package org.melanee.core.modelexplorer;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.InternalTransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jgit.errors.CorruptObjectException;
import org.eclipse.jgit.errors.IncorrectObjectTypeException;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.melanee.core.models.links.links.Link;
import org.melanee.core.models.links.links.LinkingModel;
import org.melanee.core.models.links.links.LinksFactory;
import org.melanee.core.models.links.links.LinksPackage;
import org.melanee.core.models.links.links.RemoteModel;
import org.melanee.core.models.plm.PLM.Clabject;
import org.melanee.core.models.plm.PLM.DeepModel;
import org.melanee.core.models.plm.PLM.Domain;
import org.melanee.core.models.plm.PLM.Element;
import org.melanee.core.models.plm.PLM.Feature;
import org.melanee.core.models.plm.PLM.Inheritance;
import org.melanee.core.models.plm.PLM.Level;
import org.melanee.core.models.plm.PLM.PLMPackage;
import org.melanee.core.models.plm.PLM.ConnectionEnd;

public class ModelExplorerDialog extends TitleAreaDialog {

	private static final Image SHELL_ICON = AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "/icons/explore.gif").createImage();
	
	private Text remoteURLText;
	private ListViewer fileListViewer;
	private TreeViewer sourceOntologyTreeViewer;
	private TreeViewer targetOntologyTreeViewer;
	
	private GITHelper gitHelper = null;
	
	private Domain sourceDomain = null;
	private Diagram sourceDiagram = null;
	
	private Domain targetDomain = null;
	private Diagram targetDiagram = null;
	
	private Collection<EObject> createdElements = null;
	
	public Collection<EObject> getCreatedElements(){
		return createdElements;
	}
	
	public ModelExplorerDialog(Shell parentShell, Domain targetDomain, Diagram targetDiagram) {
		super(parentShell);
//		setShellStyle(getShellStyle() | SWT.RESIZE);
		
		this.targetDomain = targetDomain;
		this.targetDiagram = targetDiagram;
	}
	
	@Override
	protected Control createDialogArea(Composite parent) {
		setTitle("Select the remote model to link into current model.");
		
		Composite parentComposite = (Composite) super.createDialogArea(parent);
	    parentComposite.setLayout(new GridLayout(1, true));
	    parentComposite.setLayoutData(new GridData(GridData.FILL_BOTH));
	    ((GridData)parentComposite.getLayoutData()).grabExcessHorizontalSpace = true;
	    ((GridData)parentComposite.getLayoutData()).grabExcessVerticalSpace = true;
		
	    
	    //********************************************************************************************
	    // BEGIN COMPOSITE FOR THE ADDRESS URL
	    //********************************************************************************************
	    Composite remoteURLComposite = new Composite(parentComposite, SWT.NONE);
	    remoteURLComposite.setLayout(new GridLayout(3, false));
	    remoteURLComposite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    ((GridData)remoteURLComposite.getLayoutData()).grabExcessHorizontalSpace = true;
	    
	    Label remoteURLLabel = new Label(remoteURLComposite, SWT.NONE);
	    remoteURLLabel.setText("Model URL");
	    
	    remoteURLText = new Text(remoteURLComposite, SWT.BORDER);
	    remoteURLText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    ((GridData)remoteURLText.getLayoutData()).grabExcessHorizontalSpace = true;
	    
	    remoteURLText.setText("https://github.com/ralphgerbig/testGit.git");
	    
	    Button refreshButton = new Button(remoteURLComposite, SWT.PUSH);
	    refreshButton.setText("refresh");
	    
	    refreshButton.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Close the repository so that the tmp folder
				// can be deleted
				if(gitHelper != null)
					gitHelper.closeRepository();
				
				gitHelper = new GITHelper(remoteURLText.getText());
				try {
					fileListViewer.setInput(gitHelper.getFileList());
				} catch (MissingObjectException ex) {
					ex.printStackTrace();
				} catch (IncorrectObjectTypeException ex) {
					ex.printStackTrace();
				} catch (CorruptObjectException ex) {
					ex.printStackTrace();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				
			}
		});
	    //********************************************************************************************
	    // END COMPOSITE FOR THE ADDRESS URL
	    //********************************************************************************************
	    
	    
	    //********************************************************************************************
		// BEGIN COMPOSITE FOR MODEL SELECTION
		//********************************************************************************************
	    Composite modelSelectionComposite = new Composite(parentComposite, SWT.NONE);
	    modelSelectionComposite.setLayout(new GridLayout(1, true));
	    modelSelectionComposite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    ((GridData)modelSelectionComposite.getLayoutData()).grabExcessHorizontalSpace = true;
	    
	    Label selectFileToImportFromLabel = new Label(modelSelectionComposite, SWT.NONE);
	    selectFileToImportFromLabel.setText("1) Select file to import from");
	    
	    fileListViewer = new ListViewer(modelSelectionComposite);
	    fileListViewer.getControl().setLayoutData(new GridData(GridData.FILL_BOTH));
	    ((GridData)fileListViewer.getControl().getLayoutData()).grabExcessHorizontalSpace = true;
	    ((GridData)fileListViewer.getControl().getLayoutData()).grabExcessVerticalSpace = true;
	    
	    
	    fileListViewer.setContentProvider(ArrayContentProvider.getInstance());
	    fileListViewer.addFilter(new ViewerFilter() {
			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				return ((String)element).endsWith(".lml");
			}
		});;
	    fileListViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				try 
				{
					if(event.getSelection() == null 
							|| ((IStructuredSelection)event.getSelection()).getFirstElement() == null)
						return;
					
					String fileName = ((IStructuredSelection)event.getSelection()).getFirstElement().toString();
					InputStream fileStream = gitHelper.getInputStreamForFile(fileName);
					ResourceSet fileResourceSet = new ResourceSetImpl();
					Resource fileResource = fileResourceSet.createResource(URI.createURI(fileName));
					fileResource.load(fileStream, Collections.EMPTY_MAP);
					fileStream.close();
					
					sourceDiagram = (Diagram)fileResource.getContents().get(1);
					sourceDomain = (Domain)fileResource.getContents().get(0);
					sourceOntologyTreeViewer.setInput(sourceDomain);
				} catch (MissingObjectException e) {
					e.printStackTrace();
				} catch (IncorrectObjectTypeException e) {
					e.printStackTrace();
				} catch (CorruptObjectException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	    //********************************************************************************************
  		// END COMPOSITE FOR MODEL SELECTION
  		//********************************************************************************************
	    
	    //********************************************************************************************
	    // BEGIN COMPOSITE FOR DISPLAYING SELECTED MODEL
	    //********************************************************************************************
	    Composite loadedModelComposite = new Composite(parentComposite, SWT.NONE);
	    loadedModelComposite.setLayout(new GridLayout(1, true));
	    loadedModelComposite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    ((GridData)loadedModelComposite.getLayoutData()).grabExcessHorizontalSpace = true;
	    
	    Label selectModelElementsToImportLabel = new Label(loadedModelComposite, SWT.NONE);
	    selectModelElementsToImportLabel.setText("2) Select the model elements to import");
	    
	    sourceOntologyTreeViewer = new TreeViewer(loadedModelComposite);
	    sourceOntologyTreeViewer.getControl().setLayoutData(new GridData(GridData.FILL_BOTH));
	    ((GridData)sourceOntologyTreeViewer.getControl().getLayoutData()).grabExcessHorizontalSpace = true;
	    ((GridData)sourceOntologyTreeViewer.getControl().getLayoutData()).grabExcessVerticalSpace = true;
	    
	    ComposedAdapterFactory composedAdapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
	    AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(composedAdapterFactory);
	    AdapterFactoryContentProvider contentProvider = new AdapterFactoryContentProvider(composedAdapterFactory);
	    
	    sourceOntologyTreeViewer.setLabelProvider(labelProvider);
	    sourceOntologyTreeViewer.setContentProvider(contentProvider);
	    sourceOntologyTreeViewer.addFilter(new ViewerFilter() {
			
			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				return element instanceof Clabject 
						|| element instanceof Domain
						|| element instanceof DeepModel
						|| element instanceof Feature
						|| element instanceof ConnectionEnd
						|| element instanceof Inheritance
						|| element instanceof Level;
			}
		});
	    
	    sourceOntologyTreeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				if(event.getSelection() != null){
					targetOntologyTreeViewer.setInput(targetDomain);
				}
			}
		});
	    
	    //********************************************************************************************
	    // END COMPOSITE FOR DISPLAYING SELECTED MODEL
	    //********************************************************************************************
	    
	    //********************************************************************************************
	    // BEGIN COMPOSITE FOR TARGET SELECTION
	    //********************************************************************************************
	    Composite targetModelComposite = new Composite(parentComposite, SWT.NONE);
	    targetModelComposite.setLayout(new GridLayout(1, true));
	    targetModelComposite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    ((GridData)targetModelComposite.getLayoutData()).grabExcessHorizontalSpace = true;
	    
	    Label targetModelElementLabel = new Label(targetModelComposite, SWT.NONE);
	    targetModelElementLabel.setText("3) Select the target model element");
	    
	    targetOntologyTreeViewer = new TreeViewer(targetModelComposite, SWT.BORDER | SWT.SINGLE);
	    targetOntologyTreeViewer.getControl().setLayoutData(new GridData(GridData.FILL_BOTH));
	    ((GridData)targetOntologyTreeViewer.getControl().getLayoutData()).grabExcessHorizontalSpace = true;
	    ((GridData)targetOntologyTreeViewer.getControl().getLayoutData()).grabExcessVerticalSpace = true;
	    
	    targetOntologyTreeViewer.setLabelProvider(labelProvider);
	    targetOntologyTreeViewer.setContentProvider(contentProvider);
	    targetOntologyTreeViewer.addFilter(new ViewerFilter() {
			
			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				return element instanceof Clabject 
						|| element instanceof Domain
						|| element instanceof DeepModel
						|| element instanceof Feature
						|| element instanceof ConnectionEnd
						|| element instanceof Inheritance
						|| element instanceof Level;
			}
		});
	    //********************************************************************************************
	    // BEGIN COMPOSITE FOR TARGET SELECTION
	    //********************************************************************************************
		
	    return super.createDialogArea(parent);
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		
		newShell.setText("Model Explorer");
		newShell.setImage(SHELL_ICON);
	}
	
	@Override
	public boolean close() {
		if(gitHelper != null)
			gitHelper.closeRepository();
		
		return super.close();
	}
	
	@Override
	protected void okPressed() {
		
		List<Element> e = new ArrayList<Element>();
		Map<Element, Element> sourceToTarget = new HashMap<Element, Element>(); 
		
		//Copy the elements over
		IStructuredSelection selection = (IStructuredSelection)sourceOntologyTreeViewer.getSelection();
		
		List<EObject> sourceEObjects = new ArrayList<>();
		Iterator sourceSelectionIterator = selection.iterator();
		while(sourceSelectionIterator.hasNext()){
			sourceEObjects.add((EObject) sourceSelectionIterator.next());
		}
		
		Copier copier = new Copier();
		Collection<EObject> targetElements = copier.copyAll(sourceEObjects);
		copier.copyReferences();
		createdElements = copier.values();
		
		EObject target = (EObject)((IStructuredSelection)targetOntologyTreeViewer.getSelection()).getFirstElement();
		
		//Create the command to add target elements to the target
		copyElementsToTarget(targetElements, target, copier);
		//Copy over the layout
		copyLayout(copier);
		
		//Shows the connectionEnds etc.
		List editPolicies = CanonicalEditPolicy.getRegisteredEditPolicies(targetDomain);
		for (Iterator it = editPolicies.iterator(); it.hasNext();) {
			CanonicalEditPolicy nextEditPolicy = (CanonicalEditPolicy) it.next();
			nextEditPolicy.refresh();
		}
		
		super.okPressed();
	}

	/**
	 * Copies the layout from the old to the new model
	 * 
	 * @param source2target mapping from the source to the target model elements
	 */
	private void copyLayout(Map<EObject, EObject> source2target) {
		TreeIterator<EObject> sourceDiagramIterator = sourceDiagram.eAllContents();
		while(sourceDiagramIterator.hasNext()){
			EObject sourceNotaionElement = sourceDiagramIterator.next();
			if(sourceNotaionElement instanceof Node
					&& ((Node)sourceNotaionElement).getLayoutConstraint() != null
					&& ! (((View)sourceNotaionElement).getElement() instanceof Level)
					&& ((((View)sourceNotaionElement).getElement() instanceof Clabject) || (((View)sourceNotaionElement).getElement() instanceof Inheritance)) 
					&& source2target.get(((View)sourceNotaionElement).getElement()) != null){
				
				Node sourceView = (Node)sourceNotaionElement;
				EObject targetEObject = source2target.get(((View)sourceNotaionElement).getElement());
				
				TreeIterator<EObject> targetNotationIterator = targetDiagram.eAllContents();
				while(targetNotationIterator.hasNext()){
					EObject targetView = targetNotationIterator.next();
					
					if(targetView instanceof Node
							&& ((Node)targetView).getLayoutConstraint() != null
							&& ((View) targetView).getElement() == targetEObject){
						InternalTransactionalEditingDomain targetEditingDomain = (InternalTransactionalEditingDomain)TransactionUtil.getEditingDomain(targetView);
						try {
							targetEditingDomain.startTransaction(false, Collections.EMPTY_MAP);
							
							if (sourceView.getLayoutConstraint() instanceof Bounds
									&& ((Node)targetView).getLayoutConstraint() instanceof Bounds){
								Bounds sourceBounds = (Bounds)sourceView.getLayoutConstraint();
								Bounds targetBounds = (Bounds)((Node)targetView).getLayoutConstraint();
								
								targetBounds.setX(sourceBounds.getX());
								targetBounds.setY(sourceBounds.getY());
								targetBounds.setHeight(sourceBounds.getHeight());
								targetBounds.setWidth(sourceBounds.getWidth());
							}
							
							targetEditingDomain.getActiveTransaction().commit();
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						} catch (RollbackException e1) {
							e1.printStackTrace();
						}
					}
					
				}
			}
		}
		
		List editPolicies = CanonicalEditPolicy.getRegisteredEditPolicies(targetDomain);
		for (Iterator it = editPolicies.iterator(); it.hasNext();) {
			CanonicalEditPolicy nextEditPolicy = (CanonicalEditPolicy) it.next();
			nextEditPolicy.refresh();
		}
	}

	/**
	 * Creates the command to copy all model elements from the source
	 * to the target
	 * 
	 * @param targetElements Copied elements for the target
	 * @param target Element to add the targetElements as child to
	 * @param source2target the mapping of source and target elements
	 */
	private void copyElementsToTarget(Collection<EObject> targetElements,
			EObject target, Map<EObject, EObject> source2target) {
		
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(targetDomain);
		CompoundCommand importCommand = new CompoundCommand("Import from Remote model");
		
		for(EObject o : targetElements){
			Command setCommand;
			
			//If a selected is added only the content of the level is added
			if(o instanceof Level){
				setCommand = SetCommand.create(editingDomain, target, PLMPackage.eINSTANCE.getLevel_Content(), ((Level)o).getContent());
			}
			//If a clabject is added the clabject and its content is added
			else if (o instanceof Clabject)
				setCommand = AddCommand.create(editingDomain, target, PLMPackage.eINSTANCE.getLevel_Content(), o);
			//Ontologies cannot be import as a whole at the moment
			else
				continue;
			
			if(setCommand != null)
				importCommand.append(setCommand);
		}
		
		importCommand.append(createLinksBetweenSourceAndTargetModel(source2target, target.eResource()));
		
		editingDomain.getCommandStack().execute(importCommand);
	}
	
	/**
	 * Creates the links between the source and target model elements
	 * 
	 * @param source2target Mapping from the source to the target model elements
	 * @param targetResource The resource where the mapping is added to
	 */
	private Command createLinksBetweenSourceAndTargetModel(Map<EObject, EObject> source2target, Resource targetResource) {
		
		InternalTransactionalEditingDomain domain = (InternalTransactionalEditingDomain)TransactionUtil.getEditingDomain(targetDomain);
		CompoundCommand result = new CompoundCommand("Create Links");
		
		LinkingModel linkingModel = null;
		
		//Search for an already existing linking model
		for (EObject eObject : targetResource.getContents())
			if(eObject instanceof LinkingModel)
				linkingModel = (LinkingModel)eObject;
		
		if(linkingModel == null){
			linkingModel = LinksFactory.eINSTANCE.createLinkingModel();
			
			//The root model needs to be added to the resource
			try {
				domain.startTransaction(false, Collections.EMPTY_MAP);
				targetResource.getContents().add(linkingModel);
				domain.getActiveTransaction().commit();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (RollbackException e) {
				e.printStackTrace();
			}
		}
		
		RemoteModel remoteModel = null;
		
		//Search for an already existing remote model link
		for(RemoteModel model : linkingModel.getRemoteModels())
			if(model.getPath().equals(((IStructuredSelection)fileListViewer.getSelection()).getFirstElement().toString())
					&&  model.getURL().equals(remoteURLText.getText()))
				remoteModel = model;
		
		if(remoteModel == null){
			remoteModel = LinksFactory.eINSTANCE.createRemoteModel();
			remoteModel.setURL(remoteURLText.getText());
			remoteModel.setPath(((IStructuredSelection)fileListViewer.getSelection()).getFirstElement().toString());
			Command addRemoteModelCommand = new AddCommand(domain, linkingModel, LinksPackage.eINSTANCE.getLinkingModel_RemoteModels(), remoteModel);
			result.append(addRemoteModelCommand);
		}
		
		List<Link> linksToAdd = new ArrayList<Link>();
		Iterator<EObject> sourceIterator =  source2target.keySet().iterator();
		while(sourceIterator.hasNext()){
			EObject source = sourceIterator.next();
			
			//Only Clabjects and inheritances are of interest
			if(! (source instanceof Clabject
					|| source instanceof Inheritance))
				continue;
			
			Link l = LinksFactory.eINSTANCE.createLink();
			l.setSource(EMFCoreUtil.getProxyID(source));
			l.setTarget((Element)source2target.get(source));
			linksToAdd.add(l);
		}
		
		Command addLinksCommand = AddCommand.create(domain, remoteModel, LinksPackage.eINSTANCE.getRemoteModel_Links(), linksToAdd);
		result.append(addLinksCommand);
		
		return result;
	}
}
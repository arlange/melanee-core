/*
* *******************************************************************************
* Copyright (c) 2011 - 2015 University of Mannheim: Chair for Software Engineering
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
* 
* Contributors:
*      - initial API and implementation and initial documentation
* *******************************************************************************
*/
package org.melanee.core.modeleditor.part;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.gmf.runtime.common.ui.services.marker.MarkerNavigationService;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds;
import org.eclipse.gmf.runtime.diagram.ui.actions.AlignAction;
import org.eclipse.gmf.runtime.diagram.ui.actions.ShowPropertiesViewAction;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.actions.ZoomContributionItem;
import org.eclipse.gmf.runtime.diagram.ui.internal.services.palette.PaletteToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocumentProvider;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.navigator.resources.ProjectExplorer;
import org.eclipse.ui.part.IShowInTargetList;
import org.eclipse.ui.part.ShowInContext;
import org.melanee.core.emendation.service.EmendationObserver;
import org.melanee.core.modeleditor.custom.resourcesetlisteners.ConstraintLanguageServiceResourceSetListener;
import org.melanee.core.modeleditor.editortoolbaritems.SelectComplianceModeContributionItem;
import org.melanee.core.modeleditor.editortoolbaritems.ValidateDeepModelAction;
import org.melanee.core.modeleditor.navigator.PLMNavigatorItem;
import org.melanee.core.modeleditor.providers.PLMElementTypes;
import org.melanee.core.modelexplorer.ModelExplorerAction;
import org.melanee.core.models.plm.PLM.Clabject;
import org.melanee.core.models.plm.PLM.DeepModel;
import org.melanee.core.models.plm.PLM.Domain;
import org.melanee.core.models.plm.PLM.Element;
import org.melanee.core.models.plm.PLM.Entity;
import org.melanee.core.models.plm.PLM.Level;

/**
 * @generated
 */
public class PLMDiagramEditor extends DiagramDocumentEditor implements IGotoMarker {

	/**
	* @generated
	*/
	public static final String ID = "org.melanee.core.modeleditor.part.PLMDiagramEditorID"; //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final String CONTEXT_ID = "org.melanee.core.modeleditor.ui.diagramContext"; //$NON-NLS-1$

	/**
	* @generated
	*/
	public PLMDiagramEditor() {
		super(true);
	}

	/**
	* @generated
	*/
	protected String getContextID() {
		return CONTEXT_ID;
	}

	/**
	* @generated
	*/
	protected PaletteRoot createPaletteRoot(PaletteRoot existingPaletteRoot) {
		PaletteRoot root = super.createPaletteRoot(existingPaletteRoot);
		new PLMPaletteFactory().fillPalette(root);
		return root;
	}

	/**
	* @generated
	*/
	protected PreferencesHint getPreferencesHint() {
		return PLMDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT;
	}

	/**
	* @generated
	*/
	public String getContributorId() {
		return PLMDiagramEditorPlugin.ID;
	}

	/**
	 * @generated
	 */
	@SuppressWarnings("rawtypes")
	public Object getAdapter(Class type) {
		if (type == IShowInTargetList.class) {
			return new IShowInTargetList() {
				public String[] getShowInTargetIds() {
					return new String[] { ProjectExplorer.VIEW_ID };
				}
			};
		}
		return super.getAdapter(type);
	}

	/**
	* @generated
	*/
	protected IDocumentProvider getDocumentProvider(IEditorInput input) {
		if (input instanceof IFileEditorInput || input instanceof URIEditorInput) {
			return PLMDiagramEditorPlugin.getInstance().getDocumentProvider();
		}
		return super.getDocumentProvider(input);
	}

	/**
	* @generated
	*/
	public TransactionalEditingDomain getEditingDomain() {
		IDocument document = getEditorInput() != null ? getDocumentProvider().getDocument(getEditorInput()) : null;
		if (document instanceof IDiagramDocument) {
			return ((IDiagramDocument) document).getEditingDomain();
		}
		return super.getEditingDomain();
	}

	/**
	* @generated
	*/
	protected void setDocumentProvider(IEditorInput input) {
		if (input instanceof IFileEditorInput || input instanceof URIEditorInput) {
			setDocumentProvider(PLMDiagramEditorPlugin.getInstance().getDocumentProvider());
		} else {
			super.setDocumentProvider(input);
		}
	}

	/**
	* @generated
	*/
	public void gotoMarker(IMarker marker) {
		MarkerNavigationService.getInstance().gotoMarker(this, marker);
	}

	/**
	* @generated
	*/
	public boolean isSaveAsAllowed() {
		//Prevent "Save as" because this leads to corrupted diagrams
		return false;
	}

	/**
	* @generated
	*/
	public void doSaveAs() {
		// Do nothing
	}

	/**
	* @generated
	*/
	public ShowInContext getShowInContext() {
		return new ShowInContext(getEditorInput(), getNavigatorSelection());
	}

	/**
	* @generated
	*/
	private ISelection getNavigatorSelection() {
		IDiagramDocument document = getDiagramDocument();
		if (document == null) {
			return StructuredSelection.EMPTY;
		}
		Diagram diagram = document.getDiagram();
		if (diagram == null || diagram.eResource() == null) {
			return StructuredSelection.EMPTY;
		}
		IFile file = WorkspaceSynchronizer.getFile(diagram.eResource());
		if (file != null) {
			PLMNavigatorItem item = new PLMNavigatorItem(diagram, file, false);
			return new StructuredSelection(item);
		}
		return StructuredSelection.EMPTY;
	}

	/**
	* @generated
	*/
	protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();
		DiagramEditorContextMenuProvider provider = new DiagramEditorContextMenuProvider(this,
				getDiagramGraphicalViewer());
		getDiagramGraphicalViewer().setContextMenu(provider);
		getSite().registerContextMenu(ActionIds.DIAGRAM_EDITOR_CONTEXT_MENU, provider, getDiagramGraphicalViewer());
	}

	/**
	 * @generated
	 */
	@Override
	public void doSave(IProgressMonitor progressMonitor) {
		ValidateAction.runValidation(this.getDiagram());

		super.doSave(progressMonitor);
	}

	/**
	  * This listener is responsible for invoking the palette update process
	  * @generated
	  */
	private ISelectionListener selectionListener = new ISelectionListener() {
		@Override
		public void selectionChanged(IWorkbenchPart part, ISelection selection) {
			if ( //Happens on startup
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage() != null
					&& part instanceof org.melanee.core.modeleditor.part.PLMDiagramEditor
					&& selection instanceof StructuredSelection
					&& ((IStructuredSelection) selection).getFirstElement() instanceof IGraphicalEditPart) {

				IGraphicalEditPart editPart = (IGraphicalEditPart) ((IStructuredSelection) selection).getFirstElement();
				//Level validation on selection change
				//ValidateAction.runValidation((org.eclipse.gmf.runtime.notation.View)org.eclipse.emf.ecore.util.EcoreUtil.getRootContainer(editPart.getNotationView()));

				//Debugcode
				//System.out.println("Selected : " + editPart.getClass().getName());

				if (editPart.resolveSemanticElement() instanceof Element)
					managePalette((Element) editPart.resolveSemanticElement());
			}
		}
	};

	/**
	 * @generated
	 */
	@Override
	protected void startListening() {
		super.startListening();

		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService()
				.addPostSelectionListener(selectionListener);
	}

	/**
	 * @generated
	 */
	@Override
	protected void stopListening() {
		super.stopListening();

		//Can be null if exiting Eclipse with diagram open
		if (PlatformUI.getWorkbench().getActiveWorkbenchWindow() != null)
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService()
					.removePostSelectionListener(selectionListener);
	}

	/**
	 * @generated
	 */
	public PaletteViewer getPalette() {
		return getEditDomain().getPaletteViewer();
	}

	/**
	 * @generated
	 */
	private PaletteDrawer dslElementsGroup = null;
	/**
	 * @generated
	 */

	public static String dslElementsGroupID = "dslElementsGroup";

	/**
	 * @generated
	 */
	private void managePalette(Element selectedElement) {
		//Does the DSL Elements group alread exist? => Create it
		if (dslElementsGroup == null) {
			PaletteRoot root = getEditDomain().getPaletteViewer().getPaletteRoot();

			dslElementsGroup = new PaletteDrawer("DSL Elements");
			dslElementsGroup.setId("dslElementsGroup");

			root.add(dslElementsGroup);
		}

		dslElementsGroup.getChildren().clear();

		//An deep model offers no context from which we can retrieve the DSL Elements
		if (selectedElement instanceof DeepModel) {
			dslElementsGroup.setVisible(false);
			return;
		}

		EObject container = selectedElement;

		//Find the containing model
		while (container != null && !(container instanceof Level))
			container = container.eContainer();

		//No level found..
		if (container == null) {
			dslElementsGroup.setVisible(false);
			return;
		}

		// search for the next higher level
		DeepModel d = (DeepModel) container.eContainer();

		//We are at the highest level
		if (d.getContent().indexOf(container) == 0) {
			dslElementsGroup.setVisible(false);
			return;
		} else
			dslElementsGroup.setVisible(true);

		Level higherLevel = d.getContent().get(d.getContent().indexOf(container) - 1);

		LinkedList<ToolEntry> entries = new LinkedList<ToolEntry>();
		//Fill the palette
		Iterator<EObject> contentIterator = higherLevel.eAllContents();
		while (contentIterator.hasNext()) {

			EObject eObject = contentIterator.next();
			if (!(eObject instanceof Clabject))
				continue;

			Element e = (Element) eObject;

			//For entities we simply create the entry
			if (e instanceof Entity && ((Clabject) e).getPotency() != 0 && e.getName() != null) {

				List<IElementType> types = new ArrayList<IElementType>(2);
				types.add(PLMElementTypes.Entity_3120);
				types.add(PLMElementTypes.Entity_3105);

				org.melanee.core.modeleditor.part.PLMDiagramEditor.NodeToolEntry entry = new org.melanee.core.modeleditor.part.PLMDiagramEditor.NodeToolEntry(
						e.getName(), "Creates a new " + e.getName(), types);

				entry.setId("dsl." + EMFCoreUtil.getProxyID(e) + ".CreationTool");
				entry.setSmallIcon(PLMDiagramEditorPlugin
						.findImageDescriptor("/org.melanee.core.models.gmf/icons/clabject16.gif")); //$NON-NLS-1$
				entry.setLargeIcon(PLMDiagramEditorPlugin
						.findImageDescriptor("/org.melanee.core.models.gmf/icons/clabject16.gif"));

				entries.add(entry);
			}

		}

		//Connections are instantiated via context menu.
		org.melanee.core.modeleditor.part.PLMDiagramEditor.LinkToolEntry entry = new org.melanee.core.modeleditor.part.PLMDiagramEditor.LinkToolEntry(
				"Instantiate Connection", "Instantiates / Creates a new connection.",
				Collections.singletonList(PLMElementTypes.ConnectionEnd_4036));

		//No leading "dsl." to apply dsl specific commands
		entry.setId("connection.CreationTool");
		entry.setSmallIcon(
				PLMDiagramEditorPlugin.findImageDescriptor("/org.melanee.core.models.gmf/icons/connection16.gif"));
		entry.setLargeIcon(
				PLMDiagramEditorPlugin.findImageDescriptor("/org.melanee.core.models.gmf/icons/connection16.gif"));

		entries.add(entry);

		Collections.sort(entries, new Comparator<ToolEntry>() {

			@Override
			public int compare(ToolEntry o1, ToolEntry o2) {
				//All Entities need to go to the top
				if (o1 instanceof org.melanee.core.modeleditor.part.PLMDiagramEditor.NodeToolEntry
						&& ((org.melanee.core.modeleditor.part.PLMDiagramEditor.NodeToolEntry) o1).elementTypes
								.contains(PLMElementTypes.Entity_3105)) {
					//We compare to a connection node or link entry -> We want to be first
					if (o2 instanceof org.melanee.core.modeleditor.part.PLMDiagramEditor.NodeToolEntry
							&& !((org.melanee.core.modeleditor.part.PLMDiagramEditor.NodeToolEntry) o2).elementTypes
									.contains(PLMElementTypes.Entity_3105)
							|| o2 instanceof org.melanee.core.modeleditor.part.PLMDiagramEditor.LinkToolEntry)
						return -1;
					//We are two Entities -> Sort by name
					else
						return (o1.getLabel().compareToIgnoreCase(o2.getLabel()));

				} else if (o1 instanceof org.melanee.core.modeleditor.part.PLMDiagramEditor.NodeToolEntry
						&& !((org.melanee.core.modeleditor.part.PLMDiagramEditor.NodeToolEntry) o1).elementTypes
								.contains(PLMElementTypes.Entity_3105)
						|| o1 instanceof org.melanee.core.modeleditor.part.PLMDiagramEditor.LinkToolEntry) {
					//We compare to a connection node or link entry -> We want to be first
					if (o2 instanceof org.melanee.core.modeleditor.part.PLMDiagramEditor.NodeToolEntry
							&& ((org.melanee.core.modeleditor.part.PLMDiagramEditor.NodeToolEntry) o2).elementTypes
									.contains(PLMElementTypes.Entity_3105))
						return 1;
					//We are two Connections -> Sort by name
					else {
						if ((o1.getLabel() == null || o1.getLabel().length() == 0)
								&& (o2.getLabel() == null || o2.getLabel().length() == 0))
							return 0;
						else if ((o1.getLabel() == null || o1.getLabel().length() == 0)
								&& (o2.getLabel() != null || o2.getLabel().length() != 0))
							return 1;
						else if ((o1.getLabel() != null || o1.getLabel().length() != 0)
								&& (o2.getLabel() == null || o2.getLabel().length() == 0))
							return -1;
						else
							//In order to get the entry tools sorted next to their connection tool
							//their leading <<.*>> must be removed for comparison
							return o1.getLabel().replaceAll("<<.*?>>", "")
									.compareToIgnoreCase(o2.getLabel().replaceAll("<<.*?>>", ""));
					}
				}
				return 0;
			}
		});

		dslElementsGroup.addAll(entries);

		if (dslElementsGroup.getChildren().size() == 0)
			dslElementsGroup.setVisible(false);
	}

	/**
	 * @generated
	 */
	private static class NodeToolEntry extends PaletteToolEntry {

		/**
		 * @generated
		 */
		private final List<IElementType> elementTypes;

		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description, List<IElementType> elementTypes) {
			super(null, title, null);
			super.setDescription(description);
			this.elementTypes = elementTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}

	/**
	* @generated
	*/
	private static class LinkToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List<IElementType> relationshipTypes;

		/**
		 * @generated
		 */
		private LinkToolEntry(String title, String description, List<IElementType> relationshipTypes) {
			super(title, description, null, null);
			this.relationshipTypes = relationshipTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}

	/**
	 * @generated
	 */
	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);

		EmendationObserver.getInstance().startListening(getDiagram().getElement());
		ConstraintLanguageServiceResourceSetListener.getInstance().startListening(getDiagram().getElement());
	}

	@Override
	protected void createGraphicalViewer(Composite parent) {

		//Create the composite which contains the toolbar and
		//the flyout palette
		Composite rootComposite = new Composite(parent.getParent(), SWT.NONE);
		GridLayout layout = new GridLayout(1, true);
		layout.verticalSpacing = 0;
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		rootComposite.setLayout(layout);

		//This composite contains the toolbar
		Composite toolbarParent = new Composite(rootComposite, SWT.None);
		toolbarParent.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		toolbarParent.setBackground(PlatformUI.getWorkbench().getDisplay().getSystemColor(SWT.COLOR_WHITE));
		toolbarParent.setLayout(new RowLayout());

		ToolBar toolBar = new ToolBar(toolbarParent, SWT.FLAT | SWT.WRAP | SWT.RIGHT);
		ToolBarManager toolBarManager = new ToolBarManager(toolBar);

		//These are the actions for alignment
		Action alignLeft = new AlignAction(this.getSite().getPage(), GEFActionConstants.ALIGN_LEFT,
				PositionConstants.LEFT, true);
		toolBarManager.add(alignLeft);
		Action alignCenter = new AlignAction(this.getSite().getPage(), GEFActionConstants.ALIGN_CENTER,
				PositionConstants.CENTER, true);
		toolBarManager.add(alignCenter);
		Action alignRight = new AlignAction(this.getSite().getPage(), GEFActionConstants.ALIGN_RIGHT,
				PositionConstants.RIGHT, true);
		toolBarManager.add(alignRight);

		toolBarManager.add(new Separator());

		Action alignTop = new AlignAction(this.getSite().getPage(), GEFActionConstants.ALIGN_TOP, PositionConstants.TOP,
				true);
		toolBarManager.add(alignTop);
		Action alignMiddle = new AlignAction(this.getSite().getPage(), GEFActionConstants.ALIGN_MIDDLE,
				PositionConstants.MIDDLE, true);
		toolBarManager.add(alignMiddle);
		Action alignBottom = new AlignAction(this.getSite().getPage(), GEFActionConstants.ALIGN_BOTTOM,
				PositionConstants.BOTTOM, true);
		toolBarManager.add(alignBottom);

		toolBarManager.add(new Separator());

		//Show PropertiesView Action
		Action showPropertiesView = new ShowPropertiesViewAction(this);
		toolBarManager.add(showPropertiesView);

		toolBarManager.add(new Separator());

		//The zooming action
		ContributionItem zoom = new ZoomContributionItem(this.getSite().getPage());
		toolBarManager.add(zoom);

		//Model exploring and linking
		toolBarManager.add(new Separator());
		Action modelExplorer = new ModelExplorerAction();
		toolBarManager.add(modelExplorer);

		//Compatibility Mode
		toolBarManager.add(new Separator());
		ContributionItem selectCompatibilityMode = new SelectComplianceModeContributionItem(this.getSite().getPage(),
				(Domain) getDiagram().getElement());
		toolBarManager.add(selectCompatibilityMode);

		//Model exploring and linking
		Action validateModel = new ValidateDeepModelAction((Domain) getDiagram().getElement());
		toolBarManager.add(validateModel);

		toolBarManager.update(true);

		//This is a seperator between editor and toolbar
		Label separator = new Label(rootComposite, SWT.SEPARATOR | SWT.HORIZONTAL);
		separator.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		//This is the composite which contains the actual editors
		parent.setParent(rootComposite);
		GridData gd3 = new GridData(GridData.FILL_BOTH);
		gd3.grabExcessVerticalSpace = true;
		parent.setLayoutData(gd3);

		super.createGraphicalViewer(parent);
	}

}

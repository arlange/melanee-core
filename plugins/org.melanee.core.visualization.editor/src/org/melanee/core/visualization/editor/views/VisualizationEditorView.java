/*******************************************************************************
 * Copyright (c) 2011 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Ralph Gerbig - initial API and implementation and initial documentation
 *******************************************************************************/
package org.melanee.core.visualization.editor.views;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.action.CopyAction;
import org.eclipse.emf.edit.ui.action.CreateChildAction;
import org.eclipse.emf.edit.ui.action.CreateSiblingAction;
import org.eclipse.emf.edit.ui.action.CutAction;
import org.eclipse.emf.edit.ui.action.DeleteAction;
import org.eclipse.emf.edit.ui.action.EditingDomainActionBarContributor;
import org.eclipse.emf.edit.ui.action.PasteAction;
import org.eclipse.emf.edit.ui.action.RedoAction;
import org.eclipse.emf.edit.ui.action.UndoAction;
import org.eclipse.emf.edit.ui.dnd.EditingDomainViewerDropAdapter;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.edit.ui.dnd.ViewerDragAdapter;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.edit.ui.view.ExtendedPropertySheetPage;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IContributionManager;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.SubContributionItem;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.INullSelectionListener;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.views.properties.IPropertySheetEntry;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheetSorter;
import org.melanee.core.modeleditor.part.PLMDiagramEditor;
import org.melanee.core.models.plm.PLM.Element;
import org.melanee.core.models.plm.PLM.LMLVisualizer;
import org.melanee.core.models.plm.PLM.PLMPackage;
import org.melanee.core.models.plm.PLM.presentation.PLMEditorPlugin;
import org.melanee.core.models.plm.PLM.provider.PLMItemProviderAdapterFactory;
import org.melanee.core.workbench.ExtensionPointService;
import org.melanee.core.workbench.interfaces.IVisualizationServiceBase;

/**
 * Contains code from the EMF generated editor plug-in
 * 
 * BUG: getPropertySheetPage() does use the domain of the first opened diagram.
 * Maybe here an own EditingDomain is needed so that the View is not polluting
 * the domains of diagrams if more than one is opened.
 *
 */
public class VisualizationEditorView extends ViewPart
    implements INullSelectionListener, ISelectionProvider {

  /**
   * The ID of the view as specified by the extension.
   */
  public static final String ID = "org.melanee.core.visualization.editor.views.VisualizationEditorView";

  // A list of all active visualization services
  List<IVisualizationServiceBase> activeVisualizationServices = new ArrayList<IVisualizationServiceBase>();

  TreeViewer viewer;
  EContentAdapter adapter;
  // Used by the menuBuilder SelectionChangedListener
  MenuManager createChildMenuManager = new MenuManager(
      PLMEditorPlugin.INSTANCE.getString("_UI_CreateChild_menu_item"));
  MenuManager createSiblingMenuManager = new MenuManager(
      PLMEditorPlugin.INSTANCE.getString("_UI_CreateSibling_menu_item"));
  Collection<IAction> createSiblingActions;
  Collection<IAction> createChildActions;
  ComposedAdapterFactory factory;
  EObject model = null;
  ChangeListener modelListener = new ChangeListener();

  public void addPropertyListener(org.eclipse.ui.IPropertyListener listener) {
  };

  PropertySheetPage propertySheetPage;
  EditingDomain domain = null;

  /**
   * This is need to return a property sheet page. If not implemented the property
   * sheet does not get updated correctly in some cases.
   * 
   * This is how the framework determines which interfaces we implement. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("rawtypes")
  @Override
  public Object getAdapter(Class key) {
    if (key.equals(IPropertySheetPage.class)) {
      return getPropertySheetPage();
    } else if (key.equals(IGotoMarker.class)) {
      return this;
    } else {
      return super.getAdapter(key);
    }
  }

  public IPropertySheetPage getPropertySheetPage() {
    if (propertySheetPage == null) {

      // An other editor than the PLM Model Editor is active
      if (getSite().getWorkbenchWindow().getActivePage().getActiveEditor() == null || !(getSite()
          .getWorkbenchWindow().getActivePage().getActiveEditor() instanceof PLMDiagramEditor))
        if (!getSelection().isEmpty())
          domain = TransactionUtil.getEditingDomain(
              (EObject) ((IStructuredSelection) getSelection()).getFirstElement());
        else if (viewer.getTree().getItemCount() > 0)
          domain = TransactionUtil
              .getEditingDomain((EObject) viewer.getTree().getItem(0).getData());
        else
          return null;
      // The domain is null so we need to get on by the active editor
      else if (domain == null)
        domain = ((PLMDiagramEditor) getSite().getWorkbenchWindow().getActivePage()
            .getActiveEditor()).getEditingDomain();
      else
        return null;

      // viewer.getSelection();

      propertySheetPage = new MyExtendedPropertySheetPage((AdapterFactoryEditingDomain) domain);
      propertySheetPage.setPropertySourceProvider(new AdapterFactoryContentProvider(factory));
    }

    return propertySheetPage;
  }

  /**
   * This class is needed to prevent sorting of RGB color Attributes. Everything
   * else is sorted using the default behaviour.
   */
  private class MyExtendedPropertySheetPage extends ExtendedPropertySheetPage {

    public MyExtendedPropertySheetPage(AdapterFactoryEditingDomain domain) {
      super(domain);

      setSorter(new PropertySheetSorter());
    }

    @Override
    public void setSelectionToViewer(List<?> selection) {
      this.setSelectionToViewer(selection);
      this.setFocus();
    }

    @Override
    public void setActionBars(IActionBars actionBars) {
      super.setActionBars(actionBars);
      // getActionBarContributor().shareGlobalActions(this, actionBars);
    }

    /**
     * This is used to not sort RGB color properties alphabetically
     */
    @Override
    protected void setSorter(PropertySheetSorter sorter) {
      sorter = new PropertySheetSorter() {
        @Override
        public void sort(IPropertySheetEntry[] entries) {
          boolean isRGB = true;

          for (IPropertySheetEntry entry : entries) {
            isRGB = entry.getDisplayName().equals("R") || entry.getDisplayName().equals("G")
                || entry.getDisplayName().equals("B");
          }

          // For RGB Colors nothing is done
          if (isRGB)
            return;

          // Everything else gets sorted alpabetically
          super.sort(entries);
        }
      };
      super.setSorter(sorter);
    }
  }

  public EditingDomainActionBarContributor getActionBarContributor() {
    return null; // (EditingDomainActionBarContributor)getEditorSite().getActionBarContributor();
  }

  /**
   * @throws CoreException
   * 
   */
  public VisualizationEditorView() throws CoreException {

    // Add all visualization services which will be used for building up models
    if (ExtensionPointService.Instance().getActiveGraphicalVisualizationService() != null)
      activeVisualizationServices
          .add(ExtensionPointService.Instance().getActiveGraphicalVisualizationService());
    if (ExtensionPointService.Instance().getActiveTextualVisualizationService() != null)
      activeVisualizationServices
          .add(ExtensionPointService.Instance().getActiveTextualVisualizationService());
    if (ExtensionPointService.Instance().getActiveFormVisualizationService() != null)
      activeVisualizationServices
          .add(ExtensionPointService.Instance().getActiveFormVisualizationService());
    if (ExtensionPointService.Instance().getActiveValidationService() != null)
      activeVisualizationServices
          .add(ExtensionPointService.Instance().getActiveValidationService());
    if (ExtensionPointService.Instance().getActiveApplicationVisualizationService() != null)
      activeVisualizationServices
          .add(ExtensionPointService.Instance().getActiveApplicationVisualizationService());
    if (ExtensionPointService.Instance().getActiveTableVisualizationService() != null)
      activeVisualizationServices
          .add(ExtensionPointService.Instance().getActiveTableVisualizationService());
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.
   * Composite)
   */
  @Override
  public void createPartControl(Composite parent) {
    viewer = new TreeViewer(parent);

    // Allow only visualizers to be displayed
    viewer.addFilter(new ViewerFilter() {

      @Override
      public boolean select(Viewer viewer, Object parentElement, Object element) {
        for (IVisualizationServiceBase visualizationService : activeVisualizationServices)
          if (visualizationService.isVisibleInVisualizerEditorView((EObject) element))
            return true;
        return false;

        // return
        // Graphical Level
        // (element instanceof GraphicalDSLVisualizer) || (element instanceof
        // LMLVisualizer)
        // || (element instanceof VisualizationDescriptor) || (element instanceof Point)
        // || (element instanceof LayoutInformationDescriptor) || (element instanceof
        // FontDescriptor)
        // || (element instanceof LinkDecoration) || (element instanceof
        // SpacingDescriptor)
        // Textual Level
        // || (element instanceof TextualDSLVisualizer) || (element instanceof
        // TextualVisualizationDescriptor)
        // || (element instanceof AbstractColor)
        // ;
      }
    });

    factory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

    // factory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
    // factory.addAdapterFactory(new PLMItemProviderAdapterFactory());
    // factory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

    // Add the visualization service adapter factories
    // for (IVisualizationServiceBase visualizationService :
    // activeVisualizationServices)
    // factory.addAdapterFactory(visualizationService.getItemProviderAdapterFactory());

    viewer.setContentProvider(new AdapterFactoryContentProvider(factory));
    viewer.setLabelProvider(new AdapterFactoryLabelProvider(factory));
    viewer.addSelectionChangedListener(menuBuilder);

    // *************************************************************************************
    // BEGIN Register the context menu
    // *************************************************************************************
    MenuManager menu = new MenuManager();
    menu.setRemoveAllWhenShown(true);
    menu.addMenuListener(new IMenuListener() {

      @Override
      public void menuAboutToShow(IMenuManager manager) {

        manager.add(new Separator("additions"));
        manager.insertBefore("additions", createChildMenuManager);
        manager.insertBefore("additions", createSiblingMenuManager);

        EditingDomain domain = ((PLMDiagramEditor) getSite().getWorkbenchWindow().getActivePage()
            .getActiveEditor()).getEditingDomain();

        ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();

        DeleteAction deleteAction = new DeleteAction(domain);
        deleteAction.selectionChanged((IStructuredSelection) viewer.getSelection());
        deleteAction
            .setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
        manager.add(deleteAction);

        CutAction cutAction = new CutAction(domain);
        cutAction.selectionChanged((IStructuredSelection) viewer.getSelection());
        cutAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_CUT));
        manager.add(cutAction);

        CopyAction copyAction = new CopyAction(domain);
        copyAction.selectionChanged((IStructuredSelection) viewer.getSelection());
        copyAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_COPY));
        manager.add(copyAction);

        PasteAction pasteAction = new PasteAction(domain);
        pasteAction.selectionChanged((IStructuredSelection) viewer.getSelection());
        pasteAction
            .setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_PASTE));
        manager.add(pasteAction);

        UndoAction undoAction = new UndoAction(domain);
        undoAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_UNDO));
        manager.add(undoAction);

        RedoAction redoAction = new RedoAction(domain);
        redoAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_REDO));
        manager.add(redoAction);
      }
    });

    Menu m = menu.createContextMenu(viewer.getTree());

    viewer.getTree().setMenu(m);
    getSite().registerContextMenu(menu, viewer);
    // *************************************************************************************
    // END Register the context menu
    // *************************************************************************************

    int dndOperations = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK;
    Transfer[] transfers = new Transfer[] { LocalTransfer.getInstance() };
    viewer.addDragSupport(dndOperations, transfers, new ViewerDragAdapter(viewer));
    viewer.addDropSupport(dndOperations, transfers,
        new EditingDomainViewerDropAdapter(domain, viewer));

    // Better use this but does not work due to bug
    // getSite().getPage().addSelectionListener(PLMDiagramEditor.ID ,this);
    getSite().getPage().addSelectionListener(this);
    getSite().setSelectionProvider(this);
    viewer.getTree().setTopItem(new TreeItem(viewer.getTree(), 0));
  }

  @Override
  public void selectionChanged(IWorkbenchPart part, ISelection selection) {

    if (!(selection instanceof IStructuredSelection))
      return;

    IStructuredSelection structeredSelection = (IStructuredSelection) selection;

    if (!(structeredSelection.getFirstElement() instanceof IGraphicalEditPart))
      return;

    IGraphicalEditPart editPart = (IGraphicalEditPart) structeredSelection.getFirstElement();

    if (!(editPart.resolveSemanticElement() instanceof Element))
      return;

    Element ele = (Element) editPart.resolveSemanticElement();
    viewer.setInput(ele);

    // We need to install/uninstall listeners to the model
    EObject newModel = EcoreUtil.getRootContainer(ele);
    if (newModel != model) {
      // No previous model
      if (model != null)
        model.eAdapters().remove(modelListener);

      model = newModel;
      model.eAdapters().add(modelListener);
    }

    viewer.expandAll();
  }

  ISelectionChangedListener menuBuilder = new ISelectionChangedListener() {
    /**
     * This implements {@link org.eclipse.jface.viewers.ISelectionChangedListener},
     * handling {@link org.eclipse.jface.viewers.SelectionChangedEvent}s by querying
     * for the children and siblings that can be added to the selected object and
     * updating the menus accordingly. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void selectionChanged(SelectionChangedEvent event) {
      // Remove any menu items for old selection.
      //
      if (createChildMenuManager != null) {
        depopulateManager(createChildMenuManager, createChildActions);
      }
      if (createSiblingMenuManager != null) {
        depopulateManager(createSiblingMenuManager, createSiblingActions);
      }

      // Query the new selection for appropriate new child/sibling descriptors
      //
      Collection<?> newChildDescriptors = null;
      Collection<?> newSiblingDescriptors = null;

      ISelection selection = event.getSelection();
      if (selection instanceof IStructuredSelection
          && ((IStructuredSelection) selection).size() == 1) {
        Object object = ((IStructuredSelection) selection).getFirstElement();

        // We set the domain according to the current selection in the view
        if (event.getSelection() instanceof IStructuredSelection
            && ((IStructuredSelection) event.getSelection()).getFirstElement() instanceof EObject) {
          domain = TransactionUtil.getEditingDomain(
              ((EObject) ((IStructuredSelection) event.getSelection()).getFirstElement()));
        } else
          domain = ((PLMDiagramEditor) getSite().getWorkbenchWindow().getActivePage()
              .getActiveEditor()).getEditingDomain();

        // If there is an adapter of the correct type...
        //
        IEditingDomainItemProvider provider = (IEditingDomainItemProvider) factory.adapt(object,
            IEditingDomainItemProvider.class);

        newChildDescriptors = provider.getNewChildDescriptors(object, domain, null);

        // ***************************************************************
        // This is a workaround to be able to add a DSLVisualizer to
        // a LMLVisualizer
        // ***************************************************************
        if (object instanceof LMLVisualizer)
          newChildDescriptors = getDomainSpecificVisualizerChildMenuEntries(object);

        // Needs to be replaced with similar code as for children
        newSiblingDescriptors = domain.getNewChildDescriptors(null, object);
      }

      // Generate actions for selection; populate and redraw the menus.
      //
      createChildActions = generateCreateChildActions(newChildDescriptors, selection);
      createSiblingActions = generateCreateSiblingActions(newSiblingDescriptors, selection);

      if (createChildMenuManager != null) {
        populateManager(createChildMenuManager, createChildActions, null);
        createChildMenuManager.update(true);
      }
      if (createSiblingMenuManager != null) {
        populateManager(createSiblingMenuManager, createSiblingActions, null);
        createSiblingMenuManager.update(true);
      }

      setSelection(selection);

      if (propertySheetPage != null)
        propertySheetPage.refresh();
    }

    /**
     * This method is used as workaround to support splitted meta-models. The
     * LMLVisualizerItemProvider does not know about the types available in
     * visualization meta-models which reference the PLM. Thus these types are added
     * manually to the childe menu with this method. This is done by searching for
     * meta-models provided through IVisualizationServiceBase in future releases.
     * 
     * @param object
     *          The owner of the newly created model element
     * @return an array with command parameters for all DSL extensions
     */
    private Collection<?> getDomainSpecificVisualizerChildMenuEntries(Object object) {

      Collection<?> newChildDescriptors;

      ArrayList<CommandParameter> commands = new ArrayList<CommandParameter>();

      for (IVisualizationServiceBase visualizationService : activeVisualizationServices) {
        CommandParameter parameter = new CommandParameter(object,
            PLMPackage.eINSTANCE.getLMLVisualizer_DslVisualizer(),
            visualizationService.createNewSpecificDSLVisualizer());
        commands.add(parameter);
      }
      newChildDescriptors = commands;

      return newChildDescriptors;
    }

    protected void depopulateManager(IContributionManager manager,
        Collection<? extends IAction> actions) {
      if (actions != null) {
        IContributionItem[] items = manager.getItems();
        for (int i = 0; i < items.length; i++) {
          // Look into SubContributionItems
          //
          IContributionItem contributionItem = items[i];
          while (contributionItem instanceof SubContributionItem) {
            contributionItem = ((SubContributionItem) contributionItem).getInnerItem();
          }

          // Delete the ActionContributionItems with matching action.
          //
          if (contributionItem instanceof ActionContributionItem) {
            IAction action = ((ActionContributionItem) contributionItem).getAction();
            if (actions.contains(action)) {
              manager.remove(contributionItem);
            }
          }
        }
      }
    }

    protected void populateManager(IContributionManager manager,
        Collection<? extends IAction> actions, String contributionID) {
      if (actions != null) {
        for (IAction action : actions) {
          if (contributionID != null) {
            manager.insertBefore(contributionID, action);
          } else {
            manager.add(action);
          }
        }
      }
    }

    protected Collection<IAction> generateCreateChildActions(Collection<?> descriptors,
        ISelection selection) {
      Collection<IAction> actions = new ArrayList<IAction>();
      if (descriptors != null) {
        for (Object descriptor : descriptors) {
          // EditingDomain domain =
          // ((PLMDiagramEditor)getSite().getWorkbenchWindow().getActivePage().getActiveEditor()).getEditingDomain();
          actions.add(new CreateChildAction(domain, selection, descriptor));
        }
      }
      return actions;
    }

    protected Collection<IAction> generateCreateSiblingActions(Collection<?> descriptors,
        ISelection selection) {
      Collection<IAction> actions = new ArrayList<IAction>();
      if (descriptors != null) {
        for (Object descriptor : descriptors) {
          // EditingDomain domain =
          // ((PLMDiagramEditor)getSite().getWorkbenchWindow().getActivePage().getActiveEditor()).getEditingDomain();
          actions.add(new CreateSiblingAction(domain, selection, descriptor));
        }
      }
      return actions;
    }
  };

  @Override
  public void setFocus() {
    // TODO Auto-generated method stub

  }

  @Override
  public void dispose() {
    // Throws exception if workbench is closing -> We do not care about this
    try {
      // Remove the listener
      getSite().getPage().removeSelectionListener(this);
      getSite().setSelectionProvider(null);
      propertySheetPage = null;
    } catch (Exception ex) {
    }

    super.dispose();
  }

  private class ChangeListener extends EContentAdapter {

    @Override
    public void notifyChanged(Notification notification) {
      super.notifyChanged(notification);

      // This is needed in case that a change to the domain model was made from
      // outside the UI thread which causes a thread access exception.
      PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {

        @Override
        public void run() {
          viewer.refresh();
          if (viewer.getTree().getSelection().length > 0)
            viewer.getTree().getSelection()[0].setExpanded(true);
          viewer.refresh();
        }
      });
    }

  }

  List<ISelectionChangedListener> listeners = new LinkedList<ISelectionChangedListener>();

  @Override
  public void addSelectionChangedListener(ISelectionChangedListener listener) {
    listeners.add(listener);
  }

  @Override
  public ISelection getSelection() {
    return viewer.getSelection();
  }

  @Override
  public void removeSelectionChangedListener(ISelectionChangedListener listener) {
    listeners.remove(listener);
  }

  ISelection viewSelection;

  @Override
  public void setSelection(ISelection selection) {

    for (ISelectionChangedListener l : listeners)
      l.selectionChanged(new SelectionChangedEvent(viewer, selection));

    viewSelection = selection;
  }
}

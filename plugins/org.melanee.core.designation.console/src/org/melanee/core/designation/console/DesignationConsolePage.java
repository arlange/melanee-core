package org.melanee.core.designation.console;

import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.team.internal.core.PluginStringMappings;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.IPageBookViewPage;
import org.eclipse.ui.part.IPageSite;
import org.melanee.core.designation.service.DesignationService;
import org.melanee.core.models.plm.PLM.Clabject;
import org.melanee.core.workbench.ExtensionPointService;

public class DesignationConsolePage implements IPageBookViewPage, ISelectionListener {

  private IPageSite site;
  private Composite rootComposite;
  private Clabject selectedClabject;

  @Override
  public void setFocus() {

  }

  @Override
  public void setActionBars(IActionBars actionBars) {

  }

  @Override
  public Control getControl() {
    return rootComposite;
  }

  @Override
  public void dispose() {

  }

  @Override
  public void createControl(Composite parent) {
    getSite().getWorkbenchWindow().getSelectionService().addSelectionListener(this);

    rootComposite = new SashForm(parent, SWT.VERTICAL);

    final Text result = new Text(rootComposite, SWT.BORDER);
    result.setEditable(false);
    final Text command = new Text(rootComposite, SWT.BORDER);
    command.addTraverseListener(new TraverseListener() {

      @Override
      public void keyTraversed(TraverseEvent e) {
        if (e.detail == SWT.TRAVERSE_RETURN)
          if (selectedClabject == null)
            result.setText("Please Select a context.");
          else {
            try {
              result.setText(ExtensionPointService.Instance().getActiveDesignationService()
                  .evaluate(selectedClabject, command.getText()));
            } catch (Exception ex) {
              result.setText(ex.getMessage());
              ex.printStackTrace();
            }
          }
      }
    });

  }

  @Override
  public void init(IPageSite site) throws PartInitException {
    this.site = site;
  }

  @Override
  public IPageSite getSite() {
    return site;
  }

  @Override
  public void selectionChanged(IWorkbenchPart part, ISelection selection) {
    if (selection instanceof IStructuredSelection
        && ((IStructuredSelection) selection).getFirstElement() instanceof IGraphicalEditPart) {
      IGraphicalEditPart editPart = (IGraphicalEditPart) ((IStructuredSelection) selection)
          .getFirstElement();
      if (editPart.resolveSemanticElement() instanceof Clabject)
        selectedClabject = (Clabject) editPart.resolveSemanticElement();
      else
        selectedClabject = null;
    }
  }
}

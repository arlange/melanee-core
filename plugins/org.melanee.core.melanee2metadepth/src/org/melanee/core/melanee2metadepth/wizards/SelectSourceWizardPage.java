package org.melanee.core.melanee2metadepth.wizards;

import java.util.Iterator;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

public class SelectSourceWizardPage extends WizardPage {

  private IStructuredSelection selection;
  private TreeViewer viewer;

  protected SelectSourceWizardPage(String pageName, IStructuredSelection selection) {
    super(pageName);

    this.selection = selection;

    setTitle("Select model to export");
  }

  @SuppressWarnings("restriction")
  @Override
  public void createControl(Composite parent) {
    Composite c = new Composite(parent, SWT.NONE);

    c.setLayout(new GridLayout(2, false));

    viewer = new TreeViewer(new Tree(c, SWT.BORDER | SWT.SINGLE));
    viewer.setContentProvider(new WorkbenchContentProvider());
    viewer.setLabelProvider(new WorkbenchLabelProvider());
    viewer.setInput(ResourcesPlugin.getWorkspace().getRoot());

    viewer.setSelection(selection);

    viewer.addSelectionChangedListener(new ISelectionChangedListener() {

      @Override
      public void selectionChanged(SelectionChangedEvent event) {
        selection = (IStructuredSelection) viewer.getSelection();
        getContainer().updateButtons();
      }
    });

    GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
    viewer.getTree().setLayoutData(data);

    setControl(c);
  }

  public String getSelection() {
    return selection.getFirstElement().toString().substring(1);
  }

  @Override
  public boolean isPageComplete() {
    return selection.getFirstElement() != null
        && (selection.getFirstElement().toString().endsWith(".lml")
            || selection.getFirstElement().toString().endsWith(".plm"));
  }

}

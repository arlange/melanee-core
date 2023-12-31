/*
 * *******************************************************************************
 * Copyright (c) 2011 - 2015 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Ralph Gerbig - initial API and implementation and initial documentation
 * *******************************************************************************
 */
package org.melanee.core.modeleditor.part;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

/**
 * @generated
 */
public class PLMCreationWizard extends Wizard implements INewWizard {

  /**
   * @generated
   */
  private IWorkbench workbench;

  /**
   * @generated
   */
  protected IStructuredSelection selection;

  /**
   * @generated
   */
  protected PLMCreationWizardPage diagramModelFilePage;

  /**
   * @generated
   */
  protected Resource diagram;

  /**
   * @generated
   */
  private boolean openNewlyCreatedDiagramEditor = true;

  /**
   * @generated
   */
  public IWorkbench getWorkbench() {
    return workbench;
  }

  /**
   * @generated
   */
  public IStructuredSelection getSelection() {
    return selection;
  }

  /**
   * @generated
   */
  public final Resource getDiagram() {
    return diagram;
  }

  /**
   * @generated
   */
  public final boolean isOpenNewlyCreatedDiagramEditor() {
    return openNewlyCreatedDiagramEditor;
  }

  /**
   * @generated
   */
  public void setOpenNewlyCreatedDiagramEditor(boolean openNewlyCreatedDiagramEditor) {
    this.openNewlyCreatedDiagramEditor = openNewlyCreatedDiagramEditor;
  }

  /**
   * @generated
   */
  public void init(IWorkbench workbench, IStructuredSelection selection) {
    this.workbench = workbench;
    this.selection = selection;
    setWindowTitle(Messages.PLMCreationWizardTitle);
    setDefaultPageImageDescriptor(
        PLMDiagramEditorPlugin.getBundledImageDescriptor("icons/wizban/NewPLMWizard.gif")); //$NON-NLS-1$
    setNeedsProgressMonitor(true);
  }

  /**
   * @generated
   */
  public void addPages() {
    diagramModelFilePage = new PLMCreationWizardPage("DiagramModelFile", getSelection(), "lml"); //$NON-NLS-1$ //$NON-NLS-2$
    diagramModelFilePage.setTitle(Messages.PLMCreationWizard_DiagramModelFilePageTitle);
    diagramModelFilePage.setDescription(Messages.PLMCreationWizard_DiagramModelFilePageDescription);
    addPage(diagramModelFilePage);
  }

  /**
   * @generated
   */
  public boolean performFinish() {
    IRunnableWithProgress op = new WorkspaceModifyOperation(null) {

      protected void execute(IProgressMonitor monitor) throws CoreException, InterruptedException {
        diagram = PLMDiagramEditorUtil.createDiagram(diagramModelFilePage.getURI(), monitor);
        if (isOpenNewlyCreatedDiagramEditor() && diagram != null) {
          try {
            PLMDiagramEditorUtil.openDiagram(diagram);
          } catch (PartInitException e) {
            ErrorDialog.openError(getContainer().getShell(),
                Messages.PLMCreationWizardOpenEditorError, null, e.getStatus());
          }
        }
      }
    };
    try {
      getContainer().run(false, true, op);
    } catch (InterruptedException e) {
      return false;
    } catch (InvocationTargetException e) {
      if (e.getTargetException() instanceof CoreException) {
        ErrorDialog.openError(getContainer().getShell(), Messages.PLMCreationWizardCreationError,
            null, ((CoreException) e.getTargetException()).getStatus());
      } else {
        PLMDiagramEditorPlugin.getInstance().logError("Error creating diagram", //$NON-NLS-1$
            e.getTargetException());
      }
      return false;
    }
    return diagram != null;
  }
}

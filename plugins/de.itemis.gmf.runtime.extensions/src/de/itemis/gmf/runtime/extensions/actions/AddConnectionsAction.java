/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.itemis.gmf.runtime.extensions.actions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import de.itemis.gmf.runtime.edit.policy.SemiCanonicalDiagramEditPolicy;
import de.itemis.gmf.runtime.extensions.Activator;

public class AddConnectionsAction implements IObjectActionDelegate {

	private ArrayList<IGraphicalEditPart> selectedEditParts;

	/**
	 * Constructor for Action1.
	 */
	public AddConnectionsAction() {
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		// TODO: node edit part
		final Set<EObject> selectedSemanticElements = new HashSet<EObject>();
		Set<DiagramEditPart> selectedDiagramEditParts = new HashSet<DiagramEditPart>();
		for (IGraphicalEditPart selectedEditPart : selectedEditParts) {
			Object view = selectedEditPart.getModel();
			if (view instanceof Node) {
				selectedSemanticElements.add(selectedEditPart
						.resolveSemanticElement());
				DiagramEditPart diagramEditPart = getDiagramEditPart(selectedEditPart);
				selectedDiagramEditParts.add(diagramEditPart);
			}
		}
		for (DiagramEditPart diagramEditPart : selectedDiagramEditParts) {
			final SemiCanonicalDiagramEditPolicy semiCanonicalEditPolicy = (SemiCanonicalDiagramEditPolicy) diagramEditPart
					.getEditPolicy(SemiCanonicalDiagramEditPolicy.SEMI_CANONICAL_ROLE);
			ArrayList<IFile> affectedFiles = new ArrayList<IFile>();
			Resource resource = ((View) diagramEditPart.getModel()).eResource();
			affectedFiles.add(WorkspaceSynchronizer.getFile(resource));
			AbstractTransactionalCommand command = new AbstractTransactionalCommand(
					TransactionUtil
							.getEditingDomain(diagramEditPart.getModel()),
					"Add Connections", affectedFiles) {

				@Override
				protected CommandResult doExecuteWithResult(
						IProgressMonitor monitor, IAdaptable info)
						throws ExecutionException {
					semiCanonicalEditPolicy
							.addConnections(selectedSemanticElements);
					return CommandResult.newOKCommandResult();
				}
			};
			try {
				OperationHistoryFactory.getOperationHistory().execute(command,
						new NullProgressMonitor(), null);
			} catch (ExecutionException e) {
				Activator
						.logError("error executing Add Connections command", e);
			}
			TransactionUtil.getEditingDomain(diagramEditPart.getModel())
					.getCommandStack().execute(null);
		}
	}

	private DiagramEditPart getDiagramEditPart(EditPart editPart) {
		if (editPart instanceof DiagramEditPart) {
			return (DiagramEditPart) editPart;
		}
		EditPart parent = editPart.getParent();
		if (parent != null) {
			return getDiagramEditPart(parent);
		}
		return null;
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		action.setEnabled(false);
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
            selectedEditParts = new ArrayList<IGraphicalEditPart>();
			for (Iterator<?> i = structuredSelection.iterator(); i.hasNext();) {
				Object selectedElement = i.next();
				if (selectedElement instanceof IGraphicalEditPart) {
					IGraphicalEditPart graphicalEditPart = (IGraphicalEditPart) selectedElement;
					selectedEditParts.add(graphicalEditPart);
					action.setEnabled(true);
				}
			}
		}
	}

}

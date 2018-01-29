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
package org.melanee.core.modeleditor.custom.menucontributions;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.CompoundContributionItem;
import org.melanee.core.modeleditor.part.PLMDiagramEditor;
import org.melanee.core.workbench.ExtensionPointService;
import org.melanee.core.workbench.interfaces.IReasoningService;

/**
 * @author Ralph
 *
 */
public class ReasoningContributionItem extends CompoundContributionItem {

	/* (non-Javadoc)
	 * @see org.eclipse.ui.actions.CompoundContributionItem#getContributionItems()
	 */
	@Override
	protected IContributionItem[] getContributionItems() {
		IReasoningService reasoner = null;
		
		try {
			reasoner = ExtensionPointService.Instance().getActiveReasoningService();
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
		//No refactoring service found -> return no refactoring options
		if (reasoner == null)
			return new IContributionItem[0];
		
		IEditorPart editPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		
		//Check if PLM diagram editor is opened
		if (! (editPart instanceof PLMDiagramEditor))
			return new IContributionItem[0];
		
		//Check if we have a IStructeredSeclection
		if (! (((PLMDiagramEditor)editPart).getSite().getSelectionProvider().getSelection() instanceof IStructuredSelection))
			return new IContributionItem[0];
		
		IStructuredSelection selection = (IStructuredSelection)((PLMDiagramEditor)editPart).getSite().getSelectionProvider().getSelection();
		
		//Check if exactly one element is selected and the first one is a IGraphicalEditPart
		if (selection.size() != 1 && !(selection.getFirstElement() instanceof IGraphicalEditPart))
			return new IContributionItem[0];
		
		Object[] parts = selection.toArray();
		EObject[] modelElements = new EObject[parts.length];
		
		for (int i = 0; i < parts.length; i++)
			if (parts[i] instanceof IGraphicalEditPart)
				modelElements[i] = ((IGraphicalEditPart)parts[i]).resolveSemanticElement();
		
		return reasoner.getAvailableReasoningCommands(modelElements).toArray(new IContributionItem[] {});
	}

}

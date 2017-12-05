/*******************************************************************************
 * Copyright (c) 2012 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Daniel Gritzner - initial API and implementation and initial documentation
 *******************************************************************************/
package org.melanee.core.modeleditor.custom.resizableswimlanes.editpolicies;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConstrainedToolbarLayoutEditPolicy;
import org.melanee.core.modeleditor.custom.resizableswimlanes.layoutmanagers.SwimlaneDeepModelLayoutManager;
import org.melanee.core.modeleditor.custom.resizableswimlanes.layoutmanagers.SwimlaneDiagramLayoutManager;
import org.melanee.core.modeleditor.edit.policies.PLMTextSelectionEditPolicy;

/**
 * EditPolicy for implementing resizable swimlanes. Installs the proper layout managers and
 * also enforces a minimum width during when resizing to prevent scrollbars.
 * 
 * @author gritzner
 */
public class SwimlaneDeepModelLayoutEditPolicy extends
		ConstrainedToolbarLayoutEditPolicy {
	
	// GENERATED CODE - BEGIN
	protected EditPolicy createChildEditPolicy(EditPart child) {
		if (child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE) == null) {
			if (child instanceof ITextAwareEditPart) {
				return new PLMTextSelectionEditPolicy();
			}
		}
		return super.createChildEditPolicy(child);
	}
	// GENERATED CODE - END
	
	/**
	 * wrapper for SwimlaneDeepModelLayoutManager.getLevelCompartment(getHost())
	 * 
	 * @return
	 */
	private IGraphicalEditPart getLevelCompartment() {
		return SwimlaneDeepModelLayoutManager.getLevelCompartment((IGraphicalEditPart)getHost());
	}
	
	/**
	 * Returns a Command which makes the changes requested by 'request'.
	 * 
	 * Enforces a minimum of the resulting width of the DeepModel to prevent scrollbars.
	 * 
	 * @param request the Request for which a Command is created and returned
	 * @return the Command
	 */
	@Override
	public Command getCommand(Request request) {
		if(request instanceof ChangeBoundsRequest) {
			// DeepModel resize request
			ChangeBoundsRequest cbRequest = (ChangeBoundsRequest)request;
			Dimension sizeDelta = cbRequest.getSizeDelta().getCopy();

			// determine and enforce the minimal value for the width change which is still acceptable (-> no scrollbars)
			IGraphicalEditPart levelCompartment = getLevelCompartment();
			for(Object child : levelCompartment.getChildren()) {
				IGraphicalEditPart level = (IGraphicalEditPart)child;
				sizeDelta.width = Math.max(sizeDelta.width, SwimlaneDeepModelLayoutManager.getMinimumLevelWidthDelta(level));
			}

			// set new delta and return
			cbRequest.setSizeDelta(sizeDelta);
			return super.getCommand(cbRequest);
		}
		
		return super.getCommand(request);
	}
		
	/**
	 * adds the layout managers to the diagram and the DeepModel in addition to executing the default
	 * implementation
	 */
	@Override
	public void setHost(EditPart host) {
		super.setHost(host);
		
		// set layout managers
		EditPart parent = host.getParent();
		((IGraphicalEditPart)parent).getFigure().setLayoutManager(new SwimlaneDiagramLayoutManager(parent, host));
		((IGraphicalEditPart)host).getFigure().setLayoutManager(new SwimlaneDeepModelLayoutManager(host));
	}	
}
 
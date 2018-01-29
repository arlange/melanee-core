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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.melanee.core.modeleditor.custom.resizableswimlanes.layoutmanagers.SwimlaneDeepModelLayoutManager;
import org.melanee.core.modeleditor.edit.parts.DeepModelDeepModelLevelCompartmentEditPart;
import org.melanee.core.modeleditor.providers.PLMElementTypes;

/**
 * EditPolicy which forwards Level creation request to the LevelCompartment to allow
 * creating new Levels by clicking on exiting ones
 * 
 * @author gritzner
 */
public class SwimlaneLevelLayoutEditPolicy extends LayoutEditPolicy {

	// Generated Code from LevelEditPart --- BEGIN ---
	@Override
	protected EditPolicy createChildEditPolicy(EditPart child) {
		EditPolicy result = child
				.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
		if (result == null) {
			result = new NonResizableEditPolicy();
		}
		return result;
	}

	@Override
	protected Command getCreateCommand(CreateRequest request) {
		return null;
	}

	@Override
	protected Command getMoveChildrenCommand(Request request) {
		return null;
	}
	// Generated Code from LevelEditPart --- END ---

//	/**
//	 * forwards Level creation requests to the LevelCompartment in addition to the default implementation
//	 */
//	@Override
//	public Command getCommand(Request request) {
//		((IGraphicalEditPart)getHost()).getFigure().invalidateTree(); // ensure that the LevelDomainElementsCompartment's figure has properly set bounds
//		Command cmd = super.getCommand(request);
//		
//		if(cmd == null && request instanceof CreateUnspecifiedTypeRequest) {
//			CreateUnspecifiedTypeRequest cutRequest = (CreateUnspecifiedTypeRequest)request;
//			
//			if(cutRequest.getElementTypes().contains(PLMElementTypes.Entity_3105)) {
//				EditPart levelDomainElementsCompartment = SwimlaneDeepModelLayoutManager.getLevelDomainElementsCompartment((IGraphicalEditPart)getHost());
//				cmd = levelDomainElementsCompartment.getCommand(cutRequest);
//			}
//
//			if(cutRequest.getElementTypes().contains(PLMElementTypes.Level_3097)) {
//				// Level creation request detected, build new request to prevent an exception
//				List<IElementType> types = new ArrayList<IElementType>();
//				types.add(PLMElementTypes.Level_3097);				
//				PreferencesHint prefHint = ((IGraphicalEditPart)getHost()).getDiagramPreferencesHint();
//				CreateUnspecifiedTypeRequest createLevelRequest = new CreateUnspecifiedTypeRequest(types, prefHint);
//
//				// send new request to the LevelCompartment
//				EditPart levelCompartment = getHost();
//				while(!(levelCompartment instanceof DeepModelDeepModelLevelCompartmentEditPart))
//					levelCompartment = levelCompartment.getParent();
//				cmd = levelCompartment.getCommand(createLevelRequest);				
//			}
//		}
//		
//		return cmd;
//	}
}

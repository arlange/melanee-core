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

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.melanee.core.modeleditor.edit.parts.DeepModelDeepModelLevelCompartmentEditPart;
import org.melanee.core.modeleditor.providers.PLMElementTypes;

/**
 * EditPolicy ensuring that no entity with a LevelDomainElementsCompartment can be added to
 * or moved to a location which would cause scrollbars to appear. If the new location is too
 * far to the right or too far to the bottom the DeepModel or Level is automatically resized.
 * Also forwards Level creation requests to the LevelCompartment to allow adding new Levels by
 * clicking on existing ones.
 * 
 * @author gritzner
 */
public class SwimlaneLevelDomainElementsCompartmentLayoutEditPolicy extends
		XYLayoutEditPolicy {
	
	/**
	 * in addition to the default implementation enforces a minimum location of (0,0)
	 * to prevent scrollbars 
	 */
	@Override
	protected Command getCreateCommand(CreateRequest request) {
		Point location = request.getLocation().getCopy();
		IFigure contentPane = ((IGraphicalEditPart)getHost()).getContentPane();

		// enforce minimum boundaries
		contentPane.translateToRelative(location);
		location.x = Math.max(location.x, 0);
		location.y = Math.max(location.y, 0);
		contentPane.translateToAbsolute(location);

		// set new boundaries
		request.setLocation(location);
		
		return super.getCreateCommand(request);
	}
	
	/**
	 * creates a Command to resize the DeepModel
	 * 
	 * @param deltaX the change in width
	 * @return the Command
	 */
	private Command createResizeDeepModelCommand(int deltaX) {
		EditPart deepModel = getHost().getParent().getParent().getParent();
		ChangeBoundsRequest request = new ChangeBoundsRequest();
		
		request.setType(REQ_RESIZE_CHILDREN);
		request.setEditParts(deepModel);
		request.setSizeDelta(new Dimension(deltaX, 0));
		
		EditPolicy edPol = deepModel.getParent().getEditPolicy(LAYOUT_ROLE);
		return edPol.getCommand(request);
	}

	/**
	 * creates a Command to resize the Level containing the LevelDomainElementsCompartment using this EditPolicy
	 * 
	 * @param deltaY the change in height
	 * @return the Command
	 */
	private Command createResizeLevelsCommand(int deltaY) {
		EditPart level = getHost().getParent();
		ChangeBoundsRequest request = new ChangeBoundsRequest();
		
		request.setType(REQ_RESIZE_CHILDREN);
		request.setEditParts(level);
		request.setSizeDelta(new Dimension(0, deltaY));
		
		EditPolicy edPol = level.getParent().getEditPolicy(EditPolicy.LAYOUT_ROLE);
		return edPol.getCommand(request);
	}

	/**
	 * In addition to the default implementation a minimum location of (0,0) is enforced. Also
	 * the proper DeepModel/Level resize commands are created when moving an entity too far to the
	 * right or too far to the bottom.
	 */
	@Override
	protected Command getMoveChildrenCommand(Request _request) {
		ChangeBoundsRequest request = (ChangeBoundsRequest)_request;
		IGraphicalEditPart changedEditPart = (IGraphicalEditPart)request.getEditParts().get(0);
		IFigure figure = changedEditPart.getFigure();

		Rectangle paneBounds = ((IGraphicalEditPart)getHost()).getContentPane().getBounds(); 
		Rectangle figureBounds = figure.getBounds().getCopy();
		Point moveDelta = request.getMoveDelta().getCopy();
		
		// enforce a minimum location of (0,0)
		if(figureBounds.x + moveDelta.x < 0)
			moveDelta.x = -figureBounds.x;
		if(figureBounds.y + moveDelta.y < 0)
			moveDelta.y = -figureBounds.y;
		request.setMoveDelta(moveDelta);
		
		// calculate the right/bottom bounds after executing the move command
		int editPartRightX = figureBounds.x + moveDelta.x + figureBounds.width;
		int deltaX = editPartRightX - paneBounds.width;
		
		int editPartBottomY = figureBounds.y + moveDelta.y + figureBounds.height;
		int deltaY = editPartBottomY - paneBounds.height;
		
		// create the proper DeepModel/Level resize commands if necessary
		if(deltaX > 0 || deltaY > 0) {
			org.eclipse.gef.commands.CompoundCommand compoundCommand = new CompoundCommand();
			compoundCommand.add(super.getMoveChildrenCommand(request));
			if(deltaX > 0)
				compoundCommand.add(createResizeDeepModelCommand(deltaX));
			if(deltaY > 0)
				compoundCommand.add(createResizeLevelsCommand(deltaY + 5));
			return compoundCommand;
		}
		
		return super.getMoveChildrenCommand(request);
	}
	
	/**
	 * Returns a CompoundCommand also resizing the Level and/or DeepModel if necessary after executing
	 * the resize operation according to the request.
	 */
	@Override
	protected Command getResizeChildrenCommand(ChangeBoundsRequest request) {
		IGraphicalEditPart changedEditPart = (IGraphicalEditPart)request.getEditParts().get(0);
		IFigure figure = changedEditPart.getFigure();

		Rectangle paneBounds = ((IGraphicalEditPart)getHost()).getContentPane().getBounds(); 
		Rectangle figureBounds = figure.getBounds().getCopy();
		Dimension sizeDelta = request.getSizeDelta().getCopy();
		
		// calculate the right/bottom bounds after executing the resize command
		int editPartRightX = figureBounds.x + figureBounds.width + sizeDelta.width;
		int deltaX = editPartRightX - paneBounds.width;
		
		int editPartBottomY = figureBounds.y + figureBounds.height + sizeDelta.height;
		int deltaY = editPartBottomY - paneBounds.height;
		
		// create the proper DeepModel/Level resize commands if necessary
		if(deltaX > 0 || deltaY > 0) {
			org.eclipse.gef.commands.CompoundCommand compoundCommand = new CompoundCommand();
			compoundCommand.add(super.getResizeChildrenCommand(request));
			if(deltaX > 0)
				compoundCommand.add(createResizeDeepModelCommand(deltaX));
			if(deltaY > 0)
				compoundCommand.add(createResizeLevelsCommand(deltaY + 5));
			return compoundCommand;
		}
		
		return super.getResizeChildrenCommand(request);
	}
	
	/**
	 * forwards Level creation requests to the LevelCompartment in addtion to the default implemenation.
	 */
	@Override
	public Command getCommand(Request request) {
		Command cmd = super.getCommand(request);
		
		if(cmd == null && request instanceof CreateUnspecifiedTypeRequest) {
			CreateUnspecifiedTypeRequest cutRequest = (CreateUnspecifiedTypeRequest)request;
			if(cutRequest.getElementTypes().contains(PLMElementTypes.Level_3097)) {
				// Level creation request detected, build new request to prevent an exception
				List<IElementType> types = new ArrayList<IElementType>();
				types.add(PLMElementTypes.Level_3097);				
				PreferencesHint prefHint = ((IGraphicalEditPart)getHost()).getDiagramPreferencesHint();
				CreateUnspecifiedTypeRequest createLevelRequest = new CreateUnspecifiedTypeRequest(types, prefHint);

				// send new request to the LevelCompartment
				EditPart levelCompartment = getHost();
				while(!(levelCompartment instanceof DeepModelDeepModelLevelCompartmentEditPart))
					levelCompartment = levelCompartment.getParent();
				cmd = levelCompartment.getCommand(createLevelRequest);				
			}
		}
		
		return cmd;
	}
}

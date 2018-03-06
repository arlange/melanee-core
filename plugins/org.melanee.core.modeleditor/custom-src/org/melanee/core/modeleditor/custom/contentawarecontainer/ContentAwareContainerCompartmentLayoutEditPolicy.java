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
package org.melanee.core.modeleditor.custom.contentawarecontainer;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;
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
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy;

/**
 * EditPolicy which ensures that the container is resized if an entity inside it
 * is moved or resized.
 * 
 * @author gritzner
 */
public class ContentAwareContainerCompartmentLayoutEditPolicy extends XYLayoutEditPolicy {
  // bottom margin
  private static final int HEIGHT_MARGIN = 8;

  /**
   * ensures that every new Entity is created no further to the left or to the top
   * than (0,0)
   */
  @Override
  protected Command getCreateCommand(CreateRequest request) {
    Point location = request.getLocation().getCopy();
    IFigure contentPane = ((IGraphicalEditPart) getHost()).getContentPane();

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
   * Creates a Command to resize the Entity which serves as the container
   * 
   * @param deltaX
   *          The change in width. Negative values are ignored.
   * @param deltaY
   *          The change in height. Negative values are ignored.
   * @return the Command
   */
  private Command createResizeContainerCommand(int deltaX, int deltaY) {
    deltaX = Math.max(deltaX, 0);
    deltaY = Math.max(deltaY, 0);

    EditPart entity = getHost().getParent();
    ChangeBoundsRequest request = new ChangeBoundsRequest();

    request.setType(REQ_RESIZE_CHILDREN);
    request.setEditParts(entity);
    request.setSizeDelta(new Dimension(deltaX, deltaY));

    EditPolicy edPol = entity.getParent().getEditPolicy(LAYOUT_ROLE);
    return edPol.getCommand(request);
  }

  /**
   * Checks whether the container has to be resized when fulfilling the move
   * command. Returns an appropriate CompoundCommand which also resizes the
   * container if necessary.
   */
  @Override
  protected Command getMoveChildrenCommand(Request _request) {
    ChangeBoundsRequest request = (ChangeBoundsRequest) _request;
    IGraphicalEditPart host = (IGraphicalEditPart) getHost();
    IGraphicalEditPart parent = (IGraphicalEditPart) host.getParent();
    IGraphicalEditPart changedEditPart = (IGraphicalEditPart) request.getEditParts().get(0);
    IFigure figure = changedEditPart.getFigure();

    Rectangle paneBounds = host.getContentPane().getBounds().getCopy();
    paneBounds.height = parent.getFigure().getBounds().height - host.getFigure().getBounds().y
        - HEIGHT_MARGIN;
    Rectangle figureBounds = figure.getBounds().getCopy();
    Point moveDelta = request.getMoveDelta().getCopy();

    // enforce a minimum location of (0,0)
    if (figureBounds.x + moveDelta.x < 0)
      moveDelta.x = -figureBounds.x;
    if (figureBounds.y + moveDelta.y < 0)
      moveDelta.y = -figureBounds.y;
    request.setMoveDelta(moveDelta);

    // calculate the right/bottom bounds after executing the move command
    int editPartRightX = figureBounds.x + moveDelta.x + figureBounds.width;
    int deltaX = editPartRightX - paneBounds.width;

    int editPartBottomY = figureBounds.y + moveDelta.y + figureBounds.height;
    int deltaY = editPartBottomY - paneBounds.height;

    // create the proper resize command if necessary
    if (deltaX > 0 || deltaY > 0) {
      org.eclipse.gef.commands.CompoundCommand compoundCommand = new CompoundCommand();
      compoundCommand.add(super.getMoveChildrenCommand(request));
      compoundCommand.add(createResizeContainerCommand(deltaX, deltaY));
      return compoundCommand;
    }

    return super.getMoveChildrenCommand(request);
  }

  /**
   * Checks whether the container has to be resized when fulfilling the reize
   * command. Returns an appropriate CompoundCommand which also resizes the
   * container if necessary.
   */
  @Override
  protected Command getResizeChildrenCommand(ChangeBoundsRequest request) {
    IGraphicalEditPart host = (IGraphicalEditPart) getHost();
    IGraphicalEditPart parent = (IGraphicalEditPart) host.getParent();
    IGraphicalEditPart changedEditPart = (IGraphicalEditPart) request.getEditParts().get(0);
    IFigure figure = changedEditPart.getFigure();

    Rectangle paneBounds = host.getContentPane().getBounds().getCopy();
    paneBounds.height = parent.getFigure().getBounds().height - host.getFigure().getBounds().y
        - HEIGHT_MARGIN;
    Rectangle figureBounds = figure.getBounds().getCopy();
    Dimension sizeDelta = request.getSizeDelta().getCopy();

    // calculate the right/bottom bounds after executing the resize command
    int editPartRightX = figureBounds.x + figureBounds.width + sizeDelta.width;
    int deltaX = editPartRightX - paneBounds.width;

    int editPartBottomY = figureBounds.y + figureBounds.height + sizeDelta.height;
    int deltaY = editPartBottomY - paneBounds.height;

    // create the proper resize command if necessary
    if (deltaX > 0 || deltaY > 0) {
      org.eclipse.gef.commands.CompoundCommand compoundCommand = new CompoundCommand();
      compoundCommand.add(super.getResizeChildrenCommand(request));
      compoundCommand.add(createResizeContainerCommand(deltaX, deltaY));
      return compoundCommand;
    }

    return super.getResizeChildrenCommand(request);
  }
}

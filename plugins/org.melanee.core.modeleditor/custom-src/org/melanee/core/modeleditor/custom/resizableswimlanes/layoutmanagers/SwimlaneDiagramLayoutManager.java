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

package org.melanee.core.modeleditor.custom.resizableswimlanes.layoutmanagers;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.layout.FreeFormLayoutEx;
import org.eclipse.gmf.runtime.diagram.ui.render.editparts.RenderedDiagramRootEditPart;
import org.melanee.core.modeleditor.edit.parts.DeepModelDeepModelLevelCompartmentEditPart;

/**
 * A layout manager responsible for managing the DeepModel's bounds. Both the
 * width and height are set to values which prevent scrollbars from appearing.
 * The width is also increased to at least the canvas' width.
 * 
 * Assumes that there is exactly one DeepModel within a diagram.
 * 
 * @author gritzner
 */
public class SwimlaneDiagramLayoutManager extends FreeFormLayoutEx {
  // margins used to fit the DeepModel into the diagram
  private static final int LEFT_MARGIN = 4;
  private static final int TOP_MARGIN = 4;
  private static final int RIGHT_MARGIN = 12;
  private static final int BOTTOM_MARGIN = 8;

  // margins used to fit the various EditParts' figures properly into their
  // containers
  private static final int MINIMUM_LEVEL_WIDTH_MARGIN = 12;
  private static final int MINIMUM_LEVEL_COMPARTMENT_HEIGHT = 40;
  private static final int DEEP_MODEL_HEIGHT_MARGIN = 20;

  // the diagram containing the DeepModel
  private IGraphicalEditPart diagram;

  // the contained deep model
  private IGraphicalEditPart deepModel;

  /**
   * @param diagram
   *          the containing diagram
   * @param deepModel
   *          the contained DeepModel
   */
  public SwimlaneDiagramLayoutManager(EditPart diagram, EditPart deepModel) {
    super();
    this.diagram = (IGraphicalEditPart) diagram;
    this.deepModel = (IGraphicalEditPart) deepModel;
  }

  /**
   * determines the minimum width across all Levels contained in the DeepModel
   * which prevents scrollbars from appearing in any Level
   * 
   * @return the minimum width
   */
  private int getMinimumDeepModelWidth() {
    IGraphicalEditPart levelCompartment = SwimlaneDeepModelLayoutManager
        .getLevelCompartment(deepModel);
    int minWidth = 0;

    for (Object child : levelCompartment.getChildren()) {
      IGraphicalEditPart level = (IGraphicalEditPart) child;
      minWidth = Math.max(minWidth, level.getContentPane().getPreferredSize().width);
    }

    return minWidth + MINIMUM_LEVEL_WIDTH_MARGIN;
  }

  /**
   * sets the DeepModel's bounds to appropriate values to prevent scrollbars
   * 
   * @param figure
   *          the containing diagram's figure
   */
  @Override
  public void layout(IFigure figure) {
    super.layout(figure); // invoke default implementation to ensure that all children are rendered
                          // properly

    // determine the height required so that no scrollbars are necessary yet only
    // small margins are visible
    int height = 0;
    for (Object child : deepModel.getChildren()) {
      if (child instanceof DeepModelDeepModelLevelCompartmentEditPart) {
        height += Math.max(SwimlaneDeepModelLayoutManager.getTotalLevelHeight(deepModel),
            MINIMUM_LEVEL_COMPARTMENT_HEIGHT);
      } else {
        IGraphicalEditPart editPart = (IGraphicalEditPart) child;
        height += editPart.getFigure().getBounds().height;
      }
    }
    height += DEEP_MODEL_HEIGHT_MARGIN;

    // see usage below on why this line is commented out
    // Rectangle diagramBounds = figure.getBounds().getCopy();

    // determine the canvas' bounds
    RenderedDiagramRootEditPart rdrEditPart = (RenderedDiagramRootEditPart) diagram.getRoot();
    Rectangle canvasBounds = rdrEditPart.getFigure().getBounds().getCopy();
    canvasBounds.width -= RIGHT_MARGIN;
    canvasBounds.height -= BOTTOM_MARGIN;

    // calculate the new bounds
    figure = deepModel.getFigure();
    Rectangle bounds = figure.getBounds().getCopy();
    // are the two lines below left-overs from when deep models were resizable in
    // all directions? they cause problems when zooming out now
    // bounds.x = diagramBounds.x + LEFT_MARGIN;
    // bounds.y = diagramBounds.y + TOP_MARGIN;
    bounds.x = LEFT_MARGIN;
    bounds.y = TOP_MARGIN;
    bounds.width = Math.max(bounds.width, Math.max(canvasBounds.width, getMinimumDeepModelWidth()));
    bounds.height = height;
    // System.out.println(bounds + " ||| " + diagramBounds + " ||| " +
    // getMinimumDeepModelWidth());

    // set the new bounds
    figure.setBounds(bounds);
    figure.validate(); // fixes an infinite loop
    figure = deepModel.getContentPane();
    figure.setBounds(bounds);
    figure.validate();
  }
}

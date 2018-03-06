/*******************************************************************************
 * Copyright (c) 2011, 2012 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Ralph Gerbig - initial API and implementation and initial documentation
 *******************************************************************************/
package org.melanee.core.workbench.interfaces;

import org.melanee.core.models.plm.PLM.AbstractDSLVisualizer;
import org.melanee.core.models.plm.PLM.Clabject;
import org.melanee.core.models.plm.PLM.ConnectionEnd;

/**
 * Interface for a visual model to figure transformator. The transformator takes
 * a visualizer as input and generates a renderable figure as output (e.g. a
 * draw2d figure).
 *
 */
public interface IGraphicalVisualizationService extends IVisualizationServiceBase {

  /**
   * Runs the transformation on a clabject (i.e. Connection, Entity)
   * 
   * @param v
   *          graphical dsl visualizer to translate into a figure
   * @param c
   *          the clabject meta-model element which is visualized
   * 
   * @return renderable figure (org.eclipse.draw2d.IFigure)
   */
  public abstract Object run(AbstractDSLVisualizer v, Clabject c);

  /**
   * Runs the transformation on a clabject (i.e. Connection, Entity)
   * 
   * @param v
   *          graphical dsl visualizer to translate into a figure
   * @param c
   *          the clabject meta-model element which is visualized
   * @param compartmentFigure
   *          the figure which holds the content which owner by the model element,
   *          i.e. Clabject.content.
   * 
   * @return renderable figure (org.eclipse.draw2d.IFigure)
   */
  public abstract Object run(AbstractDSLVisualizer v, Clabject c, Object compartmentFigure);

  /**
   * Runs the transformation on a connectionEnd.
   * 
   * @param v
   *          graphical dsl visualizer to translate into a figure
   * @param p
   *          the connectionEnd meta-model element which is visualized
   * @param figure
   *          the connectionEnd figure to manipulate
   * 
   * @return renderable figure (org.eclipse.draw2d.IFigure)
   */
  public abstract Object run(AbstractDSLVisualizer v, ConnectionEnd p, Object figure);

  /**
   * Translates a color constant into a SWT Color
   * 
   * @param constant
   *          value of Color Constant
   *          (org.melanee.graphdsl.models.definition.ColorConstant)
   * @return SWT Color (org.eclipse.swt.graphics.Color)
   */
  // public Object colorConstant2Color(int constant);
}
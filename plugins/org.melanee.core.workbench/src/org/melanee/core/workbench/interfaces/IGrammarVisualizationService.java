/*******************************************************************************
 * Copyright (c) 2017-2022 University of Mannheim: Chair for Software Engineering All rights
 * reserved. This program and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Arne Lange - implementation and documentation
 *******************************************************************************/
package org.melanee.core.workbench.interfaces;

import org.melanee.core.models.plm.PLM.DeepModel;

/**
 * Interface for grammar domain-specific language support.
 *
 */
public interface IGrammarVisualizationService {
  /**
   * Starts the creation of the textual editor.
   * 
   * @param host the IGraphicalEditPart on which the service is invoked
   * @param notationChanged is the service invoked after a change of the notation or to update the
   *        visualization without notation change
   */
  public abstract void run(DeepModel model);

  public void model2Text(DeepModel model);

  public void text2Model(DeepModel model, String text);

  public boolean isExpressionInGrammar(DeepModel context, String expression) throws Exception;

}


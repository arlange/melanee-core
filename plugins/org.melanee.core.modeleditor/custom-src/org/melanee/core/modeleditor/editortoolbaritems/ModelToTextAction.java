/*******************************************************************************
 * Copyright (c) 2017-2022 University of Mannheim: Chair for Software Engineering All rights
 * reserved. This program and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Arne Lange - implementation and documentation
 *******************************************************************************/
package org.melanee.core.modeleditor.editortoolbaritems;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.melanee.core.models.plm.PLM.DeepModel;
import org.melanee.core.models.plm.PLM.Domain;
import org.melanee.core.workbench.ExtensionPointService;
import org.melanee.core.workbench.interfaces.IGrammarVisualizationService;

public class ModelToTextAction extends Action {

  private final Domain domain;

  public ModelToTextAction(Domain domain) {
    super();
    this.domain = domain;
  }

  @Override
  public ImageDescriptor getImageDescriptor() {
    return AbstractUIPlugin.imageDescriptorFromPlugin(
        org.melanee.core.workbench.Activator.PLUGIN_ID, "/icons/2Text.png");
  }

  @Override
  public String getToolTipText() {
    return "Model to Text Translation";
  }

  @Override
  public void run() {
    try {
      IGrammarVisualizationService grammarVisualizerService =
          ExtensionPointService.Instance().getActiveGrammarVisualizationService();

      if (grammarVisualizerService == null)
        return;

      DeepModel deepModel =
          domain.getDeepModel().size() > 0 ? (DeepModel) domain.getDeepModel().get(0) : null;
      if (deepModel == null)
        return;

      grammarVisualizerService.model2Text(deepModel);

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}

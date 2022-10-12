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
import org.melanee.core.models.plm.PLM.Domain;

public class TextToModelAction extends Action {

  private final Domain domain;

  public TextToModelAction(Domain domain) {
    super();
    this.domain = domain;
  }

  @Override
  public ImageDescriptor getImageDescriptor() {
    return AbstractUIPlugin.imageDescriptorFromPlugin(
        org.melanee.core.workbench.Activator.PLUGIN_ID, "/icons/2Model.png");
  }

  @Override
  public String getToolTipText() {
    return "Text To Model Translation";
  }



}

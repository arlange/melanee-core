/*******************************************************************************
 * Copyright (c) 2012 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Ralph Gerbig - initial API and implementation and initial documentation
 *******************************************************************************/
package org.melanee.core.autolayout.service.popupbartools;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.ChangePropertyValueRequest;
import org.eclipse.gmf.runtime.diagram.ui.tools.AbstractPopupBarTool;
import org.melanee.core.autolayout.service.popupbartools.commands.AutoLayoutCommand;

/**
 * 
 * This tool is used for Reasoning Operations which do not have a target
 *
 */
public class AutoLayoutPopupBarTool extends AbstractPopupBarTool {

  public AutoLayoutPopupBarTool(EditPart epHost, CreateRequest theRequest) {
    super(epHost, theRequest);
  }

  @Override
  protected Request createTargetRequest() {
    ChangePropertyValueRequest req = new ChangePropertyValueRequest("Do Auto Layout",
        "Do Auto Layout");
    return req;
  }

  @Override
  protected Command getCommand() {
    return new AutoLayoutCommand((IGraphicalEditPart) getHost());
  }

}
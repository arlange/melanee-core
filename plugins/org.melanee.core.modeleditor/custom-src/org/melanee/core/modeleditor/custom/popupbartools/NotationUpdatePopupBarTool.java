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
package org.melanee.core.modeleditor.custom.popupbartools;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.ChangePropertyValueRequest;
import org.eclipse.gmf.runtime.diagram.ui.tools.AbstractPopupBarTool;
import org.melanee.core.modeleditor.custom.commands.NotationSelectionCommand;
import org.melanee.core.modeleditor.custom.commands.NotationUpdateCommand;

/**
 * 
 * This tools is reponsible for updating the format/notation without
 * setting a value.
 * 
 */
public class NotationUpdatePopupBarTool extends AbstractPopupBarTool{

	private String notation;
	private String format;
	
	public NotationUpdatePopupBarTool(EditPart epHost, CreateRequest theRequest, String format) {
		super(epHost, theRequest);
		this.notation = notation;
		this.format = format;
	}

	@Override
	protected Request createTargetRequest() {
		ChangePropertyValueRequest req = new ChangePropertyValueRequest("Apply Graphical Notation", "Apply Graphical Notation");
		return req;
	}

	@Override
	protected Command getCommand() {
		return new NotationUpdateCommand((IGraphicalEditPart)getHost(), format);
	}
}
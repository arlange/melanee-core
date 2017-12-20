/*******************************************************************************
 * Copyright (c) 2013 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Ralph Gerbig - initial API and implementation and initial documentation
 *******************************************************************************/
package org.melanee.core.modeleditor.custom.selectioneditpolicies;

import java.util.List;

import org.eclipse.gef.DragTracker;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.swt.graphics.Image;

/**
 * 
 * Describes a menu which is expanded when hovering
 * the tool in the toolbar.
 *
 */
public class ToolBarMenuDescriptor extends ToolBarItemDescriptor {

	List<ToolBarItemDescriptor> _children;
	
	public ToolBarMenuDescriptor(String toolTip, Image image, IElementType elementType, DragTracker theTracker, List<ToolBarItemDescriptor> children) {
		super(toolTip, image, elementType, theTracker);
		_children = children;
	}

	public List<ToolBarItemDescriptor> getChildren(){
		return _children;
	}
}

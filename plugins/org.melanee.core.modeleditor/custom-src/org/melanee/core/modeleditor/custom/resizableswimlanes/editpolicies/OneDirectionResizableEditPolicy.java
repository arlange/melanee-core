/*******************************************************************************
 * Copyright (c) 2012 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Daniel Gritzner, Ralph Gerbig - initial API and implementation 
 *    									and initial documentation
 *******************************************************************************/
package org.melanee.core.modeleditor.custom.resizableswimlanes.editpolicies;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableEditPolicyEx;

/**
 *
 * This edit policy allows edit parts to be only resized towards one direction
 * specified during instantiation. The direction can be specified using constants
 * from org.eclipse.draw2d.PositionConstants.
 *
 */
public class OneDirectionResizableEditPolicy extends ResizableEditPolicyEx {
	// the direction in which the EditPart can be resized
	private int direction = PositionConstants.NONE;
	
	/**
	 * 
	 * @param direction the direction in which the EditPart using this EditPolicy may be resized
	 */
	public OneDirectionResizableEditPolicy(int direction) {
		this.direction = direction;
		setResizeDirections(direction);
		setDragAllowed(false);
	}
	
	@Override
	protected List createSelectionHandles() {
		List list = new ArrayList();
		createResizeHandle(list, direction);
		return list;
	}
}

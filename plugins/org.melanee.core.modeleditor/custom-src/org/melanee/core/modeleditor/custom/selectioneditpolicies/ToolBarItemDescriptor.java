/*******************************************************************************
 * Copyright (c) 2013 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     - initial API and implementation and initial documentation
 *******************************************************************************/
package org.melanee.core.modeleditor.custom.selectioneditpolicies;

import org.eclipse.gef.DragTracker;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.swt.graphics.Image;

/**
 * Describes a clickable toolbar item which
 * executes a command.
 *
 */
public class ToolBarItemDescriptor {

	/** The action button tooltip */
	private String _tooltip = new String();

	/** The image for the button */
	private Image _icon = null;

	/** The typeinfo used to create the Request for the command */
	@SuppressWarnings("unused")
	private IElementType _elementType;

	/** The DracgTracker / Tool associatd with the popup bar button */
	private DragTracker _dragTracker = null;

	/**
	 * constructor
	 * @param toolTip
	 * @param image
	 * @param elementType
	 * @param theTracker
	 */
	public ToolBarItemDescriptor(
			String toolTip,
			Image image,
			IElementType elementType,
			DragTracker theTracker) {
		_tooltip = toolTip;
		_icon = image;
		_dragTracker = theTracker;
		_elementType = elementType;

	}

	/**
	 * gets the icon associated with this Descriptor
	 * @return Image
	 */
	public final Image getIcon() {
		return _icon;
	}

	/**
	 * gets the drag tracker associated with this Descriptor
	 * @return drag tracker
	 */
	public final DragTracker getDragTracker() {
		return _dragTracker;
	}

	/**
	 * gets the tool tip associated with this Descriptor
	 * @return string
	 */
	public final String getToolTip() {
		return _tooltip;
	}

}

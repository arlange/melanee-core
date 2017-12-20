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

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.internal.l10n.DiagramUIPluginImages;
import org.eclipse.swt.graphics.Image;

/**
 * The container of the tool bar items
 * 
 * Code is copied from
 * org.eclipse.gmf.runtime.diagram.ui.editpolicies.PopupBarEditPolicy and
 * modified.
 */
public class Toolbar extends RoundedRectangle {

	private Image myTailImage = null;

	private boolean bIsInit = false;

	private int myCornerDimension = 6;

	/** Indicates whether over any tool in the toolbar is hovered, use for transparancy management */
	public boolean mouseOver = false;
	
	/** Mouse hovers any of the buttons */
	public void setMouseOver(boolean value){
		mouseOver = value;
	}
	
	/** Mouse hovers any of the buttons */
	public boolean getMouseOver(){
		return mouseOver;
	}
	
	private BaseToolbarSelectionEditPolicy hostEditPolicy = null;

	private static Image IMAGE_POPUPBAR_PLUS = DiagramUIPluginImages
			.get(DiagramUIPluginImages.IMG_POPUPBAR_PLUS);

	private static Image IMAGE_POPUPBAR = DiagramUIPluginImages
			.get(DiagramUIPluginImages.IMG_POPUPBAR);

	/**
	 * constructor
	 */
	public Toolbar(BaseToolbarSelectionEditPolicy hostEditPolicy) {
		// we do not make the myActionTailFigue opaque because it
		// doesn't look good when magnification is set.
		this.setFill(true);
		this.setBackgroundColor(ColorConstants.buttonLightest);
		this.setForegroundColor(ColorConstants.lightGray);
		this.setVisible(true);
		this.setEnabled(true);
		this.setOpaque(true);
		this.hostEditPolicy = hostEditPolicy;

	}

	/**
	 * @see org.eclipse.draw2d.Figure#paintFigure(org.eclipse.draw2d.Graphics)
	 */
	public void paintFigure(Graphics graphics) {
		if(mouseOver)
			graphics.setAlpha(255);
		else
			graphics.setAlpha(ToolbarItem.MOUSE_EXIT_ALPHA);
		
		int shiftWidth = 3;
		Image theTail = getTail();
		Rectangle theBounds = this.getBounds().getCopy();
		theBounds.height -= theTail.getBounds().height;
		theBounds.height -= shiftWidth;// shift slight above cursor
		theBounds.x += shiftWidth; // shift slight to right of cursor
		theBounds.width -= (shiftWidth + 1); // otherwise rhs is clipped

		// fill the round rectangle first since it is opaque
		graphics.fillRoundRectangle(theBounds, myCornerDimension,
				myCornerDimension);
		graphics.drawRoundRectangle(theBounds, myCornerDimension,
				myCornerDimension);

		graphics.drawImage(theTail, theBounds.x + 6, theBounds.y
				+ theBounds.height - 1);

	}

	private Image getTail() {
		if (!bIsInit) {
			if (hostEditPolicy.getIsDisplayAtMouseHoverLocation()
					&& !hostEditPolicy.isHostConnection()) {
				if (myTailImage == null) {
					myTailImage = IMAGE_POPUPBAR_PLUS;
					bIsInit = true;
				}
			} else {
				if (myTailImage == null) {
					myTailImage = IMAGE_POPUPBAR;
					bIsInit = true;
				}
			}

		}
		return myTailImage;

	}
}

/*******************************************************************************
 * Copyright (c) 2011 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     - initial API and implementation and initial documentation
 *******************************************************************************/
package org.melanee.core.modeleditor.custom.borders;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;

/**
 * 
 * Positions a figure at the centered south. If an other position than
 * south is chosen it behaves like the standard BorderItemLocator 
 *
 */
public class CenteredBorderItemLocator extends BorderItemLocator {

	private Dimension initialOffset = new Dimension(0, 0);
	
	public void setInitialOffset(int x, int y){initialOffset = new Dimension(x, y);}
	
	public void setInitialOffset(Dimension d){initialOffset = d;}
	
	public Dimension getInitialOffset(){return initialOffset;}
	
	public CenteredBorderItemLocator(IFigure mainFigure, int preferredSide) {
		super(mainFigure, preferredSide);
	}	
	
	/**
	 * If position is set to south calculate the center
	 */
	protected Point getPreferredLocation(int side, IFigure borderItem) {
		if (side == PositionConstants.NORTH_EAST){
			Rectangle bounds = getParentBorder();
			
			int x = -getSize(borderItem).width;
			int y = 0;
			
			x += initialOffset.width;
			y += initialOffset.height;
			
			setBorderItemOffset(new Dimension(x, y));
			
			return super.getPreferredLocation(side, borderItem);
		}
		if (side == PositionConstants.NORTH){
			Rectangle bounds = getParentBorder();
			int parentFigureWidth = bounds.width;
			
			int x = -(getSize(borderItem).width / 2) + (parentFigureWidth / 2);
			int y = 0;
			
			x += initialOffset.width;
			y += initialOffset.height;
			
			setBorderItemOffset(new Dimension(x, y));
			
			return super.getPreferredLocation(side, borderItem);
		}
		if (side == PositionConstants.NORTH_WEST){
			Rectangle bounds = getParentBorder();
			
			int x = (bounds.width);
			int y = 0;
			
			x += initialOffset.width;
			y += initialOffset.height;
			
			setBorderItemOffset(new Dimension(x, y));
			
			return super.getPreferredLocation(side, borderItem);
		}
		else if (side == PositionConstants.EAST) {
			
			Rectangle bounds = getParentBorder();
			int parentFigureHeight = bounds.height;
			int parentFigureWidth = bounds.width;
			int parentFigureX = bounds.x;
			int parentFigureY = bounds.y;
			int x = parentFigureX;
			int y = parentFigureY;
			Dimension borderItemSize = getSize(borderItem);
			
			x = parentFigureX + parentFigureWidth - getBorderItemOffset().width;
			y += (parentFigureHeight / 2) - (borderItemSize.height / 2);
			
			x += initialOffset.width;
			y += initialOffset.height;
			
			return new Point(x, y);
		}
		else if (side == PositionConstants.SOUTH_EAST) {
			
			Rectangle bounds = getParentBorder();
			int parentFigureWidth = bounds.width;
			int parentFigureHeight = bounds.height;
			
			int x = -getSize(borderItem).width;
			int y = parentFigureHeight + getSize(borderItem).height;
			
			x += initialOffset.width;
			y += initialOffset.height;
			
			setBorderItemOffset(new Dimension(x, y));
			
			return super.getPreferredLocation(PositionConstants.SOUTH, borderItem);
		}
		else if (side == PositionConstants.SOUTH_WEST) {
			
			Rectangle bounds = getParentBorder();
			int parentFigureWidth = bounds.width;
			int parentFigureHeight = bounds.height;
			
			int x = bounds.width;
			int y = parentFigureHeight + getSize(borderItem).height;
			
			x += initialOffset.width;
			y += initialOffset.height;
			
			setBorderItemOffset(new Dimension(x, y));
			
			return super.getPreferredLocation(PositionConstants.SOUTH, borderItem);
		}
		else if (side == PositionConstants.SOUTH) {
			
			Rectangle bounds = getParentBorder();
			int parentFigureWidth = bounds.width;
			
			int x = -(getSize(borderItem).width / 2) + (parentFigureWidth / 2);
			int y = 0;
			
			x += initialOffset.width;
			y += initialOffset.height;
			
			setBorderItemOffset(new Dimension(x, y));
			
			return super.getPreferredLocation(side, borderItem);
		}
		else if (side == PositionConstants.WEST) {
			
			Rectangle bounds = getParentBorder();
			int parentFigureHeight = bounds.height;
			int parentFigureX = bounds.x;
			int parentFigureY = bounds.y;
			int x = parentFigureX;
			int y = parentFigureY;
			Dimension borderItemSize = getSize(borderItem);
			
			x = parentFigureX - getSize(borderItem).width
					+ getBorderItemOffset().width;
			y += (parentFigureHeight / 2) - (borderItemSize.height / 2);
			
			x += initialOffset.width;
			y += initialOffset.height;
			
			return new Point(x, y);
		}
		else {
			return super.getPreferredLocation(side, borderItem);
		}
	}

	@Override
	protected void calculateNextNonConflictingPosition(Point currentLocation,
			int interval, int currentSide, IFigure borderItem,
			Rectangle obstacle) {
		
		super.calculateNextNonConflictingPosition(currentLocation, interval,
			currentSide, borderItem, obstacle);
		
		if (currentSide == PositionConstants.SOUTH_EAST)
			super.calculateNextNonConflictingPosition(currentLocation, interval,
					PositionConstants.SOUTH, borderItem, obstacle);
	}
}

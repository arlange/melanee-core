/*******************************************************************************
 * Copyright (c) 2012 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     - initial API and implementation and initial documentation
 *******************************************************************************/
package org.melanee.core.autolayout.service;

import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

public class BinaryLayouter {

	private static final String PATTERN_HORIZONTAL = "horizontal";
	private static final String PATTERN_VERTICAL = "vertical";
	private static final String PATTERN_ANGLE_LEFT = "angle_left";
	private static final String PATTERN_ANGLE_RIGHT = "angel_right";
	
	private String pattern;
	
	private Rectangle north = null;
	private Rectangle east = null;
	private Rectangle south = null;
	private Rectangle west = null;
	
	
	/**
	 * 
	 * @param rectangles
	 * @return
	 */
	public boolean matchesPattern(List<Rectangle> rectangles){
		
		//Only applicable for 2 rectangles
		if (rectangles.size() != 2)
			return false;
		
		Rectangle rect1 = rectangles.get(0);
		Rectangle rect2 = rectangles.get(1);
		
		//Are the two rectangles opposite of each other?
		
		/*
		 *     R1              R2
		 *  _________       _________
		 * |         |_____|         |
		 * |_________|     |_________|
		 */
		if (rect1.getCenter().y > rect2.getTopLeft().y
				&& rect1.getCenter().y < rect2.getBottomLeft().y){
			
			pattern = PATTERN_HORIZONTAL;
			
			if (rect1.getCenter().x < rect2.getCenter().x){
				east = rect1; west = rect2;
			}
			else{
				west = rect1; east = rect2;
			}
			
			return true;
		}
		
		/*
		 *  _________      
		 * |         |     
		 * |_________|     
		 *      |
		 *  ____|____
		 * |         |
		 * |_________|
		 */
		if (	(rect1.getTop().y > rect2.getBottom().y
					&& rect1.getCenter().x > rect2.getBottomLeft().x
					&& rect1.getCenter().x < rect2.getBottomRight().x)
				||
				(rect2.getTop().y > rect1.getBottom().y
						&& rect2.getCenter().x > rect1.getBottomLeft().x
						&& rect2.getCenter().x < rect1.getBottomRight().x)
			){
			pattern = PATTERN_VERTICAL;
			
			if (rect1.getCenter().y > rect2.getCenter().y){
				north = rect1; south = rect2;
			}
			else{
				north = rect2; south = rect1;
			}
			
			return true;
		}
		
		
		/*
		 *             _________
		 *            |         |
		 *            |_________|
		 *  _________      |
		 * |         |_____|
		 * |_________|     
		 */
		if ( 
				(rect1.getCenter().y > rect2.getCenter().y
						&& rect1.getCenter().x < rect2.getCenter().x)
				|| 
				(rect2.getCenter().y > rect1.getCenter().y
						&& rect2.getCenter().x < rect1.getCenter().x)
			){
			pattern = PATTERN_ANGLE_LEFT;
			
			if (rect1.getCenter().x < rect2.getCenter().x){
				west = rect1; north = rect2;
			}
			else{
				west = rect2; north = rect1;
			}
			
			return true;
		}
		/*
		 *   _________
		 *  |         |
		 *  |_________|
		 *       |   _________
		 *       |__|         |
		 *          |_________|     
		 */
		if ( 
				(rect1.getCenter().y > rect2.getCenter().y
						&& rect1.getCenter().x > rect2.getCenter().x)
				|| 
				(rect2.getCenter().y > rect1.getCenter().y
						&& rect2.getCenter().x > rect1.getCenter().x)
				
				){
			
			pattern = PATTERN_ANGLE_RIGHT;
			
			if(rect1.getCenter().x > rect2.getCenter().x){
				east = rect1; north = rect2;
			}
			else{
				east = rect2; north = rect1;
			}
			
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @return
	 */
	public Point calculateNewMiddle(){
		
		/*
		 *     R1              R2
		 *  _________       _________
		 * |         |_____|         |
		 * |_________|     |_________|
		 */
		if (PATTERN_HORIZONTAL.equals(pattern)){
			int x = west.getRight().x + ( (east.getLeft().x - west.getRight().x) / 2 );
			int y = (west.getCenter().y + east.getCenter().y) / 2;
			
			return new Point(x, y);
		}
		
		/*
		 *  _________      
		 * |         |     
		 * |_________|     
		 *      |
		 *  ____|____
		 * |         |
		 * |_________|
		 */
		if (PATTERN_VERTICAL.equals(pattern)){
			int x = north.getCenter().x;
			int y = (north.getCenter().y + south.getCenter().y) / 2;
			
			return new Point(x, y);
		}
		
		/*
		 *             _________
		 *            |         |
		 *            |_________|
		 *  _________      |
		 * |         |_____|
		 * |_________|     
		 */
		if (PATTERN_ANGLE_LEFT.equals(pattern)){
			int x = north.getCenter().x;
			int y = west.getCenter().y;
			
			return new Point(x, y);
		}
		
		/*
		 *   _________
		 *  |         |
		 *  |_________|
		 *       |   _________
		 *       |__|         |
		 *          |_________|     
		 */
		if (PATTERN_ANGLE_RIGHT.equals(pattern)){
			int x = north.getCenter().x;
			int y = east.getCenter().y;
			
			return new Point(x, y);
		}
		
		return null;
	}
}
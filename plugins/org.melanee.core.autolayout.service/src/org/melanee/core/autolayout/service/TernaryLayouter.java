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
package org.melanee.core.autolayout.service;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

public class TernaryLayouter {

	private static final String PATTERN_TRIANGLE_NORTH = "triangle_north";
	private static final String PATTERN_TRIANGLE_SOUTH = "triangle_south";
	private static final String PATTERN_TOP_LEFT = "tree_top_left";
	private static final String PATTERN_TOP_RIGHT = "tree_top_right";
	private static final String PATTERN_BOTTOM_LEFT = "tree_bottom_left";
	private static final String PATTERN_BOTTOM_RIGHT = "tree_bottom_right";
	private static final String PATTERN_TRIANGLE_RIGHT = "tree_triangle_right";
	private static final String PATTERN_TRIANGLE_LEFT = "tree_triangle_left";
	
	private String pattern;
	
	private Rectangle north = null;
	private Rectangle south = null;
	private List<Rectangle> rectangles = new ArrayList<Rectangle>();
	
	
	/**
	 * 
	 * @param rectangles
	 * @return
	 */
	public boolean matchesPattern(List<Rectangle> rectangles){
		
		this.rectangles = new ArrayList<Rectangle>(rectangles);
		
		//Only applicable for 2 rectangles
		if (rectangles.size() != 3)
			return false;
		
		/*             _________                 
		 *            |         |
		 *            |_________|
		 *  _________      |       _________
		 * |         |_____|______|         |
		 * |_________|            |_________|
		 */
		for (Rectangle northRect : rectangles){
			boolean isMostNorth = true;
			
			for (Rectangle rect : rectangles){
				if (rect != northRect)
					if (northRect.getCenter().y > rect.getTop().y){
						isMostNorth = false;
						break;
					}
					else
						isMostNorth = true;
			}
			
			if (isMostNorth == true){
				north = northRect;
				break;
			}
		}
		
		for (Rectangle southRect : rectangles){
			boolean isMostSouth = true;
			
			for (Rectangle rect : rectangles){
				if (rect != southRect)
					if (southRect.getCenter().y < rect.getBottom().y){
						isMostSouth = false;
						break;
					}
					else
						isMostSouth = true;
			}
			
			if (isMostSouth == true){
				south = southRect;
				break;
			}
		}
		
		
		/*             _________
		 *            |         |
		 *            |_________|
		 *  _________      |       _________
		 * |         |_____|______|         |
		 * |_________|            |_________|     
		 */
		if (north != null && south == null){
			pattern = PATTERN_TRIANGLE_NORTH;
			
			return true;
		}
		
		/*  _________             _________
		 * |         |___________|         |
		 * |_________|     |     |_________|
		 * 	               |
		 *       	   ____|____
		 *            |         |
		 *            |_________|
		 */
		if (south != null && north == null){
			pattern = PATTERN_TRIANGLE_SOUTH;
			
			return true;
		}
		
		/*   _________                     _________          _________
		 *  |         |                   |         |        |         | 
		 *  |_________|                   |_________|        |_________|
		 *       |   _________   _________   |       _________    |      
		 *       |__|         | |         |__|      |         |___|
		 *       |  |_________| |_________|  |      |_________|   |      
		 *       |   _________   _________   |                ____|____      
		 *       |__|         | |         |__|               |         |
		 *          |_________| |_________|                  |_________|
		 *            
		 *    _________                    _________     _________
		 *   |         |__              __|         |   |         |
		 *   |_________|  |            |  |_________|   |_________|
		 *    _________   |            |   _________         |      _________
		 *   |         |__|            |__|         |        |_____|         |
		 *   |_________|  |            |  |_________|        |     |_________|
		 *            ____|____    ____|____             ____|____
		 *           |         |  |         |           |         |
		 *           |_________|  |_________|           |_________|
		 */
		if (north != null && south != null){
			rectangles.remove(north);
			rectangles.remove(south);
			
			Rectangle rect1 = rectangles.get(0);
			
			if (rect1.getCenter().x > south.getLeft().x && rect1.getCenter().x < south.getRight().x)
				if (south.getCenter().x < north.getCenter().x)
					pattern = PATTERN_TOP_LEFT;
				else
					pattern = PATTERN_TOP_RIGHT;
			else if (rect1.getCenter().x > north.getLeft().x && rect1.getCenter().x < north.getRight().x)
				if (north.getCenter().x < south.getCenter().x)
					pattern = PATTERN_BOTTOM_LEFT;
				else
					pattern = PATTERN_BOTTOM_RIGHT;
			else
				if (rect1.getCenter().x < north.getCenter().x)
					pattern = PATTERN_TRIANGLE_LEFT;
				else
					pattern = PATTERN_TRIANGLE_RIGHT;
			
			return true;
		}
		
		return false;
	}
	
	/**
	 * 
	 * @return
	 */
	public Point calculateNewMiddle(){
		
		/*             _________
		 *            |         |
		 *            |_________|
		 *  _________      |      _________
		 * |         |_____|_____|         |
		 * |_________|           |_________|     
		 */
		if (PATTERN_TRIANGLE_NORTH.equals(pattern)){
			int x = north.getCenter().x;
			
			rectangles.remove(north);
			Rectangle rect1 = rectangles.get(0);
			Rectangle rect2 = rectangles.get(1);
			
			int y = (rect1.getCenter().y + rect2.getCenter().y) / 2;
			
			return new Point(x, y);
		}
		
		
		/*  _________             _________
		 * |         |___________|         |
		 * |_________|     |     |_________|
		 *       	   ____|____
		 *            |         |
		 *            |_________|
		 */
		if (PATTERN_TRIANGLE_SOUTH.equals(pattern)){
			int x = south.getCenter().x;
			
			rectangles.remove(south);
			Rectangle rect1 = rectangles.get(0);
			Rectangle rect2 = rectangles.get(1);
			
			int y = (rect1.getCenter().y + rect2.getCenter().y) / 2;
			
			return new Point(x, y);
		}
		
		/*  _________             _________
		 * |         |___________|         |
		 * |_________|     |     |_________|
		 *       	   ____|____
		 *            |         |
		 *            |_________|
		 */
		if (PATTERN_TRIANGLE_SOUTH.equals(pattern)){
			int x = south.getCenter().x;
			
			rectangles.remove(south);
			Rectangle rect1 = rectangles.get(0);
			Rectangle rect2 = rectangles.get(1);
			
			int y = (rect1.getCenter().y + rect2.getCenter().y) / 2;
			
			return new Point(x, y);
		}
		
		/*            _________
		 *           |         | 
		 *           |_________|
		 *   _________    |      
		 *  |         |___|
		 *  |_________|   |      
		 *            ____|____      
		 *           |         |
		 *           |_________|
		 */
		if (PATTERN_TRIANGLE_LEFT.equals(pattern)){
			int x = (south.getCenter().x + north.getCenter().x) / 2;
			
			rectangles.remove(south);
			Rectangle rect1 = rectangles.get(0);
			
			int y = rect1.getCenter().y;
			
			return new Point(x, y);
		}

		/*    _________
		 *   |         |
		 *   |_________|
		 *        |      _________
		 *        |_____|         |
		 *        |     |_________|
		 *    ____|____ 
		 *   |         |
		 *   |_________|
		 */
		if (PATTERN_TRIANGLE_RIGHT.equals(pattern)){
			int x = (south.getCenter().x + north.getCenter().x) / 2;
			
			rectangles.remove(south);
			Rectangle rect1 = rectangles.get(0);
			
			int y = rect1.getCenter().y;
			
			return new Point(x, y);
		}
		
		
		 /*    _________
		  *   |         |
		  *   |_________|
		  *         |    _________
		  *         |___|         |
		  *         |   |_________|
		  *         |    _________
		  *         |___|         |
		  *             |_________|
		  */
		if (PATTERN_TOP_RIGHT.equals(pattern) || PATTERN_TOP_LEFT.equals(pattern)){
			int x = north.getCenter().x;
			
			rectangles.remove(south);
			Rectangle rect1 = rectangles.get(0);
			
			int y = rect1.getCenter().y;
			
			return new Point(x, y);
		}
		
		/*    _________ 
		 *   |         |__
		 *   |_________|  |
		 *    _________   |
		 *   |         |__|
		 *   |_________|  |
		 *            ____|____
		 *           |         |
		 *           |_________|
		 *    _________
		 *   |         |
		 *   |_________|
		 *         |    _________
		 *         |___|         |
		 *         |   |_________|
		 *         |    _________
		 *         |___|         |
		 *             |_________|
		 */
		if (PATTERN_BOTTOM_RIGHT.equals(pattern) || PATTERN_BOTTOM_LEFT.equals(pattern)){
			int x = south.getCenter().x;
			
			rectangles.remove(south);
			Rectangle rect1 = rectangles.get(0);
			
			int y = rect1.getCenter().y;
			
			return new Point(x, y);
		}
		
		return null;
	}
}
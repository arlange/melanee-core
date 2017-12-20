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

public class NnaryLayouter {

	private static final String PATTERN_VERTICAL_TREE_NORTH = "vertical_tree_north";
	private static final String PATTERN_VERTICAL_TREE_SOUTH = "vertical_tree_south";
	private static final String PATTERN_HORIZONTAL_NORTH_TREE = "horizontal_tree_north";
	private static final String PATTERN_HORIZONTAL_SOUTH_TREE = "horizontal_tree_south";
	
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
		
		//Only applicable for more than 3 rectangles
		if (rectangles.size() < 3)
			return false;
		
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
		
		/*   _________                     _________
		 *  |         |                   |         | 
		 *  |_________|                   |_________|
		 *       |   _________   _________   |
		 *       |__|         | |         |__|
		 *       |  |_________| |_________|  |      
		 *       |   _________   _________   |      
		 *       |__|         | |         |__|
		 *       |  |_________| |_________|  |
		 *       |   _________   _________   |
		 *       |__|         | |         |__|
		 *          |_________| |_________|
		 *   
		 *    _________                    _________
		 *   |         |__              __|         |
		 *   |_________|  |            |  |_________|
		 *    _________   |            |   _________ 
		 *   |         |__|            |__|         |
		 *   |_________|  |            |  |_________|
		 *    _________   |            |   _________ 
		 *   |         |__|            |__|         |
		 *   |_________|  |            |  |_________|
		 *            ____|____    ____|____ 
		 *           |         |  |         |
		 *           |_________|  |_________|
		 */
		//We have one most south and one most north node
		if (north != null && south != null){
			//Check if root is north or south
			
			int columStackSize = 0;
			
			//If we have south oriented tree the column stack is under the north tree
			for (Rectangle r  : rectangles){
				if (r == south)
					continue;
				
				if (r.getCenter().x < south.getRight().x && r.getCenter().x > south.getLeft().x)
					columStackSize++;
			}
			
			if (columStackSize > 0){
				pattern = PATTERN_VERTICAL_TREE_NORTH;
				return true;
			}
			
			columStackSize = 0;
			
			//If we have south oriented tree the column stack is under the north tree
			for (Rectangle r  : rectangles){
				if (r == north)
					continue;
				
				if (r.getCenter().x < north.getRight().x && r.getCenter().x > north.getLeft().x)
					columStackSize++;
			}
			
			if (columStackSize > 0){
				pattern = PATTERN_VERTICAL_TREE_SOUTH;
				return true;
			}
		}
		
		
		
		/*               _________                _________    _________    _________
		 *              |         |              |         |  |         |  |         |
		 *              |_________|              |_________|  |_________|  |_________|
		 *       ____________|____________            |____________|____________|
		 *  ____|____    ____|____    ____|____                ____|____
		 * |         |  |         |  |         |              |         |
		 * |_________|  |_________|  |_________|              |_________|
		 *              
		 */
		//we have either a most sout or most north tree
		if(north != null && south == null){
			pattern = PATTERN_HORIZONTAL_NORTH_TREE;
			return true;
		}
		else if(north == null && south != null){
			pattern = PATTERN_HORIZONTAL_SOUTH_TREE;
			return true;
		}
			
		
		
		return true;
	}
	
	/**
	 * 
	 * @return
	 */
	public Point calculateNewMiddle(){
		/*   _________                     _________
		 *  |         |                   |         | 
		 *  |_________|                   |_________|
		 *       |   _________   _________   |
		 *       |__|         | |         |__|
		 *       |  |_________| |_________|  |      
		 *       |   _________   _________   |      
		 *       |__|         | |         |__|
		 *       |  |_________| |_________|  |
		 *       |   _________   _________   |
		 *       |__|         | |         |__|
		 *          |_________| |_________|
		 */
		if (pattern == PATTERN_VERTICAL_TREE_NORTH){
			
			Rectangle columnNorthRect = null;
			
			//find most north node wich is not the root
			for (Rectangle northRect : rectangles){
				if (northRect == north || northRect == south)
					continue;
				
				boolean isMostNorth = true;
				
				for (Rectangle rect : rectangles){
					if (rect != northRect && rect != north)
						if (northRect.getCenter().y > rect.getTop().y){
							isMostNorth = false;
							break;
						}
						else
							isMostNorth = true;
				}
				
				if (isMostNorth == true){
					columnNorthRect = northRect;
					break;
				}
			}
			if (columnNorthRect != null)
				return new Point(north.getCenter().x, columnNorthRect.getCenter().y);
		}
		
		/*    _________                    _________
		 *   |         |__              __|         |
		 *   |_________|  |            |  |_________|
		 *    _________   |            |   _________ 
		 *   |         |__|            |__|         |
		 *   |_________|  |            |  |_________|
		 *    _________   |            |   _________ 
		 *   |         |__|            |__|         |
		 *   |_________|  |            |  |_________|
		 *            ____|____    ____|____ 
		 *           |         |  |         |
		 *           |_________|  |_________|
		 */
		if (pattern == PATTERN_VERTICAL_TREE_SOUTH){
			
			Rectangle columnSouthRect = null;
			
			//find most south rectangle wich is not the root
			for (Rectangle southRect : rectangles){
				if (southRect == north || southRect == south)
					continue;
				
				boolean isMostSouth = true;
				
				for (Rectangle rect : rectangles){
					if (rect != southRect && rect != south)
						if (southRect.getCenter().y < rect.getBottom().y){
							isMostSouth = false;
							break;
						}
						else
							isMostSouth = true;
				}
				
				if (isMostSouth == true){
					columnSouthRect = southRect;
					break;
				}
			}
			if (columnSouthRect != null)
				return new Point(south.getCenter().x, columnSouthRect.getCenter().y);
		}
		
		/*               _________                  
		 *              |         |
		 *              |_________|
		 *       ____________|____________
		 *  ____|____    ____|____    ____|____
		 * |         |  |         |  |         |
		 * |_________|  |_________|  |_________|
		 *
		 */
		if (pattern == PATTERN_HORIZONTAL_NORTH_TREE){
			
			Rectangle currentClosest = null;
			
			//take the on the x-axis closest leave for positioning
			for (Rectangle rect : rectangles)
				if (rect == north)
					continue;
				else
					if (currentClosest == null)
						currentClosest = rect;
					else if(Math.abs(rect.getCenter().x - north.getCenter().x) < Math.abs(currentClosest.getCenter().x - north.getCenter().x))
						currentClosest = rect;
			
			return new Point((currentClosest.getCenter().x + north.getCenter().x) / 2, (currentClosest.getCenter().y + north.getCenter().y) / 2);
			
		}
		
		
		/*  _________    _________    _________
		 * |         |  |         |  |         |
		 * |_________|  |_________|  |_________|
		 *      |____________|____________|
		 *               ____|____
		 *              |         |
		 *              |_________|
		 *              
		 */
		if (pattern == PATTERN_HORIZONTAL_SOUTH_TREE){
			
			Rectangle currentClosest = null;
			
			//take the on the x-axis closest leave for positioning
			for (Rectangle rect : rectangles)
				if (rect == south)
					continue;
				else
					if (currentClosest == null)
						currentClosest = rect;
					else if(Math.abs(rect.getCenter().x - south.getCenter().x) < Math.abs(currentClosest.getCenter().x - south.getCenter().x))
						currentClosest = rect;
			
			return new Point((currentClosest.getCenter().x + south.getCenter().x) / 2, (currentClosest.getCenter().y + south.getCenter().y) / 2);
		}
		
		return null;
	}
}
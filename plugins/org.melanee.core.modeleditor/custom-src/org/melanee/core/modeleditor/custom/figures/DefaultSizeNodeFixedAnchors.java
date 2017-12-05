/*******************************************************************************
 * Copyright (c) 2011 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     - Shaping up the code from 
 *    					http://gmfsamples.tuxfamily.org/wiki/doku.php?id=gmf_tutorial6 but
 *    
 * Idea from http://gmfsamples.tuxfamily.org/wiki/doku.php?id=gmf_tutorial6 but
 * completely polished up.
 *******************************************************************************/
package org.melanee.core.modeleditor.custom.figures;

import java.util.HashMap;

import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;

public class DefaultSizeNodeFixedAnchors extends DefaultSizeNodeFigure {

	public final static String ANCHOR_WEST = "WEST";
	public final static String ANCHOR_EAST = "EAST";
	public final static String ANCHOR_NORTH = "NORTH";
	public final static String ANCHOR_SOUTH = "SOUTH";
	
	private HashMap<String, FixedConnectionAnchor> anchors = new HashMap<String, FixedConnectionAnchor>();
	
	public DefaultSizeNodeFixedAnchors(Dimension defSize, HashMap<String, PrecisionPoint> anchorLocations) {
		this(defSize.width, defSize.height, anchorLocations);
	}
	
	public DefaultSizeNodeFixedAnchors(int width, int height, HashMap<String, PrecisionPoint> anchorLocations) {
		super(width, height);
		
		if (anchorLocations.size()==0)
			throw new IllegalArgumentException("At least one fixed anchor must be specified");

		for (String terminal : anchorLocations.keySet())
			anchors.put(terminal, new FixedConnectionAnchor(this, anchorLocations.get(terminal)));
	}
	
	@Override
	public ConnectionAnchor getSourceConnectionAnchorAt(Point p) {
		return findNearestAnchorFrom(p);
	}
 
	@Override
	public ConnectionAnchor getTargetConnectionAnchorAt(Point p) {
		return findNearestAnchorFrom(p);
	}
 
	@Override
	public ConnectionAnchor getConnectionAnchor(String terminal) {
		return anchors.get(terminal);
	}
 
	@Override
	public String getConnectionAnchorTerminal(ConnectionAnchor c) {
		
		for (String s : anchors.keySet())
			if (anchors.get(s) == c)
				return s;
		
		return null;
	}
 
	private ConnectionAnchor findNearestAnchorFrom(Point point) {
		
		if (point == null || anchors.size()==1)
			return anchors.values().iterator().next();
			
		String nearestTerminal = anchors.keySet().toArray(new String[]{})[0];
		double distance = point.getDistance(anchors.get(nearestTerminal).getLocation());
		
		for (String terminal : anchors.keySet())
		{
			if (distance > point.getDistance(anchors.get(terminal).getLocation())) {
				distance = point.getDistance(anchors.get(terminal).getLocation());
				nearestTerminal = terminal;
			}
		}
		
		return anchors.get(nearestTerminal);
	}
	
	public class FixedConnectionAnchor extends AbstractConnectionAnchor {
		 
		private double xOffset;
		private double yOffset;
	 
		public FixedConnectionAnchor(IFigure owner, PrecisionPoint offset) {
			this(owner, offset.preciseX, offset.preciseY);
		}
	 
		public FixedConnectionAnchor(IFigure owner, double xOffset, double yOffset) {
			super(owner);
			this.xOffset = xOffset;
			this.yOffset = yOffset;
		}
	 
		@Override
		public Point getLocation(Point point) {
			return getLocation();
		}
	 
		public Point getLocation() {
			Rectangle r = getOwner().getBounds();
			Point p = new PrecisionPoint(r.x + r.width*xOffset, r.y + r.height*yOffset);
			getOwner().translateToAbsolute(p);
			return p;
		}
	 
	}
	
}

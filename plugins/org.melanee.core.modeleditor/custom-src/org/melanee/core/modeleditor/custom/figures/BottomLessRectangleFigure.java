/*******************************************************************************
 * Copyright (c) 2016 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Ralph Gerbig - initial API and implementation and initial documentation
 *******************************************************************************/
package org.melanee.core.modeleditor.custom.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;

public class BottomLessRectangleFigure extends RectangleFigure {


	
//	@Override
//	protected void paintBorder(Graphics graphics) {
//		super.paintBorder(graphics);
//		
//		getBorder();
//	}
//	
	@Override
	protected void outlineShape(Graphics graphics) {
//		super.outlineShape(graphics);
		float lineInset = Math.max(1.0f, getLineWidthFloat()) / 2.0f;
		int inset1 = (int) Math.floor(lineInset);
		int inset2 = (int) Math.ceil(lineInset);

		Rectangle r = Rectangle.SINGLETON.setBounds(getBounds());
		r.x += inset1;
		r.y += inset1;
		r.width -= inset1 + inset2;
//		r.height -= inset1 + inset2;
		
		PointList points = new PointList();
//		Rectangle bounds = getBounds();
		
		points.addPoint(r.getBottomLeft());
		points.addPoint(r.getTopLeft());
		points.addPoint(r.getTopRight());
		points.addPoint(r.getBottomRight());
		graphics.drawPolyline(points);
	}
	
}

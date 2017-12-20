/*******************************************************************************
 * Copyright (c) 2014 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *       Ralph Gerbig - initial API and implementation and initial documentation
 *******************************************************************************/
package org.melanee.core.modeleditor.custom.tooltip;

import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.text.FlowPage;
import org.eclipse.draw2d.text.TextFlow;

public class ToolTip extends FlowPage {

	private final TextFlow title = new TextFlow();
	
	public ToolTip(String title){
		
		setOpaque(true);
		setBorder(new MarginBorder(0 , 2, 1, 2));
		this.title.setText(title);
		
		add(this.title);
		
	}
	
	@Override
	public Dimension getPreferredSize(int width, int h) {
		Dimension result = super.getPreferredSize(-1, -1);
		
		if(result.width > 450)
			result = super.getPreferredSize(450, -1);
		
		return result;
	}
	
	public void setTitle(String text){
		title.setText(text);
		revalidate();
		repaint();
	}
	
}

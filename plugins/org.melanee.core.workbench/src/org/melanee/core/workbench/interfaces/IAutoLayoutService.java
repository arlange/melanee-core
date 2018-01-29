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
package org.melanee.core.workbench.interfaces;

import org.eclipse.draw2d.geometry.Rectangle;


public interface IAutoLayoutService {
	/**
	 * Starts the auto layouting mechanism for a connection which is connected with the clabjects, which
	 * coordinates are stored in clabjectClientRectangles.
	 * 
	 * @param clabjectClientRectangles The coordinates of the connected clabjects
	 * @return the client rectangle for the layouted connection
	 */
	public Rectangle doLayout(Rectangle[] clabjectClientRectangles);
}

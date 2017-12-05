/*******************************************************************************
 * Copyright (c) 2011, 2012 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     - initial API and implementation and initial documentation
 *******************************************************************************/ 
package org.melanee.core.workbench.interfaces;



/**
 * Interface for textual domain-specific language support.
 *
 */
public interface ITextualVisualizationService extends IVisualizationServiceBase {
	
	/**
	 * Starts the creation of the textual editor.
	 * 
	 * @param host the IGraphicalEditPart on which the service is invoked
	 * @param notationChanged is the service invoked after a change of the notation 
	 * 			or to update the visualization without notation change
	 */
	public abstract void run(Object host, String notation, boolean notationChanged);
	
}

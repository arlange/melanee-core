/*******************************************************************************
 * Copyright (c) 2015 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Ralph Gerbig    - initial API and implementation and initial documentation
 *******************************************************************************/
package org.melanee.core.modeleditor.custom.wrappers;

import org.eclipse.core.runtime.Assert;
import org.melanee.core.modeleditor.edit.parts.Connection2EditPart;
import org.melanee.core.modeleditor.edit.parts.ConnectionEditPart;
import org.melanee.core.modeleditor.edit.parts.Entity2EditPart;
import org.melanee.core.modeleditor.edit.parts.EntityEditPart;

/**
 *
 * A wrapper to allow convenient access to common methods of
 * EntityEditPart, Entity2EditPart, ConnectionEditPart,
 * Connection2EditPart.
 *
 */
public class ClabjectEditPartWrapper {

	Object clabjectEditPart;
	
	/**
	 * 
	 * Creates a new instance of the wrapper with the 
	 * passed edit part
	 * 
	 * @param clabjectEditPart the editpart to wrap
	 */
	public ClabjectEditPartWrapper(Object clabjectEditPart){
		//Assert to wrap the right type only
		Assert.isTrue(clabjectEditPart instanceof Entity2EditPart
						|| clabjectEditPart instanceof EntityEditPart
						|| clabjectEditPart instanceof ConnectionEditPart
						|| clabjectEditPart instanceof Connection2EditPart);
		
		
		this.clabjectEditPart = clabjectEditPart;
	}
	
	/**
	 * Hands through the updateView() method
	 */
	public void updateView(String format){
		if(clabjectEditPart instanceof EntityEditPart)
			((EntityEditPart)clabjectEditPart).updateView(format);
		else if(clabjectEditPart instanceof Entity2EditPart)
			((Entity2EditPart)clabjectEditPart).updateView(format);
		else if(clabjectEditPart instanceof ConnectionEditPart)
			((ConnectionEditPart)clabjectEditPart).updateView(format);
		else if(clabjectEditPart instanceof Connection2EditPart)
			((Connection2EditPart)clabjectEditPart).updateView(format);
	}
}

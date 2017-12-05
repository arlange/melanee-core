/*
* *******************************************************************************
* Copyright (c) 2011 - 2015 University of Mannheim: Chair for Software Engineering
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
* 
* Contributors:
*      - initial API and implementation and initial documentation
* *******************************************************************************
*/
package org.melanee.core.modeleditor.navigator;

import org.eclipse.jface.viewers.ViewerSorter;
import org.melanee.core.modeleditor.part.PLMVisualIDRegistry;

/**
 * @generated
 */
public class PLMNavigatorSorter extends ViewerSorter {

	/**
	* @generated
	*/
	private static final int GROUP_CATEGORY = 7072;

	/**
	* @generated
	*/
	public int category(Object element) {
		if (element instanceof PLMNavigatorItem) {
			PLMNavigatorItem item = (PLMNavigatorItem) element;
			return PLMVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}

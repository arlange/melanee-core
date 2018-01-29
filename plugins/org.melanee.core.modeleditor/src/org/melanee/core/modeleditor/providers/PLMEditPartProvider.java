/*
 * *******************************************************************************
 * Copyright (c) 2011 - 2015 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Ralph Gerbig - initial API and implementation and initial documentation
 * *******************************************************************************
 */
package org.melanee.core.modeleditor.providers;

import org.eclipse.gmf.tooling.runtime.providers.DefaultEditPartProvider;
import org.melanee.core.modeleditor.edit.parts.DomainEditPart;
import org.melanee.core.modeleditor.edit.parts.PLMEditPartFactory;
import org.melanee.core.modeleditor.part.PLMVisualIDRegistry;

/**
 * @generated
 */
public class PLMEditPartProvider extends DefaultEditPartProvider {

	/**
	* @generated
	*/
	public PLMEditPartProvider() {
		super(new PLMEditPartFactory(), PLMVisualIDRegistry.TYPED_INSTANCE, DomainEditPart.MODEL_ID);
	}

}

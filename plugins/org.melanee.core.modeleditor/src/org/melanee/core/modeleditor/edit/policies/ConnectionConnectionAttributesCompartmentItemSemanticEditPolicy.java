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
package org.melanee.core.modeleditor.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.melanee.core.modeleditor.edit.commands.AttributeCreateCommand;
import org.melanee.core.modeleditor.providers.PLMElementTypes;

/**
 * @generated
 */
public class ConnectionConnectionAttributesCompartmentItemSemanticEditPolicy extends PLMBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public ConnectionConnectionAttributesCompartmentItemSemanticEditPolicy() {
		super(PLMElementTypes.Connection_3099);
	}

	/**
	* @generated
	*/
	protected Command getCreateCommand(CreateElementRequest req) {
		if (PLMElementTypes.Attribute_3100 == req.getElementType()) {
			return getGEFWrapper(new AttributeCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}

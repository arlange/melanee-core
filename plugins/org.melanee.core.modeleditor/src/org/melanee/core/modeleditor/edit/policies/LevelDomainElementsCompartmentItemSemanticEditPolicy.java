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
package org.melanee.core.modeleditor.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.melanee.core.modeleditor.edit.commands.ConnectionCreateCommand;
import org.melanee.core.modeleditor.edit.commands.Entity2CreateCommand;
import org.melanee.core.modeleditor.edit.commands.Inheritance2CreateCommand;
import org.melanee.core.modeleditor.edit.commands.PackageCreateCommand;
import org.melanee.core.modeleditor.providers.PLMElementTypes;

/**
 * @generated
 */
public class LevelDomainElementsCompartmentItemSemanticEditPolicy extends PLMBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public LevelDomainElementsCompartmentItemSemanticEditPolicy() {
		super(PLMElementTypes.Level_3097);
	}

	/**
	* @generated
	*/
	protected Command getCreateCommand(CreateElementRequest req) {
		if (PLMElementTypes.Connection_3099 == req.getElementType()) {
			return getGEFWrapper(new ConnectionCreateCommand(req));
		}
		if (PLMElementTypes.Inheritance_3122 == req.getElementType()) {
			return getGEFWrapper(new Inheritance2CreateCommand(req));
		}
		if (PLMElementTypes.Entity_3120 == req.getElementType()) {
			return getGEFWrapper(new Entity2CreateCommand(req));
		}
		if (PLMElementTypes.Package_3125 == req.getElementType()) {
			return getGEFWrapper(new PackageCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}

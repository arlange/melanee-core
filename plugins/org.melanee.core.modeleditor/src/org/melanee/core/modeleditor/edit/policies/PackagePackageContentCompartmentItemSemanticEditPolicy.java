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
import org.melanee.core.modeleditor.edit.commands.Connection3CreateCommand;
import org.melanee.core.modeleditor.edit.commands.Entity3CreateCommand;
import org.melanee.core.modeleditor.edit.commands.Inheritance3CreateCommand;
import org.melanee.core.modeleditor.edit.commands.Package2CreateCommand;
import org.melanee.core.modeleditor.providers.PLMElementTypes;

/**
 * @generated
 */
public class PackagePackageContentCompartmentItemSemanticEditPolicy
    extends PLMBaseItemSemanticEditPolicy {

  /**
   * @generated
   */
  public PackagePackageContentCompartmentItemSemanticEditPolicy() {
    super(PLMElementTypes.Package_3125);
  }

  /**
   * @generated
   */
  protected Command getCreateCommand(CreateElementRequest req) {
    if (PLMElementTypes.Entity_3126 == req.getElementType()) {
      return getGEFWrapper(new Entity3CreateCommand(req));
    }
    if (PLMElementTypes.Connection_3127 == req.getElementType()) {
      return getGEFWrapper(new Connection3CreateCommand(req));
    }
    if (PLMElementTypes.Inheritance_3128 == req.getElementType()) {
      return getGEFWrapper(new Inheritance3CreateCommand(req));
    }
    if (PLMElementTypes.Package_3129 == req.getElementType()) {
      return getGEFWrapper(new Package2CreateCommand(req));
    }
    return super.getCreateCommand(req);
  }

}

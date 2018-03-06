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
import org.melanee.core.modeleditor.edit.commands.Connection2CreateCommand;
import org.melanee.core.modeleditor.edit.commands.EntityCreateCommand;
import org.melanee.core.modeleditor.edit.commands.InheritanceCreateCommand;
import org.melanee.core.modeleditor.providers.PLMElementTypes;

/**
 * @generated
 */
public class ConnectionConnectionContentsCompartmentItemSemanticEditPolicy
    extends PLMBaseItemSemanticEditPolicy {

  /**
   * @generated
   */
  public ConnectionConnectionContentsCompartmentItemSemanticEditPolicy() {
    super(PLMElementTypes.Connection_3099);
  }

  /**
   * @generated
   */
  protected Command getCreateCommand(CreateElementRequest req) {
    if (PLMElementTypes.Entity_3105 == req.getElementType()) {
      return getGEFWrapper(new EntityCreateCommand(req));
    }
    if (PLMElementTypes.Connection_3111 == req.getElementType()) {
      return getGEFWrapper(new Connection2CreateCommand(req));
    }
    if (PLMElementTypes.Inheritance_3124 == req.getElementType()) {
      return getGEFWrapper(new InheritanceCreateCommand(req));
    }
    return super.getCreateCommand(req);
  }

}

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
import org.melanee.core.modeleditor.edit.commands.Attribute2CreateCommand;
import org.melanee.core.modeleditor.providers.PLMElementTypes;

/**
 * @generated
 */
public class EntityEntityAttributesCompartment2ItemSemanticEditPolicy
    extends PLMBaseItemSemanticEditPolicy {

  /**
   * @generated
   */
  public EntityEntityAttributesCompartment2ItemSemanticEditPolicy() {
    super(PLMElementTypes.Entity_3120);
  }

  /**
   * @generated
   */
  protected Command getCreateCommand(CreateElementRequest req) {
    if (PLMElementTypes.Attribute_3106 == req.getElementType()) {
      return getGEFWrapper(new Attribute2CreateCommand(req));
    }
    return super.getCreateCommand(req);
  }

}

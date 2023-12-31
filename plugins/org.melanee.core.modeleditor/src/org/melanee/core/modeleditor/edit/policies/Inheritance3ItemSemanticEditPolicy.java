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

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.melanee.core.modeleditor.edit.commands.SubtypeCreateCommand;
import org.melanee.core.modeleditor.edit.commands.SubtypeReorientCommand;
import org.melanee.core.modeleditor.edit.commands.SupertypeCreateCommand;
import org.melanee.core.modeleditor.edit.commands.SupertypeReorientCommand;
import org.melanee.core.modeleditor.edit.parts.SubtypeEditPart;
import org.melanee.core.modeleditor.edit.parts.SupertypeEditPart;
import org.melanee.core.modeleditor.part.PLMVisualIDRegistry;
import org.melanee.core.modeleditor.providers.PLMElementTypes;

/**
 * @generated
 */
public class Inheritance3ItemSemanticEditPolicy extends PLMBaseItemSemanticEditPolicy {

  /**
   * @generated
   */
  public Inheritance3ItemSemanticEditPolicy() {
    super(PLMElementTypes.Inheritance_3128);
  }

  /**
   * @generated
   */
  protected Command getDestroyElementCommand(DestroyElementRequest req) {
    View view = (View) getHost().getModel();
    CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(getEditingDomain(), null);
    cmd.setTransactionNestingEnabled(false);
    for (Iterator<?> it = view.getSourceEdges().iterator(); it.hasNext();) {
      Edge outgoingLink = (Edge) it.next();
      if (PLMVisualIDRegistry.getVisualID(outgoingLink) == SupertypeEditPart.VISUAL_ID) {
        DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
        cmd.add(new DestroyElementCommand(r));
        cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
        continue;
      }
      if (PLMVisualIDRegistry.getVisualID(outgoingLink) == SubtypeEditPart.VISUAL_ID) {
        DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
        cmd.add(new DestroyElementCommand(r));
        cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
        continue;
      }
    }
    EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
    if (annotation == null) {
      // there are indirectly referenced children, need extra commands: false
      addDestroyShortcutsCommand(cmd, view);
      // delete host element
      cmd.add(new DestroyElementCommand(req));
    } else {
      cmd.add(new DeleteCommand(getEditingDomain(), view));
    }
    return getGEFWrapper(cmd.reduce());
  }

  /**
   * @generated
   */
  protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
    Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req)
        : getCompleteCreateRelationshipCommand(req);
    return command != null ? command : super.getCreateRelationshipCommand(req);
  }

  /**
   * @generated
   */
  protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
    if (PLMElementTypes.Supertype_4034 == req.getElementType()) {
      return getGEFWrapper(new SupertypeCreateCommand(req, req.getSource(), req.getTarget()));
    }
    if (PLMElementTypes.Subtype_4035 == req.getElementType()) {
      return getGEFWrapper(new SubtypeCreateCommand(req, req.getSource(), req.getTarget()));
    }
    return null;
  }

  /**
   * @generated
   */
  protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
    if (PLMElementTypes.Supertype_4034 == req.getElementType()) {
      return null;
    }
    if (PLMElementTypes.Subtype_4035 == req.getElementType()) {
      return null;
    }
    return null;
  }

  /**
   * Returns command to reorient EClass based link. New link target or source
   * should be the domain model element associated with this node.
   * 
   * @generated
   */
  protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
    switch (getVisualID(req)) {
    case SupertypeEditPart.VISUAL_ID:
      return getGEFWrapper(new SupertypeReorientCommand(req));
    case SubtypeEditPart.VISUAL_ID:
      return getGEFWrapper(new SubtypeReorientCommand(req));
    }
    return super.getReorientRelationshipCommand(req);
  }

}

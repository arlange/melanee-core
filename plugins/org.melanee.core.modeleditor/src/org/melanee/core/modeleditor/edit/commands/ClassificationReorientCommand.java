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
package org.melanee.core.modeleditor.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.melanee.core.modeleditor.edit.policies.PLMBaseItemSemanticEditPolicy;
import org.melanee.core.models.plm.PLM.Clabject;
import org.melanee.core.models.plm.PLM.Classification;
import org.melanee.core.models.plm.PLM.Level;

/**
 * @generated
 */
public class ClassificationReorientCommand extends EditElementCommand {

  /**
   * @generated
   */
  private final int reorientDirection;

  /**
   * @generated
   */
  private final EObject oldEnd;

  /**
   * @generated
   */
  private final EObject newEnd;

  /**
   * @generated
   */
  public ClassificationReorientCommand(ReorientRelationshipRequest request) {
    super(request.getLabel(), request.getRelationship(), request);
    reorientDirection = request.getDirection();
    oldEnd = request.getOldRelationshipEnd();
    newEnd = request.getNewRelationshipEnd();
  }

  /**
   * @generated
   */
  public boolean canExecute() {
    if (false == getElementToEdit() instanceof Classification) {
      return false;
    }
    if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
      return canReorientSource();
    }
    if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
      return canReorientTarget();
    }
    return false;
  }

  /**
   * @generated
   */
  protected boolean canReorientSource() {
    if (!(oldEnd instanceof Clabject && newEnd instanceof Clabject)) {
      return false;
    }
    Clabject target = getLink().getType();
    if (!(getLink().eContainer() instanceof Level)) {
      return false;
    }
    Level container = (Level) getLink().eContainer();
    return PLMBaseItemSemanticEditPolicy.getLinkConstraints().canExistClassification_4026(container,
        getLink(), getNewSource(), target);
  }

  /**
   * @generated
   */
  protected boolean canReorientTarget() {
    if (!(oldEnd instanceof Clabject && newEnd instanceof Clabject)) {
      return false;
    }
    Clabject source = getLink().getInstance();
    if (!(getLink().eContainer() instanceof Level)) {
      return false;
    }
    Level container = (Level) getLink().eContainer();
    return PLMBaseItemSemanticEditPolicy.getLinkConstraints().canExistClassification_4026(container,
        getLink(), source, getNewTarget());
  }

  /**
   * @generated
   */
  protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
      throws ExecutionException {
    if (!canExecute()) {
      throw new ExecutionException("Invalid arguments in reorient link command"); //$NON-NLS-1$
    }
    if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
      return reorientSource();
    }
    if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
      return reorientTarget();
    }
    throw new IllegalStateException();
  }

  /**
   * @generated
   */
  protected CommandResult reorientSource() throws ExecutionException {
    getLink().setInstance(getNewSource());
    return CommandResult.newOKCommandResult(getLink());
  }

  /**
   * @generated
   */
  protected CommandResult reorientTarget() throws ExecutionException {
    getLink().setType(getNewTarget());
    return CommandResult.newOKCommandResult(getLink());
  }

  /**
   * @generated
   */
  protected Classification getLink() {
    return (Classification) getElementToEdit();
  }

  /**
   * @generated
   */
  protected Clabject getOldSource() {
    return (Clabject) oldEnd;
  }

  /**
   * @generated
   */
  protected Clabject getNewSource() {
    return (Clabject) newEnd;
  }

  /**
   * @generated
   */
  protected Clabject getOldTarget() {
    return (Clabject) oldEnd;
  }

  /**
   * @generated
   */
  protected Clabject getNewTarget() {
    return (Clabject) newEnd;
  }
}

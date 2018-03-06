/*******************************************************************************
 * Copyright (c) 2012 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Ralph Gerbig - initial API and implementation and initial documentation
 *******************************************************************************/
package org.melanee.core.emendation.service.commands;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.PlatformUI;
import org.melanee.core.emendation.service.dialogs.EmendMoveAttributeDialog;
import org.melanee.core.models.plm.PLM.Clabject;
import org.melanee.core.models.plm.PLM.Feature;
import org.melanee.core.workbench.interfaces.IEmendationService.IImpactAnalyzer;

public class EmendMoveAttributeCommandFactory {

  private Set<EObject> emendedObjects = new HashSet<EObject>();
  private final IImpactAnalyzer impactAnalyzer;
  private final Clabject source;
  private final Clabject target;
  private final Feature movedFeature;

  public Set<EObject> getEmendedObjects() {
    return emendedObjects;
  }

  public EmendMoveAttributeCommandFactory(IImpactAnalyzer impactAnalyzer, Clabject source,
      Clabject target, Feature movedFeature) {
    this.impactAnalyzer = impactAnalyzer;
    this.source = source;
    this.target = target;
    this.movedFeature = movedFeature;
  }

  public CompoundCommand run() {
    try {
      EmendMoveAttributeDialog dialog = showMoveModelElementDialog();

      if (dialog == null)
        return null;

      return runEmendation();
    } catch (ExecutionException e) {
      e.printStackTrace();
    }

    return null;
  }

  protected EmendMoveAttributeDialog showMoveModelElementDialog() throws ExecutionException {
    EmendMoveAttributeDialog dialog = new EmendMoveAttributeDialog(
        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());

    if (dialog.open() == Window.OK)
      return dialog;
    else
      return null;
  }

  /**
   * 
   * @param changeOrigin
   *          The element on which the original change operation has been
   *          performed
   * @param traitToChange
   *          The EAttribut in the meta-model to change
   * @param newValue
   *          can bee needed because if emendation request comes from UI it can be
   *          already changed in the feature
   * @param newValue
   *          the new value to set
   * @param changeOntologicalTypes
   *          change ontological types?
   * @param changeSubtypes
   *          change subtypes?
   * @param changeSuperTypes
   *          change supertypes?
   * @return
   */
  protected CompoundCommand runEmendation() {
    // Set<Clabject> emendedElements = new
    // ImpactAnalyzer().getAffectedModelElementsForAddFeatureOperation(changeOrigin);
    // //(Set<Clabject>)new
    // ImpactAnalyzer().calculateImpactOfChange((Clabject)changeOrigin,
    // traitToChange, changeOntologicalTypes, changeSubtypes, changeSuperTypes);

    CompoundCommand emendationCommand = new CompoundCommand("Emendation move feature "
        + movedFeature.getName() + " from " + source.getName() + " to " + target.getName());

    EmendRemoveAttributeCommandFactory removeAttributeCommand = new EmendRemoveAttributeCommandFactory(
        impactAnalyzer, source, movedFeature);
    Command cmd = removeAttributeCommand.run(
        impactAnalyzer.getAffectedModelElementsForAddFeatureOperation(target, movedFeature, true));
    if (cmd != null)
      emendationCommand.append(cmd);
    EmendAddAttributeCommandFactory addAttributeCommand = new EmendAddAttributeCommandFactory(
        impactAnalyzer, target, movedFeature);
    emendationCommand.append(addAttributeCommand.run());

    emendedObjects.addAll(removeAttributeCommand.getEmendedObjects());
    emendedObjects.addAll(addAttributeCommand.getEmendedObjects());

    return emendationCommand;
  }
}
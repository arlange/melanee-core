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

import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.PlatformUI;
import org.melanee.core.emendation.service.BasicImpactAnalyzer;
import org.melanee.core.emendation.service.dialogs.EmendChangeTraitDialog;
import org.melanee.core.models.plm.PLM.Feature;
import org.melanee.core.models.plm.PLM.PLMPackage;
import org.melanee.core.workbench.interfaces.IEmendationService.IImpactAnalyzer;

public class EmendChangeFeatureTraitCommandFactory {

  Set<Feature> emendedElements;
  private final IImpactAnalyzer impactAnalyzer;
  private final Feature changeOrigin;
  private final EStructuralFeature traitToChange;
  private final String oldValue;
  private final String newValue;

  public Set<Feature> getEmendedObjects() {
    return emendedElements;
  }

  public EmendChangeFeatureTraitCommandFactory(IImpactAnalyzer impactAnalyzer, Feature changeOrigin,
      EStructuralFeature traitToChange, String oldValue, String newValue) {
    this.impactAnalyzer = impactAnalyzer;
    this.changeOrigin = changeOrigin;
    this.traitToChange = traitToChange;
    this.oldValue = oldValue;
    this.newValue = newValue;
  }

  public CompoundCommand run() {
    try {
      EmendChangeTraitDialog dialog = showChangeValueDialog(newValue, oldValue, changeOrigin);

      if (dialog == null)
        return null;

      return runEmendation();
    } catch (ExecutionException e) {
      e.printStackTrace();
    }

    return null;
  }

  protected EmendChangeTraitDialog showChangeValueDialog(String valueToDisplayValue,
      String oldValue, Feature changeOrigin) throws ExecutionException {
    EmendChangeTraitDialog dialog = new EmendChangeTraitDialog(
        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), valueToDisplayValue,
        EmendChangeTraitDialog.FEATURE);

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
    emendedElements = impactAnalyzer.getAffectedModelElementsForChangeTraitFeatureOperation(
        changeOrigin, oldValue, traitToChange);

    CompoundCommand emendationCommand = new CompoundCommand(
        "Emendation - " + traitToChange.getName() + " - " + changeOrigin.getName());
    TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(changeOrigin);

    for (Feature element : emendedElements)
      if (traitToChange.getEType().getName().equals("EInt")) {
        int computedValue = (Integer) computeNewValue(changeOrigin, element, newValue,
            traitToChange);
        emendationCommand.append(SetCommand.create(domain, element, traitToChange, computedValue));
      } else
        emendationCommand.append(SetCommand.create(domain, element, traitToChange,
            computeNewValue(changeOrigin, element, newValue, traitToChange)));

    // domain.getCommandStack().execute(emendationCommand);

    // For mutability 0 we need to change the value
    // if (traitToChange.getName().equals("mutability")){
    // emendationCommand = new CompoundCommand("Emendation (Value) - " +
    // traitToChange.getName() + " - " + changeOrigin.getName());
    //
    // for (Feature element : emendedElements){
    // //For mutability 0 we need to change the value
    // if (((Attribute)element).getMutability() == 0){
    //
    // try {
    // String validValue = (String)OCLHelper.execute(element,
    // "let allDirectSupertypes:OrderedSet(Clabject) = " +
    // "
    // self.getClabject().getModelSupertypes()->union(OrderedSet{self.getClabject()}).getModelDirectTypes()->asOrderedSet()
    // " +
    // "in " +
    // "if (allDirectSupertypes->size() = 0) then " +
    // " self.value " +
    // "else " +
    // " let typeLevelFeature:Attribute = " +
    // " allDirectSupertypes.getAllFeatures()->select(f | f.name = self.name and
    // f.oclIsTypeOf(Attribute))->first().oclAsType(Attribute) " +
    // " in " +
    // " let typeLevelMutability:Integer = " +
    // " typeLevelFeature.mutability " +
    // " in " +
    // " if typeLevelMutability = 0 then " +
    // " typeLevelFeature.value" +
    // " else " +
    // " self.value " +
    // " endif " +
    // "endif"
    // );
    //
    // if ( (validValue != null && (((Attribute)element).getValue() == null))
    // || ((((Attribute)element).getValue() != null &&
    // !((Attribute)element).getValue().equals(validValue)))
    // ){
    // emendationCommand.append(SetCommand.create(domain, element,
    // PLMPackage.eINSTANCE.getAttribute_Value(), validValue));
    // domain.getCommandStack().execute(emendationCommand);
    // emendationCommand = new CompoundCommand("Emendation (Value) - " +
    // traitToChange.getName() + " - " + changeOrigin.getName());
    // }
    //
    // } catch (ParserException e) {
    // e.printStackTrace();
    // }
    // }
    // }
    // }

    return emendationCommand;
  }

  protected Object computeNewValue(Feature changeOrigin, Feature machtingElement, String newValue,
      EStructuralFeature traitToChange) {
    if (isPotencyValue(traitToChange) && Integer.parseInt(newValue) > 0) {
      int changeOriginLevel = ((Feature) changeOrigin).getClabject().getLevelIndex();
      int matchingFeatureLevel = ((Feature) machtingElement).getClabject().getLevelIndex();
      int levelDistance = changeOriginLevel - matchingFeatureLevel;
      return Integer.parseInt(newValue) + levelDistance;

    } else if (isPotencyValue(traitToChange) && Integer.parseInt(newValue) == -1)
      return Integer.parseInt(newValue);
    else if (isPotencyValue(traitToChange) && Integer.parseInt(newValue) == 0) {
      int changeOriginLevel = ((Feature) changeOrigin).getClabject().getLevelIndex();
      int matchingFeatureLevel = ((Feature) machtingElement).getClabject().getLevelIndex();
      int levelDistance = changeOriginLevel - matchingFeatureLevel;
      int computedValue = Integer.parseInt(newValue) + levelDistance;

      return computedValue > 0 ? computedValue : 0;
    }

    return newValue;
  }

  protected boolean isPotencyValue(EStructuralFeature traitToChange) {
    return traitToChange == PLMPackage.eINSTANCE.getFeature_Durability()
        || traitToChange == PLMPackage.eINSTANCE.getAttribute_Mutability();
  }
}
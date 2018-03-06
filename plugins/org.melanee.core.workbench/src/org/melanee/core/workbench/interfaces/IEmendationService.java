/*******************************************************************************
 * Copyright (c) 2011, 2012 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Ralph Gerbig - initial API and implementation and initial documentation
 *******************************************************************************/
package org.melanee.core.workbench.interfaces;

import java.util.Set;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.melanee.core.models.plm.PLM.Clabject;
import org.melanee.core.models.plm.PLM.Feature;

/**
 * Interface for refactoring extension point.
 *
 */
public interface IEmendationService {

  /**
   * Retruns the ImpactAnalyzer which is shipped with this emendation service.
   * 
   * @return An instance of the impact analyzer
   */
  public IImpactAnalyzer getImpactAnalyzer();

  /**
   * Creates an emendation command which supports the move of an attribute from
   * one Clabject to an other Clabject
   * 
   * @param source
   *          Clabject where attribute is moved from
   * @param target
   *          Clabject where attribute is moved to
   * @param movedFeature
   *          Attribute which is moved
   * @return Complete emendation command for the move operation; null if the
   *         operation is cancelled or no changes are required
   */
  public Command handleMoveAttributeOperation(Clabject source, Clabject target,
      Feature movedFeature);

  /**
   * Creates an emendation command which handles the removal of an attribute from
   * a Clabject
   * 
   * @param changeOrigin
   *          Clabject from which attribute is deleted
   * @param featureToDelete
   *          Attribute which is deleted
   * @return Complete emendation command for the delete operation; null if the
   *         operation is cancelled or no changes are required
   */
  public Command handleRemoveAttributeOperation(Clabject changeOrigin, Feature featureToDelete);

  /**
   * Creates an emenadation command which handles the addition of an attribute to
   * a Clabject.
   * 
   * @param changeOrigin
   *          Clabject to which the attribute is added
   * @param addedFeature
   *          Attribute which is added to Clabject
   * @return Complete emendation command for the add operation; null if the
   *         operation is cancelled or no changes are required
   */
  public Command handleAddAttributeOperation(Clabject changeOrigin, Feature addedFeature);

  /**
   * Creates an emendation command which handles the emendation of a trait (e.g.
   * durability, name) to a feature
   * 
   * @param changeOrigin
   *          Feature which owns the changed trait
   * @param traitToChange
   *          Trait which is changed
   * @param oldValue
   *          Old trait value
   * @param newValue
   *          New trait value
   * @return Complete emendation command for the change operation; null if the
   *         operation is cancelled or no changes are required
   */
  public Command handleChangeFeatureTraitOperation(Feature changeOrigin,
      EStructuralFeature traitToChange, String oldValue, String newValue);

  /**
   * Creates an emendation command which handles the emendation of a trait (e.g.
   * potency) of a Clabject
   * 
   * @param changeOrigin
   *          Clabject which owns the changed trait
   * @param traitToChange
   *          Trait which is changed
   * @param oldValue
   *          Old trait value
   * @param newValue
   *          New trait value
   * @return Complete emendation command which handles the change operation; null
   *         if the operation is cancelled or no changes are required
   */
  public Command handleChangeClabjectTraitOpertation(Clabject changeOrigin,
      EStructuralFeature traitToChange, String oldValue, String newValue);

  /**
   * Returns the emended clabjects by one command.
   * 
   * @param command
   *          Command to get list of emended clabjects for
   * @return The list of emended clabjects
   */
  public Set<EObject> getEmendedObjects(Command command);

  public interface IImpactAnalyzer {
    /**
     * 
     * Collects all model elements affected by a feature move operation. This is the
     * union of remove feature at sourceChangeOrigin and add feature at
     * targetChangeOrigin
     * 
     * @param sourceChangeOrigin
     *          Clabject from which the feature is moved away
     * @param targetChangeOrigin
     *          Clabject to which the feature is moved to
     * @param movedFeature
     *          The feature which is moved
     * @return The union of remove feature on source and add feature on target
     */
    public Set<EObject> getAffectedModelElementsForMoveFeatureOperation(Clabject sourceChangeOrigin,
        Clabject targetChangeOrigin, Feature movedFeature);

    /**
     * Collects the impact of adding a feature to a clabject. This does not include
     * clabjects which do already contain a feature with the name of the added
     * feature.
     * 
     * @param changeOrigin
     *          Clabject to which the feature is added to
     * @param addedFeature
     *          Feature which is added
     * @return The list of clabjects to which the feature needs to be added
     */
    public Set<Clabject> getAffectedModelElementsForAddFeatureOperation(Clabject changeOrigin,
        Feature addedFeature);

    /**
     * Collects the impact of adding a feature to a clabject. The user can choose
     * whether to include clabjects which do already contain a feature with the name
     * of the added feature.
     * 
     * @param changeOrigin
     *          changeOrigin Clabject to which the feature is added to
     * @param addedFeature
     *          Feature which is added
     * @param includeDuplicates
     *          Whether to include clabjects already containing a feature with the
     *          name of the added feature
     * @return The list of clabjects to which the feature needs to be added.
     *         Depending on the user's choice this can contain clabjects which
     *         already contain a clabject with a feature that has the same name as
     *         the feature to be added
     */
    public Set<Clabject> getAffectedModelElementsForAddFeatureOperation(Clabject changeOrigin,
        Feature addedFeature, boolean includeDuplicates);

    /**
     * Collects the impact of adding a feature to a clabject. The user can choose
     * whether to include clabjects which do already contain a feature with the name
     * of the added feature. Can include the supertypes only. This is useful in
     * cases where the new feature shall not be added to an subtype in an
     * inheritance hierarchy but to the supertype of each inheritance hierarchy.
     * 
     * @param changeOrigin
     *          changeOrigin Clabject to which the feature is added to
     * @param addedFeature
     *          Feature which is added
     * @param includeDuplicates
     *          Whether to include clabjects already containing a feature with the
     *          name of the added feature
     * @param addedFeatureName
     *          The name of the added feature. In some cases this is null in the
     *          addedFeature parameter but known e.g. when called from
     *          EmendAddAttributCommand
     * @param includeSuperTypesOnly
     *          returns only the supertypes of inheritance hierarchies.
     * @return The list of clabjects to which the feature needs to be added.
     *         Depending on the user's choice this can contain clabjects which
     *         already contain a clabject with a feature that has the same name as
     *         the feature to be added
     */
    public Set<Clabject> getAffectedModelElementsForAddFeatureOperation(Clabject changeOrigin,
        Feature addedFeature, String addedFeatureName, boolean includeDuplicates,
        boolean includeSuperTypesOnly, boolean includeOntologicalTypes,
        boolean includeOntologicalInstances);

    /**
     * Collects the impact of a remove feature operation. All features which need to
     * be removed after the feature changeOrigin is deleted are collected.
     * 
     * @param changeOrigin
     *          The feature that is about to be deleted from the model
     * @param changeOriginContainingClabject
     *          The clabject which contains the feature that is about to be deleted
     * @return All features that need to be deleted after changeOrigin is deleted
     */
    public Set<Feature> getAffectedModelElementsForDeleteFeatureOperation(Feature changeOrigin,
        Clabject changeOriginContainingClabject);

    /**
     * Calculates the impact of changes to traits of Features. All features which
     * are affected by a change to the trait changeOrigin are calculated.
     * 
     * @param changeOrigin
     *          The changed clabject
     * @param oldValue
     *          The value before the change
     * @param changedTrait
     *          The change trait.
     * 
     * @return A list with all features that need to be changed after changing
     *         changeOrigin
     */
    public Set<Feature> getAffectedModelElementsForChangeTraitFeatureOperation(Feature changeOrigin,
        String oldValue, EStructuralFeature changedTrait);

    /**
     * Calculates the impact of a change to a clabject's trait.
     * 
     * @param changeOrigin
     *          The modified clabject
     * @param oldValue
     *          The value before modification
     * @param changedTrait
     *          The trait which has been modified
     * @param includeNonShallowInheritance
     *          Whether to change the potency for non shallow super-/subtypes
     * @return All clabjects that need to be changed after modifying changeOrigin
     */
    public Set<Clabject> getAffectedModelElementsForChangeTraitClabjectOperation(
        Clabject changeOrigin, String oldValue, EStructuralFeature changedTrait,
        boolean includeNonShallowInheritance);
  }

  /**
   * Pauses the emendation service until resume is called
   */
  public void pause();

  /**
   * Resumes the emendation service after it was paused
   */
  public void resume();

  /**
   * Checks if the emendation service is paused
   * 
   * @return
   */
  public boolean isPaused();
}
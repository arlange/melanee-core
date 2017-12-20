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
package org.melanee.core.emendation.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.melanee.core.models.plm.PLM.Attribute;
import org.melanee.core.models.plm.PLM.Clabject;
import org.melanee.core.models.plm.PLM.Feature;
import org.melanee.core.models.plm.PLM.PLMPackage;
import org.melanee.core.workbench.interfaces.IEmendationService.IImpactAnalyzer;

/**
 * Analyzes the impact of changes to a model. All model elements that need to be
 * fixed after a change are calculated by this service. This service is the foundation
 * for the implementation of all emendation service commands.
 * 
 * <b>
 * 	The result of all search operations is not allowed to contain the origin of
 *  the impact calculation. This will break the emendation service otherwise.
 * </b>
 *
 */
public class BasicImpactAnalyzer implements IImpactAnalyzer{
	
	/**
	 * 
	 * Collects all model elements affected by a feature move operation. This is the union of
	 * remove feature at sourceChangeOrigin and add feature at targetChangeOrigin
	 * 
	 * @param sourceChangeOrigin Clabject from which the feature is moved away
	 * @param targetChangeOrigin Clabject to which the feature is moved to
	 * @param movedFeature The feature which is moved
	 * @return The union of remove feature on source and add feature on target
	 */
	@Override
	public Set<EObject> getAffectedModelElementsForMoveFeatureOperation(Clabject sourceChangeOrigin, Clabject targetChangeOrigin, Feature movedFeature){
		Set<EObject> result = new HashSet<EObject>();
		
		result.addAll(getAffectedModelElementsForDeleteFeatureOperation(movedFeature, sourceChangeOrigin));
		result.addAll(getAffectedModelElementsForAddFeatureOperation(targetChangeOrigin, movedFeature));
		return result;
	}
	
	/**
	 * Collects the impact of adding a feature to a clabject. This does not include clabjects which
	 * do already contain a feature with the name of the added feature.
	 * 
	 * @param changeOrigin Clabject to which the feature is added to
	 * @param addedFeature Feature which is added
	 * @return The list of clabjects to which the feature needs to be added
	 */
	@Override
	public Set<Clabject> getAffectedModelElementsForAddFeatureOperation(Clabject changeOrigin, Feature addedFeature){
		return getAffectedModelElementsForAddFeatureOperation(changeOrigin, addedFeature, false);
	}

	
	/**
	 * Collects the impact of adding a feature to a clabject. The user can choose whether to include clabjects which
	 * do already contain a feature with the name of the added feature.
	 * 
	 * @param changeOrigin changeOrigin Clabject to which the feature is added to
	 * @param addedFeature Feature which is added
	 * @param includeDuplicates Whether to include clabjects already containing a feature with the name of the added feature
	 * @return The list of clabjects to which the feature needs to be added. Depending on the user's choice this can contain
	 * 			clabjects which already contain a clabject with a feature that has the same name as the feature to be added
	 */
	@Override
	public Set<Clabject> getAffectedModelElementsForAddFeatureOperation(Clabject changeOrigin, Feature addedFeature, boolean includeDuplicates){
		return getAffectedModelElementsForAddFeatureOperation(changeOrigin, addedFeature, addedFeature.getName(), includeDuplicates, false, true, true);
	}
	
	/**
	 * Collects the impact of adding a feature to a clabject. The user can choose whether to include clabjects which
	 * do already contain a feature with the name of the added feature. Can include the supertypes only. This is useful
	 * in cases where the new feature shall not be added to an subtype in an inheritance hierarchy but to the supertype
	 * of each inheritance hierarchy.
	 * 
	 * @param changeOrigin changeOrigin Clabject to which the feature is added to
	 * @param addedFeature Feature which is added
	 * @param includeDuplicates Whether to include clabjects already containing a feature with the name of the added feature
	 * @param addedFeatureName The name of the added feature. In some cases this is null in the addedFeature parameter but known
	 * 			e.g. when called from EmendAddAttributCommand
	 * @param includeSuperTypesOnly returns only the supertypes of inheritance hierarchies.
	 * @return The list of clabjects to which the feature needs to be added. Depending on the user's choice this can contain
	 * 			clabjects which already contain a clabject with a feature that has the same name as the feature to be added
	 */
	@Override
	public Set<Clabject> getAffectedModelElementsForAddFeatureOperation(Clabject changeOrigin, Feature addedFeature, String addedFeatureName, 
			boolean includeDuplicates, boolean includeSuperTypesOnly, boolean includeOntologicalTypes, boolean includeOntologicalInstances){
		Set<Clabject> result = new HashSet<Clabject>();

		Set<Clabject> currentLevel = new HashSet<Clabject>();
		
		if (!includeSuperTypesOnly)
			currentLevel.add(changeOrigin);
		else
			//Change origin is root of the inheritance hierarchy
			if (changeOrigin.getSupertypes().size() == 0)
				currentLevel.add(changeOrigin);
			else
				//Search the root of the inheritance hierarchy
				for(Clabject c : changeOrigin.getSupertypes())
					if (c.getSupertypes().size() == 0)
						currentLevel.add(c);
		
		if (includeOntologicalTypes)
			result.addAll(searchLevelForAddFeatureTypeDirection(currentLevel, includeSuperTypesOnly));
		
		result.addAll(currentLevel);
		
		if (includeOntologicalInstances)
			result.addAll(searchLevelForAddFeatureInstanceDirection(result, includeSuperTypesOnly));
		
		result.remove(changeOrigin);
		
		if(!includeDuplicates){
			Set<Clabject> clabjectsAlreadyContainingFeature = new HashSet<Clabject>();
			//Filter out all results that have already the added attribute
			for (Clabject c : result)
				for (Feature f : c.getFeature())
					if (f.getName() != null && f.getName().equals(addedFeatureName))
						clabjectsAlreadyContainingFeature.add(c);
			
			result.removeAll(clabjectsAlreadyContainingFeature);
		}
		return result;
	}
	
	/**
	 * Recursive method to search for clabjects which need the new feature to be added starting
	 * from the list of clabjects contained in clabjects. Moves upwards in the classification
	 * hierarchy. 
	 * 
	 * @param clabjects List of clabjects to start recursion from 
	 * @return clabjects that need the feature to be added
	 */
	private Set<Clabject> searchLevelForAddFeatureTypeDirection(Set<Clabject> clabjects, boolean includeSuperTypesOnly){
		Set<Clabject> result = new HashSet<Clabject>();
		Set<Clabject> directTypes = new HashSet<Clabject>();
		
		for(Clabject c : clabjects){
			//If we add an attribute to an clabject only this attribute is affected on the same level
			//all subtypes get inherited the attribute by this clabject
			directTypes.addAll(c.getTypes());
		
			//On the next level only the direct instances of the change origin and
			//its subtypes are relevant. The subtypes of these do automatically get
			//inherited the attribute
			for(Clabject subType : c.getSubtypes())
				directTypes.addAll(subType.getTypes());
			
			result.addAll(directTypes);
			
			
			result.addAll(searchLevelForAddFeatureTypeDirection(directTypes, includeSuperTypesOnly));
		}
		
		//We can take this result if we do not want to have the supertypes only
		if (!includeSuperTypesOnly)
			return result;
		
		//if we only want to have the supertypes in the inheritance hierarchy,
		//we need to search for clabjects with getModelSupertypes()->size = 0
		Set<Clabject> inheritanceRootResult = new HashSet<Clabject>();
		
		for (Clabject c : result)
			if (c.getSupertypes().size() == 0)
				inheritanceRootResult.add(c);
			else
				for (Clabject superType : c.getSupertypes())
					if (superType.getSupertypes().size() == 0)
						inheritanceRootResult.add(superType);
		
		return inheritanceRootResult;
	}
	
	/**
	 * Recursive method to search for clabjects which need the new feature to be added starting
	 * from the list of clabjects contained in clabjects. Moves downwards in the classification
	 * hierarchy. 
	 * 
	 * @param clabjects List of clabjects to start recursion from 
	 * @return clabjects that need the feature to be added
	 */
	Set<Clabject> searchLevelForAddFeatureInstanceDirection(Set<Clabject> clabjects, boolean includeSuperTypesOnly){
		Set<Clabject> result = new HashSet<Clabject>();
		Set<Clabject> directInstances = new HashSet<Clabject>();
		
		for(Clabject c : clabjects){
			//If we add an attribute to an clabject only this attribute is affected on the same level
			//all subtypes get inherited the attribute by this clabject
			directInstances.addAll(c.getInstances());
		
			//On the next level only the direct instances of the change origin and
			//its subtypes are relevant. The subtypes of these do automatically get
			//inherited the attribute
			for(Clabject subType : c.getSubtypes())
				directInstances.addAll(subType.getInstances());
			
			result.addAll(directInstances);
			result.addAll(searchLevelForAddFeatureInstanceDirection(directInstances, includeSuperTypesOnly));
		}
		
		//We can take this result if we do not want to have the supertypes only
		if (!includeSuperTypesOnly)
			return result;
		
		//if we only want to have the supertypes in the inheritance hierarchy,
		//we need to search for clabjects with getModelSupertypes()->size = 0
		Set<Clabject> inheritanceRootResult = new HashSet<Clabject>();
		
		for (Clabject c : result)
			if (c.getSupertypes().size() == 0)
				inheritanceRootResult.add(c);
			else
				for (Clabject superType : c.getSupertypes())
					if (superType.getSupertypes().size() == 0)
						inheritanceRootResult.add(superType);
		
		return inheritanceRootResult;
	}
	
	
	/**
	 * Collects the impact of a remove feature operation. All features which need to be removed after
	 * the feature changeOrigin is deleted are collected.
	 * 
	 * @param changeOrigin The feature that is about to be deleted from the model
	 * @param changeOriginContainingClabject The clabject which contains the feature that is about to be deleted
	 * @return All features that need to be deleted after changeOrigin is deleted
	 */
	@Override
	public Set<Feature> getAffectedModelElementsForDeleteFeatureOperation(Feature changeOrigin, Clabject changeOriginContainingClabject){
		
		Set<Feature> result = new HashSet<Feature>();
		
		boolean overridden = false;
		
		//containingClabject.getAllFeatures() works here because this clabject does not contain
		//the feature at this point of time anymore
		for (Feature f :changeOriginContainingClabject.getAllFeatures())
			if(match(changeOrigin, changeOriginContainingClabject, f, PLMPackage.eINSTANCE.getElement_Name(), changeOrigin.getName())){
				overridden = true;
				break;
			}
		
		//If overridden then nothing needs to be done just delete the overriding 
		if (overridden)
			return result;

		Set<Feature> currentLevel = new HashSet<Feature>();
		currentLevel.add(changeOrigin);
		result.addAll(searchLevelForRemoveFeatureTypeDirection(currentLevel, changeOriginContainingClabject, changeOrigin));
		result.addAll(currentLevel);
		result.addAll(searchLevelForRemoveFeatureInstanceDirection(result, changeOriginContainingClabject, changeOrigin));
		result.removeAll(currentLevel);
		
		return result;
	}
	
	/**
	 * Searches for all features that need to be removed after removing the feature stored in changeOrigin.
	 * Searches the upwards in the classification hierarchy.
	 * 
	 * @param features List of features to start recursion from
	 * @param changeOriginContaining Clabject which contains the impact analysis triggering feature
	 * @param changeOrigin The feature for which the impact analysis was initially triggered
	 * @return Returns a list with features that need to be deleted after deleting change origin
	 */
	Set<Feature> searchLevelForRemoveFeatureTypeDirection(Set<Feature> features, Clabject changeOriginContaining, Feature changeOrigin){
		Set<Feature> result = new HashSet<Feature>();
		Set<Clabject> allTypes = new HashSet<Clabject>();
		Set<Feature> allTypesFeatures = new HashSet<Feature>();
		
		for(Feature f : features){
			
			
			Clabject thisFeatureContainingClabject = null;
			
			if (
				//This happens on move. Feature has move target as owner
				(f == changeOrigin && f.getClabject() != changeOrigin) 
					//Happens for origin on delete
					|| f.getClabject() == null)
				thisFeatureContainingClabject = changeOriginContaining;
			else
				thisFeatureContainingClabject = f.getClabject();
			
			//If we add an attribute to an clabject only this attribute is affected on the same level
			//all subtypes get inherited the attribute by this clabject
			allTypes.addAll(thisFeatureContainingClabject.getLevelTypes());
		
			//On the next level only the direct instances of the change origin and
			//its subtypes are relevant. The subtypes of these do automatically get
			//inherited the attribute
			for(Clabject subType : thisFeatureContainingClabject.getSubtypes())
				allTypes.addAll(subType.getLevelTypes());
			
			//after collecting the clabjects we must search for the conforming features
			for(Clabject c : allTypes)
				for (Feature containedFeature : c.getFeature())
					if (match(f, thisFeatureContainingClabject, containedFeature, PLMPackage.eINSTANCE.getElement_Name(), f.getName()))
						allTypesFeatures.add(containedFeature);
			
			result.addAll(allTypesFeatures);
			result.addAll(searchLevelForRemoveFeatureTypeDirection(allTypesFeatures, changeOriginContaining, changeOrigin));
		}
		
		return result;
	}
	
	/**
	 * Searches for all features that need to be removed after removing the feature stored in changeOrigin.
	 * Searches the downwards in the classification hierarchy.
	 * 
	 * @param features List of features to start recursion from
	 * @param changeOriginContaining Clabject which contains the impact analysis triggering feature
	 * @param changeOrigin The feature for which the impact analysis was initially triggered
	 * @return Returns a list with features that need to be deleted after deleting change origin
	 */
	Set<Feature> searchLevelForRemoveFeatureInstanceDirection(Set<Feature> features, Clabject changeOriginContaining, Feature changeOrigin){
		Set<Feature> result = new HashSet<Feature>();
		Set<Clabject> allInstances = new HashSet<Clabject>();
		Set<Feature> allInstancesFeatures = new HashSet<Feature>();
		
		for(Feature f : features){
			
			Clabject thisFeatureContainingClabject = null;
			
			if (
				//This happens on move. Feature has move target as owner
				(f == changeOrigin && f.getClabject() != changeOrigin) 
					//Happens for origin on delete
					|| f.getClabject() == null)
				thisFeatureContainingClabject = changeOriginContaining;
			else
				thisFeatureContainingClabject = f.getClabject();
			
			//If we add an attribute to an clabject only this attribute is affected on the same level
			//all subtypes get inherited the attribute by this clabject
			allInstances.addAll(thisFeatureContainingClabject.getInstances());
		
			//On the next level only the direct instances of the change origin and
			//its subtypes are relevant. The subtypes of these do automatically get
			//inherited the attribute
			for(Clabject subType : thisFeatureContainingClabject.getSubtypes())
				allInstances.addAll(subType.getInstances());
			
			//after collecting the clabjects we must search for the conforming features
			for(Clabject c : allInstances)
				for (Feature containedFeature : c.getFeature())
					if (match(f, thisFeatureContainingClabject, containedFeature, PLMPackage.eINSTANCE.getElement_Name(), f.getName()))
						allInstancesFeatures.add(containedFeature);
			
			result.addAll(allInstancesFeatures);
			result.addAll(searchLevelForRemoveFeatureInstanceDirection(allInstancesFeatures, changeOriginContaining, changeOrigin));
		}
		
		return result;
	}
	
	/**
	 * Calculates the impact of changes to traits of Features. All features which are affected by a
	 * change to the trait changeOrigin are calculated.
	 * 
	 * @param changeOrigin The changed clabject
	 * @param oldValue The value before the change
	 * @param changedTrait The change trait.
	 * 
	 * @return  A list with all features that need to be changed after changing changeOrigin
	 */
	@Override
	public Set<Feature> getAffectedModelElementsForChangeTraitFeatureOperation(Feature changeOrigin, String oldValue, EStructuralFeature changedTrait){
		Set<Feature> result = new HashSet<Feature>();
		
		boolean overridden = false;
		Clabject changeOriginContainingClabject = changeOrigin.getClabject();
		
		//containingClabject.getAllFeatures() works here because this clabject does not contain
		//the feature at this point of time anymore
		for (Feature f :changeOriginContainingClabject.getAllFeatures())
			if(f != changeOrigin
					&& match(changeOrigin, changeOriginContainingClabject, f, PLMPackage.eINSTANCE.getElement_Name(), changeOrigin.getName())){
				overridden = true;
				break;
			}
		
		//If overridden then nothing needs to be done just delete the overriding 
		if (overridden)
			return result;

		Set<Feature> currentLevel = new HashSet<Feature>();
		currentLevel.add(changeOrigin);
		result.addAll(searchLevelForChangeFeatureTraitFeatureTypeDirection(currentLevel, changeOrigin, changedTrait, oldValue));
		result.addAll(currentLevel);
		result.addAll(searchLevelForChangeFeatureTraitFeatureInstanceDirection(result, changeOrigin, changedTrait, oldValue));
		result.removeAll(currentLevel);
		
		return result;
	}
	
	/**
	 * Recursively searches for features to change after changing changeOrigin. The search direction is
	 * upwards in the classification hierarchy relative from features.
	 * 
	 * @param features The features to start the recursion from
	 * @param changeOrigin The initially changed feature which triggered the impact analysis
	 * @param changedTrait The trait that has been changed
	 * @param oldValue The trait value before the change
	 * @return All features that need to be changed after applying a change to changeOrigin in type direction
	 */
	Set<Feature> searchLevelForChangeFeatureTraitFeatureTypeDirection(Set<Feature> features, Feature changeOrigin, EStructuralFeature changedTrait, String oldValue){
		Set<Feature> result = new HashSet<Feature>();
		Set<Clabject> allTypes = new HashSet<Clabject>();
		Set<Feature> allTypesFeatures = new HashSet<Feature>();
		
		for(Feature f : features){
			
			Clabject thisFeatureContainingClabject = f.getClabject(); 
			
			//If we add an attribute to an clabject only this attribute is affected on the same level
			//all subtypes get inherited the attribute by this clabject
			allTypes.addAll(thisFeatureContainingClabject.getLevelTypes());
		
			//On the next level only the direct instances of the change origin and
			//its subtypes are relevant. The subtypes of these do automatically get
			//inherited the attribute
			for(Clabject subType : thisFeatureContainingClabject.getSubtypes())
				allTypes.addAll(subType.getLevelTypes());
			
			//after collecting the clabjects we must search for the conforming features
			for(Clabject c : allTypes)
				for (Feature containedFeature : c.getFeature())
					if (match(changeOrigin, changeOrigin.getClabject(), containedFeature, changedTrait, oldValue))
						allTypesFeatures.add(containedFeature);
			
			result.addAll(allTypesFeatures);
			result.addAll(searchLevelForChangeFeatureTraitFeatureTypeDirection(allTypesFeatures, changeOrigin, changedTrait, oldValue));
		}
		
		return result;
	}
	
	/**
	 * Recursively searches for features to change after changing changeOrigin. The search direction is
	 * downwards in the classification hierarchy relative from features.
	 * 
	 * @param features The features to start the recursion from
	 * @param changeOrigin The initially changed feature which triggered the impact analysis
	 * @param changedTrait The trait that has been changed
	 * @param oldValue The trait value before the change
	 * @return All features that need to be changed after applying a change to changeOrigin in instance direction
	 */
	Set<Feature> searchLevelForChangeFeatureTraitFeatureInstanceDirection(Set<Feature> features, Feature changeOrigin, EStructuralFeature changedTrait, String oldValue){
		Set<Feature> result = new HashSet<Feature>();
		Set<Clabject> allInstances = new HashSet<Clabject>();
		Set<Feature> allInstancesFeatures = new HashSet<Feature>();
		
		for(Feature f : features){
			
			Clabject thisFeatureContainingClabject = f.getClabject();
			
			//If we add an attribute to an clabject only this attribute is affected on the same level
			//all subtypes get inherited the attribute by this clabject
			allInstances.addAll(thisFeatureContainingClabject.getInstances());
		
			//On the next level only the direct instances of the change origin and
			//its subtypes are relevant. The subtypes of these do automatically get
			//inherited the attribute
			for(Clabject subType : thisFeatureContainingClabject.getSubtypes())
				allInstances.addAll(subType.getInstances());
			
			//after collecting the clabjects we must search for the conforming features
			for(Clabject c : allInstances)
				for (Feature containedFeature : c.getFeature())
					if (match(changeOrigin, changeOrigin.getClabject(), containedFeature, changedTrait, oldValue))
						allInstancesFeatures.add(containedFeature);
			
			result.addAll(allInstancesFeatures);
			result.addAll(searchLevelForChangeFeatureTraitFeatureInstanceDirection(allInstancesFeatures, changeOrigin, changedTrait, oldValue));
		}
		
		return result;
	}
	
	/**
	 * Calculates the impact of a change to a clabject's trait.
	 * 
	 * @param changeOrigin The modified clabject
	 * @param oldValue The value before modification
	 * @param changedTrait The trait which has been modified
	 * @param includeNonShallowInheritance Whether to change the potency for non shallow super-/subtypes
	 * @return All clabjects that need to be changed after modifying changeOrigin
	 */
	@Override
	public Set<Clabject> getAffectedModelElementsForChangeTraitClabjectOperation(Clabject changeOrigin, String oldValue, EStructuralFeature changedTrait, boolean includeNonShallowInheritance){
		Set<Clabject> result = new HashSet<Clabject>();
		
		Set<Clabject> changeOrigins = new HashSet<Clabject>();
		changeOrigins.add(changeOrigin);
		Set<Clabject> affectedTypes = searchLevelForClabjectTraitChangesTypeDirectionForShallowPotencyChange(changeOrigins, includeNonShallowInheritance); 
		result.addAll(affectedTypes);
		result.addAll(searchLevelForClabjectTraitChangesInstanceDirectionForShallowPotencyChange(affectedTypes, includeNonShallowInheritance));
		
		//Clean up the result in case the change origin is in.
		result.remove(changeOrigin);
		
		return new HashSet<Clabject>(result);
	}

	/**
	 * Searches for the clabjects that need to be changed after changing a clabject. The search direction is upwards in the
	 * classification hierarchy relative from baseClabjects.
	 * 
	 * @param baseClabjects Clabjects to start recursion from
	 * @return A list with all clabjects that need to be changed in type direction
	 */
	private Set<Clabject> searchLevelForClabjectTraitChangesTypeDirectionForShallowPotencyChange(Set<Clabject> baseClabjects, boolean includeNonShallowInheritance){
		Set<Clabject> result = new HashSet<Clabject>();
		
		for(Clabject changeOrigin : baseClabjects){
		
			//At first we need to collect the whole inheritance hierarchy that is affected.
			//All shallow subtypes need to be updated.
			Set<Clabject> affectedClabjectsSameLevel = new HashSet<Clabject>();
			affectedClabjectsSameLevel.addAll(includeNonShallowInheritance ? changeOrigin.getSupertypes() : changeOrigin.getHollowSupertypes());
			
			affectedClabjectsSameLevel.add(changeOrigin);
			
			Iterator<Clabject> iter = affectedClabjectsSameLevel.iterator();
			Set<Clabject> affectedClabjectsSameLevelTmp = new HashSet<Clabject>();
			while (iter.hasNext())
				affectedClabjectsSameLevelTmp .addAll(includeNonShallowInheritance ? iter.next().getSubtypes() : iter.next().getHollowSubtypes());
			
			affectedClabjectsSameLevel.addAll(affectedClabjectsSameLevelTmp);
			
			result.addAll(affectedClabjectsSameLevel);
			
			//Now we need all direct types of the model elements that are affected on one level
			//Direct types are important as only these and their shallow supertypes are affected
			//and not the none shallow ones
			Set<Clabject> affectedDirectTypes = new HashSet<Clabject>();
			
			for (Clabject affectedClabjectSameLevel : affectedClabjectsSameLevel)
				affectedDirectTypes.addAll(affectedClabjectSameLevel.getTypes());
			
			result.addAll(affectedDirectTypes);
			result.addAll(searchLevelForClabjectTraitChangesTypeDirectionForShallowPotencyChange(affectedDirectTypes, includeNonShallowInheritance));
		}
		
		return result;
	}
	
	/**
	 * Searches for the clabjects that need to be changed after changing a clabject. The search direction is downwards in the
	 * classification hierarchy relative from baseClabjects.
	 * 
	 * @param baseClabjects Clabjects to start recursion from
	 * @return A list with all clabjects that need to be changed in instance direction
	 */
	private Set<Clabject> searchLevelForClabjectTraitChangesInstanceDirectionForShallowPotencyChange(Set<Clabject> baseClabjects, boolean includeNonShallowInheritance){
		Set<Clabject> result = new HashSet<Clabject>();
		
		for(Clabject changeOrigin : baseClabjects){
		
			//At first we need to collect the whole inheritance hierarchy that is affected.
			//All shallow subtypes need to be updated.
			Set<Clabject> affectedClabjectsSameLevel = new HashSet<Clabject>();
			affectedClabjectsSameLevel.addAll(includeNonShallowInheritance ? changeOrigin.getSupertypes() : changeOrigin.getHollowSupertypes());
			affectedClabjectsSameLevel.add(changeOrigin);
			
			Iterator<Clabject> iter = affectedClabjectsSameLevel.iterator();
			Set<Clabject> affectedClabjectsSameLevelTmp = new HashSet<Clabject>();
			while (iter.hasNext())
				affectedClabjectsSameLevelTmp .addAll(includeNonShallowInheritance ? iter.next().getSubtypes() : iter.next().getHollowSubtypes());
			
			affectedClabjectsSameLevel.addAll(affectedClabjectsSameLevelTmp);
			
			result.addAll(affectedClabjectsSameLevel);
			
			//Now we need all direct instances of the model elements that are affected on one level
			//Direct instances are important as only these and their shallow supertypes are affected
			//and not the none shallow ones
			Set<Clabject> affectedDirectInstances = new HashSet<Clabject>();
			
			for (Clabject affectedClabjectSameLevel : affectedClabjectsSameLevel)
				affectedDirectInstances.addAll(affectedClabjectSameLevel.getInstances());
			
			result.addAll(affectedDirectInstances);
			result.addAll(searchLevelForClabjectTraitChangesInstanceDirectionForShallowPotencyChange(affectedDirectInstances, includeNonShallowInheritance));
		}
		
		return result;
	}
	
	/**
	 * 
	 * This checks whether two features are relevant for emendation.
	 * The conditions are:
	 * 
	 * <ul>
	 * 	<li>Name and Datatype (if Attribute) must be equal</li>
	 *  <li>
	 *  	Potency rules are not allowed to be violated
	 *  	<ul>
	 *  		<li>f1.potency = -1 && f2.potency = -1</li>
	 *  		<li>f1.potency = -1 && f1.level < f2.level => f2.potency > -2
	 *  		<li>f1.potency = -1 && f1.level > f2.level => f2.potency = -1
	 *  		<li>f1.potency > -1 && f1.level < f2.level => f2.potency = f1.potency - (f2.level - f1.level)</li>
	 *  		<li>f1.potency > -1 && f1.level > f2.level => f1.potency = f2.potency - (f1.level - f2.level)</li>
	 *  	</ul>
	 *  </li>
	 * </ul>
	 * 
	 * @param changeOrigin
	 * @param f2
	 * @param newValue can bee needed because if emendation request comes from UI it can be already changed in 
	 * 					the feature
	 * @param traitToChange
	 * @return is f2 relevant for changes to changeOrigin
	 */
	private boolean match(Feature changeOrigin, Clabject originContainingClabject ,Feature f2, EStructuralFeature traitToChange, String oldValue){
		String changedTraitName = traitToChange.getName();
		String originName = changedTraitName.equals("name") ? oldValue : changeOrigin.getName();
		
		//This is a dirty hack for the case the user enters -1 potency
		//in this case it can for some reason happen that oldvalue becomes
		//null
		oldValue = traitToChange.getName().equals("durability") && oldValue == null ? changeOrigin.getDurabilityAsString() : oldValue;
		
		int originDurability = traitToChange.getName().equals("durability") ? Integer.parseInt(oldValue) : changeOrigin.getDurability();
		
		if (originName == null || originName.length() == 0 || !originName.equals(f2.getName()))
			return false;

		//Checks the datatype (attributes only)
		if(changeOrigin instanceof Attribute && f2 instanceof Attribute) {
			String originDataType = changedTraitName.equals("datatype") ? oldValue : ((Attribute)changeOrigin).getDatatype();
			String f2DataType = ((Attribute)f2).getDatatype();
			if(
					//Origin attribute has no datatype, f2 has one
					(originDataType == null && f2DataType != null) 
					//Both have a different datatype (include origin != null, f2 == null)
					|| (originDataType != null && !originDataType.equals(f2DataType))
				)
				return false;
		}
		
		//Both changeOrigin and f2 have -1 durability
		if ((originDurability == -1) && (originDurability == f2.getDurability()))
			return true;
		
		int f1Level = originContainingClabject.getLevelIndex();
		int f2Level = f2.getClabject().getLevelIndex();
		
		if (f1Level < f2Level){
			if (originDurability == -1)
				return true;
			else if (f2.getDurability() == -1)
				return originDurability == -1;
			else
				return f2.getDurability() == originDurability - (f2Level - f1Level); 
		}
		else{
			if (originDurability == -1)
				return f2.getDurability() == -1;
			else if (f2.getDurability() ==  -1)
				return true;
			else
				return originDurability == f2.getDurability() - (f1Level - f2Level);
		}
	}
}
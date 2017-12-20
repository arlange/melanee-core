/*******************************************************************************
 * Copyright (c) 2014 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Ralph Gerbig - initial API and implementation and initial documentation
 *******************************************************************************/ 
package org.melanee.core.dsl.service.visualizationsearchalgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.melanee.core.models.plm.PLM.AbstractDSLVisualizer;
import org.melanee.core.models.plm.PLM.Clabject;
import org.melanee.core.models.plm.PLM.Domain;
import org.melanee.core.models.plm.PLM.Element;
import org.melanee.core.models.plm.PLM.Enumeration;
import org.melanee.core.models.plm.PLM.LMLVisualizer;
import org.melanee.core.models.plm.PLM.Level;
import org.melanee.core.models.plm.PLM.ConnectionEnd;
import org.melanee.core.models.plm.PLM.DeepModel;
import org.melanee.core.workbench.ExtensionPointService;
import org.melanee.core.workbench.interfaces.IConstraintLanguageService;
import org.melanee.core.workbench.interfaces.IVisualizationServiceBase;

public class AspectAwareVisualizationSearchAlgorithm {

		IAspectAwareVisualizationSearchAlgorithmHelper helper;
	
		public AspectAwareVisualizationSearchAlgorithm(IAspectAwareVisualizationSearchAlgorithmHelper helper){
			//Make a deep copy of the visualizer
			//so that nothing can go wrong with the model
		   	copier = new EcoreUtil.Copier(true);
			this.helper = helper;
		}
	
		/**
		 * The copier which can be used to resolve a model element to
		 * its original visualizer
		 */
		private EcoreUtil.Copier copier;
		
		/**
		 * Merged visualizers return a copy only. When interpreting a visualizer is can be important to
		 * know where the copied visualization descriptor currently interpreted comes from. This
		 * operation returns the original visualization descriptor for a given visualization descriptor
		 * 
		 * @param descriptor the descriptor for which the original descriptor is searched
		 * @return the original visualization descriptor if one exists, descriptor otherwise
		 */
		public EObject findOriginalVisualizationDescriptorForMergedVisualizationDescriptor(EObject descriptor){
			if(!copier.containsValue(descriptor))
				return descriptor;

			EObject[] values = copier.values().toArray(new EObject[]{}); 
			for(int i = 0; i < copier.values().size(); i++){
				if(values[i] == descriptor)
					return copier.keySet().toArray(new EObject[]{})[i];
			}
			
			return descriptor;
		}
		
		//This map stores the owners of visualizers. This is needed
		//because visualizers which are merged through aspects do not
		//have their containing clabject stored.
		/**
		 * @deprecated replaced by findOriginalVisualizationDescriptorForMergedVisualizationDescriptor
		 * @see #findOriginalVisualizationDescriptorForMergedVisualizationDescriptor(EObject)
		 */
		public static Map<AbstractDSLVisualizer, Clabject> visualizer2ownerMap = new HashMap<AbstractDSLVisualizer, Clabject>();

		/**
		 * Retrieves the parent for an visualizer which was merged
		 * through aspects.
		 * 
		 * @param visualizer the visualizer for which to retrieve the parent
		 * @return the clabject containing the visualizer, null if no merged visualizer
		 * @deprecated replaced by findOriginalVisualizationDescriptorForMergedVisualizationDescriptor
		 * @see #findOriginalVisualizationDescriptorForMergedVisualizationDescriptor(EObject)
		 */
		public static Clabject findOwnerOfVisualizer(AbstractDSLVisualizer visualizer){
			return visualizer2ownerMap.get(visualizer);
		}
	
		/**
		 * 
		 * Searches the dsl notation for a model element. If no notation is found
		 * IVisualizationServiceBase.NOTATION_LML is returned. This is also returned
		 * for Domain and Enumeration as these do not have visualizers attached and
		 * do thus not have any notation except the LML in which they are rendered.
		 * The notation search starts searching at the element for a notation. If
		 * the notation of the element to be searched is specified as 
		 * IVisualizationServiceBase.NOTATION_DERIVED the containment hierarchy is
		 * recursively searched until a specified notation is found. If no notation is
		 * found, IVisualizationServiceBase.NOTATION_LML is returned.
		 * 
		 * @param e The element to search the notation for.
		 * @param format The format for which the notation is searched
		 * @return The notation or IVisualizationServiceBase.NOTATION_LML if no notation is found 
		 */
		public static String searchNotationForElement(Element e, String format) {
			
			if (e instanceof Enumeration || e instanceof Domain)
				return IVisualizationServiceBase.NOTATION_LML;
			
			//boolean collapse = false;

			//********************************************************
			//Find the LMLVisualizer attached to this element 
			//********************************************************
			//This can happen on delete
			if (e == null)
				return IVisualizationServiceBase.NOTATION_LML;

			EObject container = e;
			
			//In case of a connectionEnd the notation is stored in the connection
			if (e instanceof ConnectionEnd)
				container = e.eContainer();
				
			String dslRenderingString = null;

			//Search until a not derived notation is found
			while (container.eContainer() != null 
					&& ! (container.eContainer() == null)) {
				LMLVisualizer r = ((Element) container).getVisualizer().get(0);
				dslRenderingString = r.getValueForKey(format);

				if (!dslRenderingString.equals(IVisualizationServiceBase.NOTATION_DERIVED))
					break;

				container = container.eContainer();
			}
			
			//If all notations are derived use LML notation
			if (! IVisualizationServiceBase.NOTATION_DERIVED.equals(dslRenderingString))
				return dslRenderingString;

			return IVisualizationServiceBase.NOTATION_LML;	
		}
		
		/**
		 * The visualization search algorithm.  The algorithm for levels does not <b>support</b> aspects yet.
		 * All aspects which are found on the way to a visualizer are stored and merged into the visualizer
		 * which is used for rendering (mergeAspects == true).
		 * 
		 * @param e Element to visualize
		 * @param mergeAspects Shall aspects be merged?
		 * @return The found visualizer; null if no visualizer is found; A copy of the visualizer
		 * 				with aspects merged into it if aspects are found and mergeAspects == true
		 */
		private AbstractDSLVisualizer search(Level e, boolean mergeAspects){
			if(mergeAspects == true)
				throw new UnsupportedOperationException();
			
			AbstractDSLVisualizer dslVisualizer = getVisualizerFromElement(e, e);
						
			//A dsl visualizer is directly attached
			if(dslVisualizer != null)
				return dslVisualizer;
			
			//search more abstract levels
			if(! (e.eContainer() instanceof DeepModel))
				return null;
			
			DeepModel deepModel = (DeepModel)e.eContainer();
			for(int i = deepModel.getContent().indexOf(e) - 1; i > 0; i--){
				dslVisualizer = getVisualizerFromElement((Element)deepModel.getContent().get(i), e);
				System.out.println(dslVisualizer);
				if(dslVisualizer != null)
					return dslVisualizer;
			}
			
			return null;
		}
		
		/**
		 * The visualization search algorithm. This algorithm searches first the inheritance tree
		 * of the visualized element. If no visualizer is found the types are searched. This
		 * is done for the whole classification tree. The algorithm supports aspects. All aspects
		 * which are found on the way to a visualizer are stored and merged into the visualizer
		 * which is used for rendering (mergeAspects == true). In the case of a level the level
		 * itself is searched for a visualizer, then the levels into the more absract direction.
		 * For levels no aspects are supported.
		 * 
		 * @param e Element to visualize (Supports Clabjects and Levels)
		 * @param mergeAspects Shall aspects be merged?
		 * @return The found visualizer; null if no visualizer is found; A copy of the visualizer
		 * 				with aspects merged into it if aspects are found and mergeAspects == true
		 */
		private AbstractDSLVisualizer search(Clabject e, boolean mergeAspects){
			visualizer2ownerMap.clear();

			Map<String, EObject> name2aspect = new HashMap<String, EObject>();
			AbstractDSLVisualizer visualizerToMerge = null;

			// There is currently only DSL visualization for connections and
			// clabjects available
			if (!(e instanceof Clabject))
				return null;

			Clabject elementToVisualize = (Clabject) e;

			LinkedList<Clabject> superTypesToSearch = new LinkedList<Clabject>();
			LinkedList<Clabject> typesToSearch = new LinkedList<Clabject>();
			typesToSearch.add(elementToVisualize);

			Clabject currentClabject = null;
			Clabject currentType = null;

			// Go through the type hierarchy
			search: while ((currentType = typesToSearch.poll()) != null) {

				// We need to have the type of the current type at the beginning
				typesToSearch.addAll(currentType.getDirectTypes());

				superTypesToSearch = new LinkedList<Clabject>(currentType.getDirectSupertypes());
				superTypesToSearch.add(0, currentType);

				// Go through the inheritance hierarchy
				while ((currentClabject = superTypesToSearch.poll()) != null) {
					AbstractDSLVisualizer dslVisualizer = getVisualizerFromElement(currentClabject, elementToVisualize);

					// A DSLVisualizer has been found
					if (dslVisualizer != null) {
						List<EObject> aspects = getAspects(dslVisualizer, e);

						// No Aspect visualizer present and not an aspect visualizer
						if ((aspects == null || aspects.size() == 0) && name2aspect.isEmpty())
							return (AbstractDSLVisualizer) dslVisualizer;
						// No aspect visualizer but content to merge
						else if ((aspects == null || aspects.size() == 0) && !name2aspect.isEmpty()) {
							visualizerToMerge = (AbstractDSLVisualizer) dslVisualizer;
							break search;
						}
						// Aspect visualizer present -> merge the active ones
						else if (aspects != null && aspects.size() > 0)
							for (EObject aspect : getActiveAspects(dslVisualizer, e))
								name2aspect.put(helper.getAspectOrJoinPointName(aspect), aspect);
					}

					superTypesToSearch.addAll(currentClabject.getDirectSupertypes());
					typesToSearch.addAll(currentClabject.getDirectTypes());
				}
			}

			// If no merge is wanted the found visualizer
			// is returned as is
			if (!mergeAspects)
				return visualizerToMerge;

			return visualizerToMerge == null ? null : mergeVisualizer(visualizerToMerge, name2aspect);
		}
		
		/**
		 * The visualization search algorithm. This algorithm searches first the inheritance tree
		 * of the visualized element. If no visualizer is found the types are searched. This
		 * is done for the whole classification tree. The algorithm supports aspects. All aspects
		 * which are found on the way to a visualizer are stored and merged into the visualizer
		 * which is used for rendering (mergeAspects == true). In the case of a level the level
		 * itself is searched for a visualizer, then the levels into the more absract direction.
		 * For levels no aspects are supported.
		 * 
		 * @param e Element to visualize (Supports Clabjects and Levels)
		 * @param mergeAspects Shall aspects be merged?
		 * @return The found visualizer; null if no visualizer is found; A copy of the visualizer
		 * 				with aspects merged into it if aspects are found and mergeAspects == true
		 */
		public AbstractDSLVisualizer search(Element e, boolean mergeAspects) {
	
			if(e instanceof Level)
				return search((Level) e, mergeAspects);
			if(e instanceof Clabject)
				return search((Clabject) e, mergeAspects);
			
			return null;
		}
	
	/**
	 * Searches a clabject for a dsl Visualizer. The dsl visualizer has to have the correct notation,
	 * format and conform to the isSameLevel attribute.
	 * 
	 * @param currentClabject The clabject to search the dsl visualizer for
	 * @param elementToVisualize The element to visualize. This is needed to check if the element
	 * 								to visualize and the visualizer are at the same level.
	 * @return Returns a visualizer or null if none is found.
	 */
	private AbstractDSLVisualizer getVisualizerFromElement(Element currentElement, Element elementToVisualize){
		//Iterate all gpl visualizers
		for (LMLVisualizer lmlVisualizer : currentElement.getVisualizer())
			//Find the first graphical DSL visualizer
			for (AbstractDSLVisualizer dslVisualizer : lmlVisualizer.getDslVisualizer())
				//Check if the visualizer is of interest
				if (helper.isRightFormat(dslVisualizer)
						&& helper.isRightNotation(dslVisualizer)){
					
					//Check if the visualizer is to be applied in case
					//the visualizer and visualized model element are
					//on the same level
					if(dslVisualizer.isInstanceLevel()
							&& sameLevel(elementToVisualize, dslVisualizer))
						continue;
					
					return dslVisualizer;
				}
		
		return null;
	}
	
	/**
	 * Checks if e and v are on the same leve. Returns false
	 * if e is not a clabject
	 * @param e element to check
	 * @param v visualizer to check
	 * @return e.level == v.level; false if e is not a clabject
	 */
	private boolean sameLevel(Element e, AbstractDSLVisualizer v){
		if(! (e instanceof Clabject))
			return false;
		
		Level clabjectLevel = ((Clabject)e).getLevel();
		Level visualizerLevel = null;
		
		EObject parent = v.eContainer();
		while(parent != null && ! (parent instanceof Level))
			parent = parent.eContainer();
		
		if(parent instanceof Level)
			visualizerLevel = (Level)parent;
		
		return clabjectLevel == visualizerLevel;
		
	}
		
	/**
	 * Searches and returns the aspect. If no aspect is found
	 * an empty list is returned
	 * 
	 * @return
	 */
	private List<EObject> getAspects(AbstractDSLVisualizer v, Element visualizedElement){
		List<EObject> result = new ArrayList<EObject>();
		
		List<EObject> iterator = v.eContents();
		
		//An empty visualizer cannot contain an aspect
		if (iterator.size() == 0)
			return result;
		
		for(EObject eObj : iterator){
			if(helper.isAspect(eObj)){
				result.add(eObj);
			}
			
			//As soon as a joint point is found no apsect orient visualizer is
			//is present
			else if(! helper.isAspect(eObj))
				return new ArrayList<EObject>();
		}
		
		return result;
	}
	
	/**
	 * Filters only the active aspects from all aspects. An aspect
	 * is active if the condition evaluates to true.
	 * 
	 * @return
	 * @throws CoreException 
	 */
	private List<EObject> getActiveAspects(AbstractDSLVisualizer v, Element visualizedElement){
		List<EObject> result = new ArrayList<EObject>();
		
		List<EObject> allAspects = getAspects(v, visualizedElement);
		
		/**
		 * The constraint language service is needed to evaluat applicability of aspects
		 */
		IConstraintLanguageService constraintLanguageService = null;
		
		try {
			constraintLanguageService = ExtensionPointService.Instance().getActiveConstraintLanguageService();
		} catch (CoreException e1) {
			e1.printStackTrace();
		}
		
		for(EObject a : allAspects){
				
			//Check if aspect shall be applied
			//The default is true if no constraint
			//language service is installed
			boolean apply = true;
			
			if (constraintLanguageService != null
					&& visualizedElement instanceof Clabject)
				try {
					Object conditionResult = constraintLanguageService.evaluate(helper.getAspectContainingClabject(a), (Clabject)visualizedElement, helper.getCondition(a));
					if(conditionResult instanceof Boolean)
						apply = ((Boolean) conditionResult).booleanValue();
						
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			if(apply)
				result.add((EObject)a);
		}
		
		return result;
	}
	
	private AbstractDSLVisualizer mergeVisualizer(AbstractDSLVisualizer v, Map<String, EObject> name2aspect){
		AbstractDSLVisualizer mergedDSLVisualizer = (AbstractDSLVisualizer)copier.copy(v);
		copier.copyReferences();
		
		//Store the owner for the merged dsl visualizer
		visualizer2ownerMap.put(mergedDSLVisualizer, (Clabject)v.eContainer().eContainer());
		
		TreeIterator<EObject> iterator = mergedDSLVisualizer.eAllContents();
		
		
		//An empty visualizer cannot be merged
		if (!iterator.hasNext())
			return mergedDSLVisualizer;
		
		while(iterator.hasNext()) {
			EObject eObj = iterator.next();
			
			String name = helper.getAspectOrJoinPointName(eObj);
			//Only join points with names can be merged
			if(name != null
					&& !"".equals(name)
				){
				
				EObject joinPoint = eObj;
				EObject aspect = name2aspect.get(name);
				
				//Did not find a join point to merge this aspect
				if (aspect == null)
					continue;
				
				EObject copiedAspect =  copier.copy(aspect);
				copier.copyReferences();
				helper.merge(copiedAspect, joinPoint);
				
			}			
		}

		return mergedDSLVisualizer;
	}
	
	/**
	 * Searches for the level of an element
	 * 
	 * @param e element to search level
	 * @return level if contained in one; null otherwise
	 */
	private EObject getLevelOfElement(EObject e){
		EObject container = e.eContainer();
		while(e.eContainer() != null){
			if(container instanceof Level)
				return container;
			container = container.eContainer();
		}
		
		return null;
	}
}
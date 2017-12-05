/*******************************************************************************
 * Copyright (c) 2012 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Bastian Kennel, 
 *    				 - initial API and implementation and initial documentation
 *******************************************************************************/ 
package org.melanee.core.proximityindication.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EObject;
import org.melanee.core.models.plm.PLM.Clabject;
import org.melanee.core.models.plm.PLM.Domain;
import org.melanee.core.models.plm.PLM.Element;
import org.melanee.core.workbench.interfaces.IDesignationService;

public class ProximityIndicationService implements IDesignationService{
	
	@Override
	public String createIdenficationDesignationString(Clabject context,
			String query) {
		return context.getName();
	}
	
	@Override
	public String evaluate(Clabject context, String query) {
		return createLocationDesignationString(context, query) + createLocationDesignationString(context, query) + context.getName() + createClassificationDesignationString(context, query);
	}
	
	/**
	 *
	 * @param <T> Either Clabject or Element in case of containment
	 * 
	 * Helper to parameterize the three proximity types.
	 * 
	 */
	private interface IProximityHelper<T> {
		
		/**
		 * 
		 * @param currentResult
		 * @param newAddition
		 * @return The new Result with the two combined
		 */
		public String appendResult(String currentResult, String newAddition);
		
		public String appendSeperator(String result);

		
		/**
		 * 
		 * @param current
		 * @return the next level of proximity from current
		 */
		public List<T> getNextProximityLevel(T current);
		
		/**
		 * 
		 * @return the separation string for the current type of proximity
		 */
		public String getSeparator();
		
	}
	
	// The queues containing the parsed input of the proximity indication strings
	/**
	 * DO NOT MODIFY
	 */
	private LinkedList<Integer> generlizationRequests = null;
	/**
	 * DO NOT MODIFY
	 */
	private LinkedList<Integer> containmentRequests = null;
	/**
	 * DO NOT MODIFY
	 */
	private LinkedList<Integer> classificationRequests = null;
	
	// Star proximity flushes everything 
	private final int STAR = -1;

	/**
	 * 
	 * @param c the clabject to evaluate the proximity string from
	 * @param expression has the format [inheritanceExpression](containmentExpression){classificationExpression}
	 *			leave empty to display; -1 to display whole hierarchy; 0 to display first only; seperate levels to 
	 *			display by comma 
	 * 
	 * @return the string replacing the name in the header compartment
	 */
	public String run(Clabject c, String expression) {
		// Parse the input expression
		parseInput(expression);
		// Create the three proximity strings with helpers
		String inheritanceProximityString = createHeritageDesignationString(c);
		String classificationProximityString = createClassificationDesignationString(c);
		String containmentProximityString = createLocationDesignationString(c);
		// Put them together
		String result = inheritanceProximityString + containmentProximityString + c.getName() + classificationProximityString;  
		return  result;
	}


	public String createLocationDesignationString(Clabject c, String expression) {
		parseInput(expression);
		
		return createLocationDesignationString(c);
	}


	public String createLocationDesignationString(Clabject c) {
		
		String containmentProximityString = createProximityString(c, containmentRequests, new IProximityHelper<Element>() {

			@Override
			public String appendResult(String currentResult, String newAddition) {
				return newAddition + currentResult;
			}

			@Override
			public List<Element> getNextProximityLevel(Element current) {
				ArrayList<Element> temp = new ArrayList<Element>();
				EObject possible = current.eContainer();
				if (possible instanceof Domain) return temp;
				temp.add((Element) possible);
				return temp;
			}

			@Override
			public String getSeparator() {
				return ".";
			}

			@Override
			public String appendSeperator(String result) {
				return result + getSeparator();
			}
			
		});
		return containmentProximityString;
	}
	
	public String createClassificationDesignationString(Clabject c, String expression) {
		parseInput(expression);

		return createClassificationDesignationString(c);
	}

	public String createClassificationDesignationString(Clabject c) {
			String classificationProximityString = createProximityString(c, classificationRequests, new IProximityHelper<Clabject>() {

			@Override
			public String appendResult(String currentResult, String newAddition) {
				return currentResult + newAddition;
			}
			
			@Override
			public List<Clabject> getNextProximityLevel(Clabject current) {
				return current.getTypes();
			}

			@Override
			public String getSeparator() {
				return ":";
			}

			@Override
			public String appendSeperator(String result) {
				return getSeparator() + result;
			}
			
		});
		return classificationProximityString;
	}

	public String createHeritageDesignationString(Clabject c, String expression) {
		parseInput(expression);
		
		return createHeritageDesignationString(c);
	}

	public String createHeritageDesignationString(Clabject c) {
		
		String inheritanceProximityString = createProximityString(c, generlizationRequests, new IProximityHelper<Clabject>(){

			@Override
			public String appendResult(String currentResult, String newAddition) {
				return newAddition + currentResult;
			}

			@Override
			public List<Clabject> getNextProximityLevel(Clabject current) {
				return current.getDirectSupertypes();
			}

			@Override
			public String getSeparator() {
				return "<";
			}

			@Override
			public String appendSeperator(String result) {
				return result + getSeparator();
			}
			
		});
		return inheritanceProximityString;
	}

	private String createProximityString(Clabject c, LinkedList<Integer> requestQueue, IProximityHelper helper) {
		String result = "";
		//When there is no queue there is no string
		if (requestQueue.isEmpty()) {
			return result;
		}
		
		//Needs to be done so that performance improvements are working
		LinkedList<Integer> requestQueueCopy = new LinkedList<Integer>(requestQueue);
		// The current string request level
		int currentRequest = requestQueueCopy.poll();
		// helper to collect the possible name givers
		int currentLevel = 0;
		// the last request level to determine if we skip levels
		int previousRequest = -1;
		// all the possible elements to contribute to the proximity, each entry is one level of them
		List<List<? extends Element>> allLevels = new ArrayList<List<? extends Element>>();
		// initialize with the first level from the input
		allLevels.add(helper.getNextProximityLevel(c));
		// local flag to store if there is a next level
		boolean nextLevelPresent = true;
		while (nextLevelPresent) {
			List<? extends Element> nextLevel = new ArrayList<Element>();
			// Collect the next level from all elements on the current level
			for (Element t: allLevels.get(currentLevel)) {
				nextLevel.addAll(helper.getNextProximityLevel(t));
			}
			// Determine if there is a next level
			nextLevelPresent = nextLevel.size() > 0;
			// Prevent empty lists in allLevels
			if (nextLevelPresent) allLevels.add(nextLevel);
			currentLevel++;
		}
		//Loop through all the possible elements on all the levels and see if there is a request for it
		for (List<? extends Element> currentLevelElements: allLevels) {
			// Only act if the current level is of interest 
			// Interest can be either a request or STAR
			if (currentRequest == allLevels.indexOf(currentLevelElements) || currentRequest == STAR) {
				String temp = "";
				// If there is more than one element in the current level, we have to bracket them
				if (currentLevelElements.size()>1) temp += "(";
				// Parse the current level string from the names of the current level Elements
				for (Element t: currentLevelElements) {
					// If there is no name or its empty, use a underscore
					if (t.getName() != null && t.getName().length()>0) {
						temp += t.getName();
					} else {
						temp += "_";
					}
					temp += ",";
				}
				// If there was any, there is a trailing comma too much
				if (temp.length() > 0) temp = temp.substring(0,temp.length()-1);
				// If there was more than one, we have to close the bracket
				if (currentLevelElements.size()>1) temp += ")";
				// add the proximity separator
				temp = helper.appendSeperator(temp);
				// If we skipped a level, add a second separator
				if (currentRequest != STAR && currentRequest - previousRequest >= 2) temp = helper.appendSeperator(temp);
				// Let the helper build the result 
				result = helper.appendResult(result, temp);
				// if the queue is not empty, go to the next request
				// the loop will still do all elements even if there are no more requests because a 
				// star request will be relevant for all levels
				if (!requestQueueCopy.isEmpty()) {
					previousRequest = currentRequest;
					currentRequest = requestQueueCopy.poll();
				}
			}
		}
		
		//Clean up string to be empty in case that nothing is found
		if (result.length() == 1 && result.equals(helper.getSeparator()))
			result = "";
		
		return result;
	}
	

	private static final HashMap<String, List<List<Integer>>> requestCache = new HashMap<String, List<List<Integer>>>();
	
	private void parseInput(String expression) {
		//Check if request is already in cache.
		List<List<Integer>> cacheResult = null;
		if ((cacheResult = requestCache.get(expression)) != null){
			generlizationRequests = (LinkedList<Integer>)cacheResult.get(0);
			containmentRequests = (LinkedList<Integer>)cacheResult.get(1);
			classificationRequests = (LinkedList<Integer>)cacheResult.get(2);
			return;
		}
		// Parse the input integer queues of the requested levels from the expression string
		Pattern pattern = Pattern.compile("\\[(.*?)\\]\\((.*?)\\)\\{(.*?)\\}");
		Matcher matcher = pattern.matcher(expression);
		matcher.matches();
		//Initialize the arrays so that if nothing is passed the service does not choke
		String[] inheritanceArray = new String[]{""};
		String[] containmentArray = new String[]{""};
		String[] classificationArray = new String[]{""};
		if (matcher.groupCount() == 3) {
			String inheritanceExpression = matcher.group(1);
			String containmentExpression = matcher.group(2);
			String classificationExpression = matcher.group(3);
			
			inheritanceArray = inheritanceExpression.split(",");
			containmentArray = containmentExpression.split(",");
			classificationArray = classificationExpression.split(",");
		}
		generlizationRequests = new LinkedList<Integer>();
		for(String i:inheritanceArray) {
			try {
				if (i != null && i.length() > 0)
					generlizationRequests.add(Integer.parseInt(i));
			} catch (NumberFormatException ex) {
				ex.printStackTrace();
			}
		}
		
		containmentRequests = new LinkedList<Integer>();
		for(String i:containmentArray) {
			try {
				if (i != null && i.length() > 0)
					containmentRequests.add(Integer.parseInt(i));
			} catch (NumberFormatException ex) {
				ex.printStackTrace();
			}
		}
		
		classificationRequests = new LinkedList<Integer>();
		for(String i:classificationArray) {
			try {
				if (i != null && i.length() > 0)
					classificationRequests.add(Integer.parseInt(i));
			} catch (NumberFormatException ex) {
				ex.printStackTrace();
			}
		}
		
		//Cache the result to improve performance on further requests
		//New Collection(Collection) is needed because the list elements
		//are taken out of the lists during the algorithm
		List<List<Integer>> cache = new LinkedList<List<Integer>>();
		cache.add(generlizationRequests);
		cache.add(containmentRequests);
		cache.add(classificationRequests);
		requestCache.put(expression, cache);
	}
}

/*******************************************************************************
 * Copyright (c) 2011 - 2015 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     - initial API and implementation and initial documentation
 *******************************************************************************/ 
package org.melanee.core.workbench;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.statushandlers.StatusManager;
import org.melanee.core.workbench.interfaces.IApplicationVisualizationService;
import org.melanee.core.workbench.interfaces.IConstraintLanguageService;
import org.melanee.core.workbench.interfaces.IDSLService;
import org.melanee.core.workbench.interfaces.IEmendationService;
import org.melanee.core.workbench.interfaces.IFormVisualizationService;
import org.melanee.core.workbench.interfaces.IGraphicalVisualizationService;
import org.melanee.core.workbench.interfaces.IPopupToolBarProvider;
import org.melanee.core.workbench.interfaces.IDesignationService;
import org.melanee.core.workbench.interfaces.IReasoningService;
import org.melanee.core.workbench.interfaces.ITableVisualizationService;
import org.melanee.core.workbench.interfaces.ITextualVisualizationService;
import org.melanee.core.workbench.interfaces.IValidationService;
import org.melanee.core.workbench.preferences.PreferenceConstants;
import org.melanee.core.workbench.status.MelaneeWorkbenchStatus;

/**
 * This class manages loading extension points. Call Instance() to 
 * get an instance of this class.
 *
 */
public class ExtensionPointService {
	
	private final static String TEXTUAL_VISUALIZATION_SERVICE_ID = "org.melanee.core.textdsl.service";
	private final static String GRAPHICAL_VISUALIZATION_SERVICE_ID = "org.melanee.core.graphdsl.service";
	private final static String APPLICATION_VISUALIZATION_SERVICE_ID = "org.melanee.core.appdsl.service";
	private final static String VALIDATION_SERVICE_ID = "org.melanee.core.validation.service";
	private final static String CONSTRAINT_LANGUAGE_SERVICE_ID = "org.melanee.core.constraintlanguage.service";
	private final static String REASONING_SERVICE_ID = "org.melanee.core.reasoning.service";
	private final static String EMENDATION_SERVICE_ID = "org.melanee.core.emendation.service";
	private final static String DESIGNATION_SERVICE_ID = "org.melanee.core.designation.service";
	private final static String DSL_SERVICE_ID = "org.melanee.core.dsl.service";
	private final static String POPUPBARBUTTON_PROVIDER_ID = "org.melanee.core.popupbarbuttons.provider";
	private final static String FORM_VISUALIZATION_SERVICE_ID = "org.melanee.core.formdsl.service";
	private final static String TABLE_VISUALIZATION_SERVICE_ID = "org.melanee.core.tabledsl.service";
	
	private static ExtensionPointService instance = null;
	
	/**
	 * Cache for Graphical Visualization IConfigurationElements
	 */
	private static Map<String, IConfigurationElement> id2GraphicalVisualizationServiceConfigurationElement;
	public Map<String, IConfigurationElement> getId2GraphicalVisualizationServiceConfigurationElement() {
		return id2GraphicalVisualizationServiceConfigurationElement;
	}
	/**
	 * Cache for Graphical Visualization Instances
	 */
	private static Map<String, IGraphicalVisualizationService> id2GraphicalVisualizationServiceInstance;

	
	/**
	 * Cache for Textual Visualization IConfigurationElements
	 */
	private static Map<String, IConfigurationElement> id2TextualVisualizationServiceConfigurationElement;
	public Map<String, IConfigurationElement> getId2TextualVisualizationServiceConfigurationElement() {
		return id2TextualVisualizationServiceConfigurationElement;
	}
	/**
	 * Cache for Textual Visualization Instances
	 */
	private static Map<String, ITextualVisualizationService> id2TextualVisualizationServiceInstance;
	
	/**
	 * Cache for Form Visualization IConfigurationElements
	 */
	private static Map<String, IConfigurationElement> id2FormVisualizationServiceConfigurationElement;
	public Map<String, IConfigurationElement> getId2FormVisualizationServiceConfigurationElement() {
		return id2FormVisualizationServiceConfigurationElement;
	}
	/**
	 * Cache for Form Visualization Instances
	 */
	private static Map<String, IFormVisualizationService> id2FormVisualizationServiceInstance;
	
	/**
	 * Cache for Table Visualization IConfigurationElements
	 */
	private static Map<String, IConfigurationElement> id2TableVisualizationServiceConfigurationElement;
	public Map<String, IConfigurationElement> getId2TableVisualizationServiceConfigurationElement() {
		return id2TableVisualizationServiceConfigurationElement;
	}
	/**
	 * Cache for Table Visualization Instances
	 */
	private static Map<String, ITableVisualizationService> id2TableVisualizationServiceInstance;
	
	/**
	 * Cache for Reasoning IConfigurationElements
	 */
	private static Map<String, IConfigurationElement> id2ReasoningServiceConfigurationElement;
	public Map<String, IConfigurationElement> getId2ReasoningServiceConfigurationElement() {
		return id2ReasoningServiceConfigurationElement;
	}
	/**
	 * Cache for Reasoning Instances
	 */
	private static Map<String, IReasoningService> id2ReasoningServiceInstance;
	
	
	
	/**
	 * Cache for Refactoring IConfigurationElements
	 */
	private static Map<String, IConfigurationElement> id2EmendationServiceConfigurationElement;
	public Map<String, IConfigurationElement> getId2EmendationServiceConfigurationElement() {
		return id2EmendationServiceConfigurationElement;
	}
	/**
	 * Cache for Refactoring Instances
	 */
	private static Map<String, IEmendationService> id2EmendationServiceInstance;
	
	
	
	/**
	 * Cache for Proximity Indication IConfigurationElements
	 */
	private static Map<String, IConfigurationElement> id2DesignationServiceConfigurationElement;
	public Map<String, IConfigurationElement> getId2DesignationServiceConfigurationElement() {
		return id2DesignationServiceConfigurationElement;
	}
	/**
	 * Cache for Proximity Indication Instances
	 */
	private static Map<String, IDesignationService> id2DesignationServiceInstance;
	
	
	
	/**
	 * Cache for DSL IConfigurationElements
	 */
	private static Map<String, IConfigurationElement> id2DSLServiceConfigurationElement;
	public Map<String, IConfigurationElement> getId2DSLServiceConfigurationElement() {
		return id2DSLServiceConfigurationElement;
	}
	/**
	 * Cache for DSL Instances
	 */
	private static Map<String, IDSLService> id2DSLServiceInstance;
	
	
	/**
	 * Cache for IPopupToolBarProvider IConfigurationElements
	 */
	private static Map<String, IConfigurationElement> id2IPopupToolBarProviderConfigurationElement;
	public Map<String, IConfigurationElement> getId2PopUpBarButtonProviderConfigurationElement() {
		return id2IPopupToolBarProviderConfigurationElement;
	}
	/**
	 * Cache for IPopupToolBarProvider Instances
	 */
	private static Map<String, IPopupToolBarProvider> id2IPopupToolBarProviderInstance;
	
	
	/**
	 * Cache for IValidationService IConfigurationElements
	 */
	private static Map<String, IConfigurationElement> id2IValidationServiceConfigurationElement;
	public Map<String, IConfigurationElement> getId2ValidationServiceConfigurationElement() {
		return id2IValidationServiceConfigurationElement;
	}
	/**
	 * Cache for IValidarionService Instances
	 */
	private static Map<String, IValidationService> id2IValidationServiceInstance;
	
	/**
	 * Cache for IConstraintLanguageService IConfigurationElements
	 */
	private static Map<String, IConfigurationElement> id2IConstraintLanguageServiceConfigurationElement;
	public Map<String, IConfigurationElement> getId2ContraintLanguageServiceConfigurationElement() {
		return id2IConstraintLanguageServiceConfigurationElement;
	}
	/**
	 * Cache for IConstraintLanguageService Instances
	 */
	private static Map<String, IConstraintLanguageService> id2IConstraintLanguageServiceInstance;
	
	/**
	 * Cache for IApplicationVisualizationService IConfigurationElements
	 */
	private static Map<String, IConfigurationElement> id2IApplicationVisualizationServiceConfigurationElement;
	public Map<String, IConfigurationElement> getId2ApplicationVisualizationServiceConfigurationElement() {
		return id2IApplicationVisualizationServiceConfigurationElement;
	}
	/**
	 * Cache for IApplicationVisualizationService Instances
	 */
	private static Map<String, IApplicationVisualizationService> id2IApplicationVisualizationServiceInstance;
	
	
	private ExtensionPointService(){
		
	}
	
	public static ExtensionPointService Instance()
	{
		
		if (instance == null){
			instance = new ExtensionPointService();
			instance.initialize();
		}
		
		return instance;
	}
	
	/**
	 * Initializes all IConfigurationElement caches.
	 */
	private void initialize(){
		
		//Initialize caches
		id2FormVisualizationServiceConfigurationElement = new HashMap<String, IConfigurationElement>();
		id2FormVisualizationServiceInstance = new HashMap<String, IFormVisualizationService>();
		
		id2TableVisualizationServiceConfigurationElement = new HashMap<String, IConfigurationElement>();
		id2TableVisualizationServiceInstance = new HashMap<String, ITableVisualizationService>();
		
		id2TextualVisualizationServiceConfigurationElement = new HashMap<String, IConfigurationElement>();
		id2TextualVisualizationServiceInstance = new HashMap<String, ITextualVisualizationService>();
		
		id2GraphicalVisualizationServiceConfigurationElement = new HashMap<String, IConfigurationElement>();
		id2GraphicalVisualizationServiceInstance = new HashMap<String, IGraphicalVisualizationService>();
		
		id2ReasoningServiceConfigurationElement = new HashMap<String, IConfigurationElement>();
		id2ReasoningServiceInstance = new HashMap<String, IReasoningService>();
		
		id2EmendationServiceConfigurationElement = new HashMap<String, IConfigurationElement>();
		id2EmendationServiceInstance = new HashMap<String, IEmendationService>();
		
		id2DesignationServiceConfigurationElement = new HashMap<String, IConfigurationElement>();
		id2DesignationServiceInstance = new HashMap<String, IDesignationService>();
		
		id2DSLServiceConfigurationElement = new HashMap<String, IConfigurationElement>();
		id2DSLServiceInstance = new HashMap<String, IDSLService>();
		
		id2IPopupToolBarProviderConfigurationElement = new HashMap<String, IConfigurationElement>();
		id2IPopupToolBarProviderInstance = new HashMap<String, IPopupToolBarProvider>();
		
		id2IValidationServiceConfigurationElement = new HashMap<String, IConfigurationElement>();
		id2IValidationServiceInstance = new HashMap<String, IValidationService>();
		
		id2IConstraintLanguageServiceConfigurationElement = new HashMap<String, IConfigurationElement>();
		id2IConstraintLanguageServiceInstance = new HashMap<String, IConstraintLanguageService>();
		
		id2IApplicationVisualizationServiceConfigurationElement = new HashMap<String, IConfigurationElement>();
		id2IApplicationVisualizationServiceInstance = new HashMap<String, IApplicationVisualizationService>();
		

		//Initialize the form visualization service
		IConfigurationElement[] configurationElements = Platform.getExtensionRegistry().getConfigurationElementsFor(FORM_VISUALIZATION_SERVICE_ID);
		
		for (IConfigurationElement cElement : configurationElements)
			id2FormVisualizationServiceConfigurationElement.put(cElement.getAttribute("id"), cElement);

		//Initialize the table visualization service
		configurationElements = Platform.getExtensionRegistry().getConfigurationElementsFor(TABLE_VISUALIZATION_SERVICE_ID);
		
		for (IConfigurationElement cElement : configurationElements)
			id2TableVisualizationServiceConfigurationElement.put(cElement.getAttribute("id"), cElement);
		
		//Initialize the textual visualization service
		configurationElements = Platform.getExtensionRegistry().getConfigurationElementsFor(TEXTUAL_VISUALIZATION_SERVICE_ID);
		
		for (IConfigurationElement cElement : configurationElements)
			id2TextualVisualizationServiceConfigurationElement.put(cElement.getAttribute("id"), cElement);
		
		//Initialize the graphical visualization service
		configurationElements = Platform.getExtensionRegistry().getConfigurationElementsFor(GRAPHICAL_VISUALIZATION_SERVICE_ID);
		
		for (IConfigurationElement cElement : configurationElements)
			id2GraphicalVisualizationServiceConfigurationElement.put(cElement.getAttribute("id"), cElement);
				
		//Initialize the reasoning service
		configurationElements = Platform.getExtensionRegistry().getConfigurationElementsFor(REASONING_SERVICE_ID);
		
		for (IConfigurationElement cElement : configurationElements)
			id2ReasoningServiceConfigurationElement.put(cElement.getAttribute("id"), cElement);
		
		//Initialize the refactoring service
		configurationElements = Platform.getExtensionRegistry().getConfigurationElementsFor(EMENDATION_SERVICE_ID);
		
		for (IConfigurationElement cElement : configurationElements)
			id2EmendationServiceConfigurationElement.put(cElement.getAttribute("id"), cElement);
		
		//Initialize the designation indication service
		configurationElements = Platform.getExtensionRegistry().getConfigurationElementsFor(DESIGNATION_SERVICE_ID);
		
		for (IConfigurationElement cElement : configurationElements)
			id2DesignationServiceConfigurationElement.put(cElement.getAttribute("id"), cElement);
		
		//Initialize the DSL service
		configurationElements = Platform.getExtensionRegistry().getConfigurationElementsFor(DSL_SERVICE_ID);
		
		for (IConfigurationElement cElement : configurationElements)
			id2DSLServiceConfigurationElement.put(cElement.getAttribute("id"), cElement);
		
		//Initialize the popup bar service
		configurationElements = Platform.getExtensionRegistry().getConfigurationElementsFor(POPUPBARBUTTON_PROVIDER_ID);
		
		for (IConfigurationElement cElement : configurationElements)
			id2IPopupToolBarProviderConfigurationElement.put(cElement.getAttribute("id"), cElement);
		
		//Initialize the validation service
		configurationElements = Platform.getExtensionRegistry().getConfigurationElementsFor(VALIDATION_SERVICE_ID);
		
		for (IConfigurationElement cElement : configurationElements)
			id2IValidationServiceConfigurationElement.put(cElement.getAttribute("id"), cElement);
		
		//Initialize the constraint language service
		configurationElements = Platform.getExtensionRegistry().getConfigurationElementsFor(CONSTRAINT_LANGUAGE_SERVICE_ID);
		
		for (IConfigurationElement cElement : configurationElements)
			id2IConstraintLanguageServiceConfigurationElement.put(cElement.getAttribute("id"), cElement);
		
		//Initialize the validation service
		configurationElements = Platform.getExtensionRegistry().getConfigurationElementsFor(APPLICATION_VISUALIZATION_SERVICE_ID);
		
		for (IConfigurationElement cElement : configurationElements)
			id2IApplicationVisualizationServiceConfigurationElement.put(cElement.getAttribute("id"), cElement);
	}

	/**
	 * Returns an instance of the Form Visualization Service. For performance improvements two caches are used.
	 * One to cache the IConfigurationElements and one to cache the visualization service instance. Returns null
	 * in case that an empty string or null is provided as id.
	 * 
	 * @param id ID of the registered extension point
	 * 
	 * @return A cached instance of the visualization service
	 * 
	 * @throws CoreException
	 */
	public IFormVisualizationService getFormVisualizationService(String id) throws CoreException{
		IFormVisualizationService transformator = id2FormVisualizationServiceInstance.get(id);
		
		if (id == null
				|| id.length() == 0)
			return null;
		
		if (transformator == null)
		{
			if (id2FormVisualizationServiceConfigurationElement.get(id) == null){
				String message = MelaneeWorkbenchStatus.CANNOT_FIND_PLUGIN_MESSAGE + id;
				StatusManager.getManager().handle(new MelaneeWorkbenchStatus(IStatus.ERROR, MelaneeWorkbenchStatus.CANNOT_FIND_PLUGIN, message, null, Activator.PLUGIN_ID), StatusManager.LOG);
				return null;
			}
			
			transformator = (IFormVisualizationService)id2FormVisualizationServiceConfigurationElement.get(id).createExecutableExtension("class");
			id2FormVisualizationServiceInstance.put(id, transformator);
		}
		
		return transformator;
	}
	
	/**
	 * Returns the active instance of the Form Visualization Service. For performance improvements two caches are used.
	 * One to cache the IConfigurationElements and one to cache the visualization service instance.
	 *
	 * 
	 * @return A cached instance of the visualization service
	 * 
	 * @throws CoreException
	 */
	public IFormVisualizationService getActiveFormVisualizationService() throws CoreException{
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		
		return getFormVisualizationService(store.getString(PreferenceConstants.P_ACTIVE_FORM_VISUALIZATION_ENGINE));
	}
	
	/**
	 * Returns an instance of the Table Visualization Service. For performance improvements two caches are used.
	 * One to cache the IConfigurationElements and one to cache the visualization service instance. Returns null
	 * in case that an empty string or null is provided as id.
	 * 
	 * @param id ID of the registered extension point
	 * 
	 * @return A cached instance of the visualization service
	 * 
	 * @throws CoreException
	 */
	public ITableVisualizationService getTableVisualizationService(String id) throws CoreException{
		ITableVisualizationService transformator = id2TableVisualizationServiceInstance.get(id);
		
		if (id == null
				|| id.length() == 0)
			return null;
		
		if (transformator == null)
		{
			if (id2TableVisualizationServiceConfigurationElement.get(id) == null){
				String message = MelaneeWorkbenchStatus.CANNOT_FIND_PLUGIN_MESSAGE + id;
				StatusManager.getManager().handle(new MelaneeWorkbenchStatus(IStatus.ERROR, MelaneeWorkbenchStatus.CANNOT_FIND_PLUGIN, message, null, Activator.PLUGIN_ID), StatusManager.LOG);
				return null;
			}
			
			transformator = (ITableVisualizationService)id2TableVisualizationServiceConfigurationElement.get(id).createExecutableExtension("class");
			id2TableVisualizationServiceInstance.put(id, transformator);
		}
		
		return transformator;
	}
	
	/**
	 * Returns the active instance of the Form Visualization Service. For performance improvements two caches are used.
	 * One to cache the IConfigurationElements and one to cache the visualization service instance.
	 *
	 * 
	 * @return A cached instance of the visualization service
	 * 
	 * @throws CoreException
	 */
	public ITableVisualizationService getActiveTableVisualizationService() throws CoreException{
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		
		return getTableVisualizationService(store.getString(PreferenceConstants.P_ACTIVE_TABLE_VISUALIZATION_ENGINE));
	}
	
	/**
	 * Returns an instance of the Textual Visualization Service. For performance improvements two caches are used.
	 * One to cache the IConfigurationElements and one to cache the visualization service instance. Returns null
	 * in case that an empty string or null is provided as id.
	 * 
	 * @param id ID of the registered extension point
	 * 
	 * @return A cached instance of the visualization service
	 * 
	 * @throws CoreException
	 */
	public ITextualVisualizationService getTextualVisualizationService(String id) throws CoreException{
		ITextualVisualizationService transformator = id2TextualVisualizationServiceInstance.get(id);
		
		if (id == null
				|| id.length() == 0)
			return null;
		
		if (transformator == null)
		{
			if (id2TextualVisualizationServiceConfigurationElement.get(id) == null){
				String message = MelaneeWorkbenchStatus.CANNOT_FIND_PLUGIN_MESSAGE + id;
				StatusManager.getManager().handle(new MelaneeWorkbenchStatus(IStatus.ERROR, MelaneeWorkbenchStatus.CANNOT_FIND_PLUGIN, message, null, Activator.PLUGIN_ID), StatusManager.LOG);
				return null;
			}
			
			transformator = (ITextualVisualizationService)id2TextualVisualizationServiceConfigurationElement.get(id).createExecutableExtension("class");
			id2TextualVisualizationServiceInstance.put(id, transformator);
		}
		
		return transformator;
	}
	
	/**
	 * Returns the active instance of the Textual Visualization Service. For performance improvements two caches are used.
	 * One to cache the IConfigurationElements and one to cache the visualization service instance.
	 *
	 * 
	 * @return A cached instance of the visualization service
	 * 
	 * @throws CoreException
	 */
	public ITextualVisualizationService getActiveTextualVisualizationService() throws CoreException{
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		
		return getTextualVisualizationService(store.getString(PreferenceConstants.P_ACTIVE_TEXTUAL_VISUALIZATION_ENGINE));
	}
	
	/**
	 * Returns an instance of the Visualization Service. For performance improvements two caches are used.
	 * One to cache the IConfigurationElements and one to cache the visualization service instance. Returns null
	 * in case that an empty string or null is provided as id.
	 * 
	 * @param id ID of the registered extension point
	 * 
	 * @return A cached instance of the visualization service
	 * 
	 * @throws CoreException
	 */
	public IGraphicalVisualizationService getGraphicalVisualizationService(String id) throws CoreException{
		IGraphicalVisualizationService transformator = id2GraphicalVisualizationServiceInstance.get(id);
		
		if (id == null
				|| id.length() == 0)
			return null;
		
		if (transformator == null)
		{
			if (id2GraphicalVisualizationServiceConfigurationElement.get(id) == null){
				String message = MelaneeWorkbenchStatus.CANNOT_FIND_PLUGIN_MESSAGE + id;
				StatusManager.getManager().handle(new MelaneeWorkbenchStatus(IStatus.ERROR, MelaneeWorkbenchStatus.CANNOT_FIND_PLUGIN, message, null, Activator.PLUGIN_ID), StatusManager.LOG);
				return null;
			}
			
			transformator = (IGraphicalVisualizationService)id2GraphicalVisualizationServiceConfigurationElement.get(id).createExecutableExtension("class");
			id2GraphicalVisualizationServiceInstance.put(id, transformator);
		}
		
		return transformator;
	}
	
	/**
	 * Returns the active instance of the Visualization Service. For performance improvements two caches are used.
	 * One to cache the IConfigurationElements and one to cache the visualization service instance.
	 *
	 * 
	 * @return A cached instance of the visualization service
	 * 
	 * @throws CoreException
	 */
	public IGraphicalVisualizationService getActiveGraphicalVisualizationService() throws CoreException{
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		
		return getGraphicalVisualizationService(store.getString(PreferenceConstants.P_ACTIVE_GRAPHICAL_VISUALIZATION_ENGINE));
	}
	
	/**
	 * Returns an instance of the Reasoning Service. For performance improvements two caches are used.
	 * One to cache the IConfigurationElements and one to cache the visualization service instance. Returns null
	 * in case that an empty string or null is provided as id.
	 * 
	 * @param id ID of the registered extension point
	 * 
	 * @return A cached instance of the reasoning service
	 * 
	 * @throws CoreException
	 */
	public IReasoningService getReasoningService(String id) throws CoreException{
		IReasoningService reasoner = id2ReasoningServiceInstance.get(id);
		
		if (id == null
				|| id.length() == 0)
			return null;
		
		if (reasoner == null && id2ReasoningServiceConfigurationElement.get(id) != null)
		{
			if (id2ReasoningServiceConfigurationElement.get(id) == null){
				String message = MelaneeWorkbenchStatus.CANNOT_FIND_PLUGIN_MESSAGE + id;
				StatusManager.getManager().handle(new MelaneeWorkbenchStatus(IStatus.ERROR, MelaneeWorkbenchStatus.CANNOT_FIND_PLUGIN, message, null, Activator.PLUGIN_ID), StatusManager.LOG);
				return null;
			}
			
			reasoner = (IReasoningService)id2ReasoningServiceConfigurationElement.get(id).createExecutableExtension("class");
			id2ReasoningServiceInstance.put(id, reasoner);
		}
		
		return reasoner;
	}
	
	/**
	 * Returns the active Reasoning Service. For performance improvements two caches are used.
	 * One to cache the IConfigurationElements and one to cache the visualization service instance.
	 * 
	 * 
	 * @return A cached instance of the reasoning service
	 * 
	 * @throws CoreException
	 */
	public IReasoningService getActiveReasoningService() throws CoreException{
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		
		IReasoningService reasoner = getReasoningService(store.getString(PreferenceConstants.P_ACTIVE_REASONING_ENGINE)); 
		return reasoner != null ? reasoner.Instance() : null;
	}
	
	/**
	 * Returns an instance of the Refactoring Service. For performance improvements two caches are used.
	 * One to cache the IConfigurationElements and one to cache the visualization service instance. Returns null
	 * in case that an empty string or null is provided as id.
	 * 
	 * @param id ID of the registered extension point
	 * 
	 * @return A cached instance of the reasoning service
	 * 
	 * @throws CoreException
	 */
	public IEmendationService getEmendationService(String id) throws CoreException{
		IEmendationService emender = id2EmendationServiceInstance.get(id);
		
		if (id == null
				|| id.length() == 0)
			return null;
		
		if (emender == null)
		{
			if (id2EmendationServiceConfigurationElement.get(id) == null){
				String message = MelaneeWorkbenchStatus.CANNOT_FIND_PLUGIN_MESSAGE + id;
				StatusManager.getManager().handle(new MelaneeWorkbenchStatus(IStatus.ERROR, MelaneeWorkbenchStatus.CANNOT_FIND_PLUGIN, message, null, Activator.PLUGIN_ID), StatusManager.LOG);
				return null;
			}
			
			emender = (IEmendationService)id2EmendationServiceConfigurationElement.get(id).createExecutableExtension("class");
			id2EmendationServiceInstance.put(id, emender);
		}
		
		return emender;
	}
	
	/**
	 * Returns the active Refactoring Service. For performance improvements two caches are used.
	 * One to cache the IConfigurationElements and one to cache the visualization service instance.
	 * 
	 * @param id ID of the registered extension point
	 * 
	 * @return A cached instance of the reasoning service
	 * 
	 * @throws CoreException
	 */
	public IEmendationService getActiveEmendationService() throws CoreException{
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		
		return getEmendationService(store.getString(PreferenceConstants.P_ACTIVE_EMENDATION_ENGINE));
	}
	
	/**
	 * Returns an instance of the Designation Service. For performance improvements two caches are used.
	 * One to cache the IConfigurationElements and one to cache the visualization service instance. Returns null
	 * in case that an empty string or null is provided as id.
	 * 
	 * @param id ID of the registered extension point
	 * 
	 * @return A cached instance of the reasoning service
	 * 
	 * @throws CoreException
	 */
	public IDesignationService getDesignationService(String id) throws CoreException{
		IDesignationService designationService = id2DesignationServiceInstance.get(id);
		
		if (id == null
				|| id.length() == 0)
			return null;
		
		if (designationService == null)
		{
			if (id2DesignationServiceConfigurationElement.get(id) == null){
				String message = MelaneeWorkbenchStatus.CANNOT_FIND_PLUGIN_MESSAGE + id;
				StatusManager.getManager().handle(new MelaneeWorkbenchStatus(IStatus.ERROR, MelaneeWorkbenchStatus.CANNOT_FIND_PLUGIN, message, null, Activator.PLUGIN_ID), StatusManager.LOG);
				return null;
			}
			
			designationService = (IDesignationService)id2DesignationServiceConfigurationElement.get(id).createExecutableExtension("class");
			id2DesignationServiceInstance.put(id, designationService);
		}
		
		return designationService;
	}
	
	/**
	 * Returns the active Designation Indication Service. For performance improvements two caches are used.
	 * One to cache the IConfigurationElements and one to cache the visualization service instance.
	 * 
	 * @param id ID of the registered extension point
	 * 
	 * @return A cached instance of the reasoning service
	 * 
	 * @throws CoreException
	 */
	public IDesignationService getActiveDesignationService() throws CoreException{
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		
		return getDesignationService(store.getString(PreferenceConstants.P_ACTIVE_DESIGNATION_SERVICE));
	}
	
	/**
	 * Returns an instance of the DSL Service. For performance improvements two caches are used.
	 * One to cache the IConfigurationElements and one to cache the visualization service instance. Returns null
	 * in case that an empty string or null is provided as id.
	 * 
	 * @param id ID of the registered extension point
	 * 
	 * @return A cached instance of the reasoning service
	 * 
	 * @throws CoreException
	 */
	public IDSLService getDSLService(String id) throws CoreException{
		IDSLService dslService = id2DSLServiceInstance.get(id);
		
		if (id == null
				|| id.length() == 0)
			return null;
		
		if (dslService == null)
		{
			if (id2DSLServiceConfigurationElement.get(id) == null){
				String message = MelaneeWorkbenchStatus.CANNOT_FIND_PLUGIN_MESSAGE + id;
				StatusManager.getManager().handle(new MelaneeWorkbenchStatus(IStatus.ERROR, MelaneeWorkbenchStatus.CANNOT_FIND_PLUGIN, message, null, Activator.PLUGIN_ID), StatusManager.LOG);
				return null;
			}
			
			dslService = (IDSLService)id2DSLServiceConfigurationElement.get(id).createExecutableExtension("class");
			id2DSLServiceInstance.put(id, dslService);
		}
		
		return dslService;
	}
	
	/**
	 * Returns the active DSL Service. For performance improvements two caches are used.
	 * One to cache the IConfigurationElements and one to cache the visualization service instance.
	 * 
	 * @param id ID of the registered extension point
	 * 
	 * @return A cached instance of the reasoning service
	 * 
	 * @throws CoreException
	 */
	public IDSLService getActiveDSLService() throws CoreException{
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		
		return getDSLService(store.getString(PreferenceConstants.P_ACTIVE_DSL_ENGINE));
	}
	
	/**
	 * Returns an instance of the PopupBarButtonProvider. For performance improvements two caches are used.
	 * One to cache the IConfigurationElements and one to cache the visualization service instance. Returns null
	 * in case that an empty string or null is provided as id.
	 * 
	 * @param id ID of the registered extension point
	 * 
	 * @return A cached instance of the reasoning service
	 * 
	 * @throws CoreException
	 */
	public IPopupToolBarProvider getPopUpBarButtonProvider(String id) throws CoreException{
		IPopupToolBarProvider popupBarToolProvider = id2IPopupToolBarProviderInstance.get(id);
		
		if (id == null
				|| id.length() == 0)
			return null;
		
		if (popupBarToolProvider == null)
		{
			if (id2IPopupToolBarProviderConfigurationElement.get(id) == null){
				String message = MelaneeWorkbenchStatus.CANNOT_FIND_PLUGIN_MESSAGE + id;
				StatusManager.getManager().handle(new MelaneeWorkbenchStatus(IStatus.ERROR, MelaneeWorkbenchStatus.CANNOT_FIND_PLUGIN, message, null, Activator.PLUGIN_ID), StatusManager.LOG);
				return null;
			}
			
			popupBarToolProvider = (IPopupToolBarProvider)id2IPopupToolBarProviderConfigurationElement.get(id).createExecutableExtension("class");
			id2IPopupToolBarProviderInstance.put(id, popupBarToolProvider);
		}
		
		return popupBarToolProvider;
	}
	
	/**
	 * Returns instances of all PopupBarButtonProvider. For performance improvements two caches are used.
	 * One to cache the IConfigurationElements and one to cache the visualization service instance.
	 * 
	 * @param id ID of the registered extension point
	 * 
	 * @return A cached instance of the reasoning service
	 * 
	 * @throws CoreException
	 */
	public List<IPopupToolBarProvider> getAllPopUpBarButtonProvider() throws CoreException{
		List<IPopupToolBarProvider> popupBarToolProviders = new ArrayList<IPopupToolBarProvider>(id2IPopupToolBarProviderInstance.keySet().size()); 
		
		for (String id : id2IPopupToolBarProviderConfigurationElement.keySet()){
			popupBarToolProviders.add(getPopUpBarButtonProvider(id));
		}
		
		return popupBarToolProviders;
	}
	
	/**
	 * Returns an instance of the Visualization Service. For performance improvements two caches are used.
	 * One to cache the IConfigurationElements and one to cache the visualization service instance. Returns null
	 * in case that an empty string or null is provided as id.
	 * 
	 * @param id ID of the registered extension point
	 * 
	 * @return A cached instance of the visualization service
	 * 
	 * @throws CoreException
	 */
	public IValidationService getValidationService(String id) throws CoreException{
		IValidationService validator = id2IValidationServiceInstance.get(id);
		
		if (id == null
				|| id.length() == 0)
			return null;
		
		if (validator == null)
		{
			if (id2IValidationServiceConfigurationElement.get(id) == null){
				String message = MelaneeWorkbenchStatus.CANNOT_FIND_PLUGIN_MESSAGE + id;
				StatusManager.getManager().handle(new MelaneeWorkbenchStatus(IStatus.ERROR, MelaneeWorkbenchStatus.CANNOT_FIND_PLUGIN, message, null, Activator.PLUGIN_ID), StatusManager.LOG);
				return null;
			}
			
			validator = (IValidationService)id2IValidationServiceConfigurationElement.get(id).createExecutableExtension("class");
			id2IValidationServiceInstance.put(id, validator);
		}
		
		return validator;
	}
	
	/**
	 * Returns the active instance of the Validation Service. For performance improvements two caches are used.
	 * One to cache the IConfigurationElements and one to cache the validation service instance.
	 *
	 * 
	 * @return A cached instance of the visualization service
	 * 
	 * @throws CoreException
	 */
	public IValidationService getActiveValidationService() throws CoreException{
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		
		return getValidationService(store.getString(PreferenceConstants.P_ACTIVE_VALIDATION_SERVICE));
	}
	
	/**
	 * Returns an instance of the Visualization Service. For performance improvements two caches are used.
	 * One to cache the IConfigurationElements and one to cache the visualization service instance. Returns null
	 * in case that an empty string or null is provided as id.
	 * 
	 * @param id ID of the registered extension point
	 * 
	 * @return A cached instance of the visualization service
	 * 
	 * @throws CoreException
	 */
	public IConstraintLanguageService getConstraintLanguageService(String id) throws CoreException{
		IConstraintLanguageService languageService = id2IConstraintLanguageServiceInstance.get(id);
		
		if (id == null
				|| id.length() == 0)
			return null;
		
		if (languageService == null)
		{
			if (id2IConstraintLanguageServiceConfigurationElement.get(id) == null){
				String message = MelaneeWorkbenchStatus.CANNOT_FIND_PLUGIN_MESSAGE + id;
				StatusManager.getManager().handle(new MelaneeWorkbenchStatus(IStatus.ERROR, MelaneeWorkbenchStatus.CANNOT_FIND_PLUGIN, message, null, Activator.PLUGIN_ID), StatusManager.LOG);
				return null;
			}
			
			languageService = (IConstraintLanguageService)id2IConstraintLanguageServiceConfigurationElement.get(id).createExecutableExtension("class");
			id2IConstraintLanguageServiceInstance.put(id, languageService);
		}
		
		return languageService;
	}
	
	/**
	 * Returns the active instance of the Validation Service. For performance improvements two caches are used.
	 * One to cache the IConfigurationElements and one to cache the validation service instance.
	 *
	 * 
	 * @return A cached instance of the visualization service
	 * 
	 * @throws CoreException
	 */
	public IConstraintLanguageService getActiveConstraintLanguageService() throws CoreException{
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		
		return getConstraintLanguageService(store.getString(PreferenceConstants.P_ACTIVE_CONSTRAINT_LANGUAGE_SERVICE));
	}
	
	
	/**
	 * Returns an instance of the Application Visualization Service. For performance improvements two caches are used.
	 * One to cache the IConfigurationElements and one to cache the visualization service instance. Returns null
	 * in case that an empty string or null is provided as id.
	 * 
	 * @param id ID of the registered extension point
	 * 
	 * @return A cached instance of the visualization service
	 * 
	 * @throws CoreException
	 */
	public IApplicationVisualizationService getApplicationVisualizationService(String id) throws CoreException{
		IApplicationVisualizationService appVisualizer = id2IApplicationVisualizationServiceInstance.get(id);
		
		if (id == null
				|| id.length() == 0)
			return null;
		
		if (appVisualizer == null)
		{
			if (id2IApplicationVisualizationServiceConfigurationElement.get(id) == null){
				String message = MelaneeWorkbenchStatus.CANNOT_FIND_PLUGIN_MESSAGE + id;
				StatusManager.getManager().handle(new MelaneeWorkbenchStatus(IStatus.ERROR, MelaneeWorkbenchStatus.CANNOT_FIND_PLUGIN, message, null, Activator.PLUGIN_ID), StatusManager.LOG);
				return null;
			}
			
			appVisualizer = (IApplicationVisualizationService)id2IApplicationVisualizationServiceConfigurationElement.get(id).createExecutableExtension("class");
			id2IApplicationVisualizationServiceInstance.put(id, appVisualizer);
		}
		
		return appVisualizer;
	}
	
	/**
	 * Returns the active instance of the Validation Service. For performance improvements two caches are used.
	 * One to cache the IConfigurationElements and one to cache the validation service instance.
	 *
	 * 
	 * @return A cached instance of the visualization service
	 * 
	 * @throws CoreException
	 */
	public IApplicationVisualizationService getActiveApplicationVisualizationService() throws CoreException{
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		
		return getApplicationVisualizationService(store.getString(PreferenceConstants.P_ACTIVE_APPLICATION_VISUALIZATION_ENGINE));
	}
}
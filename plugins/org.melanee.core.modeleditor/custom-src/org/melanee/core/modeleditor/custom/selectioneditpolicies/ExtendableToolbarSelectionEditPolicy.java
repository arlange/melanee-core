/*******************************************************************************
 * Copyright (c) 2013 - 2016 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Ralph Gerbig - initial API and implementation and initial documentation
 *******************************************************************************/
package org.melanee.core.modeleditor.custom.selectioneditpolicies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.tools.AbstractPopupBarTool;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ocl.ParserException;
import org.eclipse.swt.graphics.Image;
import org.melanee.core.common.emf.ocl.OCLHelper;
import org.melanee.core.modeleditor.custom.Activator;
import org.melanee.core.modeleditor.custom.popupbartools.InstantiatateSinglePopupBarTool;
import org.melanee.core.modeleditor.custom.popupbartools.InstantiatateWithContentPopupBar;
import org.melanee.core.modeleditor.custom.popupbartools.NotationSelectionPopupBarTool;
import org.melanee.core.modeleditor.custom.popupbartools.NotationUpdatePopupBarTool;
import org.melanee.core.modeleditor.custom.popupbartools.SeparatorPopupBarTool;
import org.melanee.core.modeleditor.custom.popupbartools.TogglePopupBarTool;
import org.melanee.core.models.plm.PLM.AbstractDSLVisualizer;
import org.melanee.core.models.plm.PLM.Connection;
import org.melanee.core.models.plm.PLM.Entity;
import org.melanee.core.models.plm.PLM.Inheritance;
import org.melanee.core.models.plm.PLM.Level;
import org.melanee.core.models.plm.PLM.Method;
import org.melanee.core.workbench.ExtensionPointService;
import org.melanee.core.workbench.interfaces.IPopupToolBarProvider;
import org.melanee.core.workbench.interfaces.IPopupToolBarProvider.PopupToolBarMenuWrapper;
import org.melanee.core.workbench.interfaces.IPopupToolBarProvider.PopupToolBarToolWrapper;
import org.melanee.core.workbench.interfaces.IVisualizationServiceBase;

/**
 * 
 * This is a toolbar that is extandable via an extension point.
 *
 */
public class ExtendableToolbarSelectionEditPolicy extends
		BaseToolbarSelectionEditPolicy {
	
	/**
	 * We override populatePopupBars because we want to replace what is shown.
	 * If the defult content is to be extended, fillPopupBarDescritpor needs
	 * to be called.
	 */
	@Override
	protected void populatePopupBars() {
		
		//No default tools for adding semantic items are wanted
		//super.fillPopupBarDescriptors();

		AbstractPopupBarTool tool = null;

		ImageDescriptor imageDescriptor = null;
		Image image = null;
		
		try {
			
			//This list is used for ordering tools by groups
			Map<String, List<PopupToolBarToolWrapper>> groups2tools = new HashMap<String, List<PopupToolBarToolWrapper>>();
			
			EObject semanticElement = ((IGraphicalEditPart)getHost()).resolveSemanticElement(); 
			
			/***********************************************************
			 * Graphical Notation Selection
			 ***********************************************************/
			if (!(semanticElement instanceof Inheritance)
					&& ! (semanticElement instanceof Method))
				{
				
				List<PopupToolBarToolWrapper> wrappers = groups2tools.get("DSL");
				
				if (wrappers == null)
					wrappers = new ArrayList<PopupToolBarToolWrapper>();
				
				PopupToolBarToolWrapper graphToolWrapper = null;
				
				if(ExtensionPointService.Instance().getActiveGraphicalVisualizationService() != null){
					graphToolWrapper = createMenuForFormat(IVisualizationServiceBase.FORMAT_GRAPH);
					wrappers.add(graphToolWrapper);
				}
				
				if(ExtensionPointService.Instance().getActiveTextualVisualizationService() != null){
					PopupToolBarToolWrapper textToolWrapper = createMenuForFormat(IVisualizationServiceBase.FORMAT_TEXT);
					wrappers.add(textToolWrapper);
				}
				
				if(ExtensionPointService.Instance().getActiveTableVisualizationService() != null){
					PopupToolBarToolWrapper tableToolWrapper = createMenuForFormat(IVisualizationServiceBase.FORMAT_TABLE);
					wrappers.add(tableToolWrapper);
				}
				
				if(ExtensionPointService.Instance().getActiveFormVisualizationService() != null){
					PopupToolBarToolWrapper formToolWrapper = createMenuForFormat(IVisualizationServiceBase.FORMAT_FORM);
					wrappers.add(formToolWrapper);
				}
				
				if(ExtensionPointService.Instance().getActiveApplicationVisualizationService() != null){
					PopupToolBarToolWrapper appToolWrapper = createMenuForFormat(IVisualizationServiceBase.FORMAT_APP);
					wrappers.add(appToolWrapper);
				}
				
				if (wrappers.size() > 0)
					groups2tools.put("DSL", wrappers);
			}
			/***********************************************************
			 * Expand/Collapse button
			 ***********************************************************/
			if (!(semanticElement instanceof Entity)
					&& ! (semanticElement instanceof Level)
					&& ! (semanticElement instanceof Package)
					&& ! (semanticElement instanceof Method)
				){
				tool = new TogglePopupBarTool(getHost(), null);
		
				imageDescriptor = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "/icons/popup/toggle16.gif");
				image = imageDescriptor.createImage();
				
				PopupToolBarToolWrapper toolWrapper = new PopupToolBarToolWrapper(image, tool, "Expand/Collapse", "connector");
				
				List<PopupToolBarToolWrapper> wrappers = groups2tools.get("connector");
				
				if (wrappers == null)
					wrappers = new ArrayList<PopupToolBarToolWrapper>();
				
				wrappers.add(toolWrapper);
				groups2tools.put("connector", wrappers);
			}
			/***********************************************************
			 * Add remove parameter
			 ***********************************************************/
			if (semanticElement instanceof Method){
				tool = new TogglePopupBarTool(getHost(), null);
		
				List<PopupToolBarToolWrapper> wrappers = groups2tools.get("method");
				
				if (wrappers == null)
					wrappers = new ArrayList<PopupToolBarToolWrapper>();
				
				imageDescriptor = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "/icons/popup/parameter_plus16.gif");
				image = imageDescriptor.createImage();
				PopupToolBarToolWrapper toolWrapper = new PopupToolBarToolWrapper(image, tool, "Add Parameter", "method");
				wrappers.add(toolWrapper);
				
				imageDescriptor = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "/icons/popup/parameter_minus16.gif");
				image = imageDescriptor.createImage();
				toolWrapper = new PopupToolBarToolWrapper(image, tool, "Remove Parameter", "method");
				wrappers.add(toolWrapper);
				
				groups2tools.put("method", wrappers);
			}
			/***********************************************************
			 * Instantiate
			 ***********************************************************/
			if (((IGraphicalEditPart)getHost()).resolveSemanticElement() instanceof Entity
					|| ((IGraphicalEditPart)getHost()).resolveSemanticElement() instanceof Connection
				){
				
				//*************************************************
				//The menu for secletion of the instantiation task
				//*************************************************
				imageDescriptor = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "/icons/popup/instantiate16.gif");
				image = imageDescriptor.createImage();
				PopupToolBarMenuWrapper menu = new PopupToolBarMenuWrapper(image, null, "Instantiate Model Element", new LinkedList<PopupToolBarToolWrapper>(), "DSL");
				
				//*************************************************
				//Do a single instantiation
				//*************************************************
				tool =
						new InstantiatateSinglePopupBarTool(getHost(), null);
				imageDescriptor = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "/icons/popup/instantiate_single16.gif");
				image = imageDescriptor.createImage();
				
				PopupToolBarToolWrapper toolWrapper = new PopupToolBarToolWrapper(image, tool, "Instantiate without Content", "clabject");
				
				menu.getChildren().add(toolWrapper);
				
				
				
				//*************************************************
				//Do an instantiation including content
				//*************************************************
				tool =
						new InstantiatateWithContentPopupBar(getHost(), null);
				imageDescriptor = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "/icons/popup/instantiate_content16.gif");
				image = imageDescriptor.createImage();
				
				toolWrapper = new PopupToolBarToolWrapper(image, tool, "Instantiate with Content", "clabject");
				
				
				//*************************************************
				//Add dropdown to toolbar
				//*************************************************
				List<PopupToolBarToolWrapper> wrappers = groups2tools.get("clabject");
				menu.getChildren().add(toolWrapper);
				
				if (wrappers == null)
					wrappers = new ArrayList<PopupToolBarToolWrapper>();
				
				wrappers.add(menu);
				groups2tools.put("clabject", wrappers);
			}
			
			/***********************************************************
			 * build the toolbar with tools provided by extension point
			 ***********************************************************/
			//First get all providers registered in the extension point
			for (IPopupToolBarProvider provider : ExtensionPointService.Instance().getAllPopUpBarButtonProvider()){
				//Get the popup bar tool for the model element the tool is built for
				for (PopupToolBarToolWrapper toolWrapper : provider.getPopUpToolbarButtonsForDiagramElement(getHost())){
					//Get all wrappers stored under ID of tool
					List<PopupToolBarToolWrapper> wrappersForGroup = groups2tools.get(toolWrapper.getGroupId());
					
					//No wrappers are stored -> create new list for this groupo
					if (wrappersForGroup == null){
						wrappersForGroup = new ArrayList<PopupToolBarToolWrapper>();
						groups2tools.put(toolWrapper.getGroupId(), wrappersForGroup);
					}
					
					//Add tool to list for this group
					wrappersForGroup.add(toolWrapper);
				}	
				//addPopupBarDescriptor(null, (Image)toolWrapper.getImage(), (AbstractPopupBarTool)toolWrapper.getTool(), toolWrapper.getText());	
			}
			
			//This is used to count the amount of groups that are processed
			int groupCounter = 0;
			//Iterate over all group
			for (List<PopupToolBarToolWrapper> wrapperGroup : groups2tools.values()){
				
				//Add the tools of the group to the toolbar
				for (PopupToolBarToolWrapper toolWrapper : wrapperGroup)
					if(toolWrapper instanceof PopupToolBarMenuWrapper){
						List<ToolBarItemDescriptor> childTools = new ArrayList<ToolBarItemDescriptor>();
						for(PopupToolBarToolWrapper childTool : ((PopupToolBarMenuWrapper) toolWrapper).getChildren())
							childTools.add(new ToolBarItemDescriptor(childTool.getText(), (Image)childTool.getImage(), null, (AbstractPopupBarTool)childTool.getTool()));
						addPopupBarMenuDescriptor((Image)toolWrapper.getImage(), (AbstractPopupBarTool)toolWrapper.getTool(), toolWrapper.getText(), childTools);
					}
					else
						addPopupBarDescriptor(null, (Image)toolWrapper.getImage(), (AbstractPopupBarTool)toolWrapper.getTool(), toolWrapper.getText());
				
				//Add an separator between this and the next group	
				AbstractPopupBarTool seperatorTool =
						new SeparatorPopupBarTool(getHost(), null);
				
				imageDescriptor = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "/icons/popup/seperator16.gif");
				image = imageDescriptor.createImage();
				
				groupCounter++;
				//No separator is wanted after the last group
				if(groupCounter < groups2tools.values().size())
				{
					addPopupBarDescriptor(null, image, seperatorTool, SeparatorPopupBarTool.TOOL_TIP);
					continue;
				}
			}
		} 
		catch (CoreException e) {
			e.printStackTrace();
		}
		
		/***********************************************************
		 * Introspect button
		 ***********************************************************/
		/*if (((IGraphicalEditPart)getHost()).resolveSemanticElement() instanceof Clabject){
			tool =
					new IntrospectPopupBarTool(getHost(), null);
	
			imageDescriptor = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "/icons/introspect16.gif");
			image = imageDescriptor.createImage();
			
			addPopupBarDescriptor(null, image, tool, "Introspect");
		}*/
	}
	
	/**
	 * 
	 * @param format supported formats are graph, text, table and form 
	 * @return
	 */
	private PopupToolBarToolWrapper createMenuForFormat(String format){
		ArrayList<PopupToolBarToolWrapper> children = new ArrayList<PopupToolBarToolWrapper>();
		
		//Add derived notation
		AbstractPopupBarTool tool = new NotationSelectionPopupBarTool(getHost(), null, IVisualizationServiceBase.NOTATION_DERIVED, format);
		
		
		ImageDescriptor imageDescriptor = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "/icons/popup/derived16.gif");
		Image image = imageDescriptor.createImage();
		PopupToolBarToolWrapper toolWrapper = new PopupToolBarToolWrapper(image, tool, "Derived", "clabject");
		children.add(toolWrapper);
		
		//Add GPL notation
		tool = new NotationSelectionPopupBarTool(getHost(), null, IVisualizationServiceBase.NOTATION_LML, format);
		
		imageDescriptor = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "/icons/popup/predefined16.gif");
		image = imageDescriptor.createImage();
		toolWrapper = new PopupToolBarToolWrapper(image, tool, "LML", "clabject");
		children.add(toolWrapper);
		
		// Collect all graphical DSL notations as children
		try {
			Set<AbstractDSLVisualizer> set =  (Set<AbstractDSLVisualizer>)OCLHelper.execute(((IGraphicalEditPart)getHost()).resolveSemanticElement(), "AbstractDSLVisualizer.allInstances()");
			Iterator<AbstractDSLVisualizer> iterator = set.iterator();
			List<String> addedNotations = new ArrayList<String>();
			while(iterator.hasNext()){
				AbstractDSLVisualizer v = iterator.next();
				if (v.format().equals(format)){
					if(! addedNotations.contains(v.getNotation())){
						tool = new NotationSelectionPopupBarTool(getHost(), null, v.getNotation(), format);
						
						imageDescriptor = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "/icons/popup/userdefined16.gif");
						image = imageDescriptor.createImage();
						toolWrapper = new PopupToolBarToolWrapper(image, tool, v.getNotation(), "clabject");
						children.add(toolWrapper);
						addedNotations.add(v.getNotation());
					}
				}
			}
		} catch (ParserException e) {
			e.printStackTrace();
		}
		
		
		
		
		String tooltip;
		tool = new NotationUpdatePopupBarTool(getHost(), null, format);
		
		if(format.equals(IVisualizationServiceBase.FORMAT_FORM)){
			tooltip = "Choose Form Notation";
			imageDescriptor = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "/icons/popup/formnotation16.gif");
		}
		else if(format.equals(IVisualizationServiceBase.FORMAT_GRAPH)){
			tooltip = "Choose Graph Notation";
			imageDescriptor = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "/icons/popup/graphnotation16.gif");
		}
		else if(format.equals(IVisualizationServiceBase.FORMAT_TEXT)){
			tooltip = "Choose Text Notation";
			imageDescriptor = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "/icons/popup/textnotation16.gif");
		}
		else if(format.equals(IVisualizationServiceBase.FORMAT_TABLE)){
			tooltip = "Choose Table Notation";
			imageDescriptor = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "/icons/popup/tablenotation16.gif");
		}
		else{
			tooltip = "Choose Applicaction Notation";
			imageDescriptor = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "/icons/popup/appnotation16.gif");
		}
		image = imageDescriptor.createImage();
		
		return new PopupToolBarMenuWrapper(image, tool, tooltip, children, "DSL");
	}
}

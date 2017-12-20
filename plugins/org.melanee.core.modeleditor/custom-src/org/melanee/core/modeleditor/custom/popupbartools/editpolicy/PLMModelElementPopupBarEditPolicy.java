///*******************************************************************************
// * Copyright (c) 2011, 2012 University of Mannheim: Chair for Software Engineering
// * All rights reserved. This program and the accompanying materials
// * are made available under the terms of the Eclipse Public License v1.0
// * which accompanies this distribution, and is available at
// * http://www.eclipse.org/legal/epl-v10.html
// *
// * Contributors:
// *    Ralph Gerbig - initial API and implementation and initial documentation
// *******************************************************************************/
//package org.melanee.core.modeleditor.custom.popupbartools.editpolicy;
//
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.eclipse.core.runtime.CoreException;
//import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
//import org.eclipse.gmf.runtime.diagram.ui.editpolicies.PopupBarEditPolicy;
//import org.eclipse.gmf.runtime.diagram.ui.tools.AbstractPopupBarTool;
//import org.eclipse.jface.resource.ImageDescriptor;
//import org.eclipse.swt.graphics.Image;
//import org.melanee.core.modeleditor.custom.Activator;
//import org.melanee.core.modeleditor.custom.popupbartools.InstantiatatePopupBarTool;
//import org.melanee.core.modeleditor.custom.popupbartools.OpenTextualModelEditorPopupBarTool;
//import org.melanee.core.modeleditor.custom.popupbartools.SeparatorPopupBarTool;
//import org.melanee.core.modeleditor.custom.popupbartools.TogglePopupBarTool;
//import org.melanee.core.models.plm.PLM.Connection;
//import org.melanee.core.models.plm.PLM.Entity;
//import org.melanee.core.models.plm.PLM.Model;
//import org.melanee.core.models.plm.PLM.SetRelationship;
//import org.melanee.core.workbench.ExtensionPointService;
//import org.melanee.core.workbench.interfaces.IPopupToolBarProvider;
//import org.melanee.core.workbench.interfaces.IPopupToolBarProvider.PopupToolBarToolWrapper;
//
//public class PLMModelElementPopupBarEditPolicy extends PopupBarEditPolicy {
//	
//	@Override
//	protected void fillPopupBarDescriptors() {
//		super.fillPopupBarDescriptors();
//
//		AbstractPopupBarTool tool = null;
//
//		ImageDescriptor imageDescriptor = null;
//		Image image = null;
//		
//		try {
//			
//			//This list is used for ordering tools by groups
//			Map<String, List<PopupToolBarToolWrapper>> groups2tools = new HashMap<String, List<PopupToolBarToolWrapper>>();
//			
//			/***********************************************************
//			 * Expand/Collapse button
//			 ***********************************************************/
//			if (!(((IGraphicalEditPart)getHost()).resolveSemanticElement() instanceof Entity)
//					&& ! (((IGraphicalEditPart)getHost()).resolveSemanticElement() instanceof Model)
//					&& ! (((IGraphicalEditPart)getHost()).resolveSemanticElement() instanceof SetRelationship)
//				){
//				tool = new TogglePopupBarTool(getHost(), null);
//		
//				imageDescriptor = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "/icons/popup/toggle16.gif");
//				image = imageDescriptor.createImage();
//				
//				PopupToolBarToolWrapper toolWrapper = new PopupToolBarToolWrapper(image, tool, "Expand/Collapse", "connector");
//				
//				List<PopupToolBarToolWrapper> wrappers = groups2tools.get("connector");
//				
//				if (wrappers == null)
//					wrappers = new ArrayList<PopupToolBarToolWrapper>();
//				
//				wrappers.add(toolWrapper);
//				groups2tools.put("connector", wrappers);
//			}
//			
//			/***********************************************************
//			 * Instantiate
//			 ***********************************************************/
//			if (((IGraphicalEditPart)getHost()).resolveSemanticElement() instanceof Entity
//					|| ((IGraphicalEditPart)getHost()).resolveSemanticElement() instanceof Connection
//				){
//				tool =
//						new InstantiatatePopupBarTool(getHost(), null);
//		
//				imageDescriptor = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "/icons/popup/instantiate16.gif");
//				image = imageDescriptor.createImage();
//				
//				PopupToolBarToolWrapper toolWrapper = new PopupToolBarToolWrapper(image, tool, "Instantiate", "clabject");
//				
//				List<PopupToolBarToolWrapper> wrappers = groups2tools.get("clabject");
//				
//				if (wrappers == null)
//					wrappers = new ArrayList<PopupToolBarToolWrapper>();
//				
//				wrappers.add(toolWrapper);
//				groups2tools.put("clabject", wrappers);
//			}
//			
//			/***********************************************************
//			 * Textual Modelediting
//			 ***********************************************************/
//			if (((IGraphicalEditPart)getHost()).resolveSemanticElement() instanceof Model
//					&& ExtensionPointService.Instance().getActiveTextualVisualizationService() != null){
//				
//				tool = new OpenTextualModelEditorPopupBarTool((IGraphicalEditPart)getHost(), null);
//		
//				imageDescriptor = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "/icons/popup/text16.gif");
//				image = imageDescriptor.createImage();
//				
//				PopupToolBarToolWrapper toolWrapper = new PopupToolBarToolWrapper(image, tool, "Open in Textual Model Editor", "textualDSL");
//				
//				List<PopupToolBarToolWrapper> wrappers = groups2tools.get("textualDSL");
//				
//				if (wrappers == null)
//					wrappers = new ArrayList<PopupToolBarToolWrapper>();
//				
//				wrappers.add(toolWrapper);
//				groups2tools.put("textualDSL", wrappers);
//			}
//			
//			/***********************************************************
//			 * build the toolbar with tools provided by extension point
//			 ***********************************************************/
//			//First get all providers registered in the extension point
//			for (IPopupToolBarProvider provider : ExtensionPointService.Instance().getAllPopUpBarButtonProvider()){
//				//Get the popup bar tool for the model element the tool is built for
//				for (PopupToolBarToolWrapper toolWrapper : provider.getPopUpToolbarButtonsForDiagramElement(getHost())){
//					//Get all wrappers stored under ID of tool
//					List<PopupToolBarToolWrapper> wrappersForGroup = groups2tools.get(toolWrapper.getGroupId());
//					
//					//No wrappers are stored -> create new list for this group
//					if (wrappersForGroup == null){
//						wrappersForGroup = new ArrayList<PopupToolBarToolWrapper>();
//						groups2tools.put(toolWrapper.getGroupId(), wrappersForGroup);
//					}
//					
//					//Add tool to list for this group
//					wrappersForGroup.add(toolWrapper);
//				}	
//				//addPopupBarDescriptor(null, (Image)toolWrapper.getImage(), (AbstractPopupBarTool)toolWrapper.getTool(), toolWrapper.getText());	
//			}
//			
//			//Iterate over all group
//			for (List<PopupToolBarToolWrapper> wrapperGroup : groups2tools.values()){
//				
//				//Add the tools of the group to the toolbar
//				for (PopupToolBarToolWrapper toolWrapper : wrapperGroup)
//					addPopupBarDescriptor(null, (Image)toolWrapper.getImage(), (AbstractPopupBarTool)toolWrapper.getTool(), toolWrapper.getText());
//				
//				//Add an separator between this and the next group	
//				AbstractPopupBarTool seperatorTool =
//						new SeparatorPopupBarTool(getHost(), null);
//				
//				imageDescriptor = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "/icons/popup/seperator16.gif");
//				image = imageDescriptor.createImage();
//				
//				addPopupBarDescriptor(null, image, seperatorTool, "Separator");
//			}
//		} catch (CoreException e) {
//			e.printStackTrace();
//		}
//		
//		/***********************************************************
//		 * Introspect button
//		 ***********************************************************/
//		/*if (((IGraphicalEditPart)getHost()).resolveSemanticElement() instanceof Clabject){
//			tool =
//					new IntrospectPopupBarTool(getHost(), null);
//	
//			imageDescriptor = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "/icons/introspect16.gif");
//			image = imageDescriptor.createImage();
//			
//			addPopupBarDescriptor(null, image, tool, "Introspect");
//		}*/
//	}
//}

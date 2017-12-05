/*******************************************************************************
 * Copyright (c) 2012 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     - initial API and implementation and initial documentation
 *******************************************************************************/
package org.melanee.core.tests.ui;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Tool;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.PopupBarEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.tools.AbstractPopupBarTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swtbot.eclipse.finder.matchers.WidgetMatcherFactory;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable;
import org.eclipse.swtbot.swt.finder.results.VoidResult;
import org.eclipse.ui.internal.views.properties.tabbed.view.TabbedPropertyList;
import org.eclipse.ui.internal.views.properties.tabbed.view.TabbedPropertyList.ListElement;
import org.melanee.core.modeleditor.custom.selectioneditpolicies.BaseToolbarSelectionEditPolicy;
import org.melanee.core.modeleditor.custom.selectioneditpolicies.ExtendableToolbarSelectionEditPolicy;

public class GMFTestUtil {

	/**
	 * Executes a PopupBarTool with the specified tool tip. The button
	 * is no invoked via the UI but via calls to PopupBarEditPolicy.
	 * 
	 * @param gefEP The editpart to execute the button for
	 * @param tooltipText Tool tip of the button
	 */
	public static void executeSelectionToolBarToolWithTooltip(final IGraphicalEditPart gefEP, String tooltipText){
		BaseToolbarSelectionEditPolicy pol = (BaseToolbarSelectionEditPolicy)gefEP.getEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE);
		
		try{
			Class popupBarEditPolicy = Class.forName("org.melanee.core.modeleditor.custom.selectioneditpolicies.BaseToolbarSelectionEditPolicy");
			
			//The baloon needs to initialized otherwise a NullPointerException will happen later
			Field f = popupBarEditPolicy.getDeclaredField("myBalloon");
			f.setAccessible(true);
			Method m = popupBarEditPolicy.getDeclaredMethod("createPopupBarFigure", null);
			m.setAccessible(true);
			f.set(pol, m.invoke(pol));
			
			//First the policies popup bar needs to be populated
			Method populatePopupBars = popupBarEditPolicy.getDeclaredMethod("populatePopupBars",null);
			populatePopupBars.setAccessible(true);
			populatePopupBars.invoke(pol);
			
			//Get the popup bar descriptors
			List descriptors = new ArrayList();
			Method getPopupBarDescriptors = popupBarEditPolicy.getDeclaredMethod("getPopupBarDescriptors", null);
			getPopupBarDescriptors.setAccessible(true);
			descriptors = (List)getPopupBarDescriptors.invoke(pol);
			
			List<AbstractPopupBarTool> tools = new ArrayList<AbstractPopupBarTool>();
			
			Class popupBarDescriptor = Class.forName("org.melanee.core.modeleditor.custom.selectioneditpolicies.ToolBarItemDescriptor");
				
			for (Object descriptor : descriptors){
				Method getToolTip = popupBarDescriptor.getMethod("getToolTip", null);
				getToolTip.setAccessible(true);
				String descriptorToolTip = (String)getToolTip.invoke(descriptor);
				
				if (tooltipText.equals(descriptorToolTip)){
					Method getDragtracker = popupBarDescriptor.getMethod("getDragTracker", null);
					getDragtracker.setAccessible(true);
					DragTracker tool = (DragTracker)getDragtracker.invoke(descriptor, null);
					 
					Method getCommand = tool.getClass().getDeclaredMethod("getCommand", null);
					getCommand.setAccessible(true);
					final Command cmd = (Command)getCommand.invoke(tool);
					
					UIThreadRunnable.syncExec(new VoidResult() {
						
						@Override
						public void run() {
							gefEP.getDiagramEditDomain().getDiagramCommandStack().execute(cmd);
						}
					});
				}
			}
		}catch(IllegalAccessException e){
			e.printStackTrace();
		}
		catch(IllegalArgumentException e){
			e.printStackTrace();
		}
		catch(InvocationTargetException  e){
			e.printStackTrace();
		}
		catch(NoSuchMethodException e){
			e.printStackTrace();
		}
		catch(SecurityException e){
			e.printStackTrace();
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		catch(NoSuchFieldException e){
			e.printStackTrace();
		}
	}
	
	public static void connect(String sourceLabel, String targetLabel, SWTBotGefEditor editor){
		
		final IGraphicalEditPart target = ((IGraphicalEditPart)editor.getEditPart(targetLabel).part()).getTopGraphicEditPart();
		
		UIThreadRunnable.syncExec(new VoidResult() {
			
			@Override
			public void run() {
				final PaletteDrawer debugDrawer = new PaletteDrawer("Debug");
				final PaletteViewer palette = ((EditDomain)target.getDiagramEditDomain()).getPaletteViewer();
				palette.getPaletteRoot().add(debugDrawer);
				
				List<IElementType> types = new ArrayList<IElementType>(2);
				types.add(org.melanee.core.modeleditor.providers.PLMElementTypes.ConnectionEnd_4036);
				
				NodeToolEntry entry = new NodeToolEntry(
						"ConnectionEnd", "Creates a new ConnectionEnd", types);

				entry.setId("ConnectionEnd Creation");
				entry.setSmallIcon(org.melanee.core.modeleditor.part.PLMDiagramEditorPlugin
						.findImageDescriptor("/org.melanee.core.modeleditor/icons/connectionEnd16.gif")); //$NON-NLS-1$
				entry.setLargeIcon(org.melanee.core.modeleditor.part.PLMDiagramEditorPlugin
						.findImageDescriptor("/org.melanee.core.modeleditor/icons/connectionEnd16.gif"));

				debugDrawer.add(entry);
			}
		});	
		
		Point targetPoint = target.getFigure().getBounds().getCenter();
		target.getFigure().translateToAbsolute(targetPoint);
		
		editor.activateTool("ConnectionEnd");
		
		editor.drag(sourceLabel, targetPoint.x(), targetPoint.y());
	}
	
	/**
	 * Searches for the middle of an EditPart
	 * 
	 * @return the center of the editpart
	 */
	public static Point getEditPartCenter(IGraphicalEditPart ep){
		Point center = ep.getTopGraphicEditPart().getFigure().getBounds().getCenter();
		ep.getFigure().translateToAbsolute(center);
		return center;
	}
	
	private static class NodeToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List<IElementType> elementTypes;
		
		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description,
				List<IElementType> elementTypes) {
			super(title, description, null, null);
			this.elementTypes = elementTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeConnectionTool(elementTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}
	
	/**
	 * 
	 * Selects a properties page by clicking.
	 * 
	 * @param name the name of the tab to click on.
	 */
	public static void selectTabbedPropertiesPage(final String name, final SWTBot bot){
			UIThreadRunnable.syncExec(new VoidResult() {
			
			@Override
			public void run() {
				List<TabbedPropertyList> items = bot.getFinder().findControls(WidgetMatcherFactory.widgetOfType(TabbedPropertyList.class));
				for (TabbedPropertyList item:items){
					for (Control t : item.getTabList()){
						if (t instanceof ListElement
								&& name.equals(((ListElement)t).getTabItem().getText())){
							org.eclipse.swt.graphics.Point location = t.getLocation();
							location = t.toDisplay(location);
							SWTUtilsEx.clickXY(location.x, location.y, t);
						}
					}
				}
			}
		});
	}
	
	public static boolean tabbedPropertiesPageExists(final String name, final SWTBot bot){
		final List<ListElement> result = new ArrayList<ListElement>();
		
		UIThreadRunnable.syncExec(new VoidResult(){
			
			@Override
			public void run() {
				List<TabbedPropertyList> items = bot.getFinder().findControls(WidgetMatcherFactory.widgetOfType(TabbedPropertyList.class));
				for (TabbedPropertyList item:items){
					for (Control t : item.getTabList()){
						if (t instanceof ListElement
								&& name.equals(((ListElement)t).getTabItem().getText())){
							result.add((ListElement)t);
						}
					}
				}
			}
		});

		return result.size() > 0;
	}
}
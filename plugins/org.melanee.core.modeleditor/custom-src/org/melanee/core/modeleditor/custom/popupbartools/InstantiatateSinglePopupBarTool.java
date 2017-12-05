/*******************************************************************************
 * Copyright (c) 2011, 2012 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     - initial API and implementation and initial documentation
 *******************************************************************************/
package org.melanee.core.modeleditor.custom.popupbartools;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.EditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.Tool;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteListener;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.ChangePropertyValueRequest;
import org.eclipse.gmf.runtime.diagram.ui.tools.AbstractPopupBarTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.melanee.core.modeleditor.custom.ModelEditorConstants;
import org.melanee.core.models.plm.PLM.Element;

public class InstantiatateSinglePopupBarTool extends AbstractPopupBarTool{
	
	public InstantiatateSinglePopupBarTool(EditPart epHost, CreateRequest theRequest) {
		super(epHost, theRequest);
	}

	@Override
	protected Request createTargetRequest() {
		ChangePropertyValueRequest req = new ChangePropertyValueRequest("instantiate", "instantiate");
		return req;
	}

	@Override
	protected Command getCommand() {
		
		return new Command() {
			
			@Override
			public boolean canExecute() {
				return true;
			}
			
			@Override
			public void execute() {
				IGraphicalEditPart host = (IGraphicalEditPart)getHost();
				final PaletteDrawer instantiateDrawer = new PaletteDrawer("Instantiate");
				
				final PaletteViewer palette = ((EditDomain)host.getDiagramEditDomain()).getPaletteViewer();
				palette.getPaletteRoot().add(instantiateDrawer);
				
				List<IElementType> types = new ArrayList<IElementType>(2);
				types.add(org.melanee.core.modeleditor.providers.PLMElementTypes.Entity_3120);
				types.add(org.melanee.core.modeleditor.providers.PLMElementTypes.Entity_3105);
				
				Element type = ((Element)host.resolveSemanticElement()); 
				NodeToolEntry entry = new NodeToolEntry(
						type.getName(), "Creates a new " + type.getName(), types, instantiateDrawer);

				entry.setId("dsl." + EMFCoreUtil.getProxyID(type)
						+ ModelEditorConstants.INSTANTIATE_WITHOUT_CONTENT);
				entry.setSmallIcon(org.melanee.core.modeleditor.part.PLMDiagramEditorPlugin
						.findImageDescriptor("/org.melanee.core.modeleditor/icons/clabject16.gif")); //$NON-NLS-1$
				entry.setLargeIcon(org.melanee.core.modeleditor.part.PLMDiagramEditorPlugin
						.findImageDescriptor("/org.melanee.core.modeleditor/icons/clabject16.gif"));

				instantiateDrawer.add(entry);
				
//				instantiateDrawer.setVisible(false);
				
				palette.setActiveTool(entry);
				
//				instantiateDrawer.setVisible(false);
//				
				
				palette.addPaletteListener(new PaletteListener() {
					
					@Override
					public void activeToolChanged(PaletteViewer palette, ToolEntry tool) {
						palette.getPaletteRoot().remove(instantiateDrawer);
						palette.removePaletteListener(this);
					}
				});
			}
		};
	}
	
	private static class NodeToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List<IElementType> elementTypes;
		private final PaletteDrawer containingDrawer;
		
		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description,
				List<IElementType> elementTypes, PaletteDrawer containingDrawer) {
			super(title, description, null, null);
			this.elementTypes = elementTypes;
			this.containingDrawer = containingDrawer;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeCreationToolEx(elementTypes, containingDrawer);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}
	
	private static class UnspecifiedTypeCreationToolEx extends UnspecifiedTypeCreationTool{
		
		private PaletteDrawer containingDrawer = null;
		
		public UnspecifiedTypeCreationToolEx(List elementTypes) {
			super(elementTypes);
		}
		
		public UnspecifiedTypeCreationToolEx(List elementTypes, PaletteDrawer containingDrawer){
			this(elementTypes);
			this.containingDrawer = containingDrawer;
		}

		@Override
		protected void handleFinished() {
			containingDrawer.setVisible(true);
			super.handleFinished();
		}
	}
}
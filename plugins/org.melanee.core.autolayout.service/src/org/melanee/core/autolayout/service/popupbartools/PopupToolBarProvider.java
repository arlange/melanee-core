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
package org.melanee.core.autolayout.service.popupbartools;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.tools.AbstractPopupBarTool;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.melanee.core.autolayout.service.Activator;
import org.melanee.core.models.plm.PLM.Connection;
import org.melanee.core.models.plm.PLM.Correlation;
import org.melanee.core.workbench.interfaces.IPopupToolBarProvider;

public class PopupToolBarProvider implements IPopupToolBarProvider {

	private final String GROUP_ID = "connector";
	
	/**
	 * 
	 */
	public PopupToolBarProvider(){ 
	}

	@Override
	public List<PopupToolBarToolWrapper> getPopUpToolbarButtonsForDiagramElement(Object host) {
		IGraphicalEditPart editPart = (IGraphicalEditPart)host;
		
		List<PopupToolBarToolWrapper> result = new ArrayList<PopupToolBarToolWrapper>();
		AbstractPopupBarTool tool = null;
		ImageDescriptor imageDescriptor = null;
		Image image = null;
		
		if(editPart.resolveSemanticElement() instanceof Connection
				|| editPart.resolveSemanticElement() instanceof Correlation){
			//*********************************
			// * Add reasoning option
			// ********************************
			tool = new AutoLayoutPopupBarTool(editPart, null);
	
			imageDescriptor = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "/icons/auto_layout16.gif");
			image = imageDescriptor.createImage();
			
			result.add(new PopupToolBarToolWrapper(image, tool, "Do Auto Layout", GROUP_ID));
		}
		
		return result;
	}
}
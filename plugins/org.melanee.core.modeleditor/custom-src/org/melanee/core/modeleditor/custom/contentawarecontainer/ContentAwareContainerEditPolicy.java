/*******************************************************************************
 * Copyright (c) 2012 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Daniel Gritzner - initial API and implementation and initial documentation
 *******************************************************************************/
package org.melanee.core.modeleditor.custom.contentawarecontainer;

import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.handles.MoveHandle;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConstrainedToolbarLayoutEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.melanee.core.dsl.service.visualizationsearchalgorithm.AspectAwareVisualizationSearchAlgorithm;
import org.melanee.core.modeleditor.edit.parts.ConnectionNameExternalLabel2EditPart;
import org.melanee.core.modeleditor.edit.parts.ConnectionNameExternalLabelEditPart;
import org.melanee.core.modeleditor.edit.parts.Entity2EditPart;
import org.melanee.core.modeleditor.edit.parts.EntityEditPart;
import org.melanee.core.modeleditor.edit.policies.PLMTextSelectionEditPolicy;
import org.melanee.core.modeleditor.part.PLMVisualIDRegistry;
import org.melanee.core.models.plm.PLM.Element;
import org.melanee.core.workbench.interfaces.IVisualizationServiceBase;

/**
 * EditPolicy which ensures that an Entity can never become smaller than is necessary to render
 * all contained entities without scrollbars
 * 
 * @author gritzner
 *
 */
public class ContentAwareContainerEditPolicy extends ConstrainedToolbarLayoutEditPolicy {
	private static final int WIDTH_MARGIN = 2;
	private static final int HEIGHT_MARGIN = 4;
	
	// GENERATED CODE --- BEGIN
	protected EditPolicy createChildEditPolicy(EditPart child) {
		View childView = (View) child.getModel();
		switch (PLMVisualIDRegistry.getVisualID(childView)) {
		//This handles ConnectionEditPart and Connection2EditPart
		case ConnectionNameExternalLabelEditPart.VISUAL_ID:
		case ConnectionNameExternalLabel2EditPart.VISUAL_ID:
			return new BorderItemSelectionEditPolicy() {

				protected List createSelectionHandles() {
					MoveHandle mh = new MoveHandle(
							(GraphicalEditPart) getHost());
					mh.setBorder(null);
					return Collections.singletonList(mh);
				}
			};
		}
		if (child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE) == null) {
			if (child instanceof ITextAwareEditPart) {
				return new PLMTextSelectionEditPolicy();
			}
		}
		return super.createChildEditPolicy(child);
	}
	// GENERATED CODE --- END
	
	// Checks whether `editPart' is currently being rendered in a DSL. Returns true if it is.
	private static boolean isDSLrendered(IGraphicalEditPart editPart) {
		Boolean dslRendering = false;
		
		if(editPart instanceof EntityEditPart)
			dslRendering = AspectAwareVisualizationSearchAlgorithm.searchNotationForElement((Element)editPart.resolveSemanticElement(), IVisualizationServiceBase.FORMAT_GRAPH) != IVisualizationServiceBase.NOTATION_LML;
		if(editPart instanceof Entity2EditPart)
			dslRendering = AspectAwareVisualizationSearchAlgorithm.searchNotationForElement((Element)editPart.resolveSemanticElement(), IVisualizationServiceBase.FORMAT_GRAPH) != IVisualizationServiceBase.NOTATION_LML;
		
		if(dslRendering == null)
			return false;
		return dslRendering;
	}
	
	/**
	 * Changes a ChangeBoundsRequest such that it will not change the supplied EditPart in a way
	 * that causes scrollbars to appear in its entity content compartment.
	 * 
	 * @param editPart the EditPart
	 * @param request the ChangeBoundsRequest
	 */
	public static void constrainChangeBoundsRequest(IGraphicalEditPart editPart, ChangeBoundsRequest request) {
		if(isDSLrendered(editPart))
			return;
		
		Dimension sizeDelta = request.getSizeDelta().getCopy();
		
		if(sizeDelta.width != 0 || sizeDelta.height != 0) {
			Point moveDelta = request.getMoveDelta().getCopy();
			int direction = request.getResizeDirection();
							
			IFigure contentPane = editPart.getContentPane();
			
			Rectangle bounds = contentPane.getBounds();
			Dimension prefSize = contentPane.getPreferredSize();
			
			if(bounds.width + sizeDelta.width < prefSize.width + WIDTH_MARGIN) {
				sizeDelta.width = prefSize.width + WIDTH_MARGIN - bounds.width;
				if((direction & PositionConstants.WEST) != 0)
					moveDelta.x = -sizeDelta.width;
			}

			if(bounds.height + sizeDelta.height < prefSize.height + HEIGHT_MARGIN) {
				sizeDelta.height = prefSize.height + HEIGHT_MARGIN - bounds.height;
				if((direction & PositionConstants.NORTH) != 0)
					moveDelta.y = -sizeDelta.height;
			}
			
			request.setMoveDelta(moveDelta);
			request.setSizeDelta(sizeDelta);
		}
	}
	
	@Override
	public Command getCommand(Request request) {
		if(request instanceof ChangeBoundsRequest)
			constrainChangeBoundsRequest((IGraphicalEditPart)getHost(), (ChangeBoundsRequest)request);
		
		return super.getCommand(request);
	}
}

/*
 * *******************************************************************************
 * Copyright (c) 2011 - 2015 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      - initial API and implementation and initial documentation
 * *******************************************************************************
 */
package org.melanee.core.modeleditor.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeConnectionRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.melanee.core.modeleditor.custom.resizableswimlanes.editpolicies.SwimlaneLevelCompartmentLayoutEditPolicy;
import org.melanee.core.modeleditor.edit.policies.DeepModelDeepModelLevelCompartmentCanonicalEditPolicy;
import org.melanee.core.modeleditor.edit.policies.DeepModelDeepModelLevelCompartmentItemSemanticEditPolicy;
import org.melanee.core.modeleditor.providers.PLMElementTypes;

/**
 * @generated
 */
public class DeepModelDeepModelLevelCompartmentEditPart extends ShapeCompartmentEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 7062;

	/**
	* @generated
	*/
	public DeepModelDeepModelLevelCompartmentEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	public String getCompartmentName() {
		return null;
	}

	/**
	* @generated
	*/
	public IFigure createFigure() {
		ResizableCompartmentFigure result = (ResizableCompartmentFigure) super.createFigure();
		result.setTitleVisibility(false);
		return result;
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {

		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new DeepModelDeepModelLevelCompartmentItemSemanticEditPolicy());

		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());

		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new DeepModelDeepModelLevelCompartmentCanonicalEditPolicy());

		removeEditPolicy(EditPolicy.LAYOUT_ROLE);
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new SwimlaneLevelCompartmentLayoutEditPolicy());

	}

	/**
	* @generated
	*/
	protected void setRatio(Double ratio) {
		// nothing to do -- parent layout does not accept Double constraints as ratio
		// super.setRatio(ratio); 
	}

	/**
	* @generated
	*/
	public EditPart getTargetEditPart(Request request) {
		if (request instanceof CreateViewAndElementRequest) {
			CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest) request).getViewAndElementDescriptor()
					.getCreateElementRequestAdapter();
			IElementType type = (IElementType) adapter.getAdapter(IElementType.class);
			if (type == PLMElementTypes.Level_3097) {
				return this;
			}
			if (getParent() != null) {
				return getParent().getTargetEditPart(request);
			}
		}
		if (request instanceof CreateUnspecifiedTypeConnectionRequest) {
			return getParent().getTargetEditPart(request);
		}
		return super.getTargetEditPart(request);
	}

	/*
	 * @generated
	 */
	@Override
	public boolean isSelectable() {
		//Things that are not viewed cannot be selected
		//Throws an NullPointerException after import from
		//remote model for clabjects
		if (getViewer() == null)
			return false;

		return super.isSelectable();
	}

}

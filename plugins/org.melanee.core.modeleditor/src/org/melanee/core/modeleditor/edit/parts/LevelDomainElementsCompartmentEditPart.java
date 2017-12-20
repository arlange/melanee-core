/*
 * *******************************************************************************
 * Copyright (c) 2011 - 2015 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Ralph Gerbig - initial API and implementation and initial documentation
 * *******************************************************************************
 */
package org.melanee.core.modeleditor.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableCompartmentEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeConnectionRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.melanee.core.modeleditor.custom.ModelEditorConstants;
import org.melanee.core.modeleditor.custom.resizableswimlanes.editpolicies.SwimlaneLevelDomainElementsCompartmentLayoutEditPolicy;
import org.melanee.core.modeleditor.edit.policies.LevelDomainElementsCompartmentCanonicalEditPolicy;
import org.melanee.core.modeleditor.edit.policies.LevelDomainElementsCompartmentItemSemanticEditPolicy;
import org.melanee.core.modeleditor.providers.PLMElementTypes;

/**
 * @generated
 */
public class LevelDomainElementsCompartmentEditPart extends ShapeCompartmentEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 7046;

	/**
	* @generated
	*/
	public LevelDomainElementsCompartmentEditPart(View view) {
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
		result.setBorder(null);
		return result;
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {

		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new ResizableCompartmentEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new LevelDomainElementsCompartmentItemSemanticEditPolicy());

		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());

		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new LevelDomainElementsCompartmentCanonicalEditPolicy());

		removeEditPolicy(EditPolicyRoles.POPUPBAR_ROLE);
		removeEditPolicy(EditPolicy.LAYOUT_ROLE);
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new SwimlaneLevelDomainElementsCompartmentLayoutEditPolicy());
		//installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE, new org.melanee.core.modeleditor.custom.popupbartools.editpolicy.PLMModelElementPopupBarEditPolicy());

	}

	/**
	* @generated
	*/
	protected void setRatio(Double ratio) {
		if (getFigure().getParent().getLayoutManager() instanceof ConstrainedToolbarLayout) {
			super.setRatio(ratio);
		}
	}

	/**
	* @generated
	*/
	public EditPart getTargetEditPart(Request request) {
		if (request instanceof CreateViewAndElementRequest) {
			CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest) request).getViewAndElementDescriptor()
					.getCreateElementRequestAdapter();
			IElementType type = (IElementType) adapter.getAdapter(IElementType.class);
			if (type == PLMElementTypes.Connection_3099) {
				return this;
			}
			if (type == PLMElementTypes.Inheritance_3122) {
				return this;
			}
			if (type == PLMElementTypes.Entity_3120) {
				return this;
			}
			if (type == PLMElementTypes.Package_3125) {
				return this;
			}
			if (getParent() != null) {
				return getParent().getTargetEditPart(request);
			}
		}
		if (request instanceof CreateUnspecifiedTypeConnectionRequest) {
			if (RequestConstants.REQ_CONNECTION_END.equals(request.getType())) {
				for (Object type : ((CreateUnspecifiedTypeConnectionRequest) request).getElementTypes()) {
					if (type instanceof IElementType) {
						IElementType elementType = (IElementType) type;
						if (elementType.equals(PLMElementTypes.Classification_4026)
								|| elementType.equals(PLMElementTypes.Supertype_4034)
								|| elementType.equals(PLMElementTypes.Subtype_4035)
								|| elementType.equals(PLMElementTypes.ConnectionEnd_4036))
							return super.getTargetEditPart(request);
					}
				}
			}
			return getParent().getTargetEditPart(request);
		}
		return super.getTargetEditPart(request);
	}

	/**
	 * Saves the location to the _request for later synchronization
	 * with the LMLVisualizer in the CreatCommand.
	 */
	@Override
	public Command getCommand(Request _request) {
		Command result = super.getCommand(_request);

		//For create commands the location is saved as an parameter
		if (_request instanceof CreateUnspecifiedTypeRequest && result != null) {
			Point location = new Point(((CreateUnspecifiedTypeRequest) _request).getLocation());
			getContentPane().translateToRelative(location);
			_request.getExtendedData().put(ModelEditorConstants.CREATE_COMMAND_LOCATION, location);
		}

		return result;
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

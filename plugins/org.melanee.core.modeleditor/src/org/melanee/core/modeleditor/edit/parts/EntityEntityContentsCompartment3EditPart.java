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

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
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
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;
import org.melanee.core.modeleditor.custom.ModelEditorConstants;
import org.melanee.core.modeleditor.custom.contentawarecontainer.ContentAwareContainerCompartmentLayoutEditPolicy;
import org.melanee.core.modeleditor.edit.policies.EntityEntityContentsCompartment3CanonicalEditPolicy;
import org.melanee.core.modeleditor.edit.policies.EntityEntityContentsCompartment3ItemSemanticEditPolicy;
import org.melanee.core.modeleditor.part.PLMVisualIDRegistry;
import org.melanee.core.modeleditor.providers.PLMElementTypes;
import org.melanee.core.models.plm.PLM.Clabject;
import org.melanee.core.models.plm.PLM.Element;
import org.melanee.core.models.plm.PLM.LMLVisualizer;

/**
 * @generated
 */
public class EntityEntityContentsCompartment3EditPart extends ShapeCompartmentEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 7066;

	/**
	* @generated
	*/
	public EntityEntityContentsCompartment3EditPart(View view) {
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
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new ResizableCompartmentEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new EntityEntityContentsCompartment3ItemSemanticEditPolicy());

		installEditPolicy(EditPolicyRoles.CREATION_ROLE,
				new CreationEditPolicyWithCustomReparent(PLMVisualIDRegistry.TYPED_INSTANCE));

		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new EntityEntityContentsCompartment3CanonicalEditPolicy());

		removeEditPolicy(EditPolicy.LAYOUT_ROLE);
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new ContentAwareContainerCompartmentLayoutEditPolicy());

	}

	/**
	* @generated
	*/
	@Override
	protected void handleNotificationEvent(Notification event) {
		super.handleNotificationEvent(event);

		updateView();
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
			if (type == PLMElementTypes.Entity_3105) {
				return this;
			}
			if (type == PLMElementTypes.Connection_3111) {
				return this;
			}
			if (type == PLMElementTypes.Inheritance_3124) {
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
	 * @generated
	 */
	@Override
	public void activate() {
		super.activate();

		updateView();
	}

	/**
	 * @generated
	 */
	Border cachedBorder = null;

	/**
	 * Remove the top border in DSL model
	 *
	 * @generated
	 */
	private void updateView() {
		IFigure compartmentFigure = getFigure();

		if (cachedBorder == null && compartmentFigure.getBorder() != null)
			cachedBorder = compartmentFigure.getBorder();

		Clabject self = (Clabject) resolveSemanticElement();
		if (getDSLRenderingValue())
			compartmentFigure.setBorder(null);
		else
			compartmentFigure.setBorder(cachedBorder);
	}

	/**
	 * 
	 * @return null if no DSLRendering infotmation is available, else true or false
	 *
	 * @generated
	 */
	public Boolean getDSLRenderingValue() {

		//********************************************************
		//Find the LMLVisualizer attached to this element 
		//********************************************************
		Element self = (Element) this.resolveSemanticElement();

		//No rendering information found => all Connection remains expanded
		if (self.getVisualizer().size() == 0) {
			//Hide external name label
			IFigure boderItemContainer = (IFigure) figure.getChildren().get(1);
			((IFigure) boderItemContainer.getChildren().get(0)).setVisible(false);

			return null;
		}

		LMLVisualizer r = self.getVisualizer().get(0);
		String dslRenderingString = r.getValueForKey("DSLRendering");

		if ("".equals(dslRenderingString))
			return null;

		return Boolean.parseBoolean(dslRenderingString);
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

	/**
	 * Registers the Edipart to fire handleNotification on changes
	 * in LMLVisualizer.
	 *
	 * BUG: Only runs on EditPartCrearion. Items which are added Afterwards are not
	 * listened to.
	 * 
	 * @generated
	 */
	@Override
	protected void addSemanticListeners() {
		super.addSemanticListeners();

		Element e = (Element) resolveSemanticElement();

		//Register for listening to LMLVisualizer changes
		for (LMLVisualizer v : e.getVisualizer())
			addListenerFilter(v.toString().substring(0, v.toString().indexOf(" ")), this, v);
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

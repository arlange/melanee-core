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
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableCompartmentEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeConnectionRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.melanee.core.modeleditor.custom.contentawarecontainer.ContentAwareContainerCompartmentLayoutEditPolicy;
import org.melanee.core.modeleditor.edit.policies.PackagePackageContentCompartment2CanonicalEditPolicy;
import org.melanee.core.modeleditor.edit.policies.PackagePackageContentCompartment2ItemSemanticEditPolicy;
import org.melanee.core.modeleditor.providers.PLMElementTypes;

/**
 * @generated
 */
public class PackagePackageContentCompartment2EditPart extends ShapeCompartmentEditPart {

  /**
   * @generated
   */
  public static final int VISUAL_ID = 7070;

  /**
   * @generated
   */
  public PackagePackageContentCompartment2EditPart(View view) {
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
    installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
        new PackagePackageContentCompartment2ItemSemanticEditPolicy());

    installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());

    installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
    installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
        new PackagePackageContentCompartment2CanonicalEditPolicy());

    removeEditPolicy(EditPolicy.LAYOUT_ROLE);
    installEditPolicy(EditPolicy.LAYOUT_ROLE,
        new ContentAwareContainerCompartmentLayoutEditPolicy());

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
      CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest) request)
          .getViewAndElementDescriptor().getCreateElementRequestAdapter();
      IElementType type = (IElementType) adapter.getAdapter(IElementType.class);
      if (type == PLMElementTypes.Entity_3126) {
        return this;
      }
      if (type == PLMElementTypes.Connection_3127) {
        return this;
      }
      if (type == PLMElementTypes.Inheritance_3128) {
        return this;
      }
      if (type == PLMElementTypes.Package_3129) {
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

  /*
   * @generated
   */
  @Override
  public boolean isSelectable() {
    // Things that are not viewed cannot be selected
    // Throws an NullPointerException after import from
    // remote model for clabjects
    if (getViewer() == null)
      return false;

    return super.isSelectable();
  }

}

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

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.melanee.core.modeleditor.edit.policies.ClassificationItemSemanticEditPolicy;
import org.melanee.core.models.plm.PLM.Classification;
import org.melanee.core.models.plm.PLM.PLMPackage;

/**
 * @generated
 */
public class ClassificationEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 4026;

	/**
	* @generated
	*/
	public ClassificationEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ClassificationItemSemanticEditPolicy());
	}

	/**
	* @generated
	*/
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof WrappingLabel51EditPart) {
			((WrappingLabel51EditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureClassificationBlueprintNameFigure());
			return true;
		}
		if (childEditPart instanceof WrappingLabel52EditPart) {
			((WrappingLabel52EditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureClassificationTypeNameFigure());
			return true;
		}
		return false;
	}

	/**
	* @generated
	*/
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, index);
	}

	/**
	* @generated
	*/
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof WrappingLabel51EditPart) {
			return true;
		}
		if (childEditPart instanceof WrappingLabel52EditPart) {
			return true;
		}
		return false;
	}

	/**
	* @generated
	*/
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	* Creates figure for this edit part.
	* 
	* Body of this method does not depend on settings in generation model
	* so you may safely remove <i>generated</i> tag and modify it.
	* 
	* @generated
	*/

	protected Connection createConnectionFigure() {
		return new ClassificationFigure();
	}

	/**
	* @generated
	*/
	public ClassificationFigure getPrimaryShape() {
		return (ClassificationFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class ClassificationFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureClassificationTypeNameFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureClassificationBlueprintNameFigure;

		/**
		 * @generated
		 */
		public ClassificationFigure() {
			this.setLineStyle(Graphics.LINE_DASH);
			this.setForegroundColor(ColorConstants.black);

			createContents();
			setTargetDecoration(createTargetDecoration());
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureClassificationTypeNameFigure = new WrappingLabel();

			fFigureClassificationTypeNameFigure.setText("");
			fFigureClassificationTypeNameFigure.setForegroundColor(ColorConstants.black);

			fFigureClassificationTypeNameFigure.setFont(FFIGURECLASSIFICATIONTYPENAMEFIGURE_FONT);

			this.add(fFigureClassificationTypeNameFigure);

			fFigureClassificationBlueprintNameFigure = new WrappingLabel();

			fFigureClassificationBlueprintNameFigure.setText("");
			fFigureClassificationBlueprintNameFigure.setForegroundColor(ColorConstants.black);

			fFigureClassificationBlueprintNameFigure.setFont(FFIGURECLASSIFICATIONBLUEPRINTNAMEFIGURE_FONT);

			this.add(fFigureClassificationBlueprintNameFigure);

		}

		/**
		 * @generated
		 */
		private RotatableDecoration createTargetDecoration() {
			PolylineDecoration df = new PolylineDecoration();
			return df;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureClassificationTypeNameFigure() {
			return fFigureClassificationTypeNameFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureClassificationBlueprintNameFigure() {
			return fFigureClassificationBlueprintNameFigure;
		}

	}

	/**
	 * @generated
	 */
	static final Font FFIGURECLASSIFICATIONTYPENAMEFIGURE_FONT = new Font(Display.getCurrent(),
			Display.getDefault().getSystemFont().getFontData()[0].getName(), 8, SWT.NORMAL);

	/**
	 * @generated
	 */
	static final Font FFIGURECLASSIFICATIONBLUEPRINTNAMEFIGURE_FONT = new Font(Display.getCurrent(),
			Display.getDefault().getSystemFont().getFontData()[0].getName(), 8, SWT.NORMAL);

	//Sets the potency of instatiation ends

	/**
	 * updates the potency of the source element
	 *
	 * @generated
	 */
	public void updateSourcePotency() {
		Classification i = (Classification) resolveSemanticElement();

		int newPotency = 0;

		if (i.getType().getPotency() == -1)
			newPotency = -1;
		else if (i.getType().getPotency() > 0)
			newPotency = i.getType().getPotency() - 1;

		SetRequest request = new SetRequest(i.getInstance(), PLMPackage.eINSTANCE.getClabject_Potency(), newPotency);
		SetValueCommand command = new SetValueCommand(request);
		this.getViewer().getEditDomain().getCommandStack().execute(new ICommandProxy(command));
	}

	/**
	 * updates the potency of the source element
	 *
	 * @generated
	 */
	@Override
	protected void handleNotificationEvent(Notification notification) {
		super.handleNotificationEvent(notification);

		//Source is set before target, so now we can set the potency of the source with the one of the target - 1
		if (((EStructuralFeature) notification.getFeature()).getName().equals("target")) {
			updateSourcePotency();

		} else if (((EStructuralFeature) notification.getFeature()).getName().equals("source")
				&& ((Classification) resolveSemanticElement()).getType() != null) {
			updateSourcePotency();
		}
	}

}

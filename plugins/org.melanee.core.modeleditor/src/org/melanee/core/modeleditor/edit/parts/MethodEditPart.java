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

import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.SelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConstrainedToolbarLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeConnectionRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.melanee.core.modeleditor.custom.selectioneditpolicies.ExtendableToolbarSelectionEditPolicy;
import org.melanee.core.modeleditor.edit.policies.MethodItemSemanticEditPolicy;
import org.melanee.core.modeleditor.edit.policies.PLMTextSelectionEditPolicy;
import org.melanee.core.modeleditor.part.PLMVisualIDRegistry;
import org.melanee.core.modeleditor.providers.PLMElementTypes;

/**
 * @generated
 */
public class MethodEditPart extends ShapeNodeEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 3102;

	/**
	* @generated
	*/
	protected IFigure contentPane;

	/**
	* @generated
	*/
	protected IFigure primaryShape;

	/**
	* @generated
	*/
	public MethodEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {

		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new MethodItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);

		removeEditPolicy(EditPolicyRoles.POPUPBAR_ROLE);
		//installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE, new org.melanee.core.modeleditor.custom.popupbartools.editpolicy.PLMModelElementPopupBarEditPolicy());

		removeEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE);

		installEditPolicy(SelectionEditPolicy.SELECTION_FEEDBACK_ROLE, new ExtendableToolbarSelectionEditPolicy());

	}

	/**
	* @generated
	*/
	protected LayoutEditPolicy createLayoutEditPolicy() {

		ConstrainedToolbarLayoutEditPolicy lep = new ConstrainedToolbarLayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				if (child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE) == null) {
					if (child instanceof ITextAwareEditPart) {
						return new PLMTextSelectionEditPolicy();
					}
				}
				return super.createChildEditPolicy(child);
			}
		};
		return lep;
	}

	/**
	* @generated
	*/
	protected IFigure createNodeShape() {
		return primaryShape = new MethodFigure();
	}

	/**
	* @generated
	*/
	public MethodFigure getPrimaryShape() {
		return (MethodFigure) primaryShape;
	}

	/**
	* @generated
	*/
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof MethodNameEditPart) {
			((MethodNameEditPart) childEditPart).setLabel(getPrimaryShape().getFigureMethodNameFigure());
			return true;
		}
		if (childEditPart instanceof WrappingLabel13EditPart) {
			((WrappingLabel13EditPart) childEditPart).setLabel(getPrimaryShape().getFigureMethodInputFigure());
			return true;
		}
		if (childEditPart instanceof WrappingLabel14EditPart) {
			((WrappingLabel14EditPart) childEditPart).setLabel(getPrimaryShape().getFigureMethodPotencyFigure());
			return true;
		}
		if (childEditPart instanceof WrappingLabel15EditPart) {
			((WrappingLabel15EditPart) childEditPart).setLabel(getPrimaryShape().getFigureMethodOutputFigure());
			return true;
		}
		return false;
	}

	/**
	* @generated
	*/
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof MethodNameEditPart) {
			return true;
		}
		if (childEditPart instanceof WrappingLabel13EditPart) {
			return true;
		}
		if (childEditPart instanceof WrappingLabel14EditPart) {
			return true;
		}
		if (childEditPart instanceof WrappingLabel15EditPart) {
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
		super.addChildVisual(childEditPart, -1);
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
	* @generated
	*/
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		return getContentPane();
	}

	/**
	* @generated
	*/
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(0, 20);

		return result;
	}

	/**
	* Creates figure for this edit part.
	* 
	* Body of this method does not depend on settings in generation model
	* so you may safely remove <i>generated</i> tag and modify it.
	* 
	* @generated
	*/
	protected NodeFigure createNodeFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	* Default implementation treats passed figure as content pane.
	* Respects layout one may have set for generated figure.
	* @param nodeShape instance of generated figure class
	* @generated
	*/
	protected IFigure setupContentPane(IFigure nodeShape) {
		if (nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(5);
			nodeShape.setLayoutManager(layout);
		}
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	* @generated
	*/
	public IFigure getContentPane() {
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	* @generated
	*/
	protected void setForegroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	* @generated
	*/
	protected void setBackgroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setBackgroundColor(color);
		}
	}

	/**
	* @generated
	*/
	protected void setLineWidth(int width) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineWidth(width);
		}
	}

	/**
	* @generated
	*/
	protected void setLineType(int style) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineStyle(style);
		}
	}

	/**
	* @generated
	*/
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(PLMVisualIDRegistry.getType(MethodNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public class MethodFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureMethodNameFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureMethodPotencyFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureMethodOutputFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureMethodInputFigure;

		/**
		 * @generated
		 */
		public MethodFigure() {

			ToolbarLayout layoutThis = new ToolbarLayout();
			layoutThis.setStretchMinorAxis(true);
			layoutThis.setMinorAlignment(ToolbarLayout.ALIGN_TOPLEFT);

			layoutThis.setSpacing(0);
			layoutThis.setVertical(true);

			this.setLayoutManager(layoutThis);

			this.setFill(false);
			this.setOutline(false);

			this.setBorder(new MarginBorder(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0), getMapMode().DPtoLP(0),
					getMapMode().DPtoLP(0)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			RectangleFigure innerRectangle0 = new RectangleFigure();

			innerRectangle0.setFill(false);
			innerRectangle0.setOutline(false);

			this.add(innerRectangle0);

			GridLayout layoutInnerRectangle0 = new GridLayout();
			layoutInnerRectangle0.numColumns = 4;
			layoutInnerRectangle0.makeColumnsEqualWidth = false;
			layoutInnerRectangle0.horizontalSpacing = 0;
			layoutInnerRectangle0.verticalSpacing = 0;
			layoutInnerRectangle0.marginWidth = 3;
			layoutInnerRectangle0.marginHeight = 0;
			innerRectangle0.setLayoutManager(layoutInnerRectangle0);

			fFigureMethodNameFigure = new WrappingLabel();

			fFigureMethodNameFigure.setText("");

			fFigureMethodNameFigure.setFont(FFIGUREMETHODNAMEFIGURE_FONT);

			GridData constraintFFigureMethodNameFigure = new GridData();
			constraintFFigureMethodNameFigure.verticalAlignment = GridData.CENTER;
			constraintFFigureMethodNameFigure.horizontalAlignment = GridData.BEGINNING;
			constraintFFigureMethodNameFigure.horizontalIndent = 0;
			constraintFFigureMethodNameFigure.horizontalSpan = 1;
			constraintFFigureMethodNameFigure.verticalSpan = 1;
			constraintFFigureMethodNameFigure.grabExcessHorizontalSpace = false;
			constraintFFigureMethodNameFigure.grabExcessVerticalSpace = false;
			innerRectangle0.add(fFigureMethodNameFigure, constraintFFigureMethodNameFigure);

			fFigureMethodPotencyFigure = new WrappingLabel();

			fFigureMethodPotencyFigure.setText("");

			fFigureMethodPotencyFigure.setFont(FFIGUREMETHODPOTENCYFIGURE_FONT);

			fFigureMethodPotencyFigure.setBorder(new MarginBorder(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0),
					getMapMode().DPtoLP(10), getMapMode().DPtoLP(0)));

			GridData constraintFFigureMethodPotencyFigure = new GridData();
			constraintFFigureMethodPotencyFigure.verticalAlignment = GridData.CENTER;
			constraintFFigureMethodPotencyFigure.horizontalAlignment = GridData.BEGINNING;
			constraintFFigureMethodPotencyFigure.horizontalIndent = 0;
			constraintFFigureMethodPotencyFigure.horizontalSpan = 1;
			constraintFFigureMethodPotencyFigure.verticalSpan = 1;
			constraintFFigureMethodPotencyFigure.grabExcessHorizontalSpace = false;
			constraintFFigureMethodPotencyFigure.grabExcessVerticalSpace = false;
			innerRectangle0.add(fFigureMethodPotencyFigure, constraintFFigureMethodPotencyFigure);

			fFigureMethodInputFigure = new WrappingLabel();

			fFigureMethodInputFigure.setText("");

			fFigureMethodInputFigure.setFont(FFIGUREMETHODINPUTFIGURE_FONT);

			GridData constraintFFigureMethodInputFigure = new GridData();
			constraintFFigureMethodInputFigure.verticalAlignment = GridData.CENTER;
			constraintFFigureMethodInputFigure.horizontalAlignment = GridData.BEGINNING;
			constraintFFigureMethodInputFigure.horizontalIndent = 0;
			constraintFFigureMethodInputFigure.horizontalSpan = 1;
			constraintFFigureMethodInputFigure.verticalSpan = 1;
			constraintFFigureMethodInputFigure.grabExcessHorizontalSpace = false;
			constraintFFigureMethodInputFigure.grabExcessVerticalSpace = false;
			innerRectangle0.add(fFigureMethodInputFigure, constraintFFigureMethodInputFigure);

			fFigureMethodOutputFigure = new WrappingLabel();

			fFigureMethodOutputFigure.setText("");

			fFigureMethodOutputFigure.setFont(FFIGUREMETHODOUTPUTFIGURE_FONT);

			GridData constraintFFigureMethodOutputFigure = new GridData();
			constraintFFigureMethodOutputFigure.verticalAlignment = GridData.CENTER;
			constraintFFigureMethodOutputFigure.horizontalAlignment = GridData.BEGINNING;
			constraintFFigureMethodOutputFigure.horizontalIndent = 0;
			constraintFFigureMethodOutputFigure.horizontalSpan = 1;
			constraintFFigureMethodOutputFigure.verticalSpan = 1;
			constraintFFigureMethodOutputFigure.grabExcessHorizontalSpace = false;
			constraintFFigureMethodOutputFigure.grabExcessVerticalSpace = false;
			innerRectangle0.add(fFigureMethodOutputFigure, constraintFFigureMethodOutputFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureMethodNameFigure() {
			return fFigureMethodNameFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureMethodPotencyFigure() {
			return fFigureMethodPotencyFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureMethodOutputFigure() {
			return fFigureMethodOutputFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureMethodInputFigure() {
			return fFigureMethodInputFigure;
		}

	}

	/**
	 * @generated
	 */
	static final Font FFIGUREMETHODNAMEFIGURE_FONT = new Font(Display.getCurrent(),
			Display.getDefault().getSystemFont().getFontData()[0].getName(), 8, SWT.NORMAL);

	/**
	 * @generated
	 */
	static final Font FFIGUREMETHODPOTENCYFIGURE_FONT = new Font(Display.getCurrent(),
			Display.getDefault().getSystemFont().getFontData()[0].getName(), 7, SWT.NORMAL);

	/**
	 * @generated
	 */
	static final Font FFIGUREMETHODINPUTFIGURE_FONT = new Font(Display.getCurrent(),
			Display.getDefault().getSystemFont().getFontData()[0].getName(), 8, SWT.NORMAL);

	/**
	 * @generated
	 */
	static final Font FFIGUREMETHODOUTPUTFIGURE_FONT = new Font(Display.getCurrent(),
			Display.getDefault().getSystemFont().getFontData()[0].getName(), 8, SWT.NORMAL);

	//Gives the option to diplay a Connection/Inheritance/Specialization as black rectangle

	@Override
	public Command getCommand(Request _request) {
		if (_request instanceof CreateUnspecifiedTypeConnectionRequest
				&& (((CreateUnspecifiedTypeConnectionRequest) _request).getElementTypes()
						.contains(PLMElementTypes.ConnectionEnd_4036))) {

			if (((CreateUnspecifiedTypeConnectionRequest) _request).getTargetEditPart() == this)
				((CreateUnspecifiedTypeConnectionRequest) _request).setTargetEditPart(getParent().getParent());

			if (((CreateUnspecifiedTypeConnectionRequest) _request).getSourceEditPart() == this)
				((CreateUnspecifiedTypeConnectionRequest) _request).setSourceEditPart(getParent().getParent());

			return getParent().getParent().getCommand(_request);
		}
		return super.getCommand(_request);
	}

}

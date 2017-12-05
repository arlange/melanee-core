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
import org.melanee.core.modeleditor.edit.policies.Attribute2ItemSemanticEditPolicy;
import org.melanee.core.modeleditor.edit.policies.PLMTextSelectionEditPolicy;
import org.melanee.core.modeleditor.part.PLMVisualIDRegistry;
import org.melanee.core.modeleditor.providers.PLMElementTypes;

/**
 * @generated
 */
public class Attribute2EditPart extends ShapeNodeEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 3106;

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
	public Attribute2EditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {

		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new Attribute2ItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);

		removeEditPolicy(EditPolicyRoles.POPUPBAR_ROLE);
		//installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE, new org.melanee.core.modeleditor.custom.popupbartools.editpolicy.PLMModelElementPopupBarEditPolicy());

		removeEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE);

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
		return primaryShape = new AttributeFigure();
	}

	/**
	* @generated
	*/
	public AttributeFigure getPrimaryShape() {
		return (AttributeFigure) primaryShape;
	}

	/**
	* @generated
	*/
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof AttributeName2EditPart) {
			((AttributeName2EditPart) childEditPart).setLabel(getPrimaryShape().getFigureAttributeNameFigure());
			return true;
		}
		if (childEditPart instanceof WrappingLabel21EditPart) {
			((WrappingLabel21EditPart) childEditPart).setLabel(getPrimaryShape().getFigureAttributeDurabilityFigure());
			return true;
		}
		if (childEditPart instanceof WrappingLabel22EditPart) {
			((WrappingLabel22EditPart) childEditPart).setLabel(getPrimaryShape().getFigureAttributeDataTypeFigure());
			return true;
		}
		if (childEditPart instanceof WrappingLabel23EditPart) {
			((WrappingLabel23EditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureAttributeDefaultValueFigure());
			return true;
		}
		if (childEditPart instanceof WrappingLabel24EditPart) {
			((WrappingLabel24EditPart) childEditPart).setLabel(getPrimaryShape().getFigureAttributeVariabilityFigure());
			return true;
		}
		return false;
	}

	/**
	* @generated
	*/
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof AttributeName2EditPart) {
			return true;
		}
		if (childEditPart instanceof WrappingLabel21EditPart) {
			return true;
		}
		if (childEditPart instanceof WrappingLabel22EditPart) {
			return true;
		}
		if (childEditPart instanceof WrappingLabel23EditPart) {
			return true;
		}
		if (childEditPart instanceof WrappingLabel24EditPart) {
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
		return getChildBySemanticHint(PLMVisualIDRegistry.getType(AttributeName2EditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public class AttributeFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureAttributeNameFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureAttributeDurabilityFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureAttributeDataTypeFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureAttributeDefaultValueFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureAttributeVariabilityFigure;

		/**
		 * @generated
		 */
		public AttributeFigure() {

			ToolbarLayout layoutThis = new ToolbarLayout();
			layoutThis.setStretchMinorAxis(false);
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
			layoutInnerRectangle0.numColumns = 5;
			layoutInnerRectangle0.makeColumnsEqualWidth = false;
			layoutInnerRectangle0.horizontalSpacing = 0;
			layoutInnerRectangle0.verticalSpacing = 0;
			layoutInnerRectangle0.marginWidth = 3;
			layoutInnerRectangle0.marginHeight = 0;
			innerRectangle0.setLayoutManager(layoutInnerRectangle0);

			fFigureAttributeNameFigure = new WrappingLabel();

			fFigureAttributeNameFigure.setText("");

			fFigureAttributeNameFigure.setFont(FFIGUREATTRIBUTENAMEFIGURE_FONT);

			GridData constraintFFigureAttributeNameFigure = new GridData();
			constraintFFigureAttributeNameFigure.verticalAlignment = GridData.CENTER;
			constraintFFigureAttributeNameFigure.horizontalAlignment = GridData.BEGINNING;
			constraintFFigureAttributeNameFigure.horizontalIndent = 0;
			constraintFFigureAttributeNameFigure.horizontalSpan = 1;
			constraintFFigureAttributeNameFigure.verticalSpan = 1;
			constraintFFigureAttributeNameFigure.grabExcessHorizontalSpace = false;
			constraintFFigureAttributeNameFigure.grabExcessVerticalSpace = false;
			innerRectangle0.add(fFigureAttributeNameFigure, constraintFFigureAttributeNameFigure);

			fFigureAttributeDurabilityFigure = new WrappingLabel();

			fFigureAttributeDurabilityFigure.setText("");

			fFigureAttributeDurabilityFigure.setFont(FFIGUREATTRIBUTEDURABILITYFIGURE_FONT);

			fFigureAttributeDurabilityFigure.setBorder(new MarginBorder(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0),
					getMapMode().DPtoLP(10), getMapMode().DPtoLP(0)));

			GridData constraintFFigureAttributeDurabilityFigure = new GridData();
			constraintFFigureAttributeDurabilityFigure.verticalAlignment = GridData.CENTER;
			constraintFFigureAttributeDurabilityFigure.horizontalAlignment = GridData.BEGINNING;
			constraintFFigureAttributeDurabilityFigure.horizontalIndent = 0;
			constraintFFigureAttributeDurabilityFigure.horizontalSpan = 1;
			constraintFFigureAttributeDurabilityFigure.verticalSpan = 1;
			constraintFFigureAttributeDurabilityFigure.grabExcessHorizontalSpace = false;
			constraintFFigureAttributeDurabilityFigure.grabExcessVerticalSpace = false;
			innerRectangle0.add(fFigureAttributeDurabilityFigure, constraintFFigureAttributeDurabilityFigure);

			fFigureAttributeDataTypeFigure = new WrappingLabel();

			fFigureAttributeDataTypeFigure.setText("");

			fFigureAttributeDataTypeFigure.setFont(FFIGUREATTRIBUTEDATATYPEFIGURE_FONT);

			GridData constraintFFigureAttributeDataTypeFigure = new GridData();
			constraintFFigureAttributeDataTypeFigure.verticalAlignment = GridData.CENTER;
			constraintFFigureAttributeDataTypeFigure.horizontalAlignment = GridData.BEGINNING;
			constraintFFigureAttributeDataTypeFigure.horizontalIndent = 0;
			constraintFFigureAttributeDataTypeFigure.horizontalSpan = 1;
			constraintFFigureAttributeDataTypeFigure.verticalSpan = 1;
			constraintFFigureAttributeDataTypeFigure.grabExcessHorizontalSpace = false;
			constraintFFigureAttributeDataTypeFigure.grabExcessVerticalSpace = false;
			innerRectangle0.add(fFigureAttributeDataTypeFigure, constraintFFigureAttributeDataTypeFigure);

			fFigureAttributeDefaultValueFigure = new WrappingLabel();

			fFigureAttributeDefaultValueFigure.setText("");

			fFigureAttributeDefaultValueFigure.setFont(FFIGUREATTRIBUTEDEFAULTVALUEFIGURE_FONT);

			GridData constraintFFigureAttributeDefaultValueFigure = new GridData();
			constraintFFigureAttributeDefaultValueFigure.verticalAlignment = GridData.CENTER;
			constraintFFigureAttributeDefaultValueFigure.horizontalAlignment = GridData.BEGINNING;
			constraintFFigureAttributeDefaultValueFigure.horizontalIndent = 0;
			constraintFFigureAttributeDefaultValueFigure.horizontalSpan = 1;
			constraintFFigureAttributeDefaultValueFigure.verticalSpan = 1;
			constraintFFigureAttributeDefaultValueFigure.grabExcessHorizontalSpace = false;
			constraintFFigureAttributeDefaultValueFigure.grabExcessVerticalSpace = false;
			innerRectangle0.add(fFigureAttributeDefaultValueFigure, constraintFFigureAttributeDefaultValueFigure);

			fFigureAttributeVariabilityFigure = new WrappingLabel();

			fFigureAttributeVariabilityFigure.setText("");

			fFigureAttributeVariabilityFigure.setFont(FFIGUREATTRIBUTEVARIABILITYFIGURE_FONT);

			fFigureAttributeVariabilityFigure.setBorder(new MarginBorder(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0),
					getMapMode().DPtoLP(10), getMapMode().DPtoLP(0)));

			GridData constraintFFigureAttributeVariabilityFigure = new GridData();
			constraintFFigureAttributeVariabilityFigure.verticalAlignment = GridData.CENTER;
			constraintFFigureAttributeVariabilityFigure.horizontalAlignment = GridData.BEGINNING;
			constraintFFigureAttributeVariabilityFigure.horizontalIndent = 0;
			constraintFFigureAttributeVariabilityFigure.horizontalSpan = 1;
			constraintFFigureAttributeVariabilityFigure.verticalSpan = 1;
			constraintFFigureAttributeVariabilityFigure.grabExcessHorizontalSpace = false;
			constraintFFigureAttributeVariabilityFigure.grabExcessVerticalSpace = false;
			innerRectangle0.add(fFigureAttributeVariabilityFigure, constraintFFigureAttributeVariabilityFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureAttributeNameFigure() {
			return fFigureAttributeNameFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureAttributeDurabilityFigure() {
			return fFigureAttributeDurabilityFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureAttributeDataTypeFigure() {
			return fFigureAttributeDataTypeFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureAttributeDefaultValueFigure() {
			return fFigureAttributeDefaultValueFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureAttributeVariabilityFigure() {
			return fFigureAttributeVariabilityFigure;
		}

	}

	/**
	 * @generated
	 */
	static final Font FFIGUREATTRIBUTENAMEFIGURE_FONT = new Font(Display.getCurrent(),
			Display.getDefault().getSystemFont().getFontData()[0].getName(), 8, SWT.NORMAL);

	/**
	 * @generated
	 */
	static final Font FFIGUREATTRIBUTEDURABILITYFIGURE_FONT = new Font(Display.getCurrent(),
			Display.getDefault().getSystemFont().getFontData()[0].getName(), 7, SWT.NORMAL);

	/**
	 * @generated
	 */
	static final Font FFIGUREATTRIBUTEDATATYPEFIGURE_FONT = new Font(Display.getCurrent(),
			Display.getDefault().getSystemFont().getFontData()[0].getName(), 8, SWT.NORMAL);

	/**
	 * @generated
	 */
	static final Font FFIGUREATTRIBUTEDEFAULTVALUEFIGURE_FONT = new Font(Display.getCurrent(),
			Display.getDefault().getSystemFont().getFontData()[0].getName(), 8, SWT.NORMAL);

	/**
	 * @generated
	 */
	static final Font FFIGUREATTRIBUTEVARIABILITYFIGURE_FONT = new Font(Display.getCurrent(),
			Display.getDefault().getSystemFont().getFontData()[0].getName(), 7, SWT.NORMAL);

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

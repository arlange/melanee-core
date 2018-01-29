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

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.editpolicies.SelectionEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.melanee.core.modeleditor.custom.contentawarecontainer.ContentAwareContainerEditPolicy;
import org.melanee.core.modeleditor.custom.figures.BottomLessRectangleFigure;
import org.melanee.core.modeleditor.custom.selectioneditpolicies.ExtendableToolbarSelectionEditPolicy;
import org.melanee.core.modeleditor.edit.policies.PackageItemSemanticEditPolicy;
import org.melanee.core.modeleditor.part.PLMVisualIDRegistry;

/**
 * @generated
 */
public class PackageEditPart extends ShapeNodeEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 3125;

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
	public PackageEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {

		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new PackageItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);

		removeEditPolicy(EditPolicyRoles.POPUPBAR_ROLE);
		//installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE, new org.melanee.core.modeleditor.custom.popupbartools.editpolicy.PLMModelElementPopupBarEditPolicy());

		removeEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE);

		removeEditPolicy(EditPolicy.LAYOUT_ROLE);
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new ContentAwareContainerEditPolicy());

		installEditPolicy(SelectionEditPolicy.SELECTION_FEEDBACK_ROLE, new ExtendableToolbarSelectionEditPolicy());

	}

	/**
	* @generated
	*/
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if (result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}

			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}
		};
		return lep;
	}

	/**
	* @generated
	*/
	protected IFigure createNodeShape() {
		return primaryShape = new PackageFigure();
	}

	/**
	* @generated
	*/
	public PackageFigure getPrimaryShape() {
		return (PackageFigure) primaryShape;
	}

	/**
	* @generated
	*/
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof PackageNameEditPart) {
			((PackageNameEditPart) childEditPart).setLabel(getPrimaryShape().getFigurePackageNameFigure());
			return true;
		}
		if (childEditPart instanceof PackagePackageContentCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getFigurePackageContentRectangle();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((PackagePackageContentCompartmentEditPart) childEditPart).getFigure());
			return true;
		}
		return false;
	}

	/**
	* @generated
	*/
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof PackageNameEditPart) {
			return true;
		}
		if (childEditPart instanceof PackagePackageContentCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getFigurePackageContentRectangle();
			pane.remove(((PackagePackageContentCompartmentEditPart) childEditPart).getFigure());
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
		if (editPart instanceof PackagePackageContentCompartmentEditPart) {
			return getPrimaryShape().getFigurePackageContentRectangle();
		}
		return getContentPane();
	}

	/**
	* @generated
	*/
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);

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
		return getChildBySemanticHint(PLMVisualIDRegistry.getType(PackageNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public class PackageFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fFigurePackageNameFigure;
		/**
		 * @generated
		 */
		private RectangleFigure fFigurePackageContentRectangle;

		/**
		 * @generated
		 */
		public PackageFigure() {

			GridLayout layoutThis = new GridLayout();
			layoutThis.numColumns = 1;
			layoutThis.makeColumnsEqualWidth = true;
			layoutThis.horizontalSpacing = 0;
			layoutThis.verticalSpacing = 0;
			layoutThis.marginWidth = 0;
			layoutThis.marginHeight = 0;
			this.setLayoutManager(layoutThis);

			this.setOutline(false);
			this.setForegroundColor(ColorConstants.black);
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			BottomLessRectangleFigure nameRectangle0 = new BottomLessRectangleFigure();

			this.add(nameRectangle0);

			GridLayout layoutNameRectangle0 = new GridLayout();
			layoutNameRectangle0.numColumns = 1;
			layoutNameRectangle0.makeColumnsEqualWidth = true;
			nameRectangle0.setLayoutManager(layoutNameRectangle0);

			fFigurePackageNameFigure = new WrappingLabel();

			fFigurePackageNameFigure.setText("");

			fFigurePackageNameFigure.setFont(FFIGUREPACKAGENAMEFIGURE_FONT);

			GridData constraintFFigurePackageNameFigure = new GridData();
			constraintFFigurePackageNameFigure.verticalAlignment = GridData.CENTER;
			constraintFFigurePackageNameFigure.horizontalAlignment = GridData.BEGINNING;
			constraintFFigurePackageNameFigure.horizontalIndent = 0;
			constraintFFigurePackageNameFigure.horizontalSpan = 1;
			constraintFFigurePackageNameFigure.verticalSpan = 1;
			constraintFFigurePackageNameFigure.grabExcessHorizontalSpace = false;
			constraintFFigurePackageNameFigure.grabExcessVerticalSpace = false;
			nameRectangle0.add(fFigurePackageNameFigure, constraintFFigurePackageNameFigure);

			fFigurePackageContentRectangle = new RectangleFigure();

			GridData constraintFFigurePackageContentRectangle = new GridData();
			constraintFFigurePackageContentRectangle.verticalAlignment = GridData.FILL;
			constraintFFigurePackageContentRectangle.horizontalAlignment = GridData.FILL;
			constraintFFigurePackageContentRectangle.horizontalIndent = 0;
			constraintFFigurePackageContentRectangle.horizontalSpan = 1;
			constraintFFigurePackageContentRectangle.verticalSpan = 1;
			constraintFFigurePackageContentRectangle.grabExcessHorizontalSpace = true;
			constraintFFigurePackageContentRectangle.grabExcessVerticalSpace = true;
			this.add(fFigurePackageContentRectangle, constraintFFigurePackageContentRectangle);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigurePackageNameFigure() {
			return fFigurePackageNameFigure;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigurePackageContentRectangle() {
			return fFigurePackageContentRectangle;
		}

	}

	/**
	 * @generated
	 */
	static final Font FFIGUREPACKAGENAMEFIGURE_FONT = new Font(Display.getCurrent(),
			Display.getDefault().getSystemFont().getFontData()[0].getName(), 9, SWT.BOLD);

	//Gives the option to diplay a Connection/Inheritance/Specialization as black rectangle

}

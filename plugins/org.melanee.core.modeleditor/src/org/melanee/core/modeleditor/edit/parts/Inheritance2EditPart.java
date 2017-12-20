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

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.ScalablePolygonShape;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.impl.InternalTransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.editpolicies.SelectionEditPolicy;
import org.eclipse.gef.handles.MoveHandle;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.NonResizableEditPolicyEx;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableShapeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.Decoration;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.draw2d.ui.internal.figures.ImageFigureEx;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.gef.ui.internal.figures.RelativeToBorderLocator;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.melanee.core.modeleditor.custom.figures.DefaultSizeNodeFixedAnchors;
import org.melanee.core.modeleditor.custom.selectioneditpolicies.ExtendableToolbarSelectionEditPolicy;
import org.melanee.core.modeleditor.custom.tooltip.ToolTip;
import org.melanee.core.modeleditor.edit.policies.Inheritance2ItemSemanticEditPolicy;
import org.melanee.core.modeleditor.part.PLMDiagramEditorPlugin;
import org.melanee.core.modeleditor.part.PLMVisualIDRegistry;
import org.melanee.core.models.links.links.Link;
import org.melanee.core.models.links.links.LinkingModel;
import org.melanee.core.models.links.links.RemoteModel;
import org.melanee.core.models.plm.PLM.Element;
import org.melanee.core.models.plm.PLM.LMLVisualizer;
import org.melanee.core.workbench.interfaces.IVisualizationServiceBase;

import de.itemis.gmf.runtime.layout.ScaleInnerFigureLayout;

/**
 * @generated
 */
public class Inheritance2EditPart extends AbstractBorderedShapeEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 3122;

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
	public Inheritance2EditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {

		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new Inheritance2ItemSemanticEditPolicy());
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
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				View childView = (View) child.getModel();
				switch (PLMVisualIDRegistry.getVisualID(childView)) {
				case InheritanceName4EditPart.VISUAL_ID:
					return new BorderItemSelectionEditPolicy() {

						protected List createSelectionHandles() {
							MoveHandle mh = new MoveHandle((GraphicalEditPart) getHost());
							mh.setBorder(null);
							return Collections.singletonList(mh);
						}
					};
				}
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
		return primaryShape = new GeneralizationFigure();
	}

	/**
	* @generated
	*/
	public GeneralizationFigure getPrimaryShape() {
		return (GeneralizationFigure) primaryShape;
	}

	/**
	* @generated
	*/
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof InheritanceName3EditPart) {
			((InheritanceName3EditPart) childEditPart).setLabel(getPrimaryShape().getFigureGeneralisationNameFigure());
			return true;
		}
		if (childEditPart instanceof WrappingLabel34EditPart) {
			((WrappingLabel34EditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureGeneralisationSubtitleFigure());
			return true;
		}
		return false;
	}

	/**
	* @generated
	*/
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof InheritanceName3EditPart) {
			return true;
		}
		if (childEditPart instanceof WrappingLabel34EditPart) {
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
		if (editPart instanceof IBorderItemEditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}
		return getContentPane();
	}

	/**
	* @generated
	*/
	protected void addBorderItem(IFigure borderItemContainer, IBorderItemEditPart borderItemEditPart) {
		if (borderItemEditPart instanceof InheritanceName4EditPart) {
			BorderItemLocator locator = new BorderItemLocator(getMainFigure(), PositionConstants.SOUTH);
			locator.setBorderItemOffset(new Dimension(-20, -20));
			borderItemContainer.add(borderItemEditPart.getFigure(), locator);
		} else {
			super.addBorderItem(borderItemContainer, borderItemEditPart);
		}
	}

	/**
	* @generated
	*/
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(60, 25);

		if (true) {
			HashMap<String, PrecisionPoint> anchorLocations = new HashMap<String, PrecisionPoint>();

			anchorLocations.put("NORTH", new PrecisionPoint(0.5d, 0));
			anchorLocations.put("EAST", new PrecisionPoint(1d, 0.5d));
			anchorLocations.put("SOUTH", new PrecisionPoint(0.5d, 1d));
			anchorLocations.put("WEST", new PrecisionPoint(0, 0.5d));

			result = new DefaultSizeNodeFixedAnchors(8, 8, anchorLocations);

			return result;
		}

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
	protected NodeFigure createMainFigure() {
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
		return getChildBySemanticHint(PLMVisualIDRegistry.getType(InheritanceName3EditPart.VISUAL_ID));
	}

	/**
	 * Updates the connections after a value was set and does elision
	 *
	 * @generated
	 */
	@Override
	protected void handleNotificationEvent(Notification notification) {
		super.handleNotificationEvent(notification);

		//visualizer -> notation
		if (notification.getNotifier() instanceof LMLVisualizer) {
			String featureName = ((EStructuralFeature) notification.getFeature()).getName();
			if (featureName.equals("xLocation") || featureName.equals("yLocation") || featureName.equals("width")
					|| featureName.equals("height")) {
				synchronizeVisualizerAndNotationModel();
				return;
			}
		}

		if (notification.getNotifier() instanceof LMLVisualizer
				//This filter is needed as on a change a remove many and
				//add many is executed
				&& notification.getEventType() == Notification.ADD) {

			updateView(IVisualizationServiceBase.FORMAT_GRAPH);

		}

	}

	//	/**
	//	 * 
	//	 * @return null if no DSLRendering infotmation is available, else true or false
	//	 *
	//	 * @generated
	//	 */
	//	public String getDSLRenderingValue(String format) {
	//		//boolean collapse = false;
	//
	//		//********************************************************
	//		//Find the LMLVisualizer attached to this element 
	//		//********************************************************
	//		org.melanee.core.models.plm.PLM.Element self = (org.melanee.core.models.plm.PLM.Element) this
	//				.resolveSemanticElement();
	//
	//		//This can happen on delete
	//		if(self == null)
	//			return null;
	//
	//		//No rendering information found => all Connection remains expanded
	//		if (self.getVisualizer().size() == 0) {
	//			//Hide external name label
	//			org.eclipse.draw2d.IFigure boderItemContainer = (org.eclipse.draw2d.IFigure) figure.getChildren().get(1);
	//			((org.eclipse.draw2d.IFigure) boderItemContainer.getChildren().get(0))
	//					.setVisible(false);
	//
	//			return null;
	//		}
	//
	//		org.eclipse.emf.ecore.EObject container = self;
	//		String dslRenderingString = null;
	//		
	//		//Search until a not derived notation is found
	//		while(container.eContainer() != null
	//				&& ! (container.eContainer() instanceof org.melanee.core.models.plm.PLM.Domain)){
	//			org.melanee.core.models.plm.PLM.LMLVisualizer r = ((org.melanee.core.models.plm.PLM.Element)container).getVisualizer().get(0);
	//			dslRenderingString = r.getValueForKey(format);
	//			
	//			if(!dslRenderingString.equals(org.melanee.core.workbench.interfaces.IVisualizationServiceBase.NOTATION_DERIVED))
	//				break;
	//			
	//			container = container.eContainer();
	//		}
	//		
	//		//If all notations are derived use LML notation
	//		if (dslRenderingString.equals(org.melanee.core.workbench.interfaces.IVisualizationServiceBase.NOTATION_DERIVED))
	//			return org.melanee.core.workbench.interfaces.IVisualizationServiceBase.NOTATION_LML;
	//
	//		return dslRenderingString;
	//	}

	/**
	 * @generated
	 */
	public void updateView(String format) {

		java.lang.Boolean toggleValue = getToggleValue();

		//We do toggle the connection
		if (toggleValue != null)
			toggle();

	}

	/**
	 * @generated
	 */
	public class GeneralizationFigure extends ScalablePolygonShape {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureGeneralisationNameFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureGeneralisationSubtitleFigure;

		/**
		 * @generated
		 */
		public GeneralizationFigure() {

			ScaleInnerFigureLayout layoutThis = new ScaleInnerFigureLayout();
			this.setLayoutManager(layoutThis);

			this.addPoint(new Point(getMapMode().DPtoLP(0), getMapMode().DPtoLP(30)));
			this.addPoint(new Point(getMapMode().DPtoLP(10), getMapMode().DPtoLP(15)));
			this.addPoint(new Point(getMapMode().DPtoLP(20), getMapMode().DPtoLP(5)));
			this.addPoint(new Point(getMapMode().DPtoLP(30), getMapMode().DPtoLP(0)));
			this.addPoint(new Point(getMapMode().DPtoLP(40), getMapMode().DPtoLP(0)));
			this.addPoint(new Point(getMapMode().DPtoLP(50), getMapMode().DPtoLP(5)));
			this.addPoint(new Point(getMapMode().DPtoLP(60), getMapMode().DPtoLP(15)));
			this.addPoint(new Point(getMapMode().DPtoLP(70), getMapMode().DPtoLP(30)));
			this.addPoint(new Point(getMapMode().DPtoLP(70), getMapMode().DPtoLP(50)));
			this.addPoint(new Point(getMapMode().DPtoLP(60), getMapMode().DPtoLP(65)));
			this.addPoint(new Point(getMapMode().DPtoLP(50), getMapMode().DPtoLP(75)));
			this.addPoint(new Point(getMapMode().DPtoLP(40), getMapMode().DPtoLP(80)));
			this.addPoint(new Point(getMapMode().DPtoLP(30), getMapMode().DPtoLP(80)));
			this.addPoint(new Point(getMapMode().DPtoLP(20), getMapMode().DPtoLP(75)));
			this.addPoint(new Point(getMapMode().DPtoLP(10), getMapMode().DPtoLP(65)));
			this.addPoint(new Point(getMapMode().DPtoLP(0), getMapMode().DPtoLP(50)));
			this.setFill(true);
			this.setForegroundColor(ColorConstants.black);
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(60), getMapMode().DPtoLP(25)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			RectangleFigure nameRectangle0 = new RectangleFigure();

			nameRectangle0.setFill(false);
			nameRectangle0.setOutline(false);

			this.add(nameRectangle0);

			GridLayout layoutNameRectangle0 = new GridLayout();
			layoutNameRectangle0.numColumns = 1;
			layoutNameRectangle0.makeColumnsEqualWidth = true;
			layoutNameRectangle0.horizontalSpacing = 0;
			layoutNameRectangle0.verticalSpacing = 0;
			layoutNameRectangle0.marginWidth = 0;
			layoutNameRectangle0.marginHeight = 0;
			nameRectangle0.setLayoutManager(layoutNameRectangle0);

			fFigureGeneralisationNameFigure = new WrappingLabel();

			fFigureGeneralisationNameFigure.setText("");
			fFigureGeneralisationNameFigure.setForegroundColor(ColorConstants.black);

			fFigureGeneralisationNameFigure.setFont(FFIGUREGENERALISATIONNAMEFIGURE_FONT);

			GridData constraintFFigureGeneralisationNameFigure = new GridData();
			constraintFFigureGeneralisationNameFigure.verticalAlignment = GridData.CENTER;
			constraintFFigureGeneralisationNameFigure.horizontalAlignment = GridData.CENTER;
			constraintFFigureGeneralisationNameFigure.horizontalIndent = 0;
			constraintFFigureGeneralisationNameFigure.horizontalSpan = 1;
			constraintFFigureGeneralisationNameFigure.verticalSpan = 1;
			constraintFFigureGeneralisationNameFigure.grabExcessHorizontalSpace = true;
			constraintFFigureGeneralisationNameFigure.grabExcessVerticalSpace = true;
			nameRectangle0.add(fFigureGeneralisationNameFigure, constraintFFigureGeneralisationNameFigure);

			fFigureGeneralisationSubtitleFigure = new WrappingLabel();

			fFigureGeneralisationSubtitleFigure.setText("");
			fFigureGeneralisationSubtitleFigure.setForegroundColor(ColorConstants.black);

			fFigureGeneralisationSubtitleFigure.setFont(FFIGUREGENERALISATIONSUBTITLEFIGURE_FONT);

			fFigureGeneralisationSubtitleFigure.setBorder(new MarginBorder(getMapMode().DPtoLP(0),
					getMapMode().DPtoLP(0), getMapMode().DPtoLP(0), getMapMode().DPtoLP(0)));

			GridData constraintFFigureGeneralisationSubtitleFigure = new GridData();
			constraintFFigureGeneralisationSubtitleFigure.verticalAlignment = GridData.CENTER;
			constraintFFigureGeneralisationSubtitleFigure.horizontalAlignment = GridData.CENTER;
			constraintFFigureGeneralisationSubtitleFigure.horizontalIndent = 0;
			constraintFFigureGeneralisationSubtitleFigure.horizontalSpan = 1;
			constraintFFigureGeneralisationSubtitleFigure.verticalSpan = 1;
			constraintFFigureGeneralisationSubtitleFigure.grabExcessHorizontalSpace = false;
			constraintFFigureGeneralisationSubtitleFigure.grabExcessVerticalSpace = false;
			nameRectangle0.add(fFigureGeneralisationSubtitleFigure, constraintFFigureGeneralisationSubtitleFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureGeneralisationNameFigure() {
			return fFigureGeneralisationNameFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureGeneralisationSubtitleFigure() {
			return fFigureGeneralisationSubtitleFigure;
		}

	}

	/**
	 * @generated
	 */
	static final Font FFIGUREGENERALISATIONNAMEFIGURE_FONT = new Font(Display.getCurrent(),
			Display.getDefault().getSystemFont().getFontData()[0].getName(), 8, SWT.NORMAL);

	/**
	 * @generated
	 */
	static final Font FFIGUREGENERALISATIONSUBTITLEFIGURE_FONT = new Font(Display.getCurrent(),
			Display.getDefault().getSystemFont().getFontData()[0].getName(), 7, SWT.NORMAL);

	//Gives the option to diplay a Connection/Inheritance/Specialization as black rectangle

	/**
	 * set new bounds so that the center of 'rect' matches the center of the new bounds
	 *
	 * @generated
	 */
	private void setBounds(Rectangle rect, int newWidth, int newHeight) {
		Rectangle _rect = rect.getCopy();
		_rect.setLocation(rect.getCenter().x - (newWidth / 2), rect.getCenter().y - (newHeight / 2));
		_rect.setSize(newWidth, newHeight);
		SetBoundsCommand sbc = new SetBoundsCommand(this.getEditingDomain(), "change size",
				new EObjectAdapter((View) this.getModel()), _rect);
		getEditDomain().getCommandStack().execute(new ICommandProxy(sbc));
	}

	/**
	 * 
	 * @return null if no toggling information is available, else true or false
	 *
	 * @generated
	 */
	private Boolean getToggleValue() {
		//boolean collapse = false;

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
		String collapsedString = r.getValueForKey("collapsed");

		return java.lang.Boolean.parseBoolean(collapsedString);
	}

	/**
	 *
	 * Tracks the editPartsToggledState
	 * 
	 * @generated
	 */
	private boolean inToggeledState = false;

	/**
	 * This renders the ConnectionEditPart based on information
	 * in the model. Collapsed means that the Connection is rendered as small 
	 * black rectangle. Collapsed means that the Connection will rendered as
	 * hexagon, its default figure.
	 * 
	 * @generated
	 */
	private void toggle() {
		java.lang.Boolean collapse = getToggleValue();

		//expand element
		if (collapse == null || !collapse) {

			this.setBackgroundColor(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));

			// get current location (as part of the bounds)
			Rectangle rect = figure.getClientArea().getCopy();

			//remove previous shape
			getMainFigure().getChildren().remove(0);
			//add default figure
			getMainFigure().getChildren().add(0, getPrimaryShape());

			//Hide external name label
			IFigure boderItemContainer = (IFigure) figure.getChildren().get(1);
			((IFigure) boderItemContainer.getChildren().get(0)).setVisible(false);

			//Allow Resizing
			removeEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
			installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new ResizableShapeEditPolicy());

			//When we come from read only context / addNotify the size should be in the
			//notation model
			if (getEditingDomain() instanceof InternalTransactionalEditingDomain &&
			//No transaction is running or no readonly transaction is running
					(((InternalTransactionalEditingDomain) getEditingDomain()).getActiveTransaction() == null
							|| !((InternalTransactionalEditingDomain) getEditingDomain()).getActiveTransaction()
									.isReadOnly())) {
				//Auto resize with the new shape
				Request rr = new Request(RequestConstants.REQ_AUTOSIZE);
				performRequest(rr);
			}

			// get current bounds of expanded figure (primarily: get size)
			Dimension dim = ((IFigure) getMainFigure().getChildren().get(0)).getPreferredSize().getCopy();

			//A client rectangle existed
			if (rect != null && (rect.width != 0 && rect.height != 0 && rect.x != 0 && rect.y != 0)) {

				//Set the new location based on center of the shape
				setBounds(rect, dim.width, dim.height);
			}

			inToggeledState = false;

			return;
		}
		//collapse element
		else {
			//**************************************************
			//Create the new figure (Rectangle with black background)
			//**************************************************

			//if already toggled -> return
			if (inToggeledState == true)
				return;

			Rectangle rect = (figure.getClientArea() != null) ? figure.getClientArea().getCopy() : null;

			((IFigure) figure.getChildren().get(0)).getChildren().clear();

			RectangleFigure rf = new RectangleFigure();

			rf.setBackgroundColor(Display.getDefault().getSystemColor(SWT.COLOR_BLACK));
			rf.setBorder(new LineBorder(PlatformUI.getWorkbench().getDisplay().getSystemColor(SWT.COLOR_WHITE), 2));

			getMainFigure().getChildren().add(0, rf);
			rf.setParent(getMainFigure());

			//Hide external name label
			IFigure boderItemContainer = (IFigure) figure.getChildren().get(1);
			((IFigure) boderItemContainer.getChildren().get(0)).setVisible(true);

			//A client rectangle existed
			if (rect != null && (rect.width != 0 && rect.height != 0 && rect.x != 0 && rect.y != 0)) {

				//Set the new location based on center of the shape
				setBounds(rect, 8, 8);
			}
			//A client rectangle does not exist -> called from activate
			else {
				rf.setSize(8, 8);
			}

			removeEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
			installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new NonResizableEditPolicyEx());

			inToggeledState = true;
		}
	}

	@Override
	public void activate() {
		super.activate();

		//Entity EditParts do not have a outer BorderItemContainer in contrast
		//to Connections etc. as those have external labels

		//synchronizeVisualizerAndNotationModel();

		createLinkedModelElementDecoration();

		updateView(IVisualizationServiceBase.FORMAT_GRAPH);
	}

	/**
	 * This method synchronizes the visualizer and the notation view. The
	 * method can be configured whether to write from notation model to 
	 * visualizer or the other way around. Writing to notation model is
	 * e.g. used when opening the editor or editing the visualizer. Writing
	 * to the visualizer is e.g. used when changes in the graphical editor
	 * occur.
	 * 
	 * @param notationModel True -> write from notation model to visualizer;
	 * 							false -> write from visualizer to notation model
	 */
	private void synchronizeVisualizerAndNotationModel() {
		try {
			Element self = (Element) resolveSemanticElement();
			LMLVisualizer visualizer = self.getVisualizer().get(0);

			Node node = (Node) getNotationView();
			Bounds bounds = (Bounds) node.getLayoutConstraint();
			InternalTransactionalEditingDomain domain = (InternalTransactionalEditingDomain) getEditingDomain();

			try {
				//A location is different to notation -> change in notation model
				if (bounds.getX() != visualizer.getXLocation() || bounds.getY() != visualizer.getYLocation()
						|| bounds.getWidth() != visualizer.getWidth() || bounds.getHeight() != visualizer.getHeight()) {
					//Write X and Y value to notation model
					//If a transaction is active the command stack has to be used
					if (domain.getActiveTransaction() != null) {
						CompoundCommand compoundCommand = new CompoundCommand();
						org.eclipse.emf.common.command.Command xCommand = SetCommand.create(domain, bounds,
								NotationPackage.eINSTANCE.getLocation_X(), visualizer.getXLocation());
						compoundCommand.append(xCommand);
						org.eclipse.emf.common.command.Command yCommand = SetCommand.create(domain, bounds,
								NotationPackage.eINSTANCE.getLocation_Y(), visualizer.getYLocation());
						compoundCommand.append(yCommand);
						org.eclipse.emf.common.command.Command widthCommand = SetCommand.create(domain, bounds,
								NotationPackage.eINSTANCE.getSize_Width(), visualizer.getWidth());
						compoundCommand.append(widthCommand);
						org.eclipse.emf.common.command.Command heightCommand = SetCommand.create(domain, bounds,
								NotationPackage.eINSTANCE.getSize_Height(), visualizer.getHeight());
						compoundCommand.append(heightCommand);
						domain.getCommandStack().execute(compoundCommand);
						return;
					} else {
						domain.startTransaction(false, Collections.EMPTY_MAP);
						bounds.setX(visualizer.getXLocation());
						bounds.setY(visualizer.getYLocation());
						bounds.setWidth(visualizer.getWidth());
						bounds.setHeight(visualizer.getHeight());
						domain.getActiveTransaction().commit();
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (RollbackException e) {
				e.printStackTrace();
			}
		} catch (IllegalStateException e) {
			//Who cares?!
		}
	}

	/**
	 * Searches for a link to a remote model
	 * 
	 * @return Returns the link, null otherwise
	 */
	private Link getRemoteModelLink() {
		//Check if this is a linked model element
		EObject self = resolveSemanticElement();
		Resource containingResource = self.eResource();
		LinkingModel linkingModel = null;

		for (EObject obj : containingResource.getContents())
			if (obj instanceof LinkingModel)
				linkingModel = (LinkingModel) obj;

		if (linkingModel == null)
			return null;

		Link linkToRemoteObject = null;
		Iterator<EObject> linkingModelIterator = linkingModel.eAllContents();
		while (linkingModelIterator.hasNext()) {
			EObject next = linkingModelIterator.next();

			if (next instanceof Link && ((Link) next).getTarget() == self)
				linkToRemoteObject = (Link) next;
		}

		return linkToRemoteObject;
	}

	//This variable stores the link decoration
	Decoration linkDecoration = null;

	/**
	 * Creates a decoration at the lower right if
	 * the model element is linked from a remote 
	 * model
	 */
	public void createLinkedModelElementDecoration() {
		if (linkDecoration != null)
			return;

		Link remoteLink = getRemoteModelLink();
		if (remoteLink == null)
			return;

		RemoteModel remoteModel = (RemoteModel) remoteLink.eContainer();

		Image image = PLMDiagramEditorPlugin.getInstance().getBundledImage("icons/link.gif");
		boolean isVolatile = true;
		int margin = -2;
		//Create a Decoration. This code is from DecorationEditPolicy
		IMapMode mm = MapModeUtil.getMapMode(getFigure());
		ImageFigureEx figure = new ImageFigureEx();
		figure.setImage(image);
		figure.setSize(mm.DPtoLP(image.getBounds().width), mm.DPtoLP(image.getBounds().height));

		linkDecoration = new Decoration();
		linkDecoration.add(figure);
		linkDecoration.setSize(figure.getSize());
		String tooltipText = "Link to " + remoteModel.getURL() + "/" + remoteModel.getPath();
		linkDecoration.setToolTip(new ToolTip(tooltipText));

		GraphicalEditPart ownerEditPart = (GraphicalEditPart) getAdapter(GraphicalEditPart.class);
		linkDecoration.setOwnerFigure(ownerEditPart.getFigure());

		Locator locator = new RelativeToBorderLocator(
				((GraphicalEditPart) getAdapter(GraphicalEditPart.class)).getFigure(), PositionConstants.SOUTH_EAST,
				margin);

		linkDecoration.setLocator(locator);

		// Register this figure with it's owner editpart so mouse events
		// will be propagated to it's host.
		ownerEditPart.getViewer().getVisualPartMap().put(linkDecoration, ownerEditPart);

		IFigure pane = getLayer(isVolatile ? DiagramRootEditPart.DECORATION_UNPRINTABLE_LAYER
				: DiagramRootEditPart.DECORATION_PRINTABLE_LAYER);

		pane.add(linkDecoration);
	}

	@Override
	public void deactivate() {

		//Remove the cached decoration code from DecorationEditPolicy
		if (linkDecoration != null) {
			((IFigure) linkDecoration).getParent().remove((IFigure) linkDecoration);
			GraphicalEditPart ownerEditPart = (GraphicalEditPart) getAdapter(GraphicalEditPart.class);
			ownerEditPart.getViewer().getVisualPartMap().remove(linkDecoration);
			linkDecoration = null;
		}

		super.deactivate();
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

}

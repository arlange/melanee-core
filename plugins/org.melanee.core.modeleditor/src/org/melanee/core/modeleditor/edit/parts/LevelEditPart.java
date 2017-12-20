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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.TreeIterator;
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
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.Decoration;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.draw2d.ui.internal.figures.ImageFigureEx;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
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
import org.melanee.core.dsl.service.visualizationsearchalgorithm.AspectAwareVisualizationSearchAlgorithm;
import org.melanee.core.modeleditor.custom.borders.CustomBorder;
import org.melanee.core.modeleditor.custom.resizableswimlanes.editpolicies.OneDirectionResizableEditPolicy;
import org.melanee.core.modeleditor.custom.selectioneditpolicies.ExtendableToolbarSelectionEditPolicy;
import org.melanee.core.modeleditor.custom.tooltip.ToolTip;
import org.melanee.core.modeleditor.custom.wrappers.ClabjectEditPartWrapper;
import org.melanee.core.modeleditor.edit.policies.LevelItemSemanticEditPolicy;
import org.melanee.core.modeleditor.part.PLMDiagramEditorPlugin;
import org.melanee.core.modeleditor.part.PLMVisualIDRegistry;
import org.melanee.core.modeleditor.providers.PLMElementTypes;
import org.melanee.core.models.links.links.Link;
import org.melanee.core.models.links.links.LinkingModel;
import org.melanee.core.models.links.links.RemoteModel;
import org.melanee.core.models.plm.PLM.Clabject;
import org.melanee.core.models.plm.PLM.Element;
import org.melanee.core.models.plm.PLM.LMLVisualizer;
import org.melanee.core.workbench.ExtensionPointService;
import org.melanee.core.workbench.interfaces.IApplicationVisualizationService;
import org.melanee.core.workbench.interfaces.IFormVisualizationService;
import org.melanee.core.workbench.interfaces.ITableVisualizationService;
import org.melanee.core.workbench.interfaces.ITextualVisualizationService;
import org.melanee.core.workbench.interfaces.IVisualizationServiceBase;

import de.itemis.gmf.runtime.layout.ResizableFlowLayout;

/**
 * @generated
 */
public class LevelEditPart extends ShapeNodeEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 3097;

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
	public LevelEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {

		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new LevelItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);

		removeEditPolicy(EditPolicyRoles.POPUPBAR_ROLE);
		//installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE, new org.melanee.core.modeleditor.custom.popupbartools.editpolicy.PLMModelElementPopupBarEditPolicy());

		removeEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE);

		removeEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new OneDirectionResizableEditPolicy(PositionConstants.SOUTH));

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
		return primaryShape = new ModelFigure();
	}

	/**
	* @generated
	*/
	public ModelFigure getPrimaryShape() {
		return (ModelFigure) primaryShape;
	}

	/**
	* @generated
	*/
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof LevelNameEditPart) {
			((LevelNameEditPart) childEditPart).setLabel(getPrimaryShape().getFigureDeepModelLevelNameFigure());
			return true;
		}
		if (childEditPart instanceof WrappingLabel3EditPart) {
			((WrappingLabel3EditPart) childEditPart).setLabel(getPrimaryShape().getFigureDeepModelLevelAVSFigure());
			return true;
		}
		if (childEditPart instanceof LevelDomainElementsCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getFigureDomainElementsContainer();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((LevelDomainElementsCompartmentEditPart) childEditPart).getFigure());
			return true;
		}
		return false;
	}

	/**
	* @generated
	*/
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof LevelNameEditPart) {
			return true;
		}
		if (childEditPart instanceof WrappingLabel3EditPart) {
			return true;
		}
		if (childEditPart instanceof LevelDomainElementsCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getFigureDomainElementsContainer();
			pane.remove(((LevelDomainElementsCompartmentEditPart) childEditPart).getFigure());
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
		if (editPart instanceof LevelDomainElementsCompartmentEditPart) {
			return getPrimaryShape().getFigureDomainElementsContainer();
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
		return getChildBySemanticHint(PLMVisualIDRegistry.getType(LevelNameEditPart.VISUAL_ID));
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

			//*************************************************************************
			// Update view of container (DeepModel, Level, Entity, Connection) content 
			// if a notation is changed in any format
			//*************************************************************************
			String format = notification.getNewStringValue().split("=")[0].trim();

			//If the format is not graph it can produce strange results to call
			//updateView on all children
			if (!"graph".equals(format)) {
				updateView(format);
				return;
			}

			TreeIterator<EObject> iterator = resolveSemanticElement().eAllContents();

			while (iterator.hasNext()) {
				EObject current = iterator.next();

				if (current instanceof Clabject) {
					Object editPart = findEditPart(this, current);
					if (editPart == null)
						continue;

					ClabjectEditPartWrapper wrapper = new ClabjectEditPartWrapper(editPart);
					wrapper.updateView(notification.getNewStringValue().split("=")[0].trim());
				}
			}

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

		java.lang.String notation = AspectAwareVisualizationSearchAlgorithm
				.searchNotationForElement((Element) this.resolveSemanticElement(), format);

		//*******************************************
		//BEGIN Apply the form rendering if requested
		//*******************************************
		if (IVisualizationServiceBase.FORMAT_FORM.equals(format) || IVisualizationServiceBase.FORMAT_TEXT.equals(format)
				|| IVisualizationServiceBase.FORMAT_APP.equals(format)
				|| IVisualizationServiceBase.FORMAT_TABLE.equals(format)) {
			try {
				if (IVisualizationServiceBase.FORMAT_FORM.equals(format)) {
					IFormVisualizationService service = ExtensionPointService.Instance()
							.getActiveFormVisualizationService();
					if (service != null)
						service.run(this, notation, true);
				} else if (IVisualizationServiceBase.FORMAT_TEXT.equals(format)) {
					ITextualVisualizationService service = ExtensionPointService.Instance()
							.getActiveTextualVisualizationService();
					if (service != null)
						service.run(this, notation, true);
				} else if (IVisualizationServiceBase.FORMAT_APP.equals(format)) {
					IApplicationVisualizationService service = ExtensionPointService.Instance()
							.getActiveApplicationVisualizationService();
					if (service != null)
						service.run(this, notation, true);
				} else if (IVisualizationServiceBase.FORMAT_TABLE.equals(format)) {
					ITableVisualizationService service = ExtensionPointService.Instance()
							.getActiveTableVisualizationService();
					if (service != null)
						service.run(this, notation, true);
				}
			} catch (CoreException e) {
				e.printStackTrace();
			}

			return;
		}
		//*******************************************
		//END Apply the form rendering if requested
		//*******************************************

	}

	/**
	 * @generated
	 */
	public class ModelFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureDeepModelLevelNameFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureDeepModelLevelAVSFigure;
		/**
		 * @generated
		 */
		private RectangleFigure fFigureDomainElementsContainer;

		/**
		 * @generated
		 */
		public ModelFigure() {

			ResizableFlowLayout layoutThis = new ResizableFlowLayout();
			this.setLayoutManager(layoutThis);

			this.setFill(false);
			this.setOutline(false);
			this.setLineWidth(0);
			this.setBorder(createBorder0());
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			RectangleFigure nameRectangle0 = new RectangleFigure();

			nameRectangle0.setFill(false);
			nameRectangle0.setOutline(false);
			nameRectangle0.setMaximumSize(new Dimension(getMapMode().DPtoLP(0), getMapMode().DPtoLP(25)));

			this.add(nameRectangle0);

			GridLayout layoutNameRectangle0 = new GridLayout();
			layoutNameRectangle0.numColumns = 2;
			layoutNameRectangle0.makeColumnsEqualWidth = false;
			layoutNameRectangle0.horizontalSpacing = 0;
			layoutNameRectangle0.verticalSpacing = 0;
			layoutNameRectangle0.marginWidth = 0;
			layoutNameRectangle0.marginHeight = 3;
			nameRectangle0.setLayoutManager(layoutNameRectangle0);

			fFigureDeepModelLevelNameFigure = new WrappingLabel();

			fFigureDeepModelLevelNameFigure.setText("");

			fFigureDeepModelLevelNameFigure.setFont(FFIGUREDEEPMODELLEVELNAMEFIGURE_FONT);

			fFigureDeepModelLevelNameFigure
					.setMaximumSize(new Dimension(getMapMode().DPtoLP(0), getMapMode().DPtoLP(20)));

			GridData constraintFFigureDeepModelLevelNameFigure = new GridData();
			constraintFFigureDeepModelLevelNameFigure.verticalAlignment = GridData.CENTER;
			constraintFFigureDeepModelLevelNameFigure.horizontalAlignment = GridData.BEGINNING;
			constraintFFigureDeepModelLevelNameFigure.horizontalIndent = 0;
			constraintFFigureDeepModelLevelNameFigure.horizontalSpan = 1;
			constraintFFigureDeepModelLevelNameFigure.verticalSpan = 1;
			constraintFFigureDeepModelLevelNameFigure.grabExcessHorizontalSpace = false;
			constraintFFigureDeepModelLevelNameFigure.grabExcessVerticalSpace = false;
			nameRectangle0.add(fFigureDeepModelLevelNameFigure, constraintFFigureDeepModelLevelNameFigure);

			fFigureDeepModelLevelAVSFigure = new WrappingLabel();

			fFigureDeepModelLevelAVSFigure.setText("");

			fFigureDeepModelLevelAVSFigure.setFont(FFIGUREDEEPMODELLEVELAVSFIGURE_FONT);

			fFigureDeepModelLevelAVSFigure
					.setMaximumSize(new Dimension(getMapMode().DPtoLP(0), getMapMode().DPtoLP(20)));

			GridData constraintFFigureDeepModelLevelAVSFigure = new GridData();
			constraintFFigureDeepModelLevelAVSFigure.verticalAlignment = GridData.CENTER;
			constraintFFigureDeepModelLevelAVSFigure.horizontalAlignment = GridData.BEGINNING;
			constraintFFigureDeepModelLevelAVSFigure.horizontalIndent = 0;
			constraintFFigureDeepModelLevelAVSFigure.horizontalSpan = 1;
			constraintFFigureDeepModelLevelAVSFigure.verticalSpan = 1;
			constraintFFigureDeepModelLevelAVSFigure.grabExcessHorizontalSpace = true;
			constraintFFigureDeepModelLevelAVSFigure.grabExcessVerticalSpace = true;
			nameRectangle0.add(fFigureDeepModelLevelAVSFigure, constraintFFigureDeepModelLevelAVSFigure);

			fFigureDomainElementsContainer = new RectangleFigure();

			fFigureDomainElementsContainer.setFill(false);
			fFigureDomainElementsContainer.setOutline(false);

			this.add(fFigureDomainElementsContainer);

		}

		/**
		 * @generated
		 */
		private Border createBorder0() {
			CustomBorder result = new CustomBorder();
			result.setBottom(true);

			return result;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureDeepModelLevelNameFigure() {
			return fFigureDeepModelLevelNameFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureDeepModelLevelAVSFigure() {
			return fFigureDeepModelLevelAVSFigure;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureDomainElementsContainer() {
			return fFigureDomainElementsContainer;
		}

	}

	/**
	 * @generated
	 */
	static final Font FFIGUREDEEPMODELLEVELNAMEFIGURE_FONT = new Font(Display.getCurrent(),
			Display.getDefault().getSystemFont().getFontData()[0].getName(), 10, SWT.NORMAL);

	/**
	 * @generated
	 */
	static final Font FFIGUREDEEPMODELLEVELAVSFIGURE_FONT = new Font(Display.getCurrent(),
			Display.getDefault().getSystemFont().getFontData()[0].getName(), 8, SWT.NORMAL);

	//Gives the option to diplay a Connection/Inheritance/Specialization as black rectangle

	@Override
	public Command getCommand(Request _request) {
		getFigure().invalidateTree(); // ensure that the LevelDomainElementsCompartment's figure has properly set bounds
		Command cmd = super.getCommand(_request);

		if (cmd == null && _request instanceof CreateUnspecifiedTypeRequest) {
			CreateUnspecifiedTypeRequest createUnspecifiedTypeRequest = (CreateUnspecifiedTypeRequest) _request;

			if (createUnspecifiedTypeRequest.getElementTypes().contains(PLMElementTypes.Entity_3105)
					|| createUnspecifiedTypeRequest.getElementTypes().contains(PLMElementTypes.Package_3125)) {
				EditPart levelDomainElementsCompartment = getLevelDomainElementsCompartment();
				cmd = levelDomainElementsCompartment.getCommand(createUnspecifiedTypeRequest);
			} else if (createUnspecifiedTypeRequest.getElementTypes().contains(PLMElementTypes.Level_3097)) {
				// Level creation request detected, build new request to prevent an exception
				List<IElementType> types = new ArrayList<IElementType>();
				types.add(PLMElementTypes.Level_3097);
				PreferencesHint prefHint = getDiagramPreferencesHint();
				CreateUnspecifiedTypeRequest createLevelRequest = new CreateUnspecifiedTypeRequest(types, prefHint);

				// send new request to the LevelCompartment
				EditPart levelCompartment = getParent();
				while (!(levelCompartment instanceof DeepModelDeepModelLevelCompartmentEditPart))
					levelCompartment = levelCompartment.getParent();
				cmd = levelCompartment.getCommand(createLevelRequest);
			}
		}

		return cmd;
	}

	/**
	 * returns the EditPart of the LevelDomainElementsCompartment of a Level
	 * 
	 * @param level the Level
	 * @return the LevelDomainElementsCompartment
	 */
	public IGraphicalEditPart getLevelDomainElementsCompartment() {
		for (Object child : getChildren())
			if (child instanceof LevelDomainElementsCompartmentEditPart)
				return (IGraphicalEditPart) child;

		return null;
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

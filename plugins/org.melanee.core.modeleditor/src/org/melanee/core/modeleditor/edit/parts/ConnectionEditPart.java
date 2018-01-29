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
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
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
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.impl.InternalTransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.SelectionEditPolicy;
import org.eclipse.gef.handles.MoveHandle;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IResizableCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConstrainedToolbarLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.NonResizableEditPolicyEx;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableShapeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditDomain;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.Decoration;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.draw2d.ui.internal.figures.ImageFigureEx;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.gef.ui.internal.figures.RelativeToBorderLocator;
import org.eclipse.gmf.runtime.notation.BasicCompartment;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.helper.OCLHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.melanee.core.dsl.service.visualizationsearchalgorithm.AspectAwareVisualizationSearchAlgorithm;
import org.melanee.core.modeleditor.custom.contentawarecontainer.ContentAwareContainerEditPolicy;
import org.melanee.core.modeleditor.custom.figures.DefaultSizeNodeFixedAnchors;
import org.melanee.core.modeleditor.custom.implicitconnection.policy.ImplicitConnectionGraphicalNodeEditPolicy;
import org.melanee.core.modeleditor.custom.selectioneditpolicies.EntityConnectionSelectionEditPolicy;
import org.melanee.core.modeleditor.custom.tooltip.ToolTip;
import org.melanee.core.modeleditor.custom.wrappers.ClabjectEditPartWrapper;
import org.melanee.core.modeleditor.edit.policies.ConnectionItemSemanticEditPolicy;
import org.melanee.core.modeleditor.edit.policies.PLMTextSelectionEditPolicy;
import org.melanee.core.modeleditor.part.PLMDiagramEditor;
import org.melanee.core.modeleditor.part.PLMDiagramEditorPlugin;
import org.melanee.core.modeleditor.part.PLMVisualIDRegistry;
import org.melanee.core.modeleditor.providers.PLMElementTypes;
import org.melanee.core.models.links.links.Link;
import org.melanee.core.models.links.links.LinkingModel;
import org.melanee.core.models.links.links.RemoteModel;
import org.melanee.core.models.plm.PLM.Attribute;
import org.melanee.core.models.plm.PLM.Clabject;
import org.melanee.core.models.plm.PLM.Classification;
import org.melanee.core.models.plm.PLM.Connection;
import org.melanee.core.models.plm.PLM.ConnectionEnd;
import org.melanee.core.models.plm.PLM.ConnectionEndKind;
import org.melanee.core.models.plm.PLM.Element;
import org.melanee.core.models.plm.PLM.Entity;
import org.melanee.core.models.plm.PLM.Feature;
import org.melanee.core.models.plm.PLM.LMLVisualizer;
import org.melanee.core.workbench.ExtensionPointService;
import org.melanee.core.workbench.interfaces.IApplicationVisualizationService;
import org.melanee.core.workbench.interfaces.IDesignationService;
import org.melanee.core.workbench.interfaces.IFormVisualizationService;
import org.melanee.core.workbench.interfaces.ITableVisualizationService;
import org.melanee.core.workbench.interfaces.ITextualVisualizationService;
import org.melanee.core.workbench.interfaces.IVisualizationServiceBase;

/**
 * @generated
 */
public class ConnectionEditPart extends AbstractBorderedShapeEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 3099;

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
	public ConnectionEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {

		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ConnectionItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);

		removeEditPolicy(EditPolicyRoles.POPUPBAR_ROLE);
		//installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE, new org.melanee.core.modeleditor.custom.popupbartools.editpolicy.PLMModelElementPopupBarEditPolicy());

		removeEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE);

		removeEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE);
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new ImplicitConnectionGraphicalNodeEditPolicy());

		installEditPolicy(SelectionEditPolicy.SELECTION_FEEDBACK_ROLE, new EntityConnectionSelectionEditPolicy());

		removeEditPolicy(EditPolicy.LAYOUT_ROLE);
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new ContentAwareContainerEditPolicy());

	}

	/**
	* @generated
	*/
	protected LayoutEditPolicy createLayoutEditPolicy() {

		ConstrainedToolbarLayoutEditPolicy lep = new ConstrainedToolbarLayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				View childView = (View) child.getModel();
				switch (PLMVisualIDRegistry.getVisualID(childView)) {
				case ConnectionNameEditPart.VISUAL_ID:
					return new BorderItemSelectionEditPolicy() {

						protected List createSelectionHandles() {
							MoveHandle mh = new MoveHandle((GraphicalEditPart) getHost());
							mh.setBorder(null);
							return Collections.singletonList(mh);
						}
					};
				}
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
		return primaryShape = new ConnectionFigure();
	}

	/**
	* @generated
	*/
	public ConnectionFigure getPrimaryShape() {
		return (ConnectionFigure) primaryShape;
	}

	/**
	* @generated
	*/
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof WrappingLabel4EditPart) {
			((WrappingLabel4EditPart) childEditPart).setLabel(getPrimaryShape().getFigureConnectionNameFigure());
			return true;
		}
		if (childEditPart instanceof WrappingLabel5EditPart) {
			((WrappingLabel5EditPart) childEditPart).setLabel(getPrimaryShape().getFigureConnectionLevelFigure());
			return true;
		}
		if (childEditPart instanceof WrappingLabel6EditPart) {
			((WrappingLabel6EditPart) childEditPart).setLabel(getPrimaryShape().getFigureConnectionPotencyFigure());
			return true;
		}
		if (childEditPart instanceof WrappingLabel7EditPart) {
			((WrappingLabel7EditPart) childEditPart).setLabel(getPrimaryShape().getFigureConnectionAVSFigure());
			return true;
		}
		if (childEditPart instanceof WrappingLabel8EditPart) {
			((WrappingLabel8EditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureConnectionProximityClassificationFigure());
			return true;
		}
		if (childEditPart instanceof ConnectionConnectionAttributesCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getFigureAttributesCompartmentRectangle();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((ConnectionConnectionAttributesCompartmentEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof ConnectionConnectionMethodsCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getFigureMethodsCompartmentRectangle();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((ConnectionConnectionMethodsCompartmentEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof ConnectionConnectionContentsCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getFigureContentCompartmentRectangle();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((ConnectionConnectionContentsCompartmentEditPart) childEditPart).getFigure());
			return true;
		}
		return false;
	}

	/**
	* @generated
	*/
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof WrappingLabel4EditPart) {
			return true;
		}
		if (childEditPart instanceof WrappingLabel5EditPart) {
			return true;
		}
		if (childEditPart instanceof WrappingLabel6EditPart) {
			return true;
		}
		if (childEditPart instanceof WrappingLabel7EditPart) {
			return true;
		}
		if (childEditPart instanceof WrappingLabel8EditPart) {
			return true;
		}
		if (childEditPart instanceof ConnectionConnectionAttributesCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getFigureAttributesCompartmentRectangle();
			pane.remove(((ConnectionConnectionAttributesCompartmentEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof ConnectionConnectionMethodsCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getFigureMethodsCompartmentRectangle();
			pane.remove(((ConnectionConnectionMethodsCompartmentEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof ConnectionConnectionContentsCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getFigureContentCompartmentRectangle();
			pane.remove(((ConnectionConnectionContentsCompartmentEditPart) childEditPart).getFigure());
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
		if (editPart instanceof ConnectionConnectionAttributesCompartmentEditPart) {
			return getPrimaryShape().getFigureAttributesCompartmentRectangle();
		}
		if (editPart instanceof ConnectionConnectionMethodsCompartmentEditPart) {
			return getPrimaryShape().getFigureMethodsCompartmentRectangle();
		}
		if (editPart instanceof ConnectionConnectionContentsCompartmentEditPart) {
			return getPrimaryShape().getFigureContentCompartmentRectangle();
		}
		if (editPart instanceof IBorderItemEditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}
		return getContentPane();
	}

	protected void addBorderItem(IFigure borderItemContainer, IBorderItemEditPart borderItemEditPart) {
		/**
		* @generated
		*/

		if (borderItemEditPart instanceof ConnectionNameEditPart) {
			BorderItemLocator locator = new BorderItemLocator(getMainFigure(), PositionConstants.SOUTH);
			locator.setBorderItemOffset(new Dimension(0, -8));
			borderItemContainer.add(borderItemEditPart.getFigure(), locator);
		} else {
			super.addBorderItem(borderItemContainer, borderItemEditPart);
		}
	}

	/**
	* @generated
	*/
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);

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
		return getChildBySemanticHint(PLMVisualIDRegistry.getType(WrappingLabel4EditPart.VISUAL_ID));
	}

	/**
	* @generated
	*/
	public EditPart getTargetEditPart(Request request) {
		if (request instanceof CreateViewAndElementRequest) {
			CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest) request).getViewAndElementDescriptor()
					.getCreateElementRequestAdapter();
			IElementType type = (IElementType) adapter.getAdapter(IElementType.class);
			if (type == PLMElementTypes.Attribute_3100) {
				return getChildBySemanticHint(
						PLMVisualIDRegistry.getType(ConnectionConnectionAttributesCompartmentEditPart.VISUAL_ID));
			}
			if (type == PLMElementTypes.Method_3102) {
				return getChildBySemanticHint(
						PLMVisualIDRegistry.getType(ConnectionConnectionMethodsCompartmentEditPart.VISUAL_ID));
			}
		}
		return super.getTargetEditPart(request);
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

		//*************************************************************************
		//We want to update the DSL notation for Entities
		//*************************************************************************
		if (notification.getNotifier() instanceof Attribute
				&& ((EStructuralFeature) notification.getFeature()).getName().equals("value"))
			updateView(IVisualizationServiceBase.FORMAT_GRAPH);

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

			//*************************************************************************
			//Update view if a notation is changed in any format
			//*************************************************************************
			updateView(notification.getNewStringValue().split("=")[0].trim());

			//*************************************************************************
			//Manage the classifications view state according to designation
			//*************************************************************************
			View v = this.getNotationView();
			LMLVisualizer LMLVisualizer = (LMLVisualizer) notification.getNotifier();

			HashSet<View> outgoingEdges = new HashSet<View>();
			org.eclipse.ocl.ecore.OCL ocl = org.eclipse.ocl.ecore.OCL.newInstance();

			OCLHelper<EClassifier, ?, ?, Constraint> helper = ocl.createOCLHelper();
			helper.setContext(NotationPackage.Literals.VIEW);

			try {
				//Need to take care to only select classification - plm::Classification is not known here..
				OCLExpression<EClassifier> q = helper.createQuery(
						"Edge.allInstances()->select(e | e.source = self)->select(e | e.element.oclIsUndefined() <> true)");
				outgoingEdges = ((HashSet<View>) ocl.evaluate(v, q));
			} catch (ParserException e) {
				e.printStackTrace();
			}

			LinkedList<View> outgoingClassificationEdges = new LinkedList<View>();

			//Only take views of Classifications
			for (View c : outgoingEdges)
				if (c.getElement() instanceof Classification)
					outgoingClassificationEdges.add(c);

			//This has currently no support for multiple classifications
			if (outgoingClassificationEdges.size() > 0) {
				if ("1".equals(LMLVisualizer.getValueForKey("ProximityClassification")))
					outgoingClassificationEdges.get(0).setVisible(false);
				else
					outgoingClassificationEdges.get(0).setVisible(true);

				IGraphicalEditPart edgeEP = (IGraphicalEditPart) getViewer().getEditPartRegistry()
						.get(outgoingClassificationEdges.get(0));

				if (edgeEP != null)
					edgeEP.performRequest(new Request(RequestConstants.REQ_REFRESH));
				//In cases where there is no editpart, refresh both ends to get it created
				else {
					Edge classView = (Edge) outgoingClassificationEdges.get(0);
					((EditPart) getViewer().getEditPartRegistry().get(classView.getTarget())).refresh();
					((EditPart) getViewer().getEditPartRegistry().get(classView.getSource())).refresh();
				}
			}

		}

		EStructuralFeature changedFeature = (EStructuralFeature) notification.getFeature();
		if (notification.getNotifier() instanceof Element) {

			if (changedFeature.getName().equals("potency")) {
				for (EObject eObj : ((Clabject) resolveSemanticElement()).getFeature()) {
					findEditPart(this, eObj).performRequest(new Request(RequestConstants.REQ_REFRESH));
				}
			}

			if (changedFeature.getName().equals("name") && notification.getNotifier() instanceof Entity) {
				PLMDiagramEditor plmEditor = (PLMDiagramEditor) ((DiagramEditDomain) ((IGraphicalEditPart) this)
						.getDiagramEditDomain()).getEditorPart();

				Entity changedEntity = (Entity) notification.getNotifier();
				for (Clabject instance : changedEntity.getInstances()) {
					List featureEditParts = plmEditor.getDiagramGraphicalViewer()
							.findEditPartsForElement(EMFCoreUtil.getProxyID(instance), NodeEditPart.class);

					if (featureEditParts.size() > 0) {
						IGraphicalEditPart featureEditPart = (IGraphicalEditPart) featureEditParts.get(0);
						if (featureEditPart instanceof EntityEditPart)
							((EntityEditPart) featureEditPart).updateView(IVisualizationServiceBase.FORMAT_GRAPH);
						else if (featureEditPart instanceof Entity2EditPart)
							((Entity2EditPart) featureEditPart).updateView(IVisualizationServiceBase.FORMAT_GRAPH);
						else if (featureEditPart instanceof Entity3EditPart)
							((Entity3EditPart) featureEditPart).updateView(IVisualizationServiceBase.FORMAT_GRAPH);
					}
				}
			}

			if (changedFeature.getName().equals("feature") && notification.getNewValue() instanceof Attribute) {
				makeCompartmentsVisible(COMPARTMENT_ATTRIBUTES);

				// add a new listener so that each clabject is notified of changes of its attributes (would require saving and reloading a diagram without these two lines)
				Feature f = (Feature) notification.getNewValue();
				addListenerFilter(f.toString().substring(0, f.toString().indexOf(" ")), this, f);
			}

			if (changedFeature.getName().equals("content") || changedFeature.getName().equals("feature"))
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

		Element self = (Element) resolveSemanticElement();
		boolean hasCompositeAggregate = false;

		//*******************************************
		// BEGING Show hide depending on containment
		//*******************************************
		for (ConnectionEnd p : ((Connection) self).getConnectionEnd())
			if (p.getKind() != ConnectionEndKind.BASIC)
				hasCompositeAggregate = true;

		if (hasCompositeAggregate) {
			// Containment/Aggregation 
			List<Clabject> participants = ((Connection) self).getParticipants();

			if ((participants.get(0).getContent().contains(participants.get(1))
					|| participants.get(1).getContent().contains(participants.get(0)))) {
				if (!getNotationView().isVisible())
					return;

				//Set Notation view to invisble so that it does not appear in the command stack
				InternalTransactionalEditingDomain domain = (InternalTransactionalEditingDomain) getEditingDomain();

				Map<java.lang.String, java.lang.Boolean> commandOptions = Collections
						.singletonMap(Transaction.OPTION_NO_UNDO, java.lang.Boolean.TRUE);

				try {
					if (domain.getActiveTransaction() != null && domain.getActiveTransaction().isReadOnly())
						domain.getActiveTransaction().commit();

					domain.startTransaction(false, commandOptions);
					getNotationView().setVisible(false);
					domain.getActiveTransaction().commit();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (RollbackException e) {
					e.printStackTrace();
				}

				return;
			}
		}
		//*******************************************
		// END Show hide depending on containment
		//*******************************************		

		if (sourceConnections != null) {
			//ConnectionEnd need to be updated
			for (java.lang.Object ep : sourceConnections)
				if (ep instanceof ConnectionEndEditPart)
					((ConnectionEndEditPart) ep).updateView(IVisualizationServiceBase.FORMAT_GRAPH);
		}

		if (notation != null && notation.length() > 0 && !notation.equals(IVisualizationServiceBase.NOTATION_LML)) {

			toggle();

			return;
		}

		Clabject c = (Clabject) resolveSemanticElement();

		java.lang.Boolean toggleValue = getToggleValue();

		//We do toggle the connection
		if (toggleValue != null)
			toggle();

		//We can change expressed as long as connection is not elided and not toggled
		if ((toggleValue == null || toggleValue == false)) {
			makeCompartmentsVisible(COMPARTMENT_AUTOMATIC); // hide all empty compartments
		}

	}

	/**
	 * @generated
	 */
	private void updateNameCompartment() {
		try {

			Clabject self = (Clabject) resolveSemanticElement();

			//No visualization information available
			if (self.getVisualizer().size() == 0)
				return;

			IDesignationService designationService = ExtensionPointService.Instance().getActiveDesignationService();

			WrappingLabel classificationDesignationWrappingLabel =

					((org.melanee.core.modeleditor.edit.parts.ConnectionEditPart.ConnectionFigure) getPrimaryShape())
							.getFigureConnectionProximityClassificationFigure();

			WrappingLabel inheritanceDesignationWrappingLabel =

					((org.melanee.core.modeleditor.edit.parts.ConnectionEditPart.ConnectionFigure) getPrimaryShape())
							.getFigureConnectionProximityInheritanceFigure();

			WrappingLabel containmentDesignationWrappingLabel =

					((org.melanee.core.modeleditor.edit.parts.ConnectionEditPart.ConnectionFigure) getPrimaryShape())
							.getFigureConnectionProximityContainmentFigure();

			WrappingLabel identifierDesignationWrappingLabel =

					((org.melanee.core.modeleditor.edit.parts.ConnectionEditPart.ConnectionFigure) getPrimaryShape())
							.getFigureConnectionNameFigure();

			String designationRequest = self.getVisualizer().get(0).getValueForKey("ProximityIndication");

			classificationDesignationWrappingLabel
					.setText(designationService.createClassificationDesignationString(self, designationRequest));
			inheritanceDesignationWrappingLabel
					.setText(designationService.createHeritageDesignationString(self, designationRequest));
			containmentDesignationWrappingLabel
					.setText(designationService.createLocationDesignationString(self, designationRequest));

			String newIdentification = designationService.createIdenficationDesignationString(self, designationRequest);
			if (newIdentification.equals("~"))
				newIdentification = self.getName();
			identifierDesignationWrappingLabel.setText(newIdentification);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	public static final int COMPARTMENT_AUTOMATIC = 0;
	public static final int COMPARTMENT_ATTRIBUTES = 1;
	public static final int COMPARTMENT_METHODS = 2;
	public static final int COMPARTMENT_CONTENT = 4;

	/**
	 * Makes the compartments specified by 'compartments' visible. Bitwise-Or combinations of COMPARTMENT_ATTRIBUTES
	 * COMPARTMENT_METHODS and COMPARTMENT_CONTENT are valid values for this parameter. Forcing compartments to be
	 * is neither implemented nor currently intended. COMPARTMENT_AUTOMATIC is making the compartments with content
	 * visible. 
	 */
	public void makeCompartmentsVisible(int compartments) {
		InternalTransactionalEditingDomain domain = (InternalTransactionalEditingDomain) getEditingDomain();

		Map<java.lang.String, java.lang.Boolean> commandOptions = Collections.singletonMap(Transaction.OPTION_NO_UNDO,
				java.lang.Boolean.TRUE);

		if (domain.getActiveTransaction() != null && domain.getActiveTransaction().isReadOnly())
			return;

		try {
			Clabject self = (Clabject) resolveSemanticElement();

			domain.startTransaction(false, commandOptions);

			// manage attributes compartment visibility
			if ((compartments & COMPARTMENT_ATTRIBUTES) != 0)
				getAttributesCompartmentView().setVisible(true);
			else if (self.getDefinedAttributes().size() == 0 && getAttributesCompartment() != null)
				getAttributesCompartmentView().setVisible(false);

			// manage methods compartment visibility
			if ((compartments & COMPARTMENT_METHODS) != 0)
				getMethodsCompartmentView().setVisible(true);
			else if (self.getDefinedMethods().size() == 0 && getMethodsCompartment() != null)
				getMethodsCompartmentView().setVisible(false);

			// manage content compartment visibility
			if ((compartments & COMPARTMENT_CONTENT) != 0)
				getContentsCompartmentView().setVisible(true);
			else if (self.getContent().size() == 0 && getContentsCompartment() != null)
				getContentsCompartmentView().setVisible(false);

			domain.getActiveTransaction().commit();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (RollbackException e) {
			e.printStackTrace();
		}
	}

	public IResizableCompartmentEditPart getAttributesCompartment() {
		for (Object ep : getChildren())
			if (ep instanceof ConnectionConnectionAttributesCompartmentEditPart
					|| ep instanceof ConnectionConnectionAttributesCompartment2EditPart
					|| ep instanceof ConnectionConnectionAttributesCompartment3EditPart)
				return (IResizableCompartmentEditPart) ep;

		return null;
	}

	private View getAttributesCompartmentView() {
		for (View v : (List<View>) getNotationView().getChildren())
			if (v instanceof BasicCompartment) {
				try {
					int type = (new Integer(v.getType())).intValue();
					if (ConnectionConnectionAttributesCompartmentEditPart.VISUAL_ID == type
							|| ConnectionConnectionAttributesCompartment2EditPart.VISUAL_ID == type
							|| ConnectionConnectionAttributesCompartment3EditPart.VISUAL_ID == type)
						return v;
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
			}

		return null;
	}

	public IResizableCompartmentEditPart getMethodsCompartment() {
		for (Object ep : getChildren())
			if (ep instanceof ConnectionConnectionMethodsCompartmentEditPart
					|| ep instanceof ConnectionConnectionMethodsCompartment2EditPart
					|| ep instanceof ConnectionConnectionMethodsCompartment3EditPart)
				return (IResizableCompartmentEditPart) ep;

		return null;
	}

	private View getMethodsCompartmentView() {
		for (View v : (List<View>) getNotationView().getChildren())
			if (v instanceof BasicCompartment) {
				try {
					int type = (new Integer(v.getType())).intValue();
					if (ConnectionConnectionMethodsCompartmentEditPart.VISUAL_ID == type
							|| ConnectionConnectionMethodsCompartment2EditPart.VISUAL_ID == type
							|| ConnectionConnectionMethodsCompartment3EditPart.VISUAL_ID == type)
						return v;
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
			}

		return null;
	}

	public IResizableCompartmentEditPart getContentsCompartment() {
		for (Object ep : getChildren())
			if (ep instanceof ConnectionConnectionContentsCompartmentEditPart
					|| ep instanceof ConnectionConnectionContentsCompartment2EditPart
					|| ep instanceof ConnectionConnectionContentsCompartment3EditPart)
				return (IResizableCompartmentEditPart) ep;

		return null;
	}

	private View getContentsCompartmentView() {
		for (View v : (List<View>) getNotationView().getChildren())
			if (v instanceof BasicCompartment) {
				try {
					int type = (new Integer(v.getType())).intValue();
					if (ConnectionConnectionContentsCompartmentEditPart.VISUAL_ID == type
							|| ConnectionConnectionContentsCompartment2EditPart.VISUAL_ID == type
							|| ConnectionConnectionContentsCompartment3EditPart.VISUAL_ID == type)
						return v;
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
			}

		return null;
	}

	/**
	 * @generated
	 */
	public class ConnectionFigure extends ScalablePolygonShape {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureConnectionProximityInheritanceFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureConnectionProximityContainmentFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureConnectionNameFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureConnectionProximityClassificationFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureConnectionPotencyFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureConnectionLevelFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureConnectionAVSFigure;
		/**
		 * @generated
		 */
		private RectangleFigure fFigureAttributesCompartmentRectangle;
		/**
		 * @generated
		 */
		private RectangleFigure fFigureMethodsCompartmentRectangle;
		/**
		 * @generated
		 */
		private RectangleFigure fFigureContentCompartmentRectangle;
		/**
		 * @generated
		 */
		private RectangleFigure fFigureVisualizerCompartmentRectangle;

		/**
		 * @generated
		 */
		public ConnectionFigure() {

			ToolbarLayout layoutThis = new ToolbarLayout();
			layoutThis.setStretchMinorAxis(true);
			layoutThis.setMinorAlignment(ToolbarLayout.ALIGN_TOPLEFT);

			layoutThis.setSpacing(0);
			layoutThis.setVertical(true);

			this.setLayoutManager(layoutThis);

			this.addPoint(new Point(getMapMode().DPtoLP(0), getMapMode().DPtoLP(3)));
			this.addPoint(new Point(getMapMode().DPtoLP(0), getMapMode().DPtoLP(40)));
			this.addPoint(new Point(getMapMode().DPtoLP(20), getMapMode().DPtoLP(42)));
			this.addPoint(new Point(getMapMode().DPtoLP(40), getMapMode().DPtoLP(40)));
			this.addPoint(new Point(getMapMode().DPtoLP(40), getMapMode().DPtoLP(3)));
			this.addPoint(new Point(getMapMode().DPtoLP(20), getMapMode().DPtoLP(0)));
			this.setFill(true);
			this.setForegroundColor(ColorConstants.black);

			this.setBorder(new MarginBorder(getMapMode().DPtoLP(3), getMapMode().DPtoLP(0), getMapMode().DPtoLP(15),
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
			layoutInnerRectangle0.numColumns = 1;
			layoutInnerRectangle0.makeColumnsEqualWidth = false;
			layoutInnerRectangle0.horizontalSpacing = 0;
			layoutInnerRectangle0.verticalSpacing = 0;
			layoutInnerRectangle0.marginWidth = 0;
			layoutInnerRectangle0.marginHeight = 0;
			innerRectangle0.setLayoutManager(layoutInnerRectangle0);

			RectangleFigure nameRectangle1 = new RectangleFigure();

			nameRectangle1.setFill(false);
			nameRectangle1.setOutline(false);

			GridData constraintNameRectangle1 = new GridData();
			constraintNameRectangle1.verticalAlignment = GridData.BEGINNING;
			constraintNameRectangle1.horizontalAlignment = GridData.CENTER;
			constraintNameRectangle1.horizontalIndent = 0;
			constraintNameRectangle1.horizontalSpan = 1;
			constraintNameRectangle1.verticalSpan = 1;
			constraintNameRectangle1.grabExcessHorizontalSpace = true;
			constraintNameRectangle1.grabExcessVerticalSpace = false;
			innerRectangle0.add(nameRectangle1, constraintNameRectangle1);

			GridLayout layoutNameRectangle1 = new GridLayout();
			layoutNameRectangle1.numColumns = 5;
			layoutNameRectangle1.makeColumnsEqualWidth = false;
			layoutNameRectangle1.horizontalSpacing = 0;
			layoutNameRectangle1.verticalSpacing = 0;
			layoutNameRectangle1.marginWidth = 3;
			layoutNameRectangle1.marginHeight = 3;
			nameRectangle1.setLayoutManager(layoutNameRectangle1);

			fFigureConnectionProximityInheritanceFigure = new WrappingLabel();

			fFigureConnectionProximityInheritanceFigure.setText("");

			fFigureConnectionProximityInheritanceFigure.setFont(FFIGURECONNECTIONPROXIMITYINHERITANCEFIGURE_FONT);

			GridData constraintFFigureConnectionProximityInheritanceFigure = new GridData();
			constraintFFigureConnectionProximityInheritanceFigure.verticalAlignment = GridData.CENTER;
			constraintFFigureConnectionProximityInheritanceFigure.horizontalAlignment = GridData.BEGINNING;
			constraintFFigureConnectionProximityInheritanceFigure.horizontalIndent = 0;
			constraintFFigureConnectionProximityInheritanceFigure.horizontalSpan = 1;
			constraintFFigureConnectionProximityInheritanceFigure.verticalSpan = 4;
			constraintFFigureConnectionProximityInheritanceFigure.grabExcessHorizontalSpace = false;
			constraintFFigureConnectionProximityInheritanceFigure.grabExcessVerticalSpace = true;
			nameRectangle1.add(fFigureConnectionProximityInheritanceFigure,
					constraintFFigureConnectionProximityInheritanceFigure);

			fFigureConnectionProximityContainmentFigure = new WrappingLabel();

			fFigureConnectionProximityContainmentFigure.setText("");

			fFigureConnectionProximityContainmentFigure.setFont(FFIGURECONNECTIONPROXIMITYCONTAINMENTFIGURE_FONT);

			GridData constraintFFigureConnectionProximityContainmentFigure = new GridData();
			constraintFFigureConnectionProximityContainmentFigure.verticalAlignment = GridData.CENTER;
			constraintFFigureConnectionProximityContainmentFigure.horizontalAlignment = GridData.BEGINNING;
			constraintFFigureConnectionProximityContainmentFigure.horizontalIndent = 0;
			constraintFFigureConnectionProximityContainmentFigure.horizontalSpan = 1;
			constraintFFigureConnectionProximityContainmentFigure.verticalSpan = 4;
			constraintFFigureConnectionProximityContainmentFigure.grabExcessHorizontalSpace = false;
			constraintFFigureConnectionProximityContainmentFigure.grabExcessVerticalSpace = true;
			nameRectangle1.add(fFigureConnectionProximityContainmentFigure,
					constraintFFigureConnectionProximityContainmentFigure);

			fFigureConnectionNameFigure = new WrappingLabel();

			fFigureConnectionNameFigure.setText("");

			fFigureConnectionNameFigure.setFont(FFIGURECONNECTIONNAMEFIGURE_FONT);

			GridData constraintFFigureConnectionNameFigure = new GridData();
			constraintFFigureConnectionNameFigure.verticalAlignment = GridData.CENTER;
			constraintFFigureConnectionNameFigure.horizontalAlignment = GridData.END;
			constraintFFigureConnectionNameFigure.horizontalIndent = 0;
			constraintFFigureConnectionNameFigure.horizontalSpan = 1;
			constraintFFigureConnectionNameFigure.verticalSpan = 4;
			constraintFFigureConnectionNameFigure.grabExcessHorizontalSpace = true;
			constraintFFigureConnectionNameFigure.grabExcessVerticalSpace = true;
			nameRectangle1.add(fFigureConnectionNameFigure, constraintFFigureConnectionNameFigure);

			fFigureConnectionPotencyFigure = new WrappingLabel();

			fFigureConnectionPotencyFigure.setText("");

			fFigureConnectionPotencyFigure.setFont(FFIGURECONNECTIONPOTENCYFIGURE_FONT);

			fFigureConnectionPotencyFigure.setBorder(new MarginBorder(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0),
					getMapMode().DPtoLP(10), getMapMode().DPtoLP(0)));

			GridData constraintFFigureConnectionPotencyFigure = new GridData();
			constraintFFigureConnectionPotencyFigure.verticalAlignment = GridData.CENTER;
			constraintFFigureConnectionPotencyFigure.horizontalAlignment = GridData.BEGINNING;
			constraintFFigureConnectionPotencyFigure.horizontalIndent = 0;
			constraintFFigureConnectionPotencyFigure.horizontalSpan = 1;
			constraintFFigureConnectionPotencyFigure.verticalSpan = 2;
			constraintFFigureConnectionPotencyFigure.grabExcessHorizontalSpace = false;
			constraintFFigureConnectionPotencyFigure.grabExcessVerticalSpace = true;
			nameRectangle1.add(fFigureConnectionPotencyFigure, constraintFFigureConnectionPotencyFigure);

			fFigureConnectionProximityClassificationFigure = new WrappingLabel();

			fFigureConnectionProximityClassificationFigure.setText("");

			fFigureConnectionProximityClassificationFigure.setFont(FFIGURECONNECTIONPROXIMITYCLASSIFICATIONFIGURE_FONT);

			GridData constraintFFigureConnectionProximityClassificationFigure = new GridData();
			constraintFFigureConnectionProximityClassificationFigure.verticalAlignment = GridData.CENTER;
			constraintFFigureConnectionProximityClassificationFigure.horizontalAlignment = GridData.BEGINNING;
			constraintFFigureConnectionProximityClassificationFigure.horizontalIndent = 0;
			constraintFFigureConnectionProximityClassificationFigure.horizontalSpan = 1;
			constraintFFigureConnectionProximityClassificationFigure.verticalSpan = 4;
			constraintFFigureConnectionProximityClassificationFigure.grabExcessHorizontalSpace = true;
			constraintFFigureConnectionProximityClassificationFigure.grabExcessVerticalSpace = true;
			nameRectangle1.add(fFigureConnectionProximityClassificationFigure,
					constraintFFigureConnectionProximityClassificationFigure);

			fFigureConnectionLevelFigure = new WrappingLabel();

			fFigureConnectionLevelFigure.setText("");

			fFigureConnectionLevelFigure.setFont(FFIGURECONNECTIONLEVELFIGURE_FONT);

			GridData constraintFFigureConnectionLevelFigure = new GridData();
			constraintFFigureConnectionLevelFigure.verticalAlignment = GridData.BEGINNING;
			constraintFFigureConnectionLevelFigure.horizontalAlignment = GridData.BEGINNING;
			constraintFFigureConnectionLevelFigure.horizontalIndent = 0;
			constraintFFigureConnectionLevelFigure.horizontalSpan = 1;
			constraintFFigureConnectionLevelFigure.verticalSpan = 2;
			constraintFFigureConnectionLevelFigure.grabExcessHorizontalSpace = false;
			constraintFFigureConnectionLevelFigure.grabExcessVerticalSpace = true;
			nameRectangle1.add(fFigureConnectionLevelFigure, constraintFFigureConnectionLevelFigure);

			fFigureConnectionAVSFigure = new WrappingLabel();

			fFigureConnectionAVSFigure.setText("");

			fFigureConnectionAVSFigure.setFont(FFIGURECONNECTIONAVSFIGURE_FONT);

			GridData constraintFFigureConnectionAVSFigure = new GridData();
			constraintFFigureConnectionAVSFigure.verticalAlignment = GridData.BEGINNING;
			constraintFFigureConnectionAVSFigure.horizontalAlignment = GridData.CENTER;
			constraintFFigureConnectionAVSFigure.horizontalIndent = 0;
			constraintFFigureConnectionAVSFigure.horizontalSpan = 5;
			constraintFFigureConnectionAVSFigure.verticalSpan = 1;
			constraintFFigureConnectionAVSFigure.grabExcessHorizontalSpace = false;
			constraintFFigureConnectionAVSFigure.grabExcessVerticalSpace = true;
			nameRectangle1.add(fFigureConnectionAVSFigure, constraintFFigureConnectionAVSFigure);

			fFigureAttributesCompartmentRectangle = new RectangleFigure();

			fFigureAttributesCompartmentRectangle.setFill(false);
			fFigureAttributesCompartmentRectangle.setOutline(false);

			fFigureAttributesCompartmentRectangle.setBorder(new MarginBorder(getMapMode().DPtoLP(0),
					getMapMode().DPtoLP(0), getMapMode().DPtoLP(0), getMapMode().DPtoLP(0)));

			GridData constraintFFigureAttributesCompartmentRectangle = new GridData();
			constraintFFigureAttributesCompartmentRectangle.verticalAlignment = GridData.BEGINNING;
			constraintFFigureAttributesCompartmentRectangle.horizontalAlignment = GridData.FILL;
			constraintFFigureAttributesCompartmentRectangle.horizontalIndent = 0;
			constraintFFigureAttributesCompartmentRectangle.horizontalSpan = 1;
			constraintFFigureAttributesCompartmentRectangle.verticalSpan = 1;
			constraintFFigureAttributesCompartmentRectangle.grabExcessHorizontalSpace = true;
			constraintFFigureAttributesCompartmentRectangle.grabExcessVerticalSpace = false;
			innerRectangle0.add(fFigureAttributesCompartmentRectangle, constraintFFigureAttributesCompartmentRectangle);

			ToolbarLayout layoutFFigureAttributesCompartmentRectangle = new ToolbarLayout();
			layoutFFigureAttributesCompartmentRectangle.setStretchMinorAxis(true);
			layoutFFigureAttributesCompartmentRectangle.setMinorAlignment(ToolbarLayout.ALIGN_TOPLEFT);

			layoutFFigureAttributesCompartmentRectangle.setSpacing(0);
			layoutFFigureAttributesCompartmentRectangle.setVertical(true);

			fFigureAttributesCompartmentRectangle.setLayoutManager(layoutFFigureAttributesCompartmentRectangle);

			fFigureMethodsCompartmentRectangle = new RectangleFigure();

			fFigureMethodsCompartmentRectangle.setFill(false);
			fFigureMethodsCompartmentRectangle.setOutline(false);

			fFigureMethodsCompartmentRectangle.setBorder(new MarginBorder(getMapMode().DPtoLP(0),
					getMapMode().DPtoLP(0), getMapMode().DPtoLP(0), getMapMode().DPtoLP(0)));

			GridData constraintFFigureMethodsCompartmentRectangle = new GridData();
			constraintFFigureMethodsCompartmentRectangle.verticalAlignment = GridData.BEGINNING;
			constraintFFigureMethodsCompartmentRectangle.horizontalAlignment = GridData.FILL;
			constraintFFigureMethodsCompartmentRectangle.horizontalIndent = 0;
			constraintFFigureMethodsCompartmentRectangle.horizontalSpan = 1;
			constraintFFigureMethodsCompartmentRectangle.verticalSpan = 1;
			constraintFFigureMethodsCompartmentRectangle.grabExcessHorizontalSpace = true;
			constraintFFigureMethodsCompartmentRectangle.grabExcessVerticalSpace = false;
			innerRectangle0.add(fFigureMethodsCompartmentRectangle, constraintFFigureMethodsCompartmentRectangle);

			ToolbarLayout layoutFFigureMethodsCompartmentRectangle = new ToolbarLayout();
			layoutFFigureMethodsCompartmentRectangle.setStretchMinorAxis(true);
			layoutFFigureMethodsCompartmentRectangle.setMinorAlignment(ToolbarLayout.ALIGN_TOPLEFT);

			layoutFFigureMethodsCompartmentRectangle.setSpacing(0);
			layoutFFigureMethodsCompartmentRectangle.setVertical(true);

			fFigureMethodsCompartmentRectangle.setLayoutManager(layoutFFigureMethodsCompartmentRectangle);

			fFigureContentCompartmentRectangle = new RectangleFigure();

			fFigureContentCompartmentRectangle.setFill(false);
			fFigureContentCompartmentRectangle.setOutline(false);

			fFigureContentCompartmentRectangle.setBorder(new MarginBorder(getMapMode().DPtoLP(0),
					getMapMode().DPtoLP(0), getMapMode().DPtoLP(0), getMapMode().DPtoLP(0)));

			GridData constraintFFigureContentCompartmentRectangle = new GridData();
			constraintFFigureContentCompartmentRectangle.verticalAlignment = GridData.BEGINNING;
			constraintFFigureContentCompartmentRectangle.horizontalAlignment = GridData.FILL;
			constraintFFigureContentCompartmentRectangle.horizontalIndent = 0;
			constraintFFigureContentCompartmentRectangle.horizontalSpan = 1;
			constraintFFigureContentCompartmentRectangle.verticalSpan = 1;
			constraintFFigureContentCompartmentRectangle.grabExcessHorizontalSpace = true;
			constraintFFigureContentCompartmentRectangle.grabExcessVerticalSpace = false;
			innerRectangle0.add(fFigureContentCompartmentRectangle, constraintFFigureContentCompartmentRectangle);

			ToolbarLayout layoutFFigureContentCompartmentRectangle = new ToolbarLayout();
			layoutFFigureContentCompartmentRectangle.setStretchMinorAxis(true);
			layoutFFigureContentCompartmentRectangle.setMinorAlignment(ToolbarLayout.ALIGN_TOPLEFT);

			layoutFFigureContentCompartmentRectangle.setSpacing(0);
			layoutFFigureContentCompartmentRectangle.setVertical(true);

			fFigureContentCompartmentRectangle.setLayoutManager(layoutFFigureContentCompartmentRectangle);

			fFigureVisualizerCompartmentRectangle = new RectangleFigure();

			fFigureVisualizerCompartmentRectangle.setFill(false);
			fFigureVisualizerCompartmentRectangle.setOutline(false);

			fFigureVisualizerCompartmentRectangle.setBorder(new MarginBorder(getMapMode().DPtoLP(0),
					getMapMode().DPtoLP(0), getMapMode().DPtoLP(0), getMapMode().DPtoLP(0)));

			GridData constraintFFigureVisualizerCompartmentRectangle = new GridData();
			constraintFFigureVisualizerCompartmentRectangle.verticalAlignment = GridData.BEGINNING;
			constraintFFigureVisualizerCompartmentRectangle.horizontalAlignment = GridData.FILL;
			constraintFFigureVisualizerCompartmentRectangle.horizontalIndent = 0;
			constraintFFigureVisualizerCompartmentRectangle.horizontalSpan = 1;
			constraintFFigureVisualizerCompartmentRectangle.verticalSpan = 1;
			constraintFFigureVisualizerCompartmentRectangle.grabExcessHorizontalSpace = true;
			constraintFFigureVisualizerCompartmentRectangle.grabExcessVerticalSpace = false;
			innerRectangle0.add(fFigureVisualizerCompartmentRectangle, constraintFFigureVisualizerCompartmentRectangle);

			ToolbarLayout layoutFFigureVisualizerCompartmentRectangle = new ToolbarLayout();
			layoutFFigureVisualizerCompartmentRectangle.setStretchMinorAxis(true);
			layoutFFigureVisualizerCompartmentRectangle.setMinorAlignment(ToolbarLayout.ALIGN_TOPLEFT);

			layoutFFigureVisualizerCompartmentRectangle.setSpacing(0);
			layoutFFigureVisualizerCompartmentRectangle.setVertical(true);

			fFigureVisualizerCompartmentRectangle.setLayoutManager(layoutFFigureVisualizerCompartmentRectangle);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureConnectionProximityInheritanceFigure() {
			return fFigureConnectionProximityInheritanceFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureConnectionProximityContainmentFigure() {
			return fFigureConnectionProximityContainmentFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureConnectionNameFigure() {
			return fFigureConnectionNameFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureConnectionProximityClassificationFigure() {
			return fFigureConnectionProximityClassificationFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureConnectionPotencyFigure() {
			return fFigureConnectionPotencyFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureConnectionLevelFigure() {
			return fFigureConnectionLevelFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureConnectionAVSFigure() {
			return fFigureConnectionAVSFigure;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureAttributesCompartmentRectangle() {
			return fFigureAttributesCompartmentRectangle;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureMethodsCompartmentRectangle() {
			return fFigureMethodsCompartmentRectangle;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureContentCompartmentRectangle() {
			return fFigureContentCompartmentRectangle;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureVisualizerCompartmentRectangle() {
			return fFigureVisualizerCompartmentRectangle;
		}

	}

	/**
	 * @generated
	 */
	static final Font FFIGURECONNECTIONPROXIMITYINHERITANCEFIGURE_FONT = new Font(Display.getCurrent(),
			Display.getDefault().getSystemFont().getFontData()[0].getName(), 9, SWT.NORMAL);

	/**
	 * @generated
	 */
	static final Font FFIGURECONNECTIONPROXIMITYCONTAINMENTFIGURE_FONT = new Font(Display.getCurrent(),
			Display.getDefault().getSystemFont().getFontData()[0].getName(), 9, SWT.NORMAL);

	/**
	 * @generated
	 */
	static final Font FFIGURECONNECTIONNAMEFIGURE_FONT = new Font(Display.getCurrent(),
			Display.getDefault().getSystemFont().getFontData()[0].getName(), 9, SWT.BOLD);

	/**
	 * @generated
	 */
	static final Font FFIGURECONNECTIONPOTENCYFIGURE_FONT = new Font(Display.getCurrent(),
			Display.getDefault().getSystemFont().getFontData()[0].getName(), 7, SWT.NORMAL);

	/**
	 * @generated
	 */
	static final Font FFIGURECONNECTIONPROXIMITYCLASSIFICATIONFIGURE_FONT = new Font(Display.getCurrent(),
			Display.getDefault().getSystemFont().getFontData()[0].getName(), 9, SWT.NORMAL);

	/**
	 * @generated
	 */
	static final Font FFIGURECONNECTIONLEVELFIGURE_FONT = new Font(Display.getCurrent(),
			Display.getDefault().getSystemFont().getFontData()[0].getName(), 7, SWT.NORMAL);

	/**
	 * @generated
	 */
	static final Font FFIGURECONNECTIONAVSFIGURE_FONT = new Font(Display.getCurrent(),
			Display.getDefault().getSystemFont().getFontData()[0].getName(), 8, SWT.NORMAL);

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

	/** 
	 * 
	 * @generated
	 */
	@Override
	public Command getCommand(Request _request) {

		//*******************************************
		// Hands requests for Creating Entities and 
		// connections over to the contentEditPart.
		//******************************************* 
		if (_request instanceof CreateUnspecifiedTypeRequest
				&& (((CreateUnspecifiedTypeRequest) _request).getElementTypes().contains(PLMElementTypes.Entity_3120)
						|| ((CreateUnspecifiedTypeRequest) _request).getElementTypes()
								.contains(PLMElementTypes.Connection_3099)))
			return getContentsCompartment().getCommand(_request);

		Command cmd = super.getCommand(_request);

		if (_request instanceof ChangeBoundsRequest &&
		//This shall prevent the execution of this code on element
		//creation as this is true on move by mouse.
		//This will break instantiation with content otherwise
				((ChangeBoundsRequest) _request).isSnapToEnabled()) {
			if (cmd == null)
				return cmd;

			Rectangle oldBounds = getFigure().getBounds();
			ChangeBoundsRequest changeRequest = (ChangeBoundsRequest) _request;
			Rectangle newBounds = changeRequest.getTransformedRectangle(oldBounds);

			InternalTransactionalEditingDomain domain = (InternalTransactionalEditingDomain) getEditingDomain();
			final LMLVisualizer visualizer = ((Element) resolveSemanticElement()).getVisualizer().get(0);
			final Node notationView = (Node) getNotationView();

			AbstractTransactionalCommand changeVisualizerBoundsCommand = new AbstractTransactionalCommand(domain,
					"Change Visulizer",
					Collections.singletonList(WorkspaceSynchronizer.getFile(visualizer.eResource()))) {

				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
						throws ExecutionException {
					Bounds b = (Bounds) notationView.getLayoutConstraint();

					//If in synch nothing has to be done
					if (visualizer.getXLocation() == b.getX() && visualizer.getYLocation() == b.getY()
							&& visualizer.getHeight() == b.getHeight() && visualizer.getWidth() == b.getWidth())
						return CommandResult.newOKCommandResult();

					visualizer.setXLocation(b.getX());
					visualizer.setYLocation(b.getY());
					visualizer.setHeight(b.getHeight());
					visualizer.setWidth(b.getWidth());
					return CommandResult.newOKCommandResult();
				}

			};

			((CompoundCommand) cmd).add(new ICommandProxy(changeVisualizerBoundsCommand));
		}

		return cmd;
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
						org.eclipse.emf.common.command.CompoundCommand compoundCommand = new org.eclipse.emf.common.command.CompoundCommand();
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

	private Adapter visualizerListener = new VisualizerAdapter();

	/**
	 * Used to listen for changes in an entire tree of elements 
	 */
	private class VisualizerAdapter extends EContentAdapter {
		@Override
		public void notifyChanged(Notification notification) {
			super.notifyChanged(notification);

			//Do nothing on remove of listener
			if (notification.getEventType() == Notification.REMOVING_ADAPTER)
				return;

			//This happens when toggeling between dsl and gpl mode and is already
			//handled via code in handle notification
			if (notification.getNotifier() instanceof LMLVisualizer || !(resolveSemanticElement() instanceof Clabject))
				return;

			updateView(IVisualizationServiceBase.FORMAT_GRAPH);

			Clabject c = (Clabject) resolveSemanticElement();
			List<Clabject> instances = c.getClassificationTreeAsType();
			for (Clabject i : instances) {
				EditPart ep = findEditPart(getRoot(), i);
				if (ep instanceof EntityEditPart)
					((EntityEditPart) ep).updateView(IVisualizationServiceBase.FORMAT_GRAPH);
				else if (ep instanceof Entity2EditPart)
					((Entity2EditPart) ep).updateView(IVisualizationServiceBase.FORMAT_GRAPH);
				else if (ep instanceof Entity3EditPart)
					((Entity3EditPart) ep).updateView(IVisualizationServiceBase.FORMAT_GRAPH);
				else if (ep instanceof org.melanee.core.modeleditor.edit.parts.ConnectionEditPart)
					((org.melanee.core.modeleditor.edit.parts.ConnectionEditPart) ep)
							.updateView(IVisualizationServiceBase.FORMAT_GRAPH);
				else if (ep instanceof Connection2EditPart)
					((Connection2EditPart) ep).updateView(IVisualizationServiceBase.FORMAT_GRAPH);
				else if (ep instanceof Connection3EditPart)
					((Connection3EditPart) ep).updateView(IVisualizationServiceBase.FORMAT_GRAPH);
			}
		}
	}

	@Override
	public void deactivate() {

		Element e = (Element) resolveSemanticElement();

		//if a model element gets deleted there is no
		//way to remove adapters anymore
		if (e != null)
			for (LMLVisualizer v : e.getVisualizer())
				v.eAdapters().remove(visualizerListener);

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

		//To listen the whole tree of an visualizer an Adapter is used instead of a diagram event broker
		for (LMLVisualizer v : e.getVisualizer()) {
			v.eAdapters().add(visualizerListener);
		}

		//Register to listen for feature changes
		for (Feature f : ((Clabject) e).getFeature())
			addListenerFilter(f.toString().substring(0, f.toString().indexOf(" ")), this, f);

	}

}

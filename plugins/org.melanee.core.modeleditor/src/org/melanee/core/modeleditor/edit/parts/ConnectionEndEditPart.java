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

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.editparts.AbstractEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.melanee.core.dsl.service.visualizationsearchalgorithm.AspectAwareVisualizationSearchAlgorithm;
import org.melanee.core.modeleditor.edit.policies.ConnectionEndItemSemanticEditPolicy;
import org.melanee.core.models.plm.PLM.AbstractDSLVisualizer;
import org.melanee.core.models.plm.PLM.ConnectionEnd;
import org.melanee.core.models.plm.PLM.ConnectionEndKind;
import org.melanee.core.models.plm.PLM.Element;
import org.melanee.core.workbench.ExtensionPointService;
import org.melanee.core.workbench.interfaces.IGraphicalVisualizationService;
import org.melanee.core.workbench.interfaces.IVisualizationServiceBase;

/**
 * @generated
 */
public class ConnectionEndEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 4036;

	/**
	* @generated
	*/
	public ConnectionEndEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ConnectionEndItemSemanticEditPolicy());
	}

	/**
	* @generated
	*/
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof WrappingLabel53EditPart) {
			((WrappingLabel53EditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureConnectionParticipationNameFigure());
			return true;
		}
		if (childEditPart instanceof WrappingLabel54EditPart) {
			((WrappingLabel54EditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureConnectionParticipationMultiplicityFigure());
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
		if (childEditPart instanceof WrappingLabel53EditPart) {
			return true;
		}
		if (childEditPart instanceof WrappingLabel54EditPart) {
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
		return new ConnectionParticipationFigure();
	}

	/**
	* @generated
	*/
	public ConnectionParticipationFigure getPrimaryShape() {
		return (ConnectionParticipationFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class ConnectionParticipationFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureConnectionParticipationNameFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureConnectionParticipationMultiplicityFigure;

		/**
		 * @generated
		 */
		public ConnectionParticipationFigure() {
			this.setForegroundColor(ColorConstants.black);

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureConnectionParticipationNameFigure = new WrappingLabel();

			fFigureConnectionParticipationNameFigure.setText("");
			fFigureConnectionParticipationNameFigure.setForegroundColor(ColorConstants.black);

			fFigureConnectionParticipationNameFigure.setFont(FFIGURECONNECTIONPARTICIPATIONNAMEFIGURE_FONT);

			this.add(fFigureConnectionParticipationNameFigure);

			fFigureConnectionParticipationMultiplicityFigure = new WrappingLabel();

			fFigureConnectionParticipationMultiplicityFigure.setText("");

			fFigureConnectionParticipationMultiplicityFigure
					.setFont(FFIGURECONNECTIONPARTICIPATIONMULTIPLICITYFIGURE_FONT);

			this.add(fFigureConnectionParticipationMultiplicityFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureConnectionParticipationNameFigure() {
			return fFigureConnectionParticipationNameFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureConnectionParticipationMultiplicityFigure() {
			return fFigureConnectionParticipationMultiplicityFigure;
		}

	}

	/**
	 * @generated
	 */
	static final Font FFIGURECONNECTIONPARTICIPATIONNAMEFIGURE_FONT = new Font(Display.getCurrent(),
			Display.getDefault().getSystemFont().getFontData()[0].getName(), 8, SWT.NORMAL);

	/**
	 * @generated
	 */
	static final Font FFIGURECONNECTIONPARTICIPATIONMULTIPLICITYFIGURE_FONT = new Font(Display.getCurrent(),
			Display.getDefault().getSystemFont().getFontData()[0].getName(), 8, SWT.NORMAL);

	//Sets the potency of instatiation ends

	/**
	 * @generated
	 */
	@Override
	public void addNotify() {
		super.addNotify();

		updateView(IVisualizationServiceBase.FORMAT_GRAPH);
	}

	/**
	 * @generated
	 */
	@Override
	protected void handleNotificationEvent(Notification notification) {
		super.handleNotificationEvent(notification);

		updateView(IVisualizationServiceBase.FORMAT_GRAPH);
	}

	/**
	 * @generated
	 */
	public void updateView(String format) {

		//This can happen on delete
		if (resolveSemanticElement() == null)
			return;

		org.melanee.core.modeleditor.edit.parts.ConnectionEndEditPart.ConnectionParticipationFigure connectionFigure = (org.melanee.core.modeleditor.edit.parts.ConnectionEndEditPart.ConnectionParticipationFigure) getFigure();
		connectionFigure.getChildren().retainAll(
				Arrays.asList(new Object[] { connectionFigure.getFigureConnectionParticipationMultiplicityFigure(),
						connectionFigure.getFigureConnectionParticipationNameFigure() }));

		for (AbstractEditPart part : (List<AbstractEditPart>) getChildren())
			part.refresh();

		java.lang.String notation = AspectAwareVisualizationSearchAlgorithm
				.searchNotationForElement((Element) this.resolveSemanticElement().eContainer(), format);

		if (notation != null && notation.length() > 0 && !notation.equals(IVisualizationServiceBase.NOTATION_LML)
		//TODO: Derived not implmented -> LML
				&& !notation.equals(IVisualizationServiceBase.NOTATION_DERIVED))
			updateDSLRenderingView(format, notation);
		else
			updateLMLRenderingView();

		//performRequest(new org.eclipse.gef.Request(org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants.REQ_REFRESH));
	}

	/**
	 * @generated
	 */
	private void updateLMLRenderingView() {
		ConnectionEnd self = (ConnectionEnd) resolveSemanticElement();

		//*****************************************************************
		//Is navigable
		//*****************************************************************
		if (self.getKind() == ConnectionEndKind.COMPOSITION || self.getKind() == ConnectionEndKind.AGGREGATION) {
			PolygonDecoration decoration = new PolygonDecoration();
			PointList decorationPointList = new PointList();
			decorationPointList.addPoint(0, 0);
			decorationPointList.addPoint(-1, 1);
			decorationPointList.addPoint(-2, 0);
			decorationPointList.addPoint(-1, -1);
			decoration.setTemplate(decorationPointList);
			decoration.setSize(10, 10);
			if (self.getKind() == ConnectionEndKind.AGGREGATION)
				decoration.setBackgroundColor(PlatformUI.getWorkbench().getDisplay().getSystemColor(SWT.COLOR_WHITE));
			((PolylineConnection) getFigure()).setTargetDecoration(decoration);
		}
		//*****************************************************************
		//Is navigable
		//*****************************************************************
		else if (self.isNavigable())
			((PolylineConnection) getFigure()).setTargetDecoration(new PolylineDecoration());
		else
			((PolylineConnection) getFigure()).setTargetDecoration(null);

		//Reset line style
		((PolylineConnection) getFigure()).setLineStyle(SWT.LINE_SOLID);
	}

	/**
	 * @generated
	 */
	private void updateDSLRenderingView(String format, String notation) {
		ConnectionEnd self = (ConnectionEnd) resolveSemanticElement();
		org.melanee.core.modeleditor.edit.parts.ConnectionEndEditPart.ConnectionParticipationFigure connectionFigure = (org.melanee.core.modeleditor.edit.parts.ConnectionEndEditPart.ConnectionParticipationFigure) getFigure();
		IGraphicalVisualizationService transformator = null;

		try {
			transformator = ExtensionPointService.Instance().getActiveGraphicalVisualizationService();
		} catch (CoreException e) {
			e.printStackTrace();
		}

		if (transformator != null) {
			AbstractDSLVisualizer v = getConnectionDSLVisualizer(transformator, notation);

			//No Visualizer was found for the requested => use LML rendering as fallback
			if (v == null) {
				updateLMLRenderingView();
				return;
			}

			transformator.run(v, self, connectionFigure);
		}
	}

	//	/**
	//	 * @generated
	//	 */
	//	public String getDSLRenderingValue(String format)
	//	{
	//		org.melanee.core.models.plm.PLM.ConnectionEnd self = (org.melanee.core.models.plm.PLM.ConnectionEnd) resolveSemanticElement();
	//		org.melanee.core.models.plm.PLM.Connection c = (org.melanee.core.models.plm.PLM.Connection)self.eContainer();
	//
	//		org.eclipse.emf.ecore.EObject container = c;
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
	private AbstractDSLVisualizer getConnectionDSLVisualizer(IGraphicalVisualizationService transformator,
			String notation) {
		org.melanee.core.models.plm.PLM.Connection containingConnection = (org.melanee.core.models.plm.PLM.Connection) resolveSemanticElement()
				.eContainer();

		return transformator.findDSLVisualizerForElement(containingConnection, notation, true);
	}

}

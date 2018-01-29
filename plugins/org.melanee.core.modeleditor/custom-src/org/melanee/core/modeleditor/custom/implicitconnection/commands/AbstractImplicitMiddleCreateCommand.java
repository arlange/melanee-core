/*******************************************************************************
 * Copyright (c) 2012 University of Mannheim: Chair for Software Engineering
 * and others All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev - initial API and implementation and initial documentation
 *    Ralph Gerbig    - extension
 *******************************************************************************/
package org.melanee.core.modeleditor.custom.implicitconnection.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.IdentityAnchor;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Size;
import org.eclipse.gmf.runtime.notation.View;
import org.melanee.core.modeleditor.custom.figures.DefaultSizeNodeFixedAnchors;
import org.melanee.core.modeleditor.custom.implicitconnection.policy.ImplicitConnectionCreateLinkCommand;

public abstract class AbstractImplicitMiddleCreateCommand extends
		EditElementCommand {

	private final EObject mySource;

	private final EObject myTarget;

	protected EObject middle;
	
	private ImplicitConnectionCreateLinkCommand myCommandsPack;

	public AbstractImplicitMiddleCreateCommand(
			CreateRelationshipRequest request, EObject source, EObject target) {
		super(request.getLabel(), null, request);
		mySource = source;
		myTarget = target;
	}

	protected abstract boolean checkSource(EObject source);

	protected abstract boolean checkTarget(EObject target);

	protected abstract IElementTypeAwareAdapter createSemanticMiddle(
			IProgressMonitor monitor, IAdaptable info)
			throws ExecutionException;

	protected abstract IElementTypeAwareAdapter createImplicitTargetLink(
			IProgressMonitor monitor, IAdaptable info)
			throws ExecutionException;

	protected abstract void setupSemanticConnections(EObject source,
			IElementTypeAwareAdapter middle, EObject target);

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		myCommandsPack = ImplicitConnectionCreateLinkCommand.getFromRequest(getRequest());

		try {
			IElementTypeAwareAdapter semanticMiddle = createSemanticMiddle(
					monitor, new EObjectAdapter(getSourceView().getElement().eContainer()));
			middle = (EObject)semanticMiddle.getAdapter(EObject.class);
			
			View container = (View) getSourceView().eContainer();
			Node middleNode = getViewService().createNode(
					semanticMiddle, container,
					semanticMiddle.getSemanticHint(), ViewUtil.APPEND,
					getPreferencesHint());

			IElementTypeAwareAdapter semanticImplicitLink = createImplicitTargetLink(
					monitor, info);

			setupMiddlePosition(middleNode);
			setupSemanticConnections(mySource, semanticMiddle, myTarget);

			//Set the new source and target adapters
			myCommandsPack.getSetConnectionEndsCommand().setNewSourceAdaptor(
					new EObjectAdapter(middleNode));
			myCommandsPack.getSetConnectionEndsCommand().setNewTargetAdaptor(
					new EObjectAdapter(getSourceView()));
			//Set the new anchor
			//Anchor needs to be set to prevent NullPointerException in combination
			//with DefaultSizeNodeFixedAnchors
			myCommandsPack.getSetConnectionAnchorsCommand().setNewSourceTerminal(calculateConnectionAnchor(middleNode, (Node)getSourceView()));
			
			Edge implicitTargetEdge = (Edge) getViewService().createEdge(
					semanticImplicitLink,
					container.getDiagram(),
					semanticImplicitLink.getSemanticHint(),
					ViewUtil.APPEND, getPreferencesHint());

			if (implicitTargetEdge != null) {
				implicitTargetEdge.setTarget(getTargetView());
				implicitTargetEdge.setSource(middleNode);
				IdentityAnchor a = NotationFactory.eINSTANCE.createIdentityAnchor();
				//Anchor needs to be set to prevent NullPointerException in combination
				//with DefaultSizeNodeFixedAnchors
				a.setId(calculateConnectionAnchor(middleNode, (Node)getTargetView()));
				implicitTargetEdge.setSourceAnchor(a);
				container.getDiagram().persistEdges();
			}			
		} finally {
			myCommandsPack = null;
		}

		return CommandResult.newOKCommandResult();
	}

	protected final ViewService getViewService() {
		return ViewService.getInstance();
	}

	protected PreferencesHint getPreferencesHint() {
		return myCommandsPack.getPreferencesHint();
	}

	protected View getSourceView() {
		return myCommandsPack.getSourceParameters().getParentView();
	}

	protected View getTargetView() {
		return myCommandsPack.getTargetParameters().getParentView();
	}

	@Override
	public boolean canExecute() {
		if (mySource == null && myTarget == null) {
			return false;
		}
		return checkSource(mySource) && checkTarget(myTarget);
	}

	protected void setupMiddlePosition(Node middleNode) {
		Point sourceCenter = getCenterPoint(getSourceView());
		Point targetCenter = getCenterPoint(getTargetView());

		if (sourceCenter != null && targetCenter != null) {
			Point center = new Point((sourceCenter.x + targetCenter.x) / 2,
					(sourceCenter.y + targetCenter.y) / 2);
			Dimension size = getImplicitNodeSize(middleNode);
			if (size != null) {
				center.translate(size.width / 2, -size.height / 2);
			}
			Bounds gmfBounds;
			if (middleNode.getLayoutConstraint() instanceof Bounds) {
				gmfBounds = (Bounds) middleNode.getLayoutConstraint();
			} else {
				gmfBounds = NotationFactory.eINSTANCE.createBounds();
				middleNode.setLayoutConstraint(gmfBounds);
			}
			gmfBounds.setX(center.x);
			gmfBounds.setY(center.y);
		}
	}

	protected Dimension getImplicitNodeSize(Node implicitNode) {
		if (implicitNode.getLayoutConstraint() instanceof Size) {
			Size size = (Size) implicitNode.getLayoutConstraint();
			if (size.eIsSet(NotationPackage.eINSTANCE.getSize_Width())
					&& size.eIsSet(NotationPackage.eINSTANCE.getSize_Height())) {
				return new Dimension(positiveOrZero(size.getWidth()),
						positiveOrZero(size.getHeight()));
			}
		}
		return getImplicitNodeDefaultSizeHint();
	}

	protected Dimension getImplicitNodeDefaultSizeHint() {
		return new Dimension(35, 35);
	}

	protected final void invokeDefaultElementTypeConfiguration(
			IElementTypeAwareAdapter semanticAdapter, IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		IElementType elementType = semanticAdapter.getElementType();
		EObject newElement = (EObject) semanticAdapter
				.getAdapter(EObject.class);
		if (newElement != null) {
			ConfigureRequest configureRequest = new ConfigureRequest(
					getEditingDomain(), newElement, elementType);
			configureRequest
					.setClientContext(((CreateElementRequest) getRequest())
							.getClientContext());
			configureRequest.addParameters(getRequest().getParameters());
			ICommand configureCommand = elementType
					.getEditCommand(configureRequest);
			if (configureCommand != null && configureCommand.canExecute()) {
				configureCommand.execute(monitor, info);
			}
		}
	}

	private static Point getCenterPoint(View view) {
		if (false == view instanceof Node) {
			return null;
		}
		Point result = null;
		Node node = (Node) view;
		LayoutConstraint constraint = node.getLayoutConstraint();
		if (constraint instanceof Location) {
			Location loc = (Location) constraint;
			result = new Point(loc.getX(), loc.getY());
		}
		if (constraint instanceof Size) {
			Size size = (Size) constraint;
			int width = size.getWidth();
			int height = size.getHeight();
			result.translate(positiveOrZero(width) / 2,
					positiveOrZero(height) / 2);
		}

		return result;
	}

	private static int positiveOrZero(int value) {
		return value < 0 ? 0 : value;
	}

	/**
	 * 
	 * Calculates the best fitting anchor
	 * 
	 * @param source
	 * @param destination
	 * @return
	 */
	private String calculateConnectionAnchor(Node source, Node target){
		
		int dy, dx = 0;
		
		Bounds sourceBounds = (Bounds)source.getLayoutConstraint();
		Bounds targetBounds = (Bounds)target.getLayoutConstraint();
		
		dy = sourceBounds.getY() - targetBounds.getY();
		dx = sourceBounds.getX() - targetBounds.getX();
		
		//We have more y that x delta -> NORTH or south
		if (Math.abs(dy) > Math.abs(dx))
			return dy < 0 ? DefaultSizeNodeFixedAnchors.ANCHOR_SOUTH : DefaultSizeNodeFixedAnchors.ANCHOR_NORTH;
		else
			return dx < 0 ? DefaultSizeNodeFixedAnchors.ANCHOR_EAST : DefaultSizeNodeFixedAnchors.ANCHOR_WEST;
		
	}
	
}

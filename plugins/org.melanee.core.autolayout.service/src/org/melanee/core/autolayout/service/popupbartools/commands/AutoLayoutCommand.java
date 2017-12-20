/*******************************************************************************
 * Copyright (c) 2012 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Ralph Gerbig - initial API and implementation and initial documentation
 *******************************************************************************/
package org.melanee.core.autolayout.service.popupbartools.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.commands.SetConnectionAnchorsCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.melanee.core.autolayout.service.BinaryLayouter;
import org.melanee.core.autolayout.service.NnaryLayouter;
import org.melanee.core.autolayout.service.TernaryLayouter;
import org.melanee.core.models.plm.PLM.Connection;
import org.melanee.core.models.plm.PLM.Correlation;

public class AutoLayoutCommand extends Command{
	
	private IGraphicalEditPart host = null;
	
	/**
	 * 
	 * @param host Element to introspect
	 */
	public AutoLayoutCommand(IGraphicalEditPart host){
		this.host = host;
	}
	
	@Override
	public void execute() {
		super.execute();
		
		ArrayList<Rectangle> connectedClientAreas = new ArrayList<Rectangle>();
		
		if (host.resolveSemanticElement() instanceof Connection
				|| host.resolveSemanticElement() instanceof Correlation)
			for (Object connectionEndEditPart : host.getSourceConnections()){
				connectedClientAreas.add(((IGraphicalEditPart)((ConnectionNodeEditPart)connectionEndEditPart).getTarget()).getFigure().getClientArea());
			}
		
		BinaryLayouter bLayouter = new BinaryLayouter();
		TernaryLayouter tLayouter = new TernaryLayouter();
		NnaryLayouter nLayouter = new NnaryLayouter();
		Point newConnectionCenter = null;
		
		if (bLayouter.matchesPattern(connectedClientAreas))
			newConnectionCenter = bLayouter.calculateNewMiddle();
		else if (tLayouter.matchesPattern(connectedClientAreas))
			newConnectionCenter = tLayouter.calculateNewMiddle();
		else if (nLayouter.matchesPattern(connectedClientAreas))
			newConnectionCenter = nLayouter.calculateNewMiddle();
		
		if (newConnectionCenter == null)
			return;
		
		Point newPosition = new Point();
		
		Rectangle connectionClientArea = host.getFigure().getClientArea();
		newPosition.setX(newConnectionCenter.x - (connectionClientArea.width / 2));
		newPosition.setY(newConnectionCenter.y - (connectionClientArea.height / 2));
		
		SetBoundsCommand sbc = new SetBoundsCommand(host.getEditingDomain(), "AutoLayout", new EObjectAdapter(host.getNotationView()), newPosition);
		host.getViewer().getEditDomain().getCommandStack().execute(new ICommandProxy(sbc));
		
		cleanAnchorLocations(host, newConnectionCenter);
	}
	
	/**
	 * 
	 * @param connection
	 * @param newConnectionCenter
	 */
	private static void cleanAnchorLocations(IGraphicalEditPart connection, Point newConnectionCenter){
		
		for (ConnectionNodeEditPart connectionEnd : (List<ConnectionNodeEditPart>)connection.getSourceConnections()){
			IGraphicalEditPart clabject = (IGraphicalEditPart)connectionEnd.getTarget();
			Rectangle clabjectRectangle = clabject.getFigure().getClientArea();
			
			
			/*
			 *      \   __   /
			 *       \ |__| /
			 *       _\    /_
			 *      |_|\  /|_|
			 *          XX
			 *          XX
			 *         /  \
			 *        /    \
			 *       /      \
			 *      /        \
			 *      
			 * Clabject is north of connection
			 */
			if (clabjectRectangle.getCenter().y < newConnectionCenter.y){
				int distanceY = newConnectionCenter.y - clabjectRectangle.getCenter().y;
				int leftXBorder = newConnectionCenter.x - distanceY;
				int rightXBorder = newConnectionCenter.x + distanceY;
				
				if (clabjectRectangle.getCenter().x > leftXBorder && clabjectRectangle.getCenter().x < rightXBorder){
					SetConnectionAnchorsCommand sca = new SetConnectionAnchorsCommand(connection.getEditingDomain(), "Rearrange Anchor");
					sca.setEdgeAdaptor(new EObjectAdapter(connectionEnd.getNotationView()));
					sca.setNewSourceTerminal("NORTH"); //DefaultSizeNodeFixedAnchors.ANCHOR_NORTH
					connectionEnd.getViewer().getEditDomain().getCommandStack().execute(new ICommandProxy(sca));
				}
				else if (clabjectRectangle.getCenter().x < leftXBorder){
					SetConnectionAnchorsCommand sca = new SetConnectionAnchorsCommand(connection.getEditingDomain(), "Rearrange Anchor");
					sca.setEdgeAdaptor(new EObjectAdapter(connectionEnd.getNotationView()));
					sca.setNewSourceTerminal("WEST"); //DefaultSizeNodeFixedAnchors.ANCHOR_WEST
					connectionEnd.getViewer().getEditDomain().getCommandStack().execute(new ICommandProxy(sca));
				}
				else if (clabjectRectangle.getCenter().x > rightXBorder){
					SetConnectionAnchorsCommand sca = new SetConnectionAnchorsCommand(connection.getEditingDomain(), "Rearrange Anchor");
					sca.setEdgeAdaptor(new EObjectAdapter(connectionEnd.getNotationView()));
					sca.setNewSourceTerminal("EAST"); //DefaultSizeNodeFixedAnchors.ANCHOR_EAST
					connectionEnd.getViewer().getEditDomain().getCommandStack().execute(new ICommandProxy(sca));
				}
			}
			
			/*
			 *      \        /
			 *       \      /
			 *        \    /
			 *         \  /
			 *       _  XX
			 *      |_| XX
			 *         /  \      _
			 *        / __ \    |_|
			 *       / |__| \
			 *      /        \
			 *      
			 * Clabject is south of connection
			 */
			if (clabjectRectangle.getCenter().y >= newConnectionCenter.y){
				int distanceY = clabjectRectangle.getCenter().y - newConnectionCenter.y;
				
				int leftXBorder = newConnectionCenter.x - distanceY;
				int rightXBorder = newConnectionCenter.x + distanceY;
				
				if (clabjectRectangle.getCenter().x > leftXBorder && clabjectRectangle.getCenter().x < rightXBorder){
					SetConnectionAnchorsCommand sca = new SetConnectionAnchorsCommand(connection.getEditingDomain(), "Rearrange Anchor");
					sca.setEdgeAdaptor(new EObjectAdapter(connectionEnd.getNotationView()));
					sca.setNewSourceTerminal("SOUTH"); //DefaultSizeNodeFixedAnchors.ANCHOR_SOUTH
					connectionEnd.getViewer().getEditDomain().getCommandStack().execute(new ICommandProxy(sca));
				}
				else if (clabjectRectangle.getCenter().x < leftXBorder){
					SetConnectionAnchorsCommand sca = new SetConnectionAnchorsCommand(connection.getEditingDomain(), "Rearrange Anchor");
					sca.setEdgeAdaptor(new EObjectAdapter(connectionEnd.getNotationView()));
					sca.setNewSourceTerminal("WEST"); //DefaultSizeNodeFixedAnchors.ANCHOR_WEST
					connectionEnd.getViewer().getEditDomain().getCommandStack().execute(new ICommandProxy(sca));
				}
				else if (clabjectRectangle.getCenter().x > rightXBorder){
					SetConnectionAnchorsCommand sca = new SetConnectionAnchorsCommand(connection.getEditingDomain(), "Rearrange Anchor");
					sca.setEdgeAdaptor(new EObjectAdapter(connectionEnd.getNotationView()));
					sca.setNewSourceTerminal("EAST"); //DefaultSizeNodeFixedAnchors.ANCHOR_EAST
					connectionEnd.getViewer().getEditDomain().getCommandStack().execute(new ICommandProxy(sca));
				}
			}
		}
	}
}
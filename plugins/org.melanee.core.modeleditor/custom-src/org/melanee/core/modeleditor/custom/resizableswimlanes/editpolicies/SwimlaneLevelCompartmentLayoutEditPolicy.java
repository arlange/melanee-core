/*******************************************************************************
 * Copyright (c) 2012 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Daniel Gritzner,  - initial API and implementation 
 *    									and initial documentation
 *******************************************************************************/
package org.melanee.core.modeleditor.custom.resizableswimlanes.editpolicies;

import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartListener;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Shape;
import org.melanee.core.modeleditor.custom.resizableswimlanes.layoutmanagers.SwimlaneDeepModelLayoutManager;

/**
 * EditPolicy which enforces a minimum height for each Level when resizing. Also responsible for
 * installing the proper layout edit policies into all Levels which are being created.
 * 
 * @author gritzner
 */
public class SwimlaneLevelCompartmentLayoutEditPolicy extends XYLayoutEditPolicy {
	/**
	 * Helper method which creates a Command to resize a Level
	 * 
	 * @param level the Level being resized
	 * @param bounds its new bounds
	 * @return the new Command
	 */
	private ICommandProxy createResizeLevelCommand(IGraphicalEditPart level, Rectangle bounds) {
		Shape iterateShape = (Shape)(level).getNotationView();
		Bounds iterateBounds = (Bounds)iterateShape.getLayoutConstraint();
			
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(iterateBounds);
		SetBoundsCommand sbc = new SetBoundsCommand(domain, "Change Bounds", new EObjectAdapter(iterateShape), bounds);
		
		return new ICommandProxy(sbc);
	}
	
	/**
	 * Returns a Command which resizes all children. Enforces a minimum height to prevent scrollbars.
	 * 
	 * @param request the resize request
	 * @return the Command
	 */
	@Override
	protected org.eclipse.gef.commands.Command getResizeChildrenCommand(ChangeBoundsRequest request) {
		org.eclipse.gef.commands.CompoundCommand compoundCommand = new CompoundCommand(); 
		IGraphicalEditPart changedEditPart = (IGraphicalEditPart)request.getEditParts().get(0);
		int hostWidth = getHostFigure().getBounds().width;
		int deltaHeight = request.getSizeDelta().height;
		
		int y = 0;
		for(Object child : getHost().getChildren()) {
			IGraphicalEditPart level = (IGraphicalEditPart)child;
			int figHeight = 0;

			// determine the current Level's height
			if(deltaHeight != 0 && level == changedEditPart) {
				figHeight = SwimlaneDeepModelLayoutManager.getLevelHeight(level, deltaHeight, true);
			} else {
				figHeight = SwimlaneDeepModelLayoutManager.getLevelHeight(level);
			}
			
			// set the Level's new bounds
			Rectangle newBounds = new Rectangle();
			newBounds.setX(0);
			newBounds.setY(y); // y is set in the previous iteration
			newBounds.setWidth(hostWidth);
			newBounds.setHeight(figHeight);

			// create command for current Level
			compoundCommand.add(createResizeLevelCommand(level, newBounds));
				
			y += figHeight;
		}

		return compoundCommand;		
	}
	
	/**
	 * installs the proper layout edit policies into all Levels in addition to the default implementation
	 */
	@Override
	public void setHost(EditPart host) {
		super.setHost(host);
		
		host.addEditPartListener(new EditPartListener.Stub() {
			@Override
			public void childAdded(EditPart child, int index) {
				IGraphicalEditPart editPart = (IGraphicalEditPart)child;
				editPart.getFigure().setLayoutManager(new XYLayout());
				editPart.removeEditPolicy(EditPolicy.LAYOUT_ROLE);
				editPart.installEditPolicy(EditPolicy.LAYOUT_ROLE, new SwimlaneLevelLayoutEditPolicy());

				editPart = SwimlaneDeepModelLayoutManager.getLevelDomainElementsCompartment(editPart);
				editPart.getFigure().setLayoutManager(new StackLayout());
				editPart.removeEditPolicy(EditPolicy.LAYOUT_ROLE);
				editPart.installEditPolicy(EditPolicy.LAYOUT_ROLE, new SwimlaneLevelDomainElementsCompartmentLayoutEditPolicy());
			}
		});
	}
}

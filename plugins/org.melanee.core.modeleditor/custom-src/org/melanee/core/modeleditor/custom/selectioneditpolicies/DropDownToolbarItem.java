/*******************************************************************************
 * Copyright (c) 2013 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Ralph Gerbig - initial API and implementation and initial documentation
 *******************************************************************************/
package org.melanee.core.modeleditor.custom.selectioneditpolicies;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.editparts.LayerManager;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.progress.UIJob;

/**
 * 
 * An item (Button) in the toolbar.
 * 
 * Code is copied from org.eclipse.gmf.runtime.diagram.ui.editpolicies.PopupBarEditPolicy
 * and modified.
 *
 */
public class DropDownToolbarItem extends ToolbarItem{


	private MenuMotionListener menuMotionListener = new MenuMotionListener();
	private BaseToolbarSelectionEditPolicy hostPolicy = null;
	private RectangleFigure menu = null;
	private IFigure handleLayer = null;
	private UIJob closeMenuJob = new CloseMenuJob();
	
	private List<ToolBarItemDescriptor> childToolBarItems = null;
	
	public DropDownToolbarItem(DragTracker tracker, Image theImage, BaseToolbarSelectionEditPolicy hostPolicy, List<ToolBarItemDescriptor> childToolBarItems) {
		super(tracker, theImage, hostPolicy);
		
		this.hostPolicy = hostPolicy;
		this.handleLayer = getLayer(LayerConstants.HANDLE_LAYER);
		this.childToolBarItems = childToolBarItems;
	}
	
	@Override
	public void handleMouseEntered(MouseEvent event) {
		super.handleMouseEntered(event);
		
		if (menu != null)
			handleLayer.remove(menu);
		
		menu = new RectangleFigure();
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		menu.setLayoutManager(gridLayout);
		menu.addMouseMotionListener(menuMotionListener);
		
		for (ToolBarItemDescriptor desc : childToolBarItems){
			DropDownItemToolbarItem l = new DropDownItemToolbarItem(desc.getDragTracker(), desc.getIcon(), desc.getToolTip(), hostPolicy, this);
			menu.add(l);
		}

		menu.setBounds(new Rectangle(new Point(0, 0), menu.getPreferredSize()));
		
		Point menuLocation = getBounds().getCenter();
		menuLocation.y = menuLocation.y + 15;
		menuLocation.x = menuLocation.x - 10;
		menu.setLocation(menuLocation);
		
		
		handleLayer.add(menu);
	}
	
	public void hideMenu(){
		closeMenuJob.cancel();
		closeMenuJob.schedule(90);
	}
	
	@Override
	public void handleMouseExited(MouseEvent event) {
		super.handleMouseExited(event);
		hideMenu();
	}
	
	/**
	 * Obtains the specified layer.
	 * 
	 * @param layer
	 *            the key identifying the layer
	 * @return the requested layer
	 */
	protected IFigure getLayer(Object layer) {
		return LayerManager.Helper.find(hostPolicy.getHost()).getLayer(layer);
	}
	
	private class CloseMenuJob extends UIJob{

		public CloseMenuJob() {
			super("Hide Menu");
			setSystem(false);
		}
		
		@Override
		public IStatus runInUIThread(IProgressMonitor monitor) {
			if(!menuMotionListener.hovered
					&& menu != null){
				
				boolean menuItemHovered = false;
				//Iterate over all menu items and check if they are hovered.
				for(Object menuEntry : menu.getChildren())
					if(menuEntry instanceof DropDownItemToolbarItem
							&& ((DropDownItemToolbarItem)menuEntry).getHovered()){
						menuItemHovered = true;
						break;
					}
						
				if(!menuItemHovered){
					IFigure layer = getLayer(LayerConstants.HANDLE_LAYER);
					layer.remove(menu);
					menu = null;
				}
			}
			
			return Status.OK_STATUS;
		}
		
	}
	
	
	private class MenuMotionListener extends MouseMotionListener.Stub{
		private boolean hovered = false;
		
		@Override
		public void mouseEntered(MouseEvent me) {
			hovered = true;
		}
		
		@Override
		public void mouseExited(MouseEvent me) {
			hovered = false;
			closeMenuJob.schedule();
		}
	}
}
package org.melanee.core.modeleditor.custom.selectioneditpolicies;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Handle;
import org.eclipse.swt.graphics.Image;

public class DropDownItemToolbarItem extends Label implements Handle {

	static private int POPUPBAR_MOVE_FIGURE			 		= 0x02; /* Ignore the first figureMoved event when creating elements inside a shape via a popup bar*/
	
	/** The dragTracker CreationTool associated with the handle * */
	private DragTracker myDragTracker = null;
	private EditPolicy hostPolicy = null;
	private DropDownToolbarItem hostMenu;
	
	private boolean hovered = false;
	
	public boolean getHovered(){
		return hovered;
	}
	
	/**
	 * cnostructor
	 * 
	 * @param tracker A PopupBarTool instance
	 * @param theImage
	 */
	public DropDownItemToolbarItem(DragTracker tracker, Image theImage, String theTip, BaseToolbarSelectionEditPolicy hostPolicy, DropDownToolbarItem hostMenu) {
		super(theTip, theImage);
		myDragTracker = tracker;
		this.setOpaque(true);
		this.setBackgroundColor(ColorConstants.buttonLightest);
		this.hostPolicy = hostPolicy;
		this.hostMenu = hostMenu;
		
		addMouseMotionListener(new MouseMotionListener.Stub(){
			@Override
			public void mouseEntered(MouseEvent me) {
				super.mouseEntered(me);
				hovered = true;
				setBackgroundColor(ColorConstants.menuBackgroundSelected);
		}
			
			@Override
			public void mouseExited(MouseEvent me) {
				super.mouseExited(me);
				hovered = false;
				setBackgroundColor(ColorConstants.buttonLightest);
			}
		});
	}

	@Override
	public DragTracker getDragTracker() {
		hostMenu.hideMenu();
		return myDragTracker;
	}

	@Override
	public Point getAccessibleLocation() {
		return null;
	}
}

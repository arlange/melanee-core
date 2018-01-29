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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.FigureListener;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartListener;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.Tool;
import org.eclipse.gef.editpolicies.SelectionEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.tools.SelectionTool;
import org.eclipse.gmf.runtime.common.ui.services.icon.IconService;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.PopupBarEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.internal.editparts.ISurfaceEditPart;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants;
import org.eclipse.gmf.runtime.diagram.ui.tools.PopupBarTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantService;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.progress.UIJob;
import org.melanee.core.modeleditor.custom.popupbartools.SeparatorPopupBarTool;

/**
 * 
 * This is the selection edit policy which is installed on all 
 * edit parts. It is to replace the pop up bar with a tool bar
 * that appears on selection instead of hovering.
 * 
 * Code is copied from org.eclipse.gmf.runtime.diagram.ui.editpolicies.PopupBarEditPolicy
 * and modified.
 *
 */
public class BaseToolbarSelectionEditPolicy extends SelectionEditPolicy implements MouseMotionListener {

	/** This flag is for the future. It is for example a problem to hover over something with a pen */
	private static boolean IS_TOUCH_OPTIMIZED = true;
	
	/** Images created that must be deleted when popup bar is removed */
	protected List<Image> imagesToBeDisposed = new ArrayList<Image>();

	/** Flag to indicate that the diagram assistant should not be hidden. */
	private boolean avoidHidingDiagramAssistant = true;
	
	/**
	 * The amount of time to wait before hiding the diagram assistant after it
	 * has been made visible.
	 */
	private static final int DISAPPEARANCE_DELAY = 2000;
	
	/**
	 * The amount of time to wait before showing the diagram assistant.
	 */
	private static final int APPEARANCE_DELAY = 200;
	
	private HideDiagramAssistantJob hideDiagramAssistantJob = new HideDiagramAssistantJob();
	private ShowDiagramAssistantJob showDiagramAssistantJob = new ShowDiagramAssistantJob();
	
	/**
	 * The amount of time to wait before hiding the diagram assistant after the
	 * user has moved the mouse outside of the editpart.
	 */
	private static final int DISAPPEARANCE_DELAY_UPON_EXIT = 1000;
	
	/** Listens to focus change events on the host editpart. */
	private FocusListener focusListener = new FocusListener();
	
	/**
	 * The current mouse location within the host used to determine where the
	 * diagram assistant should be displayed. This will be null if the mouse is
	 * outside the host and diagram assistant figure.
	 */
	private Point mouseLocation;
	
	/**
	 * Sets the current mouse location. If set to null, this implies that the
	 * mouse is outside the host and diagram assistant figure.
	 * 
	 * @param mouseLocation
	 *            the current mouse location
	 */
	protected void setMouseLocation(Point mouseLocation) {
		this.mouseLocation = mouseLocation;
	}
	
	public List<Image> getImagesToBeDisposed(){
		return imagesToBeDisposed;
	}
	
	@Override
	protected void hideSelection() {
		
		//From PopupBarEditPolicy.deactivate()
		getHostFigure().removeMouseListener(this.myMouseKeyListener);
		getHostFigure().removeFigureListener(this.myOwnerMovedListener);
		
		//From PopupBarEditPolicy.deactivate().super()
		//((IGraphicalEditPart) getHost()).getFigure().removi neMouseMotionListener(this);
		((IGraphicalEditPart) getHost()).removeEditPartListener(focusListener);

		hideDiagramAssistant();
	}

	@Override
	protected void showSelection() {
		
		if (!shouldShowDiagramAssistant())
			return;
		
		//From PopupBarEditPolicy.activate().super()
		//((IGraphicalEditPart) getHost()).getFigure().addMouseMotionListener(this);
		((IGraphicalEditPart) getHost()).addEditPartListener(focusListener);
		
		//From PopupBarEditPolicy.activate().super()
		getHostFigure().addMouseListener(this.myMouseKeyListener);
		getHostFigure().addFigureListener(this.myOwnerMovedListener);

		if (getHost() instanceof ISurfaceEditPart) {
			setIsDisplayAtMouseHoverLocation(true);
		}
		
		Point p = new Point(getHostFigure().getBounds().getTopRight().x + 5, getHostFigure().getBounds().getTopRight().y);
		getHostFigure().translateToAbsolute(p);
		
		showDiagramAssistant(p);
		
	}	
	
	/*******************************************************************
	 * Copied Source code
	 *******************************************************************/
	/** Y postion offset from shape where the balloon top begin. */
	static private int BALLOON_Y_OFFSET = 10;

	/** Y postion offset from shape where the balloon top begin. */
	static private double BALLOON_X_OFFSET_RHS = 0.65;

	static private double BALLOON_X_OFFSET_LHS = 0.25;

	/** Width and height of actions */
	static private int ACTION_WIDTH_HGT = 30;
	
	/** With of an separator*/
	static private int SEPARATOR_WIDTH = 2;

	static private int ACTION_BUTTON_START_X = 5;

	static private int ACTION_BUTTON_START_Y = 5;

	static private int ACTION_MARGIN_RIGHT = 10;

	/** popup bar bits */
	static private int POPUPBAR_ACTIVATEONHOVER				= 0x01; /* Display the action when hovering*/
	static private int POPUPBAR_MOVE_FIGURE			 		= 0x02; /* Ignore the first figureMoved event when creating elements inside a shape via a popup bar*/ 
	static private int POPUPBAR_DISPLAYATMOUSEHOVERLOCATION	= 0x04; /* Display the popup bar at the mouse location used by diagrams and machine edit parts*/
	static private int POPUPBAR_ONDIAGRAMACTIVATED				= 0x10; /* For popup bars on diagram and machine edit parts, where we POPUPBAR_DISPLAYATMOUSEHOVERLOCATION, don't display popup bar until user clicks on surface*/
	static private int POPUPBAR_HOST_IS_CONNECTION				= 0x20; /* For popup bars on connection edit parts*/

	/** Bit field for the actrionbar associated bits */
	private int myPopupBarFlags = POPUPBAR_ACTIVATEONHOVER;

	private double myBallonOffsetPercent = BALLOON_X_OFFSET_RHS;

	/** the figure used to surround the action buttons */
	private IFigure myBalloon = null;

	/** The popup bar descriptors for the popup bar buttons */
	private List myPopupBarDescriptors = new ArrayList();


	/** mouse keys listener for the owner shape */
	private PopupBarMouseListener myMouseKeyListener = new PopupBarMouseListener();

	/** listener for owner shape movement */
	private OwnerMovedListener myOwnerMovedListener = new OwnerMovedListener();

	/** flag for whether mouse cursor within shape */

	private void setFlag(int bit, boolean b)
	{
		if (b)
			myPopupBarFlags |= bit;
		else if (getFlag(bit))
			myPopupBarFlags ^= bit;

	}

	private boolean getFlag(int bit)
	{
		return ((myPopupBarFlags & bit) > 0);
	}


	
	private void setPopupBarOnDiagramActivated(boolean bVal)
	{
		setFlag(POPUPBAR_ONDIAGRAMACTIVATED, bVal);
	}
	private boolean getPopupBarOnDiagramActivated()
	{
		return getFlag(POPUPBAR_ONDIAGRAMACTIVATED);
	}

	/**
	 * set the host is connection flag
	 * @param bVal the new value
	 */
	protected void setHostConnection(boolean bVal)
	{
		setFlag(POPUPBAR_HOST_IS_CONNECTION, bVal);
	}

	/**
	 * get the host is connection flag
	 * @return true or false
	 */
	protected boolean isHostConnection()
	{
		return getFlag(POPUPBAR_HOST_IS_CONNECTION);
	}

	/**
	 * Populates the popup bar with popup bar descriptors added by suclassing
	 * this editpolicy (i.e. <code>fillPopupBarDescriptors</code> and by
	 * querying the modeling assistant service for all types supported on the
	 * popup bar of this host. For those types added by the modeling assistant
	 * service the icons are retrieved using the Icon Service.
	 */
	protected void populatePopupBars() {
		fillPopupBarDescriptors();
		List types = ModelingAssistantService.getInstance()
			.getTypesForPopupBar(getHost());
		for (Iterator iter = types.iterator(); iter.hasNext();) {
			Object type = iter.next();
			if (type instanceof IElementType) {
				addPopupBarDescriptor((IElementType) type, IconService
					.getInstance().getIcon((IElementType) type));
			}
		}
	}

	/**
	 * This is the entry point that subclasses can override to fill the
	 * popup bar descrioptors if they have customized tools that cannot be done
	 * using the type along with the modeling assistant service.
	 */
	protected void fillPopupBarDescriptors() {
		// subclasses can override.
	}

	private boolean isSelectionToolActive()
	{
		// getViewer calls getParent so check for null
		if(getHost().getParent() != null && getHost().isActive() )
		{
			Tool theTool = getHost().getViewer().getEditDomain().getActiveTool();
			if((theTool != null) && theTool instanceof SelectionTool)
			{
				return true;
			}
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramAssistantEditPolicy#shouldShowDiagramAssistant()
	 */
	protected boolean shouldShowDiagramAssistant()
	{
//		if (!super.shouldShowDiagramAssistant()) {
//			return false;
//		}
	
		if (getHost().getViewer().getSelectedEditParts().size() != 1)
			return false;
		
		if(this.getIsDisplayAtMouseHoverLocation())
		{
			if (isHostConnection())
				return isSelectionToolActive();
			if (getPopupBarOnDiagramActivated())
				return isSelectionToolActive();
			return false;
		}
		else
			return isSelectionToolActive();

	}

	/**
	 * allows plugins to add their own popup bar tools and tips
	 * @param elementType
	 * @param theImage
	 * @param theTracker
	 * @param theTip
	 */
	protected void addPopupBarDescriptor(
			IElementType elementType,
			Image theImage,
			DragTracker theTracker,
			String theTip) {

		ToolBarItemDescriptor desc =
			new ToolBarItemDescriptor(theTip, theImage, elementType, theTracker);
		myPopupBarDescriptors.add(desc);

	}

	/**
	 * allows plugins to their own menus
	 * 
	 * @param theImage
	 * @param theTip
	 * @param children
	 */
	protected void addPopupBarMenuDescriptor(Image theImage, DragTracker theTracker, String theTip, List<ToolBarItemDescriptor> children){
		myPopupBarDescriptors.add(new ToolBarMenuDescriptor(theTip, theImage, null, theTracker, children));
	}
	
	
	/**
	 * adds popup bar descriptor
	 * @param elementType
	 * @param theImage
	 * @param theTracker
	 */
	protected void addPopupBarDescriptor(
		IElementType elementType,
		Image theImage,
		DragTracker theTracker) {

		String theInputStr = DiagramUIMessages.PopupBar_AddNew;


		String theTip = NLS.bind(theInputStr, elementType.getDisplayName());
	
		addPopupBarDescriptor(elementType, theImage, theTracker, theTip);
	}

	/**
	 * default method for plugins which passes along the PopupBarTool
	 * as the tool to be used.
	 * @param elementType
	 * @param theImage
	 */
	protected void addPopupBarDescriptor(IElementType elementType,
			Image theImage) {

		this.addPopupBarDescriptor(elementType, theImage,
			new PopupBarTool(getHost(), elementType));

	}

	/**
	 * @param elementType
	 * @param theImage
	 * @param theTip
	 */
	protected void addPopupBarDescriptor(
			IElementType elementType,
			Image theImage,
			String theTip) {

		PopupBarTool theTracker =
			new PopupBarTool(getHost(), elementType);
		ToolBarItemDescriptor desc =
			new ToolBarItemDescriptor(theTip, theImage, elementType, theTracker);
		myPopupBarDescriptors.add(desc);

	}

	/**
	 * method used primarily to add UnspecifiedTypeCreationTool
	 * @param elementType
	 * @param theImage
	 * @param theRequest the create request to be used
	 */
	protected void addPopupBarDescriptor(
			IElementType elementType,
			Image theImage,
			CreateRequest theRequest)
	{

		PopupBarTool theTracker =
			new PopupBarTool(getHost(), theRequest);

		this.addPopupBarDescriptor(elementType, theImage, theTracker);

	}

	/**
	 * gets the popup bar descriptors
	 * @return list
	 */
	protected List getPopupBarDescriptors() {
		return myPopupBarDescriptors;
	}

	/**
	 * initialize the popup bars from the list of action descriptors.
	 */
	private void initPopupBars() {

		List theList = getPopupBarDescriptors();
		if (theList.isEmpty()) {
			return;
		}
		myBalloon = createPopupBarFigure();

		//****************************************
		//Calculate the width of the balloon
		//****************************************
		int iTotal = ACTION_MARGIN_RIGHT;
		for (Object desc : theList){
			iTotal += ((ToolBarItemDescriptor)desc).getToolTip().equals(SeparatorPopupBarTool.TOOL_TIP) ? SEPARATOR_WIDTH : ACTION_WIDTH_HGT;
		}
			
			
		getBalloon().setSize(
			iTotal,
			ACTION_WIDTH_HGT + 2 * ACTION_BUTTON_START_Y);

		int xLoc = ACTION_BUTTON_START_X;
		int yLoc = ACTION_BUTTON_START_Y;

		for (Iterator iter = theList.iterator(); iter.hasNext();) {
			ToolBarItemDescriptor theDesc = (ToolBarItemDescriptor) iter.next();
			
			// Button b = new Button(theDesc.myButtonIcon);
			ToolbarItem b;
			
			if(theDesc instanceof ToolBarMenuDescriptor)
				b = new DropDownToolbarItem(
						theDesc.getDragTracker(), 
						theDesc.getIcon(),
						this,
						((ToolBarMenuDescriptor) theDesc).getChildren());
			else
				b =
					new ToolbarItem(
						theDesc.getDragTracker(),
						theDesc.getIcon(),
						this);

			Rectangle r1 = new Rectangle();
			r1.setLocation(xLoc, yLoc);
			//A Seperator shall be smaller than other buttons
			if(!theDesc.getToolTip().equals(SeparatorPopupBarTool.TOOL_TIP)){
				xLoc += ACTION_WIDTH_HGT;
				r1.setSize(
					ACTION_WIDTH_HGT,
					ACTION_WIDTH_HGT - ACTION_MARGIN_RIGHT);
			}
			else{
				xLoc += SEPARATOR_WIDTH;
				r1.setSize(
						SEPARATOR_WIDTH,
						ACTION_WIDTH_HGT - ACTION_MARGIN_RIGHT);
			}
			
			Label l = new Label();
			l.setText(theDesc.getToolTip());

			b.setToolTip(l);
			b.setPreferredSize(ACTION_WIDTH_HGT, ACTION_WIDTH_HGT);
			b.setBounds(r1);

			getBalloon().add(b);

			b.addMouseMotionListener(this);
			b.addMouseListener(this.myMouseKeyListener);
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramAssistantEditPolicy#getPreferenceName()
	 */
	String getPreferenceName() {
		return IPreferenceConstants.PREF_SHOW_POPUP_BARS;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramAssistantEditPolicy#isDiagramAssistantShowing()
	 */
	protected boolean isDiagramAssistantShowing() {
		return getBalloon() != null;
	}

	private IFigure getBalloon() {
		return myBalloon;
	}

	protected IFigure createPopupBarFigure() {
		return new Toolbar(this);
	}

	protected void showDiagramAssistant(Point referencePoint) {

		// already have a one
		if (getBalloon() != null && getBalloon().getParent() != null) 
		{
			return;
		}

		if (this.myPopupBarDescriptors.isEmpty()) 
		{

			populatePopupBars();
			initPopupBars();

			if (myPopupBarDescriptors.isEmpty()) {
				return; // nothing to show
			}
		}
		getBalloon().addMouseMotionListener(this);
		getBalloon().addMouseListener(myMouseKeyListener);

		// the feedback layer figures do not recieve mouse events so do not use
		// it for popup bars
		IFigure layer = getLayer(LayerConstants.HANDLE_LAYER);
		layer.add(getBalloon());
		
		if (referencePoint == null) {
			referencePoint = getHostFigure().getBounds().getCenter();
		}

		Point thePoint = getBalloonPosition(referencePoint);

		getBalloon().setLocation(thePoint);

		// dismiss the popup bar after a delay
		if(!shouldAvoidHidingDiagramAssistant())
		{
			hideDiagramAssistantAfterDelay(getDisappearanceDelay());
		}
	}

	/**
	 * getter for the IsDisplayAtMouseHoverLocation flag
	 * @return true or false
	 */
	protected boolean getIsDisplayAtMouseHoverLocation()
	{
		return getFlag(POPUPBAR_DISPLAYATMOUSEHOVERLOCATION);
	}

	/**
	 * setter for the IsDisplayAtMouseHoverLocation
	 * @param bVal
	 */
	protected void setIsDisplayAtMouseHoverLocation(boolean bVal)
	{
		setFlag(POPUPBAR_DISPLAYATMOUSEHOVERLOCATION, bVal);
	}

	/**
	 * For editparts that consume the entire viewport, statechart, structure,
	 * communication, we want to display the popup bar at the mouse location.
	 * @param referencePoint
	 *            The reference point which may be used to determine where the
	 *            diagram assistant should be located. This is most likely the
	 *            current mouse location. 
	 *            @return Point
	 */
	private Point getBalloonPosition(Point referencePoint)
	{
		Point thePoint = new Point();
		boolean atMouse = getIsDisplayAtMouseHoverLocation();
		if (atMouse) {
			thePoint.setLocation(referencePoint);
			getHostFigure().translateToAbsolute(thePoint);
			getBalloon().translateToRelative(thePoint);

			// shift the ballon so it is above the cursor.
			thePoint.y -= ACTION_WIDTH_HGT;
			adjustToFitInViewport(thePoint);
		}
		else
		{
			Dimension theoffset = new Dimension();
			Rectangle rcBounds = getHostFigure().getBounds().getCopy();

			getHostFigure().translateToAbsolute(rcBounds);
			getBalloon().translateToRelative(rcBounds);

			theoffset.height = -(BALLOON_Y_OFFSET + ACTION_WIDTH_HGT);
			theoffset.width = (int) (rcBounds.width * myBallonOffsetPercent);

			thePoint.x = rcBounds.x + theoffset.width;
			thePoint.y = rcBounds.y + theoffset.height;
			adjustToFitInViewport(thePoint);
		}
		return thePoint;
	}

	/**
     * Uses the balloon location passed in and its size to determine if the
     * balloon will appear outside the viewport. If so, the balloon location
     * will be modified accordingly.
     * 
     * @param balloonLocation
     *            the suggested balloon location passed in and potentially
     *            modified when this method completes
     */
    private void adjustToFitInViewport(Point balloonLocation) {
        Control control = getHost().getViewer().getControl();
        if (control instanceof FigureCanvas) {
            Rectangle viewportRect = ((FigureCanvas) control).getViewport()
                .getClientArea();
            Rectangle balloonRect = new Rectangle(balloonLocation, getBalloon()
                .getSize());

            int yDiff = viewportRect.y - balloonRect.y;
            if (yDiff > 0) {
                // balloon is above the viewport, shift down
                balloonLocation.translate(0, yDiff);
            }
            int xDiff = balloonRect.right() - viewportRect.right();
            if (xDiff > 0) {
                // balloon is to the right of the viewport, shift left
                balloonLocation.translate(-xDiff, 0);
            }
        }
    }

	private void teardownPopupBar() {
		getBalloon().removeMouseMotionListener(this);
		getBalloon().removeMouseListener(myMouseKeyListener);
		// the feedback layer figures do not recieve mouse events
		IFigure layer = getLayer(LayerConstants.HANDLE_LAYER);
		if (myBalloon.getParent() != null) {
			layer.remove(myBalloon);
		}
		myBalloon = null;

		this.myPopupBarDescriptors.clear();

		if (imagesToBeDisposed != null) {
			for (Iterator iter = imagesToBeDisposed.iterator(); iter.hasNext();) {
				((Image) iter.next()).dispose();
			}
			imagesToBeDisposed.clear();
		}

	}

	protected void hideDiagramAssistant() {
		if (getBalloon() != null) {
			teardownPopupBar();
		}
	}

    protected String getDiagramAssistantID() {
        return PopupBarEditPolicy.class.getName();
    }
    
    /**
	 * Listens to the owner figure being moved so the handles can be removed
	 * when this occurs.
	 * 
	 * @author affrantz@us.ibm.com
	 * 
	 */
	private class OwnerMovedListener implements FigureListener {

		private Point myPopupBarLastPosition = new Point(0, 0);

		boolean hasPositionChanged(Rectangle theBounds) {
			if (theBounds.x != myPopupBarLastPosition.x)
				return true;
			if (theBounds.y != myPopupBarLastPosition.y)
				return true;
			return false;
		}

		/**
		 * @see org.eclipse.draw2d.FigureListener#figureMoved(org.eclipse.draw2d.IFigure)
		 */
		public void figureMoved(IFigure source) {
			// for some reason we get more than one
			// figure moved call after compartment items are added
			// myActionMoveFigure handles the first one which we expect
			// hasPositionChanged handles the others caused by the selection of
			// the compartment
			// item.
			if (getFlag(POPUPBAR_MOVE_FIGURE)
				&& hasPositionChanged(source.getBounds())) {
				hideDiagramAssistant(); // without delay
			} else {
				setFlag(POPUPBAR_MOVE_FIGURE, false); // toggle flag back
				Rectangle theBounds = source.getBounds();
				myPopupBarLastPosition.setLocation(theBounds.x, theBounds.y);
				
				//****************************************************************************
				// ADDED CODE - BEGIN
				//this is added so that the pop-up bar is moved after moving the figure
				//****************************************************************************
				hideDiagramAssistant();
				showDiagramAssistant(new Point(theBounds.x, theBounds.y));
				//****************************************************************************
				// ADDED CODE - END
				//this is added so that the pop-up bar is moved after moving the figure
				//****************************************************************************
			}

		}
	}

	/**
	 * Listens for mouse key presses so the popup bar can be dismissed if the context 
	 * menu is displayed
	 * 
	 * @author affrantz@us.ibm.com
	 */
	private class PopupBarMouseListener extends MouseListener.Stub {

		/**
		 * @see org.eclipse.draw2d.MouseListener#mousePressed(org.eclipse.draw2d.MouseEvent)
		 */
		public void mousePressed(MouseEvent me) {
			if (3 == me.button) // context menu, hide the popup bar
			{
				hideDiagramAssistant();
			}
			super.mousePressed(me);
			setPopupBarOnDiagramActivated(true);
		}
		public void mouseReleased(MouseEvent me)
		{
			super.mouseReleased(me);

		}
	}

	@Override
	public void mouseDragged(MouseEvent me) {
		// do nothing
	}

	@Override
	public void mouseEntered(MouseEvent me) {
		setMouseLocation(me.getLocation());
		
	}

	@Override
	public void mouseExited(MouseEvent me) {
		setMouseLocation(null);
		
		if (!IS_TOUCH_OPTIMIZED)
			hideDiagramAssistantAfterDelay(getDisappearanceDelayUponExit());
	}

	@Override
	public void mouseHover(MouseEvent me) {
		// do nothing
	}

	@Override
	public void mouseMoved(MouseEvent me) {
		setMouseLocation(me.getLocation());

		// do not hide the diagram assistant if the user is hovering over it
		//also do not hide if user is hovering within figure
		setAvoidHidingDiagramAssistant(isDiagramAssistant(me.getSource()));
		
		showDiagramAssistantAfterDelay(getAppearanceDelay());
	}
	
	/**
	 * Listens to the focus events on the owner editpart so that the diagram
	 * assistant can be added when the space bar is pressed. I tried to use
	 * IFigure.addFocusListener(), but the figure isn't getting any focus change
	 * events when the space bar is pressed.
	 */
	private class FocusListener
		extends EditPartListener.Stub {

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.gef.EditPartListener#selectedStateChanged(org.eclipse.gef.EditPart)
		 */
		public void selectedStateChanged(EditPart part) {
			if (part.hasFocus() && shouldShowDiagramAssistant()) {
				showDiagramAssistant(getMouseLocation());
			} else {
				hideDiagramAssistant();
			}
		}
	}
	
	/**
	 * Gets the current mouse location. This will be null if the mouse is
	 * outside the host and diagram assistant figure.
	 * 
	 * @return Returns the current mouse location
	 */
	protected Point getMouseLocation() {
		return mouseLocation;
	}
	
	/**
	 * Gets the amount of time to wait before hiding the diagram assistant after
	 * the user has moved the mouse outside of the editpart.
	 * 
	 * @return the time to wait in milliseconds
	 */
	protected int getDisappearanceDelayUponExit() {
		return DISAPPEARANCE_DELAY_UPON_EXIT;
	}
	
	/**
	 * Hides the diagram assistant after a certain amount of time has passed.
	 * 
	 * @param delay
	 *            the delay in milliseconds
	 */
	protected void hideDiagramAssistantAfterDelay(int delay) {
		if (isDiagramAssistantShowing() && delay >= 0) {
            hideDiagramAssistantJob.cancel();
            hideDiagramAssistantJob.schedule(delay);
		}
	}
	
	/**
	 * The <code>Job</code> used to hide the diagram assistant after a certain
	 * amount of time has passed.
	 */
	private class HideDiagramAssistantJob
        extends UIJob {

        protected HideDiagramAssistantJob() {
            super("Hide Diagram Assistant"); //$NON-NLS-1$
            setSystem(true);
        }

		/**
		 * The diagram assistant is removed when this task is run if the mouse
		 * is still outside the shape.
		 */
		public IStatus runInUIThread(IProgressMonitor monitor) {
			if (getMouseLocation() == null
				|| !shouldAvoidHidingDiagramAssistant()) {
				hideDiagramAssistant();
			}
			return Status.OK_STATUS;
		}

        public boolean belongsTo(Object family) {
            return family == getDiagramAssistantID();
        }
	}
	
	/**
	 * Returns true if the diagram assistant should not be hidden; false
	 * otherwise.
	 * 
	 * @return true if the diagram assistant should not be hidden; false
	 *         otherwise.
	 */
	protected boolean shouldAvoidHidingDiagramAssistant() {
		return avoidHidingDiagramAssistant;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramAssistantEditPolicy#isDiagramAssistant(java.lang.Object)
	 */
	protected boolean isDiagramAssistant(Object object) {
		return object instanceof Toolbar
			|| object instanceof ToolbarItem;
	}
	
	/**
	 * Sets the flag to indicate that the diagram assistant should not be
	 * hidden.
	 * 
	 * @param avoidHidingDiagramAssistant
	 *            Flag to indicate that the diagram assistant should not be
	 *            hidden
	 */
	protected void setAvoidHidingDiagramAssistant(boolean avoidHidingDiagramAssistant) {
		this.avoidHidingDiagramAssistant = avoidHidingDiagramAssistant;
	}
	
	/**
	 * Gets the amount of time to wait before hiding the diagram assistant after
	 * it has been made visible.
	 * 
	 * @return the time to wait in milliseconds
	 */
	protected int getDisappearanceDelay() {
		return DISAPPEARANCE_DELAY;
	}
	
	/**
	 * Gets the amount of time to wait before showing the diagram assistant.
	 * 
	 * @return the time to wait in milliseconds
	 */
	protected int getAppearanceDelay() {
		return APPEARANCE_DELAY;
	}
	
	/**
	 * Shows the diagram assistant after a certain amount of time has passed.
	 * 
	 * @param delay
	 *            the delay in milliseconds
	 */
	protected void showDiagramAssistantAfterDelay(int delay) {
		if (delay >= 0) {
            showDiagramAssistantJob.setOriginalMouseLocation(getMouseLocation());
            showDiagramAssistantJob.cancel();
            showDiagramAssistantJob.schedule(delay);
		}
	}
	
	/**
	 * The <code>Job</code> used to show the diagram assistant after a certain
	 * amount of time has passed.
	 */
	private class ShowDiagramAssistantJob
		extends UIJob {

		/** the mouse location when the job was created */
		private Point originalMouseLocation;

		/**
         * Creates a new instance.
         */
        protected ShowDiagramAssistantJob() {
            super("Show Diagram Assistant"); //$NON-NLS-1$
            setSystem(true);
        }

		/**
		 * Sets mouse location
		 * 
		 * @param originalMouseLocation
		 *            the current mouse location
		 */
		public void setOriginalMouseLocation(Point originalMouseLocation) {
			this.originalMouseLocation = originalMouseLocation;
		}

		/**
		 * The diagram assistant added when this task is run if the mouse is
		 * still at the same spot where it was when the timer was started (i.e.
		 * only add the diagram assistant when the user stops moving the mouse).
		 */
		public IStatus runInUIThread(IProgressMonitor monitor) {
			if (originalMouseLocation != null
				&& originalMouseLocation.equals(getMouseLocation())) {
				if (isDiagramAssistantShowing()
					&& !shouldAvoidHidingDiagramAssistant()) {
					hideDiagramAssistant();
				}
				if (shouldShowDiagramAssistant()) {

                    // Cancel the hide diagram assistant job for this host if it
                    // is waiting to run.
                    hideDiagramAssistantJob.cancel();

                    // Schedule any hide diagram assistant jobs on other
                    // editparts to run immediately to avoid duplicate diagram
                    // assistants showing.
                    if (getDiagramAssistantID() != null) {
                        Job.getJobManager().wakeUp(getDiagramAssistantID());
                    }

					showDiagramAssistant(originalMouseLocation);
				}
			}
			return Status.OK_STATUS;
		}
	}
}
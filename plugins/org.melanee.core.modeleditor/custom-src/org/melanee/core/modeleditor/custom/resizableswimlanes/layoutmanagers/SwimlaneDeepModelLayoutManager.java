/*******************************************************************************
 * Copyright (c) 2012 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Daniel Gritzner - initial API and implementation and initial documentation
 *******************************************************************************/

package org.melanee.core.modeleditor.custom.resizableswimlanes.layoutmanagers;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.DrawerStyle;
import org.eclipse.swt.graphics.Color;
import org.melanee.core.modeleditor.edit.parts.DeepModelDeepModelLevelCompartmentEditPart;
import org.melanee.core.modeleditor.edit.parts.LevelDomainElementsCompartmentEditPart;

/**
 * A layout manager responsible for managing the Levels within a DeepModel. Appropriate bounds
 * are chosen such that no scrollbars are necessary.
 * 
 * @author gritzner
 */
public class SwimlaneDeepModelLayoutManager extends StackLayout {
	// margins and limits to ensure an appealing rendering without any artifacts
	private static final int LEVEL_COMPARTMENT_CONTENT_PANE_MARGIN = 2;
	private static final int MINIMUM_LEVEL_HEIGHT = 39;
	private static final int LEVEL_MARGIN = 10;
	private static final int LEVEL_DOMAIN_ELEMENTS_COMPARTMENT_MARGIN = 2;
	private static final int LEVEL_DOMAIN_ELEMENTS_COMPARTMENT_CONTENT_PANE_MARGIN = 10;
	
	// the DeepModel whose Levels are being managed
	private IGraphicalEditPart deepModel;
	
	/**
	 * @param deepModel the DeepModel whose Levels are being managed
	 */
	public SwimlaneDeepModelLayoutManager(EditPart deepModel) {
		super();
		this.deepModel = (IGraphicalEditPart)deepModel;
	}
	
	/**
	 * returns the EditPart of the LevelCompartment of a DeepModel
	 * 
	 * @param deepModel the DeepModel
	 * @return the LevelCompartment
	 */
	public static IGraphicalEditPart getLevelCompartment(IGraphicalEditPart deepModel) {
		for(Object child : deepModel.getChildren())
			if(child instanceof DeepModelDeepModelLevelCompartmentEditPart)
				return (IGraphicalEditPart)child;		
				
		return null;
	}
	
	/**
	 * determines whether a Level is collapsed
	 * 
	 * @param level the Level whose state is being checked
	 * @return returns true if level is collapsed, false otherwise
	 */
	public static boolean levelIsCollapsed(IGraphicalEditPart level) {
		EList<EObject> list = level.getNotationView().eContents();
		for(EObject obj : list)
			if(obj instanceof DrawerStyle)
				return ((DrawerStyle)obj).isCollapsed();
						
		return false;
	}
	
	/**
	 * returns the EditPart of the LevelDomainElementsCompartment of a Level
	 * 
	 * @param level the Level
	 * @return the LevelDomainElementsCompartment
	 */
	public static IGraphicalEditPart getLevelDomainElementsCompartment(IGraphicalEditPart level) {
		for(Object child : level.getChildren())
			if(child instanceof LevelDomainElementsCompartmentEditPart)
				return (IGraphicalEditPart)child;

		return null;
	}
	
	/**
	 * returns the smallest width delta for a Level which does not cause scrollbars to appear
	 * 
	 * @param level the Level
	 * @return the smallest acceptable width delta
	 */
	public static int getMinimumLevelWidthDelta(IGraphicalEditPart level) {
		IFigure contentPane = level.getContentPane();
		return contentPane.getPreferredSize().width - contentPane.getBounds().width;
	}
	
	/**
	 * returns the height of a Level
	 * 
	 * @param level the Level
	 * @return the height
	 */
	public static int getLevelHeight(IGraphicalEditPart level) {
		return getLevelHeight(level, 0, false);
	}
	
	/**
	 * Returns the height of a level which may be changed soon (e.g. when handling a ChangeBoundsRequest).
	 * The returned height accounts for the incoming change and also enforces a minimal height prevent
	 * scrollbars.
	 * 
	 * @param level the Level
	 * @param deltaHeight how much the Level's height will be changed soon
	 * @param skipCollapsedCheck if true calculate the Level's height as if it is not collapsed
	 * @return the Level's new height
	 */
	public static int getLevelHeight(IGraphicalEditPart level, int deltaHeight, boolean skipCollapsedCheck) {
		IFigure figure = level.getFigure();
		int minHeight = MINIMUM_LEVEL_HEIGHT; // figure.getMinimumSize() seems to return only (0,0) after switching to XYLayouts for Levels
		int figHeight = minHeight;
		
		if(skipCollapsedCheck || !levelIsCollapsed(level)) {
			IGraphicalEditPart compartmentEditPart = getLevelDomainElementsCompartment(level);
			
			// determine height of current EditPart and make sure that the new height respects the minimum height
			figHeight = figure.getBounds().height + deltaHeight;
			minHeight += compartmentEditPart.getContentPane().getPreferredSize().height; 
			figHeight = Math.max(figHeight, minHeight); 						
		}
	
		return figHeight;
	}
	
	/**
	 * Calculate the total height of all Levels within a DeepModel
	 * 
	 * @param deepModel the DeepModel
	 * @return the sum of the height of all Levels
	 */
	public static int getTotalLevelHeight(IGraphicalEditPart deepModel) {
		int height = 0;
		
		IGraphicalEditPart editPart = getLevelCompartment(deepModel);
		for(Object child : editPart.getChildren()) {
			IGraphicalEditPart level = (IGraphicalEditPart)child;
			height += getLevelHeight(level);
		}
		
		return height;
	}
	
	/**
	 * Sets the bounds of a Level's figure.
	 * 
	 * The LevelDomainElementsCompartment is not changed!
	 * 
	 * @param level the Level being updated
	 * @param y its new vertical position
	 * @param width its new width
	 * @return the vertical position of the next Level
	 */
	private int updateLevel(IGraphicalEditPart level, int y, int width) {
		IFigure figure = level.getFigure();
		Rectangle bounds = figure.getBounds().getCopy();

		bounds.x = 0;
		bounds.y = y;
		bounds.width = width;
		bounds.height = getLevelHeight(level);
		y += bounds.height; // update y for the next iteration
		
		figure.setBounds(bounds);
		level.getContentPane().setBounds(bounds);
		
		return y;
	}
	
	/**
	 * Sets the bounds of a LevelDomainElementsCompartment.
	 * 
	 * @param compartment the LevelDomainElementsCompartment
	 * @param width its new width
	 */
	private void updateDomainElementsCompartment(IGraphicalEditPart compartment, int width) {
		IFigure figure = compartment.getFigure();
		Rectangle bounds = figure.getBounds().getCopy();
		bounds.width = width;
		figure.setBounds(bounds);
		
		figure = compartment.getContentPane();
		bounds = figure.getBounds().getCopy();
		bounds.width = width - LEVEL_DOMAIN_ELEMENTS_COMPARTMENT_CONTENT_PANE_MARGIN;
		figure.setBounds(bounds);
	}
	
	/**
	 * Sets the bounds of all Levels and their LevelDomainElementsCompartments. Ensures appropriate values
	 * are set to prevent scrollbars.
	 * 
	 * @param levelCompartment the compartment containing all the Levels
	 */
	private void layoutLevels(IGraphicalEditPart levelCompartment) {
		int width = levelCompartment.getFigure().getBounds().width - LEVEL_MARGIN;
		int y = 0;
		
		for(Object child : levelCompartment.getChildren()) {
			// update the bounds of the Level 'child'
			IGraphicalEditPart level = (IGraphicalEditPart)child;	
			y = updateLevel(level, y, width);
		
			// update the bounds of the Level's LevelDomainElementsCompartment
			IGraphicalEditPart domainElementsCompartment = getLevelDomainElementsCompartment(level);
			updateDomainElementsCompartment(domainElementsCompartment, width - LEVEL_DOMAIN_ELEMENTS_COMPARTMENT_MARGIN);
		}
	}
	
	/**
	 * Sets the bounds of all Levels of a DeepModel. Ensures appropriate values are set to prevent
	 * scrollbars.
	 * 
	 * @param figure the DeepModel's figure
	 */
	@Override
	public void layout(IFigure figure) {
		super.layout(figure);
		
		// update the bounds of the LevelCompartment
		IGraphicalEditPart levelCompartment = getLevelCompartment(deepModel);
		IFigure compFigure = levelCompartment.getFigure();
				
		Rectangle bounds = compFigure.getBounds().getCopy();
		bounds.width = figure.getBounds().width - LEVEL_COMPARTMENT_CONTENT_PANE_MARGIN;
		compFigure.setBounds(bounds);
				
		// update the bounds of all Levels contained in the LevelCompartment
		layoutLevels(levelCompartment);
	}	
}

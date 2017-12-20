/*******************************************************************************
 * Copyright (c) 2011, 2012 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Ralph Gerbig - initial API and implementation and initial documentation
 *******************************************************************************/ 
package org.melanee.core.workbench.interfaces;

import org.eclipse.jface.viewers.IFilter;
import org.melanee.core.models.plm.PLM.AbstractDSLVisualizer;
import org.melanee.core.models.plm.PLM.Element;

/**
 * Interface for a visual model to figure transformator.
 * The transformator takes a visualizer as input and generates
 * a renderable figure as output (e.g. a draw2d figure).
 *
 */
public interface IApplicationVisualizationService extends IVisualizationServiceBase {
	
	/**
	 * Runs the application DSL visualizer
	 * 
	 * @param host the model-element on which to invoke the service (e.g. IGraphicalEditPart)
	 * @param notation the notation to apply
	 * @param notationChanged is the service invoked after a change of the notation 
	 * 			or to update the visualization without notation change  
	 * 
	 * @return renderable figure (org.eclipse.draw2d.IFigure)
	 */
	public abstract Object run(Object host, String notation, boolean notationChanged);
	
	/**
	 * <p>Looks up the DSLVisualizer for an Element by the following rules:</p>
	 * 
	 * <ol> 
	 * 		<li>Check the supertypes for a visualizer and take the closest
	 * 		with lowest potency.</li>
	 * 		<li>Check the types for a visualizer and take the closest
	 * 		with lowest potency.</li>
	 * 		<li>Return the default LMLVisualization (null)</li>
	 * </ol>
	 * 
	 * @param e The element to search the DSLVisualizer for.
	 * @return A graphical dsl visualizer or  null if none is found.
	 */
	public abstract AbstractDSLVisualizer findDSLVisualizerForElement(Element e);
	
	/**
	 * Retrievs the filter which manages the visibility of
	 * the ontological property tab based on the active
	 * application dsl visualizers values.
	 * 
	 * @return the filter for ontological properties tab
	 */
	public abstract IFilter getFilterForOntologicalProperties();
	
	/**
	 * Retrievs the filter which manages the visibility of
	 * the linguistic property tab based on the active
	 * application dsl visualizers values.
	 * 
	 * @return the filter for linguistic properties tab
	 */
	public abstract IFilter getFilterForLinguisticProperties();
	
	/**
	 * Retrievs the filter which manages the visibility of
	 * the visualization property tab based on the active
	 * application dsl visualizers values.
	 * 
	 * @return the filter for visualization properties tab
	 */
	public abstract IFilter getFilterForVisualizationProperties();
	
	
	/**
	 * Retrievs the filter which manages the visibility of
	 * the multiplicity property tab based on the active
	 * application dsl visualizers values.
	 * 
	 * @return the filter for visualization properties tab
	 */
	public abstract IFilter getFilterForMultiplicityProperties();

	public abstract IFilter getFilterForConstraintProperties();
}
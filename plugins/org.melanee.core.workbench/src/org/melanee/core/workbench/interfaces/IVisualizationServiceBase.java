/*******************************************************************************
 * Copyright (c) 2013 - 2014 University of Mannheim: Chair for Software Engineering All rights
 * reserved. This program and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Ralph Gerbig - initial API and implementation and initial documentation
 *******************************************************************************/
package org.melanee.core.workbench.interfaces;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.melanee.core.models.plm.PLM.AbstractDSLVisualizer;
import org.melanee.core.models.plm.PLM.Element;

/**
 * Interface for services that work with visualizers
 *
 */
public abstract interface IVisualizationServiceBase {

  public static final String FORMAT_GRAPH = "graph";
  public static final String FORMAT_TABLE = "table";
  public static final String FORMAT_TEXT = "text";
  public static final String FORMAT_FORM = "form";
  public static final String FORMAT_APP = "app";
  public static final String FORMAT_GRAMMAR = "grammar";

  public static final String NOTATION_LML = "lml";
  public static final String NOTATION_DERIVED = "derived";

  /**
   * Returns the ID of the visualization editor
   * 
   * @return the ID of the visualization editor
   */
  public abstract String getVisualizationEditorViewID();

  /**
   * This method can be used to filter the visibility of the visualization editor view.
   *
   * @param element Element to check visibility for
   * @return whether the element is visible
   */
  public abstract boolean isVisibleInVisualizerEditorView(EObject element);

  /**
   * 
   * xxxItemAdapterProviderFactory needed in VisualizationEditorView
   * 
   * @return the xxxItemAdapterProviderFactory
   */
  public abstract AdapterFactory getItemProviderAdapterFactory();

  /**
   * Needed to create the initial dsl initializer in VisualizationEditorView. Once this is created,
   * the rest can be inferred from the meta-model.
   * 
   * @return e.g. GraphicalDSLVisualizer, TextualDSLVisualizer
   */
  public abstract AbstractDSLVisualizer createNewSpecificDSLVisualizer();

  /**
   * <p>
   * Looks up the DSLVisualizer for an Element by the following rules:
   * </p>
   * 
   * <ol>
   * <li>Check the supertypes for a visualizer and take the closest with lowest potency.</li>
   * <li>Check the types for a visualizer and take the closest with lowest potency.</li>
   * <li>Return the default LMLVisualization (null)</li>
   * </ol>
   * 
   * @param e The element to search the DSLVisualizer for.
   * @paran mergeAspects determines if aspects are merged into the returned visualizer. If a
   *        visualizer which is not an aspect visualizer (a visualizer not containing aspects) is
   *        returned.
   * @return A graphical dsl visualizer or null if none is found.
   */
  public AbstractDSLVisualizer findDSLVisualizerForElement(Element e, String notation,
      boolean mergeAspects);
}

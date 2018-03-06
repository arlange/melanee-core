/*******************************************************************************
 * Copyright (c) 2011 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Ralph Gerbig - initial API and implementation and initial documentation
 *******************************************************************************/

package org.melanee.core.workbench.perspective;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.melanee.core.workbench.ExtensionPointService;
import org.melanee.core.workbench.interfaces.IApplicationVisualizationService;
import org.melanee.core.workbench.interfaces.IFormVisualizationService;
import org.melanee.core.workbench.interfaces.IGraphicalVisualizationService;
import org.melanee.core.workbench.interfaces.IReasoningService;
import org.melanee.core.workbench.interfaces.ITextualVisualizationService;

/**
 * @author Ralph Gerbig
 *
 *         This class defines the standard LML perspective.
 */
public class MelaneePerspectiveFactory implements IPerspectiveFactory {

  @Override
  public void createInitialLayout(IPageLayout layout) {

    defineLayout(layout);

  }

  private void defineLayout(IPageLayout layout) {
    // Editors are placed for free.
    String editorArea = layout.getEditorArea();

    // Place navigator and outline to left of
    // editor area.
    IFolderLayout left = layout.createFolder("left", IPageLayout.LEFT, 0.20f, editorArea);
    left.addView(IPageLayout.ID_PROJECT_EXPLORER);

    try {
      IReasoningService reasoner = ExtensionPointService.Instance().getActiveReasoningService();
      if (reasoner != null)
        left.addView(reasoner.getReasoningServiceViewID());
    } catch (CoreException e) {
      e.printStackTrace();
    }

    IFolderLayout bottomLeft = layout.createFolder("leftBottom", IPageLayout.BOTTOM, 0.7f, "left");
    bottomLeft.addView(IPageLayout.ID_OUTLINE);

    IFolderLayout bottom = layout.createFolder("bottom", IPageLayout.BOTTOM, 0.7f, editorArea);
    bottom.addView(IPageLayout.ID_PROP_SHEET);

    // Stores all view ids which are contributed by extension points
    Set<String> visualizationViewsToOpen = new HashSet<String>();

    try {
      IGraphicalVisualizationService graphicalVisualizationService = ExtensionPointService
          .Instance().getActiveGraphicalVisualizationService();
      if (graphicalVisualizationService != null)
        visualizationViewsToOpen.add(graphicalVisualizationService.getVisualizationEditorViewID());

      IFormVisualizationService formVisualizationService = ExtensionPointService.Instance()
          .getActiveFormVisualizationService();
      if (formVisualizationService != null)
        visualizationViewsToOpen.add(formVisualizationService.getVisualizationEditorViewID());

      ITextualVisualizationService textualVisualizationService = ExtensionPointService.Instance()
          .getActiveTextualVisualizationService();
      if (textualVisualizationService != null)
        visualizationViewsToOpen.add(textualVisualizationService.getVisualizationEditorViewID());

      IApplicationVisualizationService applicationVisualizationService = ExtensionPointService
          .Instance().getActiveApplicationVisualizationService();
      if (applicationVisualizationService != null)
        visualizationViewsToOpen
            .add(applicationVisualizationService.getVisualizationEditorViewID());

      IFolderLayout bottomRight = layout.createFolder("bottomRight", IPageLayout.RIGHT, 0.5f,
          "bottom");

      for (String id : visualizationViewsToOpen)
        bottomRight.addView(id);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}

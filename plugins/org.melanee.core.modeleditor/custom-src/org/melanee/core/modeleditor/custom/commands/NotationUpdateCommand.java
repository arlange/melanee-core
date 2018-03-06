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
package org.melanee.core.modeleditor.custom.commands;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.melanee.core.models.plm.PLM.Element;
import org.melanee.core.models.plm.PLM.LMLVisualizer;
import org.melanee.core.workbench.ExtensionPointService;
import org.melanee.core.workbench.interfaces.IVisualizationServiceBase;

public class NotationUpdateCommand extends Command {

  private IGraphicalEditPart host = null;
  private String notation;
  private String format;

  /**
   * 
   * @param host
   *          Element which shall be toggled
   */
  public NotationUpdateCommand(IGraphicalEditPart host, String format) {
    this.host = host;
    this.format = format;
  }

  @Override
  public void execute() {
    super.execute();

    // This code is not interesting for diagrammatic format as this
    // will change immediately anyway.
    if (IVisualizationServiceBase.FORMAT_GRAPH.equals(format))
      return;

    Element self = (Element) host.resolveSemanticElement();

    if (self.getVisualizer() == null)
      return;

    String notation = null;
    LMLVisualizer lmlVisualizer = self.getVisualizer().get(0);

    for (String attr : lmlVisualizer.getAttributes())
      if (attr.startsWith(format)) {
        notation = lmlVisualizer.getValueForKey(format);
        break;
      }

    if (notation == null)
      return;

    try {

      if (IVisualizationServiceBase.FORMAT_TEXT.equals(format))
        ExtensionPointService.Instance().getActiveTextualVisualizationService().run(host, notation,
            false);
      else if (IVisualizationServiceBase.FORMAT_TABLE.equals(format))
        ExtensionPointService.Instance().getActiveTableVisualizationService().run(host, notation,
            false);
      else if (IVisualizationServiceBase.FORMAT_FORM.equals(format))
        ExtensionPointService.Instance().getActiveFormVisualizationService().run(host, notation,
            false);
      else if (IVisualizationServiceBase.FORMAT_APP.equals(format))
        ExtensionPointService.Instance().getActiveApplicationVisualizationService().run(host,
            notation, false);

    } catch (CoreException e) {
      e.printStackTrace();
    }

    return;
  }
}
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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.edit.command.ReplaceCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.melanee.core.models.plm.PLM.Element;
import org.melanee.core.models.plm.PLM.PLMPackage;

public class NotationSelectionCommand extends Command {

  private IGraphicalEditPart host = null;
  private String notation;
  private String format;

  /**
   * 
   * @param host
   *          Element which shall be toggled
   */
  public NotationSelectionCommand(IGraphicalEditPart host, String notation, String format) {
    this.host = host;
    this.notation = notation;
    this.format = format;
  }

  @Override
  public void execute() {
    super.execute();

    Element self = (Element) host.resolveSemanticElement();

    if (self.getVisualizer() == null)
      return;

    List<String> newAttribute = new ArrayList<String>();
    String oldAttribute = null;

    for (String attr : self.getVisualizer().get(0).getAttributes())
      if (attr.startsWith(format)) {
        oldAttribute = attr;
        newAttribute.add(format + "= " + notation);
        break;
      }

    EditingDomain domain = host.getEditingDomain();
    domain.getCommandStack().execute(ReplaceCommand.create(domain, self.getVisualizer().get(0),
        PLMPackage.eINSTANCE.getLMLVisualizer_Attributes(), oldAttribute, newAttribute));
  }
}
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
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.edit.command.ReplaceCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.melanee.core.models.plm.PLM.Element;
import org.melanee.core.models.plm.PLM.PLMPackage;

/**
 * Command to switch between DSL and GPL view
 *
 */
public class ToggleCommand extends Command{
	
	private IGraphicalEditPart host = null;
	
	/**
	 * 
	 * @param host Element which shall be toggled
	 */
	public ToggleCommand(IGraphicalEditPart host){
		this.host = host;
	}
	
	@Override
	public void execute() {
		super.execute();

		Element self = (Element)host.resolveSemanticElement();
		
		if (self.getVisualizer() == null)
			return;
		
		List<String> newAttribute = new ArrayList<String>();
		String oldAttribute = null;
		
		for (String attr : self.getVisualizer().get(0).getAttributes())
			if (attr.startsWith("collapsed"))
			{
				oldAttribute = attr;
				String value = self.getVisualizer().get(0).getValueForKey("collapsed");
				newAttribute.add((value.equals("true")) ? "collapsed= false":"collapsed= true");
				break;
			}
		
		EditingDomain domain = host.getEditingDomain();
		domain.getCommandStack().execute(ReplaceCommand.create(domain, self.getVisualizer().get(0), PLMPackage.eINSTANCE.getLMLVisualizer_Attributes(), oldAttribute, newAttribute));
	}
}
/*******************************************************************************
 * Copyright (c) 2011 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     - initial API and implementation and initial documentation
 *******************************************************************************/
package org.melanee.core.modeleditor.custom.commands;

import org.eclipse.gef.commands.Command;

/**
 * 
 * Command which does not execute any action. This command is for example
 * used for the seperator of the pop up tool bar.
 *
 */
public class EmptyCommand extends Command{
	
	@Override
	public void execute() {
		super.execute();
	}
}
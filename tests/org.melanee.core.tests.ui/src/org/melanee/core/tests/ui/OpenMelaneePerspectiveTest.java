/*******************************************************************************
 * Copyright (c) 2012 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Ralph Gerbig - initial API and implementation and initial documentation
 *******************************************************************************/
package org.melanee.core.tests.ui;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SWTBotJunit4ClassRunner.class)
public class OpenMelaneePerspectiveTest {

	private SWTWorkbenchBot bot;
	
	@Test
	public void canOpenMelaneePerspective(){
		
		//First close all old perspectives
		bot.menu("Window").menu("Close All Perspectives").click();
		
		//Open Melanee Perspective
		bot.perspectiveByLabel(TestConstants.PERSPECTIVE_MELANEE_NAME).activate();
	}
	
	@Before
	public void setup(){
		bot = new SWTWorkbenchBot();
	}

	
}

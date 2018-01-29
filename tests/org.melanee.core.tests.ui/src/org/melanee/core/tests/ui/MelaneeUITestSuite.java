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
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({OpenMelaneePerspectiveTest.class, CreateNewLMLFileTest.class, ModelDeepModelTest.class, InstantiateTest.class,
				PropertiesViewTest.class})
public class MelaneeUITestSuite {

	@BeforeClass
	public static void closeWelcomeScreen(){
		
		SWTWorkbenchBot bot = new SWTWorkbenchBot();
		
		//Close the Welcome page if open
		boolean welcomePageOpen = false;
		for (SWTBotView v : bot.views())
			if (TestConstants.VIEW_WELCOME_NAME.equals(v.getTitle()))
				welcomePageOpen = true;
		if (welcomePageOpen)
			bot.viewByTitle(TestConstants.VIEW_WELCOME_NAME).close();
	}
}
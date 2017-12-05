/*******************************************************************************
 * Copyright (c) 2012 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     - initial API and implementation and initial documentation
 *******************************************************************************/
package org.melanee.core.tests.ui;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.melanee.core.tests.ui.runner.OrderedSWTBotTestRunner;
import org.melanee.core.tests.ui.runner.OrderedSWTBotTestRunner.TestOrder;

@RunWith(OrderedSWTBotTestRunner.class)
public class CreateNewLMLFileTest {

	private static SWTWorkbenchBot bot;
	
	@Test
	@TestOrder(no=1)
	public void canCreateLMLProject(){
		bot.menu(TestConstants.MENU_FILE).menu(TestConstants.MENU_NEW).menu(TestConstants.MENU_PROJECT).click();
		bot.shell("New Project").activate();
		bot.tree().expandNode(TestConstants.CATEGORY_GENERAL, true).select(TestConstants.TYPE_PROJECT);
		bot.button(TestConstants.BUTTON_NEXT).click();
		bot.text().typeText(TestConstants.PROJECT_TEST_PROJECT_NAME);
		bot.button(TestConstants.BUTTON_FINISH).click();
		
		SWTBotShell wizardShell = bot.activeShell(); 
		
		bot.viewByTitle(TestConstants.VIEW_PROJECT_EXPLORER_NAME).setFocus();
		
		bot.waitUntil(Conditions.shellCloses(wizardShell));
	}
	
	@Test
	@TestOrder(no=2)
	public void createLMLFileInProject(){
		
		//Create a new file
		bot.menu(TestConstants.MENU_FILE).menu(TestConstants.MENU_NEW).menu(TestConstants.MENU_OTHER).click();
		bot.shell("New").activate();
		bot.tree().expandNode(TestConstants.CATEGORY_MELANEE).select(TestConstants.TYPE_LML_Diagram);
		bot.button(TestConstants.BUTTON_NEXT).click();
		
		bot.tree().select(TestConstants.PROJECT_TEST_PROJECT_NAME);
		
		bot.textWithLabel(TestConstants.LABEL_FILE_NAME).typeText(TestConstants.FILE_TEST_FILE);
		
		SWTBotShell wizardShell = bot.activeShell();
		
		bot.button(TestConstants.BUTTON_FINISH).click();
		
		bot.waitUntil(Conditions.shellCloses(wizardShell));
		
		bot.viewByTitle(TestConstants.VIEW_PROJECT_EXPLORER_NAME).bot().tree()
			.expandNode(TestConstants.PROJECT_TEST_PROJECT_NAME, true).select(TestConstants.FILE_TEST_FILE);
		
		bot.activeEditor().close();
	}
	
	@BeforeClass
	public static void setup(){
		bot = new SWTWorkbenchBot();
		
		//Open Melanee Perspective if not open
		if (!"Melanee".equals(bot.activePerspective().getLabel()))
			bot.perspectiveByLabel("Melanee").activate();
	}	
}
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

import static org.junit.Assert.assertTrue;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.gef.finder.SWTGefBot;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.melanee.core.tests.ui.runner.OrderedSWTBotTestRunner;
import org.melanee.core.tests.ui.runner.OrderedSWTBotTestRunner.TestOrder;

@RunWith(OrderedSWTBotTestRunner.class)
public class PropertiesViewTest {

	private static SWTWorkbenchBot bot;
	private static SWTGefBot gefBot;
	private static SWTBotGefEditor editor;
	
	@Test
	@TestOrder(no=1)
	public void ontologicalPropertiesViewWorking(){
		//Check whether the tab is there
		assertTrue(GMFTestUtil.tabbedPropertiesPageExists(TestConstants.PROPERTIES_TAB_ONTOLOGICAL, bot));
		
		//Click on it
		GMFTestUtil.selectTabbedPropertiesPage(TestConstants.PROPERTIES_TAB_ONTOLOGICAL, bot);
	}
	
	@Test
	@TestOrder(no=2)
	public void linguisticPropertiesViewWorking(){
		//Check whether the tab is there
		assertTrue(GMFTestUtil.tabbedPropertiesPageExists(TestConstants.PROPERTIES_TAB_VISUALIZATION, bot));
		
		//Click on it
		GMFTestUtil.selectTabbedPropertiesPage(TestConstants.PROPERTIES_TAB_VISUALIZATION, bot);
	}
	
	@BeforeClass
	public static void setup(){
		bot = new SWTWorkbenchBot();
		gefBot = new SWTGefBot();
		
		//Open Melanee Perspective if not open
		if (!"Melanee".equals(bot.activePerspective().getLabel()))
			bot.perspectiveByLabel("Melanee").activate();
		
		editor = gefBot.gefEditor(TestConstants.FILE_TEST_FILE);
		editor.getEditPart("A");
	}
}
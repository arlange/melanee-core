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

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.gef.finder.SWTGefBot;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.melanee.core.tests.ui.runner.OrderedSWTBotTestRunner;
import org.melanee.core.tests.ui.runner.OrderedSWTBotTestRunner.TestOrder;

@RunWith(OrderedSWTBotTestRunner.class)
public class InstantiateTest {

	private static SWTWorkbenchBot bot;
	private static SWTGefBot gefBot;
	
	@Test
	@TestOrder(no=1)
	public void checkInstantiationPaletteElementsAvailable(){
		SWTBotGefEditor editor = gefBot.gefEditor(TestConstants.FILE_TEST_FILE);
		editor.click("O1");
		
		editor.bot().sleep(1000);
		
		editor.activateTool("A");
		editor.activateTool("B");
		//Check if generic tool for instantiating connection is shown
		editor.activateTool("Instantiate Connection");
		editor.activateDefaultTool();
	}
	
	@Test
	@TestOrder(no=2)
	public void addInstanceEntities(){
		SWTBotGefEditor editor = gefBot.gefEditor(TestConstants.FILE_TEST_FILE);
		
		final IGraphicalEditPart epA = (IGraphicalEditPart)editor.getEditPart("A").part().getParent();
		GMFTestUtil.executeSelectionToolBarToolWithTooltip(epA, TestConstants.POPUP_TOOL_INSTANTIATE);
		Point modelCenter = GMFTestUtil.getEditPartCenter((IGraphicalEditPart)editor.getEditPart("O1").part());
		
		editor.activateTool("A");
		editor.click(modelCenter.x - 100, modelCenter.y + 15);
		editor.directEditType("a");
		
		final IGraphicalEditPart epB = (IGraphicalEditPart)editor.getEditPart("B").part().getParent();
		GMFTestUtil.executeSelectionToolBarToolWithTooltip(epB, TestConstants.POPUP_TOOL_INSTANTIATE);
		
		editor.activateTool("B");
		editor.click(modelCenter.x + 100, modelCenter.y + 15);
		editor.directEditType("b");
	}
	
	@Test
	@TestOrder(no=3)
	public void instantiateConnectionBetweenAAndB(){
		SWTBotGefEditor editor = gefBot.gefEditor(TestConstants.FILE_TEST_FILE);
		GMFTestUtil.connect("a", "b", editor);
		
		//TODO: Select item from context menu
	}
	
	@BeforeClass
	public static void setup(){
		bot = new SWTWorkbenchBot();
		gefBot = new SWTGefBot();
		
		//Open Melanee Perspective if not open
		if (!"Melanee".equals(bot.activePerspective().getLabel()))
			bot.perspectiveByLabel("Melanee").activate();
	}
}
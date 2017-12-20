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

import java.util.Set;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.ocl.ParserException;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.gef.finder.SWTGefBot;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable;
import org.eclipse.swtbot.swt.finder.results.VoidResult;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.melanee.core.common.emf.ocl.OCLHelper;
import org.melanee.core.tests.ui.runner.OrderedSWTBotTestRunner;
import org.melanee.core.tests.ui.runner.OrderedSWTBotTestRunner.TestOrder;
import org.melanee.core.models.plm.PLM.Clabject;
import org.melanee.core.models.plm.PLM.Feature;
import org.melanee.core.models.plm.PLM.PLMPackage;
import org.melanee.core.models.plm.PLM.ConnectionEnd;

@RunWith(OrderedSWTBotTestRunner.class)
public class ModelDeepModelTest {

	private static SWTWorkbenchBot bot;
	private static SWTGefBot gefBot;
	
	@Test
	@TestOrder(no=1)
	public void openModel(){
		bot.viewByTitle(TestConstants.VIEW_PROJECT_EXPLORER_NAME).bot().tree().expandNode(TestConstants.PROJECT_TEST_PROJECT_NAME)
			.select(TestConstants.FILE_TEST_FILE).getItems()[0].doubleClick();
	}
	
	@Test
	@TestOrder(no=2)
	public void addOntotogy() throws Exception{
		SWTBotGefEditor editor = gefBot.gefEditor(TestConstants.FILE_TEST_FILE);
		editor.activateTool("Deep Model");
		editor.click(50, 50);
		editor.directEditType("Test Deep Model");
	}
	
		  
	@Test
	@TestOrder(no=4)
	public void addTwoModelsViaPalette(){
		SWTBotGefEditor editor = gefBot.gefEditor(TestConstants.FILE_TEST_FILE);
		
		Point deepModelMiddle = GMFTestUtil.getEditPartCenter((IGraphicalEditPart)editor.getEditPart("Test Deep Model").part());
		
		editor.activateTool("Level");
		editor.click(deepModelMiddle.x, deepModelMiddle.y);
			
		editor.activateTool("Level");
		editor.click(deepModelMiddle.x, deepModelMiddle.y);
	}
	
	@Test
	@TestOrder(no=5)
	public void addTypeEntities(){
		SWTBotGefEditor editor = gefBot.gefEditor(TestConstants.FILE_TEST_FILE);
		
		Point modelMiddle = GMFTestUtil.getEditPartCenter((IGraphicalEditPart)editor.getEditPart("O0").part());
		editor.click(modelMiddle.x, modelMiddle.y);
		
		editor.activateTool(TestConstants.TOOL_ENTITY);
		editor.click(modelMiddle.x - 100, modelMiddle.y + 15);
		editor.directEditType("A");
		
		final IGraphicalEditPart epA = (IGraphicalEditPart)editor.getEditPart("A").parent().part();

		editor.activateTool(TestConstants.TOOL_ATTRIBUTE);
		editor.click(editor.getEditPart("A"));
		editor.directEditType("attrA");
				
		editor.activateTool("Entity");
		editor.click(modelMiddle.x + 100, modelMiddle.y + 15);
		editor.directEditType("B");
	}
	
	@Test
	@TestOrder(no=6)
	public void connectEntities(){
		SWTBotGefEditor editor = gefBot.gefEditor(TestConstants.FILE_TEST_FILE);
		
		GMFTestUtil.connect("A", "B", editor);
		
		//Setup the connection to be navigable towards B only
		try {
			
			final IGraphicalEditPart part = (IGraphicalEditPart)editor.getEditPart("A").part();
			
			Set roles = (Set)OCLHelper.execute(part.resolveSemanticElement(),
					"ConnectionEnd.allInstances()->select(r | r.destination = self)");
			ConnectionEnd r = (ConnectionEnd)roles.toArray()[0];
			
			final CompoundCommand setupRole = new CompoundCommand("Setup role");
			
			setupRole.append(SetCommand.create(part.getEditingDomain(), r, PLMPackage.eINSTANCE.getConnectionEnd_Navigable(), false));
			setupRole.append(SetCommand.create(part.getEditingDomain(), r, PLMPackage.eINSTANCE.getConnectionEnd_Lower(), 1));
			setupRole.append(SetCommand.create(part.getEditingDomain(), r, PLMPackage.eINSTANCE.getConnectionEnd_Upper(), 1));
			
			UIThreadRunnable.syncExec(new VoidResult() {
				
				@Override
				public void run() {
					part.getEditingDomain().getCommandStack().execute(setupRole);
				}
			});
			
		} catch (ParserException e) {
			e.printStackTrace();
		}
		
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
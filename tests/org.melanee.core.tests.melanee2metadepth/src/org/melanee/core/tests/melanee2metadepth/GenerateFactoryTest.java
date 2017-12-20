/*******************************************************************************
 * Copyright (c) 2013 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Ralph Gerbig - initial API and implementation and initial documentation
 *******************************************************************************/
package org.melanee.core.tests.melanee2metadepth;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;
import org.junit.Test;
import org.melanee.core.melanee2metadepth.main.GenerateMetadepth;

public class GenerateFactoryTest {
	
	@Test
	public void generateFactory() throws IOException, URISyntaxException {
		
		//Get the path of the plugins result folder
		URL resultFolderURL = Platform.getBundle("org.melanee.core.tests.melanee2metadepth").getEntry("result");
		File resultFolder = new File(FileLocator.toFileURL(resultFolderURL).getPath());
		URL expectedFolderURL = Platform.getBundle("org.melanee.core.tests.melanee2metadepth").getEntry("expected");
		File expectedFolder = new File(FileLocator.toFileURL(expectedFolderURL).getPath());
		
		//Load the example model
		URI sourceModel = URI.createPlatformResourceURI("/org.melanee.core.tests.melanee2metadepth/models/ProductionSystem.lml", true);
		List<String> arguments = new ArrayList<String>();
		
		//Generate the metadepth file
		GenerateMetadepth generator = new GenerateMetadepth(sourceModel, resultFolder, arguments);
		generator.doGenerate(new BasicMonitor());
		
		//Read the result and expected result line by line and compare
		List<String> diff = new ArrayList<String>();
		
		BufferedReader resultReader = new BufferedReader(new FileReader(resultFolder.getAbsoluteFile() + "/ProductionSystemDeepModel.mdepth"));
		BufferedReader expectedReader = new BufferedReader(new FileReader(expectedFolder.getAbsoluteFile() + "/ProductionSystemDeepModel.mdepth"));
		
		String resultLine, expectedLine;
		
		while ((resultLine = resultReader.readLine()) != null
					&& (expectedLine = expectedReader.readLine()) != null)
			if (!resultLine.equals(expectedLine))
				diff.add(resultLine + "<- ->" + expectedLine);
		
		for (String str : diff)
			System.out.println(str);
		
		resultReader.close();
		expectedReader.close();
		
		assertTrue("Generated file and expected result are not equal. Did you change the ordered property of PLM methods?", diff.size() == 0);
	}

}
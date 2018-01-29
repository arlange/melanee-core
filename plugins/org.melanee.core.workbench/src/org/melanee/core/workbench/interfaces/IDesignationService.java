/*******************************************************************************
 * Copyright (c) 2012 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Ralph Gerbig, Bastian Kennel - initial API and implementation and initial documentation
 *******************************************************************************/ 
package org.melanee.core.workbench.interfaces;

import org.melanee.core.models.plm.PLM.Clabject;

/**
 * Interface that needs to be implemented in order to offer a 
 * Proximity Indication Service
 *
 */
public interface IDesignationService {

	public String evaluate(Clabject context, String query);
	
	public String createHeritageDesignationString(Clabject context, String query);
	
	public String createLocationDesignationString(Clabject context, String query);
	
	public String createIdenficationDesignationString(Clabject context, String query);
	
	public String createClassificationDesignationString(Clabject context, String query);
	
	
}

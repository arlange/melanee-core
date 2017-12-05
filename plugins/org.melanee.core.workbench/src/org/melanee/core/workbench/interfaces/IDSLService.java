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
package org.melanee.core.workbench.interfaces;

import java.util.List;

import org.melanee.core.models.plm.PLM.Connection;
import org.melanee.core.models.plm.PLM.Entity;
import org.melanee.core.models.plm.PLM.ConnectionEnd;

public interface IDSLService {
	
	/**
	 * Searches for all instantiable Connections between sourceInstance and targetInstance
	 * 
	 * @param sourceInstance The source of the connection
	 * @param targetInstance The target of the connection
	 * 
	 * @return A list of all instantiable connectionEnds
	 */
	public List<Connection> getInstantiableConnectionsBetween(Entity sourceInstance, Entity targetInstance);
	/**
	 * Searches for all instantiable Connections between sourceInstance and targetInstance
	 * 
	 * @param sourceInstance The source of the connection
	 * @param targetInstance The target of the connection
	 * 
	 * @return A list of all instantiable connections
	 */
	public List<Connection> getInstantiableConnectionsBetween(Connection sourceInstance, Connection targetInstance);
	/**
	 * Searches for all instantiable Connections between sourceInstance and targetInstance
	 * 
	 * @param sourceInstance The source of the connection
	 * @param targetInstance The target of the connection
	 * 
	 * @return A list of all instantiable connections
	 */
	public List<Connection> getInstantiableConnectionsBetween(Connection sourceInstance, Entity targetInstance);
	/**
	 * Searches for all instantiable Connections between sourceInstance and targetInstance
	 * 
	 * @param sourceInstance The source of the connection
	 * @param targetInstance The target of the connection
	 * 
	 * @return A list of all instantiable connections
	 */
	public List<Connection> getInstantiableConnectionsBetween(Entity sourceInstance, Connection targetInstance);
	
	/**
	 * Searches for all instantiable connectionEnds between sourceInstance and targetInstance
	 * 
	 * @param sourceInstance The source of the connectionEnd
	 * @param targetInstance The target of the connectionEnd
	 * 
	 * @return A list of all instantiable connectionEnds
	 */
	public List<ConnectionEnd> getInstantiableConnectionEndsBetween(Connection sourceInstance, Connection tragetInstance);
	
	/**
	 * Searches for all instantiable connectionEnds between sourceInstance and targetInstance
	 * 
	 * @param sourceInstance The source of the connectionEnd
	 * @param targetInstance The target of the connectionEnd
	 * 
	 * @return A list of all instantiable connectionEnds
	 */
	public List<ConnectionEnd> getInstantiableConnectionEndsBetween(Connection sourceInstance, Entity targetInstance);

}
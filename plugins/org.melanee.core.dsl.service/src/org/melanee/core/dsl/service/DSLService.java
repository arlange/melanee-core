/*******************************************************************************
 * Copyright (c) 2011 - 2013  University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Ralph Gerbig - initial API and implementation and initial documentation
 *******************************************************************************/
package org.melanee.core.dsl.service;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ParserException;
import org.melanee.core.common.emf.ocl.OCLHelper;
import org.melanee.core.emf.EMFReflectionHelper;
import org.melanee.core.models.plm.PLM.Clabject;
import org.melanee.core.models.plm.PLM.Connection;
import org.melanee.core.models.plm.PLM.Entity;
import org.melanee.core.models.plm.PLM.ConnectionEnd;
import org.melanee.core.workbench.interfaces.IDSLService;

public class DSLService implements IDSLService {
	// returns all connections between source and target assuming that source is a supertype of target (if there is an inheritance relationship between the two entities)
	private List<Connection> getInstantiableConnectionsBetween(Entity sourceInstance, List<Clabject> sourceTypes, List<Clabject> targetTypes) throws ParserException {
		List<Connection> result = new LinkedList<Connection>();

		//Also subtypes need to be taken into account maybe it is connected to something that is subtype of the destination
		EList<Connection> sourceConnections = new BasicEList<Connection>((HashSet<Connection>)OCLHelper.execute(sourceInstance, "self.getLevelTypes().getConnections()->asSet()"));
			
		//Look for all connections that contain a type of the target instance
		for (Connection obj : sourceConnections){
			//OCL here because getParticipants does not return duplicates
			EList<EObject> participants = new BasicEList<EObject>((List<EObject>)OCLHelper.execute(obj, "self.connectionEnd.destination->union(self.connectionEnd.destination.getSubtypes())->asSequence()"));
				
			//Delete the source only once
			for (EObject sourceType : sourceTypes)
			{
				for (int i = 0; i < participants.size(); i++)
					if (participants.get(i).equals(sourceType))
					{
						participants.remove(i);
						break;
					}
			}
				
			for (EObject participant : participants)
				//participant is in targetType => suitable connection found
				if (targetTypes.contains(participant))
				{
					result.add(obj);
					
					// add all subtypes of connection 'obj'
					EList<Connection> subConnections = new BasicEList<Connection>((HashSet<Connection>)OCLHelper.execute(obj, "self.getSubtypes()"));
					for(Connection conn : subConnections)
						if(!result.contains(conn))
							result.add(conn);
					
					break;
				}
		}
		
		return result;
	}
	
	@Override
	public List<Connection> getInstantiableConnectionsBetween(
			Entity sourceInstance, Entity targetInstance){
		List<Connection> result = new LinkedList<Connection>();
		
		try {
			List<Clabject> sourceTypes = sourceInstance.getLevelTypes();			
			List<Clabject> targetTypes = targetInstance.getLevelTypes();
			
			//Only applied if both are instances
			if (sourceTypes.size() < 1 || targetTypes.size() < 1)
				return result;
			
			result = getInstantiableConnectionsBetween(sourceInstance, sourceTypes, targetTypes);
			List<Connection> other = getInstantiableConnectionsBetween(targetInstance, targetTypes, sourceTypes);
			
			// add connections found by traversing the inheritance hierarchy from target (instead of source) if they are not in 'result' already
			for(Connection c : other) {
				if(!result.contains(c))
					result.add(c);
			}
			
		} catch (ParserException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<Connection> getInstantiableConnectionsBetween(
			Connection sourceInstance, Connection targetInstance) {
		return null;
	}

	@Override
	public List<Connection> getInstantiableConnectionsBetween(
			Connection sourceInstance, Entity targetInstance) {
		return new LinkedList<Connection>();
	}

	@Override
	public List<Connection> getInstantiableConnectionsBetween(
			Entity sourceInstance, Connection targetInstance) {
		return null;
	}

	@Override
	public List<ConnectionEnd> getInstantiableConnectionEndsBetween(Connection sourceInstance,
			Connection tragetInstance) {
		return null;
	}

	@Override
	public List<ConnectionEnd> getInstantiableConnectionEndsBetween(Connection sourceInstance,
			Entity targetInstance) {
		EList<ConnectionEnd> connectionEnds = new BasicEList<ConnectionEnd>();
		EList<EObject> targetTypes = new BasicEList<EObject>();
		EList<Connection> sourceConnectionTypes = new BasicEList<Connection>();
		
		try {
			sourceConnectionTypes = (EList<Connection>)EMFReflectionHelper.executeOperation(sourceInstance, "getLevelTypes");
			targetTypes = (EList<EObject>)EMFReflectionHelper.executeOperation(targetInstance, "getLevelTypes");
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (ParserException e) {
			e.printStackTrace();
		}
		
		//Only applied if both are instances
		if (sourceConnectionTypes.size() < 1 || targetTypes.size() < 1)
			return connectionEnds;
		
		for (Connection connectionType : sourceConnectionTypes){
			for (ConnectionEnd r : connectionType.getConnectionEnd())
				if (targetTypes.contains(r.getDestination()))
					connectionEnds.add(r);
		}
		return connectionEnds;
	}
}

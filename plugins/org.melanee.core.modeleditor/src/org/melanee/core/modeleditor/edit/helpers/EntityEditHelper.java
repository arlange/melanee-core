/*
 * *******************************************************************************
 * Copyright (c) 2011 - 2015 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Ralph Gerbig - initial API and implementation and initial documentation
 * *******************************************************************************
 */
package org.melanee.core.modeleditor.edit.helpers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.ocl.ParserException;
import org.melanee.core.common.emf.ocl.OCLHelper;
import org.melanee.core.models.links.links.Link;
import org.melanee.core.models.plm.PLM.Clabject;
import org.melanee.core.models.plm.PLM.Classification;
import org.melanee.core.models.plm.PLM.Connection;
import org.melanee.core.models.plm.PLM.Element;
import org.melanee.core.models.plm.PLM.Inheritance;

/**
 * @generated
 */
public class EntityEditHelper extends PLMBaseEditHelper {

	/**
	 * This method is responsible to clean up all elements to 
	 * which the deleted elment is connected. 
	 *
	 * These include
	 * - Inheritance, Connection and Classification
	 * - Links to remote model elements
	 *
	 */
	@Override
	protected ICommand getDestroyElementCommand(DestroyElementRequest req) {

		CompositeCommand compoundCmd = new CompositeCommand("Delete Clabject and Dependents");

		//************************************************
		// Delete link to remote model
		//************************************************
		ICommand destroyRemoteLinkCommand = getDeleteRemoteLinkCommand(req);
		if (destroyRemoteLinkCommand != null)
			compoundCmd.add(destroyRemoteLinkCommand);

		if (!(req.getElementToDestroy() instanceof Clabject))
			return super.getDestroyElementCommand(req);

		//************************************************
		// Delete Inheritance, Connection, Classification
		//************************************************
		Clabject destroyedClabject = (Clabject) req.getElementToDestroy();

		List<Classification> classificationsToDestroy = new ArrayList<Classification>();
		classificationsToDestroy.addAll(destroyedClabject.getClassificationsAsInstance());
		classificationsToDestroy.addAll(destroyedClabject.getClassificationsAsType());

		//*****************************************************
		// Destroy the connections in case
		// that they are not having more than one other
		// participant
		//*****************************************************
		for (Connection connectionToDestroy : destroyedClabject.getDefinedConnections()) {

			if (connectionToDestroy.getConnectionEnd().size() > 2)
				continue;

			DestroyElementRequest dr = new DestroyElementRequest(false);
			dr.setClientContext(req.getClientContext());
			dr.setEditingDomain(req.getEditingDomain());
			dr.setElementToDestroy(connectionToDestroy);
			dr.setLabel("Delete Connection");
			compoundCmd.add(new DestroyElementCommand(dr));

			classificationsToDestroy.addAll(connectionToDestroy.getClassificationsAsInstance());
			classificationsToDestroy.addAll(connectionToDestroy.getClassificationsAsType());
		}

		//*****************************************************
		// Delete the classifications
		//*****************************************************
		for (Classification classificationToDestroy : classificationsToDestroy) {
			DestroyElementRequest dr = new DestroyElementRequest(false);
			dr.setClientContext(req.getClientContext());
			dr.setEditingDomain(req.getEditingDomain());
			dr.setElementToDestroy(classificationToDestroy);
			dr.setLabel("Delete Classification from "
					+ (classificationToDestroy.getInstance().getName() != null
							? classificationToDestroy.getInstance().getName() : "")
					+ " to " + (classificationToDestroy.getType().getName() != null
							? classificationToDestroy.getType().getName() : ""));
			compoundCmd.add(new DestroyElementCommand(dr));
		}

		//*****************************************************
		// Destroy the generalizations in case
		// that they are not having more than one other
		// participant
		//*****************************************************
		for (Inheritance inheritanceToDestroy : destroyedClabject.getDefinedInheritances()) {

			if ((inheritanceToDestroy.getSubtype().size() + inheritanceToDestroy.getSupertype().size()) > 2)
				continue;

			DestroyElementRequest dr = new DestroyElementRequest(false);
			dr.setClientContext(req.getClientContext());
			dr.setEditingDomain(req.getEditingDomain());
			dr.setElementToDestroy(inheritanceToDestroy);
			dr.setLabel("Delete inheritance");
			compoundCmd.add(new DestroyElementCommand(dr));
		}

		//Delete the model element itself
		DestroyElementCommand cmd = new DestroyElementCommand(req);
		compoundCmd.add(cmd);

		return compoundCmd;
	}

	/**
	 * Delete the link to remote model element from the deleted model element
	 * 
	 * @param req The request used to delete the model element
	 * @return the command deleting the link or null if no link exists
	 * 
	 * @generated
	 */
	private ICommand getDeleteRemoteLinkCommand(DestroyElementRequest req) {

		//first check if linking model is present
		Resource r = req.getElementToDestroy().eResource();
		if (r.getContents().size() < 3)
			return null;

		//Apply only to PLM elements
		if (!(req.getElementToDestroy() instanceof Element))
			return null;

		Link link = null;

		try {
			link = (Link) OCLHelper.execute(req.getElementToDestroy(),
					"links::Link.allInstances()->select(target = self)->any(true)");
		} catch (ParserException e) {
			e.printStackTrace();
		}

		if (link == null)
			return null;

		DestroyElementRequest dr = new DestroyElementRequest(false);
		dr.setClientContext(req.getClientContext());
		dr.setEditingDomain(req.getEditingDomain());
		dr.setElementToDestroy(link);
		dr.setLabel("Destroy Element Remote Model Link");
		DestroyElementCommand result = new DestroyElementCommand(dr);
		return result;
	}

}

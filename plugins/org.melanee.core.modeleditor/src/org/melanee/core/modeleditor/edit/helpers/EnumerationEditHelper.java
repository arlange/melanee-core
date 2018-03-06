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

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.ocl.ParserException;
import org.melanee.core.common.emf.ocl.OCLHelper;
import org.melanee.core.models.links.links.Link;
import org.melanee.core.models.plm.PLM.Element;

/**
 * @generated
 */
public class EnumerationEditHelper extends PLMBaseEditHelper {

  /**
   * This method is responsible to clean up all elements to which the deleted
   * elment is connected.
   *
   * These include - Inheritance, Connection and Classification - Links to remote
   * model elements
   *
   */
  @Override
  protected ICommand getDestroyElementCommand(DestroyElementRequest req) {

    CompositeCommand compoundCmd = new CompositeCommand("Delete Clabject and Dependents");

    // ************************************************
    // Delete link to remote model
    // ************************************************
    ICommand destroyRemoteLinkCommand = getDeleteRemoteLinkCommand(req);
    if (destroyRemoteLinkCommand != null)
      compoundCmd.add(destroyRemoteLinkCommand);

    // Delete the model element itself
    DestroyElementCommand cmd = new DestroyElementCommand(req);
    compoundCmd.add(cmd);

    return compoundCmd;
  }

  /**
   * Delete the link to remote model element from the deleted model element
   * 
   * @param req
   *          The request used to delete the model element
   * @return the command deleting the link or null if no link exists
   * 
   * @generated
   */
  private ICommand getDeleteRemoteLinkCommand(DestroyElementRequest req) {

    // first check if linking model is present
    Resource r = req.getElementToDestroy().eResource();
    if (r.getContents().size() < 3)
      return null;

    // Apply only to PLM elements
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

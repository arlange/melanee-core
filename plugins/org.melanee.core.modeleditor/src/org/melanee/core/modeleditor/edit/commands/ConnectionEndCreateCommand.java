
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
package org.melanee.core.modeleditor.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.melanee.core.modeleditor.custom.implicitconnection.commands.AbstractImplicitMiddleCreateCommand;
import org.melanee.core.modeleditor.custom.implicitconnection.commands.EObjectAndElementTypeAdapter;
import org.melanee.core.modeleditor.custom.implicitconnection.commands.IElementTypeAwareAdapter;
import org.melanee.core.modeleditor.custom.implicitconnection.policy.ImplicitConnectionGraphicalNodeEditPolicy;
import org.melanee.core.modeleditor.edit.parts.Connection2EditPart;
import org.melanee.core.modeleditor.edit.parts.Connection3EditPart;
import org.melanee.core.modeleditor.edit.parts.ConnectionEditPart;
import org.melanee.core.modeleditor.edit.parts.ConnectionEndEditPart;
import org.melanee.core.modeleditor.providers.ElementInitializers;
import org.melanee.core.modeleditor.providers.PLMElementTypes;
import org.melanee.core.models.plm.PLM.Clabject;
import org.melanee.core.models.plm.PLM.Connection;
import org.melanee.core.models.plm.PLM.ConnectionEnd;
import org.melanee.core.models.plm.PLM.Entity;
import org.melanee.core.models.plm.PLM.Level;
import org.melanee.core.models.plm.PLM.PLMFactory;
import org.melanee.core.models.plm.PLM.Package;

/**
 * @generated
 */
public class ConnectionEndCreateCommand extends AbstractImplicitMiddleCreateCommand {

  /**
   * @generated
   */
  private ConnectionEnd implicitConnectionEnd;

  /**
   * @generated
   */
  private EObject source;

  /**
   * @generated
   */
  private EObject target;

  /**
   * @generated
   */
  public ConnectionEndCreateCommand(CreateRelationshipRequest request, EObject source,
      EObject target) {
    super(request, source, target);

    this.source = source;
    this.target = target;
  }

  /**
   * @generated
   */
  @Override
  protected boolean checkSource(EObject source) {
    // This modification needs to be done to allow tool creation (SWTBot tests)
    // source is alway null in this case.
    return true;
    // return source instanceof org.melanee.core.models.plm.PLM.Connection ||
    // (source instanceof org.melanee.core.models.plm.PLM.Entity && target
    // instanceof org.melanee.core.models.plm.PLM.Entity);
  }

  /**
   * @generated
   */
  @Override
  protected boolean checkTarget(EObject target) {
    // This is null when drawing from connection to entity..
    return true;
  }

  /**
   * 
   * @generated
   */
  @Override
  protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
      throws ExecutionException {

    if (source instanceof Entity && target instanceof Entity)
      return doExecuteWithResultImplicitMiddle(monitor, info);

    ConnectionEnd newElement = PLMFactory.eINSTANCE.createConnectionEnd();
    ((Connection) source).getConnectionEnd().add(newElement);
    newElement.setConnection((Connection) source);
    newElement.setDestination((Clabject) target);

    // *************************************************************
    // BEGIN CUSTOM CODE
    // *************************************************************
    ConnectionEnd typeConnectionEnd = null;
    // Is the connectionEnd created by a DSL tool? -> Initialize values
    if (getRequest()
        .getParameter(ImplicitConnectionGraphicalNodeEditPolicy.DSL_TYPE) instanceof ConnectionEnd
        && (typeConnectionEnd = (ConnectionEnd) getRequest()
            .getParameter(ImplicitConnectionGraphicalNodeEditPolicy.DSL_TYPE)) != null) {

      newElement.setNavigable(typeConnectionEnd.isNavigable());
      newElement.setMoniker(typeConnectionEnd.getMoniker());
      newElement.setLower(typeConnectionEnd.getLower());
      newElement.setUpper(typeConnectionEnd.getUpper());
    }
    // *************************************************************
    // END CUSTOM CODE
    // *************************************************************

    doConfigure(newElement, monitor, info);
    ((CreateElementRequest) getRequest()).setNewElement(newElement);

    return CommandResult.newOKCommandResult(newElement);
  }

  /**
   * @generated
   */
  protected CommandResult doExecuteWithResultImplicitMiddle(IProgressMonitor monitor,
      IAdaptable info) throws ExecutionException {
    super.doExecuteWithResult(monitor, info);

    if (!canExecute()) {
      throw new ExecutionException("Invalid arguments in create link command"); //$NON-NLS-1$
    }

    ConnectionEnd newElement = PLMFactory.eINSTANCE.createConnectionEnd();

    newElement.setDestination((Clabject) source);
    ((Connection) middle).getConnectionEnd().add(newElement);
    newElement.setConnection((Connection) middle);

    ((CreateElementRequest) getRequest()).setNewElement(newElement);

    if (getRequest().getParameter(ImplicitConnectionGraphicalNodeEditPolicy.DSL_TYPE) != null)
      instantiateDSLValues(
          (Connection) getRequest()
              .getParameter(ImplicitConnectionGraphicalNodeEditPolicy.DSL_TYPE),
          (Connection) middle);

    return CommandResult.newOKCommandResult(newElement);
  }

  /**
   * Returns the ConnectionEnd pointing to 'destination'
   *
   * @generated
   */
  private ConnectionEnd getConnectionEndToDestination(Connection connection, Clabject destination) {
    for (ConnectionEnd connectionEnd : connection.getConnectionEnd()) {
      if (connectionEnd.getDestination() == destination)
        return connectionEnd;
    }

    Assert.isTrue(false); // should never be reached, coding error if it is reached
    return null;
  }

  /**
   * Determines whether the connection defined by 'connectionEnds' is directed
   * (i.e. exactly one connectionEnd must be navigable)
   *
   * @generated
   */
  private boolean isDirected(BasicEList<EObject> connectionEnds) {
    Assert.isTrue(connectionEnds.size() == 2);
    return ((ConnectionEnd) connectionEnds.get(0))
        .isNavigable() != ((ConnectionEnd) connectionEnds.get(1)).isNavigable();
  }

  /**
   * Returns the correct connectionEnd for 'instance' based on type checking.
   * Returns null if no connectionEnd fits (should never happen) or the type
   * checking results are ambiguous.
   *
   * @generated
   */
  private ConnectionEnd getConnectionEndBasedOnType(BasicEList<EObject> connectionEnds,
      Clabject instance) {
    ConnectionEnd result = null;

    for (EObject _connectionEnd : connectionEnds) {
      ConnectionEnd connectionEnd = (ConnectionEnd) _connectionEnd;
      Clabject type = connectionEnd.getDestination();
      if (instance.isInstanceOf(type)) {
        if (result == null)
          result = connectionEnd;
        else
          return null; // more than one connectionEnd fits based on type, result is ambiguous
      }
    }

    return result;
  }

  /**
   * Returns the correct connectionEnd based on the direction. Should only be
   * called if isDirected(connectionEnds) is true.
   *
   * @generated
   */
  private ConnectionEnd getConnectionEndBasedOnDirection(BasicEList<EObject> connectionEnds,
      boolean navigable) {
    Assert.isTrue(connectionEnds.size() == 2);

    for (EObject _connectionEnd : connectionEnds) {
      ConnectionEnd connectionEnd = (ConnectionEnd) _connectionEnd;
      if (connectionEnd.isNavigable() == navigable)
        return connectionEnd;
    }

    Assert.isTrue(false); // should never be reached, coding error if it is reached
    return null;
  }

  /**
   * Returns the element from 'connectionEnds' which is not 'connectionEnd'
   * (assumes there are only two elements in the list)
   *
   * @generated
   */
  private ConnectionEnd getComplementaryConnectionEnd(BasicEList<EObject> connectionEnds,
      ConnectionEnd connectionEnd) {
    Assert.isTrue(connectionEnds.size() == 2);
    return (connectionEnds.get(0) == connectionEnd ? (ConnectionEnd) connectionEnds.get(1)
        : (ConnectionEnd) connectionEnds.get(0));
  }

  /**
   * @generated
   */
  private void instantiateDSLValues(Connection typeConnection, Connection instanceConnection) {
    // At first set up the instance connection
    PLMFactory.eINSTANCE.configureClabject(typeConnection, instanceConnection, null);

    BasicEList<EObject> typeConnectionEnds = new BasicEList<EObject>(
        typeConnection.getAllConnectionEnd());
    ConnectionEnd[] typeConnectionEnd = new ConnectionEnd[2]; // right now the graphical editor only
                                                              // allows to create a new connection
                                                              // between exactly two entities in a
                                                              // single user action

    // try to find the proper connectionEnd mappings based on type
    typeConnectionEnd[0] = getConnectionEndBasedOnType(typeConnectionEnds, (Clabject) source);
    typeConnectionEnd[1] = getConnectionEndBasedOnType(typeConnectionEnds, (Clabject) target);

    if ((typeConnectionEnd[0] == null || typeConnectionEnd[1] == null)
        && typeConnectionEnds.size() != 2)
      throw new RuntimeException(
          "Cannot instantiate new connection: too many connectionEnds with ambiguous types");

    // fix mappings in case of ambiguity
    if (typeConnectionEnd[0] == null && typeConnectionEnd[1] == null) {
      if (isDirected(typeConnectionEnds)) { // type checking results are entirely ambiguous, try to
                                            // use direction as criterion
        typeConnectionEnd[0] = getConnectionEndBasedOnDirection(typeConnectionEnds, false);
        typeConnectionEnd[1] = getConnectionEndBasedOnDirection(typeConnectionEnds, true);
      } else {
        // last resort: mapping based on list order because all other criteria failed
        typeConnectionEnd[0] = (ConnectionEnd) typeConnectionEnds.get(0);
        typeConnectionEnd[1] = (ConnectionEnd) typeConnectionEnds.get(1);
      }
    } else if (typeConnectionEnd[0] == null && typeConnectionEnd[1] != null) { // only the result of
                                                                               // one type check is
                                                                               // ambiguous
      typeConnectionEnd[0] = getComplementaryConnectionEnd(typeConnectionEnds,
          typeConnectionEnd[1]);
    } else if (typeConnectionEnd[0] != null && typeConnectionEnd[1] == null) {
      typeConnectionEnd[1] = getComplementaryConnectionEnd(typeConnectionEnds,
          typeConnectionEnd[0]);
    }

    // set values of newly created connectionEnds based on the mapping just created
    for (int i = 0; i < typeConnectionEnds.size(); ++i) {
      Clabject destination = (Clabject) (i == 0 ? source : target);
      ConnectionEnd instanceConnectionEnd = getConnectionEndToDestination(instanceConnection,
          destination);

      instanceConnectionEnd.setMoniker(typeConnectionEnd[i].getMoniker());
      instanceConnectionEnd.setLower(typeConnectionEnd[i].getLower());
      instanceConnectionEnd.setNavigable(typeConnectionEnd[i].isNavigable());
      instanceConnectionEnd.setUpper(typeConnectionEnd[i].getUpper());
      instanceConnectionEnd.setKind(typeConnectionEnd[i].getKind());
      instanceConnectionEnd.setType(typeConnectionEnd[i]);
    }
  }

  /**
   * @generated
   */
  @Override
  protected IElementTypeAwareAdapter createSemanticMiddle(IProgressMonitor monitor, IAdaptable info)
      throws ExecutionException {

    EObject container = (EObject) info.getAdapter(EObject.class);
    IElementTypeAwareAdapter result = null;

    // The Container is an entity
    if (container instanceof Entity) {
      Connection c = PLMFactory.eINSTANCE.createConnection();
      result = new EObjectAndElementTypeAdapter(c, PLMElementTypes.Connection_3111,
          Connection2EditPart.VISUAL_ID);
      invokeDefaultElementTypeConfiguration(result, monitor, info);
      ElementInitializers.getInstance().init_Connection_3111(c);
    }
    // The container is a package
    else if (container instanceof Package) {
      Connection c = PLMFactory.eINSTANCE.createConnection();
      result = new EObjectAndElementTypeAdapter(c, PLMElementTypes.Connection_3127,
          Connection3EditPart.VISUAL_ID);
      invokeDefaultElementTypeConfiguration(result, monitor, info);
      ElementInitializers.getInstance().init_Connection_3127(c);
    }
    // The container is a model
    else if (container instanceof Level) {
      Connection c = PLMFactory.eINSTANCE.createConnection();
      result = new EObjectAndElementTypeAdapter(c, PLMElementTypes.Connection_3099,
          ConnectionEditPart.VISUAL_ID);
      invokeDefaultElementTypeConfiguration(result, monitor, info);
      ElementInitializers.getInstance().init_Connection_3099(c);
    } else
      throw new RuntimeException("Not implemented for container!");

    return result;
  }

  /**
   * @generated
   */
  @Override
  protected IElementTypeAwareAdapter createImplicitTargetLink(IProgressMonitor monitor,
      IAdaptable info) throws ExecutionException {

    implicitConnectionEnd = PLMFactory.eINSTANCE.createConnectionEnd();
    return new EObjectAndElementTypeAdapter(implicitConnectionEnd,
        PLMElementTypes.ConnectionEnd_4036, ConnectionEndEditPart.VISUAL_ID);
  }

  /**
   * @generated
   */
  @Override
  protected void setupSemanticConnections(EObject source, IElementTypeAwareAdapter middle,
      EObject target) {

    Connection connection = (Connection) middle.getAdapter(EObject.class);

    implicitConnectionEnd.setDestination((Clabject) target);
    connection.getConnectionEnd().add(implicitConnectionEnd);
    implicitConnectionEnd.setConnection(connection);

    if (connection.eContainer() == null) {
      if (source.eContainer() instanceof Level)
        ((Level) source.eContainer()).getContent().add(connection);
      else if (source.eContainer() instanceof Clabject)
        ((Clabject) source.eContainer()).getContent().add(connection);
      else if (source.eContainer() instanceof Package)
        ((Package) source.eContainer()).getContent().add(connection);
      else
        throw new RuntimeException("Not implemented for container!");
    }
  }

  /**
   * @generated
   */
  protected void doConfigure(ConnectionEnd newElement, IProgressMonitor monitor, IAdaptable info)
      throws ExecutionException {
    IElementType elementType = ((CreateElementRequest) getRequest()).getElementType();
    ConfigureRequest configureRequest = new ConfigureRequest(getEditingDomain(), newElement,
        elementType);
    configureRequest.setClientContext(((CreateElementRequest) getRequest()).getClientContext());
    configureRequest.addParameters(getRequest().getParameters());
    configureRequest.setParameter(CreateRelationshipRequest.SOURCE, source);
    configureRequest.setParameter(CreateRelationshipRequest.TARGET, target);
    ICommand configureCommand = elementType.getEditCommand(configureRequest);
    if (configureCommand != null && configureCommand.canExecute()) {
      configureCommand.execute(monitor, info);
    }
  }
}

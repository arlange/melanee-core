/*******************************************************************************
 * Copyright (c) 2012 University of Mannheim: Chair for Software Engineering
 * and others All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev - initial API and implementation and initial documentation
 *    Ralph Gerbig    - extension
 *******************************************************************************/
package org.melanee.core.modeleditor.custom.implicitconnection.policy;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.commands.SetConnectionAnchorsCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.SetConnectionEndsCommand;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateOrSelectElementCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SemanticCreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeConnectionRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.MetamodelType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.widgets.Display;
import org.melanee.core.models.plm.PLM.Clabject;
import org.melanee.core.models.plm.PLM.Connection;
import org.melanee.core.models.plm.PLM.Entity;
import org.melanee.core.models.plm.PLM.ConnectionEnd;
import org.melanee.core.workbench.ExtensionPointService;

/**
 * Inherited GraphicalNodeEditPolicy that does the following: <br />
 * 
 * <ul>
 * <li>Enable advanced link creation (two connectionEnds + connection with one
 * line)</li>
 * <li>Modifies the content of the displayed popup menu when drawing a
 * connection</li>
 * </ul>
 *
 */
public class ImplicitConnectionGraphicalNodeEditPolicy extends GraphicalNodeEditPolicy {

  public static final String DISPLAY_NAME = "DisplayName";
  // The linguistic meta-model type e.g. ConnectionEnd
  public static final String ELEMENT_TYPE = "ElementType";
  // The ontologic meta-model type
  public static final String DSL_TYPE = "DSL_TYPE";

  protected class PromptAndCreateConnectionCommand extends CreateOrSelectElementCommand {

    /**
     * Cache the request because it needs to be passed to
     * {@link #getCommandForMenuSelection(Object, CreateConnectionRequest)}.
     */
    private CreateConnectionRequest request;

    /**
     * Creates a new instance.
     * 
     * @param content
     *          The list of items making up the content of the popup menu.
     * @param request
     *          The relevant create connection request.
     */
    public PromptAndCreateConnectionCommand(List content, CreateConnectionRequest request) {
      super(CREATE_CONNECTION_COMMAND_LABEL, Display.getCurrent().getActiveShell(), content);
      this.request = request;
    }

    /**
     * The command to create the connection that may need to be undone/redone.
     */
    private Command createCommand;

    /**
     * Pops up the dialog with the content provided, gets the command to be executed
     * based on the user selection, and then executes the command.
     */
    @Override
    protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info)
        throws ExecutionException {

      CommandResult cmdResult = super.doExecuteWithResult(progressMonitor, info);
      if (!cmdResult.getStatus().isOK()) {
        return cmdResult;
      }

      Object connectionType = (cmdResult.getReturnValue() instanceof IElementType)
          ? cmdResult.getReturnValue()
          : ((Request) cmdResult.getReturnValue()).getExtendedData().get(ELEMENT_TYPE);

      if (cmdResult.getReturnValue() instanceof Request)
        getRequest().getExtendedData().put(DSL_TYPE,
            ((Request) cmdResult.getReturnValue()).getExtendedData().get(DSL_TYPE));

      Command cmd = getConnectionCompleteCommand(connectionType, getRequest());

      Assert.isTrue(cmd != null && cmd.canExecute());
      cmd.execute();
      createCommand = cmd;

      if (connectionType instanceof IElementType) {
        CreateRequest createRequest = ((CreateUnspecifiedTypeConnectionRequest) request)
            .getRequestForType((IElementType) connectionType);

        Object newObject = createRequest.getNewObject();

        return CommandResult.newOKCommandResult(newObject);
      }
      return CommandResult.newOKCommandResult();
    }

    @Override
    protected CommandResult doUndoWithResult(IProgressMonitor progressMonitor, IAdaptable info)
        throws ExecutionException {
      if (createCommand != null) {
        createCommand.undo();
      }
      return super.doUndoWithResult(progressMonitor, info);
    }

    @Override
    protected CommandResult doRedoWithResult(IProgressMonitor progressMonitor, IAdaptable info)
        throws ExecutionException {
      if (createCommand != null) {
        createCommand.redo();
      }
      return super.doRedoWithResult(progressMonitor, info);
    }

    /**
     * Gets the request.
     * 
     * @return Returns the request.
     */
    private CreateConnectionRequest getRequest() {
      return request;
    }
  }

  /**
   * The label used for the command to create a new connection.
   */
  private static final String CREATE_CONNECTION_COMMAND_LABEL = DiagramUIMessages.GraphicalNodeEditPolicy_createRelationshipCommand_label;

  // /**
  // * Diagrams that install modified edit policy for
  // * {@link org.eclipse.gef.EditPolicy#GRAPHICAL_NODE_ROLE} also require to
  // * install it into all default nodes, normally created outside the diagram
  // * plugin.
  // *
  // * @see #315953
  // */
  // public static class ITMNoteEditPart extends NoteEditPart {
  //
  // public ITMNoteEditPart(View view) {
  // super(view);
  // }
  //
  // protected void createDefaultEditPolicies() {
  // super.createDefaultEditPolicies();
  //
  // removeEditPolicy(org.eclipse.gef.EditPolicy.GRAPHICAL_NODE_ROLE);
  // installEditPolicy(org.eclipse.gef.EditPolicy.GRAPHICAL_NODE_ROLE,
  // new ImplicitConnectionGraphicalNodeEditPolicy());
  //
  // }
  // }

  public ImplicitConnectionGraphicalNodeEditPolicy() {
    super();
  }

  @Override
  protected Command getConnectionCreateCommand(CreateConnectionRequest request) {
    if (!(request instanceof CreateConnectionViewRequest)) {
      return null;
    }

    CreateConnectionViewRequest req = (CreateConnectionViewRequest) request;
    TransactionalEditingDomain editingDomain = getHostImpl().getEditingDomain();

    ImplicitConnectionCreateLinkCommand result = new ImplicitConnectionCreateLinkCommand(
        editingDomain, getHostImpl().getDiagramPreferencesHint());
    result.setSourceParameters(computeParameters(request));
    result.registerInRequest(request);

    Diagram diagramView = getView().getDiagram();

    CreateCommand createCommand = new CreateCommand(editingDomain,
        req.getConnectionViewDescriptor(), diagramView);
    result.setEdgeCreation(createCommand);

    IAdaptable edgeAdaptor = (IAdaptable) createCommand.getCommandResult().getReturnValue();
    result.setEdgeAdapter(edgeAdaptor);

    SetConnectionEndsCommand sceCommand = result.getSetConnectionEndsCommand();
    sceCommand.setNewSourceAdaptor(new EObjectAdapter(getView()));
    ConnectionAnchor sourceAnchor = getConnectableEditPart().getSourceConnectionAnchor(request);

    SetConnectionAnchorsCommand scaCommand = result.getSetConnectionAnchorsCommand();
    scaCommand
        .setNewSourceTerminal(getConnectableEditPart().mapConnectionAnchorToTerminal(sourceAnchor));

    Command c = new ICommandProxy(result);
    request.setStartCommand(c);

    return c;
  }

  @Override
  protected INodeEditPart getConnectableEditPart() {
    return getHost() instanceof INodeEditPart ? (INodeEditPart) getHost() : null;
  }

  @Override
  @SuppressWarnings("restriction")
  protected Command getConnectionCompleteCommand(CreateConnectionRequest request) {
    if (request.getStartCommand() != null && !(((ICommandProxy) request.getStartCommand())
        .getICommand() instanceof ImplicitConnectionCreateLinkCommand))
      return super.getConnectionCompleteCommand(request);

    ImplicitConnectionCreateLinkCommand cc = unwrapStartCommand(request);
    if (cc == null) {
      return null;
    }

    // reset the target edit-part for the request
    INodeEditPart targetEP = getConnectionCompleteEditPart(request);
    if (targetEP == null) {
      return null;
    }

    ConnectionAnchor targetAnchor = targetEP.getTargetConnectionAnchor(request);
    SetConnectionEndsCommand sceCommand = cc.getSetConnectionEndsCommand();
    sceCommand
        .setNewTargetAdaptor(new EObjectAdapter(((IGraphicalEditPart) targetEP).getNotationView()));

    SetConnectionAnchorsCommand scaCommand = cc.getSetConnectionAnchorsCommand();
    scaCommand.setNewTargetTerminal(targetEP.mapConnectionAnchorToTerminal(targetAnchor));

    INodeEditPart sourceEditPart = (INodeEditPart) request.getSourceEditPart();
    // FIX: This works with the connection fixed anchors
    ConnectionAnchor sourceAnchor = sourceEditPart.getSourceConnectionAnchor(request);
    // .mapTerminalToConnectionAnchor(scaCommand
    // .getNewSourceTerminal());
    PointList pointList = new PointList();
    if (request.getLocation() == null) {
      pointList.addPoint(sourceAnchor.getLocation(targetAnchor.getReferencePoint()));
      pointList.addPoint(targetAnchor.getLocation(sourceAnchor.getReferencePoint()));
    } else {
      pointList.addPoint(sourceAnchor.getLocation(request.getLocation()));
      pointList.addPoint(targetAnchor.getLocation(request.getLocation()));
    }

    cc.getSetConnectionBendpointsCommand().setNewPointList(pointList,
        sourceAnchor.getReferencePoint(), targetAnchor.getReferencePoint());
    return request.getStartCommand();
  }

  @Override
  protected Command getConnectionAndRelationshipCompleteCommand(
      CreateConnectionViewAndElementRequest request) {
    if (request.getStartCommand() != null && !(((ICommandProxy) request.getStartCommand())
        .getICommand() instanceof ImplicitConnectionCreateLinkCommand))
      return super.getConnectionAndRelationshipCompleteCommand(request);

    // get the element descriptor
    CreateElementRequestAdapter requestAdapter = request.getConnectionViewAndElementDescriptor()
        .getCreateElementRequestAdapter();
    // get the semantic request
    CreateRelationshipRequest createElementRequest = (CreateRelationshipRequest) requestAdapter
        .getAdapter(CreateRelationshipRequest.class);

    createElementRequest.setPrompt(!request.isUISupressed());

    // complete the semantic request by filling in the source and
    // destination
    INodeEditPart targetEP = getConnectionCompleteEditPart(request);
    View sourceView = (View) request.getSourceEditPart().getModel();
    View targetView = (View) targetEP.getModel();

    // resolve the source
    EObject source = ViewUtil.resolveSemanticElement(sourceView);
    if (source == null) {
      source = sourceView;
    }

    createElementRequest.setSource(source);

    // resolve the target
    EObject target = ViewUtil.resolveSemanticElement(targetView);
    if (target == null) {
      target = targetView;
    }
    createElementRequest.setTarget(target);

    ImplicitConnectionCreateParametersImpl computeParameters = computeParameters(request);
    ImplicitConnectionCreateLinkCommand unwrapStartCommand = unwrapStartCommand(request);

    if (null != unwrapStartCommand && computeParameters != null) {
      unwrapStartCommand.setTargetParameters(computeParameters);
    }

    Command createElementCommand = targetEP.getCommand(//
        new EditCommandRequestWrapper(//
            (CreateRelationshipRequest) requestAdapter.getAdapter(CreateRelationshipRequest.class), //
            request.getExtendedData()));

    // create the create semantic element wrapper command
    if (null == createElementCommand) {
      return null;
    }

    SemanticCreateCommand semanticCommand = new SemanticCreateCommand(requestAdapter,
        createElementCommand);

    // get the view command
    ICommandProxy result = (ICommandProxy) getConnectionCompleteCommand(request);
    if (null == result) {
      return null;
    }

    ImplicitConnectionCreateLinkCommand viewCommandImpl = (ImplicitConnectionCreateLinkCommand) result
        .getICommand();

    // set semantic creation to be executed before edge creation and setup
    viewCommandImpl.setSemanticCreation(semanticCommand);

    return result;
  }

  @Override
  protected Command getConnectionCompleteCommand(Object connectionType,
      CreateConnectionRequest request) {
    if (connectionType instanceof IElementType) {
      if (request instanceof CreateUnspecifiedTypeConnectionRequest) {
        CreateRequest createRequest = ((CreateUnspecifiedTypeConnectionRequest) request)
            .getRequestForType((IElementType) connectionType);

        // This modification is needed to put the DSL type into the request which is
        // used for connection and connectionEnd creation
        if (request.getExtendedData().get(DSL_TYPE) != null)
          createRequest.getExtendedData().put(DSL_TYPE, request.getExtendedData().get(DSL_TYPE));

        if (createRequest != null) {
          return getHost().getCommand(createRequest);
        }
      }
    }
    return null;
  }

  private IGraphicalEditPart getHostImpl() {
    return (IGraphicalEditPart) getHost();
  }

  protected ImplicitConnectionCreateLinkCommand unwrapStartCommand(
      CreateConnectionRequest request) {
    ICommandProxy proxy = (ICommandProxy) request.getStartCommand();
    if (proxy == null) {
      return null;
    }
    return (ImplicitConnectionCreateLinkCommand) proxy.getICommand();
  }

  protected ImplicitConnectionCreateParametersImpl computeParameters(
      CreateConnectionRequest request) {
    ImplicitConnectionCreateParametersImpl parameters = new ImplicitConnectionCreateParametersImpl();
    parameters.setParentView(getHostImpl().getNotationView());

    if (request.getLocation() != null) {
      IFigure hostContentPane = getHostImpl().getContentPane();
      Point origin;
      if (hostContentPane.getLayoutManager() instanceof XYLayout) {
        origin = ((XYLayout) hostContentPane.getLayoutManager()).getOrigin(hostContentPane);
      } else {
        origin = hostContentPane.getClientArea().getLocation();
      }
      Point relativeLocation = new Point(request.getLocation());
      hostContentPane.translateToRelative(relativeLocation);
      relativeLocation.translate(origin.getNegated());
      parameters.setRelativeLocation(relativeLocation);
    }

    return parameters;
  }

  /**
   * 
   * <p>
   * Takes care that all possible DSL connections are listed when creating a
   * connection at instance level.
   * </p>
   * 
   * <p>
   * <b>Must be refactored to get rid of reflective API. May this must be abstract
   * and implemented in plugin.</b>
   * </p>
   */
  @Override
  protected List getConnectionMenuContent(CreateConnectionRequest request) {

    // This is specialized for ConnectionEnds
    if (request instanceof CreateUnspecifiedTypeConnectionRequest) {
      List result = super.getConnectionMenuContent(request);

      try {
        EObject source = ((IGraphicalEditPart) request.getSourceEditPart())
            .resolveSemanticElement();
        EObject target = ((IGraphicalEditPart) request.getTargetEditPart())
            .resolveSemanticElement();

        // Only applyed if a Clabject is connected to an Clabject as only these
        // can have types for instantiation.
        if (!(source instanceof Clabject) || !(target instanceof Clabject))
          return super.getConnectionMenuContent(request);

        List<Connection> connections = new LinkedList<Connection>();
        List<ConnectionEnd> connectionEnds = new LinkedList<ConnectionEnd>();

        if (source instanceof Entity && target instanceof Entity)
          connections = ExtensionPointService.Instance().getActiveDSLService()
              .getInstantiableConnectionsBetween((Entity) source, (Entity) target);
        else if (source instanceof Connection && target instanceof Entity) {
          connectionEnds = ExtensionPointService.Instance().getActiveDSLService()
              .getInstantiableConnectionEndsBetween((Connection) source, (Entity) target);
          connections = ExtensionPointService.Instance().getActiveDSLService()
              .getInstantiableConnectionsBetween((Connection) source, (Entity) target);
        }
        // else
        // return super.getConnectionMenuContent(request);

        // Go for the connections
        if (connections.size() > 0) {
          IElementType elementType = null;
          for (IElementType type : (List<IElementType>) ((CreateUnspecifiedTypeConnectionRequest) request)
              .getElementTypes())
            if (type.toString().contains("ConnectionEnd"))
              elementType = type;

          for (Connection connection : connections) {
            // Here we do only create the captions
            Request clone = cloneRequest((CreateUnspecifiedTypeConnectionRequest) request);

            clone.getExtendedData().put(DISPLAY_NAME, connection.getHumanReadableName());

            clone.getExtendedData().put(DSL_TYPE, connection);
            clone.getExtendedData().put(ELEMENT_TYPE, elementType);
            result.add(clone);
          }
        }

        // Go for the connectionEnds
        if (connectionEnds.size() > 0) {
          IElementType elementType = null;
          for (IElementType type : (List<IElementType>) ((CreateUnspecifiedTypeConnectionRequest) request)
              .getElementTypes())
            if (type.toString().contains("ConnectionEnd"))
              elementType = type;

          for (ConnectionEnd r : connectionEnds) {
            // Here we do only create the captions
            Request clone = cloneRequest((CreateUnspecifiedTypeConnectionRequest) request);
            clone.getExtendedData().put(DISPLAY_NAME, r.getHumanReadableConnectionEndName());
            clone.getExtendedData().put(DSL_TYPE, r);
            clone.getExtendedData().put(ELEMENT_TYPE, elementType);
            result.add(clone);
          }
        }

        // We should also over to create a connection between two connections
        if (source instanceof Connection && target instanceof Connection) {
          IElementType elementType = null;
          for (IElementType type : (List<IElementType>) ((CreateUnspecifiedTypeConnectionRequest) request)
              .getElementTypes())
            if (type.toString().contains("ConnectionEnd"))
              elementType = type;

          Request clone = cloneRequest((CreateUnspecifiedTypeConnectionRequest) request);
          clone.getExtendedData().put(DISPLAY_NAME, "Create Connection");
          clone.getExtendedData().put(ELEMENT_TYPE, elementType);
          result.add(clone);
        }

        return result;

      } catch (CoreException e) {
        e.printStackTrace();
      }
    }

    return super.getConnectionMenuContent(request);
  }

  private CreateUnspecifiedTypeConnectionRequest cloneRequest(
      CreateUnspecifiedTypeConnectionRequest request) {
    CreateUnspecifiedTypeConnectionRequest result = new CreateUnspecifiedTypeConnectionRequest(
        request.getElementTypes(), request.useModelingAssistantService(),
        getHostImpl().getDiagramPreferencesHint());
    result.setTargetEditPart(request.getTargetEditPart());
    result.setSourceEditPart(request.getSourceEditPart());
    result.setDirectionReversed(request.isDirectionReversed());

    return result;
  }

  /**
   * This needs to be overridden to provide the right text for the content
   */
  @Override
  protected ICommand getPromptAndCreateConnectionCommand(final List content,
      final CreateConnectionRequest request) {

    return new PromptAndCreateConnectionCommand(content, request) {

      @Override
      protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info)
          throws ExecutionException {
        return super.doExecuteWithResult(progressMonitor, info);
      }

      @Override
      protected ILabelProvider getLabelProvider() {
        return new LabelProvider() {
          @Override
          public String getText(Object object) {
            if (object instanceof Request
                && ((Request) object).getExtendedData().get(DISPLAY_NAME) != null)
              return ((Request) object).getExtendedData().get(DISPLAY_NAME).toString();
            else if (object instanceof MetamodelType
                && ((MetamodelType) object).getDisplayName().equals("ConnectionEnd")
                && content.size() > 1
                && ((IGraphicalEditPart) request.getSourceEditPart())
                    .resolveSemanticElement() instanceof Entity
                && ((IGraphicalEditPart) request.getTargetEditPart())
                    .resolveSemanticElement() instanceof Entity)
              return "Create new Connection";
            return super.getText(object);
          }
        };
      }
    };
  }
}
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
package org.melanee.core.modeleditor.edit.policies;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.DeferredLayoutCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetViewMutabilityCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.UpdaterLinkDescriptor;
import org.melanee.core.modeleditor.edit.parts.Attribute2EditPart;
import org.melanee.core.modeleditor.edit.parts.AttributeEditPart;
import org.melanee.core.modeleditor.edit.parts.ClassificationEditPart;
import org.melanee.core.modeleditor.edit.parts.Connection2EditPart;
import org.melanee.core.modeleditor.edit.parts.Connection3EditPart;
import org.melanee.core.modeleditor.edit.parts.ConnectionEditPart;
import org.melanee.core.modeleditor.edit.parts.ConnectionEndEditPart;
import org.melanee.core.modeleditor.edit.parts.DeepModelEditPart;
import org.melanee.core.modeleditor.edit.parts.DomainEditPart;
import org.melanee.core.modeleditor.edit.parts.Entity2EditPart;
import org.melanee.core.modeleditor.edit.parts.Entity3EditPart;
import org.melanee.core.modeleditor.edit.parts.EntityEditPart;
import org.melanee.core.modeleditor.edit.parts.EnumerationEditPart;
import org.melanee.core.modeleditor.edit.parts.Inheritance2EditPart;
import org.melanee.core.modeleditor.edit.parts.Inheritance3EditPart;
import org.melanee.core.modeleditor.edit.parts.InheritanceEditPart;
import org.melanee.core.modeleditor.edit.parts.LevelEditPart;
import org.melanee.core.modeleditor.edit.parts.Method2EditPart;
import org.melanee.core.modeleditor.edit.parts.MethodEditPart;
import org.melanee.core.modeleditor.edit.parts.Package2EditPart;
import org.melanee.core.modeleditor.edit.parts.PackageEditPart;
import org.melanee.core.modeleditor.edit.parts.SubtypeEditPart;
import org.melanee.core.modeleditor.edit.parts.SupertypeEditPart;
import org.melanee.core.modeleditor.part.PLMDiagramUpdater;
import org.melanee.core.modeleditor.part.PLMLinkDescriptor;
import org.melanee.core.modeleditor.part.PLMNodeDescriptor;
import org.melanee.core.modeleditor.part.PLMVisualIDRegistry;
import org.melanee.core.models.plm.PLM.PLMPackage;

/**
 * @generated
 */
public class DomainCanonicalEditPolicy extends CanonicalEditPolicy {

  /**
   * @generated
   */
  protected void refreshOnActivate() {
    // Need to activate editpart children before invoking the canonical refresh for
    // EditParts to add event listeners
    List<?> c = getHost().getChildren();
    for (int i = 0; i < c.size(); i++) {
      ((EditPart) c.get(i)).activate();
    }
    super.refreshOnActivate();
  }

  /**
   * @generated
   */
  protected EStructuralFeature getFeatureToSynchronize() {
    return PLMPackage.eINSTANCE.getDomain_DeepModel();
  }

  /**
   * @generated
   */
  @SuppressWarnings("rawtypes")

  protected List getSemanticChildrenList() {
    View viewObject = (View) getHost().getModel();
    LinkedList<EObject> result = new LinkedList<EObject>();
    List<PLMNodeDescriptor> childDescriptors = PLMDiagramUpdater
        .getDomain_1000SemanticChildren(viewObject);
    for (PLMNodeDescriptor d : childDescriptors) {
      result.add(d.getModelElement());
    }
    return result;
  }

  /**
   * @generated
   */
  protected boolean isOrphaned(Collection<EObject> semanticChildren, final View view) {
    return isMyDiagramElement(view) && !semanticChildren.contains(view.getElement());
  }

  /**
   * @generated
   */
  private boolean isMyDiagramElement(View view) {
    return DeepModelEditPart.VISUAL_ID == PLMVisualIDRegistry.getVisualID(view);
  }

  /**
   * @generated
   */
  protected void refreshSemantic() {
    if (resolveSemanticElement() == null) {
      return;
    }
    LinkedList<IAdaptable> createdViews = new LinkedList<IAdaptable>();
    List<PLMNodeDescriptor> childDescriptors = PLMDiagramUpdater
        .getDomain_1000SemanticChildren((View) getHost().getModel());
    LinkedList<View> orphaned = new LinkedList<View>();
    // we care to check only views we recognize as ours
    LinkedList<View> knownViewChildren = new LinkedList<View>();
    for (View v : getViewChildren()) {
      if (isMyDiagramElement(v)) {
        knownViewChildren.add(v);
      }
    }
    // alternative to #cleanCanonicalSemanticChildren(getViewChildren(),
    // semanticChildren)
    //
    // iteration happens over list of desired semantic elements, trying to find best
    // matching View, while original CEP
    // iterates views, potentially losing view (size/bounds) information - i.e. if
    // there are few views to reference same EObject, only last one
    // to answer isOrphaned == true will be used for the domain element
    // representation, see #cleanCanonicalSemanticChildren()
    for (Iterator<PLMNodeDescriptor> descriptorsIterator = childDescriptors
        .iterator(); descriptorsIterator.hasNext();) {
      PLMNodeDescriptor next = descriptorsIterator.next();
      String hint = PLMVisualIDRegistry.getType(next.getVisualID());
      LinkedList<View> perfectMatch = new LinkedList<View>(); // both semanticElement and hint match
                                                              // that of NodeDescriptor
      for (View childView : getViewChildren()) {
        EObject semanticElement = childView.getElement();
        if (next.getModelElement().equals(semanticElement)) {
          if (hint.equals(childView.getType())) {
            perfectMatch.add(childView);
            // actually, can stop iteration over view children here, but
            // may want to use not the first view but last one as a 'real' match (the way
            // original CEP does
            // with its trick with viewToSemanticMap inside #cleanCanonicalSemanticChildren
          }
        }
      }
      if (perfectMatch.size() > 0) {
        descriptorsIterator.remove(); // precise match found no need to create anything for the
                                      // NodeDescriptor
        // use only one view (first or last?), keep rest as orphaned for further
        // consideration
        knownViewChildren.remove(perfectMatch.getFirst());
      }
    }
    // those left in knownViewChildren are subject to removal - they are our diagram
    // elements we didn't find match to,
    // or those we have potential matches to, and thus need to be recreated,
    // preserving size/location information.
    orphaned.addAll(knownViewChildren);
    //
    ArrayList<CreateViewRequest.ViewDescriptor> viewDescriptors = new ArrayList<CreateViewRequest.ViewDescriptor>(
        childDescriptors.size());
    for (PLMNodeDescriptor next : childDescriptors) {
      String hint = PLMVisualIDRegistry.getType(next.getVisualID());
      IAdaptable elementAdapter = new CanonicalElementAdapter(next.getModelElement(), hint);
      CreateViewRequest.ViewDescriptor descriptor = new CreateViewRequest.ViewDescriptor(
          elementAdapter, Node.class, hint, ViewUtil.APPEND, false,
          host().getDiagramPreferencesHint());
      viewDescriptors.add(descriptor);
    }

    boolean changed = deleteViews(orphaned.iterator());
    //
    CreateViewRequest request = getCreateViewRequest(viewDescriptors);
    Command cmd = getCreateViewCommand(request);
    if (cmd != null && cmd.canExecute()) {
      SetViewMutabilityCommand.makeMutable(new EObjectAdapter(host().getNotationView())).execute();
      executeCommand(cmd);
      @SuppressWarnings("unchecked")

      List<IAdaptable> nl = (List<IAdaptable>) request.getNewObject();
      createdViews.addAll(nl);
    }
    if (changed || createdViews.size() > 0) {
      postProcessRefreshSemantic(createdViews);
    }

    Collection<IAdaptable> createdConnectionViews = refreshConnections();

    if (createdViews.size() > 1) {
      // perform a layout of the container
      DeferredLayoutCommand layoutCmd = new DeferredLayoutCommand(host().getEditingDomain(),
          createdViews, host());
      executeCommand(new ICommandProxy(layoutCmd));
    }

    createdViews.addAll(createdConnectionViews);

    makeViewsImmutable(createdViews);
  }

  /**
   * @generated
   */
  private Collection<IAdaptable> refreshConnections() {
    Domain2Notation domain2NotationMap = new Domain2Notation();
    Collection<PLMLinkDescriptor> linkDescriptors = collectAllLinks(getDiagram(),
        domain2NotationMap);
    Collection existingLinks = new LinkedList(getDiagram().getEdges());
    for (Iterator linksIterator = existingLinks.iterator(); linksIterator.hasNext();) {
      Edge nextDiagramLink = (Edge) linksIterator.next();
      int diagramLinkVisualID = PLMVisualIDRegistry.getVisualID(nextDiagramLink);
      if (diagramLinkVisualID == -1) {
        if (nextDiagramLink.getSource() != null && nextDiagramLink.getTarget() != null) {
          linksIterator.remove();
        }
        continue;
      }
      EObject diagramLinkObject = nextDiagramLink.getElement();
      EObject diagramLinkSrc = nextDiagramLink.getSource().getElement();
      EObject diagramLinkDst = nextDiagramLink.getTarget().getElement();
      for (Iterator<PLMLinkDescriptor> linkDescriptorsIterator = linkDescriptors
          .iterator(); linkDescriptorsIterator.hasNext();) {
        PLMLinkDescriptor nextLinkDescriptor = linkDescriptorsIterator.next();
        if (diagramLinkObject == nextLinkDescriptor.getModelElement()
            && diagramLinkSrc == nextLinkDescriptor.getSource()
            && diagramLinkDst == nextLinkDescriptor.getDestination()
            && diagramLinkVisualID == nextLinkDescriptor.getVisualID()) {
          linksIterator.remove();
          linkDescriptorsIterator.remove();
          break;
        }
      }
    }
    deleteViews(existingLinks.iterator());
    return createConnections(linkDescriptors, domain2NotationMap);
  }

  /**
   * @generated
   */
  private Collection<PLMLinkDescriptor> collectAllLinks(View view,
      Domain2Notation domain2NotationMap) {
    if (!DomainEditPart.MODEL_ID.equals(PLMVisualIDRegistry.getModelID(view))) {
      return Collections.emptyList();
    }
    LinkedList<PLMLinkDescriptor> result = new LinkedList<PLMLinkDescriptor>();
    switch (PLMVisualIDRegistry.getVisualID(view)) {
    case DomainEditPart.VISUAL_ID: {
      if (!domain2NotationMap.containsKey(view.getElement())) {
        result.addAll(PLMDiagramUpdater.getDomain_1000ContainedLinks(view));
      }
      domain2NotationMap.putView(view.getElement(), view);
      break;
    }
    case DeepModelEditPart.VISUAL_ID: {
      if (!domain2NotationMap.containsKey(view.getElement())) {
        result.addAll(PLMDiagramUpdater.getDeepModel_2005ContainedLinks(view));
      }
      domain2NotationMap.putView(view.getElement(), view);
      break;
    }
    case EnumerationEditPart.VISUAL_ID: {
      if (!domain2NotationMap.containsKey(view.getElement())) {
        result.addAll(PLMDiagramUpdater.getEnumeration_3123ContainedLinks(view));
      }
      domain2NotationMap.putView(view.getElement(), view);
      break;
    }
    case LevelEditPart.VISUAL_ID: {
      if (!domain2NotationMap.containsKey(view.getElement())) {
        result.addAll(PLMDiagramUpdater.getLevel_3097ContainedLinks(view));
      }
      domain2NotationMap.putView(view.getElement(), view);
      break;
    }
    case ConnectionEditPart.VISUAL_ID: {
      if (!domain2NotationMap.containsKey(view.getElement())) {
        result.addAll(PLMDiagramUpdater.getConnection_3099ContainedLinks(view));
      }
      domain2NotationMap.putView(view.getElement(), view);
      break;
    }
    case AttributeEditPart.VISUAL_ID: {
      if (!domain2NotationMap.containsKey(view.getElement())) {
        result.addAll(PLMDiagramUpdater.getAttribute_3100ContainedLinks(view));
      }
      domain2NotationMap.putView(view.getElement(), view);
      break;
    }
    case MethodEditPart.VISUAL_ID: {
      if (!domain2NotationMap.containsKey(view.getElement())) {
        result.addAll(PLMDiagramUpdater.getMethod_3102ContainedLinks(view));
      }
      domain2NotationMap.putView(view.getElement(), view);
      break;
    }
    case EntityEditPart.VISUAL_ID: {
      if (!domain2NotationMap.containsKey(view.getElement())) {
        result.addAll(PLMDiagramUpdater.getEntity_3105ContainedLinks(view));
      }
      domain2NotationMap.putView(view.getElement(), view);
      break;
    }
    case Attribute2EditPart.VISUAL_ID: {
      if (!domain2NotationMap.containsKey(view.getElement())) {
        result.addAll(PLMDiagramUpdater.getAttribute_3106ContainedLinks(view));
      }
      domain2NotationMap.putView(view.getElement(), view);
      break;
    }
    case Method2EditPart.VISUAL_ID: {
      if (!domain2NotationMap.containsKey(view.getElement())) {
        result.addAll(PLMDiagramUpdater.getMethod_3108ContainedLinks(view));
      }
      domain2NotationMap.putView(view.getElement(), view);
      break;
    }
    case Connection2EditPart.VISUAL_ID: {
      if (!domain2NotationMap.containsKey(view.getElement())) {
        result.addAll(PLMDiagramUpdater.getConnection_3111ContainedLinks(view));
      }
      domain2NotationMap.putView(view.getElement(), view);
      break;
    }
    case InheritanceEditPart.VISUAL_ID: {
      if (!domain2NotationMap.containsKey(view.getElement())) {
        result.addAll(PLMDiagramUpdater.getInheritance_3124ContainedLinks(view));
      }
      domain2NotationMap.putView(view.getElement(), view);
      break;
    }
    case Inheritance2EditPart.VISUAL_ID: {
      if (!domain2NotationMap.containsKey(view.getElement())) {
        result.addAll(PLMDiagramUpdater.getInheritance_3122ContainedLinks(view));
      }
      domain2NotationMap.putView(view.getElement(), view);
      break;
    }
    case Entity2EditPart.VISUAL_ID: {
      if (!domain2NotationMap.containsKey(view.getElement())) {
        result.addAll(PLMDiagramUpdater.getEntity_3120ContainedLinks(view));
      }
      domain2NotationMap.putView(view.getElement(), view);
      break;
    }
    case PackageEditPart.VISUAL_ID: {
      if (!domain2NotationMap.containsKey(view.getElement())) {
        result.addAll(PLMDiagramUpdater.getPackage_3125ContainedLinks(view));
      }
      domain2NotationMap.putView(view.getElement(), view);
      break;
    }
    case Entity3EditPart.VISUAL_ID: {
      if (!domain2NotationMap.containsKey(view.getElement())) {
        result.addAll(PLMDiagramUpdater.getEntity_3126ContainedLinks(view));
      }
      domain2NotationMap.putView(view.getElement(), view);
      break;
    }
    case Connection3EditPart.VISUAL_ID: {
      if (!domain2NotationMap.containsKey(view.getElement())) {
        result.addAll(PLMDiagramUpdater.getConnection_3127ContainedLinks(view));
      }
      domain2NotationMap.putView(view.getElement(), view);
      break;
    }
    case Inheritance3EditPart.VISUAL_ID: {
      if (!domain2NotationMap.containsKey(view.getElement())) {
        result.addAll(PLMDiagramUpdater.getInheritance_3128ContainedLinks(view));
      }
      domain2NotationMap.putView(view.getElement(), view);
      break;
    }
    case Package2EditPart.VISUAL_ID: {
      if (!domain2NotationMap.containsKey(view.getElement())) {
        result.addAll(PLMDiagramUpdater.getPackage_3129ContainedLinks(view));
      }
      domain2NotationMap.putView(view.getElement(), view);
      break;
    }
    case ClassificationEditPart.VISUAL_ID: {
      if (!domain2NotationMap.containsKey(view.getElement())) {
        result.addAll(PLMDiagramUpdater.getClassification_4026ContainedLinks(view));
      }
      domain2NotationMap.putView(view.getElement(), view);
      break;
    }
    case SupertypeEditPart.VISUAL_ID: {
      if (!domain2NotationMap.containsKey(view.getElement())) {
        result.addAll(PLMDiagramUpdater.getSupertype_4034ContainedLinks(view));
      }
      domain2NotationMap.putView(view.getElement(), view);
      break;
    }
    case SubtypeEditPart.VISUAL_ID: {
      if (!domain2NotationMap.containsKey(view.getElement())) {
        result.addAll(PLMDiagramUpdater.getSubtype_4035ContainedLinks(view));
      }
      domain2NotationMap.putView(view.getElement(), view);
      break;
    }
    case ConnectionEndEditPart.VISUAL_ID: {
      if (!domain2NotationMap.containsKey(view.getElement())) {
        result.addAll(PLMDiagramUpdater.getConnectionEnd_4036ContainedLinks(view));
      }
      domain2NotationMap.putView(view.getElement(), view);
      break;
    }
    }
    for (Iterator children = view.getChildren().iterator(); children.hasNext();) {
      result.addAll(collectAllLinks((View) children.next(), domain2NotationMap));
    }
    for (Iterator edges = view.getSourceEdges().iterator(); edges.hasNext();) {
      result.addAll(collectAllLinks((View) edges.next(), domain2NotationMap));
    }
    return result;
  }

  /**
   * @generated
   */
  private Collection<IAdaptable> createConnections(Collection<PLMLinkDescriptor> linkDescriptors,
      Domain2Notation domain2NotationMap) {
    LinkedList<IAdaptable> adapters = new LinkedList<IAdaptable>();
    for (PLMLinkDescriptor nextLinkDescriptor : linkDescriptors) {
      EditPart sourceEditPart = getSourceEditPart(nextLinkDescriptor, domain2NotationMap);
      EditPart targetEditPart = getTargetEditPart(nextLinkDescriptor, domain2NotationMap);
      if (sourceEditPart == null || targetEditPart == null) {
        continue;
      }
      CreateConnectionViewRequest.ConnectionViewDescriptor descriptor = new CreateConnectionViewRequest.ConnectionViewDescriptor(
          nextLinkDescriptor.getSemanticAdapter(),
          PLMVisualIDRegistry.getType(nextLinkDescriptor.getVisualID()), ViewUtil.APPEND, false,
          ((IGraphicalEditPart) getHost()).getDiagramPreferencesHint());
      CreateConnectionViewRequest ccr = new CreateConnectionViewRequest(descriptor);
      ccr.setType(RequestConstants.REQ_CONNECTION_START);
      ccr.setSourceEditPart(sourceEditPart);
      sourceEditPart.getCommand(ccr);
      ccr.setTargetEditPart(targetEditPart);
      ccr.setType(RequestConstants.REQ_CONNECTION_END);
      Command cmd = targetEditPart.getCommand(ccr);
      if (cmd != null && cmd.canExecute()) {
        executeCommand(cmd);
        IAdaptable viewAdapter = (IAdaptable) ccr.getNewObject();
        if (viewAdapter != null) {
          adapters.add(viewAdapter);
        }
      }
    }
    return adapters;
  }

  /**
   * @generated
   */
  private EditPart getEditPart(EObject domainModelElement, Domain2Notation domain2NotationMap) {
    View view = (View) domain2NotationMap.get(domainModelElement);
    if (view != null) {
      return (EditPart) getHost().getViewer().getEditPartRegistry().get(view);
    }
    return null;
  }

  /**
   * @generated
   */
  private Diagram getDiagram() {
    return ((View) getHost().getModel()).getDiagram();
  }

  /**
   * @generated
   */
  private EditPart getSourceEditPart(UpdaterLinkDescriptor descriptor,
      Domain2Notation domain2NotationMap) {
    return getEditPart(descriptor.getSource(), domain2NotationMap);
  }

  /**
   * @generated
   */
  private EditPart getTargetEditPart(UpdaterLinkDescriptor descriptor,
      Domain2Notation domain2NotationMap) {
    return getEditPart(descriptor.getDestination(), domain2NotationMap);
  }

  /**
   * @generated
   */
  protected final EditPart getHintedEditPart(EObject domainModelElement,
      Domain2Notation domain2NotationMap, int hintVisualId) {
    View view = (View) domain2NotationMap.getHinted(domainModelElement,
        PLMVisualIDRegistry.getType(hintVisualId));
    if (view != null) {
      return (EditPart) getHost().getViewer().getEditPartRegistry().get(view);
    }
    return null;
  }

  /**
   * @generated
   */
  @SuppressWarnings("serial")
  protected static class Domain2Notation extends HashMap<EObject, View> {
    /**
     * @generated
     */
    public boolean containsDomainElement(EObject domainElement) {
      return this.containsKey(domainElement);
    }

    /**
     * @generated
     */
    public View getHinted(EObject domainEObject, String hint) {
      return this.get(domainEObject);
    }

    /**
     * @generated
     */
    public void putView(EObject domainElement, View view) {
      if (!containsKey(view.getElement())) {
        this.put(domainElement, view);
      }
    }

  }
}

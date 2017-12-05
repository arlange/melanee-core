/*
* *******************************************************************************
* Copyright (c) 2011 - 2015 University of Mannheim: Chair for Software Engineering
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
* 
* Contributors:
*      - initial API and implementation and initial documentation
* *******************************************************************************
*/
package org.melanee.core.modeleditor.navigator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonContentProvider;
import org.melanee.core.modeleditor.edit.parts.Attribute2EditPart;
import org.melanee.core.modeleditor.edit.parts.AttributeEditPart;
import org.melanee.core.modeleditor.edit.parts.ClassificationEditPart;
import org.melanee.core.modeleditor.edit.parts.Connection2EditPart;
import org.melanee.core.modeleditor.edit.parts.Connection3EditPart;
import org.melanee.core.modeleditor.edit.parts.ConnectionConnectionAttributesCompartment2EditPart;
import org.melanee.core.modeleditor.edit.parts.ConnectionConnectionAttributesCompartment3EditPart;
import org.melanee.core.modeleditor.edit.parts.ConnectionConnectionAttributesCompartmentEditPart;
import org.melanee.core.modeleditor.edit.parts.ConnectionConnectionContentsCompartment2EditPart;
import org.melanee.core.modeleditor.edit.parts.ConnectionConnectionContentsCompartment3EditPart;
import org.melanee.core.modeleditor.edit.parts.ConnectionConnectionContentsCompartmentEditPart;
import org.melanee.core.modeleditor.edit.parts.ConnectionConnectionMethodsCompartment2EditPart;
import org.melanee.core.modeleditor.edit.parts.ConnectionConnectionMethodsCompartment3EditPart;
import org.melanee.core.modeleditor.edit.parts.ConnectionConnectionMethodsCompartmentEditPart;
import org.melanee.core.modeleditor.edit.parts.ConnectionEditPart;
import org.melanee.core.modeleditor.edit.parts.ConnectionEndEditPart;
import org.melanee.core.modeleditor.edit.parts.DeepModelDeepModelEnumerationCompartmentEditPart;
import org.melanee.core.modeleditor.edit.parts.DeepModelDeepModelLevelCompartmentEditPart;
import org.melanee.core.modeleditor.edit.parts.DeepModelEditPart;
import org.melanee.core.modeleditor.edit.parts.DomainEditPart;
import org.melanee.core.modeleditor.edit.parts.Entity2EditPart;
import org.melanee.core.modeleditor.edit.parts.Entity3EditPart;
import org.melanee.core.modeleditor.edit.parts.EntityEditPart;
import org.melanee.core.modeleditor.edit.parts.EntityEntityAttributesCompartment2EditPart;
import org.melanee.core.modeleditor.edit.parts.EntityEntityAttributesCompartment3EditPart;
import org.melanee.core.modeleditor.edit.parts.EntityEntityAttributesCompartmentEditPart;
import org.melanee.core.modeleditor.edit.parts.EntityEntityContentsCompartment2EditPart;
import org.melanee.core.modeleditor.edit.parts.EntityEntityContentsCompartment3EditPart;
import org.melanee.core.modeleditor.edit.parts.EntityEntityContentsCompartmentEditPart;
import org.melanee.core.modeleditor.edit.parts.EntityEntityMethodsCompartment2EditPart;
import org.melanee.core.modeleditor.edit.parts.EntityEntityMethodsCompartment3EditPart;
import org.melanee.core.modeleditor.edit.parts.EntityEntityMethodsCompartmentEditPart;
import org.melanee.core.modeleditor.edit.parts.EnumerationEditPart;
import org.melanee.core.modeleditor.edit.parts.Inheritance2EditPart;
import org.melanee.core.modeleditor.edit.parts.Inheritance3EditPart;
import org.melanee.core.modeleditor.edit.parts.InheritanceEditPart;
import org.melanee.core.modeleditor.edit.parts.LevelDomainElementsCompartmentEditPart;
import org.melanee.core.modeleditor.edit.parts.LevelEditPart;
import org.melanee.core.modeleditor.edit.parts.Method2EditPart;
import org.melanee.core.modeleditor.edit.parts.MethodEditPart;
import org.melanee.core.modeleditor.edit.parts.Package2EditPart;
import org.melanee.core.modeleditor.edit.parts.PackageEditPart;
import org.melanee.core.modeleditor.edit.parts.PackagePackageContentCompartment2EditPart;
import org.melanee.core.modeleditor.edit.parts.PackagePackageContentCompartmentEditPart;
import org.melanee.core.modeleditor.edit.parts.SubtypeEditPart;
import org.melanee.core.modeleditor.edit.parts.SupertypeEditPart;
import org.melanee.core.modeleditor.part.Messages;
import org.melanee.core.modeleditor.part.PLMVisualIDRegistry;

/**
 * @generated
 */
public class PLMNavigatorContentProvider implements ICommonContentProvider {

	/**
	* @generated
	*/
	private static final Object[] EMPTY_ARRAY = new Object[0];

	/**
	* @generated
	*/
	private Viewer myViewer;

	/**
	* @generated
	*/
	private AdapterFactoryEditingDomain myEditingDomain;

	/**
	* @generated
	*/
	private WorkspaceSynchronizer myWorkspaceSynchronizer;

	/**
	* @generated
	*/
	private Runnable myViewerRefreshRunnable;

	/**
	* @generated
	*/
	@SuppressWarnings({ "unchecked", "serial", "rawtypes" })
	public PLMNavigatorContentProvider() {
		TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE.createEditingDomain();
		myEditingDomain = (AdapterFactoryEditingDomain) editingDomain;
		myEditingDomain.setResourceToReadOnlyMap(new HashMap() {
			public Object get(Object key) {
				if (!containsKey(key)) {
					put(key, Boolean.TRUE);
				}
				return super.get(key);
			}
		});
		myViewerRefreshRunnable = new Runnable() {
			public void run() {
				if (myViewer != null) {
					myViewer.refresh();
				}
			}
		};
		myWorkspaceSynchronizer = new WorkspaceSynchronizer(editingDomain, new WorkspaceSynchronizer.Delegate() {
			public void dispose() {
			}

			public boolean handleResourceChanged(final Resource resource) {
				unloadAllResources();
				asyncRefresh();
				return true;
			}

			public boolean handleResourceDeleted(Resource resource) {
				unloadAllResources();
				asyncRefresh();
				return true;
			}

			public boolean handleResourceMoved(Resource resource, final URI newURI) {
				unloadAllResources();
				asyncRefresh();
				return true;
			}
		});
	}

	/**
	* @generated
	*/
	public void dispose() {
		myWorkspaceSynchronizer.dispose();
		myWorkspaceSynchronizer = null;
		myViewerRefreshRunnable = null;
		myViewer = null;
		unloadAllResources();
		((TransactionalEditingDomain) myEditingDomain).dispose();
		myEditingDomain = null;
	}

	/**
	* @generated
	*/
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		myViewer = viewer;
	}

	/**
	* @generated
	*/
	void unloadAllResources() {
		for (Resource nextResource : myEditingDomain.getResourceSet().getResources()) {
			nextResource.unload();
		}
	}

	/**
	* @generated
	*/
	void asyncRefresh() {
		if (myViewer != null && !myViewer.getControl().isDisposed()) {
			myViewer.getControl().getDisplay().asyncExec(myViewerRefreshRunnable);
		}
	}

	/**
	* @generated
	*/
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	/**
	* @generated
	*/
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	* @generated
	*/
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	* @generated
	*/
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof IFile) {
			IFile file = (IFile) parentElement;
			URI fileURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			Resource resource = myEditingDomain.getResourceSet().getResource(fileURI, true);
			ArrayList<PLMNavigatorItem> result = new ArrayList<PLMNavigatorItem>();
			ArrayList<View> topViews = new ArrayList<View>(resource.getContents().size());
			for (EObject o : resource.getContents()) {
				if (o instanceof View) {
					topViews.add((View) o);
				}
			}
			result.addAll(createNavigatorItems(selectViewsByType(topViews, DomainEditPart.MODEL_ID), file, false));
			return result.toArray();
		}

		if (parentElement instanceof PLMNavigatorGroup) {
			PLMNavigatorGroup group = (PLMNavigatorGroup) parentElement;
			return group.getChildren();
		}

		if (parentElement instanceof PLMNavigatorItem) {
			PLMNavigatorItem navigatorItem = (PLMNavigatorItem) parentElement;
			if (navigatorItem.isLeaf() || !isOwnView(navigatorItem.getView())) {
				return EMPTY_ARRAY;
			}
			return getViewChildren(navigatorItem.getView(), parentElement);
		}

		return EMPTY_ARRAY;
	}

	/**
	* @generated
	*/
	private Object[] getViewChildren(View view, Object parentElement) {
		switch (PLMVisualIDRegistry.getVisualID(view)) {

		case DomainEditPart.VISUAL_ID: {
			LinkedList<PLMAbstractNavigatorItem> result = new LinkedList<PLMAbstractNavigatorItem>();
			Diagram sv = (Diagram) view;
			PLMNavigatorGroup links = new PLMNavigatorGroup(Messages.NavigatorGroupName_Domain_1000_links,
					"icons/linksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(DeepModelEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(ClassificationEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(SupertypeEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(SubtypeEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(ConnectionEndEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			if (!links.isEmpty()) {
				result.add(links);
			}
			return result.toArray();
		}

		case DeepModelEditPart.VISUAL_ID: {
			LinkedList<PLMAbstractNavigatorItem> result = new LinkedList<PLMAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(DeepModelDeepModelEnumerationCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					PLMVisualIDRegistry.getType(EnumerationEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(DeepModelDeepModelLevelCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, PLMVisualIDRegistry.getType(LevelEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case LevelEditPart.VISUAL_ID: {
			LinkedList<PLMAbstractNavigatorItem> result = new LinkedList<PLMAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(LevelDomainElementsCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					PLMVisualIDRegistry.getType(ConnectionEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(LevelDomainElementsCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					PLMVisualIDRegistry.getType(Inheritance2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(LevelDomainElementsCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, PLMVisualIDRegistry.getType(Entity2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(LevelDomainElementsCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, PLMVisualIDRegistry.getType(PackageEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case ConnectionEditPart.VISUAL_ID: {
			LinkedList<PLMAbstractNavigatorItem> result = new LinkedList<PLMAbstractNavigatorItem>();
			Node sv = (Node) view;
			PLMNavigatorGroup incominglinks = new PLMNavigatorGroup(
					Messages.NavigatorGroupName_Connection_3099_incominglinks, "icons/incomingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			PLMNavigatorGroup outgoinglinks = new PLMNavigatorGroup(
					Messages.NavigatorGroupName_Connection_3099_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(ConnectionConnectionAttributesCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					PLMVisualIDRegistry.getType(AttributeEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(ConnectionConnectionMethodsCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, PLMVisualIDRegistry.getType(MethodEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(ConnectionConnectionContentsCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, PLMVisualIDRegistry.getType(EntityEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(ConnectionConnectionContentsCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					PLMVisualIDRegistry.getType(Connection2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(ConnectionConnectionContentsCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					PLMVisualIDRegistry.getType(InheritanceEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(ClassificationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(ClassificationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(SupertypeEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(SubtypeEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(ConnectionEndEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(ConnectionEndEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case EntityEditPart.VISUAL_ID: {
			LinkedList<PLMAbstractNavigatorItem> result = new LinkedList<PLMAbstractNavigatorItem>();
			Node sv = (Node) view;
			PLMNavigatorGroup incominglinks = new PLMNavigatorGroup(
					Messages.NavigatorGroupName_Entity_3105_incominglinks, "icons/incomingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			PLMNavigatorGroup outgoinglinks = new PLMNavigatorGroup(
					Messages.NavigatorGroupName_Entity_3105_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(EntityEntityAttributesCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					PLMVisualIDRegistry.getType(Attribute2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(EntityEntityMethodsCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, PLMVisualIDRegistry.getType(Method2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(EntityEntityContentsCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, PLMVisualIDRegistry.getType(EntityEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(EntityEntityContentsCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					PLMVisualIDRegistry.getType(Connection2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(EntityEntityContentsCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					PLMVisualIDRegistry.getType(InheritanceEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(ClassificationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(ClassificationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(SupertypeEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(SubtypeEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(ConnectionEndEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case Connection2EditPart.VISUAL_ID: {
			LinkedList<PLMAbstractNavigatorItem> result = new LinkedList<PLMAbstractNavigatorItem>();
			Node sv = (Node) view;
			PLMNavigatorGroup incominglinks = new PLMNavigatorGroup(
					Messages.NavigatorGroupName_Connection_3111_incominglinks, "icons/incomingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			PLMNavigatorGroup outgoinglinks = new PLMNavigatorGroup(
					Messages.NavigatorGroupName_Connection_3111_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(ConnectionConnectionAttributesCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					PLMVisualIDRegistry.getType(AttributeEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(ConnectionConnectionMethodsCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, PLMVisualIDRegistry.getType(MethodEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(ConnectionConnectionContentsCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, PLMVisualIDRegistry.getType(EntityEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(ConnectionConnectionContentsCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					PLMVisualIDRegistry.getType(Connection2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(ConnectionConnectionContentsCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					PLMVisualIDRegistry.getType(InheritanceEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(ClassificationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(ClassificationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(SupertypeEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(SubtypeEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(ConnectionEndEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(ConnectionEndEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case Entity2EditPart.VISUAL_ID: {
			LinkedList<PLMAbstractNavigatorItem> result = new LinkedList<PLMAbstractNavigatorItem>();
			Node sv = (Node) view;
			PLMNavigatorGroup incominglinks = new PLMNavigatorGroup(
					Messages.NavigatorGroupName_Entity_3120_incominglinks, "icons/incomingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			PLMNavigatorGroup outgoinglinks = new PLMNavigatorGroup(
					Messages.NavigatorGroupName_Entity_3120_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(EntityEntityAttributesCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					PLMVisualIDRegistry.getType(Attribute2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(EntityEntityMethodsCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, PLMVisualIDRegistry.getType(Method2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(EntityEntityContentsCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, PLMVisualIDRegistry.getType(EntityEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(EntityEntityContentsCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					PLMVisualIDRegistry.getType(Connection2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(EntityEntityContentsCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					PLMVisualIDRegistry.getType(InheritanceEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(ClassificationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(ClassificationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(SupertypeEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(SubtypeEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(ConnectionEndEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case Inheritance2EditPart.VISUAL_ID: {
			LinkedList<PLMAbstractNavigatorItem> result = new LinkedList<PLMAbstractNavigatorItem>();
			Node sv = (Node) view;
			PLMNavigatorGroup outgoinglinks = new PLMNavigatorGroup(
					Messages.NavigatorGroupName_Inheritance_3122_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(SupertypeEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(SubtypeEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case InheritanceEditPart.VISUAL_ID: {
			LinkedList<PLMAbstractNavigatorItem> result = new LinkedList<PLMAbstractNavigatorItem>();
			Node sv = (Node) view;
			PLMNavigatorGroup outgoinglinks = new PLMNavigatorGroup(
					Messages.NavigatorGroupName_Inheritance_3124_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(SupertypeEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(SubtypeEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case PackageEditPart.VISUAL_ID: {
			LinkedList<PLMAbstractNavigatorItem> result = new LinkedList<PLMAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(PackagePackageContentCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, PLMVisualIDRegistry.getType(Entity3EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(PackagePackageContentCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					PLMVisualIDRegistry.getType(Connection3EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(PackagePackageContentCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					PLMVisualIDRegistry.getType(Inheritance3EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(PackagePackageContentCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, PLMVisualIDRegistry.getType(Package2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case Entity3EditPart.VISUAL_ID: {
			LinkedList<PLMAbstractNavigatorItem> result = new LinkedList<PLMAbstractNavigatorItem>();
			Node sv = (Node) view;
			PLMNavigatorGroup incominglinks = new PLMNavigatorGroup(
					Messages.NavigatorGroupName_Entity_3126_incominglinks, "icons/incomingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			PLMNavigatorGroup outgoinglinks = new PLMNavigatorGroup(
					Messages.NavigatorGroupName_Entity_3126_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(EntityEntityAttributesCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					PLMVisualIDRegistry.getType(Attribute2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(EntityEntityMethodsCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, PLMVisualIDRegistry.getType(Method2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(EntityEntityContentsCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, PLMVisualIDRegistry.getType(EntityEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(EntityEntityContentsCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					PLMVisualIDRegistry.getType(Connection2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(EntityEntityContentsCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					PLMVisualIDRegistry.getType(InheritanceEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(ClassificationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(ClassificationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(SupertypeEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(SubtypeEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(ConnectionEndEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case Connection3EditPart.VISUAL_ID: {
			LinkedList<PLMAbstractNavigatorItem> result = new LinkedList<PLMAbstractNavigatorItem>();
			Node sv = (Node) view;
			PLMNavigatorGroup incominglinks = new PLMNavigatorGroup(
					Messages.NavigatorGroupName_Connection_3127_incominglinks, "icons/incomingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			PLMNavigatorGroup outgoinglinks = new PLMNavigatorGroup(
					Messages.NavigatorGroupName_Connection_3127_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(ConnectionConnectionAttributesCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					PLMVisualIDRegistry.getType(AttributeEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(ConnectionConnectionMethodsCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, PLMVisualIDRegistry.getType(MethodEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(ConnectionConnectionContentsCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, PLMVisualIDRegistry.getType(EntityEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(ConnectionConnectionContentsCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					PLMVisualIDRegistry.getType(Connection2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(ConnectionConnectionContentsCompartment3EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					PLMVisualIDRegistry.getType(InheritanceEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(ClassificationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(ClassificationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(SupertypeEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(SubtypeEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(ConnectionEndEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(ConnectionEndEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case Inheritance3EditPart.VISUAL_ID: {
			LinkedList<PLMAbstractNavigatorItem> result = new LinkedList<PLMAbstractNavigatorItem>();
			Node sv = (Node) view;
			PLMNavigatorGroup outgoinglinks = new PLMNavigatorGroup(
					Messages.NavigatorGroupName_Inheritance_3128_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", //$NON-NLS-1$
					parentElement);
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(SupertypeEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(SubtypeEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case Package2EditPart.VISUAL_ID: {
			LinkedList<PLMAbstractNavigatorItem> result = new LinkedList<PLMAbstractNavigatorItem>();
			Node sv = (Node) view;
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(PackagePackageContentCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, PLMVisualIDRegistry.getType(Entity3EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(PackagePackageContentCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					PLMVisualIDRegistry.getType(Connection3EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(PackagePackageContentCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					PLMVisualIDRegistry.getType(Inheritance3EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(PackagePackageContentCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, PLMVisualIDRegistry.getType(Package2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			return result.toArray();
		}

		case ClassificationEditPart.VISUAL_ID: {
			LinkedList<PLMAbstractNavigatorItem> result = new LinkedList<PLMAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			PLMNavigatorGroup target = new PLMNavigatorGroup(Messages.NavigatorGroupName_Classification_4026_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			PLMNavigatorGroup source = new PLMNavigatorGroup(Messages.NavigatorGroupName_Classification_4026_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(ConnectionEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(EntityEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(Connection2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(Entity2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(Entity3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(Connection3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(ConnectionEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(EntityEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(Connection2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(Entity2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(Entity3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(Connection3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case SupertypeEditPart.VISUAL_ID: {
			LinkedList<PLMAbstractNavigatorItem> result = new LinkedList<PLMAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			PLMNavigatorGroup target = new PLMNavigatorGroup(Messages.NavigatorGroupName_Supertype_4034_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			PLMNavigatorGroup source = new PLMNavigatorGroup(Messages.NavigatorGroupName_Supertype_4034_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(ConnectionEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(EntityEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(Connection2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(Entity2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(Entity3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(Connection3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(InheritanceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(Inheritance2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(Inheritance3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case SubtypeEditPart.VISUAL_ID: {
			LinkedList<PLMAbstractNavigatorItem> result = new LinkedList<PLMAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			PLMNavigatorGroup target = new PLMNavigatorGroup(Messages.NavigatorGroupName_Subtype_4035_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			PLMNavigatorGroup source = new PLMNavigatorGroup(Messages.NavigatorGroupName_Subtype_4035_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(ConnectionEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(EntityEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(Connection2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(Entity2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(Entity3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(Connection3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(InheritanceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(Inheritance2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(Inheritance3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case ConnectionEndEditPart.VISUAL_ID: {
			LinkedList<PLMAbstractNavigatorItem> result = new LinkedList<PLMAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			PLMNavigatorGroup target = new PLMNavigatorGroup(Messages.NavigatorGroupName_ConnectionEnd_4036_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			PLMNavigatorGroup source = new PLMNavigatorGroup(Messages.NavigatorGroupName_ConnectionEnd_4036_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(ConnectionEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(EntityEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(Connection2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(Entity2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(Entity3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(Connection3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(ConnectionEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(Connection2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					PLMVisualIDRegistry.getType(Connection3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}
		}
		return EMPTY_ARRAY;
	}

	/**
	* @generated
	*/
	private Collection<View> getLinksSourceByType(Collection<Edge> edges, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (Edge nextEdge : edges) {
			View nextEdgeSource = nextEdge.getSource();
			if (type.equals(nextEdgeSource.getType()) && isOwnView(nextEdgeSource)) {
				result.add(nextEdgeSource);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getLinksTargetByType(Collection<Edge> edges, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (Edge nextEdge : edges) {
			View nextEdgeTarget = nextEdge.getTarget();
			if (type.equals(nextEdgeTarget.getType()) && isOwnView(nextEdgeTarget)) {
				result.add(nextEdgeTarget);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getOutgoingLinksByType(Collection<? extends View> nodes, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (View nextNode : nodes) {
			result.addAll(selectViewsByType(nextNode.getSourceEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getIncomingLinksByType(Collection<? extends View> nodes, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (View nextNode : nodes) {
			result.addAll(selectViewsByType(nextNode.getTargetEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getChildrenByType(Collection<? extends View> nodes, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (View nextNode : nodes) {
			result.addAll(selectViewsByType(nextNode.getChildren(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getDiagramLinksByType(Collection<Diagram> diagrams, String type) {
		ArrayList<View> result = new ArrayList<View>();
		for (Diagram nextDiagram : diagrams) {
			result.addAll(selectViewsByType(nextDiagram.getEdges(), type));
		}
		return result;
	}

	// TODO refactor as static method
	/**
	 * @generated
	 */
	private Collection<View> selectViewsByType(Collection<View> views, String type) {
		ArrayList<View> result = new ArrayList<View>();
		for (View nextView : views) {
			if (type.equals(nextView.getType()) && isOwnView(nextView)) {
				result.add(nextView);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return DomainEditPart.MODEL_ID.equals(PLMVisualIDRegistry.getModelID(view));
	}

	/**
	 * @generated
	 */
	private Collection<PLMNavigatorItem> createNavigatorItems(Collection<View> views, Object parent, boolean isLeafs) {
		ArrayList<PLMNavigatorItem> result = new ArrayList<PLMNavigatorItem>(views.size());
		for (View nextView : views) {
			result.add(new PLMNavigatorItem(nextView, parent, isLeafs));
		}
		return result;
	}

	/**
	* @generated
	*/
	public Object getParent(Object element) {
		if (element instanceof PLMAbstractNavigatorItem) {
			PLMAbstractNavigatorItem abstractNavigatorItem = (PLMAbstractNavigatorItem) element;
			return abstractNavigatorItem.getParent();
		}
		return null;
	}

	/**
	* @generated
	*/
	public boolean hasChildren(Object element) {
		return element instanceof IFile || getChildren(element).length > 0;
	}

}

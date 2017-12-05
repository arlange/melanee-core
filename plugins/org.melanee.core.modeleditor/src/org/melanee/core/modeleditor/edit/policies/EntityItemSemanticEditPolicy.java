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
package org.melanee.core.modeleditor.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.melanee.core.modeleditor.edit.commands.ClassificationCreateCommand;
import org.melanee.core.modeleditor.edit.commands.ClassificationReorientCommand;
import org.melanee.core.modeleditor.edit.commands.ConnectionEndCreateCommand;
import org.melanee.core.modeleditor.edit.commands.ConnectionEndReorientCommand;
import org.melanee.core.modeleditor.edit.commands.SubtypeCreateCommand;
import org.melanee.core.modeleditor.edit.commands.SubtypeReorientCommand;
import org.melanee.core.modeleditor.edit.commands.SupertypeCreateCommand;
import org.melanee.core.modeleditor.edit.commands.SupertypeReorientCommand;
import org.melanee.core.modeleditor.edit.parts.Attribute2EditPart;
import org.melanee.core.modeleditor.edit.parts.ClassificationEditPart;
import org.melanee.core.modeleditor.edit.parts.Connection2EditPart;
import org.melanee.core.modeleditor.edit.parts.ConnectionEndEditPart;
import org.melanee.core.modeleditor.edit.parts.EntityEditPart;
import org.melanee.core.modeleditor.edit.parts.EntityEntityAttributesCompartmentEditPart;
import org.melanee.core.modeleditor.edit.parts.EntityEntityContentsCompartmentEditPart;
import org.melanee.core.modeleditor.edit.parts.EntityEntityMethodsCompartmentEditPart;
import org.melanee.core.modeleditor.edit.parts.InheritanceEditPart;
import org.melanee.core.modeleditor.edit.parts.Method2EditPart;
import org.melanee.core.modeleditor.edit.parts.SubtypeEditPart;
import org.melanee.core.modeleditor.edit.parts.SupertypeEditPart;
import org.melanee.core.modeleditor.part.PLMVisualIDRegistry;
import org.melanee.core.modeleditor.providers.PLMElementTypes;

/**
 * @generated
 */
public class EntityItemSemanticEditPolicy extends PLMBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public EntityItemSemanticEditPolicy() {
		super(PLMElementTypes.Entity_3105);
	}

	/**
	* @generated
	*/
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		View view = (View) getHost().getModel();
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(false);
		for (Iterator<?> it = view.getTargetEdges().iterator(); it.hasNext();) {
			Edge incomingLink = (Edge) it.next();
			if (PLMVisualIDRegistry.getVisualID(incomingLink) == ClassificationEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (PLMVisualIDRegistry.getVisualID(incomingLink) == SupertypeEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (PLMVisualIDRegistry.getVisualID(incomingLink) == SubtypeEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (PLMVisualIDRegistry.getVisualID(incomingLink) == ConnectionEndEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
		}
		for (Iterator<?> it = view.getSourceEdges().iterator(); it.hasNext();) {
			Edge outgoingLink = (Edge) it.next();
			if (PLMVisualIDRegistry.getVisualID(outgoingLink) == ClassificationEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
		}
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if (annotation == null) {
			// there are indirectly referenced children, need extra commands: false
			addDestroyChildNodesCommand(cmd);
			addDestroyShortcutsCommand(cmd, view);
			// delete host element
			cmd.add(new DestroyElementCommand(req));
		} else {
			cmd.add(new DeleteCommand(getEditingDomain(), view));
		}
		return getGEFWrapper(cmd.reduce());
	}

	/**
	* @generated
	*/
	private void addDestroyChildNodesCommand(ICompositeCommand cmd) {
		View view = (View) getHost().getModel();
		for (Iterator<?> nit = view.getChildren().iterator(); nit.hasNext();) {
			Node node = (Node) nit.next();
			switch (PLMVisualIDRegistry.getVisualID(node)) {
			case EntityEntityAttributesCompartmentEditPart.VISUAL_ID:
				for (Iterator<?> cit = node.getChildren().iterator(); cit.hasNext();) {
					Node cnode = (Node) cit.next();
					switch (PLMVisualIDRegistry.getVisualID(cnode)) {
					case Attribute2EditPart.VISUAL_ID:
						cmd.add(new DestroyElementCommand(
								new DestroyElementRequest(getEditingDomain(), cnode.getElement(), false))); // directlyOwned: true
						// don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
						// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
						break;
					}
				}
				break;
			case EntityEntityMethodsCompartmentEditPart.VISUAL_ID:
				for (Iterator<?> cit = node.getChildren().iterator(); cit.hasNext();) {
					Node cnode = (Node) cit.next();
					switch (PLMVisualIDRegistry.getVisualID(cnode)) {
					case Method2EditPart.VISUAL_ID:
						cmd.add(new DestroyElementCommand(
								new DestroyElementRequest(getEditingDomain(), cnode.getElement(), false))); // directlyOwned: true
						// don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
						// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
						break;
					}
				}
				break;
			case EntityEntityContentsCompartmentEditPart.VISUAL_ID:
				for (Iterator<?> cit = node.getChildren().iterator(); cit.hasNext();) {
					Node cnode = (Node) cit.next();
					switch (PLMVisualIDRegistry.getVisualID(cnode)) {
					case EntityEditPart.VISUAL_ID:
						for (Iterator<?> it = cnode.getTargetEdges().iterator(); it.hasNext();) {
							Edge incomingLink = (Edge) it.next();
							if (PLMVisualIDRegistry.getVisualID(incomingLink) == ClassificationEditPart.VISUAL_ID) {
								DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
								cmd.add(new DestroyElementCommand(r));
								cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
								continue;
							}
							if (PLMVisualIDRegistry.getVisualID(incomingLink) == SupertypeEditPart.VISUAL_ID) {
								DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
								cmd.add(new DestroyElementCommand(r));
								cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
								continue;
							}
							if (PLMVisualIDRegistry.getVisualID(incomingLink) == SubtypeEditPart.VISUAL_ID) {
								DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
								cmd.add(new DestroyElementCommand(r));
								cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
								continue;
							}
							if (PLMVisualIDRegistry.getVisualID(incomingLink) == ConnectionEndEditPart.VISUAL_ID) {
								DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
								cmd.add(new DestroyElementCommand(r));
								cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
								continue;
							}
						}
						for (Iterator<?> it = cnode.getSourceEdges().iterator(); it.hasNext();) {
							Edge outgoingLink = (Edge) it.next();
							if (PLMVisualIDRegistry.getVisualID(outgoingLink) == ClassificationEditPart.VISUAL_ID) {
								DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
								cmd.add(new DestroyElementCommand(r));
								cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
								continue;
							}
						}
						cmd.add(new DestroyElementCommand(
								new DestroyElementRequest(getEditingDomain(), cnode.getElement(), false))); // directlyOwned: true
						// don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
						// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
						break;
					case Connection2EditPart.VISUAL_ID:
						for (Iterator<?> it = cnode.getTargetEdges().iterator(); it.hasNext();) {
							Edge incomingLink = (Edge) it.next();
							if (PLMVisualIDRegistry.getVisualID(incomingLink) == ClassificationEditPart.VISUAL_ID) {
								DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
								cmd.add(new DestroyElementCommand(r));
								cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
								continue;
							}
							if (PLMVisualIDRegistry.getVisualID(incomingLink) == SupertypeEditPart.VISUAL_ID) {
								DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
								cmd.add(new DestroyElementCommand(r));
								cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
								continue;
							}
							if (PLMVisualIDRegistry.getVisualID(incomingLink) == SubtypeEditPart.VISUAL_ID) {
								DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
								cmd.add(new DestroyElementCommand(r));
								cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
								continue;
							}
							if (PLMVisualIDRegistry.getVisualID(incomingLink) == ConnectionEndEditPart.VISUAL_ID) {
								DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
								cmd.add(new DestroyElementCommand(r));
								cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
								continue;
							}
						}
						for (Iterator<?> it = cnode.getSourceEdges().iterator(); it.hasNext();) {
							Edge outgoingLink = (Edge) it.next();
							if (PLMVisualIDRegistry.getVisualID(outgoingLink) == ClassificationEditPart.VISUAL_ID) {
								DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
								cmd.add(new DestroyElementCommand(r));
								cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
								continue;
							}
							if (PLMVisualIDRegistry.getVisualID(outgoingLink) == ConnectionEndEditPart.VISUAL_ID) {
								DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
								cmd.add(new DestroyElementCommand(r));
								cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
								continue;
							}
						}
						cmd.add(new DestroyElementCommand(
								new DestroyElementRequest(getEditingDomain(), cnode.getElement(), false))); // directlyOwned: true
						// don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
						// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
						break;
					case InheritanceEditPart.VISUAL_ID:
						for (Iterator<?> it = cnode.getSourceEdges().iterator(); it.hasNext();) {
							Edge outgoingLink = (Edge) it.next();
							if (PLMVisualIDRegistry.getVisualID(outgoingLink) == SupertypeEditPart.VISUAL_ID) {
								DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
								cmd.add(new DestroyElementCommand(r));
								cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
								continue;
							}
							if (PLMVisualIDRegistry.getVisualID(outgoingLink) == SubtypeEditPart.VISUAL_ID) {
								DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
								cmd.add(new DestroyElementCommand(r));
								cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
								continue;
							}
						}
						cmd.add(new DestroyElementCommand(
								new DestroyElementRequest(getEditingDomain(), cnode.getElement(), false))); // directlyOwned: true
						// don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
						// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
						break;
					}
				}
				break;
			}
		}
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req)
				: getCompleteCreateRelationshipCommand(req);
		return command != null ? command : super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (PLMElementTypes.Classification_4026 == req.getElementType()) {
			return getGEFWrapper(new ClassificationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (PLMElementTypes.Supertype_4034 == req.getElementType()) {
			return null;
		}
		if (PLMElementTypes.Subtype_4035 == req.getElementType()) {
			return null;
		}
		if (PLMElementTypes.ConnectionEnd_4036 == req.getElementType()) {
			return getGEFWrapper(new ConnectionEndCreateCommand(req, req.getTarget(), req.getSource()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (PLMElementTypes.Classification_4026 == req.getElementType()) {
			return getGEFWrapper(new ClassificationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (PLMElementTypes.Supertype_4034 == req.getElementType()) {
			return getGEFWrapper(new SupertypeCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (PLMElementTypes.Subtype_4035 == req.getElementType()) {
			return getGEFWrapper(new SubtypeCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (PLMElementTypes.ConnectionEnd_4036 == req.getElementType()) {
			return getGEFWrapper(new ConnectionEndCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Returns command to reorient EClass based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		switch (getVisualID(req)) {
		case ClassificationEditPart.VISUAL_ID:
			return getGEFWrapper(new ClassificationReorientCommand(req));
		case SupertypeEditPart.VISUAL_ID:
			return getGEFWrapper(new SupertypeReorientCommand(req));
		case SubtypeEditPart.VISUAL_ID:
			return getGEFWrapper(new SubtypeReorientCommand(req));
		case ConnectionEndEditPart.VISUAL_ID:
			return getGEFWrapper(new ConnectionEndReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

}

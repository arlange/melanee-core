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
package org.melanee.core.modeleditor.providers.assistants;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.melanee.core.modeleditor.edit.parts.Connection2EditPart;
import org.melanee.core.modeleditor.edit.parts.Connection3EditPart;
import org.melanee.core.modeleditor.edit.parts.ConnectionEditPart;
import org.melanee.core.modeleditor.edit.parts.Entity2EditPart;
import org.melanee.core.modeleditor.edit.parts.Entity3EditPart;
import org.melanee.core.modeleditor.edit.parts.EntityEditPart;
import org.melanee.core.modeleditor.edit.parts.InheritanceEditPart;
import org.melanee.core.modeleditor.providers.PLMElementTypes;
import org.melanee.core.modeleditor.providers.PLMModelingAssistantProvider;

/**
 * @generated
 */
public class PLMModelingAssistantProviderOfInheritanceEditPart extends PLMModelingAssistantProvider {

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSource((InheritanceEditPart) sourceEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSource(InheritanceEditPart source) {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(PLMElementTypes.Supertype_4034);
		types.add(PLMElementTypes.Subtype_4035);
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSourceAndTarget((InheritanceEditPart) sourceEditPart, targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSourceAndTarget(InheritanceEditPart source,
			IGraphicalEditPart targetEditPart) {
		List<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof ConnectionEditPart) {
			types.add(PLMElementTypes.Supertype_4034);
		}
		if (targetEditPart instanceof EntityEditPart) {
			types.add(PLMElementTypes.Supertype_4034);
		}
		if (targetEditPart instanceof Connection2EditPart) {
			types.add(PLMElementTypes.Supertype_4034);
		}
		if (targetEditPart instanceof Entity2EditPart) {
			types.add(PLMElementTypes.Supertype_4034);
		}
		if (targetEditPart instanceof Entity3EditPart) {
			types.add(PLMElementTypes.Supertype_4034);
		}
		if (targetEditPart instanceof Connection3EditPart) {
			types.add(PLMElementTypes.Supertype_4034);
		}
		if (targetEditPart instanceof ConnectionEditPart) {
			types.add(PLMElementTypes.Subtype_4035);
		}
		if (targetEditPart instanceof EntityEditPart) {
			types.add(PLMElementTypes.Subtype_4035);
		}
		if (targetEditPart instanceof Connection2EditPart) {
			types.add(PLMElementTypes.Subtype_4035);
		}
		if (targetEditPart instanceof Entity2EditPart) {
			types.add(PLMElementTypes.Subtype_4035);
		}
		if (targetEditPart instanceof Entity3EditPart) {
			types.add(PLMElementTypes.Subtype_4035);
		}
		if (targetEditPart instanceof Connection3EditPart) {
			types.add(PLMElementTypes.Subtype_4035);
		}
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForTarget((InheritanceEditPart) sourceEditPart, relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForTarget(InheritanceEditPart source, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == PLMElementTypes.Supertype_4034) {
			types.add(PLMElementTypes.Connection_3099);
			types.add(PLMElementTypes.Entity_3105);
			types.add(PLMElementTypes.Connection_3111);
			types.add(PLMElementTypes.Entity_3120);
			types.add(PLMElementTypes.Entity_3126);
			types.add(PLMElementTypes.Connection_3127);
		} else if (relationshipType == PLMElementTypes.Subtype_4035) {
			types.add(PLMElementTypes.Connection_3099);
			types.add(PLMElementTypes.Entity_3105);
			types.add(PLMElementTypes.Connection_3111);
			types.add(PLMElementTypes.Entity_3120);
			types.add(PLMElementTypes.Entity_3126);
			types.add(PLMElementTypes.Connection_3127);
		}
		return types;
	}

}

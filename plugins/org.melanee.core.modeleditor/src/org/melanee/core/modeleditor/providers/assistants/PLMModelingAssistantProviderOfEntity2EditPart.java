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
import org.melanee.core.modeleditor.providers.PLMElementTypes;
import org.melanee.core.modeleditor.providers.PLMModelingAssistantProvider;

/**
 * @generated
 */
public class PLMModelingAssistantProviderOfEntity2EditPart extends PLMModelingAssistantProvider {

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForPopupBar(IAdaptable host) {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(PLMElementTypes.Attribute_3106);
		types.add(PLMElementTypes.Method_3108);
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSource((Entity2EditPart) sourceEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSource(Entity2EditPart source) {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(PLMElementTypes.Classification_4026);
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSourceAndTarget((Entity2EditPart) sourceEditPart, targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSourceAndTarget(Entity2EditPart source,
			IGraphicalEditPart targetEditPart) {
		List<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof ConnectionEditPart) {
			types.add(PLMElementTypes.Classification_4026);
		}
		if (targetEditPart instanceof EntityEditPart) {
			types.add(PLMElementTypes.Classification_4026);
		}
		if (targetEditPart instanceof Connection2EditPart) {
			types.add(PLMElementTypes.Classification_4026);
		}
		if (targetEditPart instanceof Entity2EditPart) {
			types.add(PLMElementTypes.Classification_4026);
		}
		if (targetEditPart instanceof Entity3EditPart) {
			types.add(PLMElementTypes.Classification_4026);
		}
		if (targetEditPart instanceof Connection3EditPart) {
			types.add(PLMElementTypes.Classification_4026);
		}
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForTarget((Entity2EditPart) sourceEditPart, relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForTarget(Entity2EditPart source, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == PLMElementTypes.Classification_4026) {
			types.add(PLMElementTypes.Connection_3099);
			types.add(PLMElementTypes.Entity_3105);
			types.add(PLMElementTypes.Connection_3111);
			types.add(PLMElementTypes.Entity_3120);
			types.add(PLMElementTypes.Entity_3126);
			types.add(PLMElementTypes.Connection_3127);
		}
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnTarget((Entity2EditPart) targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnTarget(Entity2EditPart target) {
		List<IElementType> types = new ArrayList<IElementType>(4);
		types.add(PLMElementTypes.Classification_4026);
		types.add(PLMElementTypes.Supertype_4034);
		types.add(PLMElementTypes.Subtype_4035);
		types.add(PLMElementTypes.ConnectionEnd_4036);
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForSource((Entity2EditPart) targetEditPart, relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForSource(Entity2EditPart target, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == PLMElementTypes.Classification_4026) {
			types.add(PLMElementTypes.Connection_3099);
			types.add(PLMElementTypes.Entity_3105);
			types.add(PLMElementTypes.Connection_3111);
			types.add(PLMElementTypes.Entity_3120);
			types.add(PLMElementTypes.Entity_3126);
			types.add(PLMElementTypes.Connection_3127);
		} else if (relationshipType == PLMElementTypes.Supertype_4034) {
			types.add(PLMElementTypes.Inheritance_3124);
			types.add(PLMElementTypes.Inheritance_3122);
			types.add(PLMElementTypes.Inheritance_3128);
		} else if (relationshipType == PLMElementTypes.Subtype_4035) {
			types.add(PLMElementTypes.Inheritance_3124);
			types.add(PLMElementTypes.Inheritance_3122);
			types.add(PLMElementTypes.Inheritance_3128);
		} else if (relationshipType == PLMElementTypes.ConnectionEnd_4036) {
			types.add(PLMElementTypes.Connection_3099);
			types.add(PLMElementTypes.Connection_3111);
			types.add(PLMElementTypes.Connection_3127);
		}
		return types;
	}

}

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
import org.melanee.core.modeleditor.providers.PLMElementTypes;
import org.melanee.core.modeleditor.providers.PLMModelingAssistantProvider;

/**
 * @generated
 */
public class PLMModelingAssistantProviderOfEntity3EditPart extends PLMModelingAssistantProvider {

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
    IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
        .getAdapter(IGraphicalEditPart.class);
    return doGetRelTypesOnSource((Entity3EditPart) sourceEditPart);
  }

  /**
   * @generated
   */
  public List<IElementType> doGetRelTypesOnSource(Entity3EditPart source) {
    List<IElementType> types = new ArrayList<IElementType>(1);
    types.add(PLMElementTypes.Classification_4026);
    return types;
  }

  /**
   * @generated
   */
  @Override

  public List<IElementType> getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
    IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
        .getAdapter(IGraphicalEditPart.class);
    IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
        .getAdapter(IGraphicalEditPart.class);
    return doGetRelTypesOnSourceAndTarget((Entity3EditPart) sourceEditPart, targetEditPart);
  }

  /**
   * @generated
   */
  public List<IElementType> doGetRelTypesOnSourceAndTarget(Entity3EditPart source,
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
    IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
        .getAdapter(IGraphicalEditPart.class);
    return doGetTypesForTarget((Entity3EditPart) sourceEditPart, relationshipType);
  }

  /**
   * @generated
   */
  public List<IElementType> doGetTypesForTarget(Entity3EditPart source,
      IElementType relationshipType) {
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
    IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
        .getAdapter(IGraphicalEditPart.class);
    return doGetRelTypesOnTarget((Entity3EditPart) targetEditPart);
  }

  /**
   * @generated
   */
  public List<IElementType> doGetRelTypesOnTarget(Entity3EditPart target) {
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
    IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
        .getAdapter(IGraphicalEditPart.class);
    return doGetTypesForSource((Entity3EditPart) targetEditPart, relationshipType);
  }

  /**
   * @generated
   */
  public List<IElementType> doGetTypesForSource(Entity3EditPart target,
      IElementType relationshipType) {
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

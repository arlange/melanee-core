/*******************************************************************************
 * Copyright (c) 2013, 2014 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Ralph Gerbig    - initial API and implementation and initial documentation
 *    Daniel Gritzner - moved to separate file, expanded API
 *******************************************************************************/
package org.melanee.core.modeleditor.custom.selectioneditpolicies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IResizableCompartmentEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.melanee.core.modeleditor.edit.parts.Connection2EditPart;
import org.melanee.core.modeleditor.edit.parts.Connection3EditPart;
import org.melanee.core.modeleditor.edit.parts.ConnectionEditPart;
import org.melanee.core.modeleditor.edit.parts.Entity2EditPart;
import org.melanee.core.modeleditor.edit.parts.Entity3EditPart;
import org.melanee.core.modeleditor.edit.parts.EntityEditPart;

public abstract class AbstractClabjectEditPart {
  AbstractClabjectEditPart() {
  }

  static public AbstractClabjectEditPart create(EditPart editPart) {
    if (editPart instanceof EntityEditPart)
      return new ClabjectEditPart_EntityImpl((EntityEditPart) editPart);
    else if (editPart instanceof Entity2EditPart)
      return new ClabjectEditPart_Entity2Impl((Entity2EditPart) editPart);
    if (editPart instanceof Entity3EditPart)
      return new ClabjectEditPart_Entity3Impl((Entity3EditPart) editPart);
    else if (editPart instanceof ConnectionEditPart)
      return new ClabjectEditPart_ConnectionImpl((ConnectionEditPart) editPart);
    else if (editPart instanceof Connection2EditPart)
      return new ClabjectEditPart_Connection2Impl((Connection2EditPart) editPart);
    else if (editPart instanceof Connection3EditPart)
      return new ClabjectEditPart_Connection3Impl((Connection3EditPart) editPart);

    throw new RuntimeException();
  }

  abstract public IGraphicalEditPart getGraphicalEditPart();

  abstract public void makeCompartmentsVisible(int compartments);

  abstract public IResizableCompartmentEditPart getAttributesCompartment();

  abstract public IResizableCompartmentEditPart getMethodsCompartment();

  abstract public IResizableCompartmentEditPart getContentsCompartment();

  abstract public TransactionalEditingDomain getEditingDomain();

  abstract public EObject resolveSemanticElement();

  abstract public View getNotationView();

  static private class ClabjectEditPart_EntityImpl extends AbstractClabjectEditPart {
    private EntityEditPart editPart = null;

    public ClabjectEditPart_EntityImpl(EntityEditPart editPart) {
      this.editPart = editPart;
    }

    @Override
    public IGraphicalEditPart getGraphicalEditPart() {
      return editPart;
    }

    @Override
    public void makeCompartmentsVisible(int compartments) {
      editPart.makeCompartmentsVisible(compartments);
    }

    @Override
    public IResizableCompartmentEditPart getAttributesCompartment() {
      return editPart.getAttributesCompartment();
    }

    @Override
    public IResizableCompartmentEditPart getMethodsCompartment() {
      return editPart.getMethodsCompartment();
    }

    @Override
    public IResizableCompartmentEditPart getContentsCompartment() {
      return editPart.getContentsCompartment();
    }

    @Override
    public TransactionalEditingDomain getEditingDomain() {
      return editPart.getEditingDomain();
    }

    @Override
    public EObject resolveSemanticElement() {
      return editPart.resolveSemanticElement();
    }

    @Override
    public View getNotationView() {
      return editPart.getNotationView();
    }
  }

  static private class ClabjectEditPart_Entity2Impl extends AbstractClabjectEditPart {
    private Entity2EditPart editPart = null;

    public ClabjectEditPart_Entity2Impl(Entity2EditPart editPart) {
      this.editPart = editPart;
    }

    @Override
    public IGraphicalEditPart getGraphicalEditPart() {
      return editPart;
    }

    @Override
    public void makeCompartmentsVisible(int compartments) {
      editPart.makeCompartmentsVisible(compartments);
    }

    @Override
    public IResizableCompartmentEditPart getAttributesCompartment() {
      return editPart.getAttributesCompartment();
    }

    @Override
    public IResizableCompartmentEditPart getMethodsCompartment() {
      return editPart.getMethodsCompartment();
    }

    @Override
    public IResizableCompartmentEditPart getContentsCompartment() {
      return editPart.getContentsCompartment();
    }

    @Override
    public TransactionalEditingDomain getEditingDomain() {
      return editPart.getEditingDomain();
    }

    @Override
    public EObject resolveSemanticElement() {
      return editPart.resolveSemanticElement();
    }

    @Override
    public View getNotationView() {
      return editPart.getNotationView();
    }
  }

  static private class ClabjectEditPart_Entity3Impl extends AbstractClabjectEditPart {
    private Entity3EditPart editPart = null;

    public ClabjectEditPart_Entity3Impl(Entity3EditPart editPart) {
      this.editPart = editPart;
    }

    @Override
    public IGraphicalEditPart getGraphicalEditPart() {
      return editPart;
    }

    @Override
    public void makeCompartmentsVisible(int compartments) {
      editPart.makeCompartmentsVisible(compartments);
    }

    @Override
    public IResizableCompartmentEditPart getAttributesCompartment() {
      return editPart.getAttributesCompartment();
    }

    @Override
    public IResizableCompartmentEditPart getMethodsCompartment() {
      return editPart.getMethodsCompartment();
    }

    @Override
    public IResizableCompartmentEditPart getContentsCompartment() {
      return editPart.getContentsCompartment();
    }

    @Override
    public TransactionalEditingDomain getEditingDomain() {
      return editPart.getEditingDomain();
    }

    @Override
    public EObject resolveSemanticElement() {
      return editPart.resolveSemanticElement();
    }

    @Override
    public View getNotationView() {
      return editPart.getNotationView();
    }
  }

  static private class ClabjectEditPart_ConnectionImpl extends AbstractClabjectEditPart {
    private ConnectionEditPart editPart = null;

    public ClabjectEditPart_ConnectionImpl(ConnectionEditPart editPart) {
      this.editPart = editPart;
    }

    @Override
    public IGraphicalEditPart getGraphicalEditPart() {
      return editPart;
    }

    @Override
    public void makeCompartmentsVisible(int compartments) {
      editPart.makeCompartmentsVisible(compartments);
    }

    @Override
    public IResizableCompartmentEditPart getAttributesCompartment() {
      return editPart.getAttributesCompartment();
    }

    @Override
    public IResizableCompartmentEditPart getMethodsCompartment() {
      return editPart.getMethodsCompartment();
    }

    @Override
    public IResizableCompartmentEditPart getContentsCompartment() {
      return editPart.getContentsCompartment();
    }

    @Override
    public TransactionalEditingDomain getEditingDomain() {
      return editPart.getEditingDomain();
    }

    @Override
    public EObject resolveSemanticElement() {
      return editPart.resolveSemanticElement();
    }

    @Override
    public View getNotationView() {
      return editPart.getNotationView();
    }
  }

  static private class ClabjectEditPart_Connection2Impl extends AbstractClabjectEditPart {
    private Connection2EditPart editPart = null;

    public ClabjectEditPart_Connection2Impl(Connection2EditPart editPart) {
      this.editPart = editPart;
    }

    @Override
    public IGraphicalEditPart getGraphicalEditPart() {
      return editPart;
    }

    @Override
    public void makeCompartmentsVisible(int compartments) {
      editPart.makeCompartmentsVisible(compartments);
    }

    @Override
    public IResizableCompartmentEditPart getAttributesCompartment() {
      return editPart.getAttributesCompartment();
    }

    @Override
    public IResizableCompartmentEditPart getMethodsCompartment() {
      return editPart.getMethodsCompartment();
    }

    @Override
    public IResizableCompartmentEditPart getContentsCompartment() {
      return editPart.getContentsCompartment();
    }

    @Override
    public TransactionalEditingDomain getEditingDomain() {
      return editPart.getEditingDomain();
    }

    @Override
    public EObject resolveSemanticElement() {
      return editPart.resolveSemanticElement();
    }

    @Override
    public View getNotationView() {
      return editPart.getNotationView();
    }
  }

  static private class ClabjectEditPart_Connection3Impl extends AbstractClabjectEditPart {
    private Connection3EditPart editPart = null;

    public ClabjectEditPart_Connection3Impl(Connection3EditPart editPart) {
      this.editPart = editPart;
    }

    @Override
    public IGraphicalEditPart getGraphicalEditPart() {
      return editPart;
    }

    @Override
    public void makeCompartmentsVisible(int compartments) {
      editPart.makeCompartmentsVisible(compartments);
    }

    @Override
    public IResizableCompartmentEditPart getAttributesCompartment() {
      return editPart.getAttributesCompartment();
    }

    @Override
    public IResizableCompartmentEditPart getMethodsCompartment() {
      return editPart.getMethodsCompartment();
    }

    @Override
    public IResizableCompartmentEditPart getContentsCompartment() {
      return editPart.getContentsCompartment();
    }

    @Override
    public TransactionalEditingDomain getEditingDomain() {
      return editPart.getEditingDomain();
    }

    @Override
    public EObject resolveSemanticElement() {
      return editPart.resolveSemanticElement();
    }

    @Override
    public View getNotationView() {
      return editPart.getNotationView();
    }
  }
}

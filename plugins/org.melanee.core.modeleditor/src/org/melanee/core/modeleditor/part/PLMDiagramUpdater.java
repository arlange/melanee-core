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
package org.melanee.core.modeleditor.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;
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
import org.melanee.core.modeleditor.providers.PLMElementTypes;
import org.melanee.core.models.plm.PLM.Clabject;
import org.melanee.core.models.plm.PLM.Classification;
import org.melanee.core.models.plm.PLM.Connection;
import org.melanee.core.models.plm.PLM.ConnectionEnd;
import org.melanee.core.models.plm.PLM.DeepModel;
import org.melanee.core.models.plm.PLM.Domain;
import org.melanee.core.models.plm.PLM.Element;
import org.melanee.core.models.plm.PLM.Entity;
import org.melanee.core.models.plm.PLM.Enumeration;
import org.melanee.core.models.plm.PLM.Feature;
import org.melanee.core.models.plm.PLM.Inheritance;
import org.melanee.core.models.plm.PLM.Level;
import org.melanee.core.models.plm.PLM.OwnedElement;
import org.melanee.core.models.plm.PLM.PLMPackage;
import org.melanee.core.models.plm.PLM.Package;
import org.melanee.core.models.plm.PLM.Subtype;
import org.melanee.core.models.plm.PLM.Supertype;

/**
 * @generated
 */
public class PLMDiagramUpdater {

  /**
   * @generated
   */
  public static List<PLMNodeDescriptor> getSemanticChildren(View view) {
    switch (PLMVisualIDRegistry.getVisualID(view)) {
    case DomainEditPart.VISUAL_ID:
      return getDomain_1000SemanticChildren(view);
    case DeepModelDeepModelEnumerationCompartmentEditPart.VISUAL_ID:
      return getDeepModelDeepModelEnumerationCompartment_7061SemanticChildren(view);
    case DeepModelDeepModelLevelCompartmentEditPart.VISUAL_ID:
      return getDeepModelDeepModelLevelCompartment_7062SemanticChildren(view);
    case LevelDomainElementsCompartmentEditPart.VISUAL_ID:
      return getLevelDomainElementsCompartment_7046SemanticChildren(view);
    case ConnectionConnectionAttributesCompartmentEditPart.VISUAL_ID:
      return getConnectionConnectionAttributesCompartment_7047SemanticChildren(view);
    case ConnectionConnectionMethodsCompartmentEditPart.VISUAL_ID:
      return getConnectionConnectionMethodsCompartment_7048SemanticChildren(view);
    case ConnectionConnectionContentsCompartmentEditPart.VISUAL_ID:
      return getConnectionConnectionContentsCompartment_7049SemanticChildren(view);
    case EntityEntityAttributesCompartmentEditPart.VISUAL_ID:
      return getEntityEntityAttributesCompartment_7051SemanticChildren(view);
    case EntityEntityMethodsCompartmentEditPart.VISUAL_ID:
      return getEntityEntityMethodsCompartment_7052SemanticChildren(view);
    case EntityEntityContentsCompartmentEditPart.VISUAL_ID:
      return getEntityEntityContentsCompartment_7053SemanticChildren(view);
    case ConnectionConnectionAttributesCompartment2EditPart.VISUAL_ID:
      return getConnectionConnectionAttributesCompartment_7054SemanticChildren(view);
    case ConnectionConnectionMethodsCompartment2EditPart.VISUAL_ID:
      return getConnectionConnectionMethodsCompartment_7055SemanticChildren(view);
    case ConnectionConnectionContentsCompartment2EditPart.VISUAL_ID:
      return getConnectionConnectionContentsCompartment_7056SemanticChildren(view);
    case EntityEntityAttributesCompartment2EditPart.VISUAL_ID:
      return getEntityEntityAttributesCompartment_7058SemanticChildren(view);
    case EntityEntityMethodsCompartment2EditPart.VISUAL_ID:
      return getEntityEntityMethodsCompartment_7059SemanticChildren(view);
    case EntityEntityContentsCompartment2EditPart.VISUAL_ID:
      return getEntityEntityContentsCompartment_7060SemanticChildren(view);
    case PackagePackageContentCompartmentEditPart.VISUAL_ID:
      return getPackagePackageContentCompartment_7063SemanticChildren(view);
    case EntityEntityAttributesCompartment3EditPart.VISUAL_ID:
      return getEntityEntityAttributesCompartment_7064SemanticChildren(view);
    case EntityEntityMethodsCompartment3EditPart.VISUAL_ID:
      return getEntityEntityMethodsCompartment_7065SemanticChildren(view);
    case EntityEntityContentsCompartment3EditPart.VISUAL_ID:
      return getEntityEntityContentsCompartment_7066SemanticChildren(view);
    case ConnectionConnectionAttributesCompartment3EditPart.VISUAL_ID:
      return getConnectionConnectionAttributesCompartment_7067SemanticChildren(view);
    case ConnectionConnectionMethodsCompartment3EditPart.VISUAL_ID:
      return getConnectionConnectionMethodsCompartment_7068SemanticChildren(view);
    case ConnectionConnectionContentsCompartment3EditPart.VISUAL_ID:
      return getConnectionConnectionContentsCompartment_7069SemanticChildren(view);
    case PackagePackageContentCompartment2EditPart.VISUAL_ID:
      return getPackagePackageContentCompartment_7070SemanticChildren(view);
    }
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<PLMNodeDescriptor> getDomain_1000SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.emptyList();
    }
    Domain modelElement = (Domain) view.getElement();
    LinkedList<PLMNodeDescriptor> result = new LinkedList<PLMNodeDescriptor>();
    for (Iterator<?> it = modelElement.getDeepModel().iterator(); it.hasNext();) {
      Element childElement = (Element) it.next();
      int visualID = PLMVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == DeepModelEditPart.VISUAL_ID) {
        result.add(new PLMNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List<PLMNodeDescriptor> getDeepModelDeepModelEnumerationCompartment_7061SemanticChildren(
      View view) {
    if (false == view.eContainer() instanceof View) {
      return Collections.emptyList();
    }
    View containerView = (View) view.eContainer();
    if (!containerView.isSetElement()) {
      return Collections.emptyList();
    }
    DeepModel modelElement = (DeepModel) containerView.getElement();
    LinkedList<PLMNodeDescriptor> result = new LinkedList<PLMNodeDescriptor>();
    for (Iterator<?> it = modelElement.getEnumeration().iterator(); it.hasNext();) {
      Enumeration childElement = (Enumeration) it.next();
      int visualID = PLMVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == EnumerationEditPart.VISUAL_ID) {
        result.add(new PLMNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List<PLMNodeDescriptor> getDeepModelDeepModelLevelCompartment_7062SemanticChildren(
      View view) {
    if (false == view.eContainer() instanceof View) {
      return Collections.emptyList();
    }
    View containerView = (View) view.eContainer();
    if (!containerView.isSetElement()) {
      return Collections.emptyList();
    }
    DeepModel modelElement = (DeepModel) containerView.getElement();
    LinkedList<PLMNodeDescriptor> result = new LinkedList<PLMNodeDescriptor>();
    for (Iterator<?> it = modelElement.getContent().iterator(); it.hasNext();) {
      Level childElement = (Level) it.next();
      int visualID = PLMVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == LevelEditPart.VISUAL_ID) {
        result.add(new PLMNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List<PLMNodeDescriptor> getLevelDomainElementsCompartment_7046SemanticChildren(
      View view) {
    if (false == view.eContainer() instanceof View) {
      return Collections.emptyList();
    }
    View containerView = (View) view.eContainer();
    if (!containerView.isSetElement()) {
      return Collections.emptyList();
    }
    Level modelElement = (Level) containerView.getElement();
    LinkedList<PLMNodeDescriptor> result = new LinkedList<PLMNodeDescriptor>();
    for (Iterator<?> it = modelElement.getContent().iterator(); it.hasNext();) {
      OwnedElement childElement = (OwnedElement) it.next();
      int visualID = PLMVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == ConnectionEditPart.VISUAL_ID) {
        result.add(new PLMNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == Inheritance2EditPart.VISUAL_ID) {
        result.add(new PLMNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == Entity2EditPart.VISUAL_ID) {
        result.add(new PLMNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == PackageEditPart.VISUAL_ID) {
        result.add(new PLMNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List<PLMNodeDescriptor> getConnectionConnectionAttributesCompartment_7047SemanticChildren(
      View view) {
    if (false == view.eContainer() instanceof View) {
      return Collections.emptyList();
    }
    View containerView = (View) view.eContainer();
    if (!containerView.isSetElement()) {
      return Collections.emptyList();
    }
    Connection modelElement = (Connection) containerView.getElement();
    LinkedList<PLMNodeDescriptor> result = new LinkedList<PLMNodeDescriptor>();
    for (Iterator<?> it = modelElement.getFeature().iterator(); it.hasNext();) {
      Feature childElement = (Feature) it.next();
      int visualID = PLMVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == AttributeEditPart.VISUAL_ID) {
        result.add(new PLMNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List<PLMNodeDescriptor> getConnectionConnectionMethodsCompartment_7048SemanticChildren(
      View view) {
    if (false == view.eContainer() instanceof View) {
      return Collections.emptyList();
    }
    View containerView = (View) view.eContainer();
    if (!containerView.isSetElement()) {
      return Collections.emptyList();
    }
    Connection modelElement = (Connection) containerView.getElement();
    LinkedList<PLMNodeDescriptor> result = new LinkedList<PLMNodeDescriptor>();
    for (Iterator<?> it = modelElement.getFeature().iterator(); it.hasNext();) {
      Feature childElement = (Feature) it.next();
      int visualID = PLMVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == MethodEditPart.VISUAL_ID) {
        result.add(new PLMNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List<PLMNodeDescriptor> getConnectionConnectionContentsCompartment_7049SemanticChildren(
      View view) {
    if (false == view.eContainer() instanceof View) {
      return Collections.emptyList();
    }
    View containerView = (View) view.eContainer();
    if (!containerView.isSetElement()) {
      return Collections.emptyList();
    }
    Connection modelElement = (Connection) containerView.getElement();
    LinkedList<PLMNodeDescriptor> result = new LinkedList<PLMNodeDescriptor>();
    for (Iterator<?> it = modelElement.getContent().iterator(); it.hasNext();) {
      OwnedElement childElement = (OwnedElement) it.next();
      int visualID = PLMVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == EntityEditPart.VISUAL_ID) {
        result.add(new PLMNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == Connection2EditPart.VISUAL_ID) {
        result.add(new PLMNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == InheritanceEditPart.VISUAL_ID) {
        result.add(new PLMNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List<PLMNodeDescriptor> getEntityEntityAttributesCompartment_7051SemanticChildren(
      View view) {
    if (false == view.eContainer() instanceof View) {
      return Collections.emptyList();
    }
    View containerView = (View) view.eContainer();
    if (!containerView.isSetElement()) {
      return Collections.emptyList();
    }
    Entity modelElement = (Entity) containerView.getElement();
    LinkedList<PLMNodeDescriptor> result = new LinkedList<PLMNodeDescriptor>();
    for (Iterator<?> it = modelElement.getFeature().iterator(); it.hasNext();) {
      Feature childElement = (Feature) it.next();
      int visualID = PLMVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == Attribute2EditPart.VISUAL_ID) {
        result.add(new PLMNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List<PLMNodeDescriptor> getEntityEntityMethodsCompartment_7052SemanticChildren(
      View view) {
    if (false == view.eContainer() instanceof View) {
      return Collections.emptyList();
    }
    View containerView = (View) view.eContainer();
    if (!containerView.isSetElement()) {
      return Collections.emptyList();
    }
    Entity modelElement = (Entity) containerView.getElement();
    LinkedList<PLMNodeDescriptor> result = new LinkedList<PLMNodeDescriptor>();
    for (Iterator<?> it = modelElement.getFeature().iterator(); it.hasNext();) {
      Feature childElement = (Feature) it.next();
      int visualID = PLMVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == Method2EditPart.VISUAL_ID) {
        result.add(new PLMNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List<PLMNodeDescriptor> getEntityEntityContentsCompartment_7053SemanticChildren(
      View view) {
    if (false == view.eContainer() instanceof View) {
      return Collections.emptyList();
    }
    View containerView = (View) view.eContainer();
    if (!containerView.isSetElement()) {
      return Collections.emptyList();
    }
    Entity modelElement = (Entity) containerView.getElement();
    LinkedList<PLMNodeDescriptor> result = new LinkedList<PLMNodeDescriptor>();
    for (Iterator<?> it = modelElement.getContent().iterator(); it.hasNext();) {
      OwnedElement childElement = (OwnedElement) it.next();
      int visualID = PLMVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == EntityEditPart.VISUAL_ID) {
        result.add(new PLMNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == Connection2EditPart.VISUAL_ID) {
        result.add(new PLMNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == InheritanceEditPart.VISUAL_ID) {
        result.add(new PLMNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List<PLMNodeDescriptor> getConnectionConnectionAttributesCompartment_7054SemanticChildren(
      View view) {
    if (false == view.eContainer() instanceof View) {
      return Collections.emptyList();
    }
    View containerView = (View) view.eContainer();
    if (!containerView.isSetElement()) {
      return Collections.emptyList();
    }
    Connection modelElement = (Connection) containerView.getElement();
    LinkedList<PLMNodeDescriptor> result = new LinkedList<PLMNodeDescriptor>();
    for (Iterator<?> it = modelElement.getFeature().iterator(); it.hasNext();) {
      Feature childElement = (Feature) it.next();
      int visualID = PLMVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == AttributeEditPart.VISUAL_ID) {
        result.add(new PLMNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List<PLMNodeDescriptor> getConnectionConnectionMethodsCompartment_7055SemanticChildren(
      View view) {
    if (false == view.eContainer() instanceof View) {
      return Collections.emptyList();
    }
    View containerView = (View) view.eContainer();
    if (!containerView.isSetElement()) {
      return Collections.emptyList();
    }
    Connection modelElement = (Connection) containerView.getElement();
    LinkedList<PLMNodeDescriptor> result = new LinkedList<PLMNodeDescriptor>();
    for (Iterator<?> it = modelElement.getFeature().iterator(); it.hasNext();) {
      Feature childElement = (Feature) it.next();
      int visualID = PLMVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == MethodEditPart.VISUAL_ID) {
        result.add(new PLMNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List<PLMNodeDescriptor> getConnectionConnectionContentsCompartment_7056SemanticChildren(
      View view) {
    if (false == view.eContainer() instanceof View) {
      return Collections.emptyList();
    }
    View containerView = (View) view.eContainer();
    if (!containerView.isSetElement()) {
      return Collections.emptyList();
    }
    Connection modelElement = (Connection) containerView.getElement();
    LinkedList<PLMNodeDescriptor> result = new LinkedList<PLMNodeDescriptor>();
    for (Iterator<?> it = modelElement.getContent().iterator(); it.hasNext();) {
      OwnedElement childElement = (OwnedElement) it.next();
      int visualID = PLMVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == EntityEditPart.VISUAL_ID) {
        result.add(new PLMNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == Connection2EditPart.VISUAL_ID) {
        result.add(new PLMNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == InheritanceEditPart.VISUAL_ID) {
        result.add(new PLMNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List<PLMNodeDescriptor> getEntityEntityAttributesCompartment_7058SemanticChildren(
      View view) {
    if (false == view.eContainer() instanceof View) {
      return Collections.emptyList();
    }
    View containerView = (View) view.eContainer();
    if (!containerView.isSetElement()) {
      return Collections.emptyList();
    }
    Entity modelElement = (Entity) containerView.getElement();
    LinkedList<PLMNodeDescriptor> result = new LinkedList<PLMNodeDescriptor>();
    for (Iterator<?> it = modelElement.getFeature().iterator(); it.hasNext();) {
      Feature childElement = (Feature) it.next();
      int visualID = PLMVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == Attribute2EditPart.VISUAL_ID) {
        result.add(new PLMNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List<PLMNodeDescriptor> getEntityEntityMethodsCompartment_7059SemanticChildren(
      View view) {
    if (false == view.eContainer() instanceof View) {
      return Collections.emptyList();
    }
    View containerView = (View) view.eContainer();
    if (!containerView.isSetElement()) {
      return Collections.emptyList();
    }
    Entity modelElement = (Entity) containerView.getElement();
    LinkedList<PLMNodeDescriptor> result = new LinkedList<PLMNodeDescriptor>();
    for (Iterator<?> it = modelElement.getFeature().iterator(); it.hasNext();) {
      Feature childElement = (Feature) it.next();
      int visualID = PLMVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == Method2EditPart.VISUAL_ID) {
        result.add(new PLMNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List<PLMNodeDescriptor> getEntityEntityContentsCompartment_7060SemanticChildren(
      View view) {
    if (false == view.eContainer() instanceof View) {
      return Collections.emptyList();
    }
    View containerView = (View) view.eContainer();
    if (!containerView.isSetElement()) {
      return Collections.emptyList();
    }
    Entity modelElement = (Entity) containerView.getElement();
    LinkedList<PLMNodeDescriptor> result = new LinkedList<PLMNodeDescriptor>();
    for (Iterator<?> it = modelElement.getContent().iterator(); it.hasNext();) {
      OwnedElement childElement = (OwnedElement) it.next();
      int visualID = PLMVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == EntityEditPart.VISUAL_ID) {
        result.add(new PLMNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == Connection2EditPart.VISUAL_ID) {
        result.add(new PLMNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == InheritanceEditPart.VISUAL_ID) {
        result.add(new PLMNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List<PLMNodeDescriptor> getPackagePackageContentCompartment_7063SemanticChildren(
      View view) {
    if (false == view.eContainer() instanceof View) {
      return Collections.emptyList();
    }
    View containerView = (View) view.eContainer();
    if (!containerView.isSetElement()) {
      return Collections.emptyList();
    }
    Package modelElement = (Package) containerView.getElement();
    LinkedList<PLMNodeDescriptor> result = new LinkedList<PLMNodeDescriptor>();
    for (Iterator<?> it = modelElement.getContent().iterator(); it.hasNext();) {
      OwnedElement childElement = (OwnedElement) it.next();
      int visualID = PLMVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == Entity3EditPart.VISUAL_ID) {
        result.add(new PLMNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == Connection3EditPart.VISUAL_ID) {
        result.add(new PLMNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == Inheritance3EditPart.VISUAL_ID) {
        result.add(new PLMNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == Package2EditPart.VISUAL_ID) {
        result.add(new PLMNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List<PLMNodeDescriptor> getEntityEntityAttributesCompartment_7064SemanticChildren(
      View view) {
    if (false == view.eContainer() instanceof View) {
      return Collections.emptyList();
    }
    View containerView = (View) view.eContainer();
    if (!containerView.isSetElement()) {
      return Collections.emptyList();
    }
    Entity modelElement = (Entity) containerView.getElement();
    LinkedList<PLMNodeDescriptor> result = new LinkedList<PLMNodeDescriptor>();
    for (Iterator<?> it = modelElement.getFeature().iterator(); it.hasNext();) {
      Feature childElement = (Feature) it.next();
      int visualID = PLMVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == Attribute2EditPart.VISUAL_ID) {
        result.add(new PLMNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List<PLMNodeDescriptor> getEntityEntityMethodsCompartment_7065SemanticChildren(
      View view) {
    if (false == view.eContainer() instanceof View) {
      return Collections.emptyList();
    }
    View containerView = (View) view.eContainer();
    if (!containerView.isSetElement()) {
      return Collections.emptyList();
    }
    Entity modelElement = (Entity) containerView.getElement();
    LinkedList<PLMNodeDescriptor> result = new LinkedList<PLMNodeDescriptor>();
    for (Iterator<?> it = modelElement.getFeature().iterator(); it.hasNext();) {
      Feature childElement = (Feature) it.next();
      int visualID = PLMVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == Method2EditPart.VISUAL_ID) {
        result.add(new PLMNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List<PLMNodeDescriptor> getEntityEntityContentsCompartment_7066SemanticChildren(
      View view) {
    if (false == view.eContainer() instanceof View) {
      return Collections.emptyList();
    }
    View containerView = (View) view.eContainer();
    if (!containerView.isSetElement()) {
      return Collections.emptyList();
    }
    Entity modelElement = (Entity) containerView.getElement();
    LinkedList<PLMNodeDescriptor> result = new LinkedList<PLMNodeDescriptor>();
    for (Iterator<?> it = modelElement.getContent().iterator(); it.hasNext();) {
      OwnedElement childElement = (OwnedElement) it.next();
      int visualID = PLMVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == EntityEditPart.VISUAL_ID) {
        result.add(new PLMNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == Connection2EditPart.VISUAL_ID) {
        result.add(new PLMNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == InheritanceEditPart.VISUAL_ID) {
        result.add(new PLMNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List<PLMNodeDescriptor> getConnectionConnectionAttributesCompartment_7067SemanticChildren(
      View view) {
    if (false == view.eContainer() instanceof View) {
      return Collections.emptyList();
    }
    View containerView = (View) view.eContainer();
    if (!containerView.isSetElement()) {
      return Collections.emptyList();
    }
    Connection modelElement = (Connection) containerView.getElement();
    LinkedList<PLMNodeDescriptor> result = new LinkedList<PLMNodeDescriptor>();
    for (Iterator<?> it = modelElement.getFeature().iterator(); it.hasNext();) {
      Feature childElement = (Feature) it.next();
      int visualID = PLMVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == AttributeEditPart.VISUAL_ID) {
        result.add(new PLMNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List<PLMNodeDescriptor> getConnectionConnectionMethodsCompartment_7068SemanticChildren(
      View view) {
    if (false == view.eContainer() instanceof View) {
      return Collections.emptyList();
    }
    View containerView = (View) view.eContainer();
    if (!containerView.isSetElement()) {
      return Collections.emptyList();
    }
    Connection modelElement = (Connection) containerView.getElement();
    LinkedList<PLMNodeDescriptor> result = new LinkedList<PLMNodeDescriptor>();
    for (Iterator<?> it = modelElement.getFeature().iterator(); it.hasNext();) {
      Feature childElement = (Feature) it.next();
      int visualID = PLMVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == MethodEditPart.VISUAL_ID) {
        result.add(new PLMNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List<PLMNodeDescriptor> getConnectionConnectionContentsCompartment_7069SemanticChildren(
      View view) {
    if (false == view.eContainer() instanceof View) {
      return Collections.emptyList();
    }
    View containerView = (View) view.eContainer();
    if (!containerView.isSetElement()) {
      return Collections.emptyList();
    }
    Connection modelElement = (Connection) containerView.getElement();
    LinkedList<PLMNodeDescriptor> result = new LinkedList<PLMNodeDescriptor>();
    for (Iterator<?> it = modelElement.getContent().iterator(); it.hasNext();) {
      OwnedElement childElement = (OwnedElement) it.next();
      int visualID = PLMVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == EntityEditPart.VISUAL_ID) {
        result.add(new PLMNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == Connection2EditPart.VISUAL_ID) {
        result.add(new PLMNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == InheritanceEditPart.VISUAL_ID) {
        result.add(new PLMNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List<PLMNodeDescriptor> getPackagePackageContentCompartment_7070SemanticChildren(
      View view) {
    if (false == view.eContainer() instanceof View) {
      return Collections.emptyList();
    }
    View containerView = (View) view.eContainer();
    if (!containerView.isSetElement()) {
      return Collections.emptyList();
    }
    Package modelElement = (Package) containerView.getElement();
    LinkedList<PLMNodeDescriptor> result = new LinkedList<PLMNodeDescriptor>();
    for (Iterator<?> it = modelElement.getContent().iterator(); it.hasNext();) {
      OwnedElement childElement = (OwnedElement) it.next();
      int visualID = PLMVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == Entity3EditPart.VISUAL_ID) {
        result.add(new PLMNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == Connection3EditPart.VISUAL_ID) {
        result.add(new PLMNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == Inheritance3EditPart.VISUAL_ID) {
        result.add(new PLMNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == Package2EditPart.VISUAL_ID) {
        result.add(new PLMNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getContainedLinks(View view) {
    switch (PLMVisualIDRegistry.getVisualID(view)) {
    case DomainEditPart.VISUAL_ID:
      return getDomain_1000ContainedLinks(view);
    case DeepModelEditPart.VISUAL_ID:
      return getDeepModel_2005ContainedLinks(view);
    case EnumerationEditPart.VISUAL_ID:
      return getEnumeration_3123ContainedLinks(view);
    case LevelEditPart.VISUAL_ID:
      return getLevel_3097ContainedLinks(view);
    case ConnectionEditPart.VISUAL_ID:
      return getConnection_3099ContainedLinks(view);
    case AttributeEditPart.VISUAL_ID:
      return getAttribute_3100ContainedLinks(view);
    case MethodEditPart.VISUAL_ID:
      return getMethod_3102ContainedLinks(view);
    case EntityEditPart.VISUAL_ID:
      return getEntity_3105ContainedLinks(view);
    case Attribute2EditPart.VISUAL_ID:
      return getAttribute_3106ContainedLinks(view);
    case Method2EditPart.VISUAL_ID:
      return getMethod_3108ContainedLinks(view);
    case Connection2EditPart.VISUAL_ID:
      return getConnection_3111ContainedLinks(view);
    case InheritanceEditPart.VISUAL_ID:
      return getInheritance_3124ContainedLinks(view);
    case Inheritance2EditPart.VISUAL_ID:
      return getInheritance_3122ContainedLinks(view);
    case Entity2EditPart.VISUAL_ID:
      return getEntity_3120ContainedLinks(view);
    case PackageEditPart.VISUAL_ID:
      return getPackage_3125ContainedLinks(view);
    case Entity3EditPart.VISUAL_ID:
      return getEntity_3126ContainedLinks(view);
    case Connection3EditPart.VISUAL_ID:
      return getConnection_3127ContainedLinks(view);
    case Inheritance3EditPart.VISUAL_ID:
      return getInheritance_3128ContainedLinks(view);
    case Package2EditPart.VISUAL_ID:
      return getPackage_3129ContainedLinks(view);
    case ClassificationEditPart.VISUAL_ID:
      return getClassification_4026ContainedLinks(view);
    case SupertypeEditPart.VISUAL_ID:
      return getSupertype_4034ContainedLinks(view);
    case SubtypeEditPart.VISUAL_ID:
      return getSubtype_4035ContainedLinks(view);
    case ConnectionEndEditPart.VISUAL_ID:
      return getConnectionEnd_4036ContainedLinks(view);
    }
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getIncomingLinks(View view) {
    switch (PLMVisualIDRegistry.getVisualID(view)) {
    case DeepModelEditPart.VISUAL_ID:
      return getDeepModel_2005IncomingLinks(view);
    case EnumerationEditPart.VISUAL_ID:
      return getEnumeration_3123IncomingLinks(view);
    case LevelEditPart.VISUAL_ID:
      return getLevel_3097IncomingLinks(view);
    case ConnectionEditPart.VISUAL_ID:
      return getConnection_3099IncomingLinks(view);
    case AttributeEditPart.VISUAL_ID:
      return getAttribute_3100IncomingLinks(view);
    case MethodEditPart.VISUAL_ID:
      return getMethod_3102IncomingLinks(view);
    case EntityEditPart.VISUAL_ID:
      return getEntity_3105IncomingLinks(view);
    case Attribute2EditPart.VISUAL_ID:
      return getAttribute_3106IncomingLinks(view);
    case Method2EditPart.VISUAL_ID:
      return getMethod_3108IncomingLinks(view);
    case Connection2EditPart.VISUAL_ID:
      return getConnection_3111IncomingLinks(view);
    case InheritanceEditPart.VISUAL_ID:
      return getInheritance_3124IncomingLinks(view);
    case Inheritance2EditPart.VISUAL_ID:
      return getInheritance_3122IncomingLinks(view);
    case Entity2EditPart.VISUAL_ID:
      return getEntity_3120IncomingLinks(view);
    case PackageEditPart.VISUAL_ID:
      return getPackage_3125IncomingLinks(view);
    case Entity3EditPart.VISUAL_ID:
      return getEntity_3126IncomingLinks(view);
    case Connection3EditPart.VISUAL_ID:
      return getConnection_3127IncomingLinks(view);
    case Inheritance3EditPart.VISUAL_ID:
      return getInheritance_3128IncomingLinks(view);
    case Package2EditPart.VISUAL_ID:
      return getPackage_3129IncomingLinks(view);
    case ClassificationEditPart.VISUAL_ID:
      return getClassification_4026IncomingLinks(view);
    case SupertypeEditPart.VISUAL_ID:
      return getSupertype_4034IncomingLinks(view);
    case SubtypeEditPart.VISUAL_ID:
      return getSubtype_4035IncomingLinks(view);
    case ConnectionEndEditPart.VISUAL_ID:
      return getConnectionEnd_4036IncomingLinks(view);
    }
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getOutgoingLinks(View view) {
    switch (PLMVisualIDRegistry.getVisualID(view)) {
    case DeepModelEditPart.VISUAL_ID:
      return getDeepModel_2005OutgoingLinks(view);
    case EnumerationEditPart.VISUAL_ID:
      return getEnumeration_3123OutgoingLinks(view);
    case LevelEditPart.VISUAL_ID:
      return getLevel_3097OutgoingLinks(view);
    case ConnectionEditPart.VISUAL_ID:
      return getConnection_3099OutgoingLinks(view);
    case AttributeEditPart.VISUAL_ID:
      return getAttribute_3100OutgoingLinks(view);
    case MethodEditPart.VISUAL_ID:
      return getMethod_3102OutgoingLinks(view);
    case EntityEditPart.VISUAL_ID:
      return getEntity_3105OutgoingLinks(view);
    case Attribute2EditPart.VISUAL_ID:
      return getAttribute_3106OutgoingLinks(view);
    case Method2EditPart.VISUAL_ID:
      return getMethod_3108OutgoingLinks(view);
    case Connection2EditPart.VISUAL_ID:
      return getConnection_3111OutgoingLinks(view);
    case InheritanceEditPart.VISUAL_ID:
      return getInheritance_3124OutgoingLinks(view);
    case Inheritance2EditPart.VISUAL_ID:
      return getInheritance_3122OutgoingLinks(view);
    case Entity2EditPart.VISUAL_ID:
      return getEntity_3120OutgoingLinks(view);
    case PackageEditPart.VISUAL_ID:
      return getPackage_3125OutgoingLinks(view);
    case Entity3EditPart.VISUAL_ID:
      return getEntity_3126OutgoingLinks(view);
    case Connection3EditPart.VISUAL_ID:
      return getConnection_3127OutgoingLinks(view);
    case Inheritance3EditPart.VISUAL_ID:
      return getInheritance_3128OutgoingLinks(view);
    case Package2EditPart.VISUAL_ID:
      return getPackage_3129OutgoingLinks(view);
    case ClassificationEditPart.VISUAL_ID:
      return getClassification_4026OutgoingLinks(view);
    case SupertypeEditPart.VISUAL_ID:
      return getSupertype_4034OutgoingLinks(view);
    case SubtypeEditPart.VISUAL_ID:
      return getSubtype_4035OutgoingLinks(view);
    case ConnectionEndEditPart.VISUAL_ID:
      return getConnectionEnd_4036OutgoingLinks(view);
    }
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getDomain_1000ContainedLinks(View view) {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getDeepModel_2005ContainedLinks(View view) {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getEnumeration_3123ContainedLinks(View view) {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getLevel_3097ContainedLinks(View view) {
    Level modelElement = (Level) view.getElement();
    LinkedList<PLMLinkDescriptor> result = new LinkedList<PLMLinkDescriptor>();
    result.addAll(getContainedTypeModelFacetLinks_Classification_4026(modelElement));
    return result;
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getConnection_3099ContainedLinks(View view) {
    Connection modelElement = (Connection) view.getElement();
    LinkedList<PLMLinkDescriptor> result = new LinkedList<PLMLinkDescriptor>();
    result.addAll(getContainedTypeModelFacetLinks_ConnectionEnd_4036(modelElement));
    return result;
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getAttribute_3100ContainedLinks(View view) {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getMethod_3102ContainedLinks(View view) {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getEntity_3105ContainedLinks(View view) {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getAttribute_3106ContainedLinks(View view) {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getMethod_3108ContainedLinks(View view) {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getConnection_3111ContainedLinks(View view) {
    Connection modelElement = (Connection) view.getElement();
    LinkedList<PLMLinkDescriptor> result = new LinkedList<PLMLinkDescriptor>();
    result.addAll(getContainedTypeModelFacetLinks_ConnectionEnd_4036(modelElement));
    return result;
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getInheritance_3124ContainedLinks(View view) {
    Inheritance modelElement = (Inheritance) view.getElement();
    LinkedList<PLMLinkDescriptor> result = new LinkedList<PLMLinkDescriptor>();
    result.addAll(getContainedTypeModelFacetLinks_Supertype_4034(modelElement));
    result.addAll(getContainedTypeModelFacetLinks_Subtype_4035(modelElement));
    return result;
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getInheritance_3122ContainedLinks(View view) {
    Inheritance modelElement = (Inheritance) view.getElement();
    LinkedList<PLMLinkDescriptor> result = new LinkedList<PLMLinkDescriptor>();
    result.addAll(getContainedTypeModelFacetLinks_Supertype_4034(modelElement));
    result.addAll(getContainedTypeModelFacetLinks_Subtype_4035(modelElement));
    return result;
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getEntity_3120ContainedLinks(View view) {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getPackage_3125ContainedLinks(View view) {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getEntity_3126ContainedLinks(View view) {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getConnection_3127ContainedLinks(View view) {
    Connection modelElement = (Connection) view.getElement();
    LinkedList<PLMLinkDescriptor> result = new LinkedList<PLMLinkDescriptor>();
    result.addAll(getContainedTypeModelFacetLinks_ConnectionEnd_4036(modelElement));
    return result;
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getInheritance_3128ContainedLinks(View view) {
    Inheritance modelElement = (Inheritance) view.getElement();
    LinkedList<PLMLinkDescriptor> result = new LinkedList<PLMLinkDescriptor>();
    result.addAll(getContainedTypeModelFacetLinks_Supertype_4034(modelElement));
    result.addAll(getContainedTypeModelFacetLinks_Subtype_4035(modelElement));
    return result;
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getPackage_3129ContainedLinks(View view) {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getClassification_4026ContainedLinks(View view) {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getSupertype_4034ContainedLinks(View view) {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getSubtype_4035ContainedLinks(View view) {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getConnectionEnd_4036ContainedLinks(View view) {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getDeepModel_2005IncomingLinks(View view) {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getEnumeration_3123IncomingLinks(View view) {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getLevel_3097IncomingLinks(View view) {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getConnection_3099IncomingLinks(View view) {
    Connection modelElement = (Connection) view.getElement();
    Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
        .find(view.eResource().getResourceSet().getResources());
    LinkedList<PLMLinkDescriptor> result = new LinkedList<PLMLinkDescriptor>();
    result
        .addAll(getIncomingTypeModelFacetLinks_Classification_4026(modelElement, crossReferences));
    result.addAll(getIncomingTypeModelFacetLinks_Supertype_4034(modelElement, crossReferences));
    result.addAll(getIncomingTypeModelFacetLinks_Subtype_4035(modelElement, crossReferences));
    result.addAll(getIncomingTypeModelFacetLinks_ConnectionEnd_4036(modelElement, crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getAttribute_3100IncomingLinks(View view) {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getMethod_3102IncomingLinks(View view) {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getEntity_3105IncomingLinks(View view) {
    Entity modelElement = (Entity) view.getElement();
    Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
        .find(view.eResource().getResourceSet().getResources());
    LinkedList<PLMLinkDescriptor> result = new LinkedList<PLMLinkDescriptor>();
    result
        .addAll(getIncomingTypeModelFacetLinks_Classification_4026(modelElement, crossReferences));
    result.addAll(getIncomingTypeModelFacetLinks_Supertype_4034(modelElement, crossReferences));
    result.addAll(getIncomingTypeModelFacetLinks_Subtype_4035(modelElement, crossReferences));
    result.addAll(getIncomingTypeModelFacetLinks_ConnectionEnd_4036(modelElement, crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getAttribute_3106IncomingLinks(View view) {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getMethod_3108IncomingLinks(View view) {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getConnection_3111IncomingLinks(View view) {
    Connection modelElement = (Connection) view.getElement();
    Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
        .find(view.eResource().getResourceSet().getResources());
    LinkedList<PLMLinkDescriptor> result = new LinkedList<PLMLinkDescriptor>();
    result
        .addAll(getIncomingTypeModelFacetLinks_Classification_4026(modelElement, crossReferences));
    result.addAll(getIncomingTypeModelFacetLinks_Supertype_4034(modelElement, crossReferences));
    result.addAll(getIncomingTypeModelFacetLinks_Subtype_4035(modelElement, crossReferences));
    result.addAll(getIncomingTypeModelFacetLinks_ConnectionEnd_4036(modelElement, crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getInheritance_3124IncomingLinks(View view) {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getInheritance_3122IncomingLinks(View view) {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getEntity_3120IncomingLinks(View view) {
    Entity modelElement = (Entity) view.getElement();
    Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
        .find(view.eResource().getResourceSet().getResources());
    LinkedList<PLMLinkDescriptor> result = new LinkedList<PLMLinkDescriptor>();
    result
        .addAll(getIncomingTypeModelFacetLinks_Classification_4026(modelElement, crossReferences));
    result.addAll(getIncomingTypeModelFacetLinks_Supertype_4034(modelElement, crossReferences));
    result.addAll(getIncomingTypeModelFacetLinks_Subtype_4035(modelElement, crossReferences));
    result.addAll(getIncomingTypeModelFacetLinks_ConnectionEnd_4036(modelElement, crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getPackage_3125IncomingLinks(View view) {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getEntity_3126IncomingLinks(View view) {
    Entity modelElement = (Entity) view.getElement();
    Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
        .find(view.eResource().getResourceSet().getResources());
    LinkedList<PLMLinkDescriptor> result = new LinkedList<PLMLinkDescriptor>();
    result
        .addAll(getIncomingTypeModelFacetLinks_Classification_4026(modelElement, crossReferences));
    result.addAll(getIncomingTypeModelFacetLinks_Supertype_4034(modelElement, crossReferences));
    result.addAll(getIncomingTypeModelFacetLinks_Subtype_4035(modelElement, crossReferences));
    result.addAll(getIncomingTypeModelFacetLinks_ConnectionEnd_4036(modelElement, crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getConnection_3127IncomingLinks(View view) {
    Connection modelElement = (Connection) view.getElement();
    Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
        .find(view.eResource().getResourceSet().getResources());
    LinkedList<PLMLinkDescriptor> result = new LinkedList<PLMLinkDescriptor>();
    result
        .addAll(getIncomingTypeModelFacetLinks_Classification_4026(modelElement, crossReferences));
    result.addAll(getIncomingTypeModelFacetLinks_Supertype_4034(modelElement, crossReferences));
    result.addAll(getIncomingTypeModelFacetLinks_Subtype_4035(modelElement, crossReferences));
    result.addAll(getIncomingTypeModelFacetLinks_ConnectionEnd_4036(modelElement, crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getInheritance_3128IncomingLinks(View view) {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getPackage_3129IncomingLinks(View view) {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getClassification_4026IncomingLinks(View view) {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getSupertype_4034IncomingLinks(View view) {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getSubtype_4035IncomingLinks(View view) {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getConnectionEnd_4036IncomingLinks(View view) {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getDeepModel_2005OutgoingLinks(View view) {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getEnumeration_3123OutgoingLinks(View view) {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getLevel_3097OutgoingLinks(View view) {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getConnection_3099OutgoingLinks(View view) {
    Connection modelElement = (Connection) view.getElement();
    LinkedList<PLMLinkDescriptor> result = new LinkedList<PLMLinkDescriptor>();
    result.addAll(getOutgoingTypeModelFacetLinks_Classification_4026(modelElement));
    result.addAll(getOutgoingTypeModelFacetLinks_ConnectionEnd_4036(modelElement));
    return result;
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getAttribute_3100OutgoingLinks(View view) {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getMethod_3102OutgoingLinks(View view) {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getEntity_3105OutgoingLinks(View view) {
    Entity modelElement = (Entity) view.getElement();
    LinkedList<PLMLinkDescriptor> result = new LinkedList<PLMLinkDescriptor>();
    result.addAll(getOutgoingTypeModelFacetLinks_Classification_4026(modelElement));
    return result;
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getAttribute_3106OutgoingLinks(View view) {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getMethod_3108OutgoingLinks(View view) {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getConnection_3111OutgoingLinks(View view) {
    Connection modelElement = (Connection) view.getElement();
    LinkedList<PLMLinkDescriptor> result = new LinkedList<PLMLinkDescriptor>();
    result.addAll(getOutgoingTypeModelFacetLinks_Classification_4026(modelElement));
    result.addAll(getOutgoingTypeModelFacetLinks_ConnectionEnd_4036(modelElement));
    return result;
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getInheritance_3124OutgoingLinks(View view) {
    Inheritance modelElement = (Inheritance) view.getElement();
    LinkedList<PLMLinkDescriptor> result = new LinkedList<PLMLinkDescriptor>();
    result.addAll(getOutgoingTypeModelFacetLinks_Supertype_4034(modelElement));
    result.addAll(getOutgoingTypeModelFacetLinks_Subtype_4035(modelElement));
    return result;
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getInheritance_3122OutgoingLinks(View view) {
    Inheritance modelElement = (Inheritance) view.getElement();
    LinkedList<PLMLinkDescriptor> result = new LinkedList<PLMLinkDescriptor>();
    result.addAll(getOutgoingTypeModelFacetLinks_Supertype_4034(modelElement));
    result.addAll(getOutgoingTypeModelFacetLinks_Subtype_4035(modelElement));
    return result;
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getEntity_3120OutgoingLinks(View view) {
    Entity modelElement = (Entity) view.getElement();
    LinkedList<PLMLinkDescriptor> result = new LinkedList<PLMLinkDescriptor>();
    result.addAll(getOutgoingTypeModelFacetLinks_Classification_4026(modelElement));
    return result;
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getPackage_3125OutgoingLinks(View view) {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getEntity_3126OutgoingLinks(View view) {
    Entity modelElement = (Entity) view.getElement();
    LinkedList<PLMLinkDescriptor> result = new LinkedList<PLMLinkDescriptor>();
    result.addAll(getOutgoingTypeModelFacetLinks_Classification_4026(modelElement));
    return result;
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getConnection_3127OutgoingLinks(View view) {
    Connection modelElement = (Connection) view.getElement();
    LinkedList<PLMLinkDescriptor> result = new LinkedList<PLMLinkDescriptor>();
    result.addAll(getOutgoingTypeModelFacetLinks_Classification_4026(modelElement));
    result.addAll(getOutgoingTypeModelFacetLinks_ConnectionEnd_4036(modelElement));
    return result;
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getInheritance_3128OutgoingLinks(View view) {
    Inheritance modelElement = (Inheritance) view.getElement();
    LinkedList<PLMLinkDescriptor> result = new LinkedList<PLMLinkDescriptor>();
    result.addAll(getOutgoingTypeModelFacetLinks_Supertype_4034(modelElement));
    result.addAll(getOutgoingTypeModelFacetLinks_Subtype_4035(modelElement));
    return result;
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getPackage_3129OutgoingLinks(View view) {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getClassification_4026OutgoingLinks(View view) {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getSupertype_4034OutgoingLinks(View view) {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getSubtype_4035OutgoingLinks(View view) {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<PLMLinkDescriptor> getConnectionEnd_4036OutgoingLinks(View view) {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  private static Collection<PLMLinkDescriptor> getContainedTypeModelFacetLinks_Classification_4026(
      Level container) {
    LinkedList<PLMLinkDescriptor> result = new LinkedList<PLMLinkDescriptor>();
    for (Iterator<?> links = container.getContent().iterator(); links.hasNext();) {
      EObject linkObject = (EObject) links.next();
      if (false == linkObject instanceof Classification) {
        continue;
      }
      Classification link = (Classification) linkObject;
      if (ClassificationEditPart.VISUAL_ID != PLMVisualIDRegistry.getLinkWithClassVisualID(link)) {
        continue;
      }
      Clabject dst = link.getType();
      Clabject src = link.getInstance();
      result.add(new PLMLinkDescriptor(src, dst, link, PLMElementTypes.Classification_4026,
          ClassificationEditPart.VISUAL_ID));
    }
    return result;
  }

  /**
   * @generated
   */
  private static Collection<PLMLinkDescriptor> getContainedTypeModelFacetLinks_Supertype_4034(
      Inheritance container) {
    LinkedList<PLMLinkDescriptor> result = new LinkedList<PLMLinkDescriptor>();
    for (Iterator<?> links = container.getSupertype().iterator(); links.hasNext();) {
      EObject linkObject = (EObject) links.next();
      if (false == linkObject instanceof Supertype) {
        continue;
      }
      Supertype link = (Supertype) linkObject;
      if (SupertypeEditPart.VISUAL_ID != PLMVisualIDRegistry.getLinkWithClassVisualID(link)) {
        continue;
      }
      Clabject dst = link.getSupertype();
      Inheritance src = link.getInheritance();
      result.add(new PLMLinkDescriptor(src, dst, link, PLMElementTypes.Supertype_4034,
          SupertypeEditPart.VISUAL_ID));
    }
    return result;
  }

  /**
   * @generated
   */
  private static Collection<PLMLinkDescriptor> getContainedTypeModelFacetLinks_Subtype_4035(
      Inheritance container) {
    LinkedList<PLMLinkDescriptor> result = new LinkedList<PLMLinkDescriptor>();
    for (Iterator<?> links = container.getSubtype().iterator(); links.hasNext();) {
      EObject linkObject = (EObject) links.next();
      if (false == linkObject instanceof Subtype) {
        continue;
      }
      Subtype link = (Subtype) linkObject;
      if (SubtypeEditPart.VISUAL_ID != PLMVisualIDRegistry.getLinkWithClassVisualID(link)) {
        continue;
      }
      Clabject dst = link.getSubtype();
      Inheritance src = link.getInheritance();
      result.add(new PLMLinkDescriptor(src, dst, link, PLMElementTypes.Subtype_4035,
          SubtypeEditPart.VISUAL_ID));
    }
    return result;
  }

  /**
   * @generated
   */
  private static Collection<PLMLinkDescriptor> getContainedTypeModelFacetLinks_ConnectionEnd_4036(
      Connection container) {
    LinkedList<PLMLinkDescriptor> result = new LinkedList<PLMLinkDescriptor>();
    for (Iterator<?> links = container.getConnectionEnd().iterator(); links.hasNext();) {
      EObject linkObject = (EObject) links.next();
      if (false == linkObject instanceof ConnectionEnd) {
        continue;
      }
      ConnectionEnd link = (ConnectionEnd) linkObject;
      if (ConnectionEndEditPart.VISUAL_ID != PLMVisualIDRegistry.getLinkWithClassVisualID(link)) {
        continue;
      }
      Clabject dst = link.getDestination();
      Connection src = link.getConnection();
      result.add(new PLMLinkDescriptor(src, dst, link, PLMElementTypes.ConnectionEnd_4036,
          ConnectionEndEditPart.VISUAL_ID));
    }
    return result;
  }

  /**
   * @generated
   */
  private static Collection<PLMLinkDescriptor> getIncomingTypeModelFacetLinks_Classification_4026(
      Clabject target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
    LinkedList<PLMLinkDescriptor> result = new LinkedList<PLMLinkDescriptor>();
    Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
    for (EStructuralFeature.Setting setting : settings) {
      if (setting.getEStructuralFeature() != PLMPackage.eINSTANCE.getClassification_Type()
          || false == setting.getEObject() instanceof Classification) {
        continue;
      }
      Classification link = (Classification) setting.getEObject();
      if (ClassificationEditPart.VISUAL_ID != PLMVisualIDRegistry.getLinkWithClassVisualID(link)) {
        continue;
      }
      Clabject src = link.getInstance();
      result.add(new PLMLinkDescriptor(src, target, link, PLMElementTypes.Classification_4026,
          ClassificationEditPart.VISUAL_ID));
    }
    return result;
  }

  /**
   * @generated
   */
  private static Collection<PLMLinkDescriptor> getIncomingTypeModelFacetLinks_Supertype_4034(
      Clabject target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
    LinkedList<PLMLinkDescriptor> result = new LinkedList<PLMLinkDescriptor>();
    Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
    for (EStructuralFeature.Setting setting : settings) {
      if (setting.getEStructuralFeature() != PLMPackage.eINSTANCE.getSupertype_Supertype()
          || false == setting.getEObject() instanceof Supertype) {
        continue;
      }
      Supertype link = (Supertype) setting.getEObject();
      if (SupertypeEditPart.VISUAL_ID != PLMVisualIDRegistry.getLinkWithClassVisualID(link)) {
        continue;
      }
      Inheritance src = link.getInheritance();
      result.add(new PLMLinkDescriptor(src, target, link, PLMElementTypes.Supertype_4034,
          SupertypeEditPart.VISUAL_ID));
    }
    return result;
  }

  /**
   * @generated
   */
  private static Collection<PLMLinkDescriptor> getIncomingTypeModelFacetLinks_Subtype_4035(
      Clabject target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
    LinkedList<PLMLinkDescriptor> result = new LinkedList<PLMLinkDescriptor>();
    Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
    for (EStructuralFeature.Setting setting : settings) {
      if (setting.getEStructuralFeature() != PLMPackage.eINSTANCE.getSubtype_Subtype()
          || false == setting.getEObject() instanceof Subtype) {
        continue;
      }
      Subtype link = (Subtype) setting.getEObject();
      if (SubtypeEditPart.VISUAL_ID != PLMVisualIDRegistry.getLinkWithClassVisualID(link)) {
        continue;
      }
      Inheritance src = link.getInheritance();
      result.add(new PLMLinkDescriptor(src, target, link, PLMElementTypes.Subtype_4035,
          SubtypeEditPart.VISUAL_ID));
    }
    return result;
  }

  /**
   * @generated
   */
  private static Collection<PLMLinkDescriptor> getIncomingTypeModelFacetLinks_ConnectionEnd_4036(
      Clabject target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
    LinkedList<PLMLinkDescriptor> result = new LinkedList<PLMLinkDescriptor>();
    Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
    for (EStructuralFeature.Setting setting : settings) {
      if (setting.getEStructuralFeature() != PLMPackage.eINSTANCE.getConnectionEnd_Destination()
          || false == setting.getEObject() instanceof ConnectionEnd) {
        continue;
      }
      ConnectionEnd link = (ConnectionEnd) setting.getEObject();
      if (ConnectionEndEditPart.VISUAL_ID != PLMVisualIDRegistry.getLinkWithClassVisualID(link)) {
        continue;
      }
      Connection src = link.getConnection();
      result.add(new PLMLinkDescriptor(src, target, link, PLMElementTypes.ConnectionEnd_4036,
          ConnectionEndEditPart.VISUAL_ID));
    }
    return result;
  }

  /**
   * @generated
   */
  private static Collection<PLMLinkDescriptor> getOutgoingTypeModelFacetLinks_Classification_4026(
      Clabject source) {
    Level container = null;
    // Find container element for the link.
    // Climb up by containment hierarchy starting from the source
    // and return the first element that is instance of the container class.
    for (EObject element = source; element != null
        && container == null; element = element.eContainer()) {
      if (element instanceof Level) {
        container = (Level) element;
      }
    }
    if (container == null) {
      return Collections.emptyList();
    }
    LinkedList<PLMLinkDescriptor> result = new LinkedList<PLMLinkDescriptor>();
    for (Iterator<?> links = container.getContent().iterator(); links.hasNext();) {
      EObject linkObject = (EObject) links.next();
      if (false == linkObject instanceof Classification) {
        continue;
      }
      Classification link = (Classification) linkObject;
      if (ClassificationEditPart.VISUAL_ID != PLMVisualIDRegistry.getLinkWithClassVisualID(link)) {
        continue;
      }
      Clabject dst = link.getType();
      Clabject src = link.getInstance();
      if (src != source) {
        continue;
      }
      result.add(new PLMLinkDescriptor(src, dst, link, PLMElementTypes.Classification_4026,
          ClassificationEditPart.VISUAL_ID));
    }
    return result;
  }

  /**
   * @generated
   */
  private static Collection<PLMLinkDescriptor> getOutgoingTypeModelFacetLinks_Supertype_4034(
      Inheritance source) {
    Inheritance container = null;
    // Find container element for the link.
    // Climb up by containment hierarchy starting from the source
    // and return the first element that is instance of the container class.
    for (EObject element = source; element != null
        && container == null; element = element.eContainer()) {
      if (element instanceof Inheritance) {
        container = (Inheritance) element;
      }
    }
    if (container == null) {
      return Collections.emptyList();
    }
    LinkedList<PLMLinkDescriptor> result = new LinkedList<PLMLinkDescriptor>();
    for (Iterator<?> links = container.getSupertype().iterator(); links.hasNext();) {
      EObject linkObject = (EObject) links.next();
      if (false == linkObject instanceof Supertype) {
        continue;
      }
      Supertype link = (Supertype) linkObject;
      if (SupertypeEditPart.VISUAL_ID != PLMVisualIDRegistry.getLinkWithClassVisualID(link)) {
        continue;
      }
      Clabject dst = link.getSupertype();
      Inheritance src = link.getInheritance();
      if (src != source) {
        continue;
      }
      result.add(new PLMLinkDescriptor(src, dst, link, PLMElementTypes.Supertype_4034,
          SupertypeEditPart.VISUAL_ID));
    }
    return result;
  }

  /**
   * @generated
   */
  private static Collection<PLMLinkDescriptor> getOutgoingTypeModelFacetLinks_Subtype_4035(
      Inheritance source) {
    Inheritance container = null;
    // Find container element for the link.
    // Climb up by containment hierarchy starting from the source
    // and return the first element that is instance of the container class.
    for (EObject element = source; element != null
        && container == null; element = element.eContainer()) {
      if (element instanceof Inheritance) {
        container = (Inheritance) element;
      }
    }
    if (container == null) {
      return Collections.emptyList();
    }
    LinkedList<PLMLinkDescriptor> result = new LinkedList<PLMLinkDescriptor>();
    for (Iterator<?> links = container.getSubtype().iterator(); links.hasNext();) {
      EObject linkObject = (EObject) links.next();
      if (false == linkObject instanceof Subtype) {
        continue;
      }
      Subtype link = (Subtype) linkObject;
      if (SubtypeEditPart.VISUAL_ID != PLMVisualIDRegistry.getLinkWithClassVisualID(link)) {
        continue;
      }
      Clabject dst = link.getSubtype();
      Inheritance src = link.getInheritance();
      if (src != source) {
        continue;
      }
      result.add(new PLMLinkDescriptor(src, dst, link, PLMElementTypes.Subtype_4035,
          SubtypeEditPart.VISUAL_ID));
    }
    return result;
  }

  /**
   * @generated
   */
  private static Collection<PLMLinkDescriptor> getOutgoingTypeModelFacetLinks_ConnectionEnd_4036(
      Connection source) {
    Connection container = null;
    // Find container element for the link.
    // Climb up by containment hierarchy starting from the source
    // and return the first element that is instance of the container class.
    for (EObject element = source; element != null
        && container == null; element = element.eContainer()) {
      if (element instanceof Connection) {
        container = (Connection) element;
      }
    }
    if (container == null) {
      return Collections.emptyList();
    }
    LinkedList<PLMLinkDescriptor> result = new LinkedList<PLMLinkDescriptor>();
    for (Iterator<?> links = container.getConnectionEnd().iterator(); links.hasNext();) {
      EObject linkObject = (EObject) links.next();
      if (false == linkObject instanceof ConnectionEnd) {
        continue;
      }
      ConnectionEnd link = (ConnectionEnd) linkObject;
      if (ConnectionEndEditPart.VISUAL_ID != PLMVisualIDRegistry.getLinkWithClassVisualID(link)) {
        continue;
      }
      Clabject dst = link.getDestination();
      Connection src = link.getConnection();
      if (src != source) {
        continue;
      }
      result.add(new PLMLinkDescriptor(src, dst, link, PLMElementTypes.ConnectionEnd_4036,
          ConnectionEndEditPart.VISUAL_ID));
    }
    return result;
  }

  /**
   * @generated
   */
  public static final DiagramUpdater TYPED_INSTANCE = new DiagramUpdater() {
    /**
     * @generated
     */
    @Override

    public List<PLMNodeDescriptor> getSemanticChildren(View view) {
      return PLMDiagramUpdater.getSemanticChildren(view);
    }

    /**
     * @generated
     */
    @Override

    public List<PLMLinkDescriptor> getContainedLinks(View view) {
      return PLMDiagramUpdater.getContainedLinks(view);
    }

    /**
     * @generated
     */
    @Override

    public List<PLMLinkDescriptor> getIncomingLinks(View view) {
      return PLMDiagramUpdater.getIncomingLinks(view);
    }

    /**
     * @generated
     */
    @Override

    public List<PLMLinkDescriptor> getOutgoingLinks(View view) {
      return PLMDiagramUpdater.getOutgoingLinks(view);
    }
  };

}

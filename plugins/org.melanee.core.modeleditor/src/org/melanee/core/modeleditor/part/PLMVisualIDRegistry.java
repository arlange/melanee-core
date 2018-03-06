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

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.structure.DiagramStructure;
import org.melanee.core.modeleditor.edit.parts.*;
import org.melanee.core.models.plm.PLM.Domain;
import org.melanee.core.models.plm.PLM.PLMPackage;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented by
 * a domain model object.
 * 
 * @generated
 */
public class PLMVisualIDRegistry {

  /**
   * @generated
   */
  private static final String DEBUG_KEY = "org.melanee.core.modeleditor/debug/visualID"; //$NON-NLS-1$

  /**
   * @generated
   */
  public static int getVisualID(View view) {
    if (view instanceof Diagram) {
      if (DomainEditPart.MODEL_ID.equals(view.getType())) {
        return DomainEditPart.VISUAL_ID;
      } else {
        return -1;
      }
    }
    return org.melanee.core.modeleditor.part.PLMVisualIDRegistry.getVisualID(view.getType());
  }

  /**
   * @generated
   */
  public static String getModelID(View view) {
    View diagram = view.getDiagram();
    while (view != diagram) {
      EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
      if (annotation != null) {
        return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
      }
      view = (View) view.eContainer();
    }
    return diagram != null ? diagram.getType() : null;
  }

  /**
   * @generated
   */
  public static int getVisualID(String type) {
    try {
      return Integer.parseInt(type);
    } catch (NumberFormatException e) {
      if (Boolean.TRUE.toString().equalsIgnoreCase(Platform.getDebugOption(DEBUG_KEY))) {
        PLMDiagramEditorPlugin.getInstance()
            .logError("Unable to parse view type as a visualID number: " + type);
      }
    }
    return -1;
  }

  /**
   * @generated
   */
  public static String getType(int visualID) {
    return Integer.toString(visualID);
  }

  /**
   * @generated
   */
  public static int getDiagramVisualID(EObject domainElement) {
    if (domainElement == null) {
      return -1;
    }
    if (PLMPackage.eINSTANCE.getDomain().isSuperTypeOf(domainElement.eClass())
        && isDiagram((Domain) domainElement)) {
      return DomainEditPart.VISUAL_ID;
    }
    return -1;
  }

  /**
   * @generated
   */
  public static int getNodeVisualID(View containerView, EObject domainElement) {
    if (domainElement == null) {
      return -1;
    }
    String containerModelID = org.melanee.core.modeleditor.part.PLMVisualIDRegistry
        .getModelID(containerView);
    if (!DomainEditPart.MODEL_ID.equals(containerModelID)) {
      return -1;
    }
    int containerVisualID;
    if (DomainEditPart.MODEL_ID.equals(containerModelID)) {
      containerVisualID = org.melanee.core.modeleditor.part.PLMVisualIDRegistry
          .getVisualID(containerView);
    } else {
      if (containerView instanceof Diagram) {
        containerVisualID = DomainEditPart.VISUAL_ID;
      } else {
        return -1;
      }
    }
    switch (containerVisualID) {
    case DomainEditPart.VISUAL_ID:
      if (PLMPackage.eINSTANCE.getDeepModel().isSuperTypeOf(domainElement.eClass())) {
        return DeepModelEditPart.VISUAL_ID;
      }
      break;
    case DeepModelDeepModelEnumerationCompartmentEditPart.VISUAL_ID:
      if (PLMPackage.eINSTANCE.getEnumeration().isSuperTypeOf(domainElement.eClass())) {
        return EnumerationEditPart.VISUAL_ID;
      }
      break;
    case DeepModelDeepModelLevelCompartmentEditPart.VISUAL_ID:
      if (PLMPackage.eINSTANCE.getLevel().isSuperTypeOf(domainElement.eClass())) {
        return LevelEditPart.VISUAL_ID;
      }
      break;
    case LevelDomainElementsCompartmentEditPart.VISUAL_ID:
      if (PLMPackage.eINSTANCE.getConnection().isSuperTypeOf(domainElement.eClass())) {
        return ConnectionEditPart.VISUAL_ID;
      }
      if (PLMPackage.eINSTANCE.getInheritance().isSuperTypeOf(domainElement.eClass())) {
        return Inheritance2EditPart.VISUAL_ID;
      }
      if (PLMPackage.eINSTANCE.getEntity().isSuperTypeOf(domainElement.eClass())) {
        return Entity2EditPart.VISUAL_ID;
      }
      if (PLMPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())) {
        return PackageEditPart.VISUAL_ID;
      }
      break;
    case ConnectionConnectionAttributesCompartmentEditPart.VISUAL_ID:
      if (PLMPackage.eINSTANCE.getAttribute().isSuperTypeOf(domainElement.eClass())) {
        return AttributeEditPart.VISUAL_ID;
      }
      break;
    case ConnectionConnectionMethodsCompartmentEditPart.VISUAL_ID:
      if (PLMPackage.eINSTANCE.getMethod().isSuperTypeOf(domainElement.eClass())) {
        return MethodEditPart.VISUAL_ID;
      }
      break;
    case ConnectionConnectionContentsCompartmentEditPart.VISUAL_ID:
      if (PLMPackage.eINSTANCE.getEntity().isSuperTypeOf(domainElement.eClass())) {
        return EntityEditPart.VISUAL_ID;
      }
      if (PLMPackage.eINSTANCE.getConnection().isSuperTypeOf(domainElement.eClass())) {
        return Connection2EditPart.VISUAL_ID;
      }
      if (PLMPackage.eINSTANCE.getInheritance().isSuperTypeOf(domainElement.eClass())) {
        return InheritanceEditPart.VISUAL_ID;
      }
      break;
    case EntityEntityAttributesCompartmentEditPart.VISUAL_ID:
      if (PLMPackage.eINSTANCE.getAttribute().isSuperTypeOf(domainElement.eClass())) {
        return Attribute2EditPart.VISUAL_ID;
      }
      break;
    case EntityEntityMethodsCompartmentEditPart.VISUAL_ID:
      if (PLMPackage.eINSTANCE.getMethod().isSuperTypeOf(domainElement.eClass())) {
        return Method2EditPart.VISUAL_ID;
      }
      break;
    case EntityEntityContentsCompartmentEditPart.VISUAL_ID:
      if (PLMPackage.eINSTANCE.getEntity().isSuperTypeOf(domainElement.eClass())) {
        return EntityEditPart.VISUAL_ID;
      }
      if (PLMPackage.eINSTANCE.getConnection().isSuperTypeOf(domainElement.eClass())) {
        return Connection2EditPart.VISUAL_ID;
      }
      if (PLMPackage.eINSTANCE.getInheritance().isSuperTypeOf(domainElement.eClass())) {
        return InheritanceEditPart.VISUAL_ID;
      }
      break;
    case ConnectionConnectionAttributesCompartment2EditPart.VISUAL_ID:
      if (PLMPackage.eINSTANCE.getAttribute().isSuperTypeOf(domainElement.eClass())) {
        return AttributeEditPart.VISUAL_ID;
      }
      break;
    case ConnectionConnectionMethodsCompartment2EditPart.VISUAL_ID:
      if (PLMPackage.eINSTANCE.getMethod().isSuperTypeOf(domainElement.eClass())) {
        return MethodEditPart.VISUAL_ID;
      }
      break;
    case ConnectionConnectionContentsCompartment2EditPart.VISUAL_ID:
      if (PLMPackage.eINSTANCE.getEntity().isSuperTypeOf(domainElement.eClass())) {
        return EntityEditPart.VISUAL_ID;
      }
      if (PLMPackage.eINSTANCE.getConnection().isSuperTypeOf(domainElement.eClass())) {
        return Connection2EditPart.VISUAL_ID;
      }
      if (PLMPackage.eINSTANCE.getInheritance().isSuperTypeOf(domainElement.eClass())) {
        return InheritanceEditPart.VISUAL_ID;
      }
      break;
    case EntityEntityAttributesCompartment2EditPart.VISUAL_ID:
      if (PLMPackage.eINSTANCE.getAttribute().isSuperTypeOf(domainElement.eClass())) {
        return Attribute2EditPart.VISUAL_ID;
      }
      break;
    case EntityEntityMethodsCompartment2EditPart.VISUAL_ID:
      if (PLMPackage.eINSTANCE.getMethod().isSuperTypeOf(domainElement.eClass())) {
        return Method2EditPart.VISUAL_ID;
      }
      break;
    case EntityEntityContentsCompartment2EditPart.VISUAL_ID:
      if (PLMPackage.eINSTANCE.getEntity().isSuperTypeOf(domainElement.eClass())) {
        return EntityEditPart.VISUAL_ID;
      }
      if (PLMPackage.eINSTANCE.getConnection().isSuperTypeOf(domainElement.eClass())) {
        return Connection2EditPart.VISUAL_ID;
      }
      if (PLMPackage.eINSTANCE.getInheritance().isSuperTypeOf(domainElement.eClass())) {
        return InheritanceEditPart.VISUAL_ID;
      }
      break;
    case PackagePackageContentCompartmentEditPart.VISUAL_ID:
      if (PLMPackage.eINSTANCE.getEntity().isSuperTypeOf(domainElement.eClass())) {
        return Entity3EditPart.VISUAL_ID;
      }
      if (PLMPackage.eINSTANCE.getConnection().isSuperTypeOf(domainElement.eClass())) {
        return Connection3EditPart.VISUAL_ID;
      }
      if (PLMPackage.eINSTANCE.getInheritance().isSuperTypeOf(domainElement.eClass())) {
        return Inheritance3EditPart.VISUAL_ID;
      }
      if (PLMPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())) {
        return Package2EditPart.VISUAL_ID;
      }
      break;
    case EntityEntityAttributesCompartment3EditPart.VISUAL_ID:
      if (PLMPackage.eINSTANCE.getAttribute().isSuperTypeOf(domainElement.eClass())) {
        return Attribute2EditPart.VISUAL_ID;
      }
      break;
    case EntityEntityMethodsCompartment3EditPart.VISUAL_ID:
      if (PLMPackage.eINSTANCE.getMethod().isSuperTypeOf(domainElement.eClass())) {
        return Method2EditPart.VISUAL_ID;
      }
      break;
    case EntityEntityContentsCompartment3EditPart.VISUAL_ID:
      if (PLMPackage.eINSTANCE.getEntity().isSuperTypeOf(domainElement.eClass())) {
        return EntityEditPart.VISUAL_ID;
      }
      if (PLMPackage.eINSTANCE.getConnection().isSuperTypeOf(domainElement.eClass())) {
        return Connection2EditPart.VISUAL_ID;
      }
      if (PLMPackage.eINSTANCE.getInheritance().isSuperTypeOf(domainElement.eClass())) {
        return InheritanceEditPart.VISUAL_ID;
      }
      break;
    case ConnectionConnectionAttributesCompartment3EditPart.VISUAL_ID:
      if (PLMPackage.eINSTANCE.getAttribute().isSuperTypeOf(domainElement.eClass())) {
        return AttributeEditPart.VISUAL_ID;
      }
      break;
    case ConnectionConnectionMethodsCompartment3EditPart.VISUAL_ID:
      if (PLMPackage.eINSTANCE.getMethod().isSuperTypeOf(domainElement.eClass())) {
        return MethodEditPart.VISUAL_ID;
      }
      break;
    case ConnectionConnectionContentsCompartment3EditPart.VISUAL_ID:
      if (PLMPackage.eINSTANCE.getEntity().isSuperTypeOf(domainElement.eClass())) {
        return EntityEditPart.VISUAL_ID;
      }
      if (PLMPackage.eINSTANCE.getConnection().isSuperTypeOf(domainElement.eClass())) {
        return Connection2EditPart.VISUAL_ID;
      }
      if (PLMPackage.eINSTANCE.getInheritance().isSuperTypeOf(domainElement.eClass())) {
        return InheritanceEditPart.VISUAL_ID;
      }
      break;
    case PackagePackageContentCompartment2EditPart.VISUAL_ID:
      if (PLMPackage.eINSTANCE.getEntity().isSuperTypeOf(domainElement.eClass())) {
        return Entity3EditPart.VISUAL_ID;
      }
      if (PLMPackage.eINSTANCE.getConnection().isSuperTypeOf(domainElement.eClass())) {
        return Connection3EditPart.VISUAL_ID;
      }
      if (PLMPackage.eINSTANCE.getInheritance().isSuperTypeOf(domainElement.eClass())) {
        return Inheritance3EditPart.VISUAL_ID;
      }
      if (PLMPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())) {
        return Package2EditPart.VISUAL_ID;
      }
      break;
    }
    return -1;
  }

  /**
   * @generated
   */
  public static boolean canCreateNode(View containerView, int nodeVisualID) {
    String containerModelID = org.melanee.core.modeleditor.part.PLMVisualIDRegistry
        .getModelID(containerView);
    if (!DomainEditPart.MODEL_ID.equals(containerModelID)) {
      return false;
    }
    int containerVisualID;
    if (DomainEditPart.MODEL_ID.equals(containerModelID)) {
      containerVisualID = org.melanee.core.modeleditor.part.PLMVisualIDRegistry
          .getVisualID(containerView);
    } else {
      if (containerView instanceof Diagram) {
        containerVisualID = DomainEditPart.VISUAL_ID;
      } else {
        return false;
      }
    }
    switch (containerVisualID) {
    case DomainEditPart.VISUAL_ID:
      if (DeepModelEditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      break;
    case DeepModelEditPart.VISUAL_ID:
      if (DeepModelNameEditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (WrappingLabelEditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (WrappingLabel2EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (DeepModelDeepModelEnumerationCompartmentEditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (DeepModelDeepModelLevelCompartmentEditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      break;
    case EnumerationEditPart.VISUAL_ID:
      if (EnumerationNameEditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (EnumerationLiteralEditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      break;
    case LevelEditPart.VISUAL_ID:
      if (LevelNameEditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (WrappingLabel3EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (LevelDomainElementsCompartmentEditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      break;
    case ConnectionEditPart.VISUAL_ID:
      if (WrappingLabel4EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (ConnectionNameEditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (WrappingLabel5EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (WrappingLabel6EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (WrappingLabel7EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (WrappingLabel8EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (ConnectionConnectionAttributesCompartmentEditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (ConnectionConnectionMethodsCompartmentEditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (ConnectionConnectionContentsCompartmentEditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      break;
    case AttributeEditPart.VISUAL_ID:
      if (AttributeNameEditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (WrappingLabel9EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (WrappingLabel10EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (WrappingLabel11EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (WrappingLabel12EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      break;
    case MethodEditPart.VISUAL_ID:
      if (MethodNameEditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (WrappingLabel13EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (WrappingLabel14EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (WrappingLabel15EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      break;
    case EntityEditPart.VISUAL_ID:
      if (WrappingLabel16EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (WrappingLabel17EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (WrappingLabel18EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (WrappingLabel19EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (WrappingLabel20EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (ConnectionNameExternalLabelEditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (EntityEntityAttributesCompartmentEditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (EntityEntityMethodsCompartmentEditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (EntityEntityContentsCompartmentEditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      break;
    case Attribute2EditPart.VISUAL_ID:
      if (AttributeName2EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (WrappingLabel21EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (WrappingLabel22EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (WrappingLabel23EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (WrappingLabel24EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      break;
    case Method2EditPart.VISUAL_ID:
      if (MethodName2EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (WrappingLabel25EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (WrappingLabel26EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (WrappingLabel27EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      break;
    case Connection2EditPart.VISUAL_ID:
      if (WrappingLabel28EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (ConnectionName2EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (WrappingLabel29EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (WrappingLabel30EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (WrappingLabel31EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (WrappingLabel32EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (ConnectionConnectionAttributesCompartment2EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (ConnectionConnectionMethodsCompartment2EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (ConnectionConnectionContentsCompartment2EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      break;
    case InheritanceEditPart.VISUAL_ID:
      if (InheritanceNameEditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (InheritanceName2EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (WrappingLabel33EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      break;
    case Inheritance2EditPart.VISUAL_ID:
      if (InheritanceName3EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (InheritanceName4EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (WrappingLabel34EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      break;
    case Entity2EditPart.VISUAL_ID:
      if (WrappingLabel35EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (WrappingLabel36EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (WrappingLabel37EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (WrappingLabel38EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (WrappingLabel39EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (ConnectionNameExternalLabel2EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (EntityEntityAttributesCompartment2EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (EntityEntityMethodsCompartment2EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (EntityEntityContentsCompartment2EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      break;
    case PackageEditPart.VISUAL_ID:
      if (PackageNameEditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (PackagePackageContentCompartmentEditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      break;
    case Entity3EditPart.VISUAL_ID:
      if (WrappingLabel40EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (WrappingLabel41EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (WrappingLabel42EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (WrappingLabel43EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (WrappingLabel44EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (ConnectionNameExternalLabel3EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (EntityEntityAttributesCompartment3EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (EntityEntityMethodsCompartment3EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (EntityEntityContentsCompartment3EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      break;
    case Connection3EditPart.VISUAL_ID:
      if (WrappingLabel45EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (ConnectionName3EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (WrappingLabel46EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (WrappingLabel47EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (WrappingLabel48EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (WrappingLabel49EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (ConnectionConnectionAttributesCompartment3EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (ConnectionConnectionMethodsCompartment3EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (ConnectionConnectionContentsCompartment3EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      break;
    case Inheritance3EditPart.VISUAL_ID:
      if (InheritanceName5EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (InheritanceName6EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (WrappingLabel50EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      break;
    case Package2EditPart.VISUAL_ID:
      if (PackageName2EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (PackagePackageContentCompartment2EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      break;
    case DeepModelDeepModelEnumerationCompartmentEditPart.VISUAL_ID:
      if (EnumerationEditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      break;
    case DeepModelDeepModelLevelCompartmentEditPart.VISUAL_ID:
      if (LevelEditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      break;
    case LevelDomainElementsCompartmentEditPart.VISUAL_ID:
      if (ConnectionEditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (Inheritance2EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (Entity2EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (PackageEditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      break;
    case ConnectionConnectionAttributesCompartmentEditPart.VISUAL_ID:
      if (AttributeEditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      break;
    case ConnectionConnectionMethodsCompartmentEditPart.VISUAL_ID:
      if (MethodEditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      break;
    case ConnectionConnectionContentsCompartmentEditPart.VISUAL_ID:
      if (EntityEditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (Connection2EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (InheritanceEditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      break;
    case EntityEntityAttributesCompartmentEditPart.VISUAL_ID:
      if (Attribute2EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      break;
    case EntityEntityMethodsCompartmentEditPart.VISUAL_ID:
      if (Method2EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      break;
    case EntityEntityContentsCompartmentEditPart.VISUAL_ID:
      if (EntityEditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (Connection2EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (InheritanceEditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      break;
    case ConnectionConnectionAttributesCompartment2EditPart.VISUAL_ID:
      if (AttributeEditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      break;
    case ConnectionConnectionMethodsCompartment2EditPart.VISUAL_ID:
      if (MethodEditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      break;
    case ConnectionConnectionContentsCompartment2EditPart.VISUAL_ID:
      if (EntityEditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (Connection2EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (InheritanceEditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      break;
    case EntityEntityAttributesCompartment2EditPart.VISUAL_ID:
      if (Attribute2EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      break;
    case EntityEntityMethodsCompartment2EditPart.VISUAL_ID:
      if (Method2EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      break;
    case EntityEntityContentsCompartment2EditPart.VISUAL_ID:
      if (EntityEditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (Connection2EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (InheritanceEditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      break;
    case PackagePackageContentCompartmentEditPart.VISUAL_ID:
      if (Entity3EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (Connection3EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (Inheritance3EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (Package2EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      break;
    case EntityEntityAttributesCompartment3EditPart.VISUAL_ID:
      if (Attribute2EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      break;
    case EntityEntityMethodsCompartment3EditPart.VISUAL_ID:
      if (Method2EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      break;
    case EntityEntityContentsCompartment3EditPart.VISUAL_ID:
      if (EntityEditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (Connection2EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (InheritanceEditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      break;
    case ConnectionConnectionAttributesCompartment3EditPart.VISUAL_ID:
      if (AttributeEditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      break;
    case ConnectionConnectionMethodsCompartment3EditPart.VISUAL_ID:
      if (MethodEditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      break;
    case ConnectionConnectionContentsCompartment3EditPart.VISUAL_ID:
      if (EntityEditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (Connection2EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (InheritanceEditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      break;
    case PackagePackageContentCompartment2EditPart.VISUAL_ID:
      if (Entity3EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (Connection3EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (Inheritance3EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (Package2EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      break;
    case ClassificationEditPart.VISUAL_ID:
      if (WrappingLabel51EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (WrappingLabel52EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      break;
    case ConnectionEndEditPart.VISUAL_ID:
      if (WrappingLabel53EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      if (WrappingLabel54EditPart.VISUAL_ID == nodeVisualID) {
        return true;
      }
      break;
    }
    return false;
  }

  /**
   * @generated
   */
  public static int getLinkWithClassVisualID(EObject domainElement) {
    if (domainElement == null) {
      return -1;
    }
    if (PLMPackage.eINSTANCE.getClassification().isSuperTypeOf(domainElement.eClass())) {
      return ClassificationEditPart.VISUAL_ID;
    }
    if (PLMPackage.eINSTANCE.getSupertype().isSuperTypeOf(domainElement.eClass())) {
      return SupertypeEditPart.VISUAL_ID;
    }
    if (PLMPackage.eINSTANCE.getSubtype().isSuperTypeOf(domainElement.eClass())) {
      return SubtypeEditPart.VISUAL_ID;
    }
    if (PLMPackage.eINSTANCE.getConnectionEnd().isSuperTypeOf(domainElement.eClass())) {
      return ConnectionEndEditPart.VISUAL_ID;
    }
    return -1;
  }

  /**
   * User can change implementation of this method to handle some specific
   * situations not covered by default logic.
   * 
   * @generated
   */
  private static boolean isDiagram(Domain element) {
    return true;
  }

  /**
   * @generated
   */
  public static boolean checkNodeVisualID(View containerView, EObject domainElement,
      int candidate) {
    if (candidate == -1) {
      // unrecognized id is always bad
      return false;
    }
    int basic = getNodeVisualID(containerView, domainElement);
    return basic == candidate;
  }

  /**
   * @generated
   */
  public static boolean isCompartmentVisualID(int visualID) {
    switch (visualID) {
    case DeepModelDeepModelEnumerationCompartmentEditPart.VISUAL_ID:
    case DeepModelDeepModelLevelCompartmentEditPart.VISUAL_ID:
    case LevelDomainElementsCompartmentEditPart.VISUAL_ID:
    case ConnectionConnectionAttributesCompartmentEditPart.VISUAL_ID:
    case ConnectionConnectionMethodsCompartmentEditPart.VISUAL_ID:
    case ConnectionConnectionContentsCompartmentEditPart.VISUAL_ID:
    case EntityEntityAttributesCompartmentEditPart.VISUAL_ID:
    case EntityEntityMethodsCompartmentEditPart.VISUAL_ID:
    case EntityEntityContentsCompartmentEditPart.VISUAL_ID:
    case ConnectionConnectionAttributesCompartment2EditPart.VISUAL_ID:
    case ConnectionConnectionMethodsCompartment2EditPart.VISUAL_ID:
    case ConnectionConnectionContentsCompartment2EditPart.VISUAL_ID:
    case EntityEntityAttributesCompartment2EditPart.VISUAL_ID:
    case EntityEntityMethodsCompartment2EditPart.VISUAL_ID:
    case EntityEntityContentsCompartment2EditPart.VISUAL_ID:
    case PackagePackageContentCompartmentEditPart.VISUAL_ID:
    case EntityEntityAttributesCompartment3EditPart.VISUAL_ID:
    case EntityEntityMethodsCompartment3EditPart.VISUAL_ID:
    case EntityEntityContentsCompartment3EditPart.VISUAL_ID:
    case ConnectionConnectionAttributesCompartment3EditPart.VISUAL_ID:
    case ConnectionConnectionMethodsCompartment3EditPart.VISUAL_ID:
    case ConnectionConnectionContentsCompartment3EditPart.VISUAL_ID:
    case PackagePackageContentCompartment2EditPart.VISUAL_ID:
      return true;
    default:
      break;
    }
    return false;
  }

  /**
   * @generated
   */
  public static boolean isSemanticLeafVisualID(int visualID) {
    switch (visualID) {
    case DomainEditPart.VISUAL_ID:
      return false;
    case AttributeEditPart.VISUAL_ID:
    case MethodEditPart.VISUAL_ID:
    case Attribute2EditPart.VISUAL_ID:
    case Method2EditPart.VISUAL_ID:
    case Inheritance2EditPart.VISUAL_ID:
    case EnumerationEditPart.VISUAL_ID:
    case InheritanceEditPart.VISUAL_ID:
    case Inheritance3EditPart.VISUAL_ID:
      return true;
    default:
      break;
    }
    return false;
  }

  /**
   * @generated
   */
  public static final DiagramStructure TYPED_INSTANCE = new DiagramStructure() {
    /**
     * @generated
     */
    @Override

    public int getVisualID(View view) {
      return org.melanee.core.modeleditor.part.PLMVisualIDRegistry.getVisualID(view);
    }

    /**
     * @generated
     */
    @Override

    public String getModelID(View view) {
      return org.melanee.core.modeleditor.part.PLMVisualIDRegistry.getModelID(view);
    }

    /**
     * @generated
     */
    @Override

    public int getNodeVisualID(View containerView, EObject domainElement) {
      return org.melanee.core.modeleditor.part.PLMVisualIDRegistry.getNodeVisualID(containerView,
          domainElement);
    }

    /**
     * @generated
     */
    @Override

    public boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
      return org.melanee.core.modeleditor.part.PLMVisualIDRegistry.checkNodeVisualID(containerView,
          domainElement, candidate);
    }

    /**
     * @generated
     */
    @Override

    public boolean isCompartmentVisualID(int visualID) {
      return org.melanee.core.modeleditor.part.PLMVisualIDRegistry.isCompartmentVisualID(visualID);
    }

    /**
     * @generated
     */
    @Override

    public boolean isSemanticLeafVisualID(int visualID) {
      return org.melanee.core.modeleditor.part.PLMVisualIDRegistry.isSemanticLeafVisualID(visualID);
    }
  };

}

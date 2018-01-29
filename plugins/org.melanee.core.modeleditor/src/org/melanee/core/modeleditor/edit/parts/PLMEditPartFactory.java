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
package org.melanee.core.modeleditor.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.directedit.locator.CellEditorLocatorAccess;
import org.melanee.core.modeleditor.part.PLMVisualIDRegistry;

/**
 * @generated
 */
public class PLMEditPartFactory implements EditPartFactory {

	/**
	* @generated
	*/
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (PLMVisualIDRegistry.getVisualID(view)) {

			case DomainEditPart.VISUAL_ID:
				return new DomainEditPart(view);

			case DeepModelEditPart.VISUAL_ID:
				return new DeepModelEditPart(view);

			case DeepModelNameEditPart.VISUAL_ID:
				return new DeepModelNameEditPart(view);

			case WrappingLabelEditPart.VISUAL_ID:
				return new WrappingLabelEditPart(view);

			case WrappingLabel2EditPart.VISUAL_ID:
				return new WrappingLabel2EditPart(view);

			case EnumerationEditPart.VISUAL_ID:
				return new EnumerationEditPart(view);

			case EnumerationNameEditPart.VISUAL_ID:
				return new EnumerationNameEditPart(view);

			case EnumerationLiteralEditPart.VISUAL_ID:
				return new EnumerationLiteralEditPart(view);

			case LevelEditPart.VISUAL_ID:
				return new LevelEditPart(view);

			case LevelNameEditPart.VISUAL_ID:
				return new LevelNameEditPart(view);

			case WrappingLabel3EditPart.VISUAL_ID:
				return new WrappingLabel3EditPart(view);

			case ConnectionEditPart.VISUAL_ID:
				return new ConnectionEditPart(view);

			case WrappingLabel4EditPart.VISUAL_ID:
				return new WrappingLabel4EditPart(view);

			case ConnectionNameEditPart.VISUAL_ID:
				return new ConnectionNameEditPart(view);

			case WrappingLabel5EditPart.VISUAL_ID:
				return new WrappingLabel5EditPart(view);

			case WrappingLabel6EditPart.VISUAL_ID:
				return new WrappingLabel6EditPart(view);

			case WrappingLabel7EditPart.VISUAL_ID:
				return new WrappingLabel7EditPart(view);

			case WrappingLabel8EditPart.VISUAL_ID:
				return new WrappingLabel8EditPart(view);

			case AttributeEditPart.VISUAL_ID:
				return new AttributeEditPart(view);

			case AttributeNameEditPart.VISUAL_ID:
				return new AttributeNameEditPart(view);

			case WrappingLabel9EditPart.VISUAL_ID:
				return new WrappingLabel9EditPart(view);

			case WrappingLabel10EditPart.VISUAL_ID:
				return new WrappingLabel10EditPart(view);

			case WrappingLabel11EditPart.VISUAL_ID:
				return new WrappingLabel11EditPart(view);

			case WrappingLabel12EditPart.VISUAL_ID:
				return new WrappingLabel12EditPart(view);

			case MethodEditPart.VISUAL_ID:
				return new MethodEditPart(view);

			case MethodNameEditPart.VISUAL_ID:
				return new MethodNameEditPart(view);

			case WrappingLabel13EditPart.VISUAL_ID:
				return new WrappingLabel13EditPart(view);

			case WrappingLabel14EditPart.VISUAL_ID:
				return new WrappingLabel14EditPart(view);

			case WrappingLabel15EditPart.VISUAL_ID:
				return new WrappingLabel15EditPart(view);

			case EntityEditPart.VISUAL_ID:
				return new EntityEditPart(view);

			case WrappingLabel16EditPart.VISUAL_ID:
				return new WrappingLabel16EditPart(view);

			case WrappingLabel17EditPart.VISUAL_ID:
				return new WrappingLabel17EditPart(view);

			case WrappingLabel18EditPart.VISUAL_ID:
				return new WrappingLabel18EditPart(view);

			case WrappingLabel19EditPart.VISUAL_ID:
				return new WrappingLabel19EditPart(view);

			case WrappingLabel20EditPart.VISUAL_ID:
				return new WrappingLabel20EditPart(view);

			case ConnectionNameExternalLabelEditPart.VISUAL_ID:
				return new ConnectionNameExternalLabelEditPart(view);

			case Attribute2EditPart.VISUAL_ID:
				return new Attribute2EditPart(view);

			case AttributeName2EditPart.VISUAL_ID:
				return new AttributeName2EditPart(view);

			case WrappingLabel21EditPart.VISUAL_ID:
				return new WrappingLabel21EditPart(view);

			case WrappingLabel22EditPart.VISUAL_ID:
				return new WrappingLabel22EditPart(view);

			case WrappingLabel23EditPart.VISUAL_ID:
				return new WrappingLabel23EditPart(view);

			case WrappingLabel24EditPart.VISUAL_ID:
				return new WrappingLabel24EditPart(view);

			case Method2EditPart.VISUAL_ID:
				return new Method2EditPart(view);

			case MethodName2EditPart.VISUAL_ID:
				return new MethodName2EditPart(view);

			case WrappingLabel25EditPart.VISUAL_ID:
				return new WrappingLabel25EditPart(view);

			case WrappingLabel26EditPart.VISUAL_ID:
				return new WrappingLabel26EditPart(view);

			case WrappingLabel27EditPart.VISUAL_ID:
				return new WrappingLabel27EditPart(view);

			case Connection2EditPart.VISUAL_ID:
				return new Connection2EditPart(view);

			case WrappingLabel28EditPart.VISUAL_ID:
				return new WrappingLabel28EditPart(view);

			case ConnectionName2EditPart.VISUAL_ID:
				return new ConnectionName2EditPart(view);

			case WrappingLabel29EditPart.VISUAL_ID:
				return new WrappingLabel29EditPart(view);

			case WrappingLabel30EditPart.VISUAL_ID:
				return new WrappingLabel30EditPart(view);

			case WrappingLabel31EditPart.VISUAL_ID:
				return new WrappingLabel31EditPart(view);

			case WrappingLabel32EditPart.VISUAL_ID:
				return new WrappingLabel32EditPart(view);

			case InheritanceEditPart.VISUAL_ID:
				return new InheritanceEditPart(view);

			case InheritanceNameEditPart.VISUAL_ID:
				return new InheritanceNameEditPart(view);

			case InheritanceName2EditPart.VISUAL_ID:
				return new InheritanceName2EditPart(view);

			case WrappingLabel33EditPart.VISUAL_ID:
				return new WrappingLabel33EditPart(view);

			case Inheritance2EditPart.VISUAL_ID:
				return new Inheritance2EditPart(view);

			case InheritanceName3EditPart.VISUAL_ID:
				return new InheritanceName3EditPart(view);

			case InheritanceName4EditPart.VISUAL_ID:
				return new InheritanceName4EditPart(view);

			case WrappingLabel34EditPart.VISUAL_ID:
				return new WrappingLabel34EditPart(view);

			case Entity2EditPart.VISUAL_ID:
				return new Entity2EditPart(view);

			case WrappingLabel35EditPart.VISUAL_ID:
				return new WrappingLabel35EditPart(view);

			case WrappingLabel36EditPart.VISUAL_ID:
				return new WrappingLabel36EditPart(view);

			case WrappingLabel37EditPart.VISUAL_ID:
				return new WrappingLabel37EditPart(view);

			case WrappingLabel38EditPart.VISUAL_ID:
				return new WrappingLabel38EditPart(view);

			case WrappingLabel39EditPart.VISUAL_ID:
				return new WrappingLabel39EditPart(view);

			case ConnectionNameExternalLabel2EditPart.VISUAL_ID:
				return new ConnectionNameExternalLabel2EditPart(view);

			case PackageEditPart.VISUAL_ID:
				return new PackageEditPart(view);

			case PackageNameEditPart.VISUAL_ID:
				return new PackageNameEditPart(view);

			case Entity3EditPart.VISUAL_ID:
				return new Entity3EditPart(view);

			case WrappingLabel40EditPart.VISUAL_ID:
				return new WrappingLabel40EditPart(view);

			case WrappingLabel41EditPart.VISUAL_ID:
				return new WrappingLabel41EditPart(view);

			case WrappingLabel42EditPart.VISUAL_ID:
				return new WrappingLabel42EditPart(view);

			case WrappingLabel43EditPart.VISUAL_ID:
				return new WrappingLabel43EditPart(view);

			case WrappingLabel44EditPart.VISUAL_ID:
				return new WrappingLabel44EditPart(view);

			case ConnectionNameExternalLabel3EditPart.VISUAL_ID:
				return new ConnectionNameExternalLabel3EditPart(view);

			case Connection3EditPart.VISUAL_ID:
				return new Connection3EditPart(view);

			case WrappingLabel45EditPart.VISUAL_ID:
				return new WrappingLabel45EditPart(view);

			case ConnectionName3EditPart.VISUAL_ID:
				return new ConnectionName3EditPart(view);

			case WrappingLabel46EditPart.VISUAL_ID:
				return new WrappingLabel46EditPart(view);

			case WrappingLabel47EditPart.VISUAL_ID:
				return new WrappingLabel47EditPart(view);

			case WrappingLabel48EditPart.VISUAL_ID:
				return new WrappingLabel48EditPart(view);

			case WrappingLabel49EditPart.VISUAL_ID:
				return new WrappingLabel49EditPart(view);

			case Inheritance3EditPart.VISUAL_ID:
				return new Inheritance3EditPart(view);

			case InheritanceName5EditPart.VISUAL_ID:
				return new InheritanceName5EditPart(view);

			case InheritanceName6EditPart.VISUAL_ID:
				return new InheritanceName6EditPart(view);

			case WrappingLabel50EditPart.VISUAL_ID:
				return new WrappingLabel50EditPart(view);

			case Package2EditPart.VISUAL_ID:
				return new Package2EditPart(view);

			case PackageName2EditPart.VISUAL_ID:
				return new PackageName2EditPart(view);

			case DeepModelDeepModelEnumerationCompartmentEditPart.VISUAL_ID:
				return new DeepModelDeepModelEnumerationCompartmentEditPart(view);

			case DeepModelDeepModelLevelCompartmentEditPart.VISUAL_ID:
				return new DeepModelDeepModelLevelCompartmentEditPart(view);

			case LevelDomainElementsCompartmentEditPart.VISUAL_ID:
				return new LevelDomainElementsCompartmentEditPart(view);

			case ConnectionConnectionAttributesCompartmentEditPart.VISUAL_ID:
				return new ConnectionConnectionAttributesCompartmentEditPart(view);

			case ConnectionConnectionMethodsCompartmentEditPart.VISUAL_ID:
				return new ConnectionConnectionMethodsCompartmentEditPart(view);

			case ConnectionConnectionContentsCompartmentEditPart.VISUAL_ID:
				return new ConnectionConnectionContentsCompartmentEditPart(view);

			case EntityEntityAttributesCompartmentEditPart.VISUAL_ID:
				return new EntityEntityAttributesCompartmentEditPart(view);

			case EntityEntityMethodsCompartmentEditPart.VISUAL_ID:
				return new EntityEntityMethodsCompartmentEditPart(view);

			case EntityEntityContentsCompartmentEditPart.VISUAL_ID:
				return new EntityEntityContentsCompartmentEditPart(view);

			case ConnectionConnectionAttributesCompartment2EditPart.VISUAL_ID:
				return new ConnectionConnectionAttributesCompartment2EditPart(view);

			case ConnectionConnectionMethodsCompartment2EditPart.VISUAL_ID:
				return new ConnectionConnectionMethodsCompartment2EditPart(view);

			case ConnectionConnectionContentsCompartment2EditPart.VISUAL_ID:
				return new ConnectionConnectionContentsCompartment2EditPart(view);

			case EntityEntityAttributesCompartment2EditPart.VISUAL_ID:
				return new EntityEntityAttributesCompartment2EditPart(view);

			case EntityEntityMethodsCompartment2EditPart.VISUAL_ID:
				return new EntityEntityMethodsCompartment2EditPart(view);

			case EntityEntityContentsCompartment2EditPart.VISUAL_ID:
				return new EntityEntityContentsCompartment2EditPart(view);

			case PackagePackageContentCompartmentEditPart.VISUAL_ID:
				return new PackagePackageContentCompartmentEditPart(view);

			case EntityEntityAttributesCompartment3EditPart.VISUAL_ID:
				return new EntityEntityAttributesCompartment3EditPart(view);

			case EntityEntityMethodsCompartment3EditPart.VISUAL_ID:
				return new EntityEntityMethodsCompartment3EditPart(view);

			case EntityEntityContentsCompartment3EditPart.VISUAL_ID:
				return new EntityEntityContentsCompartment3EditPart(view);

			case ConnectionConnectionAttributesCompartment3EditPart.VISUAL_ID:
				return new ConnectionConnectionAttributesCompartment3EditPart(view);

			case ConnectionConnectionMethodsCompartment3EditPart.VISUAL_ID:
				return new ConnectionConnectionMethodsCompartment3EditPart(view);

			case ConnectionConnectionContentsCompartment3EditPart.VISUAL_ID:
				return new ConnectionConnectionContentsCompartment3EditPart(view);

			case PackagePackageContentCompartment2EditPart.VISUAL_ID:
				return new PackagePackageContentCompartment2EditPart(view);

			case ClassificationEditPart.VISUAL_ID:
				return new ClassificationEditPart(view);

			case WrappingLabel51EditPart.VISUAL_ID:
				return new WrappingLabel51EditPart(view);

			case WrappingLabel52EditPart.VISUAL_ID:
				return new WrappingLabel52EditPart(view);

			case SupertypeEditPart.VISUAL_ID:
				return new SupertypeEditPart(view);

			case SubtypeEditPart.VISUAL_ID:
				return new SubtypeEditPart(view);

			case ConnectionEndEditPart.VISUAL_ID:
				return new ConnectionEndEditPart(view);

			case WrappingLabel53EditPart.VISUAL_ID:
				return new WrappingLabel53EditPart(view);

			case WrappingLabel54EditPart.VISUAL_ID:
				return new WrappingLabel54EditPart(view);

			}
		}
		return createUnrecognizedEditPart(context, model);
	}

	/**
	* @generated
	*/
	private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
		// Handle creation of unrecognized child node EditParts here
		return null;
	}

	/**
	* @generated
	*/
	public static CellEditorLocator getTextCellEditorLocator(ITextAwareEditPart source) {
		return CellEditorLocatorAccess.INSTANCE.getTextCellEditorLocator(source);
	}

}

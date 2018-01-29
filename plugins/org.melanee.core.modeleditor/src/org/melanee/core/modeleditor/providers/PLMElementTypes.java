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
package org.melanee.core.modeleditor.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypeImages;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypes;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
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
import org.melanee.core.modeleditor.part.PLMDiagramEditorPlugin;
import org.melanee.core.models.plm.PLM.PLMPackage;

/**
 * @generated
 */
public class PLMElementTypes {

	/**
	* @generated
	*/
	private PLMElementTypes() {
	}

	/**
	* @generated
	*/
	private static Map<IElementType, ENamedElement> elements;

	/**
	* @generated
	*/
	private static DiagramElementTypeImages elementTypeImages = new DiagramElementTypeImages(
			PLMDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());

	/**
	* @generated
	*/
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	* @generated
	*/
	public static final IElementType Domain_1000 = getElementType("org.melanee.core.modeleditor.Domain_1000"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType DeepModel_2005 = getElementType("org.melanee.core.modeleditor.DeepModel_2005"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Enumeration_3123 = getElementType("org.melanee.core.modeleditor.Enumeration_3123"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Level_3097 = getElementType("org.melanee.core.modeleditor.Level_3097"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Connection_3099 = getElementType("org.melanee.core.modeleditor.Connection_3099"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Attribute_3100 = getElementType("org.melanee.core.modeleditor.Attribute_3100"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Method_3102 = getElementType("org.melanee.core.modeleditor.Method_3102"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Entity_3105 = getElementType("org.melanee.core.modeleditor.Entity_3105"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Attribute_3106 = getElementType("org.melanee.core.modeleditor.Attribute_3106"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Method_3108 = getElementType("org.melanee.core.modeleditor.Method_3108"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Connection_3111 = getElementType("org.melanee.core.modeleditor.Connection_3111"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Inheritance_3124 = getElementType("org.melanee.core.modeleditor.Inheritance_3124"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Inheritance_3122 = getElementType("org.melanee.core.modeleditor.Inheritance_3122"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Entity_3120 = getElementType("org.melanee.core.modeleditor.Entity_3120"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Package_3125 = getElementType("org.melanee.core.modeleditor.Package_3125"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Entity_3126 = getElementType("org.melanee.core.modeleditor.Entity_3126"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Connection_3127 = getElementType("org.melanee.core.modeleditor.Connection_3127"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Inheritance_3128 = getElementType("org.melanee.core.modeleditor.Inheritance_3128"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Package_3129 = getElementType("org.melanee.core.modeleditor.Package_3129"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Classification_4026 = getElementType(
			"org.melanee.core.modeleditor.Classification_4026"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Supertype_4034 = getElementType("org.melanee.core.modeleditor.Supertype_4034"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Subtype_4035 = getElementType("org.melanee.core.modeleditor.Subtype_4035"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType ConnectionEnd_4036 = getElementType(
			"org.melanee.core.modeleditor.ConnectionEnd_4036"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		return elementTypeImages.getImageDescriptor(element);
	}

	/**
	* @generated
	*/
	public static Image getImage(ENamedElement element) {
		return elementTypeImages.getImage(element);
	}

	/**
	* @generated
	*/
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		return getImageDescriptor(getElement(hint));
	}

	/**
	* @generated
	*/
	public static Image getImage(IAdaptable hint) {
		return getImage(getElement(hint));
	}

	/**
	* Returns 'type' of the ecore object associated with the hint.
	* 
	* @generated
	*/
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap<IElementType, ENamedElement>();

			elements.put(Domain_1000, PLMPackage.eINSTANCE.getDomain());

			elements.put(DeepModel_2005, PLMPackage.eINSTANCE.getDeepModel());

			elements.put(Enumeration_3123, PLMPackage.eINSTANCE.getEnumeration());

			elements.put(Level_3097, PLMPackage.eINSTANCE.getLevel());

			elements.put(Connection_3099, PLMPackage.eINSTANCE.getConnection());

			elements.put(Attribute_3100, PLMPackage.eINSTANCE.getAttribute());

			elements.put(Method_3102, PLMPackage.eINSTANCE.getMethod());

			elements.put(Entity_3105, PLMPackage.eINSTANCE.getEntity());

			elements.put(Attribute_3106, PLMPackage.eINSTANCE.getAttribute());

			elements.put(Method_3108, PLMPackage.eINSTANCE.getMethod());

			elements.put(Connection_3111, PLMPackage.eINSTANCE.getConnection());

			elements.put(Inheritance_3124, PLMPackage.eINSTANCE.getInheritance());

			elements.put(Inheritance_3122, PLMPackage.eINSTANCE.getInheritance());

			elements.put(Entity_3120, PLMPackage.eINSTANCE.getEntity());

			elements.put(Package_3125, PLMPackage.eINSTANCE.getPackage());

			elements.put(Entity_3126, PLMPackage.eINSTANCE.getEntity());

			elements.put(Connection_3127, PLMPackage.eINSTANCE.getConnection());

			elements.put(Inheritance_3128, PLMPackage.eINSTANCE.getInheritance());

			elements.put(Package_3129, PLMPackage.eINSTANCE.getPackage());

			elements.put(Classification_4026, PLMPackage.eINSTANCE.getClassification());

			elements.put(Supertype_4034, PLMPackage.eINSTANCE.getSupertype());

			elements.put(Subtype_4035, PLMPackage.eINSTANCE.getSubtype());

			elements.put(ConnectionEnd_4036, PLMPackage.eINSTANCE.getConnectionEnd());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	* @generated
	*/
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	* @generated
	*/
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet<IElementType>();
			KNOWN_ELEMENT_TYPES.add(Domain_1000);
			KNOWN_ELEMENT_TYPES.add(DeepModel_2005);
			KNOWN_ELEMENT_TYPES.add(Enumeration_3123);
			KNOWN_ELEMENT_TYPES.add(Level_3097);
			KNOWN_ELEMENT_TYPES.add(Connection_3099);
			KNOWN_ELEMENT_TYPES.add(Attribute_3100);
			KNOWN_ELEMENT_TYPES.add(Method_3102);
			KNOWN_ELEMENT_TYPES.add(Entity_3105);
			KNOWN_ELEMENT_TYPES.add(Attribute_3106);
			KNOWN_ELEMENT_TYPES.add(Method_3108);
			KNOWN_ELEMENT_TYPES.add(Connection_3111);
			KNOWN_ELEMENT_TYPES.add(Inheritance_3124);
			KNOWN_ELEMENT_TYPES.add(Inheritance_3122);
			KNOWN_ELEMENT_TYPES.add(Entity_3120);
			KNOWN_ELEMENT_TYPES.add(Package_3125);
			KNOWN_ELEMENT_TYPES.add(Entity_3126);
			KNOWN_ELEMENT_TYPES.add(Connection_3127);
			KNOWN_ELEMENT_TYPES.add(Inheritance_3128);
			KNOWN_ELEMENT_TYPES.add(Package_3129);
			KNOWN_ELEMENT_TYPES.add(Classification_4026);
			KNOWN_ELEMENT_TYPES.add(Supertype_4034);
			KNOWN_ELEMENT_TYPES.add(Subtype_4035);
			KNOWN_ELEMENT_TYPES.add(ConnectionEnd_4036);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	* @generated
	*/
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case DomainEditPart.VISUAL_ID:
			return Domain_1000;
		case DeepModelEditPart.VISUAL_ID:
			return DeepModel_2005;
		case EnumerationEditPart.VISUAL_ID:
			return Enumeration_3123;
		case LevelEditPart.VISUAL_ID:
			return Level_3097;
		case ConnectionEditPart.VISUAL_ID:
			return Connection_3099;
		case AttributeEditPart.VISUAL_ID:
			return Attribute_3100;
		case MethodEditPart.VISUAL_ID:
			return Method_3102;
		case EntityEditPart.VISUAL_ID:
			return Entity_3105;
		case Attribute2EditPart.VISUAL_ID:
			return Attribute_3106;
		case Method2EditPart.VISUAL_ID:
			return Method_3108;
		case Connection2EditPart.VISUAL_ID:
			return Connection_3111;
		case InheritanceEditPart.VISUAL_ID:
			return Inheritance_3124;
		case Inheritance2EditPart.VISUAL_ID:
			return Inheritance_3122;
		case Entity2EditPart.VISUAL_ID:
			return Entity_3120;
		case PackageEditPart.VISUAL_ID:
			return Package_3125;
		case Entity3EditPart.VISUAL_ID:
			return Entity_3126;
		case Connection3EditPart.VISUAL_ID:
			return Connection_3127;
		case Inheritance3EditPart.VISUAL_ID:
			return Inheritance_3128;
		case Package2EditPart.VISUAL_ID:
			return Package_3129;
		case ClassificationEditPart.VISUAL_ID:
			return Classification_4026;
		case SupertypeEditPart.VISUAL_ID:
			return Supertype_4034;
		case SubtypeEditPart.VISUAL_ID:
			return Subtype_4035;
		case ConnectionEndEditPart.VISUAL_ID:
			return ConnectionEnd_4036;
		}
		return null;
	}

	/**
	* @generated
	*/
	public static final DiagramElementTypes TYPED_INSTANCE = new DiagramElementTypes(elementTypeImages) {

		/**
		* @generated
		*/
		@Override

		public boolean isKnownElementType(IElementType elementType) {
			return org.melanee.core.modeleditor.providers.PLMElementTypes.isKnownElementType(elementType);
		}

		/**
		* @generated
		*/
		@Override

		public IElementType getElementTypeForVisualId(int visualID) {
			return org.melanee.core.modeleditor.providers.PLMElementTypes.getElementType(visualID);
		}

		/**
		* @generated
		*/
		@Override

		public ENamedElement getDefiningNamedElement(IAdaptable elementTypeAdapter) {
			return org.melanee.core.modeleditor.providers.PLMElementTypes.getElement(elementTypeAdapter);
		}
	};

}

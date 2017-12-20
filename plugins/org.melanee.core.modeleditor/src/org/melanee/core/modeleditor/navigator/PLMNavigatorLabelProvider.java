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
package org.melanee.core.modeleditor.navigator;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;
import org.melanee.core.modeleditor.edit.parts.Attribute2EditPart;
import org.melanee.core.modeleditor.edit.parts.AttributeEditPart;
import org.melanee.core.modeleditor.edit.parts.AttributeName2EditPart;
import org.melanee.core.modeleditor.edit.parts.AttributeNameEditPart;
import org.melanee.core.modeleditor.edit.parts.ClassificationEditPart;
import org.melanee.core.modeleditor.edit.parts.Connection2EditPart;
import org.melanee.core.modeleditor.edit.parts.Connection3EditPart;
import org.melanee.core.modeleditor.edit.parts.ConnectionEditPart;
import org.melanee.core.modeleditor.edit.parts.ConnectionEndEditPart;
import org.melanee.core.modeleditor.edit.parts.DeepModelEditPart;
import org.melanee.core.modeleditor.edit.parts.DeepModelNameEditPart;
import org.melanee.core.modeleditor.edit.parts.DomainEditPart;
import org.melanee.core.modeleditor.edit.parts.Entity2EditPart;
import org.melanee.core.modeleditor.edit.parts.Entity3EditPart;
import org.melanee.core.modeleditor.edit.parts.EntityEditPart;
import org.melanee.core.modeleditor.edit.parts.EnumerationEditPart;
import org.melanee.core.modeleditor.edit.parts.EnumerationNameEditPart;
import org.melanee.core.modeleditor.edit.parts.Inheritance2EditPart;
import org.melanee.core.modeleditor.edit.parts.Inheritance3EditPart;
import org.melanee.core.modeleditor.edit.parts.InheritanceEditPart;
import org.melanee.core.modeleditor.edit.parts.InheritanceName3EditPart;
import org.melanee.core.modeleditor.edit.parts.InheritanceName5EditPart;
import org.melanee.core.modeleditor.edit.parts.InheritanceNameEditPart;
import org.melanee.core.modeleditor.edit.parts.LevelEditPart;
import org.melanee.core.modeleditor.edit.parts.LevelNameEditPart;
import org.melanee.core.modeleditor.edit.parts.Method2EditPart;
import org.melanee.core.modeleditor.edit.parts.MethodEditPart;
import org.melanee.core.modeleditor.edit.parts.MethodName2EditPart;
import org.melanee.core.modeleditor.edit.parts.MethodNameEditPart;
import org.melanee.core.modeleditor.edit.parts.Package2EditPart;
import org.melanee.core.modeleditor.edit.parts.PackageEditPart;
import org.melanee.core.modeleditor.edit.parts.PackageName2EditPart;
import org.melanee.core.modeleditor.edit.parts.PackageNameEditPart;
import org.melanee.core.modeleditor.edit.parts.SubtypeEditPart;
import org.melanee.core.modeleditor.edit.parts.SupertypeEditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel16EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel28EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel35EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel40EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel45EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel4EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel51EditPart;
import org.melanee.core.modeleditor.edit.parts.WrappingLabel53EditPart;
import org.melanee.core.modeleditor.part.PLMDiagramEditorPlugin;
import org.melanee.core.modeleditor.part.PLMVisualIDRegistry;
import org.melanee.core.modeleditor.providers.PLMElementTypes;
import org.melanee.core.modeleditor.providers.PLMParserProvider;
import org.melanee.core.models.plm.PLM.Domain;

/**
 * @generated
 */
public class PLMNavigatorLabelProvider extends LabelProvider implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	* @generated
	*/
	static {
		PLMDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?UnknownElement", //$NON-NLS-1$
				ImageDescriptor.getMissingImageDescriptor());
		PLMDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?ImageNotFound", //$NON-NLS-1$
				ImageDescriptor.getMissingImageDescriptor());
	}

	/**
	* @generated
	*/
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof PLMNavigatorItem && !isOwnView(((PLMNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	* @generated
	*/
	public Image getImage(Object element) {
		if (element instanceof PLMNavigatorGroup) {
			PLMNavigatorGroup group = (PLMNavigatorGroup) element;
			return PLMDiagramEditorPlugin.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof PLMNavigatorItem) {
			PLMNavigatorItem navigatorItem = (PLMNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		return super.getImage(element);
	}

	/**
	* @generated
	*/
	public Image getImage(View view) {
		switch (PLMVisualIDRegistry.getVisualID(view)) {
		case DomainEditPart.VISUAL_ID:
			return getImage("Navigator?Diagram?http://melanee.org/PLM?Domain", PLMElementTypes.Domain_1000); //$NON-NLS-1$
		case DeepModelEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://melanee.org/PLM?DeepModel", PLMElementTypes.DeepModel_2005); //$NON-NLS-1$
		case LevelEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://melanee.org/PLM?Level", PLMElementTypes.Level_3097); //$NON-NLS-1$
		case ConnectionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://melanee.org/PLM?Connection", PLMElementTypes.Connection_3099); //$NON-NLS-1$
		case AttributeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://melanee.org/PLM?Attribute", PLMElementTypes.Attribute_3100); //$NON-NLS-1$
		case MethodEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://melanee.org/PLM?Method", PLMElementTypes.Method_3102); //$NON-NLS-1$
		case EntityEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://melanee.org/PLM?Entity", PLMElementTypes.Entity_3105); //$NON-NLS-1$
		case Attribute2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://melanee.org/PLM?Attribute", PLMElementTypes.Attribute_3106); //$NON-NLS-1$
		case Method2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://melanee.org/PLM?Method", PLMElementTypes.Method_3108); //$NON-NLS-1$
		case Connection2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://melanee.org/PLM?Connection", PLMElementTypes.Connection_3111); //$NON-NLS-1$
		case Entity2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://melanee.org/PLM?Entity", PLMElementTypes.Entity_3120); //$NON-NLS-1$
		case Inheritance2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://melanee.org/PLM?Inheritance", PLMElementTypes.Inheritance_3122); //$NON-NLS-1$
		case EnumerationEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://melanee.org/PLM?Enumeration", PLMElementTypes.Enumeration_3123); //$NON-NLS-1$
		case InheritanceEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://melanee.org/PLM?Inheritance", PLMElementTypes.Inheritance_3124); //$NON-NLS-1$
		case PackageEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://melanee.org/PLM?Package", PLMElementTypes.Package_3125); //$NON-NLS-1$
		case Entity3EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://melanee.org/PLM?Entity", PLMElementTypes.Entity_3126); //$NON-NLS-1$
		case Connection3EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://melanee.org/PLM?Connection", PLMElementTypes.Connection_3127); //$NON-NLS-1$
		case Inheritance3EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://melanee.org/PLM?Inheritance", PLMElementTypes.Inheritance_3128); //$NON-NLS-1$
		case Package2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://melanee.org/PLM?Package", PLMElementTypes.Package_3129); //$NON-NLS-1$
		case ClassificationEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://melanee.org/PLM?Classification", //$NON-NLS-1$
					PLMElementTypes.Classification_4026);
		case SupertypeEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://melanee.org/PLM?Supertype", PLMElementTypes.Supertype_4034); //$NON-NLS-1$
		case SubtypeEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://melanee.org/PLM?Subtype", PLMElementTypes.Subtype_4035); //$NON-NLS-1$
		case ConnectionEndEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://melanee.org/PLM?ConnectionEnd", PLMElementTypes.ConnectionEnd_4036); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = PLMDiagramEditorPlugin.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null && PLMElementTypes.isKnownElementType(elementType)) {
			image = PLMElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	* @generated
	*/
	public String getText(Object element) {
		if (element instanceof PLMNavigatorGroup) {
			PLMNavigatorGroup group = (PLMNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof PLMNavigatorItem) {
			PLMNavigatorItem navigatorItem = (PLMNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		return super.getText(element);
	}

	/**
	* @generated
	*/
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (PLMVisualIDRegistry.getVisualID(view)) {
		case DomainEditPart.VISUAL_ID:
			return getDomain_1000Text(view);
		case DeepModelEditPart.VISUAL_ID:
			return getDeepModel_2005Text(view);
		case LevelEditPart.VISUAL_ID:
			return getLevel_3097Text(view);
		case ConnectionEditPart.VISUAL_ID:
			return getConnection_3099Text(view);
		case AttributeEditPart.VISUAL_ID:
			return getAttribute_3100Text(view);
		case MethodEditPart.VISUAL_ID:
			return getMethod_3102Text(view);
		case EntityEditPart.VISUAL_ID:
			return getEntity_3105Text(view);
		case Attribute2EditPart.VISUAL_ID:
			return getAttribute_3106Text(view);
		case Method2EditPart.VISUAL_ID:
			return getMethod_3108Text(view);
		case Connection2EditPart.VISUAL_ID:
			return getConnection_3111Text(view);
		case Entity2EditPart.VISUAL_ID:
			return getEntity_3120Text(view);
		case Inheritance2EditPart.VISUAL_ID:
			return getInheritance_3122Text(view);
		case EnumerationEditPart.VISUAL_ID:
			return getEnumeration_3123Text(view);
		case InheritanceEditPart.VISUAL_ID:
			return getInheritance_3124Text(view);
		case PackageEditPart.VISUAL_ID:
			return getPackage_3125Text(view);
		case Entity3EditPart.VISUAL_ID:
			return getEntity_3126Text(view);
		case Connection3EditPart.VISUAL_ID:
			return getConnection_3127Text(view);
		case Inheritance3EditPart.VISUAL_ID:
			return getInheritance_3128Text(view);
		case Package2EditPart.VISUAL_ID:
			return getPackage_3129Text(view);
		case ClassificationEditPart.VISUAL_ID:
			return getClassification_4026Text(view);
		case SupertypeEditPart.VISUAL_ID:
			return getSupertype_4034Text(view);
		case SubtypeEditPart.VISUAL_ID:
			return getSubtype_4035Text(view);
		case ConnectionEndEditPart.VISUAL_ID:
			return getConnectionEnd_4036Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	* @generated
	*/
	private String getDomain_1000Text(View view) {
		Domain domainModelElement = (Domain) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			PLMDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 1000); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getDeepModel_2005Text(View view) {
		IParser parser = PLMParserProvider.getParser(PLMElementTypes.DeepModel_2005,
				view.getElement() != null ? view.getElement() : view,
				PLMVisualIDRegistry.getType(DeepModelNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PLMDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5331); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getLevel_3097Text(View view) {
		IParser parser = PLMParserProvider.getParser(PLMElementTypes.Level_3097,
				view.getElement() != null ? view.getElement() : view,
				PLMVisualIDRegistry.getType(LevelNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PLMDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5320); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getConnection_3099Text(View view) {
		IParser parser = PLMParserProvider.getParser(PLMElementTypes.Connection_3099,
				view.getElement() != null ? view.getElement() : view,
				PLMVisualIDRegistry.getType(WrappingLabel4EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PLMDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5294); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getAttribute_3100Text(View view) {
		IParser parser = PLMParserProvider.getParser(PLMElementTypes.Attribute_3100,
				view.getElement() != null ? view.getElement() : view,
				PLMVisualIDRegistry.getType(AttributeNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PLMDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5254); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getMethod_3102Text(View view) {
		IParser parser = PLMParserProvider.getParser(PLMElementTypes.Method_3102,
				view.getElement() != null ? view.getElement() : view,
				PLMVisualIDRegistry.getType(MethodNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PLMDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5261); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getEntity_3105Text(View view) {
		IParser parser = PLMParserProvider.getParser(PLMElementTypes.Entity_3105,
				view.getElement() != null ? view.getElement() : view,
				PLMVisualIDRegistry.getType(WrappingLabel16EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PLMDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5288); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getAttribute_3106Text(View view) {
		IParser parser = PLMParserProvider.getParser(PLMElementTypes.Attribute_3106,
				view.getElement() != null ? view.getElement() : view,
				PLMVisualIDRegistry.getType(AttributeName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PLMDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5269); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getMethod_3108Text(View view) {
		IParser parser = PLMParserProvider.getParser(PLMElementTypes.Method_3108,
				view.getElement() != null ? view.getElement() : view,
				PLMVisualIDRegistry.getType(MethodName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PLMDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5276); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getConnection_3111Text(View view) {
		IParser parser = PLMParserProvider.getParser(PLMElementTypes.Connection_3111,
				view.getElement() != null ? view.getElement() : view,
				PLMVisualIDRegistry.getType(WrappingLabel28EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PLMDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5282); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getEntity_3120Text(View view) {
		IParser parser = PLMParserProvider.getParser(PLMElementTypes.Entity_3120,
				view.getElement() != null ? view.getElement() : view,
				PLMVisualIDRegistry.getType(WrappingLabel35EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PLMDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5314); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getInheritance_3122Text(View view) {
		IParser parser = PLMParserProvider.getParser(PLMElementTypes.Inheritance_3122,
				view.getElement() != null ? view.getElement() : view,
				PLMVisualIDRegistry.getType(InheritanceName3EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PLMDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5326); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getEnumeration_3123Text(View view) {
		IParser parser = PLMParserProvider.getParser(PLMElementTypes.Enumeration_3123,
				view.getElement() != null ? view.getElement() : view,
				PLMVisualIDRegistry.getType(EnumerationNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PLMDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5329); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getInheritance_3124Text(View view) {
		IParser parser = PLMParserProvider.getParser(PLMElementTypes.Inheritance_3124,
				view.getElement() != null ? view.getElement() : view,
				PLMVisualIDRegistry.getType(InheritanceNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PLMDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5333); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getPackage_3125Text(View view) {
		IParser parser = PLMParserProvider.getParser(PLMElementTypes.Package_3125,
				view.getElement() != null ? view.getElement() : view,
				PLMVisualIDRegistry.getType(PackageNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PLMDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5336); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getEntity_3126Text(View view) {
		IParser parser = PLMParserProvider.getParser(PLMElementTypes.Entity_3126,
				view.getElement() != null ? view.getElement() : view,
				PLMVisualIDRegistry.getType(WrappingLabel40EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PLMDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5337); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getConnection_3127Text(View view) {
		IParser parser = PLMParserProvider.getParser(PLMElementTypes.Connection_3127,
				view.getElement() != null ? view.getElement() : view,
				PLMVisualIDRegistry.getType(WrappingLabel45EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PLMDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5343); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getInheritance_3128Text(View view) {
		IParser parser = PLMParserProvider.getParser(PLMElementTypes.Inheritance_3128,
				view.getElement() != null ? view.getElement() : view,
				PLMVisualIDRegistry.getType(InheritanceName5EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PLMDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5349); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getPackage_3129Text(View view) {
		IParser parser = PLMParserProvider.getParser(PLMElementTypes.Package_3129,
				view.getElement() != null ? view.getElement() : view,
				PLMVisualIDRegistry.getType(PackageName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PLMDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5352); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getClassification_4026Text(View view) {
		IParser parser = PLMParserProvider.getParser(PLMElementTypes.Classification_4026,
				view.getElement() != null ? view.getElement() : view,
				PLMVisualIDRegistry.getType(WrappingLabel51EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PLMDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6016); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getSupertype_4034Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private String getSubtype_4035Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private String getConnectionEnd_4036Text(View view) {
		IParser parser = PLMParserProvider.getParser(PLMElementTypes.ConnectionEnd_4036,
				view.getElement() != null ? view.getElement() : view,
				PLMVisualIDRegistry.getType(WrappingLabel53EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PLMDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6024); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	* @generated
	*/
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	* @generated
	*/
	public void init(ICommonContentExtensionSite aConfig) {
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
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	* @generated
	*/
	private boolean isOwnView(View view) {
		return DomainEditPart.MODEL_ID.equals(PLMVisualIDRegistry.getModelID(view));
	}

}

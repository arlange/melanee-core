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

import java.util.ArrayList;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.providers.IViewProvider;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateDiagramViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateEdgeViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateNodeViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateViewForKindOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateViewOperation;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.MeasurementUnit;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.RelativeBendpoints;
import org.eclipse.gmf.runtime.notation.Routing;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.TitleStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontData;
import org.melanee.core.modeleditor.edit.parts.*;
import org.melanee.core.modeleditor.part.PLMVisualIDRegistry;
import org.melanee.core.models.plm.PLM.Classification;
import org.melanee.core.models.plm.PLM.LMLVisualizer;

/**
 * @generated
 */
public class PLMViewProvider extends AbstractProvider implements IViewProvider {

	/**
	* @generated
	*/
	public final boolean provides(IOperation operation) {
		if (operation instanceof CreateViewForKindOperation) {
			return provides((CreateViewForKindOperation) operation);
		}
		assert operation instanceof CreateViewOperation;
		if (operation instanceof CreateDiagramViewOperation) {
			return provides((CreateDiagramViewOperation) operation);
		} else if (operation instanceof CreateEdgeViewOperation) {
			return provides((CreateEdgeViewOperation) operation);
		} else if (operation instanceof CreateNodeViewOperation) {
			return provides((CreateNodeViewOperation) operation);
		}
		return false;
	}

	/**
	* @generated
	*/
	protected boolean provides(CreateViewForKindOperation op) {
		/*
				if (op.getViewKind() == Node.class)
					return getNodeViewClass(op.getSemanticAdapter(), op.getContainerView(), op.getSemanticHint()) != null;
				if (op.getViewKind() == Edge.class)
					return getEdgeViewClass(op.getSemanticAdapter(), op.getContainerView(), op.getSemanticHint()) != null;
		*/
		return true;
	}

	/**
	* @generated
	*/
	protected boolean provides(CreateDiagramViewOperation op) {
		return DomainEditPart.MODEL_ID.equals(op.getSemanticHint())
				&& PLMVisualIDRegistry.getDiagramVisualID(getSemanticElement(op.getSemanticAdapter())) != -1;
	}

	/**
	* @generated
	*/
	protected boolean provides(CreateNodeViewOperation op) {
		if (op.getContainerView() == null) {
			return false;
		}
		IElementType elementType = getSemanticElementType(op.getSemanticAdapter());
		EObject domainElement = getSemanticElement(op.getSemanticAdapter());
		int visualID;
		if (op.getSemanticHint() == null) {
			// Semantic hint is not specified. Can be a result of call from CanonicalEditPolicy.
			// In this situation there should be NO elementType, visualID will be determined
			// by VisualIDRegistry.getNodeVisualID() for domainElement.
			if (elementType != null || domainElement == null) {
				return false;
			}
			visualID = PLMVisualIDRegistry.getNodeVisualID(op.getContainerView(), domainElement);
		} else {
			visualID = PLMVisualIDRegistry.getVisualID(op.getSemanticHint());
			if (elementType != null) {
				if (!PLMElementTypes.isKnownElementType(elementType) || (!(elementType instanceof IHintedType))) {
					return false; // foreign element type
				}
				String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
				if (!op.getSemanticHint().equals(elementTypeHint)) {
					return false; // if semantic hint is specified it should be the same as in element type
				}
				if (domainElement != null
						&& visualID != PLMVisualIDRegistry.getNodeVisualID(op.getContainerView(), domainElement)) {
					return false; // visual id for node EClass should match visual id from element type
				}
			} else {
				if (!DomainEditPart.MODEL_ID.equals(PLMVisualIDRegistry.getModelID(op.getContainerView()))) {
					return false; // foreign diagram
				}
				switch (visualID) {
				case DeepModelEditPart.VISUAL_ID:
				case EnumerationEditPart.VISUAL_ID:
				case LevelEditPart.VISUAL_ID:
				case ConnectionEditPart.VISUAL_ID:
				case AttributeEditPart.VISUAL_ID:
				case MethodEditPart.VISUAL_ID:
				case EntityEditPart.VISUAL_ID:
				case InheritanceEditPart.VISUAL_ID:
				case PackageEditPart.VISUAL_ID:
				case Attribute2EditPart.VISUAL_ID:
				case Method2EditPart.VISUAL_ID:
				case Connection2EditPart.VISUAL_ID:
				case Inheritance2EditPart.VISUAL_ID:
				case Entity2EditPart.VISUAL_ID:
				case Entity3EditPart.VISUAL_ID:
				case Connection3EditPart.VISUAL_ID:
				case Inheritance3EditPart.VISUAL_ID:
				case Package2EditPart.VISUAL_ID:
					if (domainElement == null
							|| visualID != PLMVisualIDRegistry.getNodeVisualID(op.getContainerView(), domainElement)) {
						return false; // visual id in semantic hint should match visual id for domain element
					}
					break;
				default:
					return false;
				}
			}
		}
		return DeepModelEditPart.VISUAL_ID == visualID || EnumerationEditPart.VISUAL_ID == visualID
				|| LevelEditPart.VISUAL_ID == visualID || ConnectionEditPart.VISUAL_ID == visualID
				|| AttributeEditPart.VISUAL_ID == visualID || MethodEditPart.VISUAL_ID == visualID
				|| EntityEditPart.VISUAL_ID == visualID || Attribute2EditPart.VISUAL_ID == visualID
				|| Method2EditPart.VISUAL_ID == visualID || Connection2EditPart.VISUAL_ID == visualID
				|| InheritanceEditPart.VISUAL_ID == visualID || Inheritance2EditPart.VISUAL_ID == visualID
				|| Entity2EditPart.VISUAL_ID == visualID || PackageEditPart.VISUAL_ID == visualID
				|| Entity3EditPart.VISUAL_ID == visualID || Connection3EditPart.VISUAL_ID == visualID
				|| Inheritance3EditPart.VISUAL_ID == visualID || Package2EditPart.VISUAL_ID == visualID;
	}

	/**
	* @generated
	*/
	protected boolean provides(CreateEdgeViewOperation op) {
		IElementType elementType = getSemanticElementType(op.getSemanticAdapter());
		if (!PLMElementTypes.isKnownElementType(elementType) || (!(elementType instanceof IHintedType))) {
			return false; // foreign element type
		}
		String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
		if (elementTypeHint == null
				|| (op.getSemanticHint() != null && !elementTypeHint.equals(op.getSemanticHint()))) {
			return false; // our hint is visual id and must be specified, and it should be the same as in element type
		}
		int visualID = PLMVisualIDRegistry.getVisualID(elementTypeHint);
		EObject domainElement = getSemanticElement(op.getSemanticAdapter());
		if (domainElement != null && visualID != PLMVisualIDRegistry.getLinkWithClassVisualID(domainElement)) {
			return false; // visual id for link EClass should match visual id from element type
		}
		return true;
	}

	/**
	* @generated
	*/
	public Diagram createDiagram(IAdaptable semanticAdapter, String diagramKind, PreferencesHint preferencesHint) {
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		diagram.getStyles().add(NotationFactory.eINSTANCE.createDiagramStyle());
		diagram.setType(DomainEditPart.MODEL_ID);
		diagram.setElement(getSemanticElement(semanticAdapter));
		diagram.setMeasurementUnit(MeasurementUnit.PIXEL_LITERAL);
		return diagram;
	}

	/**
	* @generated
	*/
	public Node createNode(IAdaptable semanticAdapter, View containerView, String semanticHint, int index,
			boolean persisted, PreferencesHint preferencesHint) {
		final EObject domainElement = getSemanticElement(semanticAdapter);
		final int visualID;
		if (semanticHint == null) {
			visualID = PLMVisualIDRegistry.getNodeVisualID(containerView, domainElement);
		} else {
			visualID = PLMVisualIDRegistry.getVisualID(semanticHint);
		}
		switch (visualID) {
		case DeepModelEditPart.VISUAL_ID:
			return createDeepModel_2005(domainElement, containerView, index, persisted, preferencesHint);
		case EnumerationEditPart.VISUAL_ID:
			return createEnumeration_3123(domainElement, containerView, index, persisted, preferencesHint);
		case LevelEditPart.VISUAL_ID:
			return createLevel_3097(domainElement, containerView, index, persisted, preferencesHint);
		case ConnectionEditPart.VISUAL_ID:
			return createConnection_3099(domainElement, containerView, index, persisted, preferencesHint);
		case AttributeEditPart.VISUAL_ID:
			return createAttribute_3100(domainElement, containerView, index, persisted, preferencesHint);
		case MethodEditPart.VISUAL_ID:
			return createMethod_3102(domainElement, containerView, index, persisted, preferencesHint);
		case EntityEditPart.VISUAL_ID:
			return createEntity_3105(domainElement, containerView, index, persisted, preferencesHint);
		case Attribute2EditPart.VISUAL_ID:
			return createAttribute_3106(domainElement, containerView, index, persisted, preferencesHint);
		case Method2EditPart.VISUAL_ID:
			return createMethod_3108(domainElement, containerView, index, persisted, preferencesHint);
		case Connection2EditPart.VISUAL_ID:
			return createConnection_3111(domainElement, containerView, index, persisted, preferencesHint);
		case InheritanceEditPart.VISUAL_ID:
			return createInheritance_3124(domainElement, containerView, index, persisted, preferencesHint);
		case Inheritance2EditPart.VISUAL_ID:
			return createInheritance_3122(domainElement, containerView, index, persisted, preferencesHint);
		case Entity2EditPart.VISUAL_ID:
			return createEntity_3120(domainElement, containerView, index, persisted, preferencesHint);
		case PackageEditPart.VISUAL_ID:
			return createPackage_3125(domainElement, containerView, index, persisted, preferencesHint);
		case Entity3EditPart.VISUAL_ID:
			return createEntity_3126(domainElement, containerView, index, persisted, preferencesHint);
		case Connection3EditPart.VISUAL_ID:
			return createConnection_3127(domainElement, containerView, index, persisted, preferencesHint);
		case Inheritance3EditPart.VISUAL_ID:
			return createInheritance_3128(domainElement, containerView, index, persisted, preferencesHint);
		case Package2EditPart.VISUAL_ID:
			return createPackage_3129(domainElement, containerView, index, persisted, preferencesHint);
		}
		// can't happen, provided #provides(CreateNodeViewOperation) is correct
		return null;
	}

	/**
	* @generated
	*/
	public Edge createEdge(IAdaptable semanticAdapter, View containerView, String semanticHint, int index,
			boolean persisted, PreferencesHint preferencesHint) {
		IElementType elementType = getSemanticElementType(semanticAdapter);
		String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
		switch (PLMVisualIDRegistry.getVisualID(elementTypeHint)) {
		case ClassificationEditPart.VISUAL_ID:
			return createClassification_4026(getSemanticElement(semanticAdapter), containerView, index, persisted,
					preferencesHint);
		case SupertypeEditPart.VISUAL_ID:
			return createSupertype_4034(getSemanticElement(semanticAdapter), containerView, index, persisted,
					preferencesHint);
		case SubtypeEditPart.VISUAL_ID:
			return createSubtype_4035(getSemanticElement(semanticAdapter), containerView, index, persisted,
					preferencesHint);
		case ConnectionEndEditPart.VISUAL_ID:
			return createConnectionEnd_4036(getSemanticElement(semanticAdapter), containerView, index, persisted,
					preferencesHint);
		}
		// can never happen, provided #provides(CreateEdgeViewOperation) is correct
		return null;
	}

	/**
	* @generated
	*/
	public Node createDeepModel_2005(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFillStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(PLMVisualIDRegistry.getType(DeepModelEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore,
					IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore,
				IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(),
				FigureUtilities.RGBToInteger(fillRGB));
		Node label5331 = createLabel(node, PLMVisualIDRegistry.getType(DeepModelNameEditPart.VISUAL_ID));
		Node label5332 = createLabel(node, PLMVisualIDRegistry.getType(WrappingLabelEditPart.VISUAL_ID));
		Node label5353 = createLabel(node, PLMVisualIDRegistry.getType(WrappingLabel2EditPart.VISUAL_ID));
		createCompartment(node, PLMVisualIDRegistry.getType(DeepModelDeepModelEnumerationCompartmentEditPart.VISUAL_ID),
				true, false, true, true);
		createCompartment(node, PLMVisualIDRegistry.getType(DeepModelDeepModelLevelCompartmentEditPart.VISUAL_ID),
				false, false, false, false);
		return node;
	}

	/**
	* @generated
	*/
	public Node createEnumeration_3123(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(PLMVisualIDRegistry.getType(EnumerationEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore,
				IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(),
				FigureUtilities.RGBToInteger(lineRGB));
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore,
					IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore,
				IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(),
				FigureUtilities.RGBToInteger(fillRGB));
		Node label5329 = createLabel(node, PLMVisualIDRegistry.getType(EnumerationNameEditPart.VISUAL_ID));
		Node label5330 = createLabel(node, PLMVisualIDRegistry.getType(EnumerationLiteralEditPart.VISUAL_ID));
		return node;
	}

	/**
	* @generated
	*/
	public Node createLevel_3097(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(PLMVisualIDRegistry.getType(LevelEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore,
				IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(),
				FigureUtilities.RGBToInteger(lineRGB));
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore,
					IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore,
				IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(),
				FigureUtilities.RGBToInteger(fillRGB));
		Node label5320 = createLabel(node, PLMVisualIDRegistry.getType(LevelNameEditPart.VISUAL_ID));
		Node label5321 = createLabel(node, PLMVisualIDRegistry.getType(WrappingLabel3EditPart.VISUAL_ID));
		createCompartment(node, PLMVisualIDRegistry.getType(LevelDomainElementsCompartmentEditPart.VISUAL_ID), true,
				false, false, false);
		return node;
	}

	/**
	* @generated
	*/
	public Node createConnection_3099(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFillStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(PLMVisualIDRegistry.getType(ConnectionEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore,
					IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore,
				IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(),
				FigureUtilities.RGBToInteger(fillRGB));
		Node label5294 = createLabel(node, PLMVisualIDRegistry.getType(WrappingLabel4EditPart.VISUAL_ID));
		Node label5295 = createLabel(node, PLMVisualIDRegistry.getType(ConnectionNameEditPart.VISUAL_ID));
		label5295.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5295 = (Location) label5295.getLayoutConstraint();
		location5295.setX(0);
		location5295.setY(5);
		Node label5296 = createLabel(node, PLMVisualIDRegistry.getType(WrappingLabel5EditPart.VISUAL_ID));
		Node label5297 = createLabel(node, PLMVisualIDRegistry.getType(WrappingLabel6EditPart.VISUAL_ID));
		Node label5298 = createLabel(node, PLMVisualIDRegistry.getType(WrappingLabel7EditPart.VISUAL_ID));
		Node label5299 = createLabel(node, PLMVisualIDRegistry.getType(WrappingLabel8EditPart.VISUAL_ID));
		createCompartment(node,
				PLMVisualIDRegistry.getType(ConnectionConnectionAttributesCompartmentEditPart.VISUAL_ID), true, false,
				true, true);
		createCompartment(node, PLMVisualIDRegistry.getType(ConnectionConnectionMethodsCompartmentEditPart.VISUAL_ID),
				true, false, true, true);
		createCompartment(node, PLMVisualIDRegistry.getType(ConnectionConnectionContentsCompartmentEditPart.VISUAL_ID),
				true, false, false, false);
		return node;
	}

	/**
	* @generated
	*/
	public Node createAttribute_3100(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(PLMVisualIDRegistry.getType(AttributeEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore,
				IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(),
				FigureUtilities.RGBToInteger(lineRGB));
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore,
					IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore,
				IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(),
				FigureUtilities.RGBToInteger(fillRGB));
		Node label5254 = createLabel(node, PLMVisualIDRegistry.getType(AttributeNameEditPart.VISUAL_ID));
		Node label5255 = createLabel(node, PLMVisualIDRegistry.getType(WrappingLabel9EditPart.VISUAL_ID));
		Node label5256 = createLabel(node, PLMVisualIDRegistry.getType(WrappingLabel10EditPart.VISUAL_ID));
		Node label5257 = createLabel(node, PLMVisualIDRegistry.getType(WrappingLabel11EditPart.VISUAL_ID));
		Node label5258 = createLabel(node, PLMVisualIDRegistry.getType(WrappingLabel12EditPart.VISUAL_ID));
		return node;
	}

	/**
	* @generated
	*/
	public Node createMethod_3102(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(PLMVisualIDRegistry.getType(MethodEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore,
				IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(),
				FigureUtilities.RGBToInteger(lineRGB));
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore,
					IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore,
				IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(),
				FigureUtilities.RGBToInteger(fillRGB));
		Node label5261 = createLabel(node, PLMVisualIDRegistry.getType(MethodNameEditPart.VISUAL_ID));
		Node label5262 = createLabel(node, PLMVisualIDRegistry.getType(WrappingLabel13EditPart.VISUAL_ID));
		Node label5263 = createLabel(node, PLMVisualIDRegistry.getType(WrappingLabel14EditPart.VISUAL_ID));
		Node label5264 = createLabel(node, PLMVisualIDRegistry.getType(WrappingLabel15EditPart.VISUAL_ID));
		return node;
	}

	/**
	* @generated
	*/
	public Node createEntity_3105(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFillStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(PLMVisualIDRegistry.getType(EntityEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore,
					IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore,
				IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(),
				FigureUtilities.RGBToInteger(fillRGB));
		Node label5288 = createLabel(node, PLMVisualIDRegistry.getType(WrappingLabel16EditPart.VISUAL_ID));
		Node label5289 = createLabel(node, PLMVisualIDRegistry.getType(WrappingLabel17EditPart.VISUAL_ID));
		Node label5290 = createLabel(node, PLMVisualIDRegistry.getType(WrappingLabel18EditPart.VISUAL_ID));
		Node label5291 = createLabel(node, PLMVisualIDRegistry.getType(WrappingLabel19EditPart.VISUAL_ID));
		Node label5292 = createLabel(node, PLMVisualIDRegistry.getType(WrappingLabel20EditPart.VISUAL_ID));
		label5292.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		Node label5293 = createLabel(node, PLMVisualIDRegistry.getType(ConnectionNameExternalLabelEditPart.VISUAL_ID));
		label5293.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		label5293.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5293 = (Location) label5293.getLayoutConstraint();
		location5293.setX(0);
		location5293.setY(5);
		createCompartment(node, PLMVisualIDRegistry.getType(EntityEntityAttributesCompartmentEditPart.VISUAL_ID), true,
				false, true, true);
		createCompartment(node, PLMVisualIDRegistry.getType(EntityEntityMethodsCompartmentEditPart.VISUAL_ID), true,
				false, true, true);
		createCompartment(node, PLMVisualIDRegistry.getType(EntityEntityContentsCompartmentEditPart.VISUAL_ID), true,
				false, false, false);
		return node;
	}

	/**
	* @generated
	*/
	public Node createAttribute_3106(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(PLMVisualIDRegistry.getType(Attribute2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore,
				IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(),
				FigureUtilities.RGBToInteger(lineRGB));
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore,
					IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore,
				IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(),
				FigureUtilities.RGBToInteger(fillRGB));
		Node label5269 = createLabel(node, PLMVisualIDRegistry.getType(AttributeName2EditPart.VISUAL_ID));
		Node label5270 = createLabel(node, PLMVisualIDRegistry.getType(WrappingLabel21EditPart.VISUAL_ID));
		Node label5271 = createLabel(node, PLMVisualIDRegistry.getType(WrappingLabel22EditPart.VISUAL_ID));
		Node label5272 = createLabel(node, PLMVisualIDRegistry.getType(WrappingLabel23EditPart.VISUAL_ID));
		Node label5273 = createLabel(node, PLMVisualIDRegistry.getType(WrappingLabel24EditPart.VISUAL_ID));
		return node;
	}

	/**
	* @generated
	*/
	public Node createMethod_3108(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(PLMVisualIDRegistry.getType(Method2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore,
				IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(),
				FigureUtilities.RGBToInteger(lineRGB));
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore,
					IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore,
				IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(),
				FigureUtilities.RGBToInteger(fillRGB));
		Node label5276 = createLabel(node, PLMVisualIDRegistry.getType(MethodName2EditPart.VISUAL_ID));
		Node label5277 = createLabel(node, PLMVisualIDRegistry.getType(WrappingLabel25EditPart.VISUAL_ID));
		Node label5278 = createLabel(node, PLMVisualIDRegistry.getType(WrappingLabel26EditPart.VISUAL_ID));
		Node label5279 = createLabel(node, PLMVisualIDRegistry.getType(WrappingLabel27EditPart.VISUAL_ID));
		return node;
	}

	/**
	* @generated
	*/
	public Node createConnection_3111(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFillStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(PLMVisualIDRegistry.getType(Connection2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore,
					IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore,
				IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(),
				FigureUtilities.RGBToInteger(fillRGB));
		Node label5282 = createLabel(node, PLMVisualIDRegistry.getType(WrappingLabel28EditPart.VISUAL_ID));
		Node label5283 = createLabel(node, PLMVisualIDRegistry.getType(ConnectionName2EditPart.VISUAL_ID));
		label5283.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5283 = (Location) label5283.getLayoutConstraint();
		location5283.setX(0);
		location5283.setY(5);
		Node label5284 = createLabel(node, PLMVisualIDRegistry.getType(WrappingLabel29EditPart.VISUAL_ID));
		Node label5285 = createLabel(node, PLMVisualIDRegistry.getType(WrappingLabel30EditPart.VISUAL_ID));
		Node label5286 = createLabel(node, PLMVisualIDRegistry.getType(WrappingLabel31EditPart.VISUAL_ID));
		Node label5287 = createLabel(node, PLMVisualIDRegistry.getType(WrappingLabel32EditPart.VISUAL_ID));
		createCompartment(node,
				PLMVisualIDRegistry.getType(ConnectionConnectionAttributesCompartment2EditPart.VISUAL_ID), true, false,
				true, true);
		createCompartment(node, PLMVisualIDRegistry.getType(ConnectionConnectionMethodsCompartment2EditPart.VISUAL_ID),
				true, false, true, true);
		createCompartment(node, PLMVisualIDRegistry.getType(ConnectionConnectionContentsCompartment2EditPart.VISUAL_ID),
				true, false, false, false);
		return node;
	}

	/**
	* @generated
	*/
	public Node createInheritance_3124(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFillStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(PLMVisualIDRegistry.getType(InheritanceEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore,
					IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore,
				IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(),
				FigureUtilities.RGBToInteger(fillRGB));
		Node label5333 = createLabel(node, PLMVisualIDRegistry.getType(InheritanceNameEditPart.VISUAL_ID));
		Node label5334 = createLabel(node, PLMVisualIDRegistry.getType(InheritanceName2EditPart.VISUAL_ID));
		label5334.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5334 = (Location) label5334.getLayoutConstraint();
		location5334.setX(0);
		location5334.setY(5);
		Node label5335 = createLabel(node, PLMVisualIDRegistry.getType(WrappingLabel33EditPart.VISUAL_ID));
		return node;
	}

	/**
	* @generated
	*/
	public Node createInheritance_3122(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFillStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(PLMVisualIDRegistry.getType(Inheritance2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore,
					IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore,
				IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(),
				FigureUtilities.RGBToInteger(fillRGB));
		Node label5326 = createLabel(node, PLMVisualIDRegistry.getType(InheritanceName3EditPart.VISUAL_ID));
		Node label5327 = createLabel(node, PLMVisualIDRegistry.getType(InheritanceName4EditPart.VISUAL_ID));
		label5327.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5327 = (Location) label5327.getLayoutConstraint();
		location5327.setX(0);
		location5327.setY(5);
		Node label5328 = createLabel(node, PLMVisualIDRegistry.getType(WrappingLabel34EditPart.VISUAL_ID));
		return node;
	}

	/**
	* @generated
	*/
	public Node createEntity_3120(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFillStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(PLMVisualIDRegistry.getType(Entity2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore,
					IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore,
				IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(),
				FigureUtilities.RGBToInteger(fillRGB));
		Node label5314 = createLabel(node, PLMVisualIDRegistry.getType(WrappingLabel35EditPart.VISUAL_ID));
		Node label5315 = createLabel(node, PLMVisualIDRegistry.getType(WrappingLabel36EditPart.VISUAL_ID));
		Node label5316 = createLabel(node, PLMVisualIDRegistry.getType(WrappingLabel37EditPart.VISUAL_ID));
		Node label5317 = createLabel(node, PLMVisualIDRegistry.getType(WrappingLabel38EditPart.VISUAL_ID));
		Node label5318 = createLabel(node, PLMVisualIDRegistry.getType(WrappingLabel39EditPart.VISUAL_ID));
		label5318.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		Node label5319 = createLabel(node, PLMVisualIDRegistry.getType(ConnectionNameExternalLabel2EditPart.VISUAL_ID));
		label5319.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		label5319.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5319 = (Location) label5319.getLayoutConstraint();
		location5319.setX(0);
		location5319.setY(5);
		createCompartment(node, PLMVisualIDRegistry.getType(EntityEntityAttributesCompartment2EditPart.VISUAL_ID), true,
				false, true, true);
		createCompartment(node, PLMVisualIDRegistry.getType(EntityEntityMethodsCompartment2EditPart.VISUAL_ID), true,
				false, true, true);
		createCompartment(node, PLMVisualIDRegistry.getType(EntityEntityContentsCompartment2EditPart.VISUAL_ID), true,
				false, false, false);
		return node;
	}

	/**
	* @generated
	*/
	public Node createPackage_3125(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFillStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(PLMVisualIDRegistry.getType(PackageEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore,
					IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore,
				IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(),
				FigureUtilities.RGBToInteger(fillRGB));
		Node label5336 = createLabel(node, PLMVisualIDRegistry.getType(PackageNameEditPart.VISUAL_ID));
		createCompartment(node, PLMVisualIDRegistry.getType(PackagePackageContentCompartmentEditPart.VISUAL_ID), true,
				false, false, false);
		return node;
	}

	/**
	* @generated
	*/
	public Node createEntity_3126(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFillStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(PLMVisualIDRegistry.getType(Entity3EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore,
					IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore,
				IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(),
				FigureUtilities.RGBToInteger(fillRGB));
		Node label5337 = createLabel(node, PLMVisualIDRegistry.getType(WrappingLabel40EditPart.VISUAL_ID));
		Node label5338 = createLabel(node, PLMVisualIDRegistry.getType(WrappingLabel41EditPart.VISUAL_ID));
		Node label5339 = createLabel(node, PLMVisualIDRegistry.getType(WrappingLabel42EditPart.VISUAL_ID));
		Node label5340 = createLabel(node, PLMVisualIDRegistry.getType(WrappingLabel43EditPart.VISUAL_ID));
		Node label5341 = createLabel(node, PLMVisualIDRegistry.getType(WrappingLabel44EditPart.VISUAL_ID));
		label5341.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		Node label5342 = createLabel(node, PLMVisualIDRegistry.getType(ConnectionNameExternalLabel3EditPart.VISUAL_ID));
		label5342.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		label5342.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5342 = (Location) label5342.getLayoutConstraint();
		location5342.setX(0);
		location5342.setY(5);
		createCompartment(node, PLMVisualIDRegistry.getType(EntityEntityAttributesCompartment3EditPart.VISUAL_ID), true,
				false, true, true);
		createCompartment(node, PLMVisualIDRegistry.getType(EntityEntityMethodsCompartment3EditPart.VISUAL_ID), true,
				false, true, true);
		createCompartment(node, PLMVisualIDRegistry.getType(EntityEntityContentsCompartment3EditPart.VISUAL_ID), true,
				false, false, false);
		return node;
	}

	/**
	* @generated
	*/
	public Node createConnection_3127(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFillStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(PLMVisualIDRegistry.getType(Connection3EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore,
					IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore,
				IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(),
				FigureUtilities.RGBToInteger(fillRGB));
		Node label5343 = createLabel(node, PLMVisualIDRegistry.getType(WrappingLabel45EditPart.VISUAL_ID));
		Node label5344 = createLabel(node, PLMVisualIDRegistry.getType(ConnectionName3EditPart.VISUAL_ID));
		label5344.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5344 = (Location) label5344.getLayoutConstraint();
		location5344.setX(0);
		location5344.setY(5);
		Node label5345 = createLabel(node, PLMVisualIDRegistry.getType(WrappingLabel46EditPart.VISUAL_ID));
		Node label5346 = createLabel(node, PLMVisualIDRegistry.getType(WrappingLabel47EditPart.VISUAL_ID));
		Node label5347 = createLabel(node, PLMVisualIDRegistry.getType(WrappingLabel48EditPart.VISUAL_ID));
		Node label5348 = createLabel(node, PLMVisualIDRegistry.getType(WrappingLabel49EditPart.VISUAL_ID));
		createCompartment(node,
				PLMVisualIDRegistry.getType(ConnectionConnectionAttributesCompartment3EditPart.VISUAL_ID), true, false,
				true, true);
		createCompartment(node, PLMVisualIDRegistry.getType(ConnectionConnectionMethodsCompartment3EditPart.VISUAL_ID),
				true, false, true, true);
		createCompartment(node, PLMVisualIDRegistry.getType(ConnectionConnectionContentsCompartment3EditPart.VISUAL_ID),
				true, false, false, false);
		return node;
	}

	/**
	* @generated
	*/
	public Node createInheritance_3128(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFillStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(PLMVisualIDRegistry.getType(Inheritance3EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore,
					IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore,
				IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(),
				FigureUtilities.RGBToInteger(fillRGB));
		Node label5349 = createLabel(node, PLMVisualIDRegistry.getType(InheritanceName5EditPart.VISUAL_ID));
		Node label5350 = createLabel(node, PLMVisualIDRegistry.getType(InheritanceName6EditPart.VISUAL_ID));
		label5350.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5350 = (Location) label5350.getLayoutConstraint();
		location5350.setX(0);
		location5350.setY(5);
		Node label5351 = createLabel(node, PLMVisualIDRegistry.getType(WrappingLabel50EditPart.VISUAL_ID));
		return node;
	}

	/**
	* @generated
	*/
	public Node createPackage_3129(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFillStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(PLMVisualIDRegistry.getType(Package2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore,
					IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore,
				IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(),
				FigureUtilities.RGBToInteger(fillRGB));
		Node label5352 = createLabel(node, PLMVisualIDRegistry.getType(PackageName2EditPart.VISUAL_ID));
		createCompartment(node, PLMVisualIDRegistry.getType(PackagePackageContentCompartment2EditPart.VISUAL_ID), true,
				false, false, false);
		return node;
	}

	/**
	* @generated
	*/
	public Edge createClassification_4026(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Edge edge = NotationFactory.eINSTANCE.createEdge();
		edge.getStyles().add(NotationFactory.eINSTANCE.createRoutingStyle());
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(PLMVisualIDRegistry.getType(ClassificationEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (edgeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			edgeFontStyle.setFontName(fontData.getName());
			edgeFontStyle.setFontHeight(fontData.getHeight());
			edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore,
					IPreferenceConstants.PREF_FONT_COLOR);
			edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		Node label6016 = createLabel(edge, PLMVisualIDRegistry.getType(WrappingLabel51EditPart.VISUAL_ID));
		label6016.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6016 = (Location) label6016.getLayoutConstraint();
		location6016.setX(10);
		location6016.setY(10);
		Node label6017 = createLabel(edge, PLMVisualIDRegistry.getType(WrappingLabel52EditPart.VISUAL_ID));
		label6017.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6017 = (Location) label6017.getLayoutConstraint();
		location6017.setX(10);
		location6017.setY(10);

		//**********************
		//Custom Code
		//**********************

		//Check if proximity indication is used -> hide classification
		Classification i = (Classification) domainElement;
		if (i.getInstance().getVisualizer().size() > 0) {
			LMLVisualizer v = i.getInstance().getVisualizer().get(0);
			if ("1".equals(v.getValueForKey("ProximityClassification")))
				edge.setVisible(false);
		}

		return edge;
	}

	/**
	* @generated
	*/
	public Edge createSupertype_4034(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Edge edge = NotationFactory.eINSTANCE.createEdge();
		edge.getStyles().add(NotationFactory.eINSTANCE.createRoutingStyle());
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(PLMVisualIDRegistry.getType(SupertypeEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (edgeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			edgeFontStyle.setFontName(fontData.getName());
			edgeFontStyle.setFontHeight(fontData.getHeight());
			edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore,
					IPreferenceConstants.PREF_FONT_COLOR);
			edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		return edge;
	}

	/**
	* @generated
	*/
	public Edge createSubtype_4035(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Edge edge = NotationFactory.eINSTANCE.createEdge();
		edge.getStyles().add(NotationFactory.eINSTANCE.createRoutingStyle());
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(PLMVisualIDRegistry.getType(SubtypeEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (edgeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			edgeFontStyle.setFontName(fontData.getName());
			edgeFontStyle.setFontHeight(fontData.getHeight());
			edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore,
					IPreferenceConstants.PREF_FONT_COLOR);
			edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		return edge;
	}

	/**
	* @generated
	*/
	public Edge createConnectionEnd_4036(EObject domainElement, View containerView, int index, boolean persisted,
			PreferencesHint preferencesHint) {
		Edge edge = NotationFactory.eINSTANCE.createEdge();
		edge.getStyles().add(NotationFactory.eINSTANCE.createRoutingStyle());
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(PLMVisualIDRegistry.getType(ConnectionEndEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (edgeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			edgeFontStyle.setFontName(fontData.getName());
			edgeFontStyle.setFontHeight(fontData.getHeight());
			edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore,
					IPreferenceConstants.PREF_FONT_COLOR);
			edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		Node label6024 = createLabel(edge, PLMVisualIDRegistry.getType(WrappingLabel53EditPart.VISUAL_ID));
		label6024.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6024 = (Location) label6024.getLayoutConstraint();
		location6024.setX(-10);
		location6024.setY(-10);
		Node label6025 = createLabel(edge, PLMVisualIDRegistry.getType(WrappingLabel54EditPart.VISUAL_ID));
		label6025.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6025 = (Location) label6025.getLayoutConstraint();
		location6025.setX(10);
		location6025.setY(10);
		return edge;
	}

	/**
	* @generated
	*/
	private void stampShortcut(View containerView, Node target) {
		if (!DomainEditPart.MODEL_ID.equals(PLMVisualIDRegistry.getModelID(containerView))) {
			EAnnotation shortcutAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			shortcutAnnotation.setSource("Shortcut"); //$NON-NLS-1$
			shortcutAnnotation.getDetails().put("modelID", DomainEditPart.MODEL_ID); //$NON-NLS-1$
			target.getEAnnotations().add(shortcutAnnotation);
		}
	}

	/**
	* @generated
	*/
	private Node createLabel(View owner, String hint) {
		DecorationNode rv = NotationFactory.eINSTANCE.createDecorationNode();
		rv.setType(hint);
		ViewUtil.insertChildView(owner, rv, ViewUtil.APPEND, true);
		return rv;
	}

	/**
	* @generated
	*/
	private Node createCompartment(View owner, String hint, boolean canCollapse, boolean hasTitle, boolean canSort,
			boolean canFilter) {
		//SemanticListCompartment rv = NotationFactory.eINSTANCE.createSemanticListCompartment();
		//rv.setShowTitle(showTitle);
		//rv.setCollapsed(isCollapsed);
		Node rv;
		if (canCollapse) {
			rv = NotationFactory.eINSTANCE.createBasicCompartment();
		} else {
			rv = NotationFactory.eINSTANCE.createDecorationNode();
		}
		if (hasTitle) {
			TitleStyle ts = NotationFactory.eINSTANCE.createTitleStyle();
			ts.setShowTitle(true);
			rv.getStyles().add(ts);
		}
		if (canSort) {
			rv.getStyles().add(NotationFactory.eINSTANCE.createSortingStyle());
		}
		if (canFilter) {
			rv.getStyles().add(NotationFactory.eINSTANCE.createFilteringStyle());
		}
		rv.setType(hint);
		ViewUtil.insertChildView(owner, rv, ViewUtil.APPEND, true);
		return rv;
	}

	/**
	* @generated
	*/
	private EObject getSemanticElement(IAdaptable semanticAdapter) {
		if (semanticAdapter == null) {
			return null;
		}
		EObject eObject = (EObject) semanticAdapter.getAdapter(EObject.class);
		if (eObject != null) {
			return EMFCoreUtil.resolve(TransactionUtil.getEditingDomain(eObject), eObject);
		}
		return null;
	}

	/**
	 * @generated
	 */
	private IElementType getSemanticElementType(IAdaptable semanticAdapter) {
		if (semanticAdapter == null) {
			return null;
		}
		return (IElementType) semanticAdapter.getAdapter(IElementType.class);
	}
}

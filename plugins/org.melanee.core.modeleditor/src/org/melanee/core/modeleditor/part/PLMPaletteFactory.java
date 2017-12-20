
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

import java.util.ArrayList;
import java.util.Collections;

import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.tooling.runtime.part.DefaultLinkToolEntry;
import org.eclipse.gmf.tooling.runtime.part.DefaultNodeToolEntry;
import org.melanee.core.modeleditor.providers.PLMElementTypes;

/**
 * @generated
 */
public class PLMPaletteFactory {

	/**
	* @generated
	*/
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createDeepModelDefinition1Group());
		paletteRoot.add(createDomainDefinition2Group());
		paletteRoot.add(createCorrelationDefinition3Group());
	}

	public static String CREATEDEEPMODELDEFINITION1GROUPID = "createDeepModelDefinition1Group";

	/**
	* Creates "DeepModel Definition" palette tool group
	* @generated
	*/
	private PaletteContainer createDeepModelDefinition1Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(Messages.DeepModelDefinition1Group_title);

		paletteContainer.setId(CREATEDEEPMODELDEFINITION1GROUPID); //$NON-NLS-1$

		paletteContainer.add(createDeepModel1CreationTool());
		paletteContainer.add(createLevel2CreationTool());
		paletteContainer.add(createEnumeration3CreationTool());
		paletteContainer.add(createPackage4CreationTool());
		return paletteContainer;
	}

	public static String CREATEDOMAINDEFINITION2GROUPID = "createDomainDefinition2Group";

	/**
	* Creates "Domain Definition" palette tool group
	* @generated
	*/
	private PaletteContainer createDomainDefinition2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(Messages.DomainDefinition2Group_title);

		paletteContainer.setId(CREATEDOMAINDEFINITION2GROUPID); //$NON-NLS-1$

		paletteContainer.add(createEntity1CreationTool());
		paletteContainer.add(createConnectionRole2CreationTool());
		paletteContainer.add(createAttribute3CreationTool());
		paletteContainer.add(createMethod4CreationTool());
		return paletteContainer;
	}

	public static String CREATECORRELATIONDEFINITION3GROUPID = "createCorrelationDefinition3Group";

	/**
	* Creates "Correlation Definition" palette tool group
	* @generated
	*/
	private PaletteContainer createCorrelationDefinition3Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(Messages.CorrelationDefinition3Group_title);

		paletteContainer.setId(CREATECORRELATIONDEFINITION3GROUPID); //$NON-NLS-1$

		paletteContainer.add(createClassification1CreationTool());
		paletteContainer.add(createInheritance2CreationTool());
		paletteContainer.add(createSuperSubtype3CreationTool());
		paletteContainer.add(createComplement4CreationTool());
		paletteContainer.add(createEqual5CreationTool());
		paletteContainer.add(createInversion6CreationTool());
		return paletteContainer;
	}

	/**
	* @generated
	*/
	private ToolEntry createDeepModel1CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.DeepModel1CreationTool_title,
				Messages.DeepModel1CreationTool_desc, Collections.singletonList(PLMElementTypes.DeepModel_2005));

		entry.setId("createDeepModel1CreationTool"); //$NON-NLS-1$

		entry.setSmallIcon(
				PLMDiagramEditorPlugin.findImageDescriptor("/org.melanee.core.models.gmf/icons/ontology16.gif")); //$NON-NLS-1$
		entry.setLargeIcon(
				PLMDiagramEditorPlugin.findImageDescriptor("/org.melanee.core.models.gmf/icons/ontology16.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createLevel2CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Level2CreationTool_title,
				Messages.Level2CreationTool_desc, Collections.singletonList(PLMElementTypes.Level_3097));

		entry.setId("createLevel2CreationTool"); //$NON-NLS-1$

		entry.setSmallIcon(
				PLMDiagramEditorPlugin.findImageDescriptor("/org.melanee.core.models.gmf/icons/model16.gif")); //$NON-NLS-1$
		entry.setLargeIcon(
				PLMDiagramEditorPlugin.findImageDescriptor("/org.melanee.core.models.gmf/icons/model16.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createEnumeration3CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Enumeration3CreationTool_title,
				Messages.Enumeration3CreationTool_desc, Collections.singletonList(PLMElementTypes.Enumeration_3123));

		entry.setId("createEnumeration3CreationTool"); //$NON-NLS-1$

		entry.setSmallIcon(
				PLMDiagramEditorPlugin.findImageDescriptor("/org.melanee.core.models.gmf/icons/enumeration16.gif")); //$NON-NLS-1$
		entry.setLargeIcon(
				PLMDiagramEditorPlugin.findImageDescriptor("/org.melanee.core.models.gmf/icons/enumeration16.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createPackage4CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(PLMElementTypes.Package_3125);
		types.add(PLMElementTypes.Package_3129);
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Package4CreationTool_title,
				Messages.Package4CreationTool_desc, types);

		entry.setId("createPackage4CreationTool"); //$NON-NLS-1$

		entry.setSmallIcon(PLMElementTypes.getImageDescriptor(PLMElementTypes.Package_3125));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createEntity1CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(3);
		types.add(PLMElementTypes.Entity_3105);
		types.add(PLMElementTypes.Entity_3120);
		types.add(PLMElementTypes.Entity_3126);
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Entity1CreationTool_title,
				Messages.Entity1CreationTool_desc, types);

		entry.setId("createEntity1CreationTool"); //$NON-NLS-1$

		entry.setSmallIcon(
				PLMDiagramEditorPlugin.findImageDescriptor("/org.melanee.core.models.gmf/icons/clabject16.gif")); //$NON-NLS-1$
		entry.setLargeIcon(
				PLMDiagramEditorPlugin.findImageDescriptor("/org.melanee.core.models.gmf/icons/clabject16.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createConnectionRole2CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(Messages.ConnectionRole2CreationTool_title,
				Messages.ConnectionRole2CreationTool_desc,
				Collections.singletonList(PLMElementTypes.ConnectionEnd_4036));

		entry.setId("createConnectionRole2CreationTool"); //$NON-NLS-1$

		entry.setSmallIcon(
				PLMDiagramEditorPlugin.findImageDescriptor("/org.melanee.core.models.gmf/icons/connection16.gif")); //$NON-NLS-1$
		entry.setLargeIcon(
				PLMDiagramEditorPlugin.findImageDescriptor("/org.melanee.core.models.gmf/icons/connection16.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createAttribute3CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(PLMElementTypes.Attribute_3100);
		types.add(PLMElementTypes.Attribute_3106);
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Attribute3CreationTool_title,
				Messages.Attribute3CreationTool_desc, types);

		entry.setId("createAttribute3CreationTool"); //$NON-NLS-1$

		entry.setSmallIcon(
				PLMDiagramEditorPlugin.findImageDescriptor("/org.melanee.core.models.gmf/icons/field16.gif")); //$NON-NLS-1$
		entry.setLargeIcon(
				PLMDiagramEditorPlugin.findImageDescriptor("/org.melanee.core.models.gmf/icons/field16.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createMethod4CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(PLMElementTypes.Method_3102);
		types.add(PLMElementTypes.Method_3108);
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Method4CreationTool_title,
				Messages.Method4CreationTool_desc, types);

		entry.setId("createMethod4CreationTool"); //$NON-NLS-1$

		entry.setSmallIcon(
				PLMDiagramEditorPlugin.findImageDescriptor("/org.melanee.core.models.gmf/icons/method16.gif")); //$NON-NLS-1$
		entry.setLargeIcon(
				PLMDiagramEditorPlugin.findImageDescriptor("/org.melanee.core.models.gmf/icons/method16.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createClassification1CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(Messages.Classification1CreationTool_title,
				Messages.Classification1CreationTool_desc,
				Collections.singletonList(PLMElementTypes.Classification_4026));

		entry.setId("createClassification1CreationTool"); //$NON-NLS-1$

		entry.setSmallIcon(
				PLMDiagramEditorPlugin.findImageDescriptor("/org.melanee.core.models.gmf/icons/classification16.gif")); //$NON-NLS-1$
		entry.setLargeIcon(
				PLMDiagramEditorPlugin.findImageDescriptor("/org.melanee.core.models.gmf/icons/classification16.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createInheritance2CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(3);
		types.add(PLMElementTypes.Inheritance_3124);
		types.add(PLMElementTypes.Inheritance_3122);
		types.add(PLMElementTypes.Inheritance_3128);
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Inheritance2CreationTool_title,
				Messages.Inheritance2CreationTool_desc, types);

		entry.setId("createInheritance2CreationTool"); //$NON-NLS-1$

		entry.setSmallIcon(
				PLMDiagramEditorPlugin.findImageDescriptor("/org.melanee.core.models.gmf/icons/inheritance16.gif")); //$NON-NLS-1$
		entry.setLargeIcon(
				PLMDiagramEditorPlugin.findImageDescriptor("/org.melanee.core.models.gmf/icons/inheritance16.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createSuperSubtype3CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(PLMElementTypes.Supertype_4034);
		types.add(PLMElementTypes.Subtype_4035);
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(Messages.SuperSubtype3CreationTool_title,
				Messages.SuperSubtype3CreationTool_desc, types);

		entry.setId("createSuperSubtype3CreationTool"); //$NON-NLS-1$

		entry.setSmallIcon(
				PLMDiagramEditorPlugin.findImageDescriptor("/org.melanee.core.models.gmf/icons/superType16.gif")); //$NON-NLS-1$
		entry.setLargeIcon(
				PLMDiagramEditorPlugin.findImageDescriptor("/org.melanee.core.models.gmf/icons/superType16.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createComplement4CreationTool() {
		ToolEntry entry = new ToolEntry(Messages.Complement4CreationTool_title, Messages.Complement4CreationTool_desc,
				null, null) {
		};

		entry.setId("createComplement4CreationTool"); //$NON-NLS-1$

		entry.setSmallIcon(
				PLMDiagramEditorPlugin.findImageDescriptor("/org.melanee.core.models.gmf/icons/setRelationship16.gif")); //$NON-NLS-1$
		entry.setLargeIcon(
				PLMDiagramEditorPlugin.findImageDescriptor("/org.melanee.core.models.gmf/icons/setRelationship16.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createEqual5CreationTool() {
		ToolEntry entry = new ToolEntry(Messages.Equal5CreationTool_title, Messages.Equal5CreationTool_desc, null,
				null) {
		};

		entry.setId("createEqual5CreationTool"); //$NON-NLS-1$

		entry.setSmallIcon(
				PLMDiagramEditorPlugin.findImageDescriptor("/org.melanee.core.models.gmf/icons/setRelationship16.gif")); //$NON-NLS-1$
		entry.setLargeIcon(
				PLMDiagramEditorPlugin.findImageDescriptor("/org.melanee.core.models.gmf/icons/setRelationship16.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createInversion6CreationTool() {
		ToolEntry entry = new ToolEntry(Messages.Inversion6CreationTool_title, Messages.Inversion6CreationTool_desc,
				null, null) {
		};

		entry.setId("createInversion6CreationTool"); //$NON-NLS-1$

		entry.setSmallIcon(
				PLMDiagramEditorPlugin.findImageDescriptor("/org.melanee.core.models.gmf/icons/setRelationship16.gif")); //$NON-NLS-1$
		entry.setLargeIcon(
				PLMDiagramEditorPlugin.findImageDescriptor("/org.melanee.core.models.gmf/icons/setRelationship16.gif")); //$NON-NLS-1$
		return entry;
	}

}

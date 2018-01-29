/*******************************************************************************
 * Copyright (c) 2011 - 2015 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Ralph Gerbig - initial API and implementation and initial documentation
 *******************************************************************************/

package org.melanee.core.workbench.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.melanee.core.workbench.Activator;
import org.melanee.core.workbench.ExtensionPointService;

/**
 * This class represents a preference page that
 * is contributed to the Preferences dialog. By 
 * subclassing <samp>FieldEditorPreferencePage</samp>, we
 * can use the field support built into JFace that allows
 * us to create a page that is small and knows how to 
 * save, restore and apply itself.
 * <p>
 * This page is used to modify preferences only. They
 * are stored in the preference store that belongs to
 * the main plug-in class. That way, preferences can
 * be accessed directly via the preference store.
 */

public class MelaneeWorkbenchPreferences
	extends FieldEditorPreferencePage
	implements IWorkbenchPreferencePage {

	public MelaneeWorkbenchPreferences() {
		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("Configuration of the Melanee workbench.");
	}
	
	/**
	 * Creates the field editors. Field editors are abstractions of
	 * the common GUI blocks needed to manipulate various types
	 * of preferences. Each field editor knows how to save and
	 * restore itself.
	 */
	public void createFieldEditors() {
		
		Composite parent = getFieldEditorParent();
		parent.setLayout(new GridLayout(2, false));
		
		
		Group extensionPointGroup = new Group(parent, SWT.SHADOW_IN);
		extensionPointGroup.setText("Available Extensions");
		GridData extensionPointGroupGridData = new GridData(SWT.FILL, SWT.TOP, true, true);
		//extensionPointGroupGridData.horizontalSpan = 2;
		extensionPointGroup.setLayoutData(extensionPointGroupGridData);
		
		//Reasoning Service
		String[] reasoningEngineKeySet = ExtensionPointService.Instance().getId2ReasoningServiceConfigurationElement().keySet().toArray(new String[]{});
		String[][] reasoningEngineIds = new String[reasoningEngineKeySet.length][2];
		
		
		for (int i = 0; i < reasoningEngineKeySet.length; i++)
			reasoningEngineIds[i][0] = reasoningEngineIds[i][1] = reasoningEngineKeySet[i];
		
		if (reasoningEngineIds.length == 0)
			reasoningEngineIds = new String[][]{{"", ""}};
		
		addField(new ComboFieldEditor(
				PreferenceConstants.P_ACTIVE_REASONING_ENGINE,
					"Active Reasoning Engine",
					reasoningEngineIds,
					extensionPointGroup
					)
		);

		
		//Emendation Service
		String[] refactoringEngineKeySet = ExtensionPointService.Instance().getId2EmendationServiceConfigurationElement().keySet().toArray(new String[]{});
		String[][] reafctoringEngineIds = new String[refactoringEngineKeySet.length][2];
		
		for (int i = 0; i < refactoringEngineKeySet.length; i++)
			reafctoringEngineIds[i][0] = reafctoringEngineIds[i][1] = refactoringEngineKeySet[i];
		
		if (reafctoringEngineIds.length == 0)
			reafctoringEngineIds = new String[][]{{"", ""}};
		
		addField(new ComboFieldEditor(
				PreferenceConstants.P_ACTIVE_EMENDATION_ENGINE,
					"Active Emendation Engine",
					reafctoringEngineIds,
					extensionPointGroup
					)
		);
		
		//Emendation Service Activated
		addField(new BooleanFieldEditor(
				PreferenceConstants.P_EMENDATION_ENGINE_ACTIVATED,
				"Emendation Service Activated",
				extensionPointGroup
			)
		);
		
		//DSL Service
		String[] dslEngineKeySet = ExtensionPointService.Instance().getId2DSLServiceConfigurationElement().keySet().toArray(new String[]{});
		String[][] dslEngineIds = new String[dslEngineKeySet.length][2];
		
		for (int i = 0; i < dslEngineKeySet.length; i++)
			dslEngineIds[i][0] = dslEngineIds[i][1] = dslEngineKeySet[i];
		
		if (dslEngineIds.length == 0)
			dslEngineIds = new String[][]{{"", ""}};
		
		addField(new ComboFieldEditor(
				PreferenceConstants.P_ACTIVE_DSL_ENGINE,
					"Active DSL Engine",
					dslEngineIds,
					extensionPointGroup
					)
		);
		
		//Graphical Visualization Service
		String[] graphicalVisualizationEngineKeySet = ExtensionPointService.Instance().getId2GraphicalVisualizationServiceConfigurationElement().keySet().toArray(new String[]{});
		String[][] graphicalVisualizationEngineIds = new String[graphicalVisualizationEngineKeySet.length][2];
		
		for (int i = 0; i < graphicalVisualizationEngineKeySet.length; i++)
			graphicalVisualizationEngineIds[i][0] = graphicalVisualizationEngineIds[i][1] = graphicalVisualizationEngineKeySet[i];
		
		if (graphicalVisualizationEngineIds.length == 0)
			graphicalVisualizationEngineIds = new String[][]{{"", ""}};
		
		addField(new ComboFieldEditor(
				PreferenceConstants.P_ACTIVE_GRAPHICAL_VISUALIZATION_ENGINE,
					"Active Graphical Visualization Engine",
					graphicalVisualizationEngineIds,
					extensionPointGroup
					)
		);
		
		//Textual Visualization Service
		String[] textualVisualizationEngineKeySet = ExtensionPointService.Instance().getId2TextualVisualizationServiceConfigurationElement().keySet().toArray(new String[]{});
		String[][] textualVisualizationEngineIds = new String[textualVisualizationEngineKeySet.length][2];
		
		for (int i = 0; i < textualVisualizationEngineKeySet.length; i++)
			textualVisualizationEngineIds[i][0] = textualVisualizationEngineIds[i][1] = textualVisualizationEngineKeySet[i];
		
		if (textualVisualizationEngineIds.length == 0)
			textualVisualizationEngineIds = new String[][]{{"", ""}};
		
		addField(new ComboFieldEditor(
				PreferenceConstants.P_ACTIVE_TEXTUAL_VISUALIZATION_ENGINE,
					"Active Textual Visualization Engine",
					textualVisualizationEngineIds,
					extensionPointGroup
					)
		);
		
		//Form Visualization Service
		String[] formVisualizationEngineKeySet = ExtensionPointService.Instance().getId2FormVisualizationServiceConfigurationElement().keySet().toArray(new String[]{});
		String[][] formVisualizationEngineIds = new String[formVisualizationEngineKeySet.length][2];
		
		for (int i = 0; i < formVisualizationEngineKeySet.length; i++)
			formVisualizationEngineIds[i][0] = formVisualizationEngineIds[i][1] = formVisualizationEngineKeySet[i];
		
		if (formVisualizationEngineIds.length == 0)
			formVisualizationEngineIds = new String[][]{{"", ""}};
		
		addField(new ComboFieldEditor(
				PreferenceConstants.P_ACTIVE_FORM_VISUALIZATION_ENGINE,
					"Active Form Visualization Engine",
					formVisualizationEngineIds,
					extensionPointGroup
					)
		);
		
		//Table Visualization Service
		String[] tableVisualizationEngineKeySet = ExtensionPointService.Instance().getId2TableVisualizationServiceConfigurationElement().keySet().toArray(new String[]{});
		String[][] tableVisualizationEngineIds = new String[tableVisualizationEngineKeySet.length][2];
		
		for (int i = 0; i < tableVisualizationEngineKeySet.length; i++)
			tableVisualizationEngineIds[i][0] = tableVisualizationEngineIds[i][1] = tableVisualizationEngineKeySet[i];
		
		if (tableVisualizationEngineIds.length == 0)
			tableVisualizationEngineIds = new String[][]{{"", ""}};
		
		addField(new ComboFieldEditor(
				PreferenceConstants.P_ACTIVE_TABLE_VISUALIZATION_ENGINE,
					"Active Table Visualization Engine",
					tableVisualizationEngineIds,
					extensionPointGroup
					)
		);
		
		//Application Visualization Service
		String[] applicationVisualizationEngineKeySet = ExtensionPointService.Instance().getId2ApplicationVisualizationServiceConfigurationElement().keySet().toArray(new String[]{});
		String[][] applicationVisualizationEngineIds = new String[applicationVisualizationEngineKeySet.length][2];
		
		for (int i = 0; i < applicationVisualizationEngineKeySet.length; i++)
			applicationVisualizationEngineIds[i][0] = applicationVisualizationEngineIds[i][1] = applicationVisualizationEngineKeySet[i];
		
		if (applicationVisualizationEngineIds.length == 0)
			applicationVisualizationEngineIds = new String[][]{{"", ""}};
		
		addField(new ComboFieldEditor(
				PreferenceConstants.P_ACTIVE_APPLICATION_VISUALIZATION_ENGINE,
					"Active Application Visualization Engine",
					applicationVisualizationEngineIds,
					extensionPointGroup
					)
		);
		
		//Proximity Indication Service
		String[] proximityIndicationEngineKeySet = ExtensionPointService.Instance().getId2DesignationServiceConfigurationElement().keySet().toArray(new String[]{});
		String[][] proximityIndicationEngineIds = new String[proximityIndicationEngineKeySet.length][2];
		
		for (int i = 0; i < proximityIndicationEngineKeySet.length; i++)
			proximityIndicationEngineIds[i][0] = proximityIndicationEngineIds[i][1] = proximityIndicationEngineKeySet[i];
		
		if (proximityIndicationEngineIds.length == 0)
			proximityIndicationEngineIds = new String[][]{{"", ""}};
		
		addField(new ComboFieldEditor(
				PreferenceConstants.P_ACTIVE_DESIGNATION_SERVICE,
					"Active Proximity Indication Engine",
					proximityIndicationEngineIds,
					extensionPointGroup
					)
		);
		
		//Validation Service
		String[] validationEngineKeySet = ExtensionPointService.Instance().getId2ValidationServiceConfigurationElement().keySet().toArray(new String[]{});
		String[][] validationServiceIds = new String[validationEngineKeySet.length][2];
		
		for (int i = 0; i < validationEngineKeySet.length; i++)
			validationServiceIds[i][0] = validationServiceIds[i][1] = validationEngineKeySet[i];
		
		if (validationServiceIds.length == 0)
			validationServiceIds = new String[][]{{"", ""}};
		
		addField(new ComboFieldEditor(
				PreferenceConstants.P_ACTIVE_VALIDATION_SERVICE,
					"Active Validation Service",
					validationServiceIds,
					extensionPointGroup
					)
		);
		
		//Constraint Language Service
		String[] constraintLanguageEngineKeySet = ExtensionPointService.Instance().getId2ContraintLanguageServiceConfigurationElement().keySet().toArray(new String[]{});
		String[][] constraintLanguageServiceIds = new String[constraintLanguageEngineKeySet.length][2];
		
		for (int i = 0; i < constraintLanguageEngineKeySet.length; i++)
			constraintLanguageServiceIds[i][0] = constraintLanguageServiceIds[i][1] = constraintLanguageEngineKeySet[i];
		
		if (constraintLanguageServiceIds.length == 0)
			constraintLanguageServiceIds = new String[][]{{"", ""}};
		
		addField(new ComboFieldEditor(
				PreferenceConstants.P_ACTIVE_CONSTRAINT_LANGUAGE_SERVICE,
					"Active Constraint Language Service",
					constraintLanguageServiceIds,
					extensionPointGroup
					)
		);
		
		Label warningLabel = new Label(extensionPointGroup, SWT.NONE);
		warningLabel.setText(" After changing active extensions, it can be required to reset the Melanee perspective.");
		warningLabel.setForeground(getFieldEditorParent().getDisplay().getSystemColor(SWT.COLOR_RED));
		GridData warningLabelGridData = new GridData(SWT.LEFT, SWT.CENTER, true, true);
		warningLabelGridData.horizontalSpan = 2;
		warningLabel.setLayoutData(warningLabelGridData);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
	}
	
}
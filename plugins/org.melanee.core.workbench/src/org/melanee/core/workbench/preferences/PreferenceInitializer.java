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

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.melanee.core.workbench.Activator;

/**
 * Class used to initialize default preference values.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		store.setDefault(PreferenceConstants.P_ACTIVE_REASONING_ENGINE, "org.melanee.reasoning.service");
		store.setDefault(PreferenceConstants.P_ACTIVE_EMENDATION_ENGINE, "org.melanee.core.emendation.service");
		store.setDefault(PreferenceConstants.P_EMENDATION_ENGINE_ACTIVATED, true);
		store.setDefault(PreferenceConstants.P_ACTIVE_GRAPHICAL_VISUALIZATION_ENGINE, "org.melanee.graphdsl.service");
		store.setDefault(PreferenceConstants.P_ACTIVE_APPLICATION_VISUALIZATION_ENGINE, "org.melanee.appdsl.service");
		store.setDefault(PreferenceConstants.P_ACTIVE_TEXTUAL_VISUALIZATION_ENGINE, "org.melanee.textdsl.service");
		store.setDefault(PreferenceConstants.P_ACTIVE_DESIGNATION_SERVICE, "org.melanee.core.designation.service");
		store.setDefault(PreferenceConstants.P_ACTIVE_DSL_ENGINE, "org.melanee.core.dsl.service");
		store.setDefault(PreferenceConstants.P_ACTIVE_VALIDATION_SERVICE, "org.melanee.validation.service");
		store.setDefault(PreferenceConstants.P_ACTIVE_CONSTRAINT_LANGUAGE_SERVICE, "org.melanee.ocl.service");
		store.setDefault(PreferenceConstants.P_ACTIVE_FORM_VISUALIZATION_ENGINE, "org.melanee.formdsl.service");
		store.setDefault(PreferenceConstants.P_ACTIVE_TABLE_VISUALIZATION_ENGINE, "org.melanee.tabledsl.service");
	}

}

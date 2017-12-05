/*
 * *******************************************************************************
 * Copyright (c) 2011 - 2015 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      - initial API and implementation and initial documentation
 * *******************************************************************************
 */
package org.melanee.core.modeleditor.preferences;

import org.eclipse.gmf.runtime.diagram.ui.preferences.ConnectionsPreferencePage;
import org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants;
import org.eclipse.gmf.runtime.notation.Routing;
import org.eclipse.jface.preference.IPreferenceStore;
import org.melanee.core.modeleditor.part.PLMDiagramEditorPlugin;

/**
 * @generated
 */
public class DiagramConnectionsPreferencePage extends ConnectionsPreferencePage {

	/**
	* @generated
	*/
	public DiagramConnectionsPreferencePage() {
		setPreferenceStore(PLMDiagramEditorPlugin.getInstance().getPreferenceStore());
	}

	/**
	* Initializes the default preference values for this preference store.
	* 
	* @param preferenceStore
	*            the preference store
	* @generated
	*/
	public static void initDefaults(IPreferenceStore preferenceStore) {
		preferenceStore.setDefault(IPreferenceConstants.PREF_LINE_STYLE, Routing.RECTILINEAR);
		preferenceStore.setDefault(IPreferenceConstants.PREF_SNAP_TO_GRID, false);
		preferenceStore.setDefault(IPreferenceConstants.PREF_SNAP_TO_GEOMETRY, true);
	}

}

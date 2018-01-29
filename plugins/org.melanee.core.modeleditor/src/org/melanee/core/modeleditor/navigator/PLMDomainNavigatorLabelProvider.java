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

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;
import org.melanee.core.modeleditor.part.PLMDiagramEditorPlugin;

/**
 * @generated
 */
public class PLMDomainNavigatorLabelProvider implements ICommonLabelProvider {

	/**
	* @generated
	*/
	private AdapterFactoryLabelProvider myAdapterFactoryLabelProvider = new AdapterFactoryLabelProvider(
			PLMDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());

	/**
	* @generated
	*/
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	* @generated
	*/
	public Image getImage(Object element) {
		if (element instanceof PLMDomainNavigatorItem) {
			return myAdapterFactoryLabelProvider.getImage(((PLMDomainNavigatorItem) element).getEObject());
		}
		return null;
	}

	/**
	* @generated
	*/
	public String getText(Object element) {
		if (element instanceof PLMDomainNavigatorItem) {
			return myAdapterFactoryLabelProvider.getText(((PLMDomainNavigatorItem) element).getEObject());
		}
		return null;
	}

	/**
	* @generated
	*/
	public void addListener(ILabelProviderListener listener) {
		myAdapterFactoryLabelProvider.addListener(listener);
	}

	/**
	* @generated
	*/
	public void dispose() {
		myAdapterFactoryLabelProvider.dispose();
	}

	/**
	* @generated
	*/
	public boolean isLabelProperty(Object element, String property) {
		return myAdapterFactoryLabelProvider.isLabelProperty(element, property);
	}

	/**
	* @generated
	*/
	public void removeListener(ILabelProviderListener listener) {
		myAdapterFactoryLabelProvider.removeListener(listener);
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

}


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
package org.melanee.core.modeleditor.sheet;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.gmf.tooling.runtime.sheet.DefaultPropertySection;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.IPropertySourceProvider;
import org.melanee.core.modeleditor.custom.propertysheet.PropertySourceExtension;

/**
 * @generated
 */
public class PLMPropertySection extends DefaultPropertySection implements IPropertySourceProvider {

	/**
	* @generated
	*/
	public IPropertySource getPropertySource(Object object) {
		if (object instanceof IPropertySource) {
			return (IPropertySource) object;
		}
		AdapterFactory af = getAdapterFactory(object);
		if (af != null) {
			IItemPropertySource ips = (IItemPropertySource) af.adapt(object, IItemPropertySource.class);
			if (ips != null) {
				//*****************************************
				// Modified to fix emendation service.
				// On focus lost no transaction is started.
				//*****************************************
				return new PropertySourceExtension(object, ips);
			}
		}
		if (object instanceof IAdaptable) {
			return (IPropertySource) ((IAdaptable) object).getAdapter(IPropertySource.class);
		}
		return null;
	}

	/**
	* Modify/unwrap selection.
	* @generated
	*/
	@Override
	protected Object transformSelection(Object selected) {
		selected = /*super.*/transformSelectionToDomain(selected);
		return selected;
	}

}

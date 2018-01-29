/*******************************************************************************
 * Copyright (c) 2016 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Ralph Gerbig - initial API and implementation and initial documentation
 *******************************************************************************/
package org.melanee.core.modeleditor.custom.propertysheet;

import org.eclipse.core.runtime.CoreException;
import org.melanee.core.workbench.ExtensionPointService;
import org.melanee.core.workbench.interfaces.IApplicationVisualizationService;

public class ConstraintPropertiesSectionFilter extends AbstractPropertiesSectionFilter{

	@Override
	public boolean select(Object toTest) {
		IApplicationVisualizationService service = null;
		
		try {
			service = ExtensionPointService.Instance().getActiveApplicationVisualizationService();
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
		if (service != null)
			return super.select(toTest) && service.getFilterForConstraintProperties().select(toTest);
		
		return super.select(toTest);
	}

}

/*******************************************************************************
 * Copyright (c) 2011 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     - initial API and implementation and initial documentation
 *******************************************************************************/
package org.melanee.core.workbench.commandparameterconverter;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.AbstractParameterValueConverter;
import org.eclipse.core.commands.ParameterValueConversionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMLResource;


public class EObjectCommandParameterConverter extends
		AbstractParameterValueConverter {

	/**
	 * Saves a mapping from emf-id to the EObject.
	 */
	Map<String, EObject> emfId2Resource = new HashMap<String, EObject>();
	
	public EObjectCommandParameterConverter() {
	}

	@Override
	public Object convertToObject(String parameterValue)
			throws ParameterValueConversionException {
		return emfId2Resource.get(parameterValue);
	}

	@Override
	public String convertToString(Object parameterValue)
			throws ParameterValueConversionException {
		
		//Changed to remove dependency to GMF
		String id = ((XMLResource)((EObject)parameterValue).eResource()).getID((EObject)parameterValue);
		emfId2Resource.put(id, (EObject)parameterValue);
		return id;
		
//		emfId2Resource.put(EMFCoreUtil.getProxyID((EObject)parameterValue), (EObject)parameterValue);
//		return EMFCoreUtil.getProxyID((EObject)parameterValue);
	}

}

/*******************************************************************************
 * Copyright (c) 2013 - 2017 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Ralph Gerbig - initial API and implementation and initial documentation
 *******************************************************************************/
package org.melanee.core.emf;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ParserException;
import org.melanee.core.common.emf.ocl.OCLHelper;

public class EMFReflectionHelper {
	
	public static Object executeOperation(EObject context, String name) throws InvocationTargetException, ParserException{
		EOperation opration = (EOperation)OCLHelper.execute(context.eClass(), "self.eAllOperations->select(o | o.name = '" + name + "')->first()");
		return context.eInvoke(opration, new BasicEList());
	}
	
	public static Object getFeature(EObject context, String name) throws ParserException{
		EStructuralFeature feature = (EStructuralFeature)OCLHelper.execute(context.eClass(), "self.eAllStructuralFeatures->select(o | o.name = '" + name + "')->first()");
		return context.eGet(feature);
	}
}

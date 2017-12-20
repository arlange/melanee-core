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
package org.melanee.core.helpers;

import java.util.Arrays;
import java.util.List;

import org.melanee.core.models.plm.PLM.Attribute;

public class AttributeHelper {

	/**
	 * Converts the value trait of a model element to its java version
	 * based on the datatype.
	 * 
	 * @param attribute attribute to convert the value of
	 * @return A converted value. String if no conversion is possible
	 */
	public static Object convert(Attribute attribute){
		return getValueConverted(attribute, false);
	}
	
	/**
	 * Converts the value trait of a model element to its java version
	 * based on the datatype. If no datatype is set the vaiue datatype
	 * can be infered.
	 * 
	 * @param attribute attribute attribute to convert the value of 
	 * @param inferDatatype infer the datatype if not set
	 * @return A converted value. String if no conversion is possible
	 */
	public static Object getValueConverted(Attribute attribute, boolean inferDatatype){
		if(inferDatatype)
			throw new UnsupportedOperationException("Datatype inference not implemented at the moment");
		
		if (attribute.getValue() == null)
			return null;
		
		List<String> primitiveDataTypes = attribute.getPrimitiveDataTypes();

		if(!(primitiveDataTypes.contains("String")
				|| primitiveDataTypes.contains("Real")
				|| primitiveDataTypes.contains("Integer")
				|| primitiveDataTypes.contains("Natural")
				|| primitiveDataTypes.contains("Boolean")
				|| primitiveDataTypes.contains("Percent")
				|| primitiveDataTypes.contains("Probability")
				|| primitiveDataTypes.contains("Money")))
			throw new RuntimeException("Datatypes in factory not in synch with annotation in models");
		
		List<String> numericDatatypes = Arrays.asList("Integer", "Natural", "Percent");
		List<String> floatingNumberDatatypes = Arrays.asList("Real", "Probability", "Money");
		
		try{
			if(numericDatatypes.contains(attribute.getDatatype()))
				return Integer.parseInt(attribute.getValue());
			else if(floatingNumberDatatypes.contains(attribute.getDatatype()))
				return Double.parseDouble(attribute.getValue());
			else if("String".equals(attribute.getDatatype()))
				attribute.getValue();
			else if("Boolean".equals(attribute.getDatatype()))
				Boolean.parseBoolean(attribute.getValue());
		}catch(Exception e){
			//Do nothing
		}
		
		return attribute.getValue();
	}
	
}

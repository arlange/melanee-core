/*******************************************************************************
 * Copyright (c) 2011-2015 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Ralph Gerbig - initial API and implementation and initial documentation
 *******************************************************************************/
package org.melanee.core.models.plm.PLM;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.melanee.core.models.plm.PLM.PLMPackage#getEntity()
 * @model
 * @generated
 */
public interface Entity extends Clabject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * returns a human readable string representation. The algorithm works as follows:
	 * 
	 * <ol>
	 * 	<li>value of attribute called name</li>
	 * 	<li>value of the first attribute  containing name in its name</li>
	 * 	<li>value of attribute called id</li>
	 * 	<li>value of the first attribute  containing id in its name</li>
	 * 	<li>value of the first attribute of type String</li>
	 * </ol>
	 * <!-- end-model-doc -->
	 * @model required="true" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='--First option is to use the name attribute\r\nlet nameAttribute:Attribute = self.getDefinedAttributes()->select(name = \'name\')->first()\r\nin\r\n--Second option is to use a name containing attribute\r\nlet nameContainingAttribute:Attribute = self.getDefinedAttributes()->select(name.toLower().matches(\'.*name.*\'))->first()\r\nin\r\n--Third option is the id attribute\r\nlet id:Attribute = self.getDefinedAttributes()->select(name = \'id\')->any(true)\r\nin\r\n--Fourth option is to use an id containing attribute\r\nlet idContainingAttribute:Attribute = self.getDefinedAttributes()->select(name.toLower().matches(\'.*id.*\'))->first()\r\nin\r\n--Last option is to use the first String attribute\r\nlet stringAttribute:Attribute = self.getDefinedAttributes()->select(name.toLower().matches(\'.*string.*\'))->first()\r\nin\r\nif (not nameAttribute.oclIsUndefined() and not nameAttribute.value.oclIsUndefined()) then\r\n\tnameAttribute.value\r\nelse\r\n\tif(not nameContainingAttribute.oclIsUndefined() and not nameContainingAttribute.value.oclIsUndefined()) then\r\n\t\tnameContainingAttribute.value\r\n\telse\r\n\t\tif(not id.oclIsUndefined() and not id.value.oclIsUndefined()) then\r\n\t\t\tid.value\r\n\t\telse\r\n\t\t\tif(not idContainingAttribute.oclIsUndefined() and not idContainingAttribute.value.oclIsUndefined()) then\r\n\t\t\t\tidContainingAttribute.value\r\n\t\t\telse\r\n\t\t\t\tif(not stringAttribute.oclIsUndefined() and not stringAttribute.value.oclIsUndefined()) then\r\n\t\t\t\t\tstringAttribute.value\r\n\t\t\t\telse\r\n\t\t\t\t\t--Linguistic name as backup\r\n\t\t\t\t\tif(not name.oclIsUndefined()) then\r\n\t\t\t\t\t\tname\r\n\t\t\t\t\telse\r\n\t\t\t\t\t\t\'\'\r\n\t\t\t\t\tendif\r\n\t\t\t\tendif\r\n\t\t\tendif\r\n\t\tendif\r\n\tendif\r\nendif'"
	 * @generated
	 */
	String represent();

} // Entity

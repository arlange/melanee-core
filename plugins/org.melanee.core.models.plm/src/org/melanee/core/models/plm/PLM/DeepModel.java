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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Deep Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.melanee.core.models.plm.PLM.DeepModel#getContent <em>Content</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.DeepModel#getEnumeration <em>Enumeration</em>}</li>
 * </ul>
 *
 * @see org.melanee.core.models.plm.PLM.PLMPackage#getDeepModel()
 * @model
 * @generated
 */
public interface DeepModel extends Element {
	/**
	 * Returns the value of the '<em><b>Content</b></em>' containment reference list.
	 * The list contents are of type {@link org.melanee.core.models.plm.PLM.Level}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content</em>' containment reference list.
	 * @see org.melanee.core.models.plm.PLM.PLMPackage#getDeepModel_Content()
	 * @model containment="true"
	 * @generated
	 */
	EList<Level> getContent();

	/**
	 * Returns the value of the '<em><b>Enumeration</b></em>' containment reference list.
	 * The list contents are of type {@link org.melanee.core.models.plm.PLM.Enumeration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enumeration</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enumeration</em>' containment reference list.
	 * @see org.melanee.core.models.plm.PLM.PLMPackage#getDeepModel_Enumeration()
	 * @model containment="true"
	 * @generated
	 */
	EList<Enumeration> getEnumeration();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * returns the model identified by the level
	 * <!-- end-model-doc -->
	 * @model ordered="false" levelRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='if level > 0 and level <= self.content->size() then\r\n\tself.content->at(level)\r\nelse\r\n\tnull\r\nendif'"
	 * @generated
	 */
	Level getLevelAtIndex(int level);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * returns all primitive datatypes
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.oclAsType(ecore::EObject).eClass().ePackage.getEAnnotation(\'http://melanee.org/PLM/Datatypes\').details.key->asOrderedSet()'"
	 * @generated
	 */
	EList<String> getPrimitiveDatatypes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * returns all primitive datatypes
	 * <!-- end-model-doc -->
	 * @model required="true" typeRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='if (self.oclAsType(ecore::EObject).eClass().ePackage.getEAnnotation(\'http://melanee.org/PLM/Datatypes\').details->select(e | e.key = type)->size() = 1) then\r\n\tself.oclAsType(ecore::EObject).eClass().ePackage.getEAnnotation(\'http://melanee.org/PLM/Datatypes\').details->select(e | e.key = type).value->first()\r\nelse\r\n\tnull\r\nendif'"
	 * @generated
	 */
	String getRegexForPrimitiveDatatype(String type);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * returns all primitive datatypes and enumeration
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.getPrimitiveDatatypes()->asSequence()->union(self.enumeration.name)->asOrderedSet()'"
	 * @generated
	 */
	EList<String> getAllDatatypes();

} // DeepModel

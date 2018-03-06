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
 * <!-- begin-user-doc --> A representation of the model object
 * '<em><b>Attribute</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.melanee.core.models.plm.PLM.Attribute#getValue
 * <em>Value</em>}</li>
 * <li>{@link org.melanee.core.models.plm.PLM.Attribute#getMutability
 * <em>Mutability</em>}</li>
 * <li>{@link org.melanee.core.models.plm.PLM.Attribute#getDatatype
 * <em>Datatype</em>}</li>
 * </ul>
 *
 * @see org.melanee.core.models.plm.PLM.PLMPackage#getAttribute()
 * @model
 * @generated
 */
public interface Attribute extends Feature, Property {
  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute. <!--
   * begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear, there really
   * should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * 
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(String)
   * @see org.melanee.core.models.plm.PLM.PLMPackage#getAttribute_Value()
   * @model
   * @generated
   */
  String getValue();

  /**
   * Sets the value of the
   * '{@link org.melanee.core.models.plm.PLM.Attribute#getValue <em>Value</em>}'
   * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @param value
   *          the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(String value);

  /**
   * Returns the value of the '<em><b>Mutability</b></em>' attribute. <!--
   * begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mutability</em>' attribute isn't clear, there
   * really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * 
   * @return the value of the '<em>Mutability</em>' attribute.
   * @see #setMutability(int)
   * @see org.melanee.core.models.plm.PLM.PLMPackage#getAttribute_Mutability()
   * @model
   * @generated
   */
  int getMutability();

  /**
   * Sets the value of the
   * '{@link org.melanee.core.models.plm.PLM.Attribute#getMutability
   * <em>Mutability</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   * 
   * @param value
   *          the new value of the '<em>Mutability</em>' attribute.
   * @see #getMutability()
   * @generated
   */
  void setMutability(int value);

  /**
   * Returns the value of the '<em><b>Datatype</b></em>' attribute. <!--
   * begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Datatype</em>' attribute isn't clear, there really
   * should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * 
   * @return the value of the '<em>Datatype</em>' attribute.
   * @see #setDatatype(String)
   * @see org.melanee.core.models.plm.PLM.PLMPackage#getAttribute_Datatype()
   * @model
   * @generated
   */
  String getDatatype();

  /**
   * Sets the value of the
   * '{@link org.melanee.core.models.plm.PLM.Attribute#getDatatype
   * <em>Datatype</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @param value
   *          the new value of the '<em>Datatype</em>' attribute.
   * @see #getDatatype()
   * @generated
   */
  void setDatatype(String value);

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns a human readable string representation <!-- end-model-doc -->
   * 
   * @model kind="operation" required="true" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='if
   *        (self.mutability > 0) then OrderedSet{1000000, 10000, 1000, 100, 10,
   *        1}->iterate(\r\n\tdenominator : Integer;\ts : String =
   *        \'\'|\r\n\t\tlet numberAsString : String =
   *        \r\n\t\t\tOrderedSet{\'0\',\'1\',\'2\',\'3\',\'4\',\'5\',\'6\',\'7\',\'8\',\'9\'}->at(self.mutability.div(denominator).mod(10)
   *        + 1)\r\n\t\tin\r\n\t\tif s=\'\' and numberAsString = \'0\'
   *        then\r\n\t\t\ts\r\n\t\telse\r\n\t\t\ts.concat(numberAsString)\r\n\t\tendif\r\n\t)\r\nelse\r\n\tif
   *        (self.mutability = 0)
   *        then\r\n\t\t\'0\'\r\n\telse\r\n\t\t\'*\'\r\n\tendif\r\nendif\r\n\r\n'"
   * @generated
   */
  String getMutabilityAsString();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns a human readable string representation <!-- end-model-doc -->
   * 
   * @model required="true" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='if
   *        self.datatype.oclIsUndefined() or self.datatype = \'\'
   *        then\r\n\tself.name\r\nelse\r\n\tself.name.concat(\'[\').concat(self.datatype).concat(\']\')\r\nendif'"
   * @generated
   */
  String represent();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns all possible datatypes <!-- end-model-doc -->
   * 
   * @model kind="operation" required="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='self.getPrimitiveDataTypes()->union(self.getEnumerationDataTypes())->asOrderedSet()'"
   * @generated
   */
  EList<String> getPossibleDataTypes();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns all possible datatypes <!-- end-model-doc -->
   * 
   * @model kind="operation" required="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='self.oclAsType(ecore::EObject).eClass().ePackage.getEAnnotation(\'http://melanee.org/PLM/Datatypes\').details.key->asOrderedSet()'"
   * @generated
   */
  EList<String> getPrimitiveDataTypes();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns all possible datatypes <!-- end-model-doc -->
   * 
   * @model kind="operation" required="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='self.getClabject().getDeepModel().enumeration.name->asOrderedSet()'"
   * @generated
   */
  EList<String> getEnumerationDataTypes();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns all possible datatypes <!-- end-model-doc -->
   * 
   * @model kind="operation" required="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='getEnumerationDataTypes()->includes(datatype)'"
   * @generated
   */
  boolean isEnumeration();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns all possible datatypes <!-- end-model-doc -->
   * 
   * @model kind="operation" required="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='--Check if
   *        the attribute is an enumeration\r\nif (isEnumeration())
   *        then\r\n\tself.getClabject().getDeepModel().enumeration->select(name =
   *        datatype)->any(true)\r\nelse\r\n\tnull\r\nendif'"
   * @generated
   */
  Enumeration getEnumeration();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns all possible datatypes <!-- end-model-doc -->
   * 
   * @model kind="operation" required="true"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='getEnumeration().literal->asOrderedSet()'"
   * @generated
   */
  EList<String> getLiterals();

} // Attribute

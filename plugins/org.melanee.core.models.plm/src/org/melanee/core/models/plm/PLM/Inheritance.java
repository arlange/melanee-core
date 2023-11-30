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
 * '<em><b>Inheritance</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.melanee.core.models.plm.PLM.Inheritance#getSupertype <em>Supertype</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.Inheritance#getSubtype <em>Subtype</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.Inheritance#getDisjoint <em>Disjoint</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.Inheritance#getComplete <em>Complete</em>}</li>
 * </ul>
 *
 * @see org.melanee.core.models.plm.PLM.PLMPackage#getInheritance()
 * @model
 * @generated
 */
public interface Inheritance extends Correlation {
  /**
   * Returns the value of the '<em><b>Supertype</b></em>' containment reference list.
   * The list contents are of type {@link org.melanee.core.models.plm.PLM.Supertype}.
   * It is bidirectional and its opposite is '{@link org.melanee.core.models.plm.PLM.Supertype#getInheritance <em>Inheritance</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Supertype</em>' containment reference list isn't
   * clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Supertype</em>' containment reference list.
   * @see org.melanee.core.models.plm.PLM.PLMPackage#getInheritance_Supertype()
   * @see org.melanee.core.models.plm.PLM.Supertype#getInheritance
   * @model opposite="inheritance" containment="true" required="true"
   * @generated
   */
  EList<Supertype> getSupertype();

  /**
   * Returns the value of the '<em><b>Subtype</b></em>' containment reference list.
   * The list contents are of type {@link org.melanee.core.models.plm.PLM.Subtype}.
   * It is bidirectional and its opposite is '{@link org.melanee.core.models.plm.PLM.Subtype#getInheritance <em>Inheritance</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Subtype</em>' containment reference list isn't
   * clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Subtype</em>' containment reference list.
   * @see org.melanee.core.models.plm.PLM.PLMPackage#getInheritance_Subtype()
   * @see org.melanee.core.models.plm.PLM.Subtype#getInheritance
   * @model opposite="inheritance" containment="true" required="true"
   * @generated
   */
  EList<Subtype> getSubtype();

  /**
   * Returns the value of the '<em><b>Disjoint</b></em>' attribute. <!--
   * begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Disjoint</em>' attribute isn't clear, there really
   * should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * 
   * @return the value of the '<em>Disjoint</em>' attribute.
   * @see #setDisjoint(Boolean)
   * @see org.melanee.core.models.plm.PLM.PLMPackage#getInheritance_Disjoint()
   * @model
   * @generated
   */
  Boolean getDisjoint();

  /**
   * Sets the value of the '{@link org.melanee.core.models.plm.PLM.Inheritance#getDisjoint <em>Disjoint</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Disjoint</em>' attribute.
   * @see #getDisjoint()
   * @generated
   */
  void setDisjoint(Boolean value);

  /**
   * Returns the value of the '<em><b>Complete</b></em>' attribute. <!--
   * begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Complete</em>' attribute isn't clear, there really
   * should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * 
   * @return the value of the '<em>Complete</em>' attribute.
   * @see #setComplete(Boolean)
   * @see org.melanee.core.models.plm.PLM.PLMPackage#getInheritance_Complete()
   * @model
   * @generated
   */
  Boolean getComplete();

  /**
   * Sets the value of the '{@link org.melanee.core.models.plm.PLM.Inheritance#getComplete <em>Complete</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Complete</em>' attribute.
   * @see #getComplete()
   * @generated
   */
  void setComplete(Boolean value);

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns true if the generalization is disjoint, false otherwise <!--
   * end-model-doc -->
   * 
   * @model kind="operation" required="true" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='not
   *        (self.disjoint.oclIsUndefined() or self.disjoint = false)'"
   * @generated
   */
  boolean isDisjoint();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns true if the generalization is complete, false otherwise <!--
   * end-model-doc -->
   * 
   * @model kind="operation" required="true" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='not
   *        (self.complete.oclIsUndefined() or self.complete = false)'"
   * @generated
   */
  boolean isComplete();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns true if the generalization is an intersection, false otherwise <!--
   * end-model-doc -->
   * 
   * @model kind="operation" required="true" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='not
   *        (self.intersection.oclIsUndefined() or self.intersection = false)'"
   * @generated
   */
  boolean isIntersection();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
   * returns a human readable string representation of the generalization. If the
   * name is set, the name is returned. It the name is not set, a meaningful
   * string is constructed from the defined inheritance. <!-- end-model-doc -->
   * 
   * @model required="true" ordered="false"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='if
   *        self.name.oclIsUndefined() or self.name = \'\' then\r\n\r\nlet superT
   *        : String = self.supertype->iterate(s:Clabject; res:String=\'\'|
   *        \r\n\t\tres.concat(s.represent()).concat(\',\')\r\n\t)
   *        \r\nin\r\n\r\nlet subT : String = self.subtype->iterate(s:Clabject;
   *        res:String=\'\'|
   *        \r\n\t\tres.concat(s.represent()).concat(\',\')\r\n\t)\r\nin\r\n\'[\'.concat(superT.substring(1,superT.size()-1))\r\n.concat(\']<-[\').concat(subT.substring(1,subT.size()-1)).concat(\']\')\r\n\r\nelse
   *        \r\n\tself.name\r\nendif'"
   * @generated
   */
  String represent();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * resturns the list of all the supertypes of the Inheritance
   * <!-- end-model-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.supertype.supertype-&gt;asOrderedSet()\n'"
   * @generated
   */
  EList<Clabject> getSupertypes();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * returns the list of all subtypes of the Inheritance
   * <!-- end-model-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='self.subtype.subtype-&gt;asOrderedSet()\n'"
   * @generated
   */
  EList<Clabject> getSubtypes();

} // Inheritance

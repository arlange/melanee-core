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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object
 * '<em><b>Subtype</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.melanee.core.models.plm.PLM.Subtype#getSubtype <em>Subtype</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.Subtype#getInheritance <em>Inheritance</em>}</li>
 * </ul>
 *
 * @see org.melanee.core.models.plm.PLM.PLMPackage#getSubtype()
 * @model
 * @generated
 */
public interface Subtype extends EObject {
  /**
   * Returns the value of the '<em><b>Subtype</b></em>' reference. <!--
   * begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Subtype</em>' reference isn't clear, there really
   * should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * 
   * @return the value of the '<em>Subtype</em>' reference.
   * @see #setSubtype(Clabject)
   * @see org.melanee.core.models.plm.PLM.PLMPackage#getSubtype_Subtype()
   * @model required="true"
   * @generated
   */
  Clabject getSubtype();

  /**
   * Sets the value of the '{@link org.melanee.core.models.plm.PLM.Subtype#getSubtype <em>Subtype</em>}' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Subtype</em>' reference.
   * @see #getSubtype()
   * @generated
   */
  void setSubtype(Clabject value);

  /**
   * Returns the value of the '<em><b>Inheritance</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.melanee.core.models.plm.PLM.Inheritance#getSubtype <em>Subtype</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Inheritance</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Inheritance</em>' container reference.
   * @see #setInheritance(Inheritance)
   * @see org.melanee.core.models.plm.PLM.PLMPackage#getSubtype_Inheritance()
   * @see org.melanee.core.models.plm.PLM.Inheritance#getSubtype
   * @model opposite="subtype" transient="false"
   * @generated
   */
  Inheritance getInheritance();

  /**
   * Sets the value of the '{@link org.melanee.core.models.plm.PLM.Subtype#getInheritance <em>Inheritance</em>}' container reference.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @param value the new value of the '<em>Inheritance</em>' container reference.
   * @see #getInheritance()
   * @generated
   */
  void setInheritance(Inheritance value);

} // Subtype

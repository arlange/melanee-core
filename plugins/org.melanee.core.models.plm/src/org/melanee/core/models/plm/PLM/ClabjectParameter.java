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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Clabject
 * Parameter</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.melanee.core.models.plm.PLM.ClabjectParameter#getDatatype
 * <em>Datatype</em>}</li>
 * </ul>
 *
 * @see org.melanee.core.models.plm.PLM.PLMPackage#getClabjectParameter()
 * @model
 * @generated
 */
public interface ClabjectParameter extends Parameter {
  /**
   * Returns the value of the '<em><b>Datatype</b></em>' reference. <!--
   * begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Datatype</em>' reference isn't clear, there really
   * should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * 
   * @return the value of the '<em>Datatype</em>' reference.
   * @see #setDatatype(Clabject)
   * @see org.melanee.core.models.plm.PLM.PLMPackage#getClabjectParameter_Datatype()
   * @model required="true"
   * @generated
   */
  Clabject getDatatype();

  /**
   * Sets the value of the
   * '{@link org.melanee.core.models.plm.PLM.ClabjectParameter#getDatatype
   * <em>Datatype</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @param value
   *          the new value of the '<em>Datatype</em>' reference.
   * @see #getDatatype()
   * @generated
   */
  void setDatatype(Clabject value);

} // ClabjectParameter

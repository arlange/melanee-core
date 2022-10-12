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
 * '<em><b>Property</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.melanee.core.models.plm.PLM.Property#getParsingOrder <em>Parsing Order</em>}</li>
 * </ul>
 *
 * @see org.melanee.core.models.plm.PLM.PLMPackage#getProperty()
 * @model abstract="true"
 * @generated
 */
public interface Property extends EObject {

	/**
   * Returns the value of the '<em><b>Parsing Order</b></em>' attribute.
   * The default value is <code>"0"</code>.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parsing Order</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Parsing Order</em>' attribute.
   * @see #setParsingOrder(String)
   * @see org.melanee.core.models.plm.PLM.PLMPackage#getProperty_ParsingOrder()
   * @model default="0"
   * @generated
   */
	String getParsingOrder();

	/**
   * Sets the value of the '{@link org.melanee.core.models.plm.PLM.Property#getParsingOrder <em>Parsing Order</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Parsing Order</em>' attribute.
   * @see #getParsingOrder()
   * @generated
   */
  void setParsingOrder(String value);
} // Property

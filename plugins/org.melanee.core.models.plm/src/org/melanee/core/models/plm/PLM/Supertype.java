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
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Supertype</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.melanee.core.models.plm.PLM.Supertype#getSupertype <em>Supertype</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.Supertype#getInheritance <em>Inheritance</em>}</li>
 * </ul>
 *
 * @see org.melanee.core.models.plm.PLM.PLMPackage#getSupertype()
 * @model
 * @generated
 */
public interface Supertype extends EObject {
	/**
	 * Returns the value of the '<em><b>Supertype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Supertype</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Supertype</em>' reference.
	 * @see #setSupertype(Clabject)
	 * @see org.melanee.core.models.plm.PLM.PLMPackage#getSupertype_Supertype()
	 * @model required="true"
	 * @generated
	 */
	Clabject getSupertype();

	/**
	 * Sets the value of the '{@link org.melanee.core.models.plm.PLM.Supertype#getSupertype <em>Supertype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Supertype</em>' reference.
	 * @see #getSupertype()
	 * @generated
	 */
	void setSupertype(Clabject value);

	/**
	 * Returns the value of the '<em><b>Inheritance</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.melanee.core.models.plm.PLM.Inheritance#getSupertype <em>Supertype</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inheritance</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inheritance</em>' container reference.
	 * @see #setInheritance(Inheritance)
	 * @see org.melanee.core.models.plm.PLM.PLMPackage#getSupertype_Inheritance()
	 * @see org.melanee.core.models.plm.PLM.Inheritance#getSupertype
	 * @model opposite="supertype" transient="false"
	 * @generated
	 */
	Inheritance getInheritance();

	/**
	 * Sets the value of the '{@link org.melanee.core.models.plm.PLM.Supertype#getInheritance <em>Inheritance</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inheritance</em>' container reference.
	 * @see #getInheritance()
	 * @generated
	 */
	void setInheritance(Inheritance value);

} // Supertype

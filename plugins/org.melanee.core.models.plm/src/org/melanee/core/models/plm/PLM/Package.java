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
 * A representation of the model object '<em><b>Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.melanee.core.models.plm.PLM.Package#getContent <em>Content</em>}</li>
 * </ul>
 *
 * @see org.melanee.core.models.plm.PLM.PLMPackage#getPackage()
 * @model
 * @generated
 */
public interface Package extends OwnedElement {
	/**
	 * Returns the value of the '<em><b>Content</b></em>' containment reference list.
	 * The list contents are of type {@link org.melanee.core.models.plm.PLM.OwnedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content</em>' containment reference list.
	 * @see org.melanee.core.models.plm.PLM.PLMPackage#getPackage_Content()
	 * @model containment="true"
	 * @generated
	 */
	EList<OwnedElement> getContent();

} // Package

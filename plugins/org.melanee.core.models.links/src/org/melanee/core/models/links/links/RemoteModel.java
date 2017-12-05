/*******************************************************************************
 * Copyright (c) 2011-2015 University of Mannheim: Chair for Software Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     - initial API and implementation and initial documentation
 *******************************************************************************/
package org.melanee.core.models.links.links;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Remote Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A link to a remot model
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.melanee.core.models.links.links.RemoteModel#getLinks <em>Links</em>}</li>
 *   <li>{@link org.melanee.core.models.links.links.RemoteModel#getURL <em>URL</em>}</li>
 *   <li>{@link org.melanee.core.models.links.links.RemoteModel#getPath <em>Path</em>}</li>
 * </ul>
 *
 * @see org.melanee.core.models.links.links.LinksPackage#getRemoteModel()
 * @model
 * @generated
 */
public interface RemoteModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Links</b></em>' containment reference list.
	 * The list contents are of type {@link org.melanee.core.models.links.links.Link}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The links between the local and remote model
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Links</em>' containment reference list.
	 * @see org.melanee.core.models.links.links.LinksPackage#getRemoteModel_Links()
	 * @model containment="true"
	 * @generated
	 */
	EList<Link> getLinks();

	/**
	 * Returns the value of the '<em><b>URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The URL to the model containing repository
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>URL</em>' attribute.
	 * @see #setURL(String)
	 * @see org.melanee.core.models.links.links.LinksPackage#getRemoteModel_URL()
	 * @model
	 * @generated
	 */
	String getURL();

	/**
	 * Sets the value of the '{@link org.melanee.core.models.links.links.RemoteModel#getURL <em>URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>URL</em>' attribute.
	 * @see #getURL()
	 * @generated
	 */
	void setURL(String value);

	/**
	 * Returns the value of the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * path within the repository
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Path</em>' attribute.
	 * @see #setPath(String)
	 * @see org.melanee.core.models.links.links.LinksPackage#getRemoteModel_Path()
	 * @model
	 * @generated
	 */
	String getPath();

	/**
	 * Sets the value of the '{@link org.melanee.core.models.links.links.RemoteModel#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(String value);

} // RemoteModel

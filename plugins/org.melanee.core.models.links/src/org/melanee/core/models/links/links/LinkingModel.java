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
package org.melanee.core.models.links.links;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Linking
 * Model</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc --> The model root which contains all models which are
 * linked <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.melanee.core.models.links.links.LinkingModel#getRemoteModels
 * <em>Remote Models</em>}</li>
 * </ul>
 *
 * @see org.melanee.core.models.links.links.LinksPackage#getLinkingModel()
 * @model
 * @generated
 */
public interface LinkingModel extends EObject {
  /**
   * Returns the value of the '<em><b>Remote Models</b></em>' containment
   * reference list. The list contents are of type
   * {@link org.melanee.core.models.links.links.RemoteModel}. <!-- begin-user-doc
   * --> <!-- end-user-doc --> <!-- begin-model-doc --> The linked remote models
   * <!-- end-model-doc -->
   * 
   * @return the value of the '<em>Remote Models</em>' containment reference list.
   * @see org.melanee.core.models.links.links.LinksPackage#getLinkingModel_RemoteModels()
   * @model containment="true"
   * @generated
   */
  EList<RemoteModel> getRemoteModels();

} // LinkingModel

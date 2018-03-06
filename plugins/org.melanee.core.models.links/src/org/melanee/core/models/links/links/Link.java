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

import org.eclipse.emf.ecore.EObject;

import org.melanee.core.models.plm.PLM.Element;

/**
 * <!-- begin-user-doc --> A representation of the model object
 * '<em><b>Link</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc --> A link between a remote model element (source) and
 * the local model element (target) <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.melanee.core.models.links.links.Link#getRevision
 * <em>Revision</em>}</li>
 * <li>{@link org.melanee.core.models.links.links.Link#getTarget
 * <em>Target</em>}</li>
 * <li>{@link org.melanee.core.models.links.links.Link#getSource
 * <em>Source</em>}</li>
 * <li>{@link org.melanee.core.models.links.links.Link#getSourceLocation
 * <em>Source Location</em>}</li>
 * </ul>
 *
 * @see org.melanee.core.models.links.links.LinksPackage#getLink()
 * @model
 * @generated
 */
public interface Link extends EObject {
  /**
   * Returns the value of the '<em><b>Revision</b></em>' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> The
   * revision to which the link currently links <!-- end-model-doc -->
   * 
   * @return the value of the '<em>Revision</em>' attribute.
   * @see #setRevision(String)
   * @see org.melanee.core.models.links.links.LinksPackage#getLink_Revision()
   * @model
   * @generated
   */
  String getRevision();

  /**
   * Sets the value of the
   * '{@link org.melanee.core.models.links.links.Link#getRevision
   * <em>Revision</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @param value
   *          the new value of the '<em>Revision</em>' attribute.
   * @see #getRevision()
   * @generated
   */
  void setRevision(String value);

  /**
   * Returns the value of the '<em><b>Target</b></em>' reference. <!--
   * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> the local
   * model element <!-- end-model-doc -->
   * 
   * @return the value of the '<em>Target</em>' reference.
   * @see #setTarget(Element)
   * @see org.melanee.core.models.links.links.LinksPackage#getLink_Target()
   * @model required="true"
   * @generated
   */
  Element getTarget();

  /**
   * Sets the value of the
   * '{@link org.melanee.core.models.links.links.Link#getTarget <em>Target</em>}'
   * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @param value
   *          the new value of the '<em>Target</em>' reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(Element value);

  /**
   * Returns the value of the '<em><b>Source</b></em>' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> the XMIID
   * of the remote model element <!-- end-model-doc -->
   * 
   * @return the value of the '<em>Source</em>' attribute.
   * @see #setSource(String)
   * @see org.melanee.core.models.links.links.LinksPackage#getLink_Source()
   * @model required="true"
   * @generated
   */
  String getSource();

  /**
   * Sets the value of the
   * '{@link org.melanee.core.models.links.links.Link#getSource <em>Source</em>}'
   * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @param value
   *          the new value of the '<em>Source</em>' attribute.
   * @see #getSource()
   * @generated
   */
  void setSource(String value);

  /**
   * Returns the value of the '<em><b>Source Location</b></em>' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> a cache for
   * the location of the remote element <!-- end-model-doc -->
   * 
   * @return the value of the '<em>Source Location</em>' attribute.
   * @see #setSourceLocation(String)
   * @see org.melanee.core.models.links.links.LinksPackage#getLink_SourceLocation()
   * @model
   * @generated
   */
  String getSourceLocation();

  /**
   * Sets the value of the
   * '{@link org.melanee.core.models.links.links.Link#getSourceLocation <em>Source
   * Location</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @param value
   *          the new value of the '<em>Source Location</em>' attribute.
   * @see #getSourceLocation()
   * @generated
   */
  void setSourceLocation(String value);

} // Link

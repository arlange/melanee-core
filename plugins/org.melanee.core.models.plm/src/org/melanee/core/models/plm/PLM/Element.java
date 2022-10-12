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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object
 * '<em><b>Element</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.melanee.core.models.plm.PLM.Element#getName <em>Name</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.Element#getVisualizer <em>Visualizer</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.Element#getBehavior <em>Behavior</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.Element#getConstraint <em>Constraint</em>}</li>
 * </ul>
 *
 * @see org.melanee.core.models.plm.PLM.PLMPackage#getElement()
 * @model abstract="true"
 * @generated
 */
public interface Element extends EObject {
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute. <!--
   * begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear, there really
   * should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * 
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.melanee.core.models.plm.PLM.PLMPackage#getElement_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.melanee.core.models.plm.PLM.Element#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Visualizer</b></em>' containment reference list.
   * The list contents are of type {@link org.melanee.core.models.plm.PLM.LMLVisualizer}.
   * <!-- begin-user-doc
   * -->
   * <p>
   * If the meaning of the '<em>Visualizer</em>' containment reference list isn't
   * clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Visualizer</em>' containment reference list.
   * @see org.melanee.core.models.plm.PLM.PLMPackage#getElement_Visualizer()
   * @model containment="true"
   * @generated
   */
  EList<LMLVisualizer> getVisualizer();

  /**
   * Returns the value of the '<em><b>Behavior</b></em>' containment reference list.
   * The list contents are of type {@link org.melanee.core.models.plm.PLM.AbstractBehavior}.
   * <!-- begin-user-doc
   * -->
   * <p>
   * If the meaning of the '<em>Behavior</em>' containment reference list isn't
   * clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Behavior</em>' containment reference list.
   * @see org.melanee.core.models.plm.PLM.PLMPackage#getElement_Behavior()
   * @model containment="true"
   * @generated
   */
  EList<AbstractBehavior> getBehavior();

  /**
   * Returns the value of the '<em><b>Constraint</b></em>' containment reference
   * list. The list contents are of type
   * {@link org.melanee.core.models.plm.PLM.AbstractConstraint}. <!--
   * begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Constraint</em>' containment reference list isn't
   * clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * 
   * @return the value of the '<em>Constraint</em>' containment reference list.
   * @see org.melanee.core.models.plm.PLM.PLMPackage#getElement_Constraint()
   * @model containment="true"
   * @generated
   */
  EList<AbstractConstraint> getConstraint();

} // Element

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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Abstract
 * DSL Visualizer</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.melanee.core.models.plm.PLM.AbstractDSLVisualizer#isInstanceLevel <em>Instance Level</em>}</li>
 *   <li>{@link org.melanee.core.models.plm.PLM.AbstractDSLVisualizer#getNotation <em>Notation</em>}</li>
 * </ul>
 *
 * @see org.melanee.core.models.plm.PLM.PLMPackage#getAbstractDSLVisualizer()
 * @model abstract="true"
 * @generated
 */
public interface AbstractDSLVisualizer extends EObject {
  /**
   * Returns the value of the '<em><b>Instance Level</b></em>' attribute. The
   * default value is <code>"false"</code>. <!-- begin-user-doc --> <!--
   * end-user-doc --> <!-- begin-model-doc --> If true this is only applied to
   * instances of the type where the visualizer is defined <!-- end-model-doc -->
   * 
   * @return the value of the '<em>Instance Level</em>' attribute.
   * @see #setInstanceLevel(boolean)
   * @see org.melanee.core.models.plm.PLM.PLMPackage#getAbstractDSLVisualizer_InstanceLevel()
   * @model default="false" required="true"
   * @generated
   */
  boolean isInstanceLevel();

  /**
   * Sets the value of the '{@link org.melanee.core.models.plm.PLM.AbstractDSLVisualizer#isInstanceLevel <em>Instance Level</em>}' attribute.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @param value the new value of the '<em>Instance Level</em>' attribute.
   * @see #isInstanceLevel()
   * @generated
   */
  void setInstanceLevel(boolean value);

  /**
   * Returns the value of the '<em><b>Notation</b></em>' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> Holds the
   * notation to which the visualizer belongs to <!-- end-model-doc -->
   * 
   * @return the value of the '<em>Notation</em>' attribute.
   * @see #setNotation(String)
   * @see org.melanee.core.models.plm.PLM.PLMPackage#getAbstractDSLVisualizer_Notation()
   * @model
   * @generated
   */
  String getNotation();

  /**
   * Sets the value of the '{@link org.melanee.core.models.plm.PLM.AbstractDSLVisualizer#getNotation <em>Notation</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Notation</em>' attribute.
   * @see #getNotation()
   * @generated
   */
  void setNotation(String value);

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> Holds
   * the format to which the visualizer belongs to. Method is used over an
   * attribute because it is not possible to overrride attributes in subclasses in
   * EMF. <!-- end-model-doc -->
   * 
   * @model required="true" annotation="http://www.eclipse.org/emf/2002/Ecore/OCL
   *        body='\'\''"
   * @generated
   */
  String format();

} // AbstractDSLVisualizer

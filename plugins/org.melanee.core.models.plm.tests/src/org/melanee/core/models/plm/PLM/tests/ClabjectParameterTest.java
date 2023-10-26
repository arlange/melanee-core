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
package org.melanee.core.models.plm.PLM.tests;

import junit.textui.TestRunner;

import org.melanee.core.models.plm.PLM.ClabjectParameter;
import org.melanee.core.models.plm.PLM.PLMFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Clabject Parameter</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ClabjectParameterTest extends ParameterTest {

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args) {
    TestRunner.run(ClabjectParameterTest.class);
  }

  /**
   * Constructs a new Clabject Parameter test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClabjectParameterTest(String name) {
    super(name);
  }

  /**
   * Returns the fixture for this Clabject Parameter test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected ClabjectParameter getFixture() {
    return (ClabjectParameter)fixture;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see junit.framework.TestCase#setUp()
   * @generated
   */
  @Override
  protected void setUp() throws Exception {
    setFixture(PLMFactory.eINSTANCE.createClabjectParameter());
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see junit.framework.TestCase#tearDown()
   * @generated
   */
  @Override
  protected void tearDown() throws Exception {
    setFixture(null);
  }

} //ClabjectParameterTest

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

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.melanee.core.models.plm.PLM.Domain;
import org.melanee.core.models.plm.PLM.PLMFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Domain</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class DomainTest extends TestCase {

  /**
   * The fixture for this Domain test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Domain fixture = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args) {
    TestRunner.run(DomainTest.class);
  }

  /**
   * Constructs a new Domain test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DomainTest(String name) {
    super(name);
  }

  /**
   * Sets the fixture for this Domain test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void setFixture(Domain fixture) {
    this.fixture = fixture;
  }

  /**
   * Returns the fixture for this Domain test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Domain getFixture() {
    return fixture;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see junit.framework.TestCase#setUp()
   * @generated
   */
  @Override
  protected void setUp() throws Exception {
    setFixture(PLMFactory.eINSTANCE.createDomain());
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

} //DomainTest

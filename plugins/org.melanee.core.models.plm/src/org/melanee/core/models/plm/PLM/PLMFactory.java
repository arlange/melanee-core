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

import org.eclipse.emf.ecore.EFactory;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a
 * create method for each non-abstract class of the model. <!-- end-user-doc -->
 * 
 * @see org.melanee.core.models.plm.PLM.PLMPackage
 * @generated
 */
public interface PLMFactory extends EFactory {
  /**
   * The singleton instance of the factory. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @generated
   */
  PLMFactory eINSTANCE = org.melanee.core.models.plm.PLM.impl.PLMFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Domain</em>'. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @return a new object of class '<em>Domain</em>'.
   * @generated
   */
  Domain createDomain();

  /**
   * Returns a new object of class '<em>Level</em>'. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @return a new object of class '<em>Level</em>'.
   * @generated
   */
  Level createLevel();

  /**
   * Returns a new object of class '<em>Deep Model</em>'. <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @return a new object of class '<em>Deep Model</em>'.
   * @generated
   */
  DeepModel createDeepModel();

  /**
   * Returns a new object of class '<em>Inheritance</em>'. <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @return a new object of class '<em>Inheritance</em>'.
   * @generated
   */
  Inheritance createInheritance();

  /**
   * Returns a new object of class '<em>Supertype</em>'. <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @return a new object of class '<em>Supertype</em>'.
   * @generated
   */
  Supertype createSupertype();

  /**
   * Returns a new object of class '<em>Subtype</em>'. <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @return a new object of class '<em>Subtype</em>'.
   * @generated
   */
  Subtype createSubtype();

  /**
   * Returns a new object of class '<em>Classification</em>'. <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * 
   * @return a new object of class '<em>Classification</em>'.
   * @generated
   */
  Classification createClassification();

  /**
   * Returns a new object of class '<em>Entity</em>'. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @return a new object of class '<em>Entity</em>'.
   * @generated
   */
  Entity createEntity();

  /**
   * Returns a new object of class '<em>Connection</em>'. <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @return a new object of class '<em>Connection</em>'.
   * @generated
   */
  Connection createConnection();

  /**
   * Returns a new object of class '<em>Connection End</em>'. <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * 
   * @return a new object of class '<em>Connection End</em>'.
   * @generated
   */
  ConnectionEnd createConnectionEnd();

  /**
   * Returns a new object of class '<em>LML Visualizer</em>'. <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * 
   * @return a new object of class '<em>LML Visualizer</em>'.
   * @generated
   */
  LMLVisualizer createLMLVisualizer();

  /**
   * Returns a new object of class '<em>Attribute</em>'. <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @return a new object of class '<em>Attribute</em>'.
   * @generated
   */
  Attribute createAttribute();

  /**
   * Returns a new object of class '<em>Method</em>'. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @return a new object of class '<em>Method</em>'.
   * @generated
   */
  Method createMethod();

  /**
   * Returns a new object of class '<em>Enumeration</em>'. <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @return a new object of class '<em>Enumeration</em>'.
   * @generated
   */
  Enumeration createEnumeration();

  /**
   * Returns a new object of class '<em>Clabject Parameter</em>'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return a new object of class '<em>Clabject Parameter</em>'.
   * @generated
   */
  ClabjectParameter createClabjectParameter();

  /**
   * Returns a new object of class '<em>Primitive Parameter</em>'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return a new object of class '<em>Primitive Parameter</em>'.
   * @generated
   */
  PrimitiveParameter createPrimitiveParameter();

  /**
   * Returns a new object of class '<em>Multiplicity</em>'. <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * 
   * @return a new object of class '<em>Multiplicity</em>'.
   * @generated
   */
  Multiplicity createMultiplicity();

  /**
   * Returns a new object of class '<em>Package</em>'. <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @return a new object of class '<em>Package</em>'.
   * @generated
   */
  Package createPackage();

  /**
   * Returns the package supported by this factory. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @return the package supported by this factory.
   * @generated
   */
  PLMPackage getPLMPackage();

  /**
   * This methods creates a clabject from a template. All features and
   * LMLVisualizers are copied to the new clabject and the potency is calculated
   * base on the new clabjects parent. In case the newClabject is on the level
   * below of template a Classification relationship is created. Does not copy
   * bounds.
   * 
   * @param template
   *          the clabject which hold all values for creation
   * @param newParent
   *          the parent in which the clabject is placed in
   * 
   *          <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */

  public Clabject createClabjectFromTemplate(Clabject template, Element newParent);

  /**
   * This methods creates a clabject from a template. All features and
   * LMLVisualizers are copied to the new clabject and the potency is calculated
   * base on the new clabjects parent. In case the newClabject is on the level
   * below of template a Classification relationship is created
   * 
   * @param template
   *          the clabject which hold all values for creation
   * @param newParent
   *          the parent in which the clabject is placed in
   * @param copyLocation
   *          copy X/Y location
   * @param copySize
   *          width and height
   * 
   *          <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */

  public Clabject createClabjectFromTemplate(Clabject template, Element newParent,
      boolean copyLocation, boolean copySize);

  /**
   * Does not copy location but size.<br />
   * Does not initialize attributes with default values
   *
   * @param template
   *          the template to "instantiate"
   * @param newClabject
   *          the clabject which is the "instance"
   *
   * @generated
   */

  public void configureClabject(Clabject template, Clabject newClabject);

  /**
   * Does not copy location but size.<br />
   *
   * @param template
   *          the template to "instantiate"
   * @param newClabject
   *          the clabject which is the "instance"
   * @param initializeAttributes
   *          initializes the ontological attributes of a clabject:
   *          <ul>
   *          <li>string = [attribute.name]</li>
   *          <li>numeric = 0</li>
   *          <li>boolean = false</li>
   *          <li>others are not initialized</li>
   *          </ul>
   *
   * @generated
   */

  public void configureClabject(Clabject template, Clabject newClabject,
      boolean initializeAttributes);

  /**
   * Does not copy location but size.<br />
   * Does not initialize attributes with default values
   * 
   * @param template
   * @param newClabject
   * @param newParent
   *          null if newClabject has already a model set or no parent exists the
   *          method will ignore the parent or use one if it can find one to
   *          calculate values. Possible values are Models, Connections or
   *          Entities as they can contain clabjects. Can be null to not set a new
   *          parent. This is needed in cases where this could raise a read/write
   *          transaction exception. If the new parten is null, the potency is
   *          calculated by substracting one from the type potency.
   *
   * @generated
   */

  public void configureClabject(Clabject template, Clabject newClabject, Element newParent);

  /**
   * Does not copy bounds
   * 
   * @param template
   * @param newClabject
   * @param newParent
   *          null if newClabject has already a model set or no parent exists the
   *          method will ignore the parent or use one if it can find one to
   *          calculate values. Possible values are Models, Connections or
   *          Entities as they can contain clabjects. Can be null to not set a new
   *          parent. This is needed in cases where this could raise a read/write
   *          transaction exception. If the new parten is null, the potency is
   *          calculated by substracting one from the type potency.
   * @param initializeAttributes
   *          initializes the ontological attributes of a clabject:
   *          <ul>
   *          <li>string = [attribute.name]</li>
   *          <li>numeric = 0</li>
   *          <li>boolean = false</li>
   *          <li>others are not initialized</li>
   *          </ul>
   *
   *
   * @generated
   */

  public void configureClabject(Clabject template, Clabject newClabject, Element newParent,
      boolean initializeAttributes);

  /**
   * 
   * @param template
   * @param newClabject
   * @param newParent
   *          null if newClabject has already a model set or no parent exists the
   *          method will ignore the parent or use one if it can find one to
   *          calculate values. Possible values are Models, Connections or
   *          Entities as they can contain clabjects. Can be null to not set a new
   *          parent. This is needed in cases where this could raise a read/write
   *          transaction exception. If the new parten is null, the potency is
   *          calculated by substracting one from the type potency.
   * @param copyLocation
   *          copy X/Y location
   * @param copySize
   *          width and height
   *
   * @generated
   */

  public void configureClabject(Clabject template, Clabject newClabject, Element newParent,
      boolean copyLocation, boolean copySize);

  /**
   * 
   * @param template
   * @param newClabject
   * @param newParent
   *          null if newClabject has already a model set or no parent exists the
   *          method will ignore the parent or use one if it can find one to
   *          calculate values. Possible values are Models, Connections or
   *          Entities as they can contain clabjects. Can be null to not set a new
   *          parent. This is needed in cases where this could raise a read/write
   *          transaction exception. If the new parten is null, the potency is
   *          calculated by substracting one from the type potency.
   * @param copyLocation
   *          copy X/Y location
   * @param copySize
   *          width and height
   *
   * @generated
   */

  public void configureClabject(Clabject template, Clabject newClabject, Element newParent,
      boolean initializeAttributes, boolean copyLocation, boolean copySize);

  /**
   * Creates a new feature from the template. Does not initialize attributes.
   * 
   * @param template
   *          the template to create from
   * @param newParent
   *          null if it shall not be added to a parent by this method
   * @return
   *
   * @generated
   */

  public Feature createFeature(Feature template, Clabject newParent);

  /**
   * Creates a new feature from the template
   * 
   * @param template
   *          the template to create from
   * @param newParent
   *          null if it shall not be added to a parent by this method
   * @param initializeAttributes
   *          initialized the ontological attributes of a clabject:
   *          <ul>
   *          <li>string = [attribute.name]</li>
   *          <li>numeric = 0</li>
   *          <li>boolean = false</li>
   *          <li>others are not initialized</li>
   *          </ul>
   * @return
   *
   * @generated
   */

  public Feature createFeature(Feature template, Clabject newParent, boolean initializeAttribute);

  /**
   * Creates a new feature from the template Does not initialize attributes.
   * 
   * @param template
   * @param newParent
   * @param initializeAttributes
   *          initialized the ontological attributes of a clabject:
   *          <ul>
   *          <li>string = [attribute.name]</li>
   *          <li>numeric = 0</li>
   *          <li>boolean = false</li>
   *          <li>others are not initialized</li>
   *          </ul>
   * 
   * @return
   *
   * @generated
   */

  public Feature createFeature(Feature template, Clabject templateParent, Clabject newParent,
      boolean addNewElementToParent);

  /**
   * Creates a new feature from the template
   * 
   * @param template
   * @param newParent
   * @param initializeAttributes
   *          initialized the ontological attributes of a clabject:
   *          <ul>
   *          <li>string = [attribute.name]</li>
   *          <li>numeric = 0</li>
   *          <li>boolean = false</li>
   *          <li>others are not initialized</li>
   *          </ul>
   * 
   * @return
   *
   * @generated
   */

  public Feature createFeature(Feature template, Clabject templateParent, Clabject newParent,
      boolean initializeAttribute, boolean addNewElementToParent);

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */

  /**
   * @param initializeAttributes
   *          initialized the ontological attributes of a clabject:
   *          <ul>
   *          <li>string = [attribute.name]</li>
   *          <li>numeric = 0</li>
   *          <li>boolean = false</li>
   *          <li>others are not initialized</li>
   *          </ul>
   *
   * @generated
   */

  public Level createLevelWithLMLVisualizer();

  public DeepModel createDeepModelWithLMLVisualizer();

  public Inheritance createInheritanceWithLMLVisualizer();

  public Classification createClassificationWithLMLVisualizer();

  public Entity createEntityWithLMLVisualizer();

  public Connection createConnectionWithLMLVisualizer();

  public Attribute createAttributeWithLMLVisualizer();

  public Method createMethodWithLMLVisualizer();

  public Enumeration createEnumerationWithLMLVisualizer();

  public Package createPackageWithLMLVisualizer();

} // PLMFactory
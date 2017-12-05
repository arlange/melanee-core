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
package org.melanee.core.models.plm.PLM.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.melanee.core.models.plm.PLM.AbstractBehavior;
import org.melanee.core.models.plm.PLM.AbstractConstraint;
import org.melanee.core.models.plm.PLM.AbstractDSLVisualizer;
import org.melanee.core.models.plm.PLM.Attribute;
import org.melanee.core.models.plm.PLM.Clabject;
import org.melanee.core.models.plm.PLM.ClabjectParameter;
import org.melanee.core.models.plm.PLM.Classification;
import org.melanee.core.models.plm.PLM.ClassificationKind;
import org.melanee.core.models.plm.PLM.ComplianceKind;
import org.melanee.core.models.plm.PLM.Connection;
import org.melanee.core.models.plm.PLM.ConnectionEnd;
import org.melanee.core.models.plm.PLM.ConnectionEndKind;
import org.melanee.core.models.plm.PLM.Correlation;
import org.melanee.core.models.plm.PLM.DeepModel;
import org.melanee.core.models.plm.PLM.Domain;
import org.melanee.core.models.plm.PLM.Element;
import org.melanee.core.models.plm.PLM.Entity;
import org.melanee.core.models.plm.PLM.Enumeration;
import org.melanee.core.models.plm.PLM.Feature;
import org.melanee.core.models.plm.PLM.Inheritance;
import org.melanee.core.models.plm.PLM.LMLVisualizer;
import org.melanee.core.models.plm.PLM.Level;
import org.melanee.core.models.plm.PLM.Method;
import org.melanee.core.models.plm.PLM.Multiplicity;
import org.melanee.core.models.plm.PLM.OwnedElement;
import org.melanee.core.models.plm.PLM.PLMFactory;
import org.melanee.core.models.plm.PLM.PLMPackage;
import org.melanee.core.models.plm.PLM.Parameter;
import org.melanee.core.models.plm.PLM.PrimitiveParameter;
import org.melanee.core.models.plm.PLM.Property;
import org.melanee.core.models.plm.PLM.Subtype;
import org.melanee.core.models.plm.PLM.Supertype;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PLMPackageImpl extends EPackageImpl implements PLMPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass domainEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass levelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deepModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ownedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass correlationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inheritanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass supertypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subtypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass clabjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectionEndEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lmlVisualizerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass methodEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumerationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass clabjectParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiplicityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass packageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractDSLVisualizerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractBehaviorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum connectionEndKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum classificationKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum complianceKindEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.melanee.core.models.plm.PLM.PLMPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PLMPackageImpl() {
		super(eNS_URI, PLMFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link PLMPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PLMPackage init() {
		if (isInited) return (PLMPackage)EPackage.Registry.INSTANCE.getEPackage(PLMPackage.eNS_URI);

		// Obtain or create and register package
		PLMPackageImpl thePLMPackage = (PLMPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PLMPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PLMPackageImpl());

		isInited = true;

		// Create package meta-data objects
		thePLMPackage.createPackageContents();

		// Initialize created meta-data
		thePLMPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePLMPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PLMPackage.eNS_URI, thePLMPackage);
		return thePLMPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDomain() {
		return domainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDomain_Name() {
		return (EAttribute)domainEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDomain_DeepModel() {
		return (EReference)domainEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDomain_PlmVersion() {
		return (EAttribute)domainEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDomain_ComplianceKind() {
		return (EAttribute)domainEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElement() {
		return elementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getElement_Name() {
		return (EAttribute)elementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getElement_Visualizer() {
		return (EReference)elementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getElement_Behavior() {
		return (EReference)elementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getElement_Constraint() {
		return (EReference)elementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLevel() {
		return levelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLevel_Content() {
		return (EReference)levelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLevel__GetAllInheritances() {
		return levelEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLevel__GetClabjects() {
		return levelEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLevel__GetEntities() {
		return levelEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLevel__GetConnections() {
		return levelEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLevel__GetClassifications() {
		return levelEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLevel__GetDeepModel() {
		return levelEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLevel__GetClassifiedLevel() {
		return levelEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLevel__GetClassifyingLevel() {
		return levelEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLevel__GetLevel() {
		return levelEClass.getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLevel__IsRootLevel() {
		return levelEClass.getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLevel__IsLeafLevel() {
		return levelEClass.getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeepModel() {
		return deepModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeepModel_Content() {
		return (EReference)deepModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeepModel_Enumeration() {
		return (EReference)deepModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDeepModel__GetLevelAtIndex__int() {
		return deepModelEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDeepModel__GetPrimitiveDatatypes() {
		return deepModelEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDeepModel__GetRegexForPrimitiveDatatype__String() {
		return deepModelEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDeepModel__GetAllDatatypes() {
		return deepModelEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOwnedElement() {
		return ownedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getOwnedElement__GetLevel() {
		return ownedElementEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCorrelation() {
		return correlationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInheritance() {
		return inheritanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInheritance_Supertype() {
		return (EReference)inheritanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInheritance_Subtype() {
		return (EReference)inheritanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInheritance_Disjoint() {
		return (EAttribute)inheritanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInheritance_Complete() {
		return (EAttribute)inheritanceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInheritance__IsDisjoint() {
		return inheritanceEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInheritance__IsComplete() {
		return inheritanceEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInheritance__IsIntersection() {
		return inheritanceEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInheritance__Represent() {
		return inheritanceEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSupertype() {
		return supertypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSupertype_Supertype() {
		return (EReference)supertypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSupertype_Inheritance() {
		return (EReference)supertypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubtype() {
		return subtypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubtype_Subtype() {
		return (EReference)subtypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubtype_Inheritance() {
		return (EReference)subtypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassification() {
		return classificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassification_Instance() {
		return (EReference)classificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassification_Type() {
		return (EReference)classificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassification_Kind() {
		return (EAttribute)classificationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassification__Represent() {
		return classificationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClabject() {
		return clabjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClabject_Potency() {
		return (EAttribute)clabjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClabject_LevelIndex() {
		return (EAttribute)clabjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClabject_Content() {
		return (EReference)clabjectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClabject_Feature() {
		return (EReference)clabjectEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetDeepModel() {
		return clabjectEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetSupertypes() {
		return clabjectEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetSupertypes__EList() {
		return clabjectEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetDirectSupertypes() {
		return clabjectEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetSubtypes() {
		return clabjectEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetHollowSubtypes() {
		return clabjectEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetHollowSupertypes() {
		return clabjectEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetClassificationsAsInstance() {
		return clabjectEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetClassificationsAsType() {
		return clabjectEClass.getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetInstances() {
		return clabjectEClass.getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetTypes() {
		return clabjectEClass.getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetDirectTypes() {
		return clabjectEClass.getEOperations().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetLevelTypes() {
		return clabjectEClass.getEOperations().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetDefinedClassificationTreeAsInstance() {
		return clabjectEClass.getEOperations().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetClassificationTreeAsInstance() {
		return clabjectEClass.getEOperations().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetDefinedInstances() {
		return clabjectEClass.getEOperations().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetDefinedClassificationTreeAsType() {
		return clabjectEClass.getEOperations().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetClassificationTreeAsType() {
		return clabjectEClass.getEOperations().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetClassificationTreeAsType__int() {
		return clabjectEClass.getEOperations().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetClassificationTreeAsType__int_int() {
		return clabjectEClass.getEOperations().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetAllFeatures() {
		return clabjectEClass.getEOperations().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetAllAttributes() {
		return clabjectEClass.getEOperations().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetDefinedAttributes() {
		return clabjectEClass.getEOperations().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetDefinedAttributeByName__String() {
		return clabjectEClass.getEOperations().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetAllMethods() {
		return clabjectEClass.getEOperations().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetDefinedMethods() {
		return clabjectEClass.getEOperations().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__IsInstanceOf__Clabject() {
		return clabjectEClass.getEOperations().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__IsTypeOf__Clabject() {
		return clabjectEClass.getEOperations().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__IsContainerOf__Clabject() {
		return clabjectEClass.getEOperations().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetComposite() {
		return clabjectEClass.getEOperations().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetAggregates() {
		return clabjectEClass.getEOperations().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetParts() {
		return clabjectEClass.getEOperations().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetPartsForMoniker__String() {
		return clabjectEClass.getEOperations().get(32);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetDefinedConnections() {
		return clabjectEClass.getEOperations().get(33);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetConnections() {
		return clabjectEClass.getEOperations().get(34);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetInheritedConnections() {
		return clabjectEClass.getEOperations().get(35);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetLevelCompleteTypes() {
		return clabjectEClass.getEOperations().get(36);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetLevelIncompleteTypes() {
		return clabjectEClass.getEOperations().get(37);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetBlueprint() {
		return clabjectEClass.getEOperations().get(38);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetOffspring() {
		return clabjectEClass.getEOperations().get(39);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetIsonyms() {
		return clabjectEClass.getEOperations().get(40);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetHyponyms() {
		return clabjectEClass.getEOperations().get(41);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetDomainForConnection__Connection() {
		return clabjectEClass.getEOperations().get(42);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetPossibleDomainSpecificVisualizers() {
		return clabjectEClass.getEOperations().get(43);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetInheritancesAsSubtype() {
		return clabjectEClass.getEOperations().get(44);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetInheritancesAsSupertype() {
		return clabjectEClass.getEOperations().get(45);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetDefinedNavigations() {
		return clabjectEClass.getEOperations().get(46);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetInheritedNavigations() {
		return clabjectEClass.getEOperations().get(47);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetAllNavigations() {
		return clabjectEClass.getEOperations().get(48);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetDomainMonikers() {
		return clabjectEClass.getEOperations().get(49);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetDomainForMoniker__String() {
		return clabjectEClass.getEOperations().get(50);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetAllNavigationsForMoniker__String() {
		return clabjectEClass.getEOperations().get(51);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetAllNavigationsAsDestination() {
		return clabjectEClass.getEOperations().get(52);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetDefinedNavigationsAsDestination() {
		return clabjectEClass.getEOperations().get(53);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetInheritedNavigationsAsDestination() {
		return clabjectEClass.getEOperations().get(54);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__Represent() {
		return clabjectEClass.getEOperations().get(55);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetFeatureForName__String() {
		return clabjectEClass.getEOperations().get(56);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetPotencyAsString() {
		return clabjectEClass.getEOperations().get(57);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetDisjointSiblings() {
		return clabjectEClass.getEOperations().get(58);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetAttributeByName__String() {
		return clabjectEClass.getEOperations().get(59);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__ViolatesMultiplicityConstraints() {
		return clabjectEClass.getEOperations().get(60);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetDefinedInheritances() {
		return clabjectEClass.getEOperations().get(61);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClabject__GetOwnedClabjects() {
		return clabjectEClass.getEOperations().get(62);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeature() {
		return featureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeature_Durability() {
		return (EAttribute)featureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFeature__GetClabject() {
		return featureEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFeature__GetDurabilityAsString() {
		return featureEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFeature__Represent() {
		return featureEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntity() {
		return entityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEntity__Represent() {
		return entityEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnection() {
		return connectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnection_ConnectionEnd() {
		return (EReference)connectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConnection__GetDomain() {
		return connectionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConnection__GetNotDomain() {
		return connectionEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConnection__GetHumanReadableName() {
		return connectionEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConnection__GetParticipants() {
		return connectionEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConnection__GetMoniker() {
		return connectionEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConnection__GetDomain__Clabject() {
		return connectionEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConnection__GetMonikerForParticipant__Clabject() {
		return connectionEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConnection__GetLowerForMoniker__String() {
		return connectionEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConnection__GetUpperForMoniker__String() {
		return connectionEClass.getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConnection__IsNavigableForMoniker__String() {
		return connectionEClass.getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConnection__GetOrder() {
		return connectionEClass.getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConnection__GetInheritedConnectionEnd() {
		return connectionEClass.getEOperations().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConnection__GetAllConnectionEnd() {
		return connectionEClass.getEOperations().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConnection__GetParticipantForMoniker__String() {
		return connectionEClass.getEOperations().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConnection__Represent() {
		return connectionEClass.getEOperations().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnectionEnd() {
		return connectionEndEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionEnd_Lower() {
		return (EAttribute)connectionEndEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionEnd_Upper() {
		return (EAttribute)connectionEndEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionEnd_Navigable() {
		return (EAttribute)connectionEndEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectionEnd_Destination() {
		return (EReference)connectionEndEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectionEnd_Connection() {
		return (EReference)connectionEndEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionEnd_Moniker() {
		return (EAttribute)connectionEndEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConnectionEnd_Kind() {
		return (EAttribute)connectionEndEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectionEnd_Type() {
		return (EReference)connectionEndEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectionEnd_Multiplicity() {
		return (EReference)connectionEndEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConnectionEnd__GetHumanReadableConnectionEndName() {
		return connectionEndEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConnectionEnd__HasDefaultMoniker() {
		return connectionEndEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConnectionEnd__Represent() {
		return connectionEndEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConnectionEnd__Moniker() {
		return connectionEndEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConnectionEnd__RepresentMultiplicity() {
		return connectionEndEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConnectionEnd__GetConnectionEndName() {
		return connectionEndEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConnectionEnd__Conforms__ConnectionEnd() {
		return connectionEndEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLMLVisualizer() {
		return lmlVisualizerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLMLVisualizer_Attributes() {
		return (EAttribute)lmlVisualizerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLMLVisualizer_DslVisualizer() {
		return (EReference)lmlVisualizerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLMLVisualizer_Name() {
		return (EAttribute)lmlVisualizerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLMLVisualizer_XLocation() {
		return (EAttribute)lmlVisualizerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLMLVisualizer_YLocation() {
		return (EAttribute)lmlVisualizerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLMLVisualizer_Width() {
		return (EAttribute)lmlVisualizerEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLMLVisualizer_Height() {
		return (EAttribute)lmlVisualizerEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLMLVisualizer__GetDefaultVisualizationValues() {
		return lmlVisualizerEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLMLVisualizer__GetValueForKey__String() {
		return lmlVisualizerEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLMLVisualizer__GetContainingElement() {
		return lmlVisualizerEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLMLVisualizer__EOperation0() {
		return lmlVisualizerEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProperty() {
		return propertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttribute() {
		return attributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttribute_Value() {
		return (EAttribute)attributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttribute_Mutability() {
		return (EAttribute)attributeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttribute_Datatype() {
		return (EAttribute)attributeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAttribute__GetMutabilityAsString() {
		return attributeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAttribute__Represent() {
		return attributeEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAttribute__GetPossibleDataTypes() {
		return attributeEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAttribute__GetPrimitiveDataTypes() {
		return attributeEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAttribute__GetEnumerationDataTypes() {
		return attributeEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAttribute__IsEnumeration() {
		return attributeEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAttribute__GetEnumeration() {
		return attributeEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAttribute__GetLiterals() {
		return attributeEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMethod() {
		return methodEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMethod_Body() {
		return (EAttribute)methodEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMethod_Parameter() {
		return (EReference)methodEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMethod__Represent() {
		return methodEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMethod__GetInput() {
		return methodEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMethod__GetOutput() {
		return methodEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumeration() {
		return enumerationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnumeration_Literal() {
		return (EAttribute)enumerationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameter() {
		return parameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameter_Name() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameter_Expression() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameter_Output() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getParameter__GetClabject() {
		return parameterEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClabjectParameter() {
		return clabjectParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClabjectParameter_Datatype() {
		return (EReference)clabjectParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimitiveParameter() {
		return primitiveParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPrimitiveParameter_Datatype() {
		return (EAttribute)primitiveParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultiplicity() {
		return multiplicityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiplicity_Lower() {
		return (EAttribute)multiplicityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiplicity_Upper() {
		return (EAttribute)multiplicityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiplicity_Potency() {
		return (EAttribute)multiplicityEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultiplicity_Connectionend() {
		return (EReference)multiplicityEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPackage() {
		return packageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackage_Content() {
		return (EReference)packageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractDSLVisualizer() {
		return abstractDSLVisualizerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractDSLVisualizer_InstanceLevel() {
		return (EAttribute)abstractDSLVisualizerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractDSLVisualizer_Notation() {
		return (EAttribute)abstractDSLVisualizerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAbstractDSLVisualizer__Format() {
		return abstractDSLVisualizerEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractBehavior() {
		return abstractBehaviorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractBehavior_Name() {
		return (EAttribute)abstractBehaviorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractConstraint() {
		return abstractConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractConstraint_Name() {
		return (EAttribute)abstractConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getConnectionEndKind() {
		return connectionEndKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getClassificationKind() {
		return classificationKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getComplianceKind() {
		return complianceKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PLMFactory getPLMFactory() {
		return (PLMFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		domainEClass = createEClass(DOMAIN);
		createEAttribute(domainEClass, DOMAIN__NAME);
		createEReference(domainEClass, DOMAIN__DEEP_MODEL);
		createEAttribute(domainEClass, DOMAIN__PLM_VERSION);
		createEAttribute(domainEClass, DOMAIN__COMPLIANCE_KIND);

		elementEClass = createEClass(ELEMENT);
		createEAttribute(elementEClass, ELEMENT__NAME);
		createEReference(elementEClass, ELEMENT__VISUALIZER);
		createEReference(elementEClass, ELEMENT__BEHAVIOR);
		createEReference(elementEClass, ELEMENT__CONSTRAINT);

		levelEClass = createEClass(LEVEL);
		createEReference(levelEClass, LEVEL__CONTENT);
		createEOperation(levelEClass, LEVEL___GET_ALL_INHERITANCES);
		createEOperation(levelEClass, LEVEL___GET_CLABJECTS);
		createEOperation(levelEClass, LEVEL___GET_ENTITIES);
		createEOperation(levelEClass, LEVEL___GET_CONNECTIONS);
		createEOperation(levelEClass, LEVEL___GET_CLASSIFICATIONS);
		createEOperation(levelEClass, LEVEL___GET_DEEP_MODEL);
		createEOperation(levelEClass, LEVEL___GET_CLASSIFIED_LEVEL);
		createEOperation(levelEClass, LEVEL___GET_CLASSIFYING_LEVEL);
		createEOperation(levelEClass, LEVEL___GET_LEVEL);
		createEOperation(levelEClass, LEVEL___IS_ROOT_LEVEL);
		createEOperation(levelEClass, LEVEL___IS_LEAF_LEVEL);

		deepModelEClass = createEClass(DEEP_MODEL);
		createEReference(deepModelEClass, DEEP_MODEL__CONTENT);
		createEReference(deepModelEClass, DEEP_MODEL__ENUMERATION);
		createEOperation(deepModelEClass, DEEP_MODEL___GET_LEVEL_AT_INDEX__INT);
		createEOperation(deepModelEClass, DEEP_MODEL___GET_PRIMITIVE_DATATYPES);
		createEOperation(deepModelEClass, DEEP_MODEL___GET_REGEX_FOR_PRIMITIVE_DATATYPE__STRING);
		createEOperation(deepModelEClass, DEEP_MODEL___GET_ALL_DATATYPES);

		ownedElementEClass = createEClass(OWNED_ELEMENT);
		createEOperation(ownedElementEClass, OWNED_ELEMENT___GET_LEVEL);

		correlationEClass = createEClass(CORRELATION);

		inheritanceEClass = createEClass(INHERITANCE);
		createEReference(inheritanceEClass, INHERITANCE__SUPERTYPE);
		createEReference(inheritanceEClass, INHERITANCE__SUBTYPE);
		createEAttribute(inheritanceEClass, INHERITANCE__DISJOINT);
		createEAttribute(inheritanceEClass, INHERITANCE__COMPLETE);
		createEOperation(inheritanceEClass, INHERITANCE___IS_DISJOINT);
		createEOperation(inheritanceEClass, INHERITANCE___IS_COMPLETE);
		createEOperation(inheritanceEClass, INHERITANCE___IS_INTERSECTION);
		createEOperation(inheritanceEClass, INHERITANCE___REPRESENT);

		supertypeEClass = createEClass(SUPERTYPE);
		createEReference(supertypeEClass, SUPERTYPE__SUPERTYPE);
		createEReference(supertypeEClass, SUPERTYPE__INHERITANCE);

		subtypeEClass = createEClass(SUBTYPE);
		createEReference(subtypeEClass, SUBTYPE__SUBTYPE);
		createEReference(subtypeEClass, SUBTYPE__INHERITANCE);

		classificationEClass = createEClass(CLASSIFICATION);
		createEReference(classificationEClass, CLASSIFICATION__INSTANCE);
		createEReference(classificationEClass, CLASSIFICATION__TYPE);
		createEAttribute(classificationEClass, CLASSIFICATION__KIND);
		createEOperation(classificationEClass, CLASSIFICATION___REPRESENT);

		clabjectEClass = createEClass(CLABJECT);
		createEAttribute(clabjectEClass, CLABJECT__POTENCY);
		createEAttribute(clabjectEClass, CLABJECT__LEVEL_INDEX);
		createEReference(clabjectEClass, CLABJECT__CONTENT);
		createEReference(clabjectEClass, CLABJECT__FEATURE);
		createEOperation(clabjectEClass, CLABJECT___GET_DEEP_MODEL);
		createEOperation(clabjectEClass, CLABJECT___GET_SUPERTYPES);
		createEOperation(clabjectEClass, CLABJECT___GET_SUPERTYPES__ELIST);
		createEOperation(clabjectEClass, CLABJECT___GET_DIRECT_SUPERTYPES);
		createEOperation(clabjectEClass, CLABJECT___GET_SUBTYPES);
		createEOperation(clabjectEClass, CLABJECT___GET_HOLLOW_SUBTYPES);
		createEOperation(clabjectEClass, CLABJECT___GET_HOLLOW_SUPERTYPES);
		createEOperation(clabjectEClass, CLABJECT___GET_CLASSIFICATIONS_AS_INSTANCE);
		createEOperation(clabjectEClass, CLABJECT___GET_CLASSIFICATIONS_AS_TYPE);
		createEOperation(clabjectEClass, CLABJECT___GET_INSTANCES);
		createEOperation(clabjectEClass, CLABJECT___GET_TYPES);
		createEOperation(clabjectEClass, CLABJECT___GET_DIRECT_TYPES);
		createEOperation(clabjectEClass, CLABJECT___GET_LEVEL_TYPES);
		createEOperation(clabjectEClass, CLABJECT___GET_DEFINED_CLASSIFICATION_TREE_AS_INSTANCE);
		createEOperation(clabjectEClass, CLABJECT___GET_CLASSIFICATION_TREE_AS_INSTANCE);
		createEOperation(clabjectEClass, CLABJECT___GET_DEFINED_INSTANCES);
		createEOperation(clabjectEClass, CLABJECT___GET_DEFINED_CLASSIFICATION_TREE_AS_TYPE);
		createEOperation(clabjectEClass, CLABJECT___GET_CLASSIFICATION_TREE_AS_TYPE);
		createEOperation(clabjectEClass, CLABJECT___GET_CLASSIFICATION_TREE_AS_TYPE__INT);
		createEOperation(clabjectEClass, CLABJECT___GET_CLASSIFICATION_TREE_AS_TYPE__INT_INT);
		createEOperation(clabjectEClass, CLABJECT___GET_ALL_FEATURES);
		createEOperation(clabjectEClass, CLABJECT___GET_ALL_ATTRIBUTES);
		createEOperation(clabjectEClass, CLABJECT___GET_DEFINED_ATTRIBUTES);
		createEOperation(clabjectEClass, CLABJECT___GET_DEFINED_ATTRIBUTE_BY_NAME__STRING);
		createEOperation(clabjectEClass, CLABJECT___GET_ALL_METHODS);
		createEOperation(clabjectEClass, CLABJECT___GET_DEFINED_METHODS);
		createEOperation(clabjectEClass, CLABJECT___IS_INSTANCE_OF__CLABJECT);
		createEOperation(clabjectEClass, CLABJECT___IS_TYPE_OF__CLABJECT);
		createEOperation(clabjectEClass, CLABJECT___IS_CONTAINER_OF__CLABJECT);
		createEOperation(clabjectEClass, CLABJECT___GET_COMPOSITE);
		createEOperation(clabjectEClass, CLABJECT___GET_AGGREGATES);
		createEOperation(clabjectEClass, CLABJECT___GET_PARTS);
		createEOperation(clabjectEClass, CLABJECT___GET_PARTS_FOR_MONIKER__STRING);
		createEOperation(clabjectEClass, CLABJECT___GET_DEFINED_CONNECTIONS);
		createEOperation(clabjectEClass, CLABJECT___GET_CONNECTIONS);
		createEOperation(clabjectEClass, CLABJECT___GET_INHERITED_CONNECTIONS);
		createEOperation(clabjectEClass, CLABJECT___GET_LEVEL_COMPLETE_TYPES);
		createEOperation(clabjectEClass, CLABJECT___GET_LEVEL_INCOMPLETE_TYPES);
		createEOperation(clabjectEClass, CLABJECT___GET_BLUEPRINT);
		createEOperation(clabjectEClass, CLABJECT___GET_OFFSPRING);
		createEOperation(clabjectEClass, CLABJECT___GET_ISONYMS);
		createEOperation(clabjectEClass, CLABJECT___GET_HYPONYMS);
		createEOperation(clabjectEClass, CLABJECT___GET_DOMAIN_FOR_CONNECTION__CONNECTION);
		createEOperation(clabjectEClass, CLABJECT___GET_POSSIBLE_DOMAIN_SPECIFIC_VISUALIZERS);
		createEOperation(clabjectEClass, CLABJECT___GET_INHERITANCES_AS_SUBTYPE);
		createEOperation(clabjectEClass, CLABJECT___GET_INHERITANCES_AS_SUPERTYPE);
		createEOperation(clabjectEClass, CLABJECT___GET_DEFINED_NAVIGATIONS);
		createEOperation(clabjectEClass, CLABJECT___GET_INHERITED_NAVIGATIONS);
		createEOperation(clabjectEClass, CLABJECT___GET_ALL_NAVIGATIONS);
		createEOperation(clabjectEClass, CLABJECT___GET_DOMAIN_MONIKERS);
		createEOperation(clabjectEClass, CLABJECT___GET_DOMAIN_FOR_MONIKER__STRING);
		createEOperation(clabjectEClass, CLABJECT___GET_ALL_NAVIGATIONS_FOR_MONIKER__STRING);
		createEOperation(clabjectEClass, CLABJECT___GET_ALL_NAVIGATIONS_AS_DESTINATION);
		createEOperation(clabjectEClass, CLABJECT___GET_DEFINED_NAVIGATIONS_AS_DESTINATION);
		createEOperation(clabjectEClass, CLABJECT___GET_INHERITED_NAVIGATIONS_AS_DESTINATION);
		createEOperation(clabjectEClass, CLABJECT___REPRESENT);
		createEOperation(clabjectEClass, CLABJECT___GET_FEATURE_FOR_NAME__STRING);
		createEOperation(clabjectEClass, CLABJECT___GET_POTENCY_AS_STRING);
		createEOperation(clabjectEClass, CLABJECT___GET_DISJOINT_SIBLINGS);
		createEOperation(clabjectEClass, CLABJECT___GET_ATTRIBUTE_BY_NAME__STRING);
		createEOperation(clabjectEClass, CLABJECT___VIOLATES_MULTIPLICITY_CONSTRAINTS);
		createEOperation(clabjectEClass, CLABJECT___GET_DEFINED_INHERITANCES);
		createEOperation(clabjectEClass, CLABJECT___GET_OWNED_CLABJECTS);

		featureEClass = createEClass(FEATURE);
		createEAttribute(featureEClass, FEATURE__DURABILITY);
		createEOperation(featureEClass, FEATURE___GET_CLABJECT);
		createEOperation(featureEClass, FEATURE___GET_DURABILITY_AS_STRING);
		createEOperation(featureEClass, FEATURE___REPRESENT);

		entityEClass = createEClass(ENTITY);
		createEOperation(entityEClass, ENTITY___REPRESENT);

		connectionEClass = createEClass(CONNECTION);
		createEReference(connectionEClass, CONNECTION__CONNECTION_END);
		createEOperation(connectionEClass, CONNECTION___GET_DOMAIN);
		createEOperation(connectionEClass, CONNECTION___GET_NOT_DOMAIN);
		createEOperation(connectionEClass, CONNECTION___GET_HUMAN_READABLE_NAME);
		createEOperation(connectionEClass, CONNECTION___GET_PARTICIPANTS);
		createEOperation(connectionEClass, CONNECTION___GET_MONIKER);
		createEOperation(connectionEClass, CONNECTION___GET_DOMAIN__CLABJECT);
		createEOperation(connectionEClass, CONNECTION___GET_MONIKER_FOR_PARTICIPANT__CLABJECT);
		createEOperation(connectionEClass, CONNECTION___GET_LOWER_FOR_MONIKER__STRING);
		createEOperation(connectionEClass, CONNECTION___GET_UPPER_FOR_MONIKER__STRING);
		createEOperation(connectionEClass, CONNECTION___IS_NAVIGABLE_FOR_MONIKER__STRING);
		createEOperation(connectionEClass, CONNECTION___GET_ORDER);
		createEOperation(connectionEClass, CONNECTION___GET_INHERITED_CONNECTION_END);
		createEOperation(connectionEClass, CONNECTION___GET_ALL_CONNECTION_END);
		createEOperation(connectionEClass, CONNECTION___GET_PARTICIPANT_FOR_MONIKER__STRING);
		createEOperation(connectionEClass, CONNECTION___REPRESENT);

		connectionEndEClass = createEClass(CONNECTION_END);
		createEAttribute(connectionEndEClass, CONNECTION_END__LOWER);
		createEAttribute(connectionEndEClass, CONNECTION_END__UPPER);
		createEAttribute(connectionEndEClass, CONNECTION_END__NAVIGABLE);
		createEReference(connectionEndEClass, CONNECTION_END__DESTINATION);
		createEReference(connectionEndEClass, CONNECTION_END__CONNECTION);
		createEAttribute(connectionEndEClass, CONNECTION_END__MONIKER);
		createEAttribute(connectionEndEClass, CONNECTION_END__KIND);
		createEReference(connectionEndEClass, CONNECTION_END__TYPE);
		createEReference(connectionEndEClass, CONNECTION_END__MULTIPLICITY);
		createEOperation(connectionEndEClass, CONNECTION_END___GET_HUMAN_READABLE_CONNECTION_END_NAME);
		createEOperation(connectionEndEClass, CONNECTION_END___HAS_DEFAULT_MONIKER);
		createEOperation(connectionEndEClass, CONNECTION_END___REPRESENT);
		createEOperation(connectionEndEClass, CONNECTION_END___MONIKER);
		createEOperation(connectionEndEClass, CONNECTION_END___REPRESENT_MULTIPLICITY);
		createEOperation(connectionEndEClass, CONNECTION_END___GET_CONNECTION_END_NAME);
		createEOperation(connectionEndEClass, CONNECTION_END___CONFORMS__CONNECTIONEND);

		lmlVisualizerEClass = createEClass(LML_VISUALIZER);
		createEAttribute(lmlVisualizerEClass, LML_VISUALIZER__ATTRIBUTES);
		createEReference(lmlVisualizerEClass, LML_VISUALIZER__DSL_VISUALIZER);
		createEAttribute(lmlVisualizerEClass, LML_VISUALIZER__NAME);
		createEAttribute(lmlVisualizerEClass, LML_VISUALIZER__XLOCATION);
		createEAttribute(lmlVisualizerEClass, LML_VISUALIZER__YLOCATION);
		createEAttribute(lmlVisualizerEClass, LML_VISUALIZER__WIDTH);
		createEAttribute(lmlVisualizerEClass, LML_VISUALIZER__HEIGHT);
		createEOperation(lmlVisualizerEClass, LML_VISUALIZER___GET_DEFAULT_VISUALIZATION_VALUES);
		createEOperation(lmlVisualizerEClass, LML_VISUALIZER___GET_VALUE_FOR_KEY__STRING);
		createEOperation(lmlVisualizerEClass, LML_VISUALIZER___GET_CONTAINING_ELEMENT);
		createEOperation(lmlVisualizerEClass, LML_VISUALIZER___EOPERATION0);

		propertyEClass = createEClass(PROPERTY);

		attributeEClass = createEClass(ATTRIBUTE);
		createEAttribute(attributeEClass, ATTRIBUTE__VALUE);
		createEAttribute(attributeEClass, ATTRIBUTE__MUTABILITY);
		createEAttribute(attributeEClass, ATTRIBUTE__DATATYPE);
		createEOperation(attributeEClass, ATTRIBUTE___GET_MUTABILITY_AS_STRING);
		createEOperation(attributeEClass, ATTRIBUTE___REPRESENT);
		createEOperation(attributeEClass, ATTRIBUTE___GET_POSSIBLE_DATA_TYPES);
		createEOperation(attributeEClass, ATTRIBUTE___GET_PRIMITIVE_DATA_TYPES);
		createEOperation(attributeEClass, ATTRIBUTE___GET_ENUMERATION_DATA_TYPES);
		createEOperation(attributeEClass, ATTRIBUTE___IS_ENUMERATION);
		createEOperation(attributeEClass, ATTRIBUTE___GET_ENUMERATION);
		createEOperation(attributeEClass, ATTRIBUTE___GET_LITERALS);

		methodEClass = createEClass(METHOD);
		createEAttribute(methodEClass, METHOD__BODY);
		createEReference(methodEClass, METHOD__PARAMETER);
		createEOperation(methodEClass, METHOD___REPRESENT);
		createEOperation(methodEClass, METHOD___GET_INPUT);
		createEOperation(methodEClass, METHOD___GET_OUTPUT);

		enumerationEClass = createEClass(ENUMERATION);
		createEAttribute(enumerationEClass, ENUMERATION__LITERAL);

		parameterEClass = createEClass(PARAMETER);
		createEAttribute(parameterEClass, PARAMETER__NAME);
		createEAttribute(parameterEClass, PARAMETER__EXPRESSION);
		createEAttribute(parameterEClass, PARAMETER__OUTPUT);
		createEOperation(parameterEClass, PARAMETER___GET_CLABJECT);

		clabjectParameterEClass = createEClass(CLABJECT_PARAMETER);
		createEReference(clabjectParameterEClass, CLABJECT_PARAMETER__DATATYPE);

		primitiveParameterEClass = createEClass(PRIMITIVE_PARAMETER);
		createEAttribute(primitiveParameterEClass, PRIMITIVE_PARAMETER__DATATYPE);

		multiplicityEClass = createEClass(MULTIPLICITY);
		createEAttribute(multiplicityEClass, MULTIPLICITY__LOWER);
		createEAttribute(multiplicityEClass, MULTIPLICITY__UPPER);
		createEAttribute(multiplicityEClass, MULTIPLICITY__POTENCY);
		createEReference(multiplicityEClass, MULTIPLICITY__CONNECTIONEND);

		packageEClass = createEClass(PACKAGE);
		createEReference(packageEClass, PACKAGE__CONTENT);

		abstractDSLVisualizerEClass = createEClass(ABSTRACT_DSL_VISUALIZER);
		createEAttribute(abstractDSLVisualizerEClass, ABSTRACT_DSL_VISUALIZER__INSTANCE_LEVEL);
		createEAttribute(abstractDSLVisualizerEClass, ABSTRACT_DSL_VISUALIZER__NOTATION);
		createEOperation(abstractDSLVisualizerEClass, ABSTRACT_DSL_VISUALIZER___FORMAT);

		abstractBehaviorEClass = createEClass(ABSTRACT_BEHAVIOR);
		createEAttribute(abstractBehaviorEClass, ABSTRACT_BEHAVIOR__NAME);

		abstractConstraintEClass = createEClass(ABSTRACT_CONSTRAINT);
		createEAttribute(abstractConstraintEClass, ABSTRACT_CONSTRAINT__NAME);

		// Create enums
		connectionEndKindEEnum = createEEnum(CONNECTION_END_KIND);
		classificationKindEEnum = createEEnum(CLASSIFICATION_KIND);
		complianceKindEEnum = createEEnum(COMPLIANCE_KIND);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		levelEClass.getESuperTypes().add(this.getElement());
		deepModelEClass.getESuperTypes().add(this.getElement());
		ownedElementEClass.getESuperTypes().add(this.getElement());
		correlationEClass.getESuperTypes().add(this.getOwnedElement());
		inheritanceEClass.getESuperTypes().add(this.getCorrelation());
		classificationEClass.getESuperTypes().add(this.getCorrelation());
		clabjectEClass.getESuperTypes().add(this.getOwnedElement());
		featureEClass.getESuperTypes().add(this.getElement());
		entityEClass.getESuperTypes().add(this.getClabject());
		connectionEClass.getESuperTypes().add(this.getClabject());
		connectionEndEClass.getESuperTypes().add(this.getProperty());
		attributeEClass.getESuperTypes().add(this.getFeature());
		attributeEClass.getESuperTypes().add(this.getProperty());
		methodEClass.getESuperTypes().add(this.getFeature());
		enumerationEClass.getESuperTypes().add(this.getElement());
		clabjectParameterEClass.getESuperTypes().add(this.getParameter());
		primitiveParameterEClass.getESuperTypes().add(this.getParameter());
		packageEClass.getESuperTypes().add(this.getOwnedElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(domainEClass, Domain.class, "Domain", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDomain_Name(), ecorePackage.getEString(), "name", null, 0, 1, Domain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomain_DeepModel(), this.getElement(), null, "deepModel", null, 0, -1, Domain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDomain_PlmVersion(), ecorePackage.getEString(), "plmVersion", "2.0b2", 0, 1, Domain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDomain_ComplianceKind(), this.getComplianceKind(), "complianceKind", null, 1, 1, Domain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(elementEClass, Element.class, "Element", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, Element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getElement_Visualizer(), this.getLMLVisualizer(), null, "visualizer", null, 0, -1, Element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getElement_Behavior(), this.getAbstractBehavior(), null, "behavior", null, 0, -1, Element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getElement_Constraint(), this.getAbstractConstraint(), null, "constraint", null, 0, -1, Element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(levelEClass, Level.class, "Level", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLevel_Content(), this.getOwnedElement(), null, "content", null, 0, -1, Level.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getLevel__GetAllInheritances(), this.getInheritance(), "getAllInheritances", 0, -1, IS_UNIQUE, !IS_ORDERED);

		initEOperation(getLevel__GetClabjects(), this.getClabject(), "getClabjects", 0, -1, IS_UNIQUE, !IS_ORDERED);

		initEOperation(getLevel__GetEntities(), this.getEntity(), "getEntities", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getLevel__GetConnections(), this.getConnection(), "getConnections", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getLevel__GetClassifications(), this.getClassification(), "getClassifications", 0, -1, IS_UNIQUE, !IS_ORDERED);

		initEOperation(getLevel__GetDeepModel(), this.getDeepModel(), "getDeepModel", 0, 1, IS_UNIQUE, !IS_ORDERED);

		initEOperation(getLevel__GetClassifiedLevel(), this.getLevel(), "getClassifiedLevel", 0, 1, IS_UNIQUE, !IS_ORDERED);

		initEOperation(getLevel__GetClassifyingLevel(), this.getLevel(), "getClassifyingLevel", 0, 1, IS_UNIQUE, !IS_ORDERED);

		initEOperation(getLevel__GetLevel(), ecorePackage.getEInt(), "getLevel", 0, 1, IS_UNIQUE, !IS_ORDERED);

		initEOperation(getLevel__IsRootLevel(), ecorePackage.getEBoolean(), "isRootLevel", 0, 1, IS_UNIQUE, !IS_ORDERED);

		initEOperation(getLevel__IsLeafLevel(), ecorePackage.getEBoolean(), "isLeafLevel", 0, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(deepModelEClass, DeepModel.class, "DeepModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDeepModel_Content(), this.getLevel(), null, "content", null, 0, -1, DeepModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDeepModel_Enumeration(), this.getEnumeration(), null, "enumeration", null, 0, -1, DeepModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getDeepModel__GetLevelAtIndex__int(), this.getLevel(), "getLevelAtIndex", 0, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "level", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getDeepModel__GetPrimitiveDatatypes(), ecorePackage.getEString(), "getPrimitiveDatatypes", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getDeepModel__GetRegexForPrimitiveDatatype__String(), ecorePackage.getEString(), "getRegexForPrimitiveDatatype", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "type", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getDeepModel__GetAllDatatypes(), ecorePackage.getEString(), "getAllDatatypes", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(ownedElementEClass, OwnedElement.class, "OwnedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getOwnedElement__GetLevel(), this.getLevel(), "getLevel", 0, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(correlationEClass, Correlation.class, "Correlation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(inheritanceEClass, Inheritance.class, "Inheritance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInheritance_Supertype(), this.getSupertype(), this.getSupertype_Inheritance(), "supertype", null, 1, -1, Inheritance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInheritance_Subtype(), this.getSubtype(), this.getSubtype_Inheritance(), "subtype", null, 1, -1, Inheritance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInheritance_Disjoint(), ecorePackage.getEBooleanObject(), "disjoint", null, 0, 1, Inheritance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInheritance_Complete(), ecorePackage.getEBooleanObject(), "complete", null, 0, 1, Inheritance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getInheritance__IsDisjoint(), ecorePackage.getEBoolean(), "isDisjoint", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEOperation(getInheritance__IsComplete(), ecorePackage.getEBoolean(), "isComplete", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEOperation(getInheritance__IsIntersection(), ecorePackage.getEBoolean(), "isIntersection", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEOperation(getInheritance__Represent(), ecorePackage.getEString(), "represent", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(supertypeEClass, Supertype.class, "Supertype", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSupertype_Supertype(), this.getClabject(), null, "supertype", null, 1, 1, Supertype.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSupertype_Inheritance(), this.getInheritance(), this.getInheritance_Supertype(), "inheritance", null, 0, 1, Supertype.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(subtypeEClass, Subtype.class, "Subtype", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSubtype_Subtype(), this.getClabject(), null, "subtype", null, 1, 1, Subtype.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSubtype_Inheritance(), this.getInheritance(), this.getInheritance_Subtype(), "inheritance", null, 0, 1, Subtype.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classificationEClass, Classification.class, "Classification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassification_Instance(), this.getClabject(), null, "instance", null, 1, 1, Classification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassification_Type(), this.getClabject(), null, "type", null, 1, 1, Classification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClassification_Kind(), this.getClassificationKind(), "kind", "instantiation", 1, 1, Classification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getClassification__Represent(), ecorePackage.getEString(), "represent", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(clabjectEClass, Clabject.class, "Clabject", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getClabject_Potency(), ecorePackage.getEInt(), "potency", "1", 1, 1, Clabject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClabject_LevelIndex(), ecorePackage.getEInt(), "levelIndex", null, 0, 1, Clabject.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getClabject_Content(), this.getOwnedElement(), null, "content", null, 0, -1, Clabject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClabject_Feature(), this.getFeature(), null, "feature", null, 0, -1, Clabject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getClabject__GetDeepModel(), this.getDeepModel(), "getDeepModel", 0, 1, IS_UNIQUE, !IS_ORDERED);

		initEOperation(getClabject__GetSupertypes(), this.getClabject(), "getSupertypes", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getClabject__GetSupertypes__EList(), this.getClabject(), "getSupertypes", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getClabject(), "immediateResult", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getClabject__GetDirectSupertypes(), this.getClabject(), "getDirectSupertypes", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getClabject__GetSubtypes(), this.getClabject(), "getSubtypes", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getClabject__GetHollowSubtypes(), this.getClabject(), "getHollowSubtypes", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getClabject__GetHollowSupertypes(), this.getClabject(), "getHollowSupertypes", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getClabject__GetClassificationsAsInstance(), this.getClassification(), "getClassificationsAsInstance", 0, -1, IS_UNIQUE, !IS_ORDERED);

		initEOperation(getClabject__GetClassificationsAsType(), this.getClassification(), "getClassificationsAsType", 0, -1, IS_UNIQUE, !IS_ORDERED);

		initEOperation(getClabject__GetInstances(), this.getClabject(), "getInstances", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getClabject__GetTypes(), this.getClabject(), "getTypes", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getClabject__GetDirectTypes(), this.getClabject(), "getDirectTypes", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getClabject__GetLevelTypes(), this.getClabject(), "getLevelTypes", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getClabject__GetDefinedClassificationTreeAsInstance(), this.getClabject(), "getDefinedClassificationTreeAsInstance", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getClabject__GetClassificationTreeAsInstance(), this.getClabject(), "getClassificationTreeAsInstance", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getClabject__GetDefinedInstances(), this.getClabject(), "getDefinedInstances", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getClabject__GetDefinedClassificationTreeAsType(), this.getClabject(), "getDefinedClassificationTreeAsType", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getClabject__GetClassificationTreeAsType(), this.getClabject(), "getClassificationTreeAsType", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getClabject__GetClassificationTreeAsType__int(), this.getClabject(), "getClassificationTreeAsType", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "distance", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getClabject__GetClassificationTreeAsType__int_int(), this.getClabject(), "getClassificationTreeAsType", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "min", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "max", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getClabject__GetAllFeatures(), this.getFeature(), "getAllFeatures", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getClabject__GetAllAttributes(), this.getAttribute(), "getAllAttributes", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getClabject__GetDefinedAttributes(), this.getAttribute(), "getDefinedAttributes", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getClabject__GetDefinedAttributeByName__String(), this.getAttribute(), "getDefinedAttributeByName", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getClabject__GetAllMethods(), this.getMethod(), "getAllMethods", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getClabject__GetDefinedMethods(), this.getFeature(), "getDefinedMethods", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getClabject__IsInstanceOf__Clabject(), ecorePackage.getEBoolean(), "isInstanceOf", 0, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getClabject(), "type", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getClabject__IsTypeOf__Clabject(), ecorePackage.getEBoolean(), "isTypeOf", 0, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getClabject(), "type", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getClabject__IsContainerOf__Clabject(), ecorePackage.getEBoolean(), "isContainerOf", 0, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getClabject(), "clabject", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getClabject__GetComposite(), this.getClabject(), "getComposite", 0, 1, IS_UNIQUE, !IS_ORDERED);

		initEOperation(getClabject__GetAggregates(), this.getClabject(), "getAggregates", 0, -1, IS_UNIQUE, !IS_ORDERED);

		initEOperation(getClabject__GetParts(), this.getClabject(), "getParts", 0, -1, IS_UNIQUE, !IS_ORDERED);

		op = initEOperation(getClabject__GetPartsForMoniker__String(), this.getClabject(), "getPartsForMoniker", 0, -1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getClabject__GetDefinedConnections(), this.getConnection(), "getDefinedConnections", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getClabject__GetConnections(), this.getConnection(), "getConnections", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getClabject__GetInheritedConnections(), this.getConnection(), "getInheritedConnections", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getClabject__GetLevelCompleteTypes(), this.getClabject(), "getLevelCompleteTypes", 0, -1, IS_UNIQUE, !IS_ORDERED);

		initEOperation(getClabject__GetLevelIncompleteTypes(), this.getClabject(), "getLevelIncompleteTypes", 0, -1, IS_UNIQUE, !IS_ORDERED);

		initEOperation(getClabject__GetBlueprint(), this.getClabject(), "getBlueprint", 0, 1, IS_UNIQUE, !IS_ORDERED);

		initEOperation(getClabject__GetOffspring(), this.getClabject(), "getOffspring", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getClabject__GetIsonyms(), this.getClabject(), "getIsonyms", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getClabject__GetHyponyms(), this.getClabject(), "getHyponyms", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getClabject__GetDomainForConnection__Connection(), this.getClabject(), "getDomainForConnection", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getConnection(), "connection", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getClabject__GetPossibleDomainSpecificVisualizers(), this.getAbstractDSLVisualizer(), "getPossibleDomainSpecificVisualizers", 0, -1, IS_UNIQUE, !IS_ORDERED);

		initEOperation(getClabject__GetInheritancesAsSubtype(), this.getInheritance(), "getInheritancesAsSubtype", 0, -1, IS_UNIQUE, !IS_ORDERED);

		initEOperation(getClabject__GetInheritancesAsSupertype(), this.getInheritance(), "getInheritancesAsSupertype", 0, -1, IS_UNIQUE, !IS_ORDERED);

		initEOperation(getClabject__GetDefinedNavigations(), this.getConnectionEnd(), "getDefinedNavigations", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getClabject__GetInheritedNavigations(), this.getConnectionEnd(), "getInheritedNavigations", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getClabject__GetAllNavigations(), this.getConnectionEnd(), "getAllNavigations", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getClabject__GetDomainMonikers(), ecorePackage.getEString(), "getDomainMonikers", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getClabject__GetDomainForMoniker__String(), this.getClabject(), "getDomainForMoniker", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "moniker", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getClabject__GetAllNavigationsForMoniker__String(), this.getConnectionEnd(), "getAllNavigationsForMoniker", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "moniker", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getClabject__GetAllNavigationsAsDestination(), this.getConnectionEnd(), "getAllNavigationsAsDestination", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getClabject__GetDefinedNavigationsAsDestination(), this.getConnectionEnd(), "getDefinedNavigationsAsDestination", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getClabject__GetInheritedNavigationsAsDestination(), this.getConnectionEnd(), "getInheritedNavigationsAsDestination", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getClabject__Represent(), ecorePackage.getEString(), "represent", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = initEOperation(getClabject__GetFeatureForName__String(), this.getFeature(), "getFeatureForName", 0, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getClabject__GetPotencyAsString(), ecorePackage.getEString(), "getPotencyAsString", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEOperation(getClabject__GetDisjointSiblings(), this.getClabject(), "getDisjointSiblings", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getClabject__GetAttributeByName__String(), this.getAttribute(), "getAttributeByName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getClabject__ViolatesMultiplicityConstraints(), ecorePackage.getEBoolean(), "violatesMultiplicityConstraints", 0, 1, IS_UNIQUE, !IS_ORDERED);

		initEOperation(getClabject__GetDefinedInheritances(), this.getInheritance(), "getDefinedInheritances", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getClabject__GetOwnedClabjects(), this.getClabject(), "getOwnedClabjects", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(featureEClass, Feature.class, "Feature", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFeature_Durability(), ecorePackage.getEInt(), "durability", null, 0, 1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getFeature__GetClabject(), this.getClabject(), "getClabject", 0, 1, IS_UNIQUE, !IS_ORDERED);

		initEOperation(getFeature__GetDurabilityAsString(), ecorePackage.getEString(), "getDurabilityAsString", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEOperation(getFeature__Represent(), ecorePackage.getEString(), "represent", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(entityEClass, Entity.class, "Entity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getEntity__Represent(), ecorePackage.getEString(), "represent", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(connectionEClass, Connection.class, "Connection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConnection_ConnectionEnd(), this.getConnectionEnd(), this.getConnectionEnd_Connection(), "connectionEnd", null, 0, -1, Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getConnection__GetDomain(), this.getClabject(), "getDomain", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getConnection__GetNotDomain(), this.getClabject(), "getNotDomain", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getConnection__GetHumanReadableName(), ecorePackage.getEString(), "getHumanReadableName", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEOperation(getConnection__GetParticipants(), this.getClabject(), "getParticipants", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getConnection__GetMoniker(), ecorePackage.getEString(), "getMoniker", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getConnection__GetDomain__Clabject(), this.getClabject(), "getDomain", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getClabject(), "source", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getConnection__GetMonikerForParticipant__Clabject(), ecorePackage.getEString(), "getMonikerForParticipant", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getClabject(), "source", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getConnection__GetLowerForMoniker__String(), ecorePackage.getEInt(), "getLowerForMoniker", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "rN", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getConnection__GetUpperForMoniker__String(), ecorePackage.getEInt(), "getUpperForMoniker", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "rN", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getConnection__IsNavigableForMoniker__String(), ecorePackage.getEBoolean(), "isNavigableForMoniker", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "rN", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getConnection__GetOrder(), ecorePackage.getEInt(), "getOrder", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getConnection__GetInheritedConnectionEnd(), this.getConnectionEnd(), "getInheritedConnectionEnd", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getConnection__GetAllConnectionEnd(), this.getConnectionEnd(), "getAllConnectionEnd", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getConnection__GetParticipantForMoniker__String(), this.getClabject(), "getParticipantForMoniker", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "rN", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getConnection__Represent(), ecorePackage.getEString(), "represent", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(connectionEndEClass, ConnectionEnd.class, "ConnectionEnd", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConnectionEnd_Lower(), ecorePackage.getEInt(), "lower", "0", 0, 1, ConnectionEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionEnd_Upper(), ecorePackage.getEInt(), "upper", "-1", 0, 1, ConnectionEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionEnd_Navigable(), ecorePackage.getEBoolean(), "navigable", "true", 1, 1, ConnectionEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnectionEnd_Destination(), this.getClabject(), null, "destination", null, 1, 1, ConnectionEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnectionEnd_Connection(), this.getConnection(), this.getConnection_ConnectionEnd(), "connection", null, 0, 1, ConnectionEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionEnd_Moniker(), ecorePackage.getEString(), "moniker", null, 0, 1, ConnectionEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConnectionEnd_Kind(), this.getConnectionEndKind(), "kind", "Basic", 1, 1, ConnectionEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnectionEnd_Type(), this.getConnectionEnd(), null, "type", null, 0, 1, ConnectionEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnectionEnd_Multiplicity(), this.getMultiplicity(), this.getMultiplicity_Connectionend(), "multiplicity", null, 0, -1, ConnectionEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getConnectionEnd__GetHumanReadableConnectionEndName(), ecorePackage.getEString(), "getHumanReadableConnectionEndName", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEOperation(getConnectionEnd__HasDefaultMoniker(), ecorePackage.getEBoolean(), "hasDefaultMoniker", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEOperation(getConnectionEnd__Represent(), ecorePackage.getEString(), "represent", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEOperation(getConnectionEnd__Moniker(), ecorePackage.getEString(), "moniker", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEOperation(getConnectionEnd__RepresentMultiplicity(), ecorePackage.getEString(), "representMultiplicity", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEOperation(getConnectionEnd__GetConnectionEndName(), ecorePackage.getEString(), "getConnectionEndName", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = initEOperation(getConnectionEnd__Conforms__ConnectionEnd(), ecorePackage.getEBoolean(), "conforms", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getConnectionEnd(), "connectionEnd", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(lmlVisualizerEClass, LMLVisualizer.class, "LMLVisualizer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLMLVisualizer_Attributes(), ecorePackage.getEString(), "attributes", null, 0, -1, LMLVisualizer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLMLVisualizer_DslVisualizer(), this.getAbstractDSLVisualizer(), null, "dslVisualizer", null, 0, -1, LMLVisualizer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLMLVisualizer_Name(), ecorePackage.getEString(), "name", null, 0, 1, LMLVisualizer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLMLVisualizer_XLocation(), ecorePackage.getEInt(), "xLocation", "-1", 0, 1, LMLVisualizer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLMLVisualizer_YLocation(), ecorePackage.getEInt(), "yLocation", "-1", 0, 1, LMLVisualizer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLMLVisualizer_Width(), ecorePackage.getEInt(), "width", "-1", 0, 1, LMLVisualizer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLMLVisualizer_Height(), ecorePackage.getEInt(), "height", "-1", 0, 1, LMLVisualizer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getLMLVisualizer__GetDefaultVisualizationValues(), ecorePackage.getEString(), "getDefaultVisualizationValues", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getLMLVisualizer__GetValueForKey__String(), ecorePackage.getEString(), "getValueForKey", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "key", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getLMLVisualizer__GetContainingElement(), this.getElement(), "getContainingElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getLMLVisualizer__EOperation0(), null, "EOperation0", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(propertyEClass, Property.class, "Property", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(attributeEClass, Attribute.class, "Attribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAttribute_Value(), ecorePackage.getEString(), "value", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttribute_Mutability(), ecorePackage.getEInt(), "mutability", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttribute_Datatype(), ecorePackage.getEString(), "datatype", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getAttribute__GetMutabilityAsString(), ecorePackage.getEString(), "getMutabilityAsString", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEOperation(getAttribute__Represent(), ecorePackage.getEString(), "represent", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEOperation(getAttribute__GetPossibleDataTypes(), ecorePackage.getEString(), "getPossibleDataTypes", 1, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getAttribute__GetPrimitiveDataTypes(), ecorePackage.getEString(), "getPrimitiveDataTypes", 1, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getAttribute__GetEnumerationDataTypes(), ecorePackage.getEString(), "getEnumerationDataTypes", 1, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getAttribute__IsEnumeration(), ecorePackage.getEBoolean(), "isEnumeration", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getAttribute__GetEnumeration(), this.getEnumeration(), "getEnumeration", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getAttribute__GetLiterals(), ecorePackage.getEString(), "getLiterals", 1, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(methodEClass, Method.class, "Method", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMethod_Body(), ecorePackage.getEString(), "body", null, 0, 1, Method.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMethod_Parameter(), this.getParameter(), null, "parameter", null, 0, -1, Method.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getMethod__Represent(), ecorePackage.getEString(), "represent", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEOperation(getMethod__GetInput(), this.getParameter(), "getInput", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getMethod__GetOutput(), this.getParameter(), "getOutput", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(enumerationEClass, Enumeration.class, "Enumeration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEnumeration_Literal(), ecorePackage.getEString(), "literal", null, 0, -1, Enumeration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterEClass, Parameter.class, "Parameter", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParameter_Name(), ecorePackage.getEString(), "name", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameter_Expression(), ecorePackage.getEString(), "expression", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameter_Output(), ecorePackage.getEBoolean(), "output", "false", 1, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getParameter__GetClabject(), this.getClabject(), "getClabject", 0, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(clabjectParameterEClass, ClabjectParameter.class, "ClabjectParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClabjectParameter_Datatype(), this.getClabject(), null, "datatype", null, 1, 1, ClabjectParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(primitiveParameterEClass, PrimitiveParameter.class, "PrimitiveParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPrimitiveParameter_Datatype(), ecorePackage.getEString(), "datatype", null, 1, 1, PrimitiveParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multiplicityEClass, Multiplicity.class, "Multiplicity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMultiplicity_Lower(), ecorePackage.getEInt(), "lower", "0", 0, 1, Multiplicity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMultiplicity_Upper(), ecorePackage.getEInt(), "upper", "-1", 0, 1, Multiplicity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMultiplicity_Potency(), ecorePackage.getEInt(), "potency", "1", 1, 1, Multiplicity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMultiplicity_Connectionend(), this.getConnectionEnd(), this.getConnectionEnd_Multiplicity(), "connectionend", null, 0, 1, Multiplicity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(packageEClass, org.melanee.core.models.plm.PLM.Package.class, "Package", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPackage_Content(), this.getOwnedElement(), null, "content", null, 0, -1, org.melanee.core.models.plm.PLM.Package.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractDSLVisualizerEClass, AbstractDSLVisualizer.class, "AbstractDSLVisualizer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractDSLVisualizer_InstanceLevel(), ecorePackage.getEBoolean(), "instanceLevel", "false", 1, 1, AbstractDSLVisualizer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractDSLVisualizer_Notation(), ecorePackage.getEString(), "notation", null, 0, 1, AbstractDSLVisualizer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getAbstractDSLVisualizer__Format(), ecorePackage.getEString(), "format", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(abstractBehaviorEClass, AbstractBehavior.class, "AbstractBehavior", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractBehavior_Name(), ecorePackage.getEString(), "name", null, 0, 1, AbstractBehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractConstraintEClass, AbstractConstraint.class, "AbstractConstraint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractConstraint_Name(), ecorePackage.getEString(), "name", null, 0, 1, AbstractConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(connectionEndKindEEnum, ConnectionEndKind.class, "ConnectionEndKind");
		addEEnumLiteral(connectionEndKindEEnum, ConnectionEndKind.BASIC);
		addEEnumLiteral(connectionEndKindEEnum, ConnectionEndKind.AGGREGATION);
		addEEnumLiteral(connectionEndKindEEnum, ConnectionEndKind.COMPOSITION);

		initEEnum(classificationKindEEnum, ClassificationKind.class, "ClassificationKind");
		addEEnumLiteral(classificationKindEEnum, ClassificationKind.INSTANCE);
		addEEnumLiteral(classificationKindEEnum, ClassificationKind.ISONYM);
		addEEnumLiteral(classificationKindEEnum, ClassificationKind.HYPONYM);
		addEEnumLiteral(classificationKindEEnum, ClassificationKind.INSTANTIATION);

		initEEnum(complianceKindEEnum, ComplianceKind.class, "ComplianceKind");
		addEEnumLiteral(complianceKindEEnum, ComplianceKind.MELANEE);
		addEEnumLiteral(complianceKindEEnum, ComplianceKind.META_DEPTH);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http://melanee.org/PLM/Datatypes
		createDatatypesAnnotations();
		// http://melanee.org/PLM/Version
		createVersionAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore/OCL
		createOCLAnnotations();
		// Comment
		createCommentAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "invocationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL",
			 "settingDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL",
			 "validationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://melanee.org/PLM/Datatypes</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createDatatypesAnnotations() {
		String source = "http://melanee.org/PLM/Datatypes";	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "String", ".*",
			 "Real", "-?\\d*(\\.\\d*)?",
			 "Integer", "-?\\d*",
			 "Natural", "\\d*",
			 "Boolean", "true|false",
			 "Character", ".",
			 "Percent", "\\d{1,3}(\\.\\d*)?",
			 "Probability", "0?\\.(\\d*)?",
			 "Money", "-?\\d*(\\.\\d{1,2})?",
			 "void", ""
		   });
	}

	/**
	 * Initializes the annotations for <b>http://melanee.org/PLM/Version</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createVersionAnnotations() {
		String source = "http://melanee.org/PLM/Version";	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "plmVersion", "2.1"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore/OCL</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createOCLAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore/OCL";	
		addAnnotation
		  (getLevel__GetAllInheritances(), 
		   source, 
		   new String[] {
			 "body", "self.content->select(e|e.oclIsKindOf(Inheritance))->collect(g | g.oclAsType(Inheritance))->asSet()"
		   });	
		addAnnotation
		  (getLevel__GetClabjects(), 
		   source, 
		   new String[] {
			 "body", "self.content->select(e|e.oclIsKindOf(Clabject))->collect(g | g.oclAsType(Clabject))->asSet()"
		   });	
		addAnnotation
		  (getLevel__GetEntities(), 
		   source, 
		   new String[] {
			 "body", "self.content->select(e|e.oclIsKindOf(Entity))->collect(g | g.oclAsType(Entity))->asOrderedSet()"
		   });	
		addAnnotation
		  (getLevel__GetConnections(), 
		   source, 
		   new String[] {
			 "body", "self.content->select(e|e.oclIsKindOf(Connection))->collect(g | g.oclAsType(Connection))->asOrderedSet()"
		   });	
		addAnnotation
		  (getLevel__GetClassifications(), 
		   source, 
		   new String[] {
			 "body", "self.content->select(e|e.oclIsKindOf(Classification))->collect(g | g.oclAsType(Classification))->asSet()"
		   });	
		addAnnotation
		  (getLevel__GetDeepModel(), 
		   source, 
		   new String[] {
			 "body", "if(self.oclAsType(ecore::EObject).eContainer().oclIsUndefined()) then\r\nnull\r\nelse \r\nself.oclAsType(ecore::EObject).eContainer().oclAsType(DeepModel)\r\nendif"
		   });	
		addAnnotation
		  (getLevel__GetClassifiedLevel(), 
		   source, 
		   new String[] {
			 "body", "if (self.getDeepModel().content->indexOf(self) = self.getDeepModel().content->size()) then\n\tnull\nelse\n\tself.getDeepModel().content->at(self.getDeepModel().content->indexOf(self) + 1)\nendif"
		   });	
		addAnnotation
		  (getLevel__GetClassifyingLevel(), 
		   source, 
		   new String[] {
			 "body", "if (self.getDeepModel().content->indexOf(self) = 1) then\n\tnull\nelse\n\tself.getDeepModel().content->at(self.getDeepModel().content->indexOf(self) - 1)\nendif"
		   });	
		addAnnotation
		  (getLevel__GetLevel(), 
		   source, 
		   new String[] {
			 "body", "self.getDeepModel().content->indexOf(self)-1"
		   });	
		addAnnotation
		  (getLevel__IsRootLevel(), 
		   source, 
		   new String[] {
			 "body", "self.getDeepModel().content->indexOf(self) = 1"
		   });	
		addAnnotation
		  (getLevel__IsLeafLevel(), 
		   source, 
		   new String[] {
			 "body", "self.getDeepModel().content->indexOf(self) = self.getDeepModel().content->size()"
		   });	
		addAnnotation
		  (getDeepModel__GetLevelAtIndex__int(), 
		   source, 
		   new String[] {
			 "body", "if level > 0 and level <= self.content->size() then\r\n\tself.content->at(level)\r\nelse\r\n\tnull\r\nendif"
		   });	
		addAnnotation
		  (getDeepModel__GetPrimitiveDatatypes(), 
		   source, 
		   new String[] {
			 "body", "self.oclAsType(ecore::EObject).eClass().ePackage.getEAnnotation(\'http://melanee.org/PLM/Datatypes\').details.key->asOrderedSet()"
		   });	
		addAnnotation
		  (getDeepModel__GetRegexForPrimitiveDatatype__String(), 
		   source, 
		   new String[] {
			 "body", "if (self.oclAsType(ecore::EObject).eClass().ePackage.getEAnnotation(\'http://melanee.org/PLM/Datatypes\').details->select(e | e.key = type)->size() = 1) then\r\n\tself.oclAsType(ecore::EObject).eClass().ePackage.getEAnnotation(\'http://melanee.org/PLM/Datatypes\').details->select(e | e.key = type).value->first()\r\nelse\r\n\tnull\r\nendif"
		   });	
		addAnnotation
		  (getDeepModel__GetAllDatatypes(), 
		   source, 
		   new String[] {
			 "body", "self.getPrimitiveDatatypes()->asSequence()->union(self.enumeration.name)->asOrderedSet()"
		   });	
		addAnnotation
		  (getOwnedElement__GetLevel(), 
		   source, 
		   new String[] {
			 "body", "let parent:ecore::EObject = \r\n\tself.oclAsType(ecore::EObject).eContainer()\r\nin\r\n\tif (parent.oclIsUndefined()) then\r\n\t\tnull\r\n\telse\r\n\t\tif (parent.oclIsTypeOf(Level)) then\r\n\t\t\tparent.oclAsType(Level)\r\n\t\telse\r\n\t\t\tif (parent.oclIsKindOf(Clabject)) then\r\n\t\t\t\tparent.oclAsType(Clabject).getLevel()\r\n\t\t\telse\r\n\t\t\t\tif (parent.oclIsKindOf(Package)) then\r\n\t\t\t\t\tparent.oclAsType(Package).getLevel()\r\n\t\t\t\telse\r\n\t\t\t\t\tnull\r\n\t\t\t\tendif\r\n\t\t\tendif\r\n\t\tendif\r\n\tendif"
		   });	
		addAnnotation
		  (getInheritance__IsDisjoint(), 
		   source, 
		   new String[] {
			 "body", "not (self.disjoint.oclIsUndefined() or self.disjoint = false)"
		   });	
		addAnnotation
		  (getInheritance__IsComplete(), 
		   source, 
		   new String[] {
			 "body", "not (self.complete.oclIsUndefined() or self.complete = false)"
		   });	
		addAnnotation
		  (getInheritance__IsIntersection(), 
		   source, 
		   new String[] {
			 "body", "not (self.intersection.oclIsUndefined() or self.intersection = false)"
		   });	
		addAnnotation
		  (getInheritance__Represent(), 
		   source, 
		   new String[] {
			 "body", "if self.name.oclIsUndefined() or self.name = \'\' then\r\n\r\nlet superT : String = self.supertype->iterate(s:Clabject; res:String=\'\'| \r\n\t\tres.concat(s.represent()).concat(\',\')\r\n\t) \r\nin\r\n\r\nlet subT : String = self.subtype->iterate(s:Clabject; res:String=\'\'| \r\n\t\tres.concat(s.represent()).concat(\',\')\r\n\t)\r\nin\r\n\'[\'.concat(superT.substring(1,superT.size()-1))\r\n.concat(\']<-[\').concat(subT.substring(1,subT.size()-1)).concat(\']\')\r\n\r\nelse \r\n\tself.name\r\nendif"
		   });	
		addAnnotation
		  (getClassification__Represent(), 
		   source, 
		   new String[] {
			 "body", "self.instance.represent().concat(\'->\').concat(self.type.represent())"
		   });	
		addAnnotation
		  (getClabject__GetDeepModel(), 
		   source, 
		   new String[] {
			 "body", "if(self.getLevel().oclIsUndefined())\r\nthen null\r\nelse \r\nself.getLevel().getDeepModel()\r\nendif"
		   });	
		addAnnotation
		  (getClabject__GetSupertypes(), 
		   source, 
		   new String[] {
			 "body", "let directResult:OrderedSet(Clabject) =\r\n\tself.getDirectSupertypes()->asOrderedSet()\r\nin\r\n--Start recursion\r\ndirectResult->iterate(c:Clabject; type:OrderedSet(Clabject) = directResult|\r\n\ttype->union(c.getSupertypes(directResult))->asOrderedSet()\r\n)"
		   });	
		addAnnotation
		  (getClabject__GetSupertypes__EList(), 
		   source, 
		   new String[] {
			 "body", "let directResult:OrderedSet(Clabject) =\r\n\tself.getDirectSupertypes()->asOrderedSet()\r\nin\r\n--Start recursion\r\ndirectResult->iterate(c:Clabject; type:OrderedSet(Clabject) = directResult|\r\n\tif (immediateResult->includes(c)) then\r\n\t\ttype\r\n\telse\r\n\t\ttype->union(c.getSupertypes(immediateResult->union(directResult)->asOrderedSet()))->asOrderedSet()\r\n\tendif\r\n)"
		   });	
		addAnnotation
		  (getClabject__GetDirectSupertypes(), 
		   source, 
		   new String[] {
			 "body", "Inheritance.allInstances()->select(i | i.subtype.subtype->includes(self)).supertype.supertype->flatten()->asOrderedSet()"
		   });	
		addAnnotation
		  (getClabject__GetSubtypes(), 
		   source, 
		   new String[] {
			 "body", "let directResult:OrderedSet(Clabject) =\r\n\tInheritance.allInstances()->select(g | g.supertype.supertype->includes(self)).subtype.subtype->flatten()->asOrderedSet()\r\nin\r\n--Start recursion\r\ndirectResult->iterate(c:Clabject; type:OrderedSet(Clabject) = directResult|\r\n\ttype->union(c.getSubtypes())->asOrderedSet()\r\n)"
		   });	
		addAnnotation
		  (getClabject__GetHollowSubtypes(), 
		   source, 
		   new String[] {
			 "body", "getSubtypes()->select(st | st.feature->forAll(f | self.feature->one(selfF | selfF.name = f.name)))"
		   });	
		addAnnotation
		  (getClabject__GetHollowSupertypes(), 
		   source, 
		   new String[] {
			 "body", "getSupertypes()->select(st | self.feature->forAll(f | st.feature->one(selfF | selfF.name = f.name)))"
		   });	
		addAnnotation
		  (getClabject__GetClassificationsAsInstance(), 
		   source, 
		   new String[] {
			 "body", "Classification.allInstances()->select(i|i.instance = self)"
		   });	
		addAnnotation
		  (getClabject__GetClassificationsAsType(), 
		   source, 
		   new String[] {
			 "body", "Classification.allInstances()->select(i|i.type = self)"
		   });	
		addAnnotation
		  (getClabject__GetInstances(), 
		   source, 
		   new String[] {
			 "body", "self.getClassificationsAsType().instance->asOrderedSet()"
		   });	
		addAnnotation
		  (getClabject__GetTypes(), 
		   source, 
		   new String[] {
			 "body", "let directTypes:OrderedSet(Clabject) = self.getClassificationsAsInstance().type->asOrderedSet()\r\nin\r\n\tdirectTypes->union(directTypes.getSupertypes()->asOrderedSet())->asOrderedSet()"
		   });	
		addAnnotation
		  (getClabject__GetDirectTypes(), 
		   source, 
		   new String[] {
			 "body", "self.getClassificationsAsInstance().type->asOrderedSet()\r\n"
		   });	
		addAnnotation
		  (getClabject__GetLevelTypes(), 
		   source, 
		   new String[] {
			 "body", "self.getClassificationsAsInstance().type->union(self.getClassificationsAsInstance().type.getSupertypes())->asOrderedSet()"
		   });	
		addAnnotation
		  (getClabject__GetDefinedClassificationTreeAsInstance(), 
		   source, 
		   new String[] {
			 "body", "let directResult:OrderedSet(Clabject) = \r\n\tself.getLevelTypes()->asOrderedSet()\r\nin\r\n\tdirectResult->union(directResult.getTypes()->asOrderedSet())->asOrderedSet()"
		   });	
		addAnnotation
		  (getClabject__GetClassificationTreeAsInstance(), 
		   source, 
		   new String[] {
			 "body", "let directResult:OrderedSet(Clabject) = \r\n\tself.getSupertypes()->append(self).getTypes()->asOrderedSet()\r\nin\r\n\tdirectResult->union(directResult.getTypes()->asOrderedSet())->asOrderedSet()"
		   });	
		addAnnotation
		  (getClabject__GetDefinedInstances(), 
		   source, 
		   new String[] {
			 "body", "self.getClassificationsAsType().instance->union(self.getClassificationsAsType().instance.getSubtypes())->asOrderedSet()"
		   });	
		addAnnotation
		  (getClabject__GetDefinedClassificationTreeAsType(), 
		   source, 
		   new String[] {
			 "body", "let directResult:OrderedSet(Clabject) = \r\n\tself.getDefinedInstances()->asOrderedSet()\r\nin\r\n\tdirectResult->union(directResult.getInstances()->asOrderedSet())->asOrderedSet()"
		   });	
		addAnnotation
		  (getClabject__GetClassificationTreeAsType(), 
		   source, 
		   new String[] {
			 "body", "let directResult:OrderedSet(Clabject) = \r\n\tself.getSubtypes().getInstances()->asOrderedSet()->union(self.getInstances())->asOrderedSet()\r\nin\r\n\tdirectResult->union(directResult.getInstances()->asOrderedSet())->asOrderedSet()"
		   });	
		addAnnotation
		  (getClabject__GetClassificationTreeAsType__int(), 
		   source, 
		   new String[] {
			 "body", "let classificationTree:OrderedSet(Clabject) =\r\n\tself.getClassificationTreeAsType()\r\nin\r\n-- first find instances at level with relative distance\r\nlet instances:OrderedSet(Clabject)  =\r\n\tclassificationTree->select(i : Clabject | i.level - self.level = distance)\r\nin\r\n-- if relative distance did not have a result take the most concrete instances\r\nif (distance = -1 or instances->size() = 0) then\r\n\tlet maxLevel:Integer =\r\n\t\tclassificationTree.level->max()\r\n\tin\r\n\tclassificationTree->select(c | c.level = maxLevel)\r\nelse\r\n\t\tinstances\r\nendif"
		   });	
		addAnnotation
		  (getClabject__GetClassificationTreeAsType__int_int(), 
		   source, 
		   new String[] {
			 "body", "let classificationTree:OrderedSet(Clabject) =\r\n\tself.getClassificationTreeAsType()\r\nin\r\n-- first find instances at level with relative distance\r\nlet instances:OrderedSet(Clabject)  =\r\n\tclassificationTree->select(i : Clabject |  i.level - self.level >= min and  (i.level - self.level <= max or max = -1))\r\nin\r\n-- if relative distance did not have a result take the most concrete instances\r\nif (instances->size() = 0) then\r\n\tlet maxLevel:Integer =\r\n\t\tclassificationTree.level->max()\r\n\tin\r\n\tclassificationTree->select(c | c.level = maxLevel)\r\nelse\r\n\t\tinstances\r\nendif"
		   });	
		addAnnotation
		  (getClabject__GetAllFeatures(), 
		   source, 
		   new String[] {
			 "body", "let features:OrderedSet(Feature) =  \r\n\tself.getSupertypes()->including(self).feature->asOrderedSet()\r\nin\r\n\tfeatures\r\n\t\t\t->select(f | features\r\n\t\t\t\t->excluding(f)\r\n\t\t\t\t\t->forAll(f2 | f.name = f2.name implies not f.getClabject().getSubtypes()->includes(f2.getClabject())))->asOrderedSet()"
		   });	
		addAnnotation
		  (getClabject__GetAllAttributes(), 
		   source, 
		   new String[] {
			 "body", "self.getAllFeatures()->select(f | f.oclIsTypeOf(Attribute)).oclAsType(Attribute)->asOrderedSet()"
		   });	
		addAnnotation
		  (getClabject__GetDefinedAttributes(), 
		   source, 
		   new String[] {
			 "body", "self.feature->select(f | f.oclIsKindOf(Attribute)).oclAsType(Attribute)->asOrderedSet()"
		   });	
		addAnnotation
		  (getClabject__GetDefinedAttributeByName__String(), 
		   source, 
		   new String[] {
			 "body", "self.feature->select(f | f.oclIsKindOf(Attribute)).oclAsType(Attribute)->select(f | f.name = name)->first()"
		   });	
		addAnnotation
		  (getClabject__GetAllMethods(), 
		   source, 
		   new String[] {
			 "body", "self.getAllFeatures()->select(f | f.oclIsTypeOf(Method)).oclAsType(Method)->asOrderedSet()"
		   });	
		addAnnotation
		  (getClabject__GetDefinedMethods(), 
		   source, 
		   new String[] {
			 "body", "self.feature->select(f | f.oclIsKindOf(Method))->asOrderedSet()"
		   });	
		addAnnotation
		  (getClabject__IsInstanceOf__Clabject(), 
		   source, 
		   new String[] {
			 "body", "type.getInstances()->includes(self)"
		   });	
		addAnnotation
		  (getClabject__IsTypeOf__Clabject(), 
		   source, 
		   new String[] {
			 "body", "self.getTypes() -> includes(type)"
		   });	
		addAnnotation
		  (getClabject__IsContainerOf__Clabject(), 
		   source, 
		   new String[] {
			 "body", "clabject.getComposite()->includes(self)"
		   });	
		addAnnotation
		  (getClabject__GetComposite(), 
		   source, 
		   new String[] {
			 "body", "let containers:OrderedSet(Clabject) =\r\n\tself.getConnections().connectionEnd->select(p | p.destination <> self and  p.kind = ConnectionEndKind::Composition).destination->asOrderedSet()\r\nin\r\n\t--no container found return null\r\n\tif (containers->size() = 0) then\r\n\t\tnull\r\n\t--return the container\r\n \telse\r\n\t\tcontainers->any(true)\r\n\tendif"
		   });	
		addAnnotation
		  (getClabject__GetAggregates(), 
		   source, 
		   new String[] {
			 "body", "let containers:OrderedSet(Clabject) =\r\n\tself.getConnections().connectionEnd->select(p | p.destination <> self and  p.kind = ConnectionEndKind::Aggregation).destination->asOrderedSet()\r\nin\r\n\t--no container found return null\r\n\tif (containers->size() = 0) then\r\n\t\tOrderedSet(Element){}\r\n\t--return the container\r\n \telse\r\n\t\tcontainers->asOrderedSet()\r\n\tendif"
		   });	
		addAnnotation
		  (getClabject__GetParts(), 
		   source, 
		   new String[] {
			 "body", "--ConnectionEnds taking part in\r\nlet connectionEnds : Set(ConnectionEnd) = \r\n\tself.getConnections().connectionEnd->select(p | p.destination = self and (p.kind = ConnectionEndKind::Composition or p.kind = ConnectionEndKind::Aggregation) )->asOrderedSet()\r\nin\r\n\tconnectionEnds.connection.connectionEnd->select(p | p.destination <> self).destination->asOrderedSet()"
		   });	
		addAnnotation
		  (getClabject__GetPartsForMoniker__String(), 
		   source, 
		   new String[] {
			 "body", "--ConnectionEnds taking part in\r\nlet connectionEnds : Set(ConnectionEnd) = \r\n\tself.getConnections().connectionEnd->select(p | p.destination = self and (p.kind = ConnectionEndKind::Composition or p.kind = ConnectionEndKind::Aggregation) )->asOrderedSet()\r\nin\r\n\tconnectionEnds.connection.connectionEnd->select(p | p.destination <> self and p.moniker = name).destination->asOrderedSet()"
		   });	
		addAnnotation
		  (getClabject__GetDefinedConnections(), 
		   source, 
		   new String[] {
			 "body", "ConnectionEnd.allInstances()->select(r | r.destination = self).connection->asOrderedSet()"
		   });	
		addAnnotation
		  (getClabject__GetConnections(), 
		   source, 
		   new String[] {
			 "body", "self.getInheritedConnections()->union(self.getDefinedConnections())->asOrderedSet()"
		   });	
		addAnnotation
		  (getClabject__GetInheritedConnections(), 
		   source, 
		   new String[] {
			 "body", "self.getSupertypes().getDefinedConnections()->asOrderedSet()"
		   });	
		addAnnotation
		  (getClabject__GetLevelCompleteTypes(), 
		   source, 
		   new String[] {
			 "body", "self.getClassificationsAsInstance()->select((kind= ClassificationKind::isonym) or (kind= ClassificationKind::instantiation)).type->asSet()"
		   });	
		addAnnotation
		  (getClabject__GetLevelIncompleteTypes(), 
		   source, 
		   new String[] {
			 "body", "self.getClassificationsAsInstance()->select(kind= ClassificationKind::hyponym).type->asSet()"
		   });	
		addAnnotation
		  (getClabject__GetBlueprint(), 
		   source, 
		   new String[] {
			 "body", "let blueprints:OrderedSet(Clabject) = \r\n\tself.getClassificationsAsInstance()->select(c | c.kind= ClassificationKind::instantiation).type->asOrderedSet()\r\nin\r\n\tif blueprints->size() > 0 then \r\n\t\tblueprints->first() \r\n\telse \r\n\t\tnull \r\n\tendif"
		   });	
		addAnnotation
		  (getClabject__GetOffspring(), 
		   source, 
		   new String[] {
			 "body", "self.getClassificationsAsType()->select(c | c.kind = ClassificationKind::instantiation).instance->asOrderedSet()"
		   });	
		addAnnotation
		  (getClabject__GetIsonyms(), 
		   source, 
		   new String[] {
			 "body", "self.getClassificationsAsType()->select(c | c.kind = ClassificationKind::isonym).instance->asOrderedSet()"
		   });	
		addAnnotation
		  (getClabject__GetHyponyms(), 
		   source, 
		   new String[] {
			 "body", "self.getClassificationsAsType()->select(c | c.kind = ClassificationKind::hyponym).instance->asOrderedSet()"
		   });	
		addAnnotation
		  (getClabject__GetDomainForConnection__Connection(), 
		   source, 
		   new String[] {
			 "body", "connection.getDomain(self)"
		   });	
		addAnnotation
		  (getClabject__GetPossibleDomainSpecificVisualizers(), 
		   source, 
		   new String[] {
			 "body", "--At first we look if a visualization descriptor is directly attached\r\nlet possibleVisualization:Set(AbstractDSLVisualizer) = \r\n\tself.visualizer.dslVisualizer->asSet()\r\nin\r\n--Now look at the superTypes if nothing is directly found\r\nlet possibleVisualizationOfLevelSupertypes:Set(AbstractDSLVisualizer) =\r\n\tif (possibleVisualization->size() = 0) then\r\n\t\tself.getSupertypes().visualizer.dslVisualizer->asSet()\r\n\telse\r\n\t\tpossibleVisualization\r\n\tendif\r\nin\r\n--Look at the level types if nothing is found\r\nif (possibleVisualizationOfLevelSupertypes->size() = 0) then\r\n\tself.getTypes().getPossibleDomainSpecificVisualizers()->asSet()\r\nelse\r\n\tpossibleVisualizationOfLevelSupertypes\r\nendif"
		   });	
		addAnnotation
		  (getClabject__GetInheritancesAsSubtype(), 
		   source, 
		   new String[] {
			 "body", "Inheritance.allInstances()->select(g|g.subtype.subtype->includes(self))"
		   });	
		addAnnotation
		  (getClabject__GetInheritancesAsSupertype(), 
		   source, 
		   new String[] {
			 "body", "Inheritance.allInstances()->select(g|g.supertype.supertype->includes(self))"
		   });	
		addAnnotation
		  (getClabject__GetDefinedNavigations(), 
		   source, 
		   new String[] {
			 "body", "let allConnections:OrderedSet(Connection)=\r\nConnection.allInstances()->select(c | c.getParticipants()->includes(self))->asOrderedSet()\r\nin\r\nallConnections->collect(c| if c.connectionEnd->select(r|r.destination=self)->size() = 1 then \r\n\tc.connectionEnd->reject(r|r.destination=self) else c.connectionEnd endif\r\n)->reject(p | not p.navigable)->asOrderedSet()->sortedBy(r | r.moniker())"
		   });	
		addAnnotation
		  (getClabject__GetInheritedNavigations(), 
		   source, 
		   new String[] {
			 "body", "self.getSupertypes()->iterate(\nsuper;\nres : OrderedSet(ConnectionEnd)= OrderedSet{} |\nres->union(super.getDefinedNavigations())->asOrderedSet()\n)"
		   });	
		addAnnotation
		  (getClabject__GetAllNavigations(), 
		   source, 
		   new String[] {
			 "body", "self.getDefinedNavigations()->union(self.getInheritedNavigations())->asOrderedSet()"
		   });	
		addAnnotation
		  (getClabject__GetDomainMonikers(), 
		   source, 
		   new String[] {
			 "body", "self.getAllNavigations().moniker()->asOrderedSet()"
		   });	
		addAnnotation
		  (getClabject__GetDomainForMoniker__String(), 
		   source, 
		   new String[] {
			 "body", "self.getDirectSupertypes()->collect(getDomainForMoniker(moniker))->asOrderedSet()->union(\r\n\tself.getDefinedNavigations()->select(r|r.moniker() = moniker).destination->asOrderedSet()\r\n)->asOrderedSet()"
		   });	
		addAnnotation
		  (getClabject__GetAllNavigationsForMoniker__String(), 
		   source, 
		   new String[] {
			 "body", "self.getAllNavigations()->select(r | r.moniker() = moniker)->asOrderedSet()"
		   });	
		addAnnotation
		  (getClabject__GetAllNavigationsAsDestination(), 
		   source, 
		   new String[] {
			 "body", "self.getDefinedNavigationsAsDestination()->union(self.getInheritedNavigationsAsDestination())->asOrderedSet()"
		   });	
		addAnnotation
		  (getClabject__GetDefinedNavigationsAsDestination(), 
		   source, 
		   new String[] {
			 "body", "ConnectionEnd.allInstances()->select(destination = self)->asOrderedSet()"
		   });	
		addAnnotation
		  (getClabject__GetInheritedNavigationsAsDestination(), 
		   source, 
		   new String[] {
			 "body", "ConnectionEnd.allInstances()->select(r| self.getSupertypes()->includes(r.destination))->asOrderedSet()"
		   });	
		addAnnotation
		  (getClabject__Represent(), 
		   source, 
		   new String[] {
			 "body", "if self.oclIsTypeOf(Connection) then \r\n\tself.oclAsType(Connection).represent() \r\nelse \r\n\tself.oclAsType(Entity).represent() \r\nendif"
		   });	
		addAnnotation
		  (getClabject__GetFeatureForName__String(), 
		   source, 
		   new String[] {
			 "body", "if self.getAllFeatures()->select(f|f.name = name)->size() = 0 then \r\n\tnull\r\nelse\r\n\tself.getAllFeatures()->select(f|f.name = name)->asOrderedSet()->first()\r\nendif"
		   });	
		addAnnotation
		  (getClabject__GetPotencyAsString(), 
		   source, 
		   new String[] {
			 "body", "if (self.potency > 0) then OrderedSet{1000000, 100000, 10000, 1000, 100, 10, 1}->iterate(\r\n\tdenominator : Integer; s : String = \'\'|\r\n\t\tlet numberAsString : String = \r\n\t\t\tOrderedSet{\'0\',\'1\',\'2\',\'3\',\'4\',\'5\',\'6\',\'7\',\'8\',\'9\'}->at(self.potency.div(denominator).mod(10) + 1)\r\n\t\tin\r\n\t\tif s=\'\' and numberAsString = \'0\' then\r\n\t\t\ts\r\n\t\telse\r\n\t\t\ts.concat(numberAsString)\r\n\t\tendif\r\n\t)\r\nelse\r\n\tif (self.potency = 0) then\r\n\t\t\'0\'\r\n\telse\r\n\t\t\'*\'\r\n\tendif\r\nendif\r\n\r\n"
		   });	
		addAnnotation
		  (getClabject__GetDisjointSiblings(), 
		   source, 
		   new String[] {
			 "body", "let siblings:OrderedSet(Clabject) = \r\n\t--get all disjoint generalizations in which self participates\r\n\tself.getInheritancesAsSubtype()->reject(i | i.disjoint = null or not i.disjoint)\r\n\t--from these disjoint generalization get all subtypes except self\r\n\t.subtype.subtype->reject(s | s=self)->asOrderedSet()\r\n\r\nin \r\nsiblings->union(\r\n\tsiblings->collect(s | s.getSubtypes())->asOrderedSet()\r\n)->union(\r\n\tself.getSupertypes()->reject(super | super = self)->collect(super | super.getDisjointSiblings())->asOrderedSet()\r\n)->asOrderedSet()"
		   });	
		addAnnotation
		  (getClabject__GetAttributeByName__String(), 
		   source, 
		   new String[] {
			 "body", "let foundAttributes:OrderedSet(Attribute) =\t\r\n\tself.getAllAttributes()->select(a | a.name = name)\r\nin \r\n\tif (foundAttributes->size() > 0) then \r\n\t\tfoundAttributes->first()\r\n\telse\r\n\t\tnull\r\n\tendif"
		   });	
		addAnnotation
		  (getClabject__ViolatesMultiplicityConstraints(), 
		   source, 
		   new String[] {
			 "body", "--Type-level connections are needed to check constrainsts againt\r\nlet typeLevelConnections:OrderedSet(Connection) =\r\n\tself.getTypes().getConnections()->asOrderedSet()\r\nin\r\n--Connections at instance levels are validated\r\nlet instanceLevelConnections:OrderedSet(Connection) =\r\n\tself.getConnections()\r\nin\r\n\t--Special case is if a clabject does not have any connections\r\n\tif instanceLevelConnections->size() = 0 then\r\n\t\t\t--The connectionEnds which are pointing to the wrong end are not interesting\r\n\t\t\tlet relevantTypeConnectionEnds : OrderedSet(ConnectionEnd) =\r\n\t\t\t\tif (typeLevelConnections->one(c : Connection  |  c.connectionEnd->select(p : ConnectionEnd | p.destination = c)->size() > 1)) then\r\n\t\t\t\t\t--Has anyone ever seen a self connection with lower = 0 on both sides?\r\n\t\t\t\t\ttypeLevelConnections.connectionEnd->asOrderedSet()\r\n\t\t\t\telse\r\n\t\t\t\t\t--Reject the connectionEnds which show to an type of this clabject\r\n\t\t\t\t\ttypeLevelConnections.connectionEnd->select(p : ConnectionEnd | p.destination.getInstances()->excludes(self))->asOrderedSet()\r\n\t\t\t\tendif\r\n\t\t\tin\r\n\t\t\t\trelevantTypeConnectionEnds->size() > 0 and relevantTypeConnectionEnds.lower->sum() > 0\r\n\telse\r\n\t\tnot(\r\n\t\t\t--For all connections at the type level constraints must be valid at instance level\r\n\t\t\ttypeLevelConnections->forAll(typeConnection : Connection | \r\n\t\t\t\t--All Connections that belong to checked type Connection\r\n\t\t\t\tlet relevantInstanceLevelConnections:OrderedSet(Connection)=\r\n\t\t\t\t\tinstanceLevelConnections->select(c : Connection | c.getTypes()->includes(typeConnection))\r\n\t\t\t\tin\r\n\t\t\t\t--Get the connectionEnds connected to the instance connections\r\n\t\t\t\tlet relevantInstanceConnectionEnds:OrderedSet(ConnectionEnd) = \r\n\t\t\t\t\trelevantInstanceLevelConnections.connectionEnd->select(p : ConnectionEnd | p.destination <> self)->asOrderedSet()\r\n\t\t\t\tin\r\n\t\t\t\t--For self connections it is filtered by navigability\r\n\t\t\t\tlet relevantTypeConnectionEnd:ConnectionEnd =\r\n\t\t\t\t\t--Is the code executed on a self connection at the type level?\r\n\t\t\t\t\tif typeConnection.connectionEnd->forAll(p : ConnectionEnd | p.destination = typeConnection) then\r\n\t\t\t\t\t\t--When looking at a self connection we need to compare navigabilities to get an idicator for the right connectionEnd\r\n\t\t\t\t\t\ttypeConnection.connectionEnd->select(p : ConnectionEnd | p.navigable = relevantInstanceConnectionEnds->first().navigable)->first()\r\n\t\t\t\t\telse\r\n\t\t\t\t\t\t--Take the opposite connectionEnd end\r\n\t\t\t\t\t\ttypeConnection.connectionEnd->reject(p : ConnectionEnd | p.destination = typeConnection)->first()\r\n\t\t\t\t\tendif\r\n\t\t\t\tin\r\n\t\t\t\tif(relevantInstanceConnectionEnds->size() = 0) then\r\n\t\t\t\t\trelevantTypeConnectionEnd.lower = 0\r\n\t\t\t\telse\r\n\t\t\t\t\t--Get the sum of multiplicities from the the to the instance connections connected connectionEnds\r\n\t\t\t\t\trelevantTypeConnectionEnd.upper <> -1 implies relevantInstanceConnectionEnds.upper->sum() <= relevantTypeConnectionEnd.upper\r\n\t\t\t\tendif\r\n\t\t\t)\r\n\t\t)\r\n\tendif"
		   });	
		addAnnotation
		  (getClabject__GetDefinedInheritances(), 
		   source, 
		   new String[] {
			 "body", "Inheritance.allInstances()->select(i | i.subtype.subtype->includes(self) or i.supertype.supertype->includes(self))->asOrderedSet()"
		   });	
		addAnnotation
		  (getClabject__GetOwnedClabjects(), 
		   source, 
		   new String[] {
			 "body", "self.content->select(oclIsKindOf(Clabject)).oclAsType(Clabject)->asOrderedSet()"
		   });	
		addAnnotation
		  (getClabject_LevelIndex(), 
		   source, 
		   new String[] {
			 "derivation", "let containingLevel : Level = \r\n\tself.getLevel()\r\nin\r\nlet containingDeepModel : DeepModel = \r\n\tself.getDeepModel() \r\nin\r\nif (containingLevel.oclIsUndefined() or containingDeepModel.oclIsUndefined()) then\r\n\t-1\r\nelse\r\n\tcontainingDeepModel.content->indexOf(containingLevel) - 1\r\nendif"
		   });	
		addAnnotation
		  (getFeature__GetClabject(), 
		   source, 
		   new String[] {
			 "body", "self.oclAsType(ecore::EObject).eContainer().oclAsType(Clabject)"
		   });	
		addAnnotation
		  (getFeature__GetDurabilityAsString(), 
		   source, 
		   new String[] {
			 "body", "if (self.durability > 0) then OrderedSet{1000000, 10000, 1000, 100, 10, 1}\r\n\t->iterate(denominator : Integer; s : String = \'\'|\r\n\t\tlet numberAsString : String = \r\n\t\t\tOrderedSet{\'0\',\'1\',\'2\',\'3\',\'4\',\'5\',\'6\',\'7\',\'8\',\'9\'}->at(self.durability.div(denominator).mod(10) + 1)\r\n\t\tin\r\n\t\tif s=\'\' and numberAsString = \'0\' then\r\n\t\t\ts\r\n\t\telse\r\n\t\t\ts.concat(numberAsString)\r\n\t\tendif\r\n\t)\r\nelse\r\n\tif (self.durability = 0) then\r\n\t\t\'0\'\r\n\telse\r\n\t\t\'*\'\r\n\tendif\r\nendif\r\n\r\n"
		   });	
		addAnnotation
		  (getFeature__Represent(), 
		   source, 
		   new String[] {
			 "body", "if self.oclIsTypeOf(Attribute) then \r\n\tself.oclAsType(Attribute).represent() \r\nelse \r\n\tself.oclAsType(Method).represent() \r\nendif"
		   });	
		addAnnotation
		  (getEntity__Represent(), 
		   source, 
		   new String[] {
			 "body", "--First option is to use the name attribute\r\nlet nameAttribute:Attribute = self.getDefinedAttributes()->select(name = \'name\')->first()\r\nin\r\n--Second option is to use a name containing attribute\r\nlet nameContainingAttribute:Attribute = self.getDefinedAttributes()->select(name.toLower().matches(\'.*name.*\'))->first()\r\nin\r\n--Third option is the id attribute\r\nlet id:Attribute = self.getDefinedAttributes()->select(name = \'id\')->any(true)\r\nin\r\n--Fourth option is to use an id containing attribute\r\nlet idContainingAttribute:Attribute = self.getDefinedAttributes()->select(name.toLower().matches(\'.*id.*\'))->first()\r\nin\r\n--Last option is to use the first String attribute\r\nlet stringAttribute:Attribute = self.getDefinedAttributes()->select(name.toLower().matches(\'.*string.*\'))->first()\r\nin\r\nif (not nameAttribute.oclIsUndefined() and not nameAttribute.value.oclIsUndefined()) then\r\n\tnameAttribute.value\r\nelse\r\n\tif(not nameContainingAttribute.oclIsUndefined() and not nameContainingAttribute.value.oclIsUndefined()) then\r\n\t\tnameContainingAttribute.value\r\n\telse\r\n\t\tif(not id.oclIsUndefined() and not id.value.oclIsUndefined()) then\r\n\t\t\tid.value\r\n\t\telse\r\n\t\t\tif(not idContainingAttribute.oclIsUndefined() and not idContainingAttribute.value.oclIsUndefined()) then\r\n\t\t\t\tidContainingAttribute.value\r\n\t\t\telse\r\n\t\t\t\tif(not stringAttribute.oclIsUndefined() and not stringAttribute.value.oclIsUndefined()) then\r\n\t\t\t\t\tstringAttribute.value\r\n\t\t\t\telse\r\n\t\t\t\t\t--Linguistic name as backup\r\n\t\t\t\t\tif(not name.oclIsUndefined()) then\r\n\t\t\t\t\t\tname\r\n\t\t\t\t\telse\r\n\t\t\t\t\t\t\'\'\r\n\t\t\t\t\tendif\r\n\t\t\t\tendif\r\n\t\t\tendif\r\n\t\tendif\r\n\tendif\r\nendif"
		   });	
		addAnnotation
		  (getConnection__GetDomain(), 
		   source, 
		   new String[] {
			 "body", "self.connectionEnd->select(r | r.navigable).destination->asOrderedSet()"
		   });	
		addAnnotation
		  (getConnection__GetNotDomain(), 
		   source, 
		   new String[] {
			 "body", "self.connectionEnd->reject(r | r.navigable).destination->asOrderedSet()"
		   });	
		addAnnotation
		  (getConnection__GetHumanReadableName(), 
		   source, 
		   new String[] {
			 "body", "--Works only on connections with two or more participants or has a name by itself\r\nif (not (self.connectionEnd->size() > 1)) then\r\n\tif (not self.name.oclIsUndefined() or self.name <> \'\') then\r\n\t\tself.name\r\n\telse\r\n\t\t\'\'\r\n\tendif\r\nelse\r\n\tif (not self.name.oclIsUndefined() and self.name.size() <> 0) then\r\n\t\tself.name\r\n\telse\r\n\t\tlet navigableConnectionEnds:OrderedSet(ConnectionEnd) =\r\n\t\t\tself.connectionEnd->select(r | r.navigable)->asOrderedSet()\r\n\t\tin\r\n\t\tif (navigableConnectionEnds->size() = 1) then\r\n\t\t\tlet domainConnectionEndName:String = \r\n\t\t\t\tnavigableConnectionEnds->first().getHumanReadableConnectionEndName()\r\n\t\t\tin\r\n\t\t\tlet notNavigableConnectionEnds:OrderedSet(ConnectionEnd)=\t\r\n\t\t\t\tself.connectionEnd->reject(r | r.navigable)->asOrderedSet()\r\n\t\t\tin\r\n\t\t\tif (notNavigableConnectionEnds->size() = 0) then\r\n\t\t\t\tnavigableConnectionEnds.destination->first().name.concat(\'.\').concat(domainConnectionEndName)\r\n\t\t\telse\r\n\t\t\t\tnotNavigableConnectionEnds->first().destination.name.concat(\'.\').concat(domainConnectionEndName)\r\n\t\t\tendif\r\n\t\telse\r\n\t\t\tif (navigableConnectionEnds->size() > 0) then\r\n\t\t\t\tlet connectionName:String = \r\n\t\t\t\t\tnavigableConnectionEnds->iterate(r:ConnectionEnd; name:String = \'\' |\r\n\t\t\t\t\t\tlet monikerToUpper:String = \r\n\t\t\t\t\t\t\tif (r.destination.name.size() = 0 or r.destination.name.oclIsUndefined()) then\r\n\t\t\t\t\t\t\t\t\'~\'\r\n\t\t\t\t\t\t\telse\r\n\t\t\t\t\t\t\t\tr.destination.name.substring(1,1).toUpper().concat(if (r.destination.name.size() > 1) then r.destination.name.substring(2, r.destination.name.size()) else \'\' endif)\r\n\t\t\t\t\t\t\tendif\r\n\t\t\t\t\t\tin\r\n\t\t\t\t\t\tif (r = navigableConnectionEnds->last()) then\t\r\n\t\t\t\t\t\t\tname.concat(monikerToUpper)\r\n\t\t\t\t\t\telse\r\n\t\t\t\t\t\t\tname.concat(monikerToUpper).concat(\'And\')\r\n\t\t\t\t\t\tendif\r\n\t\t\t\t\t)\r\n\t\t\t\tin\r\n\t\t\t\t\t\'Between\'.concat(connectionName)\r\n\t\t\telse\r\n\t\t\t\t\'\'\r\n\t\t\tendif\r\n\t\tendif\r\n\tendif\r\nendif"
		   });	
		addAnnotation
		  (getConnection__GetParticipants(), 
		   source, 
		   new String[] {
			 "body", "self.getAllConnectionEnd().destination->asOrderedSet()"
		   });	
		addAnnotation
		  (getConnection__GetMoniker(), 
		   source, 
		   new String[] {
			 "body", "self.connectionEnd->collect(r|r.getHumanReadableConnectionEndName())->asOrderedSet()"
		   });	
		addAnnotation
		  (getConnection__GetDomain__Clabject(), 
		   source, 
		   new String[] {
			 "body", "self.connectionEnd->select(r | r.navigable and  r.destination <> source).destination->asOrderedSet()"
		   });	
		addAnnotation
		  (getConnection__GetMonikerForParticipant__Clabject(), 
		   source, 
		   new String[] {
			 "body", "self.connectionEnd->select(r | r.destination = source)->collect(r|r.moniker())->asOrderedSet()"
		   });	
		addAnnotation
		  (getConnection__GetLowerForMoniker__String(), 
		   source, 
		   new String[] {
			 "body", "self.connectionEnd->select(r | r.moniker() = rN).lower->first()"
		   });	
		addAnnotation
		  (getConnection__GetUpperForMoniker__String(), 
		   source, 
		   new String[] {
			 "body", "self.connectionEnd->select(r | r.moniker() = rN).upper->first()"
		   });	
		addAnnotation
		  (getConnection__IsNavigableForMoniker__String(), 
		   source, 
		   new String[] {
			 "body", "self.connectionEnd->select(r | r.moniker() = rN).navigable->first()"
		   });	
		addAnnotation
		  (getConnection__GetOrder(), 
		   source, 
		   new String[] {
			 "body", "self.connectionEnd->size()"
		   });	
		addAnnotation
		  (getConnection__GetInheritedConnectionEnd(), 
		   source, 
		   new String[] {
			 "body", "self.getDirectSupertypes()->iterate(\r\n\tsuper;\r\n\tr : OrderedSet(ConnectionEnd)= OrderedSet{} |\r\n\tr->union(super.oclAsType(Connection).getAllConnectionEnd()->reject(rs|r->exists(rss|rss.moniker()=rs.moniker())))->asOrderedSet()\r\n)"
		   });	
		addAnnotation
		  (getConnection__GetAllConnectionEnd(), 
		   source, 
		   new String[] {
			 "body", "self.connectionEnd->union(\r\n\tself.getInheritedConnectionEnd()->reject(r | self.connectionEnd->exists(rs | rs.moniker() = r.moniker() ) )\r\n)->asOrderedSet()"
		   });	
		addAnnotation
		  (getConnection__GetParticipantForMoniker__String(), 
		   source, 
		   new String[] {
			 "body", "self.connectionEnd->select(r | r.moniker() = rN).destination->first()"
		   });	
		addAnnotation
		  (getConnection__Represent(), 
		   source, 
		   new String[] {
			 "body", "if self.name.oclIsUndefined() or self.name = \'\' then\n\tself.connectionEnd.represent()->iterate(\n\t\tr:String; res:String=\'|\'| res.concat(r).concat(\'|\')\n\t)\nelse \n\tself.name\nendif"
		   });	
		addAnnotation
		  (getConnectionEnd__GetHumanReadableConnectionEndName(), 
		   source, 
		   new String[] {
			 "body", "if (self.hasDefaultMoniker()) then\r\n\tif (self.destination.name.size() > 0) then\r\n\t\tself.destination.name.substring(1,1).toLower().concat(if (self.destination.name.size() > 1) then self.destination.name.substring(2, self.destination.name.size()) else \'\' endif)\r\n\telse\r\n\t\t\'\'\r\n\tendif\r\nelse\r\n\tself.moniker\r\nendif"
		   });	
		addAnnotation
		  (getConnectionEnd__HasDefaultMoniker(), 
		   source, 
		   new String[] {
			 "body", "if (self.moniker.oclIsUndefined() or self.moniker = \'\') then\r\n\ttrue\r\nelse\r\n\tfalse\r\nendif"
		   });	
		addAnnotation
		  (getConnectionEnd__Represent(), 
		   source, 
		   new String[] {
			 "body", "let destinationName : String = \r\n\tif self.destination.name.oclIsUndefined() or self.destination.name.size() = 0 then\r\n\t\t\'_\' else self.destination.name endif \r\nin\r\nself.moniker().concat(\'[\').concat(\r\n\tself.representMultiplicity()\r\n).concat(\']\').concat(\r\n\tif self.navigable then \'->\' else \'-\' endif\r\n).concat(destinationName)"
		   });	
		addAnnotation
		  (getConnectionEnd__Moniker(), 
		   source, 
		   new String[] {
			 "body", "if (self.hasDefaultMoniker()) then\r\n\tif (self.destination.name.size() > 0) then\r\n\t\tself.destination.name.substring(1,1).toLower().concat(if (self.destination.name.size() > 1) then self.destination.name.substring(2, self.destination.name.size()) else \'\' endif)\r\n\telse\r\n\t\t\'\'\r\n\tendif\r\nelse\r\n\tself.moniker\r\nendif"
		   });	
		addAnnotation
		  (getConnectionEnd__RepresentMultiplicity(), 
		   source, 
		   new String[] {
			 "body", "let lowerString:String = if (self.lower > 0) then OrderedSet{1000000, 10000, 1000, 100, 10, 1}->iterate(\r\n            denominator : Integer;\r\n            s : String = \'\'|\r\n            let numberAsString : String = OrderedSet{\r\n                    \'0\',\'1\',\'2\',\'3\',\'4\',\'5\',\'6\',\'7\',\'8\',\'9\'\r\n                }->at(self.lower.div(denominator).mod(10) + 1)\r\n            in\r\n                if s=\'\' and numberAsString = \'0\' then\r\n                    s\r\n                else\r\n                    s.concat(numberAsString)\r\n                endif\r\n        )\r\n\telse \r\n\t\tif (self.lower = 0) then\r\n\t\t\t\'0\'\r\n\t\telse\r\n\t\t\t\'*\'\r\n\t\tendif\r\n\tendif\r\nin\r\n\r\nlet upperString:String = if (self.upper > 0) then OrderedSet{1000000, 10000, 1000, 100, 10, 1}->iterate(\r\n            denominator : Integer;\r\n            s : String = \'\'|\r\n            let numberAsString : String = OrderedSet{\r\n                    \'0\',\'1\',\'2\',\'3\',\'4\',\'5\',\'6\',\'7\',\'8\',\'9\'\r\n                }->at(self.upper.div(denominator).mod(10) + 1)\r\n            in\r\n                if s=\'\' and numberAsString = \'0\' then\r\n                    s\r\n                else\r\n                    s.concat(numberAsString)\r\n                endif\r\n        )\r\n\telse \r\n\t\tif (self.upper = 0) then\r\n\t\t\t\'0\'\r\n\t\telse\r\n\t\t\t\'*\'\r\n\t\tendif\r\n\tendif\r\nin\r\n\r\nif (self.lower = 0 and self.upper = -1) then\r\n\t\'*\'\r\nelse\r\n\tif (self.lower = self.upper) then\r\n\t\tlowerString\r\n\telse\r\n\t\tlowerString.concat(\'..\').concat(upperString)\r\n\tendif\r\nendif"
		   });	
		addAnnotation
		  (getConnectionEnd__GetConnectionEndName(), 
		   source, 
		   new String[] {
			 "body", "self.represent()"
		   });	
		addAnnotation
		  (getConnectionEnd__Conforms__ConnectionEnd(), 
		   source, 
		   new String[] {
			 "body", "let connectionEndNameConforms:Boolean = \r\n\t(self.moniker() = connectionEnd.moniker()) or (self.hasDefaultMoniker() and connectionEnd.hasDefaultMoniker())\r\nin\r\n\tconnectionEndNameConforms and ( self.navigable = connectionEnd.navigable)"
		   });	
		addAnnotation
		  (getLMLVisualizer__GetDefaultVisualizationValues(), 
		   source, 
		   new String[] {
			 "body", "-- Trait-related default values for all meta-model elements\r\nlet default:OrderedSet(String) = self.oclAsType(ecore::EObject).eContainer().eClass().eAllAttributes->collect(a | if a.name <> \'levelIndex\' then a.name.concat(\'= default\') else a.name.concat(\'= noshow\') endif)->asOrderedSet()\r\nin\r\n-- Non trait-related default values for Entity\r\nif (self.getContainingElement().oclIsTypeOf(Entity)) then\r\n\tdefault->append(\'ProximityClassification= 1\') -- @deprecated - Do not use anymore\r\n\t\t->append(\'text= derived\')\r\n\t\t->append(\'graph= derived\')\r\n\t\t->append(\'form= derived\')\r\n\t\t->append(\'table= derived\')\r\n\t\t->append(\'app= derived\')\r\n\t\t->append(\'DSLRendering= false\') -- @deprecated - Do not use anymore\r\n\t\t->append(\'ProximityIndication= name:1\')\r\nelse\r\n\t-- Non trait-related default values for Connection\r\n\tif (self.getContainingElement().oclIsTypeOf(Connection)) then\r\n\t\tdefault->append(\'ProximityClassification= 1\') -- @deprecated - Do not use anymore\r\n\t\t\t->append(\'text= derived\')\r\n\t\t\t->append(\'graph= derived\')\r\n\t\t\t->append(\'form= derived\')\r\n\t\t\t->append(\'table= derived\')\r\n\t\t\t->append(\'app= derived\')\r\n\t\t\t->append(\'DSLRendering= false\') -- @deprecated - Do not use anymore\r\n\t\t\t->append(\'ProximityIndication= name:1\')\r\n\t\t\t->append(\'collapsed= false\')\r\n\telse\r\n\t\t-- Non trait-related default values for Inheritance\r\n\t\tif (self.getContainingElement().oclIsTypeOf(Inheritance)) then\r\n\t\t\t\tdefault->append(\'collapsed= false\')\r\n\t\telse\r\n\t\t\t-- Non trait-related default values for DeepModel\r\n\t\t\tif (self.getContainingElement().oclIsTypeOf(DeepModel)) then\r\n\t\t\t\tdefault->append(\'showClassificationConnectionEndNames = false\')\r\n\t\t\t\t->append(\'text= derived\')\r\n\t\t\t\t->append(\'graph= derived\')\r\n\t\t\t\t->append(\'form= derived\')\r\n\t\t\t\t->append(\'table= derived\')\r\n\t\t\t\t->append(\'app= derived\')\r\n\t\t\t-- Non trait-related default values for Level\r\n\t\t\telse\r\n\t\t\t\tif (self.getContainingElement().oclIsTypeOf(Level)) then\r\n\t\t\t\t\tdefault->append(\'text= derived\')\r\n\t\t\t\t\t->append(\'graph= derived\')\r\n\t\t\t\t\t->append(\'form= derived\')\r\n\t\t\t\t\t->append(\'table= derived\')\r\n\t\t\t\t\t->append(\'app= derived\')\r\n\t\t\t\telse\r\n\t\t\t\t\tif (self.getContainingElement().oclIsTypeOf(Package)) then\r\n\t\t\t\t\t\tdefault->append(\'text= derived\')\r\n\t\t\t\t\t\t->append(\'graph= derived\')\r\n\t\t\t\t\t\t->append(\'form= derived\')\r\n\t\t\t\t\t\t->append(\'table= derived\')\r\n\t\t\t\t\t\t->append(\'app= derived\')\r\n\t\t\t\t\telse\r\n\t\t\t\t\t\tdefault\r\n\t\t\t\t\tendif\r\n\t\t\t\tendif\r\n\t\t\tendif\r\n\t\tendif\r\n\tendif\r\nendif"
		   });	
		addAnnotation
		  (getLMLVisualizer__GetValueForKey__String(), 
		   source, 
		   new String[] {
			 "body", "let keyValueList : Sequence(String) =\r\n\tself.attributes->select(a | a.size() > key.size())->select(a | a.substring(1, key.size()) = key)->asSequence()\r\nin\r\nlet keyValue : String =\r\n\tif (keyValueList->size() > 0) then\r\n\t\tkeyValueList->first()\r\n\telse\r\n\t\t\'\'\r\n\tendif\r\nin\r\nlet indexOfEquals:Integer =\r\n\t--Key not found?\r\n\tif (keyValue <> \'\') then\r\n\t\tSequence{1 .. keyValue.size()}->iterate(i:Integer; index:Integer = -1 | \r\n\t\t\tif (index = -1 and keyValue.substring(i,i) = \'=\') then i else index endif)\r\n\telse\r\n\t\t-1\r\n\tendif\r\nin\r\nlet value:String =\r\n\t--No Equals found in keyValue\r\n\tif(indexOfEquals <> -1) then\r\n\t\tkeyValue.substring(indexOfEquals + 1, keyValue.size())\r\n\telse\r\n\t\t\'\'\r\n\tendif\r\nin\r\nlet valueWithoutLeadingSpace:String = \r\n\t--No value found\r\n\tif (value <> \'\') then\r\n\t\tif (value.substring(1,1) = \' \' and value.size() > 1) then\r\n\t\t\tvalue.substring(2, value.size())\r\n\t\telse\r\n\t\t\tvalue\r\n\t\tendif\r\n\telse\r\n\t\t\'\'\r\n\tendif\r\nin\r\n\tvalueWithoutLeadingSpace"
		   });	
		addAnnotation
		  (getLMLVisualizer__GetContainingElement(), 
		   source, 
		   new String[] {
			 "body", "self.oclAsType(ecore::EObject).eContainer().oclAsType(Element)"
		   });	
		addAnnotation
		  (getAttribute__GetMutabilityAsString(), 
		   source, 
		   new String[] {
			 "body", "if (self.mutability > 0) then OrderedSet{1000000, 10000, 1000, 100, 10, 1}->iterate(\r\n\tdenominator : Integer;\ts : String = \'\'|\r\n\t\tlet numberAsString : String = \r\n\t\t\tOrderedSet{\'0\',\'1\',\'2\',\'3\',\'4\',\'5\',\'6\',\'7\',\'8\',\'9\'}->at(self.mutability.div(denominator).mod(10) + 1)\r\n\t\tin\r\n\t\tif s=\'\' and numberAsString = \'0\' then\r\n\t\t\ts\r\n\t\telse\r\n\t\t\ts.concat(numberAsString)\r\n\t\tendif\r\n\t)\r\nelse\r\n\tif (self.mutability = 0) then\r\n\t\t\'0\'\r\n\telse\r\n\t\t\'*\'\r\n\tendif\r\nendif\r\n\r\n"
		   });	
		addAnnotation
		  (getAttribute__Represent(), 
		   source, 
		   new String[] {
			 "body", "if self.datatype.oclIsUndefined() or self.datatype = \'\' then\r\n\tself.name\r\nelse\r\n\tself.name.concat(\'[\').concat(self.datatype).concat(\']\')\r\nendif"
		   });	
		addAnnotation
		  (getAttribute__GetPossibleDataTypes(), 
		   source, 
		   new String[] {
			 "body", "self.getPrimitiveDataTypes()->union(self.getEnumerationDataTypes())->asOrderedSet()"
		   });	
		addAnnotation
		  (getAttribute__GetPrimitiveDataTypes(), 
		   source, 
		   new String[] {
			 "body", "self.oclAsType(ecore::EObject).eClass().ePackage.getEAnnotation(\'http://melanee.org/PLM/Datatypes\').details.key->asOrderedSet()"
		   });	
		addAnnotation
		  (getAttribute__GetEnumerationDataTypes(), 
		   source, 
		   new String[] {
			 "body", "self.getClabject().getDeepModel().enumeration.name->asOrderedSet()"
		   });	
		addAnnotation
		  (getAttribute__IsEnumeration(), 
		   source, 
		   new String[] {
			 "body", "getEnumerationDataTypes()->includes(datatype)"
		   });	
		addAnnotation
		  (getAttribute__GetEnumeration(), 
		   source, 
		   new String[] {
			 "body", "--Check if the attribute is an enumeration\r\nif (isEnumeration()) then\r\n\tself.getClabject().getDeepModel().enumeration->select(name = datatype)->any(true)\r\nelse\r\n\tnull\r\nendif"
		   });	
		addAnnotation
		  (getAttribute__GetLiterals(), 
		   source, 
		   new String[] {
			 "body", "getEnumeration().literal->asOrderedSet()"
		   });	
		addAnnotation
		  (getMethod__Represent(), 
		   source, 
		   new String[] {
			 "body", "self.name.concat(\'(\').concat(\')\')"
		   });	
		addAnnotation
		  (getMethod__GetInput(), 
		   source, 
		   new String[] {
			 "body", "self.parameter->select(p | not p.output)"
		   });	
		addAnnotation
		  (getMethod__GetOutput(), 
		   source, 
		   new String[] {
			 "body", "self.parameter->select(p | p.output)"
		   });	
		addAnnotation
		  (getParameter__GetClabject(), 
		   source, 
		   new String[] {
			 "body", "self.oclAsType(ecore::EObject).eContainer().oclAsType(Feature).getClabject()"
		   });	
		addAnnotation
		  (getAbstractDSLVisualizer__Format(), 
		   source, 
		   new String[] {
			 "body", "\'\'"
		   });
	}

	/**
	 * Initializes the annotations for <b>Comment</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createCommentAnnotations() {
		String source = "Comment";	
		addAnnotation
		  (clabjectEClass, 
		   source, 
		   new String[] {
			 "level derrived", "Element container = (this.eContainer() instanceof Element) ? (Element)this.eContainer() : null;\r\n\t\t\r\n\t\twhile ( (container != null) && !(container instanceof Level) )\r\n\t\t\tcontainer = (container.eContainer() instanceof Element) ? (Element)container.eContainer() : null;\r\n\t\tif (container == null)\r\n\t\t\treturn -1;\r\n\t\treturn (container.eContainer() instanceof DeepModel) ? ((DeepModel)container.eContainer()).getLevels().indexOf(container) : -1;"
		   });	
		addAnnotation
		  (connectionEClass, 
		   source, 
		   new String[] {
			 "Unique Workaround", "if (this.participant == null) {\r\n\t\t    this.participant = new EObjectResolvingEList<Clabject>(Clabject.class, this,\r\n\t\t    \t\tPLMPackage.DOMAIN_CONNECTION__PARTICIPANT) {\r\n\t\t      @Override\r\n\t\t      protected boolean isUnique() {\r\n\t\t        return false;\r\n\t\t      }\r\n\t\t    };\r\n\t\t  }\r\n\t\t  return this.participant;"
		   });
	}

} //PLMPackageImpl

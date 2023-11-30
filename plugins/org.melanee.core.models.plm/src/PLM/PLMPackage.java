/**
 */
package PLM;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see PLM.PLMFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 *        annotation="http://melanee.org/PLM/Datatypes String='.*' Real='-?\\d*(\\.\\d*)?' Integer='-?\\d*' Natural='\\d*' Boolean='true|false' Character='.' Percent='\\d{1,3}(\\.\\d*)?' Probability='0?\\.(\\d*)?' Money='-?\\d*(\\.\\d{1,2})?' void='' Terminal='\\d*' Separator='.'"
 *        annotation="http://melanee.org/PLM/Version plmVersion='2.1'"
 * @generated
 */
public interface PLMPackage extends EPackage {
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "PLM";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://melanee.org/PLM";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "PLM";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  PLMPackage eINSTANCE = PLM.impl.PLMPackageImpl.init();

  /**
   * The meta object id for the '{@link PLM.impl.DomainImpl <em>Domain</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.impl.DomainImpl
   * @see PLM.impl.PLMPackageImpl#getDomain()
   * @generated
   */
  int DOMAIN = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN__NAME = 0;

  /**
   * The feature id for the '<em><b>Deep Model</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN__DEEP_MODEL = 1;

  /**
   * The feature id for the '<em><b>Plm Version</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN__PLM_VERSION = 2;

  /**
   * The feature id for the '<em><b>Compliance Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN__COMPLIANCE_KIND = 3;

  /**
   * The number of structural features of the '<em>Domain</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_FEATURE_COUNT = 4;

  /**
   * The number of operations of the '<em>Domain</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link PLM.impl.ElementImpl <em>Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.impl.ElementImpl
   * @see PLM.impl.PLMPackageImpl#getElement()
   * @generated
   */
  int ELEMENT = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT__NAME = 0;

  /**
   * The feature id for the '<em><b>Visualizer</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT__VISUALIZER = 1;

  /**
   * The feature id for the '<em><b>Behavior</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT__BEHAVIOR = 2;

  /**
   * The feature id for the '<em><b>Constraint</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT__CONSTRAINT = 3;

  /**
   * The number of structural features of the '<em>Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_FEATURE_COUNT = 4;

  /**
   * The number of operations of the '<em>Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link PLM.impl.LevelImpl <em>Level</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.impl.LevelImpl
   * @see PLM.impl.PLMPackageImpl#getLevel()
   * @generated
   */
  int LEVEL = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEVEL__NAME = ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Visualizer</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEVEL__VISUALIZER = ELEMENT__VISUALIZER;

  /**
   * The feature id for the '<em><b>Behavior</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEVEL__BEHAVIOR = ELEMENT__BEHAVIOR;

  /**
   * The feature id for the '<em><b>Constraint</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEVEL__CONSTRAINT = ELEMENT__CONSTRAINT;

  /**
   * The feature id for the '<em><b>Content</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEVEL__CONTENT = ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Level</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEVEL_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

  /**
   * The operation id for the '<em>Get All Inheritances</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEVEL___GET_ALL_INHERITANCES = ELEMENT_OPERATION_COUNT + 0;

  /**
   * The operation id for the '<em>Get Clabjects</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEVEL___GET_CLABJECTS = ELEMENT_OPERATION_COUNT + 1;

  /**
   * The operation id for the '<em>Get Entities</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEVEL___GET_ENTITIES = ELEMENT_OPERATION_COUNT + 2;

  /**
   * The operation id for the '<em>Get Connections</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEVEL___GET_CONNECTIONS = ELEMENT_OPERATION_COUNT + 3;

  /**
   * The operation id for the '<em>Get Classifications</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEVEL___GET_CLASSIFICATIONS = ELEMENT_OPERATION_COUNT + 4;

  /**
   * The operation id for the '<em>Get Deep Model</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEVEL___GET_DEEP_MODEL = ELEMENT_OPERATION_COUNT + 5;

  /**
   * The operation id for the '<em>Get Classified Level</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEVEL___GET_CLASSIFIED_LEVEL = ELEMENT_OPERATION_COUNT + 6;

  /**
   * The operation id for the '<em>Get Classifying Level</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEVEL___GET_CLASSIFYING_LEVEL = ELEMENT_OPERATION_COUNT + 7;

  /**
   * The operation id for the '<em>Get Level</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEVEL___GET_LEVEL = ELEMENT_OPERATION_COUNT + 8;

  /**
   * The operation id for the '<em>Is Root Level</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEVEL___IS_ROOT_LEVEL = ELEMENT_OPERATION_COUNT + 9;

  /**
   * The operation id for the '<em>Is Leaf Level</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEVEL___IS_LEAF_LEVEL = ELEMENT_OPERATION_COUNT + 10;

  /**
   * The number of operations of the '<em>Level</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEVEL_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 11;

  /**
   * The meta object id for the '{@link PLM.impl.DeepModelImpl <em>Deep Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.impl.DeepModelImpl
   * @see PLM.impl.PLMPackageImpl#getDeepModel()
   * @generated
   */
  int DEEP_MODEL = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEEP_MODEL__NAME = ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Visualizer</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEEP_MODEL__VISUALIZER = ELEMENT__VISUALIZER;

  /**
   * The feature id for the '<em><b>Behavior</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEEP_MODEL__BEHAVIOR = ELEMENT__BEHAVIOR;

  /**
   * The feature id for the '<em><b>Constraint</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEEP_MODEL__CONSTRAINT = ELEMENT__CONSTRAINT;

  /**
   * The feature id for the '<em><b>Content</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEEP_MODEL__CONTENT = ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Enumeration</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEEP_MODEL__ENUMERATION = ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Deep Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEEP_MODEL_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 2;

  /**
   * The operation id for the '<em>Get Level At Index</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEEP_MODEL___GET_LEVEL_AT_INDEX__INT = ELEMENT_OPERATION_COUNT + 0;

  /**
   * The operation id for the '<em>Get Primitive Datatypes</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEEP_MODEL___GET_PRIMITIVE_DATATYPES = ELEMENT_OPERATION_COUNT + 1;

  /**
   * The operation id for the '<em>Get Regex For Primitive Datatype</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEEP_MODEL___GET_REGEX_FOR_PRIMITIVE_DATATYPE__STRING = ELEMENT_OPERATION_COUNT + 2;

  /**
   * The operation id for the '<em>Get All Datatypes</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEEP_MODEL___GET_ALL_DATATYPES = ELEMENT_OPERATION_COUNT + 3;

  /**
   * The number of operations of the '<em>Deep Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEEP_MODEL_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 4;

  /**
   * The meta object id for the '{@link PLM.impl.OwnedElementImpl <em>Owned Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.impl.OwnedElementImpl
   * @see PLM.impl.PLMPackageImpl#getOwnedElement()
   * @generated
   */
  int OWNED_ELEMENT = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OWNED_ELEMENT__NAME = ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Visualizer</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OWNED_ELEMENT__VISUALIZER = ELEMENT__VISUALIZER;

  /**
   * The feature id for the '<em><b>Behavior</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OWNED_ELEMENT__BEHAVIOR = ELEMENT__BEHAVIOR;

  /**
   * The feature id for the '<em><b>Constraint</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OWNED_ELEMENT__CONSTRAINT = ELEMENT__CONSTRAINT;

  /**
   * The number of structural features of the '<em>Owned Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OWNED_ELEMENT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 0;

  /**
   * The operation id for the '<em>Get Level</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OWNED_ELEMENT___GET_LEVEL = ELEMENT_OPERATION_COUNT + 0;

  /**
   * The number of operations of the '<em>Owned Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OWNED_ELEMENT_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 1;

  /**
   * The meta object id for the '{@link PLM.impl.CorrelationImpl <em>Correlation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.impl.CorrelationImpl
   * @see PLM.impl.PLMPackageImpl#getCorrelation()
   * @generated
   */
  int CORRELATION = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CORRELATION__NAME = OWNED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Visualizer</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CORRELATION__VISUALIZER = OWNED_ELEMENT__VISUALIZER;

  /**
   * The feature id for the '<em><b>Behavior</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CORRELATION__BEHAVIOR = OWNED_ELEMENT__BEHAVIOR;

  /**
   * The feature id for the '<em><b>Constraint</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CORRELATION__CONSTRAINT = OWNED_ELEMENT__CONSTRAINT;

  /**
   * The number of structural features of the '<em>Correlation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CORRELATION_FEATURE_COUNT = OWNED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The operation id for the '<em>Get Level</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CORRELATION___GET_LEVEL = OWNED_ELEMENT___GET_LEVEL;

  /**
   * The number of operations of the '<em>Correlation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CORRELATION_OPERATION_COUNT = OWNED_ELEMENT_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link PLM.impl.InheritanceImpl <em>Inheritance</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.impl.InheritanceImpl
   * @see PLM.impl.PLMPackageImpl#getInheritance()
   * @generated
   */
  int INHERITANCE = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INHERITANCE__NAME = CORRELATION__NAME;

  /**
   * The feature id for the '<em><b>Visualizer</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INHERITANCE__VISUALIZER = CORRELATION__VISUALIZER;

  /**
   * The feature id for the '<em><b>Behavior</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INHERITANCE__BEHAVIOR = CORRELATION__BEHAVIOR;

  /**
   * The feature id for the '<em><b>Constraint</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INHERITANCE__CONSTRAINT = CORRELATION__CONSTRAINT;

  /**
   * The feature id for the '<em><b>Supertype</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INHERITANCE__SUPERTYPE = CORRELATION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Subtype</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INHERITANCE__SUBTYPE = CORRELATION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Disjoint</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INHERITANCE__DISJOINT = CORRELATION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Complete</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INHERITANCE__COMPLETE = CORRELATION_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Inheritance</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INHERITANCE_FEATURE_COUNT = CORRELATION_FEATURE_COUNT + 4;

  /**
   * The operation id for the '<em>Get Level</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INHERITANCE___GET_LEVEL = CORRELATION___GET_LEVEL;

  /**
   * The operation id for the '<em>Is Disjoint</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INHERITANCE___IS_DISJOINT = CORRELATION_OPERATION_COUNT + 0;

  /**
   * The operation id for the '<em>Is Complete</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INHERITANCE___IS_COMPLETE = CORRELATION_OPERATION_COUNT + 1;

  /**
   * The operation id for the '<em>Is Intersection</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INHERITANCE___IS_INTERSECTION = CORRELATION_OPERATION_COUNT + 2;

  /**
   * The operation id for the '<em>Represent</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INHERITANCE___REPRESENT = CORRELATION_OPERATION_COUNT + 3;

  /**
   * The operation id for the '<em>Get Supertypes</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INHERITANCE___GET_SUPERTYPES = CORRELATION_OPERATION_COUNT + 4;

  /**
   * The operation id for the '<em>Get Subtypes</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INHERITANCE___GET_SUBTYPES = CORRELATION_OPERATION_COUNT + 5;

  /**
   * The number of operations of the '<em>Inheritance</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INHERITANCE_OPERATION_COUNT = CORRELATION_OPERATION_COUNT + 6;

  /**
   * The meta object id for the '{@link PLM.impl.SupertypeImpl <em>Supertype</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.impl.SupertypeImpl
   * @see PLM.impl.PLMPackageImpl#getSupertype()
   * @generated
   */
  int SUPERTYPE = 7;

  /**
   * The feature id for the '<em><b>Supertype</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPERTYPE__SUPERTYPE = 0;

  /**
   * The feature id for the '<em><b>Inheritance</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPERTYPE__INHERITANCE = 1;

  /**
   * The number of structural features of the '<em>Supertype</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPERTYPE_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>Supertype</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPERTYPE_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link PLM.impl.SubtypeImpl <em>Subtype</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.impl.SubtypeImpl
   * @see PLM.impl.PLMPackageImpl#getSubtype()
   * @generated
   */
  int SUBTYPE = 8;

  /**
   * The feature id for the '<em><b>Subtype</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBTYPE__SUBTYPE = 0;

  /**
   * The feature id for the '<em><b>Inheritance</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBTYPE__INHERITANCE = 1;

  /**
   * The number of structural features of the '<em>Subtype</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBTYPE_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>Subtype</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBTYPE_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link PLM.impl.ClassificationImpl <em>Classification</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.impl.ClassificationImpl
   * @see PLM.impl.PLMPackageImpl#getClassification()
   * @generated
   */
  int CLASSIFICATION = 9;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFICATION__NAME = CORRELATION__NAME;

  /**
   * The feature id for the '<em><b>Visualizer</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFICATION__VISUALIZER = CORRELATION__VISUALIZER;

  /**
   * The feature id for the '<em><b>Behavior</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFICATION__BEHAVIOR = CORRELATION__BEHAVIOR;

  /**
   * The feature id for the '<em><b>Constraint</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFICATION__CONSTRAINT = CORRELATION__CONSTRAINT;

  /**
   * The feature id for the '<em><b>Instance</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFICATION__INSTANCE = CORRELATION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFICATION__TYPE = CORRELATION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFICATION__KIND = CORRELATION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Classification</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFICATION_FEATURE_COUNT = CORRELATION_FEATURE_COUNT + 3;

  /**
   * The operation id for the '<em>Get Level</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFICATION___GET_LEVEL = CORRELATION___GET_LEVEL;

  /**
   * The operation id for the '<em>Represent</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFICATION___REPRESENT = CORRELATION_OPERATION_COUNT + 0;

  /**
   * The number of operations of the '<em>Classification</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFICATION_OPERATION_COUNT = CORRELATION_OPERATION_COUNT + 1;

  /**
   * The meta object id for the '{@link PLM.impl.ClabjectImpl <em>Clabject</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.impl.ClabjectImpl
   * @see PLM.impl.PLMPackageImpl#getClabject()
   * @generated
   */
  int CLABJECT = 10;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT__NAME = OWNED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Visualizer</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT__VISUALIZER = OWNED_ELEMENT__VISUALIZER;

  /**
   * The feature id for the '<em><b>Behavior</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT__BEHAVIOR = OWNED_ELEMENT__BEHAVIOR;

  /**
   * The feature id for the '<em><b>Constraint</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT__CONSTRAINT = OWNED_ELEMENT__CONSTRAINT;

  /**
   * The feature id for the '<em><b>Potency</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT__POTENCY = OWNED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Level Index</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT__LEVEL_INDEX = OWNED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Content</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT__CONTENT = OWNED_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Feature</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT__FEATURE = OWNED_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Clabject</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT_FEATURE_COUNT = OWNED_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The operation id for the '<em>Get Level</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_LEVEL = OWNED_ELEMENT___GET_LEVEL;

  /**
   * The operation id for the '<em>Get Deep Model</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_DEEP_MODEL = OWNED_ELEMENT_OPERATION_COUNT + 0;

  /**
   * The operation id for the '<em>Get Supertypes</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_SUPERTYPES = OWNED_ELEMENT_OPERATION_COUNT + 1;

  /**
   * The operation id for the '<em>Get Supertypes</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_SUPERTYPES__ELIST = OWNED_ELEMENT_OPERATION_COUNT + 2;

  /**
   * The operation id for the '<em>Get Direct Supertypes</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_DIRECT_SUPERTYPES = OWNED_ELEMENT_OPERATION_COUNT + 3;

  /**
   * The operation id for the '<em>Get Subtypes</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_SUBTYPES = OWNED_ELEMENT_OPERATION_COUNT + 4;

  /**
   * The operation id for the '<em>Get Hollow Subtypes</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_HOLLOW_SUBTYPES = OWNED_ELEMENT_OPERATION_COUNT + 5;

  /**
   * The operation id for the '<em>Get Hollow Supertypes</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_HOLLOW_SUPERTYPES = OWNED_ELEMENT_OPERATION_COUNT + 6;

  /**
   * The operation id for the '<em>Get Classifications As Instance</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_CLASSIFICATIONS_AS_INSTANCE = OWNED_ELEMENT_OPERATION_COUNT + 7;

  /**
   * The operation id for the '<em>Get Classifications As Type</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_CLASSIFICATIONS_AS_TYPE = OWNED_ELEMENT_OPERATION_COUNT + 8;

  /**
   * The operation id for the '<em>Get Instances</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_INSTANCES = OWNED_ELEMENT_OPERATION_COUNT + 9;

  /**
   * The operation id for the '<em>Get Types</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_TYPES = OWNED_ELEMENT_OPERATION_COUNT + 10;

  /**
   * The operation id for the '<em>Get Direct Types</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_DIRECT_TYPES = OWNED_ELEMENT_OPERATION_COUNT + 11;

  /**
   * The operation id for the '<em>Get Level Types</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_LEVEL_TYPES = OWNED_ELEMENT_OPERATION_COUNT + 12;

  /**
   * The operation id for the '<em>Get Defined Classification Tree As Instance</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_DEFINED_CLASSIFICATION_TREE_AS_INSTANCE = OWNED_ELEMENT_OPERATION_COUNT + 13;

  /**
   * The operation id for the '<em>Get Classification Tree As Instance</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_CLASSIFICATION_TREE_AS_INSTANCE = OWNED_ELEMENT_OPERATION_COUNT + 14;

  /**
   * The operation id for the '<em>Get Defined Instances</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_DEFINED_INSTANCES = OWNED_ELEMENT_OPERATION_COUNT + 15;

  /**
   * The operation id for the '<em>Get Defined Classification Tree As Type</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_DEFINED_CLASSIFICATION_TREE_AS_TYPE = OWNED_ELEMENT_OPERATION_COUNT + 16;

  /**
   * The operation id for the '<em>Get Classification Tree As Type</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_CLASSIFICATION_TREE_AS_TYPE = OWNED_ELEMENT_OPERATION_COUNT + 17;

  /**
   * The operation id for the '<em>Get Classification Tree As Type</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_CLASSIFICATION_TREE_AS_TYPE__INT = OWNED_ELEMENT_OPERATION_COUNT + 18;

  /**
   * The operation id for the '<em>Get Classification Tree As Type</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_CLASSIFICATION_TREE_AS_TYPE__INT_INT = OWNED_ELEMENT_OPERATION_COUNT + 19;

  /**
   * The operation id for the '<em>Get All Features</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_ALL_FEATURES = OWNED_ELEMENT_OPERATION_COUNT + 20;

  /**
   * The operation id for the '<em>Get All Attributes</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_ALL_ATTRIBUTES = OWNED_ELEMENT_OPERATION_COUNT + 21;

  /**
   * The operation id for the '<em>Get Defined Attributes</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_DEFINED_ATTRIBUTES = OWNED_ELEMENT_OPERATION_COUNT + 22;

  /**
   * The operation id for the '<em>Get Defined Attribute By Name</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_DEFINED_ATTRIBUTE_BY_NAME__STRING = OWNED_ELEMENT_OPERATION_COUNT + 23;

  /**
   * The operation id for the '<em>Get All Methods</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_ALL_METHODS = OWNED_ELEMENT_OPERATION_COUNT + 24;

  /**
   * The operation id for the '<em>Get Defined Methods</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_DEFINED_METHODS = OWNED_ELEMENT_OPERATION_COUNT + 25;

  /**
   * The operation id for the '<em>Is Instance Of</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___IS_INSTANCE_OF__CLABJECT = OWNED_ELEMENT_OPERATION_COUNT + 26;

  /**
   * The operation id for the '<em>Is Type Of</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___IS_TYPE_OF__CLABJECT = OWNED_ELEMENT_OPERATION_COUNT + 27;

  /**
   * The operation id for the '<em>Is Container Of</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___IS_CONTAINER_OF__CLABJECT = OWNED_ELEMENT_OPERATION_COUNT + 28;

  /**
   * The operation id for the '<em>Get Composite</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_COMPOSITE = OWNED_ELEMENT_OPERATION_COUNT + 29;

  /**
   * The operation id for the '<em>Get Aggregates</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_AGGREGATES = OWNED_ELEMENT_OPERATION_COUNT + 30;

  /**
   * The operation id for the '<em>Get Parts</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_PARTS = OWNED_ELEMENT_OPERATION_COUNT + 31;

  /**
   * The operation id for the '<em>Get Parts For Moniker</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_PARTS_FOR_MONIKER__STRING = OWNED_ELEMENT_OPERATION_COUNT + 32;

  /**
   * The operation id for the '<em>Get Defined Connections</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_DEFINED_CONNECTIONS = OWNED_ELEMENT_OPERATION_COUNT + 33;

  /**
   * The operation id for the '<em>Get Connections</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_CONNECTIONS = OWNED_ELEMENT_OPERATION_COUNT + 34;

  /**
   * The operation id for the '<em>Get Inherited Connections</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_INHERITED_CONNECTIONS = OWNED_ELEMENT_OPERATION_COUNT + 35;

  /**
   * The operation id for the '<em>Get Level Complete Types</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_LEVEL_COMPLETE_TYPES = OWNED_ELEMENT_OPERATION_COUNT + 36;

  /**
   * The operation id for the '<em>Get Level Incomplete Types</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_LEVEL_INCOMPLETE_TYPES = OWNED_ELEMENT_OPERATION_COUNT + 37;

  /**
   * The operation id for the '<em>Get Blueprint</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_BLUEPRINT = OWNED_ELEMENT_OPERATION_COUNT + 38;

  /**
   * The operation id for the '<em>Get Offspring</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_OFFSPRING = OWNED_ELEMENT_OPERATION_COUNT + 39;

  /**
   * The operation id for the '<em>Get Isonyms</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_ISONYMS = OWNED_ELEMENT_OPERATION_COUNT + 40;

  /**
   * The operation id for the '<em>Get Hyponyms</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_HYPONYMS = OWNED_ELEMENT_OPERATION_COUNT + 41;

  /**
   * The operation id for the '<em>Get Domain For Connection</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_DOMAIN_FOR_CONNECTION__CONNECTION = OWNED_ELEMENT_OPERATION_COUNT + 42;

  /**
   * The operation id for the '<em>Get Possible Domain Specific Visualizers</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated See {@link PLM.Clabject#getPossibleDomainSpecificVisualizers() model documentation} for details.
   * @generated
   * @ordered
   */
  @Deprecated
  int CLABJECT___GET_POSSIBLE_DOMAIN_SPECIFIC_VISUALIZERS = OWNED_ELEMENT_OPERATION_COUNT + 43;

  /**
   * The operation id for the '<em>Get Inheritances As Subtype</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_INHERITANCES_AS_SUBTYPE = OWNED_ELEMENT_OPERATION_COUNT + 44;

  /**
   * The operation id for the '<em>Get Inheritances As Supertype</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_INHERITANCES_AS_SUPERTYPE = OWNED_ELEMENT_OPERATION_COUNT + 45;

  /**
   * The operation id for the '<em>Get Defined Navigations</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_DEFINED_NAVIGATIONS = OWNED_ELEMENT_OPERATION_COUNT + 46;

  /**
   * The operation id for the '<em>Get Inherited Navigations</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_INHERITED_NAVIGATIONS = OWNED_ELEMENT_OPERATION_COUNT + 47;

  /**
   * The operation id for the '<em>Get All Navigations</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_ALL_NAVIGATIONS = OWNED_ELEMENT_OPERATION_COUNT + 48;

  /**
   * The operation id for the '<em>Get Domain Monikers</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_DOMAIN_MONIKERS = OWNED_ELEMENT_OPERATION_COUNT + 49;

  /**
   * The operation id for the '<em>Get Domain For Moniker</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   * @ordered
   */
  @Deprecated
  int CLABJECT___GET_DOMAIN_FOR_MONIKER__STRING = OWNED_ELEMENT_OPERATION_COUNT + 50;

  /**
   * The operation id for the '<em>Get All Navigations For Moniker</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_ALL_NAVIGATIONS_FOR_MONIKER__STRING = OWNED_ELEMENT_OPERATION_COUNT + 51;

  /**
   * The operation id for the '<em>Get All Navigations As Destination</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_ALL_NAVIGATIONS_AS_DESTINATION = OWNED_ELEMENT_OPERATION_COUNT + 52;

  /**
   * The operation id for the '<em>Get Defined Navigations As Destination</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_DEFINED_NAVIGATIONS_AS_DESTINATION = OWNED_ELEMENT_OPERATION_COUNT + 53;

  /**
   * The operation id for the '<em>Get Inherited Navigations As Destination</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_INHERITED_NAVIGATIONS_AS_DESTINATION = OWNED_ELEMENT_OPERATION_COUNT + 54;

  /**
   * The operation id for the '<em>Represent</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___REPRESENT = OWNED_ELEMENT_OPERATION_COUNT + 55;

  /**
   * The operation id for the '<em>Get Feature For Name</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_FEATURE_FOR_NAME__STRING = OWNED_ELEMENT_OPERATION_COUNT + 56;

  /**
   * The operation id for the '<em>Get Potency As String</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_POTENCY_AS_STRING = OWNED_ELEMENT_OPERATION_COUNT + 57;

  /**
   * The operation id for the '<em>Get Disjoint Siblings</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_DISJOINT_SIBLINGS = OWNED_ELEMENT_OPERATION_COUNT + 58;

  /**
   * The operation id for the '<em>Get Attribute By Name</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_ATTRIBUTE_BY_NAME__STRING = OWNED_ELEMENT_OPERATION_COUNT + 59;

  /**
   * The operation id for the '<em>Violates Multiplicity Constraints</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___VIOLATES_MULTIPLICITY_CONSTRAINTS = OWNED_ELEMENT_OPERATION_COUNT + 60;

  /**
   * The operation id for the '<em>Get Defined Inheritances</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_DEFINED_INHERITANCES = OWNED_ELEMENT_OPERATION_COUNT + 61;

  /**
   * The operation id for the '<em>Get Owned Clabjects</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_OWNED_CLABJECTS = OWNED_ELEMENT_OPERATION_COUNT + 62;

  /**
   * The operation id for the '<em>Get Direct Type</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT___GET_DIRECT_TYPE = OWNED_ELEMENT_OPERATION_COUNT + 63;

  /**
   * The number of operations of the '<em>Clabject</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT_OPERATION_COUNT = OWNED_ELEMENT_OPERATION_COUNT + 64;

  /**
   * The meta object id for the '{@link PLM.impl.FeatureImpl <em>Feature</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.impl.FeatureImpl
   * @see PLM.impl.PLMPackageImpl#getFeature()
   * @generated
   */
  int FEATURE = 11;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE__NAME = ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Visualizer</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE__VISUALIZER = ELEMENT__VISUALIZER;

  /**
   * The feature id for the '<em><b>Behavior</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE__BEHAVIOR = ELEMENT__BEHAVIOR;

  /**
   * The feature id for the '<em><b>Constraint</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE__CONSTRAINT = ELEMENT__CONSTRAINT;

  /**
   * The feature id for the '<em><b>Durability</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE__DURABILITY = ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Feature</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

  /**
   * The operation id for the '<em>Get Clabject</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE___GET_CLABJECT = ELEMENT_OPERATION_COUNT + 0;

  /**
   * The operation id for the '<em>Get Durability As String</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE___GET_DURABILITY_AS_STRING = ELEMENT_OPERATION_COUNT + 1;

  /**
   * The operation id for the '<em>Represent</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE___REPRESENT = ELEMENT_OPERATION_COUNT + 2;

  /**
   * The number of operations of the '<em>Feature</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 3;

  /**
   * The meta object id for the '{@link PLM.impl.EntityImpl <em>Entity</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.impl.EntityImpl
   * @see PLM.impl.PLMPackageImpl#getEntity()
   * @generated
   */
  int ENTITY = 12;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY__NAME = CLABJECT__NAME;

  /**
   * The feature id for the '<em><b>Visualizer</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY__VISUALIZER = CLABJECT__VISUALIZER;

  /**
   * The feature id for the '<em><b>Behavior</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY__BEHAVIOR = CLABJECT__BEHAVIOR;

  /**
   * The feature id for the '<em><b>Constraint</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY__CONSTRAINT = CLABJECT__CONSTRAINT;

  /**
   * The feature id for the '<em><b>Potency</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY__POTENCY = CLABJECT__POTENCY;

  /**
   * The feature id for the '<em><b>Level Index</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY__LEVEL_INDEX = CLABJECT__LEVEL_INDEX;

  /**
   * The feature id for the '<em><b>Content</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY__CONTENT = CLABJECT__CONTENT;

  /**
   * The feature id for the '<em><b>Feature</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY__FEATURE = CLABJECT__FEATURE;

  /**
   * The number of structural features of the '<em>Entity</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY_FEATURE_COUNT = CLABJECT_FEATURE_COUNT + 0;

  /**
   * The operation id for the '<em>Get Level</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_LEVEL = CLABJECT___GET_LEVEL;

  /**
   * The operation id for the '<em>Get Deep Model</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_DEEP_MODEL = CLABJECT___GET_DEEP_MODEL;

  /**
   * The operation id for the '<em>Get Supertypes</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_SUPERTYPES = CLABJECT___GET_SUPERTYPES;

  /**
   * The operation id for the '<em>Get Supertypes</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_SUPERTYPES__ELIST = CLABJECT___GET_SUPERTYPES__ELIST;

  /**
   * The operation id for the '<em>Get Direct Supertypes</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_DIRECT_SUPERTYPES = CLABJECT___GET_DIRECT_SUPERTYPES;

  /**
   * The operation id for the '<em>Get Subtypes</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_SUBTYPES = CLABJECT___GET_SUBTYPES;

  /**
   * The operation id for the '<em>Get Hollow Subtypes</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_HOLLOW_SUBTYPES = CLABJECT___GET_HOLLOW_SUBTYPES;

  /**
   * The operation id for the '<em>Get Hollow Supertypes</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_HOLLOW_SUPERTYPES = CLABJECT___GET_HOLLOW_SUPERTYPES;

  /**
   * The operation id for the '<em>Get Classifications As Instance</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_CLASSIFICATIONS_AS_INSTANCE = CLABJECT___GET_CLASSIFICATIONS_AS_INSTANCE;

  /**
   * The operation id for the '<em>Get Classifications As Type</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_CLASSIFICATIONS_AS_TYPE = CLABJECT___GET_CLASSIFICATIONS_AS_TYPE;

  /**
   * The operation id for the '<em>Get Instances</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_INSTANCES = CLABJECT___GET_INSTANCES;

  /**
   * The operation id for the '<em>Get Types</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_TYPES = CLABJECT___GET_TYPES;

  /**
   * The operation id for the '<em>Get Direct Types</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_DIRECT_TYPES = CLABJECT___GET_DIRECT_TYPES;

  /**
   * The operation id for the '<em>Get Level Types</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_LEVEL_TYPES = CLABJECT___GET_LEVEL_TYPES;

  /**
   * The operation id for the '<em>Get Defined Classification Tree As Instance</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_DEFINED_CLASSIFICATION_TREE_AS_INSTANCE = CLABJECT___GET_DEFINED_CLASSIFICATION_TREE_AS_INSTANCE;

  /**
   * The operation id for the '<em>Get Classification Tree As Instance</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_CLASSIFICATION_TREE_AS_INSTANCE = CLABJECT___GET_CLASSIFICATION_TREE_AS_INSTANCE;

  /**
   * The operation id for the '<em>Get Defined Instances</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_DEFINED_INSTANCES = CLABJECT___GET_DEFINED_INSTANCES;

  /**
   * The operation id for the '<em>Get Defined Classification Tree As Type</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_DEFINED_CLASSIFICATION_TREE_AS_TYPE = CLABJECT___GET_DEFINED_CLASSIFICATION_TREE_AS_TYPE;

  /**
   * The operation id for the '<em>Get Classification Tree As Type</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_CLASSIFICATION_TREE_AS_TYPE = CLABJECT___GET_CLASSIFICATION_TREE_AS_TYPE;

  /**
   * The operation id for the '<em>Get Classification Tree As Type</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_CLASSIFICATION_TREE_AS_TYPE__INT = CLABJECT___GET_CLASSIFICATION_TREE_AS_TYPE__INT;

  /**
   * The operation id for the '<em>Get Classification Tree As Type</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_CLASSIFICATION_TREE_AS_TYPE__INT_INT = CLABJECT___GET_CLASSIFICATION_TREE_AS_TYPE__INT_INT;

  /**
   * The operation id for the '<em>Get All Features</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_ALL_FEATURES = CLABJECT___GET_ALL_FEATURES;

  /**
   * The operation id for the '<em>Get All Attributes</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_ALL_ATTRIBUTES = CLABJECT___GET_ALL_ATTRIBUTES;

  /**
   * The operation id for the '<em>Get Defined Attributes</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_DEFINED_ATTRIBUTES = CLABJECT___GET_DEFINED_ATTRIBUTES;

  /**
   * The operation id for the '<em>Get Defined Attribute By Name</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_DEFINED_ATTRIBUTE_BY_NAME__STRING = CLABJECT___GET_DEFINED_ATTRIBUTE_BY_NAME__STRING;

  /**
   * The operation id for the '<em>Get All Methods</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_ALL_METHODS = CLABJECT___GET_ALL_METHODS;

  /**
   * The operation id for the '<em>Get Defined Methods</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_DEFINED_METHODS = CLABJECT___GET_DEFINED_METHODS;

  /**
   * The operation id for the '<em>Is Instance Of</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___IS_INSTANCE_OF__CLABJECT = CLABJECT___IS_INSTANCE_OF__CLABJECT;

  /**
   * The operation id for the '<em>Is Type Of</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___IS_TYPE_OF__CLABJECT = CLABJECT___IS_TYPE_OF__CLABJECT;

  /**
   * The operation id for the '<em>Is Container Of</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___IS_CONTAINER_OF__CLABJECT = CLABJECT___IS_CONTAINER_OF__CLABJECT;

  /**
   * The operation id for the '<em>Get Composite</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_COMPOSITE = CLABJECT___GET_COMPOSITE;

  /**
   * The operation id for the '<em>Get Aggregates</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_AGGREGATES = CLABJECT___GET_AGGREGATES;

  /**
   * The operation id for the '<em>Get Parts</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_PARTS = CLABJECT___GET_PARTS;

  /**
   * The operation id for the '<em>Get Parts For Moniker</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_PARTS_FOR_MONIKER__STRING = CLABJECT___GET_PARTS_FOR_MONIKER__STRING;

  /**
   * The operation id for the '<em>Get Defined Connections</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_DEFINED_CONNECTIONS = CLABJECT___GET_DEFINED_CONNECTIONS;

  /**
   * The operation id for the '<em>Get Connections</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_CONNECTIONS = CLABJECT___GET_CONNECTIONS;

  /**
   * The operation id for the '<em>Get Inherited Connections</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_INHERITED_CONNECTIONS = CLABJECT___GET_INHERITED_CONNECTIONS;

  /**
   * The operation id for the '<em>Get Level Complete Types</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_LEVEL_COMPLETE_TYPES = CLABJECT___GET_LEVEL_COMPLETE_TYPES;

  /**
   * The operation id for the '<em>Get Level Incomplete Types</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_LEVEL_INCOMPLETE_TYPES = CLABJECT___GET_LEVEL_INCOMPLETE_TYPES;

  /**
   * The operation id for the '<em>Get Blueprint</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_BLUEPRINT = CLABJECT___GET_BLUEPRINT;

  /**
   * The operation id for the '<em>Get Offspring</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_OFFSPRING = CLABJECT___GET_OFFSPRING;

  /**
   * The operation id for the '<em>Get Isonyms</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_ISONYMS = CLABJECT___GET_ISONYMS;

  /**
   * The operation id for the '<em>Get Hyponyms</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_HYPONYMS = CLABJECT___GET_HYPONYMS;

  /**
   * The operation id for the '<em>Get Domain For Connection</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_DOMAIN_FOR_CONNECTION__CONNECTION = CLABJECT___GET_DOMAIN_FOR_CONNECTION__CONNECTION;

  /**
   * The operation id for the '<em>Get Possible Domain Specific Visualizers</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated See {@link PLM.Clabject#getPossibleDomainSpecificVisualizers() model documentation} for details.
   * @generated
   * @ordered
   */
  @Deprecated
  int ENTITY___GET_POSSIBLE_DOMAIN_SPECIFIC_VISUALIZERS = CLABJECT___GET_POSSIBLE_DOMAIN_SPECIFIC_VISUALIZERS;

  /**
   * The operation id for the '<em>Get Inheritances As Subtype</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_INHERITANCES_AS_SUBTYPE = CLABJECT___GET_INHERITANCES_AS_SUBTYPE;

  /**
   * The operation id for the '<em>Get Inheritances As Supertype</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_INHERITANCES_AS_SUPERTYPE = CLABJECT___GET_INHERITANCES_AS_SUPERTYPE;

  /**
   * The operation id for the '<em>Get Defined Navigations</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_DEFINED_NAVIGATIONS = CLABJECT___GET_DEFINED_NAVIGATIONS;

  /**
   * The operation id for the '<em>Get Inherited Navigations</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_INHERITED_NAVIGATIONS = CLABJECT___GET_INHERITED_NAVIGATIONS;

  /**
   * The operation id for the '<em>Get All Navigations</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_ALL_NAVIGATIONS = CLABJECT___GET_ALL_NAVIGATIONS;

  /**
   * The operation id for the '<em>Get Domain Monikers</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_DOMAIN_MONIKERS = CLABJECT___GET_DOMAIN_MONIKERS;

  /**
   * The operation id for the '<em>Get Domain For Moniker</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   * @ordered
   */
  @Deprecated
  int ENTITY___GET_DOMAIN_FOR_MONIKER__STRING = CLABJECT___GET_DOMAIN_FOR_MONIKER__STRING;

  /**
   * The operation id for the '<em>Get All Navigations For Moniker</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_ALL_NAVIGATIONS_FOR_MONIKER__STRING = CLABJECT___GET_ALL_NAVIGATIONS_FOR_MONIKER__STRING;

  /**
   * The operation id for the '<em>Get All Navigations As Destination</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_ALL_NAVIGATIONS_AS_DESTINATION = CLABJECT___GET_ALL_NAVIGATIONS_AS_DESTINATION;

  /**
   * The operation id for the '<em>Get Defined Navigations As Destination</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_DEFINED_NAVIGATIONS_AS_DESTINATION = CLABJECT___GET_DEFINED_NAVIGATIONS_AS_DESTINATION;

  /**
   * The operation id for the '<em>Get Inherited Navigations As Destination</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_INHERITED_NAVIGATIONS_AS_DESTINATION = CLABJECT___GET_INHERITED_NAVIGATIONS_AS_DESTINATION;

  /**
   * The operation id for the '<em>Get Feature For Name</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_FEATURE_FOR_NAME__STRING = CLABJECT___GET_FEATURE_FOR_NAME__STRING;

  /**
   * The operation id for the '<em>Get Potency As String</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_POTENCY_AS_STRING = CLABJECT___GET_POTENCY_AS_STRING;

  /**
   * The operation id for the '<em>Get Disjoint Siblings</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_DISJOINT_SIBLINGS = CLABJECT___GET_DISJOINT_SIBLINGS;

  /**
   * The operation id for the '<em>Get Attribute By Name</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_ATTRIBUTE_BY_NAME__STRING = CLABJECT___GET_ATTRIBUTE_BY_NAME__STRING;

  /**
   * The operation id for the '<em>Violates Multiplicity Constraints</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___VIOLATES_MULTIPLICITY_CONSTRAINTS = CLABJECT___VIOLATES_MULTIPLICITY_CONSTRAINTS;

  /**
   * The operation id for the '<em>Get Defined Inheritances</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_DEFINED_INHERITANCES = CLABJECT___GET_DEFINED_INHERITANCES;

  /**
   * The operation id for the '<em>Get Owned Clabjects</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_OWNED_CLABJECTS = CLABJECT___GET_OWNED_CLABJECTS;

  /**
   * The operation id for the '<em>Get Direct Type</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___GET_DIRECT_TYPE = CLABJECT___GET_DIRECT_TYPE;

  /**
   * The operation id for the '<em>Represent</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___REPRESENT = CLABJECT_OPERATION_COUNT + 0;

  /**
   * The number of operations of the '<em>Entity</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY_OPERATION_COUNT = CLABJECT_OPERATION_COUNT + 1;

  /**
   * The meta object id for the '{@link PLM.impl.ConnectionImpl <em>Connection</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.impl.ConnectionImpl
   * @see PLM.impl.PLMPackageImpl#getConnection()
   * @generated
   */
  int CONNECTION = 13;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION__NAME = CLABJECT__NAME;

  /**
   * The feature id for the '<em><b>Visualizer</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION__VISUALIZER = CLABJECT__VISUALIZER;

  /**
   * The feature id for the '<em><b>Behavior</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION__BEHAVIOR = CLABJECT__BEHAVIOR;

  /**
   * The feature id for the '<em><b>Constraint</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION__CONSTRAINT = CLABJECT__CONSTRAINT;

  /**
   * The feature id for the '<em><b>Potency</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION__POTENCY = CLABJECT__POTENCY;

  /**
   * The feature id for the '<em><b>Level Index</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION__LEVEL_INDEX = CLABJECT__LEVEL_INDEX;

  /**
   * The feature id for the '<em><b>Content</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION__CONTENT = CLABJECT__CONTENT;

  /**
   * The feature id for the '<em><b>Feature</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION__FEATURE = CLABJECT__FEATURE;

  /**
   * The feature id for the '<em><b>Connection End</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION__CONNECTION_END = CLABJECT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Connection</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION_FEATURE_COUNT = CLABJECT_FEATURE_COUNT + 1;

  /**
   * The operation id for the '<em>Get Level</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_LEVEL = CLABJECT___GET_LEVEL;

  /**
   * The operation id for the '<em>Get Deep Model</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_DEEP_MODEL = CLABJECT___GET_DEEP_MODEL;

  /**
   * The operation id for the '<em>Get Supertypes</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_SUPERTYPES = CLABJECT___GET_SUPERTYPES;

  /**
   * The operation id for the '<em>Get Supertypes</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_SUPERTYPES__ELIST = CLABJECT___GET_SUPERTYPES__ELIST;

  /**
   * The operation id for the '<em>Get Direct Supertypes</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_DIRECT_SUPERTYPES = CLABJECT___GET_DIRECT_SUPERTYPES;

  /**
   * The operation id for the '<em>Get Subtypes</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_SUBTYPES = CLABJECT___GET_SUBTYPES;

  /**
   * The operation id for the '<em>Get Hollow Subtypes</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_HOLLOW_SUBTYPES = CLABJECT___GET_HOLLOW_SUBTYPES;

  /**
   * The operation id for the '<em>Get Hollow Supertypes</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_HOLLOW_SUPERTYPES = CLABJECT___GET_HOLLOW_SUPERTYPES;

  /**
   * The operation id for the '<em>Get Classifications As Instance</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_CLASSIFICATIONS_AS_INSTANCE = CLABJECT___GET_CLASSIFICATIONS_AS_INSTANCE;

  /**
   * The operation id for the '<em>Get Classifications As Type</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_CLASSIFICATIONS_AS_TYPE = CLABJECT___GET_CLASSIFICATIONS_AS_TYPE;

  /**
   * The operation id for the '<em>Get Instances</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_INSTANCES = CLABJECT___GET_INSTANCES;

  /**
   * The operation id for the '<em>Get Types</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_TYPES = CLABJECT___GET_TYPES;

  /**
   * The operation id for the '<em>Get Direct Types</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_DIRECT_TYPES = CLABJECT___GET_DIRECT_TYPES;

  /**
   * The operation id for the '<em>Get Level Types</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_LEVEL_TYPES = CLABJECT___GET_LEVEL_TYPES;

  /**
   * The operation id for the '<em>Get Defined Classification Tree As Instance</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_DEFINED_CLASSIFICATION_TREE_AS_INSTANCE = CLABJECT___GET_DEFINED_CLASSIFICATION_TREE_AS_INSTANCE;

  /**
   * The operation id for the '<em>Get Classification Tree As Instance</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_CLASSIFICATION_TREE_AS_INSTANCE = CLABJECT___GET_CLASSIFICATION_TREE_AS_INSTANCE;

  /**
   * The operation id for the '<em>Get Defined Instances</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_DEFINED_INSTANCES = CLABJECT___GET_DEFINED_INSTANCES;

  /**
   * The operation id for the '<em>Get Defined Classification Tree As Type</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_DEFINED_CLASSIFICATION_TREE_AS_TYPE = CLABJECT___GET_DEFINED_CLASSIFICATION_TREE_AS_TYPE;

  /**
   * The operation id for the '<em>Get Classification Tree As Type</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_CLASSIFICATION_TREE_AS_TYPE = CLABJECT___GET_CLASSIFICATION_TREE_AS_TYPE;

  /**
   * The operation id for the '<em>Get Classification Tree As Type</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_CLASSIFICATION_TREE_AS_TYPE__INT = CLABJECT___GET_CLASSIFICATION_TREE_AS_TYPE__INT;

  /**
   * The operation id for the '<em>Get Classification Tree As Type</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_CLASSIFICATION_TREE_AS_TYPE__INT_INT = CLABJECT___GET_CLASSIFICATION_TREE_AS_TYPE__INT_INT;

  /**
   * The operation id for the '<em>Get All Features</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_ALL_FEATURES = CLABJECT___GET_ALL_FEATURES;

  /**
   * The operation id for the '<em>Get All Attributes</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_ALL_ATTRIBUTES = CLABJECT___GET_ALL_ATTRIBUTES;

  /**
   * The operation id for the '<em>Get Defined Attributes</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_DEFINED_ATTRIBUTES = CLABJECT___GET_DEFINED_ATTRIBUTES;

  /**
   * The operation id for the '<em>Get Defined Attribute By Name</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_DEFINED_ATTRIBUTE_BY_NAME__STRING = CLABJECT___GET_DEFINED_ATTRIBUTE_BY_NAME__STRING;

  /**
   * The operation id for the '<em>Get All Methods</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_ALL_METHODS = CLABJECT___GET_ALL_METHODS;

  /**
   * The operation id for the '<em>Get Defined Methods</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_DEFINED_METHODS = CLABJECT___GET_DEFINED_METHODS;

  /**
   * The operation id for the '<em>Is Instance Of</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___IS_INSTANCE_OF__CLABJECT = CLABJECT___IS_INSTANCE_OF__CLABJECT;

  /**
   * The operation id for the '<em>Is Type Of</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___IS_TYPE_OF__CLABJECT = CLABJECT___IS_TYPE_OF__CLABJECT;

  /**
   * The operation id for the '<em>Is Container Of</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___IS_CONTAINER_OF__CLABJECT = CLABJECT___IS_CONTAINER_OF__CLABJECT;

  /**
   * The operation id for the '<em>Get Composite</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_COMPOSITE = CLABJECT___GET_COMPOSITE;

  /**
   * The operation id for the '<em>Get Aggregates</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_AGGREGATES = CLABJECT___GET_AGGREGATES;

  /**
   * The operation id for the '<em>Get Parts</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_PARTS = CLABJECT___GET_PARTS;

  /**
   * The operation id for the '<em>Get Parts For Moniker</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_PARTS_FOR_MONIKER__STRING = CLABJECT___GET_PARTS_FOR_MONIKER__STRING;

  /**
   * The operation id for the '<em>Get Defined Connections</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_DEFINED_CONNECTIONS = CLABJECT___GET_DEFINED_CONNECTIONS;

  /**
   * The operation id for the '<em>Get Connections</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_CONNECTIONS = CLABJECT___GET_CONNECTIONS;

  /**
   * The operation id for the '<em>Get Inherited Connections</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_INHERITED_CONNECTIONS = CLABJECT___GET_INHERITED_CONNECTIONS;

  /**
   * The operation id for the '<em>Get Level Complete Types</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_LEVEL_COMPLETE_TYPES = CLABJECT___GET_LEVEL_COMPLETE_TYPES;

  /**
   * The operation id for the '<em>Get Level Incomplete Types</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_LEVEL_INCOMPLETE_TYPES = CLABJECT___GET_LEVEL_INCOMPLETE_TYPES;

  /**
   * The operation id for the '<em>Get Blueprint</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_BLUEPRINT = CLABJECT___GET_BLUEPRINT;

  /**
   * The operation id for the '<em>Get Offspring</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_OFFSPRING = CLABJECT___GET_OFFSPRING;

  /**
   * The operation id for the '<em>Get Isonyms</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_ISONYMS = CLABJECT___GET_ISONYMS;

  /**
   * The operation id for the '<em>Get Hyponyms</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_HYPONYMS = CLABJECT___GET_HYPONYMS;

  /**
   * The operation id for the '<em>Get Domain For Connection</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_DOMAIN_FOR_CONNECTION__CONNECTION = CLABJECT___GET_DOMAIN_FOR_CONNECTION__CONNECTION;

  /**
   * The operation id for the '<em>Get Possible Domain Specific Visualizers</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated See {@link PLM.Clabject#getPossibleDomainSpecificVisualizers() model documentation} for details.
   * @generated
   * @ordered
   */
  @Deprecated
  int CONNECTION___GET_POSSIBLE_DOMAIN_SPECIFIC_VISUALIZERS = CLABJECT___GET_POSSIBLE_DOMAIN_SPECIFIC_VISUALIZERS;

  /**
   * The operation id for the '<em>Get Inheritances As Subtype</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_INHERITANCES_AS_SUBTYPE = CLABJECT___GET_INHERITANCES_AS_SUBTYPE;

  /**
   * The operation id for the '<em>Get Inheritances As Supertype</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_INHERITANCES_AS_SUPERTYPE = CLABJECT___GET_INHERITANCES_AS_SUPERTYPE;

  /**
   * The operation id for the '<em>Get Defined Navigations</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_DEFINED_NAVIGATIONS = CLABJECT___GET_DEFINED_NAVIGATIONS;

  /**
   * The operation id for the '<em>Get Inherited Navigations</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_INHERITED_NAVIGATIONS = CLABJECT___GET_INHERITED_NAVIGATIONS;

  /**
   * The operation id for the '<em>Get All Navigations</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_ALL_NAVIGATIONS = CLABJECT___GET_ALL_NAVIGATIONS;

  /**
   * The operation id for the '<em>Get Domain Monikers</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_DOMAIN_MONIKERS = CLABJECT___GET_DOMAIN_MONIKERS;

  /**
   * The operation id for the '<em>Get Domain For Moniker</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   * @ordered
   */
  @Deprecated
  int CONNECTION___GET_DOMAIN_FOR_MONIKER__STRING = CLABJECT___GET_DOMAIN_FOR_MONIKER__STRING;

  /**
   * The operation id for the '<em>Get All Navigations For Moniker</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_ALL_NAVIGATIONS_FOR_MONIKER__STRING = CLABJECT___GET_ALL_NAVIGATIONS_FOR_MONIKER__STRING;

  /**
   * The operation id for the '<em>Get All Navigations As Destination</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_ALL_NAVIGATIONS_AS_DESTINATION = CLABJECT___GET_ALL_NAVIGATIONS_AS_DESTINATION;

  /**
   * The operation id for the '<em>Get Defined Navigations As Destination</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_DEFINED_NAVIGATIONS_AS_DESTINATION = CLABJECT___GET_DEFINED_NAVIGATIONS_AS_DESTINATION;

  /**
   * The operation id for the '<em>Get Inherited Navigations As Destination</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_INHERITED_NAVIGATIONS_AS_DESTINATION = CLABJECT___GET_INHERITED_NAVIGATIONS_AS_DESTINATION;

  /**
   * The operation id for the '<em>Get Feature For Name</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_FEATURE_FOR_NAME__STRING = CLABJECT___GET_FEATURE_FOR_NAME__STRING;

  /**
   * The operation id for the '<em>Get Potency As String</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_POTENCY_AS_STRING = CLABJECT___GET_POTENCY_AS_STRING;

  /**
   * The operation id for the '<em>Get Disjoint Siblings</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_DISJOINT_SIBLINGS = CLABJECT___GET_DISJOINT_SIBLINGS;

  /**
   * The operation id for the '<em>Get Attribute By Name</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_ATTRIBUTE_BY_NAME__STRING = CLABJECT___GET_ATTRIBUTE_BY_NAME__STRING;

  /**
   * The operation id for the '<em>Violates Multiplicity Constraints</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___VIOLATES_MULTIPLICITY_CONSTRAINTS = CLABJECT___VIOLATES_MULTIPLICITY_CONSTRAINTS;

  /**
   * The operation id for the '<em>Get Defined Inheritances</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_DEFINED_INHERITANCES = CLABJECT___GET_DEFINED_INHERITANCES;

  /**
   * The operation id for the '<em>Get Owned Clabjects</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_OWNED_CLABJECTS = CLABJECT___GET_OWNED_CLABJECTS;

  /**
   * The operation id for the '<em>Get Direct Type</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_DIRECT_TYPE = CLABJECT___GET_DIRECT_TYPE;

  /**
   * The operation id for the '<em>Get Domain</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_DOMAIN = CLABJECT_OPERATION_COUNT + 0;

  /**
   * The operation id for the '<em>Get Not Domain</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_NOT_DOMAIN = CLABJECT_OPERATION_COUNT + 1;

  /**
   * The operation id for the '<em>Get Human Readable Name</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_HUMAN_READABLE_NAME = CLABJECT_OPERATION_COUNT + 2;

  /**
   * The operation id for the '<em>Get Participants</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_PARTICIPANTS = CLABJECT_OPERATION_COUNT + 3;

  /**
   * The operation id for the '<em>Get Moniker</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_MONIKER = CLABJECT_OPERATION_COUNT + 4;

  /**
   * The operation id for the '<em>Get Domain</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_DOMAIN__CLABJECT = CLABJECT_OPERATION_COUNT + 5;

  /**
   * The operation id for the '<em>Get Moniker For Participant</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_MONIKER_FOR_PARTICIPANT__CLABJECT = CLABJECT_OPERATION_COUNT + 6;

  /**
   * The operation id for the '<em>Get Lower For Moniker</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_LOWER_FOR_MONIKER__STRING = CLABJECT_OPERATION_COUNT + 7;

  /**
   * The operation id for the '<em>Get Upper For Moniker</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_UPPER_FOR_MONIKER__STRING = CLABJECT_OPERATION_COUNT + 8;

  /**
   * The operation id for the '<em>Is Navigable For Moniker</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___IS_NAVIGABLE_FOR_MONIKER__STRING = CLABJECT_OPERATION_COUNT + 9;

  /**
   * The operation id for the '<em>Get Order</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_ORDER = CLABJECT_OPERATION_COUNT + 10;

  /**
   * The operation id for the '<em>Get Inherited Connection End</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_INHERITED_CONNECTION_END = CLABJECT_OPERATION_COUNT + 11;

  /**
   * The operation id for the '<em>Get All Connection End</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_ALL_CONNECTION_END = CLABJECT_OPERATION_COUNT + 12;

  /**
   * The operation id for the '<em>Get Participant For Moniker</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___GET_PARTICIPANT_FOR_MONIKER__STRING = CLABJECT_OPERATION_COUNT + 13;

  /**
   * The operation id for the '<em>Represent</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION___REPRESENT = CLABJECT_OPERATION_COUNT + 14;

  /**
   * The number of operations of the '<em>Connection</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION_OPERATION_COUNT = CLABJECT_OPERATION_COUNT + 15;

  /**
   * The meta object id for the '{@link PLM.impl.PropertyImpl <em>Property</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.impl.PropertyImpl
   * @see PLM.impl.PLMPackageImpl#getProperty()
   * @generated
   */
  int PROPERTY = 16;

  /**
   * The feature id for the '<em><b>Parsing Order</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY__PARSING_ORDER = 0;

  /**
   * The number of structural features of the '<em>Property</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_FEATURE_COUNT = 1;

  /**
   * The number of operations of the '<em>Property</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link PLM.impl.ConnectionEndImpl <em>Connection End</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.impl.ConnectionEndImpl
   * @see PLM.impl.PLMPackageImpl#getConnectionEnd()
   * @generated
   */
  int CONNECTION_END = 14;

  /**
   * The feature id for the '<em><b>Parsing Order</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION_END__PARSING_ORDER = PROPERTY__PARSING_ORDER;

  /**
   * The feature id for the '<em><b>Lower</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION_END__LOWER = PROPERTY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Upper</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION_END__UPPER = PROPERTY_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Navigable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION_END__NAVIGABLE = PROPERTY_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Destination</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION_END__DESTINATION = PROPERTY_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Connection</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION_END__CONNECTION = PROPERTY_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Moniker</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION_END__MONIKER = PROPERTY_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION_END__KIND = PROPERTY_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION_END__TYPE = PROPERTY_FEATURE_COUNT + 7;

  /**
   * The feature id for the '<em><b>Multiplicity</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION_END__MULTIPLICITY = PROPERTY_FEATURE_COUNT + 8;

  /**
   * The number of structural features of the '<em>Connection End</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION_END_FEATURE_COUNT = PROPERTY_FEATURE_COUNT + 9;

  /**
   * The operation id for the '<em>Get Human Readable Connection End Name</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION_END___GET_HUMAN_READABLE_CONNECTION_END_NAME = PROPERTY_OPERATION_COUNT + 0;

  /**
   * The operation id for the '<em>Has Default Moniker</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION_END___HAS_DEFAULT_MONIKER = PROPERTY_OPERATION_COUNT + 1;

  /**
   * The operation id for the '<em>Represent</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION_END___REPRESENT = PROPERTY_OPERATION_COUNT + 2;

  /**
   * The operation id for the '<em>Moniker</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION_END___MONIKER = PROPERTY_OPERATION_COUNT + 3;

  /**
   * The operation id for the '<em>Represent Multiplicity</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION_END___REPRESENT_MULTIPLICITY = PROPERTY_OPERATION_COUNT + 4;

  /**
   * The operation id for the '<em>Get Connection End Name</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION_END___GET_CONNECTION_END_NAME = PROPERTY_OPERATION_COUNT + 5;

  /**
   * The operation id for the '<em>Conforms</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION_END___CONFORMS__CONNECTIONEND = PROPERTY_OPERATION_COUNT + 6;

  /**
   * The number of operations of the '<em>Connection End</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONNECTION_END_OPERATION_COUNT = PROPERTY_OPERATION_COUNT + 7;

  /**
   * The meta object id for the '{@link PLM.impl.LMLVisualizerImpl <em>LML Visualizer</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.impl.LMLVisualizerImpl
   * @see PLM.impl.PLMPackageImpl#getLMLVisualizer()
   * @generated
   */
  int LML_VISUALIZER = 15;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LML_VISUALIZER__ATTRIBUTES = 0;

  /**
   * The feature id for the '<em><b>Dsl Visualizer</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LML_VISUALIZER__DSL_VISUALIZER = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LML_VISUALIZER__NAME = 2;

  /**
   * The feature id for the '<em><b>XLocation</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LML_VISUALIZER__XLOCATION = 3;

  /**
   * The feature id for the '<em><b>YLocation</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LML_VISUALIZER__YLOCATION = 4;

  /**
   * The feature id for the '<em><b>Width</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LML_VISUALIZER__WIDTH = 5;

  /**
   * The feature id for the '<em><b>Height</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LML_VISUALIZER__HEIGHT = 6;

  /**
   * The number of structural features of the '<em>LML Visualizer</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LML_VISUALIZER_FEATURE_COUNT = 7;

  /**
   * The operation id for the '<em>Get Default Visualization Values</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LML_VISUALIZER___GET_DEFAULT_VISUALIZATION_VALUES = 0;

  /**
   * The operation id for the '<em>Get Value For Key</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LML_VISUALIZER___GET_VALUE_FOR_KEY__STRING = 1;

  /**
   * The operation id for the '<em>Get Containing Element</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LML_VISUALIZER___GET_CONTAINING_ELEMENT = 2;

  /**
   * The operation id for the '<em>EOperation0</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LML_VISUALIZER___EOPERATION0 = 3;

  /**
   * The number of operations of the '<em>LML Visualizer</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LML_VISUALIZER_OPERATION_COUNT = 4;

  /**
   * The meta object id for the '{@link PLM.impl.AttributeImpl <em>Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.impl.AttributeImpl
   * @see PLM.impl.PLMPackageImpl#getAttribute()
   * @generated
   */
  int ATTRIBUTE = 17;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__NAME = FEATURE__NAME;

  /**
   * The feature id for the '<em><b>Visualizer</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__VISUALIZER = FEATURE__VISUALIZER;

  /**
   * The feature id for the '<em><b>Behavior</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__BEHAVIOR = FEATURE__BEHAVIOR;

  /**
   * The feature id for the '<em><b>Constraint</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__CONSTRAINT = FEATURE__CONSTRAINT;

  /**
   * The feature id for the '<em><b>Durability</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__DURABILITY = FEATURE__DURABILITY;

  /**
   * The feature id for the '<em><b>Parsing Order</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__PARSING_ORDER = FEATURE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__VALUE = FEATURE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Mutability</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__MUTABILITY = FEATURE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Datatype</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__DATATYPE = FEATURE_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_FEATURE_COUNT = FEATURE_FEATURE_COUNT + 4;

  /**
   * The operation id for the '<em>Get Clabject</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE___GET_CLABJECT = FEATURE___GET_CLABJECT;

  /**
   * The operation id for the '<em>Get Durability As String</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE___GET_DURABILITY_AS_STRING = FEATURE___GET_DURABILITY_AS_STRING;

  /**
   * The operation id for the '<em>Get Mutability As String</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE___GET_MUTABILITY_AS_STRING = FEATURE_OPERATION_COUNT + 0;

  /**
   * The operation id for the '<em>Represent</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE___REPRESENT = FEATURE_OPERATION_COUNT + 1;

  /**
   * The operation id for the '<em>Get Possible Data Types</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE___GET_POSSIBLE_DATA_TYPES = FEATURE_OPERATION_COUNT + 2;

  /**
   * The operation id for the '<em>Get Primitive Data Types</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE___GET_PRIMITIVE_DATA_TYPES = FEATURE_OPERATION_COUNT + 3;

  /**
   * The operation id for the '<em>Get Enumeration Data Types</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE___GET_ENUMERATION_DATA_TYPES = FEATURE_OPERATION_COUNT + 4;

  /**
   * The operation id for the '<em>Is Enumeration</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE___IS_ENUMERATION = FEATURE_OPERATION_COUNT + 5;

  /**
   * The operation id for the '<em>Get Enumeration</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE___GET_ENUMERATION = FEATURE_OPERATION_COUNT + 6;

  /**
   * The operation id for the '<em>Get Literals</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE___GET_LITERALS = FEATURE_OPERATION_COUNT + 7;

  /**
   * The number of operations of the '<em>Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_OPERATION_COUNT = FEATURE_OPERATION_COUNT + 8;

  /**
   * The meta object id for the '{@link PLM.impl.MethodImpl <em>Method</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.impl.MethodImpl
   * @see PLM.impl.PLMPackageImpl#getMethod()
   * @generated
   */
  int METHOD = 18;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD__NAME = FEATURE__NAME;

  /**
   * The feature id for the '<em><b>Visualizer</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD__VISUALIZER = FEATURE__VISUALIZER;

  /**
   * The feature id for the '<em><b>Behavior</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD__BEHAVIOR = FEATURE__BEHAVIOR;

  /**
   * The feature id for the '<em><b>Constraint</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD__CONSTRAINT = FEATURE__CONSTRAINT;

  /**
   * The feature id for the '<em><b>Durability</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD__DURABILITY = FEATURE__DURABILITY;

  /**
   * The feature id for the '<em><b>Body</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD__BODY = FEATURE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD__PARAMETER = FEATURE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Method</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_FEATURE_COUNT = FEATURE_FEATURE_COUNT + 2;

  /**
   * The operation id for the '<em>Get Clabject</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD___GET_CLABJECT = FEATURE___GET_CLABJECT;

  /**
   * The operation id for the '<em>Get Durability As String</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD___GET_DURABILITY_AS_STRING = FEATURE___GET_DURABILITY_AS_STRING;

  /**
   * The operation id for the '<em>Represent</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD___REPRESENT = FEATURE_OPERATION_COUNT + 0;

  /**
   * The operation id for the '<em>Get Input</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD___GET_INPUT = FEATURE_OPERATION_COUNT + 1;

  /**
   * The operation id for the '<em>Get Output</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD___GET_OUTPUT = FEATURE_OPERATION_COUNT + 2;

  /**
   * The number of operations of the '<em>Method</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_OPERATION_COUNT = FEATURE_OPERATION_COUNT + 3;

  /**
   * The meta object id for the '{@link PLM.impl.EnumerationImpl <em>Enumeration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.impl.EnumerationImpl
   * @see PLM.impl.PLMPackageImpl#getEnumeration()
   * @generated
   */
  int ENUMERATION = 19;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUMERATION__NAME = ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Visualizer</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUMERATION__VISUALIZER = ELEMENT__VISUALIZER;

  /**
   * The feature id for the '<em><b>Behavior</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUMERATION__BEHAVIOR = ELEMENT__BEHAVIOR;

  /**
   * The feature id for the '<em><b>Constraint</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUMERATION__CONSTRAINT = ELEMENT__CONSTRAINT;

  /**
   * The feature id for the '<em><b>Literal</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUMERATION__LITERAL = ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Enumeration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUMERATION_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of operations of the '<em>Enumeration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUMERATION_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link PLM.impl.ParameterImpl <em>Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.impl.ParameterImpl
   * @see PLM.impl.PLMPackageImpl#getParameter()
   * @generated
   */
  int PARAMETER = 20;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER__NAME = 0;

  /**
   * The feature id for the '<em><b>Expression</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER__EXPRESSION = 1;

  /**
   * The feature id for the '<em><b>Output</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER__OUTPUT = 2;

  /**
   * The number of structural features of the '<em>Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_FEATURE_COUNT = 3;

  /**
   * The operation id for the '<em>Get Clabject</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER___GET_CLABJECT = 0;

  /**
   * The number of operations of the '<em>Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_OPERATION_COUNT = 1;

  /**
   * The meta object id for the '{@link PLM.impl.ClabjectParameterImpl <em>Clabject Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.impl.ClabjectParameterImpl
   * @see PLM.impl.PLMPackageImpl#getClabjectParameter()
   * @generated
   */
  int CLABJECT_PARAMETER = 21;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT_PARAMETER__NAME = PARAMETER__NAME;

  /**
   * The feature id for the '<em><b>Expression</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT_PARAMETER__EXPRESSION = PARAMETER__EXPRESSION;

  /**
   * The feature id for the '<em><b>Output</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT_PARAMETER__OUTPUT = PARAMETER__OUTPUT;

  /**
   * The feature id for the '<em><b>Datatype</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT_PARAMETER__DATATYPE = PARAMETER_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Clabject Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT_PARAMETER_FEATURE_COUNT = PARAMETER_FEATURE_COUNT + 1;

  /**
   * The operation id for the '<em>Get Clabject</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT_PARAMETER___GET_CLABJECT = PARAMETER___GET_CLABJECT;

  /**
   * The number of operations of the '<em>Clabject Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLABJECT_PARAMETER_OPERATION_COUNT = PARAMETER_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link PLM.impl.PrimitiveParameterImpl <em>Primitive Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.impl.PrimitiveParameterImpl
   * @see PLM.impl.PLMPackageImpl#getPrimitiveParameter()
   * @generated
   */
  int PRIMITIVE_PARAMETER = 22;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_PARAMETER__NAME = PARAMETER__NAME;

  /**
   * The feature id for the '<em><b>Expression</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_PARAMETER__EXPRESSION = PARAMETER__EXPRESSION;

  /**
   * The feature id for the '<em><b>Output</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_PARAMETER__OUTPUT = PARAMETER__OUTPUT;

  /**
   * The feature id for the '<em><b>Datatype</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_PARAMETER__DATATYPE = PARAMETER_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Primitive Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_PARAMETER_FEATURE_COUNT = PARAMETER_FEATURE_COUNT + 1;

  /**
   * The operation id for the '<em>Get Clabject</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_PARAMETER___GET_CLABJECT = PARAMETER___GET_CLABJECT;

  /**
   * The number of operations of the '<em>Primitive Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_PARAMETER_OPERATION_COUNT = PARAMETER_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link PLM.impl.MultiplicityImpl <em>Multiplicity</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.impl.MultiplicityImpl
   * @see PLM.impl.PLMPackageImpl#getMultiplicity()
   * @generated
   */
  int MULTIPLICITY = 23;

  /**
   * The feature id for the '<em><b>Lower</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICITY__LOWER = 0;

  /**
   * The feature id for the '<em><b>Upper</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICITY__UPPER = 1;

  /**
   * The feature id for the '<em><b>Potency</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICITY__POTENCY = 2;

  /**
   * The feature id for the '<em><b>Connectionend</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICITY__CONNECTIONEND = 3;

  /**
   * The number of structural features of the '<em>Multiplicity</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICITY_FEATURE_COUNT = 4;

  /**
   * The number of operations of the '<em>Multiplicity</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICITY_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link PLM.impl.PackageImpl <em>Package</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.impl.PackageImpl
   * @see PLM.impl.PLMPackageImpl#getPackage()
   * @generated
   */
  int PACKAGE = 24;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE__NAME = OWNED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Visualizer</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE__VISUALIZER = OWNED_ELEMENT__VISUALIZER;

  /**
   * The feature id for the '<em><b>Behavior</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE__BEHAVIOR = OWNED_ELEMENT__BEHAVIOR;

  /**
   * The feature id for the '<em><b>Constraint</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE__CONSTRAINT = OWNED_ELEMENT__CONSTRAINT;

  /**
   * The feature id for the '<em><b>Content</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE__CONTENT = OWNED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Package</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE_FEATURE_COUNT = OWNED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The operation id for the '<em>Get Level</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE___GET_LEVEL = OWNED_ELEMENT___GET_LEVEL;

  /**
   * The number of operations of the '<em>Package</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE_OPERATION_COUNT = OWNED_ELEMENT_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link PLM.impl.AbstractDSLVisualizerImpl <em>Abstract DSL Visualizer</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.impl.AbstractDSLVisualizerImpl
   * @see PLM.impl.PLMPackageImpl#getAbstractDSLVisualizer()
   * @generated
   */
  int ABSTRACT_DSL_VISUALIZER = 25;

  /**
   * The feature id for the '<em><b>Instance Level</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_DSL_VISUALIZER__INSTANCE_LEVEL = 0;

  /**
   * The feature id for the '<em><b>Notation</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_DSL_VISUALIZER__NOTATION = 1;

  /**
   * The number of structural features of the '<em>Abstract DSL Visualizer</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_DSL_VISUALIZER_FEATURE_COUNT = 2;

  /**
   * The operation id for the '<em>Format</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_DSL_VISUALIZER___FORMAT = 0;

  /**
   * The number of operations of the '<em>Abstract DSL Visualizer</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_DSL_VISUALIZER_OPERATION_COUNT = 1;

  /**
   * The meta object id for the '{@link PLM.impl.AbstractBehaviorImpl <em>Abstract Behavior</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.impl.AbstractBehaviorImpl
   * @see PLM.impl.PLMPackageImpl#getAbstractBehavior()
   * @generated
   */
  int ABSTRACT_BEHAVIOR = 26;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_BEHAVIOR__NAME = 0;

  /**
   * The number of structural features of the '<em>Abstract Behavior</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_BEHAVIOR_FEATURE_COUNT = 1;

  /**
   * The number of operations of the '<em>Abstract Behavior</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_BEHAVIOR_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link PLM.impl.AbstractConstraintImpl <em>Abstract Constraint</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.impl.AbstractConstraintImpl
   * @see PLM.impl.PLMPackageImpl#getAbstractConstraint()
   * @generated
   */
  int ABSTRACT_CONSTRAINT = 27;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_CONSTRAINT__NAME = 0;

  /**
   * The number of structural features of the '<em>Abstract Constraint</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_CONSTRAINT_FEATURE_COUNT = 1;

  /**
   * The number of operations of the '<em>Abstract Constraint</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_CONSTRAINT_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link PLM.ConnectionEndKind <em>Connection End Kind</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.ConnectionEndKind
   * @see PLM.impl.PLMPackageImpl#getConnectionEndKind()
   * @generated
   */
  int CONNECTION_END_KIND = 28;

  /**
   * The meta object id for the '{@link PLM.ClassificationKind <em>Classification Kind</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.ClassificationKind
   * @see PLM.impl.PLMPackageImpl#getClassificationKind()
   * @generated
   */
  int CLASSIFICATION_KIND = 29;

  /**
   * The meta object id for the '{@link PLM.ComplianceKind <em>Compliance Kind</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see PLM.ComplianceKind
   * @see PLM.impl.PLMPackageImpl#getComplianceKind()
   * @generated
   */
  int COMPLIANCE_KIND = 30;


  /**
   * Returns the meta object for class '{@link PLM.Domain <em>Domain</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Domain</em>'.
   * @see PLM.Domain
   * @generated
   */
  EClass getDomain();

  /**
   * Returns the meta object for the attribute '{@link PLM.Domain#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see PLM.Domain#getName()
   * @see #getDomain()
   * @generated
   */
  EAttribute getDomain_Name();

  /**
   * Returns the meta object for the containment reference list '{@link PLM.Domain#getDeepModel <em>Deep Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Deep Model</em>'.
   * @see PLM.Domain#getDeepModel()
   * @see #getDomain()
   * @generated
   */
  EReference getDomain_DeepModel();

  /**
   * Returns the meta object for the attribute '{@link PLM.Domain#getPlmVersion <em>Plm Version</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Plm Version</em>'.
   * @see PLM.Domain#getPlmVersion()
   * @see #getDomain()
   * @generated
   */
  EAttribute getDomain_PlmVersion();

  /**
   * Returns the meta object for the attribute '{@link PLM.Domain#getComplianceKind <em>Compliance Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Compliance Kind</em>'.
   * @see PLM.Domain#getComplianceKind()
   * @see #getDomain()
   * @generated
   */
  EAttribute getDomain_ComplianceKind();

  /**
   * Returns the meta object for class '{@link PLM.Element <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Element</em>'.
   * @see PLM.Element
   * @generated
   */
  EClass getElement();

  /**
   * Returns the meta object for the attribute '{@link PLM.Element#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see PLM.Element#getName()
   * @see #getElement()
   * @generated
   */
  EAttribute getElement_Name();

  /**
   * Returns the meta object for the containment reference list '{@link PLM.Element#getVisualizer <em>Visualizer</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Visualizer</em>'.
   * @see PLM.Element#getVisualizer()
   * @see #getElement()
   * @generated
   */
  EReference getElement_Visualizer();

  /**
   * Returns the meta object for the containment reference list '{@link PLM.Element#getBehavior <em>Behavior</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Behavior</em>'.
   * @see PLM.Element#getBehavior()
   * @see #getElement()
   * @generated
   */
  EReference getElement_Behavior();

  /**
   * Returns the meta object for the containment reference list '{@link PLM.Element#getConstraint <em>Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Constraint</em>'.
   * @see PLM.Element#getConstraint()
   * @see #getElement()
   * @generated
   */
  EReference getElement_Constraint();

  /**
   * Returns the meta object for class '{@link PLM.Level <em>Level</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Level</em>'.
   * @see PLM.Level
   * @generated
   */
  EClass getLevel();

  /**
   * Returns the meta object for the containment reference list '{@link PLM.Level#getContent <em>Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Content</em>'.
   * @see PLM.Level#getContent()
   * @see #getLevel()
   * @generated
   */
  EReference getLevel_Content();

  /**
   * Returns the meta object for the '{@link PLM.Level#getAllInheritances() <em>Get All Inheritances</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get All Inheritances</em>' operation.
   * @see PLM.Level#getAllInheritances()
   * @generated
   */
  EOperation getLevel__GetAllInheritances();

  /**
   * Returns the meta object for the '{@link PLM.Level#getClabjects() <em>Get Clabjects</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Clabjects</em>' operation.
   * @see PLM.Level#getClabjects()
   * @generated
   */
  EOperation getLevel__GetClabjects();

  /**
   * Returns the meta object for the '{@link PLM.Level#getEntities() <em>Get Entities</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Entities</em>' operation.
   * @see PLM.Level#getEntities()
   * @generated
   */
  EOperation getLevel__GetEntities();

  /**
   * Returns the meta object for the '{@link PLM.Level#getConnections() <em>Get Connections</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Connections</em>' operation.
   * @see PLM.Level#getConnections()
   * @generated
   */
  EOperation getLevel__GetConnections();

  /**
   * Returns the meta object for the '{@link PLM.Level#getClassifications() <em>Get Classifications</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Classifications</em>' operation.
   * @see PLM.Level#getClassifications()
   * @generated
   */
  EOperation getLevel__GetClassifications();

  /**
   * Returns the meta object for the '{@link PLM.Level#getDeepModel() <em>Get Deep Model</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Deep Model</em>' operation.
   * @see PLM.Level#getDeepModel()
   * @generated
   */
  EOperation getLevel__GetDeepModel();

  /**
   * Returns the meta object for the '{@link PLM.Level#getClassifiedLevel() <em>Get Classified Level</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Classified Level</em>' operation.
   * @see PLM.Level#getClassifiedLevel()
   * @generated
   */
  EOperation getLevel__GetClassifiedLevel();

  /**
   * Returns the meta object for the '{@link PLM.Level#getClassifyingLevel() <em>Get Classifying Level</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Classifying Level</em>' operation.
   * @see PLM.Level#getClassifyingLevel()
   * @generated
   */
  EOperation getLevel__GetClassifyingLevel();

  /**
   * Returns the meta object for the '{@link PLM.Level#getLevel() <em>Get Level</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Level</em>' operation.
   * @see PLM.Level#getLevel()
   * @generated
   */
  EOperation getLevel__GetLevel();

  /**
   * Returns the meta object for the '{@link PLM.Level#isRootLevel() <em>Is Root Level</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Is Root Level</em>' operation.
   * @see PLM.Level#isRootLevel()
   * @generated
   */
  EOperation getLevel__IsRootLevel();

  /**
   * Returns the meta object for the '{@link PLM.Level#isLeafLevel() <em>Is Leaf Level</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Is Leaf Level</em>' operation.
   * @see PLM.Level#isLeafLevel()
   * @generated
   */
  EOperation getLevel__IsLeafLevel();

  /**
   * Returns the meta object for class '{@link PLM.DeepModel <em>Deep Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Deep Model</em>'.
   * @see PLM.DeepModel
   * @generated
   */
  EClass getDeepModel();

  /**
   * Returns the meta object for the containment reference list '{@link PLM.DeepModel#getContent <em>Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Content</em>'.
   * @see PLM.DeepModel#getContent()
   * @see #getDeepModel()
   * @generated
   */
  EReference getDeepModel_Content();

  /**
   * Returns the meta object for the containment reference list '{@link PLM.DeepModel#getEnumeration <em>Enumeration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Enumeration</em>'.
   * @see PLM.DeepModel#getEnumeration()
   * @see #getDeepModel()
   * @generated
   */
  EReference getDeepModel_Enumeration();

  /**
   * Returns the meta object for the '{@link PLM.DeepModel#getLevelAtIndex(int) <em>Get Level At Index</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Level At Index</em>' operation.
   * @see PLM.DeepModel#getLevelAtIndex(int)
   * @generated
   */
  EOperation getDeepModel__GetLevelAtIndex__int();

  /**
   * Returns the meta object for the '{@link PLM.DeepModel#getPrimitiveDatatypes() <em>Get Primitive Datatypes</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Primitive Datatypes</em>' operation.
   * @see PLM.DeepModel#getPrimitiveDatatypes()
   * @generated
   */
  EOperation getDeepModel__GetPrimitiveDatatypes();

  /**
   * Returns the meta object for the '{@link PLM.DeepModel#getRegexForPrimitiveDatatype(java.lang.String) <em>Get Regex For Primitive Datatype</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Regex For Primitive Datatype</em>' operation.
   * @see PLM.DeepModel#getRegexForPrimitiveDatatype(java.lang.String)
   * @generated
   */
  EOperation getDeepModel__GetRegexForPrimitiveDatatype__String();

  /**
   * Returns the meta object for the '{@link PLM.DeepModel#getAllDatatypes() <em>Get All Datatypes</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get All Datatypes</em>' operation.
   * @see PLM.DeepModel#getAllDatatypes()
   * @generated
   */
  EOperation getDeepModel__GetAllDatatypes();

  /**
   * Returns the meta object for class '{@link PLM.OwnedElement <em>Owned Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Owned Element</em>'.
   * @see PLM.OwnedElement
   * @generated
   */
  EClass getOwnedElement();

  /**
   * Returns the meta object for the '{@link PLM.OwnedElement#getLevel() <em>Get Level</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Level</em>' operation.
   * @see PLM.OwnedElement#getLevel()
   * @generated
   */
  EOperation getOwnedElement__GetLevel();

  /**
   * Returns the meta object for class '{@link PLM.Correlation <em>Correlation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Correlation</em>'.
   * @see PLM.Correlation
   * @generated
   */
  EClass getCorrelation();

  /**
   * Returns the meta object for class '{@link PLM.Inheritance <em>Inheritance</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Inheritance</em>'.
   * @see PLM.Inheritance
   * @generated
   */
  EClass getInheritance();

  /**
   * Returns the meta object for the containment reference list '{@link PLM.Inheritance#getSupertype <em>Supertype</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Supertype</em>'.
   * @see PLM.Inheritance#getSupertype()
   * @see #getInheritance()
   * @generated
   */
  EReference getInheritance_Supertype();

  /**
   * Returns the meta object for the containment reference list '{@link PLM.Inheritance#getSubtype <em>Subtype</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Subtype</em>'.
   * @see PLM.Inheritance#getSubtype()
   * @see #getInheritance()
   * @generated
   */
  EReference getInheritance_Subtype();

  /**
   * Returns the meta object for the attribute '{@link PLM.Inheritance#getDisjoint <em>Disjoint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Disjoint</em>'.
   * @see PLM.Inheritance#getDisjoint()
   * @see #getInheritance()
   * @generated
   */
  EAttribute getInheritance_Disjoint();

  /**
   * Returns the meta object for the attribute '{@link PLM.Inheritance#getComplete <em>Complete</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Complete</em>'.
   * @see PLM.Inheritance#getComplete()
   * @see #getInheritance()
   * @generated
   */
  EAttribute getInheritance_Complete();

  /**
   * Returns the meta object for the '{@link PLM.Inheritance#isDisjoint() <em>Is Disjoint</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Is Disjoint</em>' operation.
   * @see PLM.Inheritance#isDisjoint()
   * @generated
   */
  EOperation getInheritance__IsDisjoint();

  /**
   * Returns the meta object for the '{@link PLM.Inheritance#isComplete() <em>Is Complete</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Is Complete</em>' operation.
   * @see PLM.Inheritance#isComplete()
   * @generated
   */
  EOperation getInheritance__IsComplete();

  /**
   * Returns the meta object for the '{@link PLM.Inheritance#isIntersection() <em>Is Intersection</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Is Intersection</em>' operation.
   * @see PLM.Inheritance#isIntersection()
   * @generated
   */
  EOperation getInheritance__IsIntersection();

  /**
   * Returns the meta object for the '{@link PLM.Inheritance#represent() <em>Represent</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Represent</em>' operation.
   * @see PLM.Inheritance#represent()
   * @generated
   */
  EOperation getInheritance__Represent();

  /**
   * Returns the meta object for the '{@link PLM.Inheritance#getSupertypes() <em>Get Supertypes</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Supertypes</em>' operation.
   * @see PLM.Inheritance#getSupertypes()
   * @generated
   */
  EOperation getInheritance__GetSupertypes();

  /**
   * Returns the meta object for the '{@link PLM.Inheritance#getSubtypes() <em>Get Subtypes</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Subtypes</em>' operation.
   * @see PLM.Inheritance#getSubtypes()
   * @generated
   */
  EOperation getInheritance__GetSubtypes();

  /**
   * Returns the meta object for class '{@link PLM.Supertype <em>Supertype</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Supertype</em>'.
   * @see PLM.Supertype
   * @generated
   */
  EClass getSupertype();

  /**
   * Returns the meta object for the reference '{@link PLM.Supertype#getSupertype <em>Supertype</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Supertype</em>'.
   * @see PLM.Supertype#getSupertype()
   * @see #getSupertype()
   * @generated
   */
  EReference getSupertype_Supertype();

  /**
   * Returns the meta object for the container reference '{@link PLM.Supertype#getInheritance <em>Inheritance</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Inheritance</em>'.
   * @see PLM.Supertype#getInheritance()
   * @see #getSupertype()
   * @generated
   */
  EReference getSupertype_Inheritance();

  /**
   * Returns the meta object for class '{@link PLM.Subtype <em>Subtype</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Subtype</em>'.
   * @see PLM.Subtype
   * @generated
   */
  EClass getSubtype();

  /**
   * Returns the meta object for the reference '{@link PLM.Subtype#getSubtype <em>Subtype</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Subtype</em>'.
   * @see PLM.Subtype#getSubtype()
   * @see #getSubtype()
   * @generated
   */
  EReference getSubtype_Subtype();

  /**
   * Returns the meta object for the container reference '{@link PLM.Subtype#getInheritance <em>Inheritance</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Inheritance</em>'.
   * @see PLM.Subtype#getInheritance()
   * @see #getSubtype()
   * @generated
   */
  EReference getSubtype_Inheritance();

  /**
   * Returns the meta object for class '{@link PLM.Classification <em>Classification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Classification</em>'.
   * @see PLM.Classification
   * @generated
   */
  EClass getClassification();

  /**
   * Returns the meta object for the reference '{@link PLM.Classification#getInstance <em>Instance</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Instance</em>'.
   * @see PLM.Classification#getInstance()
   * @see #getClassification()
   * @generated
   */
  EReference getClassification_Instance();

  /**
   * Returns the meta object for the reference '{@link PLM.Classification#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see PLM.Classification#getType()
   * @see #getClassification()
   * @generated
   */
  EReference getClassification_Type();

  /**
   * Returns the meta object for the attribute '{@link PLM.Classification#getKind <em>Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Kind</em>'.
   * @see PLM.Classification#getKind()
   * @see #getClassification()
   * @generated
   */
  EAttribute getClassification_Kind();

  /**
   * Returns the meta object for the '{@link PLM.Classification#represent() <em>Represent</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Represent</em>' operation.
   * @see PLM.Classification#represent()
   * @generated
   */
  EOperation getClassification__Represent();

  /**
   * Returns the meta object for class '{@link PLM.Clabject <em>Clabject</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Clabject</em>'.
   * @see PLM.Clabject
   * @generated
   */
  EClass getClabject();

  /**
   * Returns the meta object for the attribute '{@link PLM.Clabject#getPotency <em>Potency</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Potency</em>'.
   * @see PLM.Clabject#getPotency()
   * @see #getClabject()
   * @generated
   */
  EAttribute getClabject_Potency();

  /**
   * Returns the meta object for the attribute '{@link PLM.Clabject#getLevelIndex <em>Level Index</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Level Index</em>'.
   * @see PLM.Clabject#getLevelIndex()
   * @see #getClabject()
   * @generated
   */
  EAttribute getClabject_LevelIndex();

  /**
   * Returns the meta object for the containment reference list '{@link PLM.Clabject#getContent <em>Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Content</em>'.
   * @see PLM.Clabject#getContent()
   * @see #getClabject()
   * @generated
   */
  EReference getClabject_Content();

  /**
   * Returns the meta object for the containment reference list '{@link PLM.Clabject#getFeature <em>Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Feature</em>'.
   * @see PLM.Clabject#getFeature()
   * @see #getClabject()
   * @generated
   */
  EReference getClabject_Feature();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getDeepModel() <em>Get Deep Model</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Deep Model</em>' operation.
   * @see PLM.Clabject#getDeepModel()
   * @generated
   */
  EOperation getClabject__GetDeepModel();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getSupertypes() <em>Get Supertypes</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Supertypes</em>' operation.
   * @see PLM.Clabject#getSupertypes()
   * @generated
   */
  EOperation getClabject__GetSupertypes();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getSupertypes(org.eclipse.emf.common.util.EList) <em>Get Supertypes</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Supertypes</em>' operation.
   * @see PLM.Clabject#getSupertypes(org.eclipse.emf.common.util.EList)
   * @generated
   */
  EOperation getClabject__GetSupertypes__EList();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getDirectSupertypes() <em>Get Direct Supertypes</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Direct Supertypes</em>' operation.
   * @see PLM.Clabject#getDirectSupertypes()
   * @generated
   */
  EOperation getClabject__GetDirectSupertypes();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getSubtypes() <em>Get Subtypes</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Subtypes</em>' operation.
   * @see PLM.Clabject#getSubtypes()
   * @generated
   */
  EOperation getClabject__GetSubtypes();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getHollowSubtypes() <em>Get Hollow Subtypes</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Hollow Subtypes</em>' operation.
   * @see PLM.Clabject#getHollowSubtypes()
   * @generated
   */
  EOperation getClabject__GetHollowSubtypes();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getHollowSupertypes() <em>Get Hollow Supertypes</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Hollow Supertypes</em>' operation.
   * @see PLM.Clabject#getHollowSupertypes()
   * @generated
   */
  EOperation getClabject__GetHollowSupertypes();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getClassificationsAsInstance() <em>Get Classifications As Instance</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Classifications As Instance</em>' operation.
   * @see PLM.Clabject#getClassificationsAsInstance()
   * @generated
   */
  EOperation getClabject__GetClassificationsAsInstance();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getClassificationsAsType() <em>Get Classifications As Type</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Classifications As Type</em>' operation.
   * @see PLM.Clabject#getClassificationsAsType()
   * @generated
   */
  EOperation getClabject__GetClassificationsAsType();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getInstances() <em>Get Instances</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Instances</em>' operation.
   * @see PLM.Clabject#getInstances()
   * @generated
   */
  EOperation getClabject__GetInstances();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getTypes() <em>Get Types</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Types</em>' operation.
   * @see PLM.Clabject#getTypes()
   * @generated
   */
  EOperation getClabject__GetTypes();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getDirectTypes() <em>Get Direct Types</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Direct Types</em>' operation.
   * @see PLM.Clabject#getDirectTypes()
   * @generated
   */
  EOperation getClabject__GetDirectTypes();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getLevelTypes() <em>Get Level Types</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Level Types</em>' operation.
   * @see PLM.Clabject#getLevelTypes()
   * @generated
   */
  EOperation getClabject__GetLevelTypes();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getDefinedClassificationTreeAsInstance() <em>Get Defined Classification Tree As Instance</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Defined Classification Tree As Instance</em>' operation.
   * @see PLM.Clabject#getDefinedClassificationTreeAsInstance()
   * @generated
   */
  EOperation getClabject__GetDefinedClassificationTreeAsInstance();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getClassificationTreeAsInstance() <em>Get Classification Tree As Instance</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Classification Tree As Instance</em>' operation.
   * @see PLM.Clabject#getClassificationTreeAsInstance()
   * @generated
   */
  EOperation getClabject__GetClassificationTreeAsInstance();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getDefinedInstances() <em>Get Defined Instances</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Defined Instances</em>' operation.
   * @see PLM.Clabject#getDefinedInstances()
   * @generated
   */
  EOperation getClabject__GetDefinedInstances();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getDefinedClassificationTreeAsType() <em>Get Defined Classification Tree As Type</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Defined Classification Tree As Type</em>' operation.
   * @see PLM.Clabject#getDefinedClassificationTreeAsType()
   * @generated
   */
  EOperation getClabject__GetDefinedClassificationTreeAsType();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getClassificationTreeAsType() <em>Get Classification Tree As Type</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Classification Tree As Type</em>' operation.
   * @see PLM.Clabject#getClassificationTreeAsType()
   * @generated
   */
  EOperation getClabject__GetClassificationTreeAsType();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getClassificationTreeAsType(int) <em>Get Classification Tree As Type</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Classification Tree As Type</em>' operation.
   * @see PLM.Clabject#getClassificationTreeAsType(int)
   * @generated
   */
  EOperation getClabject__GetClassificationTreeAsType__int();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getClassificationTreeAsType(int, int) <em>Get Classification Tree As Type</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Classification Tree As Type</em>' operation.
   * @see PLM.Clabject#getClassificationTreeAsType(int, int)
   * @generated
   */
  EOperation getClabject__GetClassificationTreeAsType__int_int();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getAllFeatures() <em>Get All Features</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get All Features</em>' operation.
   * @see PLM.Clabject#getAllFeatures()
   * @generated
   */
  EOperation getClabject__GetAllFeatures();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getAllAttributes() <em>Get All Attributes</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get All Attributes</em>' operation.
   * @see PLM.Clabject#getAllAttributes()
   * @generated
   */
  EOperation getClabject__GetAllAttributes();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getDefinedAttributes() <em>Get Defined Attributes</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Defined Attributes</em>' operation.
   * @see PLM.Clabject#getDefinedAttributes()
   * @generated
   */
  EOperation getClabject__GetDefinedAttributes();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getDefinedAttributeByName(java.lang.String) <em>Get Defined Attribute By Name</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Defined Attribute By Name</em>' operation.
   * @see PLM.Clabject#getDefinedAttributeByName(java.lang.String)
   * @generated
   */
  EOperation getClabject__GetDefinedAttributeByName__String();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getAllMethods() <em>Get All Methods</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get All Methods</em>' operation.
   * @see PLM.Clabject#getAllMethods()
   * @generated
   */
  EOperation getClabject__GetAllMethods();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getDefinedMethods() <em>Get Defined Methods</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Defined Methods</em>' operation.
   * @see PLM.Clabject#getDefinedMethods()
   * @generated
   */
  EOperation getClabject__GetDefinedMethods();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#isInstanceOf(PLM.Clabject) <em>Is Instance Of</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Is Instance Of</em>' operation.
   * @see PLM.Clabject#isInstanceOf(PLM.Clabject)
   * @generated
   */
  EOperation getClabject__IsInstanceOf__Clabject();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#isTypeOf(PLM.Clabject) <em>Is Type Of</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Is Type Of</em>' operation.
   * @see PLM.Clabject#isTypeOf(PLM.Clabject)
   * @generated
   */
  EOperation getClabject__IsTypeOf__Clabject();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#isContainerOf(PLM.Clabject) <em>Is Container Of</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Is Container Of</em>' operation.
   * @see PLM.Clabject#isContainerOf(PLM.Clabject)
   * @generated
   */
  EOperation getClabject__IsContainerOf__Clabject();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getComposite() <em>Get Composite</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Composite</em>' operation.
   * @see PLM.Clabject#getComposite()
   * @generated
   */
  EOperation getClabject__GetComposite();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getAggregates() <em>Get Aggregates</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Aggregates</em>' operation.
   * @see PLM.Clabject#getAggregates()
   * @generated
   */
  EOperation getClabject__GetAggregates();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getParts() <em>Get Parts</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Parts</em>' operation.
   * @see PLM.Clabject#getParts()
   * @generated
   */
  EOperation getClabject__GetParts();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getPartsForMoniker(java.lang.String) <em>Get Parts For Moniker</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Parts For Moniker</em>' operation.
   * @see PLM.Clabject#getPartsForMoniker(java.lang.String)
   * @generated
   */
  EOperation getClabject__GetPartsForMoniker__String();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getDefinedConnections() <em>Get Defined Connections</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Defined Connections</em>' operation.
   * @see PLM.Clabject#getDefinedConnections()
   * @generated
   */
  EOperation getClabject__GetDefinedConnections();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getConnections() <em>Get Connections</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Connections</em>' operation.
   * @see PLM.Clabject#getConnections()
   * @generated
   */
  EOperation getClabject__GetConnections();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getInheritedConnections() <em>Get Inherited Connections</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Inherited Connections</em>' operation.
   * @see PLM.Clabject#getInheritedConnections()
   * @generated
   */
  EOperation getClabject__GetInheritedConnections();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getLevelCompleteTypes() <em>Get Level Complete Types</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Level Complete Types</em>' operation.
   * @see PLM.Clabject#getLevelCompleteTypes()
   * @generated
   */
  EOperation getClabject__GetLevelCompleteTypes();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getLevelIncompleteTypes() <em>Get Level Incomplete Types</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Level Incomplete Types</em>' operation.
   * @see PLM.Clabject#getLevelIncompleteTypes()
   * @generated
   */
  EOperation getClabject__GetLevelIncompleteTypes();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getBlueprint() <em>Get Blueprint</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Blueprint</em>' operation.
   * @see PLM.Clabject#getBlueprint()
   * @generated
   */
  EOperation getClabject__GetBlueprint();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getOffspring() <em>Get Offspring</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Offspring</em>' operation.
   * @see PLM.Clabject#getOffspring()
   * @generated
   */
  EOperation getClabject__GetOffspring();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getIsonyms() <em>Get Isonyms</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Isonyms</em>' operation.
   * @see PLM.Clabject#getIsonyms()
   * @generated
   */
  EOperation getClabject__GetIsonyms();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getHyponyms() <em>Get Hyponyms</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Hyponyms</em>' operation.
   * @see PLM.Clabject#getHyponyms()
   * @generated
   */
  EOperation getClabject__GetHyponyms();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getDomainForConnection(PLM.Connection) <em>Get Domain For Connection</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Domain For Connection</em>' operation.
   * @see PLM.Clabject#getDomainForConnection(PLM.Connection)
   * @generated
   */
  EOperation getClabject__GetDomainForConnection__Connection();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getPossibleDomainSpecificVisualizers() <em>Get Possible Domain Specific Visualizers</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Possible Domain Specific Visualizers</em>' operation.
   * @see PLM.Clabject#getPossibleDomainSpecificVisualizers()
   * @deprecated See {@link PLM.Clabject#getPossibleDomainSpecificVisualizers() model documentation} for details.
   * @generated
   */
  @Deprecated
  EOperation getClabject__GetPossibleDomainSpecificVisualizers();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getInheritancesAsSubtype() <em>Get Inheritances As Subtype</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Inheritances As Subtype</em>' operation.
   * @see PLM.Clabject#getInheritancesAsSubtype()
   * @generated
   */
  EOperation getClabject__GetInheritancesAsSubtype();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getInheritancesAsSupertype() <em>Get Inheritances As Supertype</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Inheritances As Supertype</em>' operation.
   * @see PLM.Clabject#getInheritancesAsSupertype()
   * @generated
   */
  EOperation getClabject__GetInheritancesAsSupertype();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getDefinedNavigations() <em>Get Defined Navigations</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Defined Navigations</em>' operation.
   * @see PLM.Clabject#getDefinedNavigations()
   * @generated
   */
  EOperation getClabject__GetDefinedNavigations();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getInheritedNavigations() <em>Get Inherited Navigations</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Inherited Navigations</em>' operation.
   * @see PLM.Clabject#getInheritedNavigations()
   * @generated
   */
  EOperation getClabject__GetInheritedNavigations();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getAllNavigations() <em>Get All Navigations</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get All Navigations</em>' operation.
   * @see PLM.Clabject#getAllNavigations()
   * @generated
   */
  EOperation getClabject__GetAllNavigations();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getDomainMonikers() <em>Get Domain Monikers</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Domain Monikers</em>' operation.
   * @see PLM.Clabject#getDomainMonikers()
   * @generated
   */
  EOperation getClabject__GetDomainMonikers();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getDomainForMoniker(java.lang.String) <em>Get Domain For Moniker</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Domain For Moniker</em>' operation.
   * @see PLM.Clabject#getDomainForMoniker(java.lang.String)
   * @deprecated
   * @generated
   */
  @Deprecated
  EOperation getClabject__GetDomainForMoniker__String();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getAllNavigationsForMoniker(java.lang.String) <em>Get All Navigations For Moniker</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get All Navigations For Moniker</em>' operation.
   * @see PLM.Clabject#getAllNavigationsForMoniker(java.lang.String)
   * @generated
   */
  EOperation getClabject__GetAllNavigationsForMoniker__String();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getAllNavigationsAsDestination() <em>Get All Navigations As Destination</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get All Navigations As Destination</em>' operation.
   * @see PLM.Clabject#getAllNavigationsAsDestination()
   * @generated
   */
  EOperation getClabject__GetAllNavigationsAsDestination();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getDefinedNavigationsAsDestination() <em>Get Defined Navigations As Destination</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Defined Navigations As Destination</em>' operation.
   * @see PLM.Clabject#getDefinedNavigationsAsDestination()
   * @generated
   */
  EOperation getClabject__GetDefinedNavigationsAsDestination();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getInheritedNavigationsAsDestination() <em>Get Inherited Navigations As Destination</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Inherited Navigations As Destination</em>' operation.
   * @see PLM.Clabject#getInheritedNavigationsAsDestination()
   * @generated
   */
  EOperation getClabject__GetInheritedNavigationsAsDestination();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#represent() <em>Represent</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Represent</em>' operation.
   * @see PLM.Clabject#represent()
   * @generated
   */
  EOperation getClabject__Represent();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getFeatureForName(java.lang.String) <em>Get Feature For Name</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Feature For Name</em>' operation.
   * @see PLM.Clabject#getFeatureForName(java.lang.String)
   * @generated
   */
  EOperation getClabject__GetFeatureForName__String();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getPotencyAsString() <em>Get Potency As String</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Potency As String</em>' operation.
   * @see PLM.Clabject#getPotencyAsString()
   * @generated
   */
  EOperation getClabject__GetPotencyAsString();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getDisjointSiblings() <em>Get Disjoint Siblings</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Disjoint Siblings</em>' operation.
   * @see PLM.Clabject#getDisjointSiblings()
   * @generated
   */
  EOperation getClabject__GetDisjointSiblings();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getAttributeByName(java.lang.String) <em>Get Attribute By Name</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Attribute By Name</em>' operation.
   * @see PLM.Clabject#getAttributeByName(java.lang.String)
   * @generated
   */
  EOperation getClabject__GetAttributeByName__String();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#violatesMultiplicityConstraints() <em>Violates Multiplicity Constraints</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Violates Multiplicity Constraints</em>' operation.
   * @see PLM.Clabject#violatesMultiplicityConstraints()
   * @generated
   */
  EOperation getClabject__ViolatesMultiplicityConstraints();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getDefinedInheritances() <em>Get Defined Inheritances</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Defined Inheritances</em>' operation.
   * @see PLM.Clabject#getDefinedInheritances()
   * @generated
   */
  EOperation getClabject__GetDefinedInheritances();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getOwnedClabjects() <em>Get Owned Clabjects</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Owned Clabjects</em>' operation.
   * @see PLM.Clabject#getOwnedClabjects()
   * @generated
   */
  EOperation getClabject__GetOwnedClabjects();

  /**
   * Returns the meta object for the '{@link PLM.Clabject#getDirectType() <em>Get Direct Type</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Direct Type</em>' operation.
   * @see PLM.Clabject#getDirectType()
   * @generated
   */
  EOperation getClabject__GetDirectType();

  /**
   * Returns the meta object for class '{@link PLM.Feature <em>Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Feature</em>'.
   * @see PLM.Feature
   * @generated
   */
  EClass getFeature();

  /**
   * Returns the meta object for the attribute '{@link PLM.Feature#getDurability <em>Durability</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Durability</em>'.
   * @see PLM.Feature#getDurability()
   * @see #getFeature()
   * @generated
   */
  EAttribute getFeature_Durability();

  /**
   * Returns the meta object for the '{@link PLM.Feature#getClabject() <em>Get Clabject</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Clabject</em>' operation.
   * @see PLM.Feature#getClabject()
   * @generated
   */
  EOperation getFeature__GetClabject();

  /**
   * Returns the meta object for the '{@link PLM.Feature#getDurabilityAsString() <em>Get Durability As String</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Durability As String</em>' operation.
   * @see PLM.Feature#getDurabilityAsString()
   * @generated
   */
  EOperation getFeature__GetDurabilityAsString();

  /**
   * Returns the meta object for the '{@link PLM.Feature#represent() <em>Represent</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Represent</em>' operation.
   * @see PLM.Feature#represent()
   * @generated
   */
  EOperation getFeature__Represent();

  /**
   * Returns the meta object for class '{@link PLM.Entity <em>Entity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Entity</em>'.
   * @see PLM.Entity
   * @generated
   */
  EClass getEntity();

  /**
   * Returns the meta object for the '{@link PLM.Entity#represent() <em>Represent</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Represent</em>' operation.
   * @see PLM.Entity#represent()
   * @generated
   */
  EOperation getEntity__Represent();

  /**
   * Returns the meta object for class '{@link PLM.Connection <em>Connection</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Connection</em>'.
   * @see PLM.Connection
   * @generated
   */
  EClass getConnection();

  /**
   * Returns the meta object for the containment reference list '{@link PLM.Connection#getConnectionEnd <em>Connection End</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Connection End</em>'.
   * @see PLM.Connection#getConnectionEnd()
   * @see #getConnection()
   * @generated
   */
  EReference getConnection_ConnectionEnd();

  /**
   * Returns the meta object for the '{@link PLM.Connection#getDomain() <em>Get Domain</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Domain</em>' operation.
   * @see PLM.Connection#getDomain()
   * @generated
   */
  EOperation getConnection__GetDomain();

  /**
   * Returns the meta object for the '{@link PLM.Connection#getNotDomain() <em>Get Not Domain</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Not Domain</em>' operation.
   * @see PLM.Connection#getNotDomain()
   * @generated
   */
  EOperation getConnection__GetNotDomain();

  /**
   * Returns the meta object for the '{@link PLM.Connection#getHumanReadableName() <em>Get Human Readable Name</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Human Readable Name</em>' operation.
   * @see PLM.Connection#getHumanReadableName()
   * @generated
   */
  EOperation getConnection__GetHumanReadableName();

  /**
   * Returns the meta object for the '{@link PLM.Connection#getParticipants() <em>Get Participants</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Participants</em>' operation.
   * @see PLM.Connection#getParticipants()
   * @generated
   */
  EOperation getConnection__GetParticipants();

  /**
   * Returns the meta object for the '{@link PLM.Connection#getMoniker() <em>Get Moniker</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Moniker</em>' operation.
   * @see PLM.Connection#getMoniker()
   * @generated
   */
  EOperation getConnection__GetMoniker();

  /**
   * Returns the meta object for the '{@link PLM.Connection#getDomain(PLM.Clabject) <em>Get Domain</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Domain</em>' operation.
   * @see PLM.Connection#getDomain(PLM.Clabject)
   * @generated
   */
  EOperation getConnection__GetDomain__Clabject();

  /**
   * Returns the meta object for the '{@link PLM.Connection#getMonikerForParticipant(PLM.Clabject) <em>Get Moniker For Participant</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Moniker For Participant</em>' operation.
   * @see PLM.Connection#getMonikerForParticipant(PLM.Clabject)
   * @generated
   */
  EOperation getConnection__GetMonikerForParticipant__Clabject();

  /**
   * Returns the meta object for the '{@link PLM.Connection#getLowerForMoniker(java.lang.String) <em>Get Lower For Moniker</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Lower For Moniker</em>' operation.
   * @see PLM.Connection#getLowerForMoniker(java.lang.String)
   * @generated
   */
  EOperation getConnection__GetLowerForMoniker__String();

  /**
   * Returns the meta object for the '{@link PLM.Connection#getUpperForMoniker(java.lang.String) <em>Get Upper For Moniker</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Upper For Moniker</em>' operation.
   * @see PLM.Connection#getUpperForMoniker(java.lang.String)
   * @generated
   */
  EOperation getConnection__GetUpperForMoniker__String();

  /**
   * Returns the meta object for the '{@link PLM.Connection#isNavigableForMoniker(java.lang.String) <em>Is Navigable For Moniker</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Is Navigable For Moniker</em>' operation.
   * @see PLM.Connection#isNavigableForMoniker(java.lang.String)
   * @generated
   */
  EOperation getConnection__IsNavigableForMoniker__String();

  /**
   * Returns the meta object for the '{@link PLM.Connection#getOrder() <em>Get Order</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Order</em>' operation.
   * @see PLM.Connection#getOrder()
   * @generated
   */
  EOperation getConnection__GetOrder();

  /**
   * Returns the meta object for the '{@link PLM.Connection#getInheritedConnectionEnd() <em>Get Inherited Connection End</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Inherited Connection End</em>' operation.
   * @see PLM.Connection#getInheritedConnectionEnd()
   * @generated
   */
  EOperation getConnection__GetInheritedConnectionEnd();

  /**
   * Returns the meta object for the '{@link PLM.Connection#getAllConnectionEnd() <em>Get All Connection End</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get All Connection End</em>' operation.
   * @see PLM.Connection#getAllConnectionEnd()
   * @generated
   */
  EOperation getConnection__GetAllConnectionEnd();

  /**
   * Returns the meta object for the '{@link PLM.Connection#getParticipantForMoniker(java.lang.String) <em>Get Participant For Moniker</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Participant For Moniker</em>' operation.
   * @see PLM.Connection#getParticipantForMoniker(java.lang.String)
   * @generated
   */
  EOperation getConnection__GetParticipantForMoniker__String();

  /**
   * Returns the meta object for the '{@link PLM.Connection#represent() <em>Represent</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Represent</em>' operation.
   * @see PLM.Connection#represent()
   * @generated
   */
  EOperation getConnection__Represent();

  /**
   * Returns the meta object for class '{@link PLM.ConnectionEnd <em>Connection End</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Connection End</em>'.
   * @see PLM.ConnectionEnd
   * @generated
   */
  EClass getConnectionEnd();

  /**
   * Returns the meta object for the attribute '{@link PLM.ConnectionEnd#getLower <em>Lower</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Lower</em>'.
   * @see PLM.ConnectionEnd#getLower()
   * @see #getConnectionEnd()
   * @generated
   */
  EAttribute getConnectionEnd_Lower();

  /**
   * Returns the meta object for the attribute '{@link PLM.ConnectionEnd#getUpper <em>Upper</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Upper</em>'.
   * @see PLM.ConnectionEnd#getUpper()
   * @see #getConnectionEnd()
   * @generated
   */
  EAttribute getConnectionEnd_Upper();

  /**
   * Returns the meta object for the attribute '{@link PLM.ConnectionEnd#isNavigable <em>Navigable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Navigable</em>'.
   * @see PLM.ConnectionEnd#isNavigable()
   * @see #getConnectionEnd()
   * @generated
   */
  EAttribute getConnectionEnd_Navigable();

  /**
   * Returns the meta object for the reference '{@link PLM.ConnectionEnd#getDestination <em>Destination</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Destination</em>'.
   * @see PLM.ConnectionEnd#getDestination()
   * @see #getConnectionEnd()
   * @generated
   */
  EReference getConnectionEnd_Destination();

  /**
   * Returns the meta object for the container reference '{@link PLM.ConnectionEnd#getConnection <em>Connection</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Connection</em>'.
   * @see PLM.ConnectionEnd#getConnection()
   * @see #getConnectionEnd()
   * @generated
   */
  EReference getConnectionEnd_Connection();

  /**
   * Returns the meta object for the attribute '{@link PLM.ConnectionEnd#getMoniker <em>Moniker</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Moniker</em>'.
   * @see PLM.ConnectionEnd#getMoniker()
   * @see #getConnectionEnd()
   * @generated
   */
  EAttribute getConnectionEnd_Moniker();

  /**
   * Returns the meta object for the attribute '{@link PLM.ConnectionEnd#getKind <em>Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Kind</em>'.
   * @see PLM.ConnectionEnd#getKind()
   * @see #getConnectionEnd()
   * @generated
   */
  EAttribute getConnectionEnd_Kind();

  /**
   * Returns the meta object for the reference '{@link PLM.ConnectionEnd#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see PLM.ConnectionEnd#getType()
   * @see #getConnectionEnd()
   * @generated
   */
  EReference getConnectionEnd_Type();

  /**
   * Returns the meta object for the containment reference list '{@link PLM.ConnectionEnd#getMultiplicity <em>Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Multiplicity</em>'.
   * @see PLM.ConnectionEnd#getMultiplicity()
   * @see #getConnectionEnd()
   * @generated
   */
  EReference getConnectionEnd_Multiplicity();

  /**
   * Returns the meta object for the '{@link PLM.ConnectionEnd#getHumanReadableConnectionEndName() <em>Get Human Readable Connection End Name</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Human Readable Connection End Name</em>' operation.
   * @see PLM.ConnectionEnd#getHumanReadableConnectionEndName()
   * @generated
   */
  EOperation getConnectionEnd__GetHumanReadableConnectionEndName();

  /**
   * Returns the meta object for the '{@link PLM.ConnectionEnd#hasDefaultMoniker() <em>Has Default Moniker</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Has Default Moniker</em>' operation.
   * @see PLM.ConnectionEnd#hasDefaultMoniker()
   * @generated
   */
  EOperation getConnectionEnd__HasDefaultMoniker();

  /**
   * Returns the meta object for the '{@link PLM.ConnectionEnd#represent() <em>Represent</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Represent</em>' operation.
   * @see PLM.ConnectionEnd#represent()
   * @generated
   */
  EOperation getConnectionEnd__Represent();

  /**
   * Returns the meta object for the '{@link PLM.ConnectionEnd#moniker() <em>Moniker</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Moniker</em>' operation.
   * @see PLM.ConnectionEnd#moniker()
   * @generated
   */
  EOperation getConnectionEnd__Moniker();

  /**
   * Returns the meta object for the '{@link PLM.ConnectionEnd#representMultiplicity() <em>Represent Multiplicity</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Represent Multiplicity</em>' operation.
   * @see PLM.ConnectionEnd#representMultiplicity()
   * @generated
   */
  EOperation getConnectionEnd__RepresentMultiplicity();

  /**
   * Returns the meta object for the '{@link PLM.ConnectionEnd#getConnectionEndName() <em>Get Connection End Name</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Connection End Name</em>' operation.
   * @see PLM.ConnectionEnd#getConnectionEndName()
   * @generated
   */
  EOperation getConnectionEnd__GetConnectionEndName();

  /**
   * Returns the meta object for the '{@link PLM.ConnectionEnd#conforms(PLM.ConnectionEnd) <em>Conforms</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Conforms</em>' operation.
   * @see PLM.ConnectionEnd#conforms(PLM.ConnectionEnd)
   * @generated
   */
  EOperation getConnectionEnd__Conforms__ConnectionEnd();

  /**
   * Returns the meta object for class '{@link PLM.LMLVisualizer <em>LML Visualizer</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>LML Visualizer</em>'.
   * @see PLM.LMLVisualizer
   * @generated
   */
  EClass getLMLVisualizer();

  /**
   * Returns the meta object for the attribute list '{@link PLM.LMLVisualizer#getAttributes <em>Attributes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Attributes</em>'.
   * @see PLM.LMLVisualizer#getAttributes()
   * @see #getLMLVisualizer()
   * @generated
   */
  EAttribute getLMLVisualizer_Attributes();

  /**
   * Returns the meta object for the containment reference list '{@link PLM.LMLVisualizer#getDslVisualizer <em>Dsl Visualizer</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Dsl Visualizer</em>'.
   * @see PLM.LMLVisualizer#getDslVisualizer()
   * @see #getLMLVisualizer()
   * @generated
   */
  EReference getLMLVisualizer_DslVisualizer();

  /**
   * Returns the meta object for the attribute '{@link PLM.LMLVisualizer#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see PLM.LMLVisualizer#getName()
   * @see #getLMLVisualizer()
   * @generated
   */
  EAttribute getLMLVisualizer_Name();

  /**
   * Returns the meta object for the attribute '{@link PLM.LMLVisualizer#getXLocation <em>XLocation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>XLocation</em>'.
   * @see PLM.LMLVisualizer#getXLocation()
   * @see #getLMLVisualizer()
   * @generated
   */
  EAttribute getLMLVisualizer_XLocation();

  /**
   * Returns the meta object for the attribute '{@link PLM.LMLVisualizer#getYLocation <em>YLocation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>YLocation</em>'.
   * @see PLM.LMLVisualizer#getYLocation()
   * @see #getLMLVisualizer()
   * @generated
   */
  EAttribute getLMLVisualizer_YLocation();

  /**
   * Returns the meta object for the attribute '{@link PLM.LMLVisualizer#getWidth <em>Width</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Width</em>'.
   * @see PLM.LMLVisualizer#getWidth()
   * @see #getLMLVisualizer()
   * @generated
   */
  EAttribute getLMLVisualizer_Width();

  /**
   * Returns the meta object for the attribute '{@link PLM.LMLVisualizer#getHeight <em>Height</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Height</em>'.
   * @see PLM.LMLVisualizer#getHeight()
   * @see #getLMLVisualizer()
   * @generated
   */
  EAttribute getLMLVisualizer_Height();

  /**
   * Returns the meta object for the '{@link PLM.LMLVisualizer#getDefaultVisualizationValues() <em>Get Default Visualization Values</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Default Visualization Values</em>' operation.
   * @see PLM.LMLVisualizer#getDefaultVisualizationValues()
   * @generated
   */
  EOperation getLMLVisualizer__GetDefaultVisualizationValues();

  /**
   * Returns the meta object for the '{@link PLM.LMLVisualizer#getValueForKey(java.lang.String) <em>Get Value For Key</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Value For Key</em>' operation.
   * @see PLM.LMLVisualizer#getValueForKey(java.lang.String)
   * @generated
   */
  EOperation getLMLVisualizer__GetValueForKey__String();

  /**
   * Returns the meta object for the '{@link PLM.LMLVisualizer#getContainingElement() <em>Get Containing Element</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Containing Element</em>' operation.
   * @see PLM.LMLVisualizer#getContainingElement()
   * @generated
   */
  EOperation getLMLVisualizer__GetContainingElement();

  /**
   * Returns the meta object for the '{@link PLM.LMLVisualizer#EOperation0() <em>EOperation0</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>EOperation0</em>' operation.
   * @see PLM.LMLVisualizer#EOperation0()
   * @generated
   */
  EOperation getLMLVisualizer__EOperation0();

  /**
   * Returns the meta object for class '{@link PLM.Property <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property</em>'.
   * @see PLM.Property
   * @generated
   */
  EClass getProperty();

  /**
   * Returns the meta object for the attribute '{@link PLM.Property#getParsingOrder <em>Parsing Order</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Parsing Order</em>'.
   * @see PLM.Property#getParsingOrder()
   * @see #getProperty()
   * @generated
   */
  EAttribute getProperty_ParsingOrder();

  /**
   * Returns the meta object for class '{@link PLM.Attribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attribute</em>'.
   * @see PLM.Attribute
   * @generated
   */
  EClass getAttribute();

  /**
   * Returns the meta object for the attribute '{@link PLM.Attribute#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see PLM.Attribute#getValue()
   * @see #getAttribute()
   * @generated
   */
  EAttribute getAttribute_Value();

  /**
   * Returns the meta object for the attribute '{@link PLM.Attribute#getMutability <em>Mutability</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Mutability</em>'.
   * @see PLM.Attribute#getMutability()
   * @see #getAttribute()
   * @generated
   */
  EAttribute getAttribute_Mutability();

  /**
   * Returns the meta object for the attribute '{@link PLM.Attribute#getDatatype <em>Datatype</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Datatype</em>'.
   * @see PLM.Attribute#getDatatype()
   * @see #getAttribute()
   * @generated
   */
  EAttribute getAttribute_Datatype();

  /**
   * Returns the meta object for the '{@link PLM.Attribute#getMutabilityAsString() <em>Get Mutability As String</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Mutability As String</em>' operation.
   * @see PLM.Attribute#getMutabilityAsString()
   * @generated
   */
  EOperation getAttribute__GetMutabilityAsString();

  /**
   * Returns the meta object for the '{@link PLM.Attribute#represent() <em>Represent</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Represent</em>' operation.
   * @see PLM.Attribute#represent()
   * @generated
   */
  EOperation getAttribute__Represent();

  /**
   * Returns the meta object for the '{@link PLM.Attribute#getPossibleDataTypes() <em>Get Possible Data Types</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Possible Data Types</em>' operation.
   * @see PLM.Attribute#getPossibleDataTypes()
   * @generated
   */
  EOperation getAttribute__GetPossibleDataTypes();

  /**
   * Returns the meta object for the '{@link PLM.Attribute#getPrimitiveDataTypes() <em>Get Primitive Data Types</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Primitive Data Types</em>' operation.
   * @see PLM.Attribute#getPrimitiveDataTypes()
   * @generated
   */
  EOperation getAttribute__GetPrimitiveDataTypes();

  /**
   * Returns the meta object for the '{@link PLM.Attribute#getEnumerationDataTypes() <em>Get Enumeration Data Types</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Enumeration Data Types</em>' operation.
   * @see PLM.Attribute#getEnumerationDataTypes()
   * @generated
   */
  EOperation getAttribute__GetEnumerationDataTypes();

  /**
   * Returns the meta object for the '{@link PLM.Attribute#isEnumeration() <em>Is Enumeration</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Is Enumeration</em>' operation.
   * @see PLM.Attribute#isEnumeration()
   * @generated
   */
  EOperation getAttribute__IsEnumeration();

  /**
   * Returns the meta object for the '{@link PLM.Attribute#getEnumeration() <em>Get Enumeration</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Enumeration</em>' operation.
   * @see PLM.Attribute#getEnumeration()
   * @generated
   */
  EOperation getAttribute__GetEnumeration();

  /**
   * Returns the meta object for the '{@link PLM.Attribute#getLiterals() <em>Get Literals</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Literals</em>' operation.
   * @see PLM.Attribute#getLiterals()
   * @generated
   */
  EOperation getAttribute__GetLiterals();

  /**
   * Returns the meta object for class '{@link PLM.Method <em>Method</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Method</em>'.
   * @see PLM.Method
   * @generated
   */
  EClass getMethod();

  /**
   * Returns the meta object for the attribute '{@link PLM.Method#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Body</em>'.
   * @see PLM.Method#getBody()
   * @see #getMethod()
   * @generated
   */
  EAttribute getMethod_Body();

  /**
   * Returns the meta object for the containment reference list '{@link PLM.Method#getParameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameter</em>'.
   * @see PLM.Method#getParameter()
   * @see #getMethod()
   * @generated
   */
  EReference getMethod_Parameter();

  /**
   * Returns the meta object for the '{@link PLM.Method#represent() <em>Represent</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Represent</em>' operation.
   * @see PLM.Method#represent()
   * @generated
   */
  EOperation getMethod__Represent();

  /**
   * Returns the meta object for the '{@link PLM.Method#getInput() <em>Get Input</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Input</em>' operation.
   * @see PLM.Method#getInput()
   * @generated
   */
  EOperation getMethod__GetInput();

  /**
   * Returns the meta object for the '{@link PLM.Method#getOutput() <em>Get Output</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Output</em>' operation.
   * @see PLM.Method#getOutput()
   * @generated
   */
  EOperation getMethod__GetOutput();

  /**
   * Returns the meta object for class '{@link PLM.Enumeration <em>Enumeration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Enumeration</em>'.
   * @see PLM.Enumeration
   * @generated
   */
  EClass getEnumeration();

  /**
   * Returns the meta object for the attribute list '{@link PLM.Enumeration#getLiteral <em>Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Literal</em>'.
   * @see PLM.Enumeration#getLiteral()
   * @see #getEnumeration()
   * @generated
   */
  EAttribute getEnumeration_Literal();

  /**
   * Returns the meta object for class '{@link PLM.Parameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter</em>'.
   * @see PLM.Parameter
   * @generated
   */
  EClass getParameter();

  /**
   * Returns the meta object for the attribute '{@link PLM.Parameter#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see PLM.Parameter#getName()
   * @see #getParameter()
   * @generated
   */
  EAttribute getParameter_Name();

  /**
   * Returns the meta object for the attribute '{@link PLM.Parameter#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Expression</em>'.
   * @see PLM.Parameter#getExpression()
   * @see #getParameter()
   * @generated
   */
  EAttribute getParameter_Expression();

  /**
   * Returns the meta object for the attribute '{@link PLM.Parameter#isOutput <em>Output</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Output</em>'.
   * @see PLM.Parameter#isOutput()
   * @see #getParameter()
   * @generated
   */
  EAttribute getParameter_Output();

  /**
   * Returns the meta object for the '{@link PLM.Parameter#getClabject() <em>Get Clabject</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Clabject</em>' operation.
   * @see PLM.Parameter#getClabject()
   * @generated
   */
  EOperation getParameter__GetClabject();

  /**
   * Returns the meta object for class '{@link PLM.ClabjectParameter <em>Clabject Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Clabject Parameter</em>'.
   * @see PLM.ClabjectParameter
   * @generated
   */
  EClass getClabjectParameter();

  /**
   * Returns the meta object for the reference '{@link PLM.ClabjectParameter#getDatatype <em>Datatype</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Datatype</em>'.
   * @see PLM.ClabjectParameter#getDatatype()
   * @see #getClabjectParameter()
   * @generated
   */
  EReference getClabjectParameter_Datatype();

  /**
   * Returns the meta object for class '{@link PLM.PrimitiveParameter <em>Primitive Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Primitive Parameter</em>'.
   * @see PLM.PrimitiveParameter
   * @generated
   */
  EClass getPrimitiveParameter();

  /**
   * Returns the meta object for the attribute '{@link PLM.PrimitiveParameter#getDatatype <em>Datatype</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Datatype</em>'.
   * @see PLM.PrimitiveParameter#getDatatype()
   * @see #getPrimitiveParameter()
   * @generated
   */
  EAttribute getPrimitiveParameter_Datatype();

  /**
   * Returns the meta object for class '{@link PLM.Multiplicity <em>Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Multiplicity</em>'.
   * @see PLM.Multiplicity
   * @generated
   */
  EClass getMultiplicity();

  /**
   * Returns the meta object for the attribute '{@link PLM.Multiplicity#getLower <em>Lower</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Lower</em>'.
   * @see PLM.Multiplicity#getLower()
   * @see #getMultiplicity()
   * @generated
   */
  EAttribute getMultiplicity_Lower();

  /**
   * Returns the meta object for the attribute '{@link PLM.Multiplicity#getUpper <em>Upper</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Upper</em>'.
   * @see PLM.Multiplicity#getUpper()
   * @see #getMultiplicity()
   * @generated
   */
  EAttribute getMultiplicity_Upper();

  /**
   * Returns the meta object for the attribute '{@link PLM.Multiplicity#getPotency <em>Potency</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Potency</em>'.
   * @see PLM.Multiplicity#getPotency()
   * @see #getMultiplicity()
   * @generated
   */
  EAttribute getMultiplicity_Potency();

  /**
   * Returns the meta object for the container reference '{@link PLM.Multiplicity#getConnectionend <em>Connectionend</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Connectionend</em>'.
   * @see PLM.Multiplicity#getConnectionend()
   * @see #getMultiplicity()
   * @generated
   */
  EReference getMultiplicity_Connectionend();

  /**
   * Returns the meta object for class '{@link PLM.Package <em>Package</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Package</em>'.
   * @see PLM.Package
   * @generated
   */
  EClass getPackage();

  /**
   * Returns the meta object for the containment reference list '{@link PLM.Package#getContent <em>Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Content</em>'.
   * @see PLM.Package#getContent()
   * @see #getPackage()
   * @generated
   */
  EReference getPackage_Content();

  /**
   * Returns the meta object for class '{@link PLM.AbstractDSLVisualizer <em>Abstract DSL Visualizer</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract DSL Visualizer</em>'.
   * @see PLM.AbstractDSLVisualizer
   * @generated
   */
  EClass getAbstractDSLVisualizer();

  /**
   * Returns the meta object for the attribute '{@link PLM.AbstractDSLVisualizer#isInstanceLevel <em>Instance Level</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Instance Level</em>'.
   * @see PLM.AbstractDSLVisualizer#isInstanceLevel()
   * @see #getAbstractDSLVisualizer()
   * @generated
   */
  EAttribute getAbstractDSLVisualizer_InstanceLevel();

  /**
   * Returns the meta object for the attribute '{@link PLM.AbstractDSLVisualizer#getNotation <em>Notation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Notation</em>'.
   * @see PLM.AbstractDSLVisualizer#getNotation()
   * @see #getAbstractDSLVisualizer()
   * @generated
   */
  EAttribute getAbstractDSLVisualizer_Notation();

  /**
   * Returns the meta object for the '{@link PLM.AbstractDSLVisualizer#format() <em>Format</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Format</em>' operation.
   * @see PLM.AbstractDSLVisualizer#format()
   * @generated
   */
  EOperation getAbstractDSLVisualizer__Format();

  /**
   * Returns the meta object for class '{@link PLM.AbstractBehavior <em>Abstract Behavior</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Behavior</em>'.
   * @see PLM.AbstractBehavior
   * @generated
   */
  EClass getAbstractBehavior();

  /**
   * Returns the meta object for the attribute '{@link PLM.AbstractBehavior#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see PLM.AbstractBehavior#getName()
   * @see #getAbstractBehavior()
   * @generated
   */
  EAttribute getAbstractBehavior_Name();

  /**
   * Returns the meta object for class '{@link PLM.AbstractConstraint <em>Abstract Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Constraint</em>'.
   * @see PLM.AbstractConstraint
   * @generated
   */
  EClass getAbstractConstraint();

  /**
   * Returns the meta object for the attribute '{@link PLM.AbstractConstraint#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see PLM.AbstractConstraint#getName()
   * @see #getAbstractConstraint()
   * @generated
   */
  EAttribute getAbstractConstraint_Name();

  /**
   * Returns the meta object for enum '{@link PLM.ConnectionEndKind <em>Connection End Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Connection End Kind</em>'.
   * @see PLM.ConnectionEndKind
   * @generated
   */
  EEnum getConnectionEndKind();

  /**
   * Returns the meta object for enum '{@link PLM.ClassificationKind <em>Classification Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Classification Kind</em>'.
   * @see PLM.ClassificationKind
   * @generated
   */
  EEnum getClassificationKind();

  /**
   * Returns the meta object for enum '{@link PLM.ComplianceKind <em>Compliance Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Compliance Kind</em>'.
   * @see PLM.ComplianceKind
   * @generated
   */
  EEnum getComplianceKind();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  PLMFactory getPLMFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each operation of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals {
    /**
     * The meta object literal for the '{@link PLM.impl.DomainImpl <em>Domain</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see PLM.impl.DomainImpl
     * @see PLM.impl.PLMPackageImpl#getDomain()
     * @generated
     */
    EClass DOMAIN = eINSTANCE.getDomain();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DOMAIN__NAME = eINSTANCE.getDomain_Name();

    /**
     * The meta object literal for the '<em><b>Deep Model</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DOMAIN__DEEP_MODEL = eINSTANCE.getDomain_DeepModel();

    /**
     * The meta object literal for the '<em><b>Plm Version</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DOMAIN__PLM_VERSION = eINSTANCE.getDomain_PlmVersion();

    /**
     * The meta object literal for the '<em><b>Compliance Kind</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DOMAIN__COMPLIANCE_KIND = eINSTANCE.getDomain_ComplianceKind();

    /**
     * The meta object literal for the '{@link PLM.impl.ElementImpl <em>Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see PLM.impl.ElementImpl
     * @see PLM.impl.PLMPackageImpl#getElement()
     * @generated
     */
    EClass ELEMENT = eINSTANCE.getElement();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ELEMENT__NAME = eINSTANCE.getElement_Name();

    /**
     * The meta object literal for the '<em><b>Visualizer</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ELEMENT__VISUALIZER = eINSTANCE.getElement_Visualizer();

    /**
     * The meta object literal for the '<em><b>Behavior</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ELEMENT__BEHAVIOR = eINSTANCE.getElement_Behavior();

    /**
     * The meta object literal for the '<em><b>Constraint</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ELEMENT__CONSTRAINT = eINSTANCE.getElement_Constraint();

    /**
     * The meta object literal for the '{@link PLM.impl.LevelImpl <em>Level</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see PLM.impl.LevelImpl
     * @see PLM.impl.PLMPackageImpl#getLevel()
     * @generated
     */
    EClass LEVEL = eINSTANCE.getLevel();

    /**
     * The meta object literal for the '<em><b>Content</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LEVEL__CONTENT = eINSTANCE.getLevel_Content();

    /**
     * The meta object literal for the '<em><b>Get All Inheritances</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation LEVEL___GET_ALL_INHERITANCES = eINSTANCE.getLevel__GetAllInheritances();

    /**
     * The meta object literal for the '<em><b>Get Clabjects</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation LEVEL___GET_CLABJECTS = eINSTANCE.getLevel__GetClabjects();

    /**
     * The meta object literal for the '<em><b>Get Entities</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation LEVEL___GET_ENTITIES = eINSTANCE.getLevel__GetEntities();

    /**
     * The meta object literal for the '<em><b>Get Connections</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation LEVEL___GET_CONNECTIONS = eINSTANCE.getLevel__GetConnections();

    /**
     * The meta object literal for the '<em><b>Get Classifications</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation LEVEL___GET_CLASSIFICATIONS = eINSTANCE.getLevel__GetClassifications();

    /**
     * The meta object literal for the '<em><b>Get Deep Model</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation LEVEL___GET_DEEP_MODEL = eINSTANCE.getLevel__GetDeepModel();

    /**
     * The meta object literal for the '<em><b>Get Classified Level</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation LEVEL___GET_CLASSIFIED_LEVEL = eINSTANCE.getLevel__GetClassifiedLevel();

    /**
     * The meta object literal for the '<em><b>Get Classifying Level</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation LEVEL___GET_CLASSIFYING_LEVEL = eINSTANCE.getLevel__GetClassifyingLevel();

    /**
     * The meta object literal for the '<em><b>Get Level</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation LEVEL___GET_LEVEL = eINSTANCE.getLevel__GetLevel();

    /**
     * The meta object literal for the '<em><b>Is Root Level</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation LEVEL___IS_ROOT_LEVEL = eINSTANCE.getLevel__IsRootLevel();

    /**
     * The meta object literal for the '<em><b>Is Leaf Level</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation LEVEL___IS_LEAF_LEVEL = eINSTANCE.getLevel__IsLeafLevel();

    /**
     * The meta object literal for the '{@link PLM.impl.DeepModelImpl <em>Deep Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see PLM.impl.DeepModelImpl
     * @see PLM.impl.PLMPackageImpl#getDeepModel()
     * @generated
     */
    EClass DEEP_MODEL = eINSTANCE.getDeepModel();

    /**
     * The meta object literal for the '<em><b>Content</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DEEP_MODEL__CONTENT = eINSTANCE.getDeepModel_Content();

    /**
     * The meta object literal for the '<em><b>Enumeration</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DEEP_MODEL__ENUMERATION = eINSTANCE.getDeepModel_Enumeration();

    /**
     * The meta object literal for the '<em><b>Get Level At Index</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation DEEP_MODEL___GET_LEVEL_AT_INDEX__INT = eINSTANCE.getDeepModel__GetLevelAtIndex__int();

    /**
     * The meta object literal for the '<em><b>Get Primitive Datatypes</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation DEEP_MODEL___GET_PRIMITIVE_DATATYPES = eINSTANCE.getDeepModel__GetPrimitiveDatatypes();

    /**
     * The meta object literal for the '<em><b>Get Regex For Primitive Datatype</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation DEEP_MODEL___GET_REGEX_FOR_PRIMITIVE_DATATYPE__STRING = eINSTANCE.getDeepModel__GetRegexForPrimitiveDatatype__String();

    /**
     * The meta object literal for the '<em><b>Get All Datatypes</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation DEEP_MODEL___GET_ALL_DATATYPES = eINSTANCE.getDeepModel__GetAllDatatypes();

    /**
     * The meta object literal for the '{@link PLM.impl.OwnedElementImpl <em>Owned Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see PLM.impl.OwnedElementImpl
     * @see PLM.impl.PLMPackageImpl#getOwnedElement()
     * @generated
     */
    EClass OWNED_ELEMENT = eINSTANCE.getOwnedElement();

    /**
     * The meta object literal for the '<em><b>Get Level</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation OWNED_ELEMENT___GET_LEVEL = eINSTANCE.getOwnedElement__GetLevel();

    /**
     * The meta object literal for the '{@link PLM.impl.CorrelationImpl <em>Correlation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see PLM.impl.CorrelationImpl
     * @see PLM.impl.PLMPackageImpl#getCorrelation()
     * @generated
     */
    EClass CORRELATION = eINSTANCE.getCorrelation();

    /**
     * The meta object literal for the '{@link PLM.impl.InheritanceImpl <em>Inheritance</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see PLM.impl.InheritanceImpl
     * @see PLM.impl.PLMPackageImpl#getInheritance()
     * @generated
     */
    EClass INHERITANCE = eINSTANCE.getInheritance();

    /**
     * The meta object literal for the '<em><b>Supertype</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INHERITANCE__SUPERTYPE = eINSTANCE.getInheritance_Supertype();

    /**
     * The meta object literal for the '<em><b>Subtype</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INHERITANCE__SUBTYPE = eINSTANCE.getInheritance_Subtype();

    /**
     * The meta object literal for the '<em><b>Disjoint</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INHERITANCE__DISJOINT = eINSTANCE.getInheritance_Disjoint();

    /**
     * The meta object literal for the '<em><b>Complete</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INHERITANCE__COMPLETE = eINSTANCE.getInheritance_Complete();

    /**
     * The meta object literal for the '<em><b>Is Disjoint</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation INHERITANCE___IS_DISJOINT = eINSTANCE.getInheritance__IsDisjoint();

    /**
     * The meta object literal for the '<em><b>Is Complete</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation INHERITANCE___IS_COMPLETE = eINSTANCE.getInheritance__IsComplete();

    /**
     * The meta object literal for the '<em><b>Is Intersection</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation INHERITANCE___IS_INTERSECTION = eINSTANCE.getInheritance__IsIntersection();

    /**
     * The meta object literal for the '<em><b>Represent</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation INHERITANCE___REPRESENT = eINSTANCE.getInheritance__Represent();

    /**
     * The meta object literal for the '<em><b>Get Supertypes</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation INHERITANCE___GET_SUPERTYPES = eINSTANCE.getInheritance__GetSupertypes();

    /**
     * The meta object literal for the '<em><b>Get Subtypes</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation INHERITANCE___GET_SUBTYPES = eINSTANCE.getInheritance__GetSubtypes();

    /**
     * The meta object literal for the '{@link PLM.impl.SupertypeImpl <em>Supertype</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see PLM.impl.SupertypeImpl
     * @see PLM.impl.PLMPackageImpl#getSupertype()
     * @generated
     */
    EClass SUPERTYPE = eINSTANCE.getSupertype();

    /**
     * The meta object literal for the '<em><b>Supertype</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUPERTYPE__SUPERTYPE = eINSTANCE.getSupertype_Supertype();

    /**
     * The meta object literal for the '<em><b>Inheritance</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUPERTYPE__INHERITANCE = eINSTANCE.getSupertype_Inheritance();

    /**
     * The meta object literal for the '{@link PLM.impl.SubtypeImpl <em>Subtype</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see PLM.impl.SubtypeImpl
     * @see PLM.impl.PLMPackageImpl#getSubtype()
     * @generated
     */
    EClass SUBTYPE = eINSTANCE.getSubtype();

    /**
     * The meta object literal for the '<em><b>Subtype</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUBTYPE__SUBTYPE = eINSTANCE.getSubtype_Subtype();

    /**
     * The meta object literal for the '<em><b>Inheritance</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUBTYPE__INHERITANCE = eINSTANCE.getSubtype_Inheritance();

    /**
     * The meta object literal for the '{@link PLM.impl.ClassificationImpl <em>Classification</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see PLM.impl.ClassificationImpl
     * @see PLM.impl.PLMPackageImpl#getClassification()
     * @generated
     */
    EClass CLASSIFICATION = eINSTANCE.getClassification();

    /**
     * The meta object literal for the '<em><b>Instance</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASSIFICATION__INSTANCE = eINSTANCE.getClassification_Instance();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASSIFICATION__TYPE = eINSTANCE.getClassification_Type();

    /**
     * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLASSIFICATION__KIND = eINSTANCE.getClassification_Kind();

    /**
     * The meta object literal for the '<em><b>Represent</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLASSIFICATION___REPRESENT = eINSTANCE.getClassification__Represent();

    /**
     * The meta object literal for the '{@link PLM.impl.ClabjectImpl <em>Clabject</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see PLM.impl.ClabjectImpl
     * @see PLM.impl.PLMPackageImpl#getClabject()
     * @generated
     */
    EClass CLABJECT = eINSTANCE.getClabject();

    /**
     * The meta object literal for the '<em><b>Potency</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLABJECT__POTENCY = eINSTANCE.getClabject_Potency();

    /**
     * The meta object literal for the '<em><b>Level Index</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLABJECT__LEVEL_INDEX = eINSTANCE.getClabject_LevelIndex();

    /**
     * The meta object literal for the '<em><b>Content</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLABJECT__CONTENT = eINSTANCE.getClabject_Content();

    /**
     * The meta object literal for the '<em><b>Feature</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLABJECT__FEATURE = eINSTANCE.getClabject_Feature();

    /**
     * The meta object literal for the '<em><b>Get Deep Model</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_DEEP_MODEL = eINSTANCE.getClabject__GetDeepModel();

    /**
     * The meta object literal for the '<em><b>Get Supertypes</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_SUPERTYPES = eINSTANCE.getClabject__GetSupertypes();

    /**
     * The meta object literal for the '<em><b>Get Supertypes</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_SUPERTYPES__ELIST = eINSTANCE.getClabject__GetSupertypes__EList();

    /**
     * The meta object literal for the '<em><b>Get Direct Supertypes</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_DIRECT_SUPERTYPES = eINSTANCE.getClabject__GetDirectSupertypes();

    /**
     * The meta object literal for the '<em><b>Get Subtypes</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_SUBTYPES = eINSTANCE.getClabject__GetSubtypes();

    /**
     * The meta object literal for the '<em><b>Get Hollow Subtypes</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_HOLLOW_SUBTYPES = eINSTANCE.getClabject__GetHollowSubtypes();

    /**
     * The meta object literal for the '<em><b>Get Hollow Supertypes</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_HOLLOW_SUPERTYPES = eINSTANCE.getClabject__GetHollowSupertypes();

    /**
     * The meta object literal for the '<em><b>Get Classifications As Instance</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_CLASSIFICATIONS_AS_INSTANCE = eINSTANCE.getClabject__GetClassificationsAsInstance();

    /**
     * The meta object literal for the '<em><b>Get Classifications As Type</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_CLASSIFICATIONS_AS_TYPE = eINSTANCE.getClabject__GetClassificationsAsType();

    /**
     * The meta object literal for the '<em><b>Get Instances</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_INSTANCES = eINSTANCE.getClabject__GetInstances();

    /**
     * The meta object literal for the '<em><b>Get Types</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_TYPES = eINSTANCE.getClabject__GetTypes();

    /**
     * The meta object literal for the '<em><b>Get Direct Types</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_DIRECT_TYPES = eINSTANCE.getClabject__GetDirectTypes();

    /**
     * The meta object literal for the '<em><b>Get Level Types</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_LEVEL_TYPES = eINSTANCE.getClabject__GetLevelTypes();

    /**
     * The meta object literal for the '<em><b>Get Defined Classification Tree As Instance</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_DEFINED_CLASSIFICATION_TREE_AS_INSTANCE = eINSTANCE.getClabject__GetDefinedClassificationTreeAsInstance();

    /**
     * The meta object literal for the '<em><b>Get Classification Tree As Instance</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_CLASSIFICATION_TREE_AS_INSTANCE = eINSTANCE.getClabject__GetClassificationTreeAsInstance();

    /**
     * The meta object literal for the '<em><b>Get Defined Instances</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_DEFINED_INSTANCES = eINSTANCE.getClabject__GetDefinedInstances();

    /**
     * The meta object literal for the '<em><b>Get Defined Classification Tree As Type</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_DEFINED_CLASSIFICATION_TREE_AS_TYPE = eINSTANCE.getClabject__GetDefinedClassificationTreeAsType();

    /**
     * The meta object literal for the '<em><b>Get Classification Tree As Type</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_CLASSIFICATION_TREE_AS_TYPE = eINSTANCE.getClabject__GetClassificationTreeAsType();

    /**
     * The meta object literal for the '<em><b>Get Classification Tree As Type</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_CLASSIFICATION_TREE_AS_TYPE__INT = eINSTANCE.getClabject__GetClassificationTreeAsType__int();

    /**
     * The meta object literal for the '<em><b>Get Classification Tree As Type</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_CLASSIFICATION_TREE_AS_TYPE__INT_INT = eINSTANCE.getClabject__GetClassificationTreeAsType__int_int();

    /**
     * The meta object literal for the '<em><b>Get All Features</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_ALL_FEATURES = eINSTANCE.getClabject__GetAllFeatures();

    /**
     * The meta object literal for the '<em><b>Get All Attributes</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_ALL_ATTRIBUTES = eINSTANCE.getClabject__GetAllAttributes();

    /**
     * The meta object literal for the '<em><b>Get Defined Attributes</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_DEFINED_ATTRIBUTES = eINSTANCE.getClabject__GetDefinedAttributes();

    /**
     * The meta object literal for the '<em><b>Get Defined Attribute By Name</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_DEFINED_ATTRIBUTE_BY_NAME__STRING = eINSTANCE.getClabject__GetDefinedAttributeByName__String();

    /**
     * The meta object literal for the '<em><b>Get All Methods</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_ALL_METHODS = eINSTANCE.getClabject__GetAllMethods();

    /**
     * The meta object literal for the '<em><b>Get Defined Methods</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_DEFINED_METHODS = eINSTANCE.getClabject__GetDefinedMethods();

    /**
     * The meta object literal for the '<em><b>Is Instance Of</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___IS_INSTANCE_OF__CLABJECT = eINSTANCE.getClabject__IsInstanceOf__Clabject();

    /**
     * The meta object literal for the '<em><b>Is Type Of</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___IS_TYPE_OF__CLABJECT = eINSTANCE.getClabject__IsTypeOf__Clabject();

    /**
     * The meta object literal for the '<em><b>Is Container Of</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___IS_CONTAINER_OF__CLABJECT = eINSTANCE.getClabject__IsContainerOf__Clabject();

    /**
     * The meta object literal for the '<em><b>Get Composite</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_COMPOSITE = eINSTANCE.getClabject__GetComposite();

    /**
     * The meta object literal for the '<em><b>Get Aggregates</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_AGGREGATES = eINSTANCE.getClabject__GetAggregates();

    /**
     * The meta object literal for the '<em><b>Get Parts</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_PARTS = eINSTANCE.getClabject__GetParts();

    /**
     * The meta object literal for the '<em><b>Get Parts For Moniker</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_PARTS_FOR_MONIKER__STRING = eINSTANCE.getClabject__GetPartsForMoniker__String();

    /**
     * The meta object literal for the '<em><b>Get Defined Connections</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_DEFINED_CONNECTIONS = eINSTANCE.getClabject__GetDefinedConnections();

    /**
     * The meta object literal for the '<em><b>Get Connections</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_CONNECTIONS = eINSTANCE.getClabject__GetConnections();

    /**
     * The meta object literal for the '<em><b>Get Inherited Connections</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_INHERITED_CONNECTIONS = eINSTANCE.getClabject__GetInheritedConnections();

    /**
     * The meta object literal for the '<em><b>Get Level Complete Types</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_LEVEL_COMPLETE_TYPES = eINSTANCE.getClabject__GetLevelCompleteTypes();

    /**
     * The meta object literal for the '<em><b>Get Level Incomplete Types</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_LEVEL_INCOMPLETE_TYPES = eINSTANCE.getClabject__GetLevelIncompleteTypes();

    /**
     * The meta object literal for the '<em><b>Get Blueprint</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_BLUEPRINT = eINSTANCE.getClabject__GetBlueprint();

    /**
     * The meta object literal for the '<em><b>Get Offspring</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_OFFSPRING = eINSTANCE.getClabject__GetOffspring();

    /**
     * The meta object literal for the '<em><b>Get Isonyms</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_ISONYMS = eINSTANCE.getClabject__GetIsonyms();

    /**
     * The meta object literal for the '<em><b>Get Hyponyms</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_HYPONYMS = eINSTANCE.getClabject__GetHyponyms();

    /**
     * The meta object literal for the '<em><b>Get Domain For Connection</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_DOMAIN_FOR_CONNECTION__CONNECTION = eINSTANCE.getClabject__GetDomainForConnection__Connection();

    /**
     * The meta object literal for the '<em><b>Get Possible Domain Specific Visualizers</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated See {@link PLM.Clabject#getPossibleDomainSpecificVisualizers() model documentation} for details.
     * @generated
     */
    @Deprecated
    EOperation CLABJECT___GET_POSSIBLE_DOMAIN_SPECIFIC_VISUALIZERS = eINSTANCE.getClabject__GetPossibleDomainSpecificVisualizers();

    /**
     * The meta object literal for the '<em><b>Get Inheritances As Subtype</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_INHERITANCES_AS_SUBTYPE = eINSTANCE.getClabject__GetInheritancesAsSubtype();

    /**
     * The meta object literal for the '<em><b>Get Inheritances As Supertype</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_INHERITANCES_AS_SUPERTYPE = eINSTANCE.getClabject__GetInheritancesAsSupertype();

    /**
     * The meta object literal for the '<em><b>Get Defined Navigations</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_DEFINED_NAVIGATIONS = eINSTANCE.getClabject__GetDefinedNavigations();

    /**
     * The meta object literal for the '<em><b>Get Inherited Navigations</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_INHERITED_NAVIGATIONS = eINSTANCE.getClabject__GetInheritedNavigations();

    /**
     * The meta object literal for the '<em><b>Get All Navigations</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_ALL_NAVIGATIONS = eINSTANCE.getClabject__GetAllNavigations();

    /**
     * The meta object literal for the '<em><b>Get Domain Monikers</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_DOMAIN_MONIKERS = eINSTANCE.getClabject__GetDomainMonikers();

    /**
     * The meta object literal for the '<em><b>Get Domain For Moniker</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    EOperation CLABJECT___GET_DOMAIN_FOR_MONIKER__STRING = eINSTANCE.getClabject__GetDomainForMoniker__String();

    /**
     * The meta object literal for the '<em><b>Get All Navigations For Moniker</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_ALL_NAVIGATIONS_FOR_MONIKER__STRING = eINSTANCE.getClabject__GetAllNavigationsForMoniker__String();

    /**
     * The meta object literal for the '<em><b>Get All Navigations As Destination</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_ALL_NAVIGATIONS_AS_DESTINATION = eINSTANCE.getClabject__GetAllNavigationsAsDestination();

    /**
     * The meta object literal for the '<em><b>Get Defined Navigations As Destination</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_DEFINED_NAVIGATIONS_AS_DESTINATION = eINSTANCE.getClabject__GetDefinedNavigationsAsDestination();

    /**
     * The meta object literal for the '<em><b>Get Inherited Navigations As Destination</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_INHERITED_NAVIGATIONS_AS_DESTINATION = eINSTANCE.getClabject__GetInheritedNavigationsAsDestination();

    /**
     * The meta object literal for the '<em><b>Represent</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___REPRESENT = eINSTANCE.getClabject__Represent();

    /**
     * The meta object literal for the '<em><b>Get Feature For Name</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_FEATURE_FOR_NAME__STRING = eINSTANCE.getClabject__GetFeatureForName__String();

    /**
     * The meta object literal for the '<em><b>Get Potency As String</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_POTENCY_AS_STRING = eINSTANCE.getClabject__GetPotencyAsString();

    /**
     * The meta object literal for the '<em><b>Get Disjoint Siblings</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_DISJOINT_SIBLINGS = eINSTANCE.getClabject__GetDisjointSiblings();

    /**
     * The meta object literal for the '<em><b>Get Attribute By Name</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_ATTRIBUTE_BY_NAME__STRING = eINSTANCE.getClabject__GetAttributeByName__String();

    /**
     * The meta object literal for the '<em><b>Violates Multiplicity Constraints</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___VIOLATES_MULTIPLICITY_CONSTRAINTS = eINSTANCE.getClabject__ViolatesMultiplicityConstraints();

    /**
     * The meta object literal for the '<em><b>Get Defined Inheritances</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_DEFINED_INHERITANCES = eINSTANCE.getClabject__GetDefinedInheritances();

    /**
     * The meta object literal for the '<em><b>Get Owned Clabjects</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_OWNED_CLABJECTS = eINSTANCE.getClabject__GetOwnedClabjects();

    /**
     * The meta object literal for the '<em><b>Get Direct Type</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CLABJECT___GET_DIRECT_TYPE = eINSTANCE.getClabject__GetDirectType();

    /**
     * The meta object literal for the '{@link PLM.impl.FeatureImpl <em>Feature</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see PLM.impl.FeatureImpl
     * @see PLM.impl.PLMPackageImpl#getFeature()
     * @generated
     */
    EClass FEATURE = eINSTANCE.getFeature();

    /**
     * The meta object literal for the '<em><b>Durability</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FEATURE__DURABILITY = eINSTANCE.getFeature_Durability();

    /**
     * The meta object literal for the '<em><b>Get Clabject</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation FEATURE___GET_CLABJECT = eINSTANCE.getFeature__GetClabject();

    /**
     * The meta object literal for the '<em><b>Get Durability As String</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation FEATURE___GET_DURABILITY_AS_STRING = eINSTANCE.getFeature__GetDurabilityAsString();

    /**
     * The meta object literal for the '<em><b>Represent</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation FEATURE___REPRESENT = eINSTANCE.getFeature__Represent();

    /**
     * The meta object literal for the '{@link PLM.impl.EntityImpl <em>Entity</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see PLM.impl.EntityImpl
     * @see PLM.impl.PLMPackageImpl#getEntity()
     * @generated
     */
    EClass ENTITY = eINSTANCE.getEntity();

    /**
     * The meta object literal for the '<em><b>Represent</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation ENTITY___REPRESENT = eINSTANCE.getEntity__Represent();

    /**
     * The meta object literal for the '{@link PLM.impl.ConnectionImpl <em>Connection</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see PLM.impl.ConnectionImpl
     * @see PLM.impl.PLMPackageImpl#getConnection()
     * @generated
     */
    EClass CONNECTION = eINSTANCE.getConnection();

    /**
     * The meta object literal for the '<em><b>Connection End</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONNECTION__CONNECTION_END = eINSTANCE.getConnection_ConnectionEnd();

    /**
     * The meta object literal for the '<em><b>Get Domain</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CONNECTION___GET_DOMAIN = eINSTANCE.getConnection__GetDomain();

    /**
     * The meta object literal for the '<em><b>Get Not Domain</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CONNECTION___GET_NOT_DOMAIN = eINSTANCE.getConnection__GetNotDomain();

    /**
     * The meta object literal for the '<em><b>Get Human Readable Name</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CONNECTION___GET_HUMAN_READABLE_NAME = eINSTANCE.getConnection__GetHumanReadableName();

    /**
     * The meta object literal for the '<em><b>Get Participants</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CONNECTION___GET_PARTICIPANTS = eINSTANCE.getConnection__GetParticipants();

    /**
     * The meta object literal for the '<em><b>Get Moniker</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CONNECTION___GET_MONIKER = eINSTANCE.getConnection__GetMoniker();

    /**
     * The meta object literal for the '<em><b>Get Domain</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CONNECTION___GET_DOMAIN__CLABJECT = eINSTANCE.getConnection__GetDomain__Clabject();

    /**
     * The meta object literal for the '<em><b>Get Moniker For Participant</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CONNECTION___GET_MONIKER_FOR_PARTICIPANT__CLABJECT = eINSTANCE.getConnection__GetMonikerForParticipant__Clabject();

    /**
     * The meta object literal for the '<em><b>Get Lower For Moniker</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CONNECTION___GET_LOWER_FOR_MONIKER__STRING = eINSTANCE.getConnection__GetLowerForMoniker__String();

    /**
     * The meta object literal for the '<em><b>Get Upper For Moniker</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CONNECTION___GET_UPPER_FOR_MONIKER__STRING = eINSTANCE.getConnection__GetUpperForMoniker__String();

    /**
     * The meta object literal for the '<em><b>Is Navigable For Moniker</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CONNECTION___IS_NAVIGABLE_FOR_MONIKER__STRING = eINSTANCE.getConnection__IsNavigableForMoniker__String();

    /**
     * The meta object literal for the '<em><b>Get Order</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CONNECTION___GET_ORDER = eINSTANCE.getConnection__GetOrder();

    /**
     * The meta object literal for the '<em><b>Get Inherited Connection End</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CONNECTION___GET_INHERITED_CONNECTION_END = eINSTANCE.getConnection__GetInheritedConnectionEnd();

    /**
     * The meta object literal for the '<em><b>Get All Connection End</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CONNECTION___GET_ALL_CONNECTION_END = eINSTANCE.getConnection__GetAllConnectionEnd();

    /**
     * The meta object literal for the '<em><b>Get Participant For Moniker</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CONNECTION___GET_PARTICIPANT_FOR_MONIKER__STRING = eINSTANCE.getConnection__GetParticipantForMoniker__String();

    /**
     * The meta object literal for the '<em><b>Represent</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CONNECTION___REPRESENT = eINSTANCE.getConnection__Represent();

    /**
     * The meta object literal for the '{@link PLM.impl.ConnectionEndImpl <em>Connection End</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see PLM.impl.ConnectionEndImpl
     * @see PLM.impl.PLMPackageImpl#getConnectionEnd()
     * @generated
     */
    EClass CONNECTION_END = eINSTANCE.getConnectionEnd();

    /**
     * The meta object literal for the '<em><b>Lower</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONNECTION_END__LOWER = eINSTANCE.getConnectionEnd_Lower();

    /**
     * The meta object literal for the '<em><b>Upper</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONNECTION_END__UPPER = eINSTANCE.getConnectionEnd_Upper();

    /**
     * The meta object literal for the '<em><b>Navigable</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONNECTION_END__NAVIGABLE = eINSTANCE.getConnectionEnd_Navigable();

    /**
     * The meta object literal for the '<em><b>Destination</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONNECTION_END__DESTINATION = eINSTANCE.getConnectionEnd_Destination();

    /**
     * The meta object literal for the '<em><b>Connection</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONNECTION_END__CONNECTION = eINSTANCE.getConnectionEnd_Connection();

    /**
     * The meta object literal for the '<em><b>Moniker</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONNECTION_END__MONIKER = eINSTANCE.getConnectionEnd_Moniker();

    /**
     * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONNECTION_END__KIND = eINSTANCE.getConnectionEnd_Kind();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONNECTION_END__TYPE = eINSTANCE.getConnectionEnd_Type();

    /**
     * The meta object literal for the '<em><b>Multiplicity</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONNECTION_END__MULTIPLICITY = eINSTANCE.getConnectionEnd_Multiplicity();

    /**
     * The meta object literal for the '<em><b>Get Human Readable Connection End Name</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CONNECTION_END___GET_HUMAN_READABLE_CONNECTION_END_NAME = eINSTANCE.getConnectionEnd__GetHumanReadableConnectionEndName();

    /**
     * The meta object literal for the '<em><b>Has Default Moniker</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CONNECTION_END___HAS_DEFAULT_MONIKER = eINSTANCE.getConnectionEnd__HasDefaultMoniker();

    /**
     * The meta object literal for the '<em><b>Represent</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CONNECTION_END___REPRESENT = eINSTANCE.getConnectionEnd__Represent();

    /**
     * The meta object literal for the '<em><b>Moniker</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CONNECTION_END___MONIKER = eINSTANCE.getConnectionEnd__Moniker();

    /**
     * The meta object literal for the '<em><b>Represent Multiplicity</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CONNECTION_END___REPRESENT_MULTIPLICITY = eINSTANCE.getConnectionEnd__RepresentMultiplicity();

    /**
     * The meta object literal for the '<em><b>Get Connection End Name</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CONNECTION_END___GET_CONNECTION_END_NAME = eINSTANCE.getConnectionEnd__GetConnectionEndName();

    /**
     * The meta object literal for the '<em><b>Conforms</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation CONNECTION_END___CONFORMS__CONNECTIONEND = eINSTANCE.getConnectionEnd__Conforms__ConnectionEnd();

    /**
     * The meta object literal for the '{@link PLM.impl.LMLVisualizerImpl <em>LML Visualizer</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see PLM.impl.LMLVisualizerImpl
     * @see PLM.impl.PLMPackageImpl#getLMLVisualizer()
     * @generated
     */
    EClass LML_VISUALIZER = eINSTANCE.getLMLVisualizer();

    /**
     * The meta object literal for the '<em><b>Attributes</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LML_VISUALIZER__ATTRIBUTES = eINSTANCE.getLMLVisualizer_Attributes();

    /**
     * The meta object literal for the '<em><b>Dsl Visualizer</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LML_VISUALIZER__DSL_VISUALIZER = eINSTANCE.getLMLVisualizer_DslVisualizer();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LML_VISUALIZER__NAME = eINSTANCE.getLMLVisualizer_Name();

    /**
     * The meta object literal for the '<em><b>XLocation</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LML_VISUALIZER__XLOCATION = eINSTANCE.getLMLVisualizer_XLocation();

    /**
     * The meta object literal for the '<em><b>YLocation</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LML_VISUALIZER__YLOCATION = eINSTANCE.getLMLVisualizer_YLocation();

    /**
     * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LML_VISUALIZER__WIDTH = eINSTANCE.getLMLVisualizer_Width();

    /**
     * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LML_VISUALIZER__HEIGHT = eINSTANCE.getLMLVisualizer_Height();

    /**
     * The meta object literal for the '<em><b>Get Default Visualization Values</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation LML_VISUALIZER___GET_DEFAULT_VISUALIZATION_VALUES = eINSTANCE.getLMLVisualizer__GetDefaultVisualizationValues();

    /**
     * The meta object literal for the '<em><b>Get Value For Key</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation LML_VISUALIZER___GET_VALUE_FOR_KEY__STRING = eINSTANCE.getLMLVisualizer__GetValueForKey__String();

    /**
     * The meta object literal for the '<em><b>Get Containing Element</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation LML_VISUALIZER___GET_CONTAINING_ELEMENT = eINSTANCE.getLMLVisualizer__GetContainingElement();

    /**
     * The meta object literal for the '<em><b>EOperation0</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation LML_VISUALIZER___EOPERATION0 = eINSTANCE.getLMLVisualizer__EOperation0();

    /**
     * The meta object literal for the '{@link PLM.impl.PropertyImpl <em>Property</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see PLM.impl.PropertyImpl
     * @see PLM.impl.PLMPackageImpl#getProperty()
     * @generated
     */
    EClass PROPERTY = eINSTANCE.getProperty();

    /**
     * The meta object literal for the '<em><b>Parsing Order</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROPERTY__PARSING_ORDER = eINSTANCE.getProperty_ParsingOrder();

    /**
     * The meta object literal for the '{@link PLM.impl.AttributeImpl <em>Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see PLM.impl.AttributeImpl
     * @see PLM.impl.PLMPackageImpl#getAttribute()
     * @generated
     */
    EClass ATTRIBUTE = eINSTANCE.getAttribute();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTRIBUTE__VALUE = eINSTANCE.getAttribute_Value();

    /**
     * The meta object literal for the '<em><b>Mutability</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTRIBUTE__MUTABILITY = eINSTANCE.getAttribute_Mutability();

    /**
     * The meta object literal for the '<em><b>Datatype</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTRIBUTE__DATATYPE = eINSTANCE.getAttribute_Datatype();

    /**
     * The meta object literal for the '<em><b>Get Mutability As String</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation ATTRIBUTE___GET_MUTABILITY_AS_STRING = eINSTANCE.getAttribute__GetMutabilityAsString();

    /**
     * The meta object literal for the '<em><b>Represent</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation ATTRIBUTE___REPRESENT = eINSTANCE.getAttribute__Represent();

    /**
     * The meta object literal for the '<em><b>Get Possible Data Types</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation ATTRIBUTE___GET_POSSIBLE_DATA_TYPES = eINSTANCE.getAttribute__GetPossibleDataTypes();

    /**
     * The meta object literal for the '<em><b>Get Primitive Data Types</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation ATTRIBUTE___GET_PRIMITIVE_DATA_TYPES = eINSTANCE.getAttribute__GetPrimitiveDataTypes();

    /**
     * The meta object literal for the '<em><b>Get Enumeration Data Types</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation ATTRIBUTE___GET_ENUMERATION_DATA_TYPES = eINSTANCE.getAttribute__GetEnumerationDataTypes();

    /**
     * The meta object literal for the '<em><b>Is Enumeration</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation ATTRIBUTE___IS_ENUMERATION = eINSTANCE.getAttribute__IsEnumeration();

    /**
     * The meta object literal for the '<em><b>Get Enumeration</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation ATTRIBUTE___GET_ENUMERATION = eINSTANCE.getAttribute__GetEnumeration();

    /**
     * The meta object literal for the '<em><b>Get Literals</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation ATTRIBUTE___GET_LITERALS = eINSTANCE.getAttribute__GetLiterals();

    /**
     * The meta object literal for the '{@link PLM.impl.MethodImpl <em>Method</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see PLM.impl.MethodImpl
     * @see PLM.impl.PLMPackageImpl#getMethod()
     * @generated
     */
    EClass METHOD = eINSTANCE.getMethod();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute METHOD__BODY = eINSTANCE.getMethod_Body();

    /**
     * The meta object literal for the '<em><b>Parameter</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference METHOD__PARAMETER = eINSTANCE.getMethod_Parameter();

    /**
     * The meta object literal for the '<em><b>Represent</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation METHOD___REPRESENT = eINSTANCE.getMethod__Represent();

    /**
     * The meta object literal for the '<em><b>Get Input</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation METHOD___GET_INPUT = eINSTANCE.getMethod__GetInput();

    /**
     * The meta object literal for the '<em><b>Get Output</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation METHOD___GET_OUTPUT = eINSTANCE.getMethod__GetOutput();

    /**
     * The meta object literal for the '{@link PLM.impl.EnumerationImpl <em>Enumeration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see PLM.impl.EnumerationImpl
     * @see PLM.impl.PLMPackageImpl#getEnumeration()
     * @generated
     */
    EClass ENUMERATION = eINSTANCE.getEnumeration();

    /**
     * The meta object literal for the '<em><b>Literal</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ENUMERATION__LITERAL = eINSTANCE.getEnumeration_Literal();

    /**
     * The meta object literal for the '{@link PLM.impl.ParameterImpl <em>Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see PLM.impl.ParameterImpl
     * @see PLM.impl.PLMPackageImpl#getParameter()
     * @generated
     */
    EClass PARAMETER = eINSTANCE.getParameter();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARAMETER__NAME = eINSTANCE.getParameter_Name();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARAMETER__EXPRESSION = eINSTANCE.getParameter_Expression();

    /**
     * The meta object literal for the '<em><b>Output</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARAMETER__OUTPUT = eINSTANCE.getParameter_Output();

    /**
     * The meta object literal for the '<em><b>Get Clabject</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation PARAMETER___GET_CLABJECT = eINSTANCE.getParameter__GetClabject();

    /**
     * The meta object literal for the '{@link PLM.impl.ClabjectParameterImpl <em>Clabject Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see PLM.impl.ClabjectParameterImpl
     * @see PLM.impl.PLMPackageImpl#getClabjectParameter()
     * @generated
     */
    EClass CLABJECT_PARAMETER = eINSTANCE.getClabjectParameter();

    /**
     * The meta object literal for the '<em><b>Datatype</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLABJECT_PARAMETER__DATATYPE = eINSTANCE.getClabjectParameter_Datatype();

    /**
     * The meta object literal for the '{@link PLM.impl.PrimitiveParameterImpl <em>Primitive Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see PLM.impl.PrimitiveParameterImpl
     * @see PLM.impl.PLMPackageImpl#getPrimitiveParameter()
     * @generated
     */
    EClass PRIMITIVE_PARAMETER = eINSTANCE.getPrimitiveParameter();

    /**
     * The meta object literal for the '<em><b>Datatype</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PRIMITIVE_PARAMETER__DATATYPE = eINSTANCE.getPrimitiveParameter_Datatype();

    /**
     * The meta object literal for the '{@link PLM.impl.MultiplicityImpl <em>Multiplicity</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see PLM.impl.MultiplicityImpl
     * @see PLM.impl.PLMPackageImpl#getMultiplicity()
     * @generated
     */
    EClass MULTIPLICITY = eINSTANCE.getMultiplicity();

    /**
     * The meta object literal for the '<em><b>Lower</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MULTIPLICITY__LOWER = eINSTANCE.getMultiplicity_Lower();

    /**
     * The meta object literal for the '<em><b>Upper</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MULTIPLICITY__UPPER = eINSTANCE.getMultiplicity_Upper();

    /**
     * The meta object literal for the '<em><b>Potency</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MULTIPLICITY__POTENCY = eINSTANCE.getMultiplicity_Potency();

    /**
     * The meta object literal for the '<em><b>Connectionend</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTIPLICITY__CONNECTIONEND = eINSTANCE.getMultiplicity_Connectionend();

    /**
     * The meta object literal for the '{@link PLM.impl.PackageImpl <em>Package</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see PLM.impl.PackageImpl
     * @see PLM.impl.PLMPackageImpl#getPackage()
     * @generated
     */
    EClass PACKAGE = eINSTANCE.getPackage();

    /**
     * The meta object literal for the '<em><b>Content</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PACKAGE__CONTENT = eINSTANCE.getPackage_Content();

    /**
     * The meta object literal for the '{@link PLM.impl.AbstractDSLVisualizerImpl <em>Abstract DSL Visualizer</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see PLM.impl.AbstractDSLVisualizerImpl
     * @see PLM.impl.PLMPackageImpl#getAbstractDSLVisualizer()
     * @generated
     */
    EClass ABSTRACT_DSL_VISUALIZER = eINSTANCE.getAbstractDSLVisualizer();

    /**
     * The meta object literal for the '<em><b>Instance Level</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ABSTRACT_DSL_VISUALIZER__INSTANCE_LEVEL = eINSTANCE.getAbstractDSLVisualizer_InstanceLevel();

    /**
     * The meta object literal for the '<em><b>Notation</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ABSTRACT_DSL_VISUALIZER__NOTATION = eINSTANCE.getAbstractDSLVisualizer_Notation();

    /**
     * The meta object literal for the '<em><b>Format</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation ABSTRACT_DSL_VISUALIZER___FORMAT = eINSTANCE.getAbstractDSLVisualizer__Format();

    /**
     * The meta object literal for the '{@link PLM.impl.AbstractBehaviorImpl <em>Abstract Behavior</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see PLM.impl.AbstractBehaviorImpl
     * @see PLM.impl.PLMPackageImpl#getAbstractBehavior()
     * @generated
     */
    EClass ABSTRACT_BEHAVIOR = eINSTANCE.getAbstractBehavior();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ABSTRACT_BEHAVIOR__NAME = eINSTANCE.getAbstractBehavior_Name();

    /**
     * The meta object literal for the '{@link PLM.impl.AbstractConstraintImpl <em>Abstract Constraint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see PLM.impl.AbstractConstraintImpl
     * @see PLM.impl.PLMPackageImpl#getAbstractConstraint()
     * @generated
     */
    EClass ABSTRACT_CONSTRAINT = eINSTANCE.getAbstractConstraint();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ABSTRACT_CONSTRAINT__NAME = eINSTANCE.getAbstractConstraint_Name();

    /**
     * The meta object literal for the '{@link PLM.ConnectionEndKind <em>Connection End Kind</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see PLM.ConnectionEndKind
     * @see PLM.impl.PLMPackageImpl#getConnectionEndKind()
     * @generated
     */
    EEnum CONNECTION_END_KIND = eINSTANCE.getConnectionEndKind();

    /**
     * The meta object literal for the '{@link PLM.ClassificationKind <em>Classification Kind</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see PLM.ClassificationKind
     * @see PLM.impl.PLMPackageImpl#getClassificationKind()
     * @generated
     */
    EEnum CLASSIFICATION_KIND = eINSTANCE.getClassificationKind();

    /**
     * The meta object literal for the '{@link PLM.ComplianceKind <em>Compliance Kind</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see PLM.ComplianceKind
     * @see PLM.impl.PLMPackageImpl#getComplianceKind()
     * @generated
     */
    EEnum COMPLIANCE_KIND = eINSTANCE.getComplianceKind();

  }

} //PLMPackage

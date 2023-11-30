/**
 */
package PLM.impl;

import PLM.Attribute;
import PLM.ClabjectParameter;
import PLM.Classification;
import PLM.ClassificationKind;
import PLM.ComplianceKind;
import PLM.Connection;
import PLM.ConnectionEnd;
import PLM.ConnectionEndKind;
import PLM.DeepModel;
import PLM.Domain;
import PLM.Entity;
import PLM.Enumeration;
import PLM.Inheritance;
import PLM.LMLVisualizer;
import PLM.Level;
import PLM.Method;
import PLM.Multiplicity;
import PLM.PLMFactory;
import PLM.PLMPackage;
import PLM.PrimitiveParameter;
import PLM.Subtype;
import PLM.Supertype;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PLMFactoryImpl extends EFactoryImpl implements PLMFactory {
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static PLMFactory init() {
    try {
      PLMFactory thePLMFactory = (PLMFactory)EPackage.Registry.INSTANCE.getEFactory(PLMPackage.eNS_URI);
      if (thePLMFactory != null) {
        return thePLMFactory;
      }
    }
    catch (Exception exception) {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new PLMFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PLMFactoryImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass) {
    switch (eClass.getClassifierID()) {
      case PLMPackage.DOMAIN: return createDomain();
      case PLMPackage.LEVEL: return createLevel();
      case PLMPackage.DEEP_MODEL: return createDeepModel();
      case PLMPackage.INHERITANCE: return createInheritance();
      case PLMPackage.SUPERTYPE: return createSupertype();
      case PLMPackage.SUBTYPE: return createSubtype();
      case PLMPackage.CLASSIFICATION: return createClassification();
      case PLMPackage.ENTITY: return createEntity();
      case PLMPackage.CONNECTION: return createConnection();
      case PLMPackage.CONNECTION_END: return createConnectionEnd();
      case PLMPackage.LML_VISUALIZER: return createLMLVisualizer();
      case PLMPackage.ATTRIBUTE: return createAttribute();
      case PLMPackage.METHOD: return createMethod();
      case PLMPackage.ENUMERATION: return createEnumeration();
      case PLMPackage.CLABJECT_PARAMETER: return createClabjectParameter();
      case PLMPackage.PRIMITIVE_PARAMETER: return createPrimitiveParameter();
      case PLMPackage.MULTIPLICITY: return createMultiplicity();
      case PLMPackage.PACKAGE: return createPackage();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue) {
    switch (eDataType.getClassifierID()) {
      case PLMPackage.CONNECTION_END_KIND:
        return createConnectionEndKindFromString(eDataType, initialValue);
      case PLMPackage.CLASSIFICATION_KIND:
        return createClassificationKindFromString(eDataType, initialValue);
      case PLMPackage.COMPLIANCE_KIND:
        return createComplianceKindFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue) {
    switch (eDataType.getClassifierID()) {
      case PLMPackage.CONNECTION_END_KIND:
        return convertConnectionEndKindToString(eDataType, instanceValue);
      case PLMPackage.CLASSIFICATION_KIND:
        return convertClassificationKindToString(eDataType, instanceValue);
      case PLMPackage.COMPLIANCE_KIND:
        return convertComplianceKindToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Domain createDomain() {
    DomainImpl domain = new DomainImpl();
    return domain;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Level createLevel() {
    LevelImpl level = new LevelImpl();
    return level;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DeepModel createDeepModel() {
    DeepModelImpl deepModel = new DeepModelImpl();
    return deepModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Inheritance createInheritance() {
    InheritanceImpl inheritance = new InheritanceImpl();
    return inheritance;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Supertype createSupertype() {
    SupertypeImpl supertype = new SupertypeImpl();
    return supertype;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Subtype createSubtype() {
    SubtypeImpl subtype = new SubtypeImpl();
    return subtype;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Classification createClassification() {
    ClassificationImpl classification = new ClassificationImpl();
    return classification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Entity createEntity() {
    EntityImpl entity = new EntityImpl();
    return entity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Connection createConnection() {
    ConnectionImpl connection = new ConnectionImpl();
    return connection;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConnectionEnd createConnectionEnd() {
    ConnectionEndImpl connectionEnd = new ConnectionEndImpl();
    return connectionEnd;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LMLVisualizer createLMLVisualizer() {
    LMLVisualizerImpl lmlVisualizer = new LMLVisualizerImpl();
    return lmlVisualizer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Attribute createAttribute() {
    AttributeImpl attribute = new AttributeImpl();
    return attribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Method createMethod() {
    MethodImpl method = new MethodImpl();
    return method;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Enumeration createEnumeration() {
    EnumerationImpl enumeration = new EnumerationImpl();
    return enumeration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClabjectParameter createClabjectParameter() {
    ClabjectParameterImpl clabjectParameter = new ClabjectParameterImpl();
    return clabjectParameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrimitiveParameter createPrimitiveParameter() {
    PrimitiveParameterImpl primitiveParameter = new PrimitiveParameterImpl();
    return primitiveParameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Multiplicity createMultiplicity() {
    MultiplicityImpl multiplicity = new MultiplicityImpl();
    return multiplicity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PLM.Package createPackage() {
    PackageImpl package_ = new PackageImpl();
    return package_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConnectionEndKind createConnectionEndKindFromString(EDataType eDataType, String initialValue) {
    ConnectionEndKind result = ConnectionEndKind.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertConnectionEndKindToString(EDataType eDataType, Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassificationKind createClassificationKindFromString(EDataType eDataType, String initialValue) {
    ClassificationKind result = ClassificationKind.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertClassificationKindToString(EDataType eDataType, Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComplianceKind createComplianceKindFromString(EDataType eDataType, String initialValue) {
    ComplianceKind result = ComplianceKind.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertComplianceKindToString(EDataType eDataType, Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PLMPackage getPLMPackage() {
    return (PLMPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static PLMPackage getPackage() {
    return PLMPackage.eINSTANCE;
  }

} //PLMFactoryImpl

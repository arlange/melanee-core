/**
 */
package PLM.util;

import PLM.AbstractBehavior;
import PLM.AbstractConstraint;
import PLM.AbstractDSLVisualizer;
import PLM.Attribute;
import PLM.Clabject;
import PLM.ClabjectParameter;
import PLM.Classification;
import PLM.Connection;
import PLM.ConnectionEnd;
import PLM.Correlation;
import PLM.DeepModel;
import PLM.Domain;
import PLM.Element;
import PLM.Entity;
import PLM.Enumeration;
import PLM.Feature;
import PLM.Inheritance;
import PLM.LMLVisualizer;
import PLM.Level;
import PLM.Method;
import PLM.Multiplicity;
import PLM.OwnedElement;
import PLM.PLMPackage;
import PLM.Parameter;
import PLM.PrimitiveParameter;
import PLM.Property;
import PLM.Subtype;
import PLM.Supertype;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see PLM.PLMPackage
 * @generated
 */
public class PLMAdapterFactory extends AdapterFactoryImpl {
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static PLMPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PLMAdapterFactory() {
    if (modelPackage == null) {
      modelPackage = PLMPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object) {
    if (object == modelPackage) {
      return true;
    }
    if (object instanceof EObject) {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PLMSwitch<Adapter> modelSwitch =
    new PLMSwitch<Adapter>() {
      @Override
      public Adapter caseDomain(Domain object) {
        return createDomainAdapter();
      }
      @Override
      public Adapter caseElement(Element object) {
        return createElementAdapter();
      }
      @Override
      public Adapter caseLevel(Level object) {
        return createLevelAdapter();
      }
      @Override
      public Adapter caseDeepModel(DeepModel object) {
        return createDeepModelAdapter();
      }
      @Override
      public Adapter caseOwnedElement(OwnedElement object) {
        return createOwnedElementAdapter();
      }
      @Override
      public Adapter caseCorrelation(Correlation object) {
        return createCorrelationAdapter();
      }
      @Override
      public Adapter caseInheritance(Inheritance object) {
        return createInheritanceAdapter();
      }
      @Override
      public Adapter caseSupertype(Supertype object) {
        return createSupertypeAdapter();
      }
      @Override
      public Adapter caseSubtype(Subtype object) {
        return createSubtypeAdapter();
      }
      @Override
      public Adapter caseClassification(Classification object) {
        return createClassificationAdapter();
      }
      @Override
      public Adapter caseClabject(Clabject object) {
        return createClabjectAdapter();
      }
      @Override
      public Adapter caseFeature(Feature object) {
        return createFeatureAdapter();
      }
      @Override
      public Adapter caseEntity(Entity object) {
        return createEntityAdapter();
      }
      @Override
      public Adapter caseConnection(Connection object) {
        return createConnectionAdapter();
      }
      @Override
      public Adapter caseConnectionEnd(ConnectionEnd object) {
        return createConnectionEndAdapter();
      }
      @Override
      public Adapter caseLMLVisualizer(LMLVisualizer object) {
        return createLMLVisualizerAdapter();
      }
      @Override
      public Adapter caseProperty(Property object) {
        return createPropertyAdapter();
      }
      @Override
      public Adapter caseAttribute(Attribute object) {
        return createAttributeAdapter();
      }
      @Override
      public Adapter caseMethod(Method object) {
        return createMethodAdapter();
      }
      @Override
      public Adapter caseEnumeration(Enumeration object) {
        return createEnumerationAdapter();
      }
      @Override
      public Adapter caseParameter(Parameter object) {
        return createParameterAdapter();
      }
      @Override
      public Adapter caseClabjectParameter(ClabjectParameter object) {
        return createClabjectParameterAdapter();
      }
      @Override
      public Adapter casePrimitiveParameter(PrimitiveParameter object) {
        return createPrimitiveParameterAdapter();
      }
      @Override
      public Adapter caseMultiplicity(Multiplicity object) {
        return createMultiplicityAdapter();
      }
      @Override
      public Adapter casePackage(PLM.Package object) {
        return createPackageAdapter();
      }
      @Override
      public Adapter caseAbstractDSLVisualizer(AbstractDSLVisualizer object) {
        return createAbstractDSLVisualizerAdapter();
      }
      @Override
      public Adapter caseAbstractBehavior(AbstractBehavior object) {
        return createAbstractBehaviorAdapter();
      }
      @Override
      public Adapter caseAbstractConstraint(AbstractConstraint object) {
        return createAbstractConstraintAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object) {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target) {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link PLM.Domain <em>Domain</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see PLM.Domain
   * @generated
   */
  public Adapter createDomainAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link PLM.Element <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see PLM.Element
   * @generated
   */
  public Adapter createElementAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link PLM.Level <em>Level</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see PLM.Level
   * @generated
   */
  public Adapter createLevelAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link PLM.DeepModel <em>Deep Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see PLM.DeepModel
   * @generated
   */
  public Adapter createDeepModelAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link PLM.OwnedElement <em>Owned Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see PLM.OwnedElement
   * @generated
   */
  public Adapter createOwnedElementAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link PLM.Correlation <em>Correlation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see PLM.Correlation
   * @generated
   */
  public Adapter createCorrelationAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link PLM.Inheritance <em>Inheritance</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see PLM.Inheritance
   * @generated
   */
  public Adapter createInheritanceAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link PLM.Supertype <em>Supertype</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see PLM.Supertype
   * @generated
   */
  public Adapter createSupertypeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link PLM.Subtype <em>Subtype</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see PLM.Subtype
   * @generated
   */
  public Adapter createSubtypeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link PLM.Classification <em>Classification</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see PLM.Classification
   * @generated
   */
  public Adapter createClassificationAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link PLM.Clabject <em>Clabject</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see PLM.Clabject
   * @generated
   */
  public Adapter createClabjectAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link PLM.Feature <em>Feature</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see PLM.Feature
   * @generated
   */
  public Adapter createFeatureAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link PLM.Entity <em>Entity</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see PLM.Entity
   * @generated
   */
  public Adapter createEntityAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link PLM.Connection <em>Connection</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see PLM.Connection
   * @generated
   */
  public Adapter createConnectionAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link PLM.ConnectionEnd <em>Connection End</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see PLM.ConnectionEnd
   * @generated
   */
  public Adapter createConnectionEndAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link PLM.LMLVisualizer <em>LML Visualizer</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see PLM.LMLVisualizer
   * @generated
   */
  public Adapter createLMLVisualizerAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link PLM.Property <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see PLM.Property
   * @generated
   */
  public Adapter createPropertyAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link PLM.Attribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see PLM.Attribute
   * @generated
   */
  public Adapter createAttributeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link PLM.Method <em>Method</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see PLM.Method
   * @generated
   */
  public Adapter createMethodAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link PLM.Enumeration <em>Enumeration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see PLM.Enumeration
   * @generated
   */
  public Adapter createEnumerationAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link PLM.Parameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see PLM.Parameter
   * @generated
   */
  public Adapter createParameterAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link PLM.ClabjectParameter <em>Clabject Parameter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see PLM.ClabjectParameter
   * @generated
   */
  public Adapter createClabjectParameterAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link PLM.PrimitiveParameter <em>Primitive Parameter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see PLM.PrimitiveParameter
   * @generated
   */
  public Adapter createPrimitiveParameterAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link PLM.Multiplicity <em>Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see PLM.Multiplicity
   * @generated
   */
  public Adapter createMultiplicityAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link PLM.Package <em>Package</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see PLM.Package
   * @generated
   */
  public Adapter createPackageAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link PLM.AbstractDSLVisualizer <em>Abstract DSL Visualizer</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see PLM.AbstractDSLVisualizer
   * @generated
   */
  public Adapter createAbstractDSLVisualizerAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link PLM.AbstractBehavior <em>Abstract Behavior</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see PLM.AbstractBehavior
   * @generated
   */
  public Adapter createAbstractBehaviorAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link PLM.AbstractConstraint <em>Abstract Constraint</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see PLM.AbstractConstraint
   * @generated
   */
  public Adapter createAbstractConstraintAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter() {
    return null;
  }

} //PLMAdapterFactory

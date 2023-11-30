/**
 */
package PLM.tests;

import PLM.Multiplicity;
import PLM.PLMFactory;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Multiplicity</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class MultiplicityTest extends TestCase {

  /**
   * The fixture for this Multiplicity test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Multiplicity fixture = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args) {
    TestRunner.run(MultiplicityTest.class);
  }

  /**
   * Constructs a new Multiplicity test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiplicityTest(String name) {
    super(name);
  }

  /**
   * Sets the fixture for this Multiplicity test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void setFixture(Multiplicity fixture) {
    this.fixture = fixture;
  }

  /**
   * Returns the fixture for this Multiplicity test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Multiplicity getFixture() {
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
    setFixture(PLMFactory.eINSTANCE.createMultiplicity());
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

} //MultiplicityTest

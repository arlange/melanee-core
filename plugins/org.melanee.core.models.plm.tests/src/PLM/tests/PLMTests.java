/**
 */
package PLM.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>PLM</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class PLMTests extends TestSuite {

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args) {
    TestRunner.run(suite());
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Test suite() {
    TestSuite suite = new PLMTests("PLM Tests");
    suite.addTestSuite(LevelTest.class);
    suite.addTestSuite(DeepModelTest.class);
    suite.addTestSuite(InheritanceTest.class);
    suite.addTestSuite(ClassificationTest.class);
    suite.addTestSuite(EntityTest.class);
    suite.addTestSuite(ConnectionTest.class);
    suite.addTestSuite(ConnectionEndTest.class);
    suite.addTestSuite(LMLVisualizerTest.class);
    suite.addTestSuite(AttributeTest.class);
    suite.addTestSuite(MethodTest.class);
    suite.addTestSuite(ClabjectParameterTest.class);
    suite.addTestSuite(PrimitiveParameterTest.class);
    suite.addTestSuite(PackageTest.class);
    return suite;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PLMTests(String name) {
    super(name);
  }

} //PLMTests

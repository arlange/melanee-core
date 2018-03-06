package org.melanee.core.tests.designation;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ClassificationTests.class, ComplexQueriesTests.class, HeritageTests.class,
    LocationTests.class, NestingTests.class })
public class DesignationTestSuite {

}

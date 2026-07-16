package spring_testing.integration;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import spring_testing.service.CalculatorServiceTest;
import spring_testing.service.CalculatorServiceTest2;

@Suite
@SelectClasses({
        CalculatorServiceTest.class,
        CalculatorServiceTest2.class
})
public class AllTests {

}
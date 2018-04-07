package webshop;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//This class is the main testing class which list all tests in the suiteclasses

//JUnit Suite Test 
@RunWith(Suite.class)

// Add all testcases/classes
@Suite.SuiteClasses({ 
		ProductTest.class,KlantTest.class//, MyUnitTest2.class 
		})

public class JunitTestSuite {
}
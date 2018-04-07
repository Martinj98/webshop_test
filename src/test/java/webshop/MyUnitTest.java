package webshop;

import junit.framework.*;
import org.junit.*;
import org.junit.Test;
//import static org.hamcrest.CoreMatchers.equalTo;
//
import webshop.domain.DomainController;

// FIXME this test is running in jenkins under the name of Junit demo
// It doesnt have a scheduled built into it though
//
//TODO Use this for testing ADMINPRODUCTRESOURCE

public class MyUnitTest extends TestCase {
	DomainController con = new DomainController(); 
	
	@Before
	protected void setUp() {
//Sets up the fixture, for example, open a network connection.	
	}
	@After
	protected void tearDown() {
//Tears down the fixture, for example, close a network connection.
	}

	@Test
	public void testfail() {
		String result = ("onetwo");
		System.out.print(con.getKlantByID(1));
		
		assertEquals("onetwo", result);
	
	}

	@Test
	public void testsucces() {
		String result = ("onetwo");
		assertEquals("onetwo", result);
	}

}

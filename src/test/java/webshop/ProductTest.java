package webshop;

import junit.framework.*;
import org.junit.*;
import org.junit.Test;

import webshop.domain.Product;
//import static org.hamcrest.CoreMatchers.equalTo;
//
import webshop.domain.DomainController;

// FIXME this test is running in jenkins under the name of Junit demo
// It doesnt have a scheduled built into it though
//
//TODO Use this for testing ADMINPRODUCTRESOURCE

public class ProductTest extends TestCase {
	//DomainController con = new DomainController(); 
	Product p = new Product("", null, 0, 0, "", "");
	
	@Test
	public void testId() {
		p.setId(11);
		int result= p.getId();
		assertEquals("auto", result,121);
	}

	@Test
	public void testNaam() {
		p.setNaam("auto");
		String result= p.getNaam();
		assertEquals("auto", result);
	}

//	@Test
//	public void testnaam() {
//		p.setNaam("auto");
//		String result= p.getNaam();
//		assertEquals("auto", result);
//	}
//	
//
//	@Test
//	public void testnaam() {
//		p.setNaam("auto");
//		String result= p.getNaam();
//		assertEquals("auto", result);
//	}
//	
//
//	@Test
//	public void testnaam() {
//		p.setNaam("auto");
//		String result= p.getNaam();
//		assertEquals("auto", result);
//	}
	
}

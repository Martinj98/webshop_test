package webshop;

import junit.framework.*;
import org.junit.Test;

import webshop.domain.Product;

public class ProductTest extends TestCase {
	Product p = new Product("", null, 0, 0, "", "");
	
	@Test
	public void testId() {
		p.setId(11);
		int result= p.getId();
		assertEquals("id",11,result);
	}

	@Test
	public void testNaam() {
		p.setNaam("auto");
		String result= p.getNaam();
		assertEquals("naam","auto", result);
	}
	@Test
	public void testPrijs() {
		p.setPrijs(100000);
		double result= p.getPrijs();
		assertEquals("fabrikant",100000.00, result);
	}
	
	@Test
	public void testomschrijving() {
		p.setOmschrijving("een dure auto");
		String result= p.getOmschrijving();
		assertEquals("omschrijving","een dure auto", result);
	}
	@Test
	public void testFabrikant() {
		p.setFabrikant("Volkswagen Group");
		String result= p.getFabrikant();
		assertEquals("fabrikant","Volkswagen Group", result);
	}
}

package webshop;

import junit.framework.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import webshop.domain.Account;
import webshop.domain.Adres;
import webshop.domain.Klant;

public class KlantTest extends TestCase {
	Klant k = new Klant(0, "", null, "", "", 0, null, null, null);
	
	@Test
	public void testId() {
		k.setId(12);
		int result= k.getId();
		assertEquals("id",12,result);
	}

	@Test
	public void testNaam() {
		k.setNaam("Jantje");
		String result= k.getNaam();
		assertEquals("naam","Jantje", result);
	}
	@Test
	public void testGeboortedatum() throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		String sDate1="31-12-1998";  
		Date date1=format.parse(sDate1);
		
		k.setGeboortedatum(date1);
		Date result= k.getGeboortedatum();
		assertEquals("geboortedatum",date1, result);
	}
	
	@Test
	public void testaccountsadres() {
		Adres Adresklant= new Adres(1, "straat1", "70c");
		Adres factuuradres= new Adres(2, "straat2", "72b");
		
		Account a= new Account(null, factuuradres, 3, false, "ww123");
		
		k.setAccount(a);
		
		String result= k.getAccount().getFactuurAdres().getStraat();
		assertEquals("straatNaamFactuur","straat2", result);
	}
	
	@Test
	public void testKlantAdresNummer() {
		Adres Adresklant= new Adres(3, "straat3", "74a");
		k.setWoonAdres(Adresklant);
		
		
		String result= k.getWoonAdres().getStraatnummer();
		assertEquals("straatnummerKlant","74a", result);
	}
}

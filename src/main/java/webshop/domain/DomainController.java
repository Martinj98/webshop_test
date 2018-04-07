package webshop.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DomainController {
	ProductDAO ProductDAO = new ProductDAO();
	KlantDAO KlantDAO = new KlantDAO();
	SaleDAO SaleDAO = new SaleDAO();
	BestellingDAO BestDAO=new BestellingDAO();

	public ArrayList<Klant> getAllKlanten() {
		return KlantDAO.getAllKlanten();
	}

	public Klant getKlantByID(int i) {
		return KlantDAO.getKlantByID(i);
	}

	public ArrayList<Product> getAllProducts() {
		return ProductDAO.getAllProducts();
	}

	public Product getProductByID(int i) {
		return ProductDAO.getProductByID(i);
	}

	public ArrayList<Product> getProductenbyCategorie(int catid) {
		return ProductDAO.getProductenbyCategorie(catid);
	}

	public Categorie getCategoryByID(int i) {
		return ProductDAO.getCategoryByID(i);
	}

	public ArrayList<Categorie> getAllCategories() {
		return ProductDAO.getAllCategories();
	}

	public ArrayList<Product> getCartByKlantID(int klantid) {
		return ProductDAO.getCartByKlantID(klantid);
	}

	public ArrayList<Aanbieding> getAanbiedingByProductID(int productid) throws ParseException {
		return ProductDAO.getAanbiedingByProductID(productid);
	}

	public void addToCart(int klantid, int productid, int aantal) {
		ProductDAO.addToCart(klantid, productid, aantal);
	}

	public void deletefromCart(int klantid, int productid) {
		ProductDAO.deletefromCart(klantid, productid);
	}

	public ArrayList<Aanbieding> getAllSales() {
		return SaleDAO.getAllSales();
	}

	public Aanbieding getSaleByProductID(int pid) {
		return SaleDAO.getSaleByProductID(pid);
	}
	public Klant getKlantByLogin(String email, String password){
		return KlantDAO.getKlantByLogin(email, password);
}
	public int getAmount(int klantid, int prodid){
		return ProductDAO.getAmount(klantid, prodid);
	}
	public Bestelling getBestellingByID(int ordid){
		return BestDAO.getBestellingByID(ordid);
	}
	public ArrayList<Bestelling> getAllBestellingen(){
		return BestDAO.getAllBestellingen();
	}
	public void addProduct(int id, String naam,double prijs,String omschrijving,String fabrikant){
		ProductDAO.addProduct(id, naam, prijs, omschrijving, fabrikant);
	}
	public void editProduct(int id, String naam,double prijs,String omschrijving,String fabrikant){
		 ProductDAO.editProduct(id, naam, prijs, omschrijving, fabrikant);
	}
	public void deleteProduct(int id){
		 ProductDAO.deleteProduct(id);
	}
}
package webshop.domain;

public class Bestellingsregel {
private int id;
private int Aantal;
private double Prijs;
private Product product;
public Bestellingsregel(int id, int aantal, double prijs, Product product) {
	super();
	this.id = id;
	Aantal = aantal;
	Prijs = prijs;
	this.product = product;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getAantal() {
	return Aantal;
}
public void setAantal(int aantal) {
	Aantal = aantal;
}
public double getPrijs() {
	return Prijs;
}
public void setPrijs(double prijs) {
	Prijs = prijs;
}
public Product getProduct() {
	return product;
}
public void setProduct(Product product) {
	this.product = product;
}


}

package webshop.domain;

import java.awt.image.BufferedImage;

public class Product {
private String Naam;
private BufferedImage Afbeelding;
private double Prijs;
private int Id;
private String Omschrijving;
private String Fabrikant;
public Product(String naam, BufferedImage afbeelding, double prijs, int id, String omschrijving, String fabrikant) {
	Naam = naam;
	Afbeelding = afbeelding;
	Prijs = prijs;
	Id = id;
	Omschrijving = omschrijving;
	Fabrikant = fabrikant;
}
public String getNaam() {
	return Naam;
}
public void setNaam(String naam) {
	Naam = naam;
}
public BufferedImage getAfbeelding() {
	return Afbeelding;
}
public void setAfbeelding(BufferedImage afbeelding) {
	Afbeelding = afbeelding;
}
public double getPrijs() {
	return Prijs;
}
public void setPrijs(double prijs) {
	Prijs = prijs;
}
public int getId() {
	return Id;
}
public void setId(int id) {
	Id = id;
}
public String getOmschrijving() {
	return Omschrijving;
}
public void setOmschrijving(String omschrijving) {
	Omschrijving = omschrijving;
}
public String getFabrikant() {
	return Fabrikant;
}
public void setFabrikant(String fabrikant) {
	Fabrikant = fabrikant;
}


}

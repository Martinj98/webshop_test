package webshop.domain;

import java.util.Date;

public class Aanbieding {
private int Id;
private double Prijs;
private String Reclame;
private Date vanDatum;
private Date totDatum;
private int ProductID;
public Aanbieding(int id, double prijs, String reclame, Date vanDatum, Date totDatum, int productID) {
	super();
	Id = id;
	Prijs = prijs;
	Reclame = reclame;
	this.vanDatum = vanDatum;
	this.totDatum = totDatum;
	ProductID = productID;
}
public int getId() {
	return Id;
}
public void setId(int id) {
	Id = id;
}
public double getPrijs() {
	return Prijs;
}
public void setPrijs(double prijs) {
	Prijs = prijs;
}
public String getReclame() {
	return Reclame;
}
public void setReclame(String reclame) {
	Reclame = reclame;
}
public Date getVanDatum() {
	return vanDatum;
}
public void setVanDatum(Date vanDatum) {
	this.vanDatum = vanDatum;
}
public Date getTotDatum() {
	return totDatum;
}
public void setTotDatum(Date totDatum) {
	this.totDatum = totDatum;
}
public int getProductID() {
	return ProductID;
}
public void setProductID(int productID) {
	ProductID = productID;
}


}

package webshop.domain;

import java.util.Date;

public class Account {
private Date OpenDatum;
private Adres factuurAdres;
private int id;
private boolean isActief;
private String Wachtwoord;
public Account(Date openDatum, Adres factuurAdres, int id, boolean isActief, String Wachtwoord) {
	super();
	OpenDatum = openDatum;
	this.factuurAdres = factuurAdres;
	this.id = id;
	this.isActief = isActief;
	this.Wachtwoord=Wachtwoord;
}
public Date getOpenDatum() {
	return OpenDatum;
}
public void setOpenDatum(Date openDatum) {
	OpenDatum = openDatum;
}
public Adres getFactuurAdres() {
	return factuurAdres;
}
public void setFactuurAdres(Adres factuurAdres) {
	this.factuurAdres = factuurAdres;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public boolean isActief() {
	return isActief;
}
public void setActief(boolean isActief) {
	this.isActief = isActief;
}
public String getWachtwoord(){
	return this.Wachtwoord;
}
public void setWachtwoord(String Wachtwoord){
	this.Wachtwoord=Wachtwoord;
}


}

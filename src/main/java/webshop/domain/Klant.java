package webshop.domain;

import java.awt.image.BufferedImage;
import java.util.Date;

public class Klant {
private int Id;
private String Naam;
private Date Geboortedatum;
private String Geslacht;
private String Email;
private int Telefoonnummer;
private BufferedImage Afbeelding;
private Adres WoonAdres;
private Account Account;

public Klant(int id, String naam, Date geboortedatum, String geslacht, String email, int telefoonnummer,
		BufferedImage afbeelding, Adres woonAdres, Account account) {
	super();
	Id = id;
	Naam = naam;
	Geboortedatum = geboortedatum;
	Geslacht = geslacht;
	Email = email;
	Telefoonnummer = telefoonnummer;
	Afbeelding = afbeelding;
	WoonAdres = woonAdres;
	Account = account;
}

public int getId() {
	return Id;
}

public void setId(int id) {
	Id = id;
}

public String getNaam() {
	return Naam;
}

public void setNaam(String naam) {
	Naam = naam;
}

public Date getGeboortedatum() {
	return Geboortedatum;
}

public void setGeboortedatum(Date geboortedatum) {
	Geboortedatum = geboortedatum;
}

public String getGeslacht() {
	return Geslacht;
}

public void setGeslacht(String geslacht) {
	Geslacht = geslacht;
}

public String getEmail() {
	return Email;
}

public void setEmail(String email) {
	Email = email;
}

public int getTelefoonnummer() {
	return Telefoonnummer;
}

public void setTelefoonnummer(int telefoonnummer) {
	Telefoonnummer = telefoonnummer;
}

public BufferedImage getAfbeelding() {
	return Afbeelding;
}

public void setAfbeelding(BufferedImage afbeelding) {
	Afbeelding = afbeelding;
}

public Adres getWoonAdres() {
	return WoonAdres;
}

public void setWoonAdres(Adres woonAdres) {
	WoonAdres = woonAdres;
}

public Account getAccount() {
	return Account;
}

public void setAccount(Account accountlijst) {
	Account = accountlijst;
}
}



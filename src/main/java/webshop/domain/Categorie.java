package webshop.domain;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Categorie {
	private int Id;
	private String Naam;
	private BufferedImage Afbeelding;
	private String Omschrijving;
	private ArrayList<Product> Productenlijst;
	
	public Categorie(int id, String naam, BufferedImage afbeelding, String omschrijving, ArrayList<Product>productenlijst) {
		super();
		Id = id;
		Naam = naam;
		Afbeelding = afbeelding;
		Omschrijving = omschrijving;
		Productenlijst=productenlijst;
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

	public BufferedImage getAfbeelding() {
		return Afbeelding;
	}

	public void setAfbeelding(BufferedImage afbeelding) {
		Afbeelding = afbeelding;
	}

	public String getOmschrijving() {
		return Omschrijving;
	}

	public void setOmschrijving(String omschrijving) {
		Omschrijving = omschrijving;
	}

	public ArrayList<Product> getProductenlijst() {
		return Productenlijst;
	}

	public void setProductenlijst(ArrayList<Product> productenlijst) {
		Productenlijst = productenlijst;
	}
	
	
}

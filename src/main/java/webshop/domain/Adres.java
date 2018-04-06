package webshop.domain;

public class Adres {
private int id;
private String Straat;
private String Straatnummer;
public Adres(int id, String straat, String straatnummer) {
	super();
	this.id = id;
	Straat = straat;
	Straatnummer = straatnummer;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getStraat() {
	return Straat;
}
public void setStraat(String straat) {
	Straat = straat;
}
public String getStraatnummer() {
	return Straatnummer;
}
public void setStraatnummer(String straatnummer) {
	Straatnummer = straatnummer;
}


}


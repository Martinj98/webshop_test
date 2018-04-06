package webshop.domain;

import java.util.ArrayList;

public class Bestelling {
private int id;
private int klantid;
private ArrayList<Bestellingsregel>regellijst;
private Adres AfleverAdres;
public Bestelling(int id, int klantid, ArrayList<Bestellingsregel> regellijst, Adres afleverAdres) {
	this.id=id;
	this.klantid = klantid;
	this.regellijst = regellijst;
	AfleverAdres = afleverAdres;
}
public int getId(){
	return id;
}
public int getAccount() {
	return klantid;
}
public ArrayList<Bestellingsregel> getRegellijst() {
	return regellijst;
}
public void setRegellijst(ArrayList<Bestellingsregel> regellijst) {
	this.regellijst = regellijst;
}
public Adres getAfleverAdres() {
	return AfleverAdres;
}
public void setAfleverAdres(Adres afleverAdres) {
	AfleverAdres = afleverAdres;
}


}

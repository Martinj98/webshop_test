package webshop;

import webshop.domain.DomainController;

public class ControllerMain {

	public static void main(String[] args){
		System.out.println("TESTCONTROLLERCLASS");
		DomainController c= new DomainController();
		System.out.println(c.getAllCategories());
	}
}

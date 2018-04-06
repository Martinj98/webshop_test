package webshop.webservices;

import java.util.ArrayList;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import webshop.domain.Categorie;
import webshop.domain.DomainController;
import webshop.domain.Product;


@Path("/category")
public class CategorieResource {
	DomainController Controller=new DomainController();

	@GET
	@Produces("application/json")
	public String getAllCategories() {
		JsonArrayBuilder jab = Json.createArrayBuilder();
		ArrayList<Integer>urllist=new ArrayList<Integer>();
		for (Categorie c : Controller.getAllCategories()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("ID", c.getId());
			job.add("Naam", c.getNaam());
			job.add("Omschrijving", c.getOmschrijving());
			for (Product p:c.getProductenlijst()){
				urllist.add(p.getId());
			}
			job.add("Producten",urllist.toString());
			urllist.clear();

			jab.add(job);
		}

		JsonArray array = jab.build();

		return (array.toString());
	}

	@Path("{id}")
	@GET
	@Produces("application/json")
	public String getCategorieByID(@PathParam("id") int id) {
		ArrayList<Integer>urllist=new ArrayList<Integer>();
		Categorie c = Controller.getCategoryByID(id);
		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("ID", c.getId());
		job.add("Naam", c.getNaam());
		job.add("Omschrijving", c.getOmschrijving());
		for (Product p:c.getProductenlijst()){
			urllist.add(p.getId());
		}
		job.add("Producten",urllist.toString());

		return (job.build().toString());
	}
	@Path("{id}/products")
	@GET
	@Produces("application/json")
	public String getProductsByCategorieID(@PathParam("id") int catid) {
		JsonArrayBuilder jab = Json.createArrayBuilder();

		for (Product p : Controller.getProductenbyCategorie(catid)) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("ID", p.getId());
			job.add("Naam", p.getNaam());
			job.add("Omschrijving", p.getOmschrijving());
			job.add("Prijs", p.getPrijs());
			job.add("Fabrikant", p.getFabrikant());

			jab.add(job);
		}
			JsonArray array = jab.build();

			return (array.toString());

}}
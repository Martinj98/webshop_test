package webshop.webservices;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import webshop.domain.Aanbieding;
import webshop.domain.DomainController;
import webshop.domain.Klant;
import webshop.domain.KlantDAO;
import webshop.domain.Product;

@Path("/product")
public class ProductResource {
	DomainController Controller=new DomainController();

	@GET
	@Produces("application/json")
	public String CountryList() {
		JsonArrayBuilder jab = Json.createArrayBuilder();

		for (Product p : Controller.getAllProducts()) {
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
	}

	@Path("{id}")
	@GET
	@Produces("application/json")
	public String getProductByID(@PathParam("id") int id) {

		Product p = Controller.getProductByID(id);
		if (p!=null){
		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("ID", p.getId());
		job.add("Naam", p.getNaam());
		job.add("Omschrijving", p.getOmschrijving());
		job.add("Prijs", p.getPrijs());
		job.add("Fabrikant", p.getFabrikant());

		return (job.build().toString());
	}else{
		throw new WebApplicationException(Response.Status.NOT_FOUND);
	}
		}

	@Path("getid/{id}")
	@GET
	@Produces("application/json")
	public String getProductIDbyName(@PathParam("id") String name) {
		Product target = null;
		name = name.replace("%20", " ");
		name = name.toLowerCase();
		for (Product p : Controller.getAllProducts()) {
			if (p.getNaam().toLowerCase().equals(name)) {
				target = p;
			}
		}
		if (target!=null){
		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("ID", target.getId());

		return (job.build().toString());
		}
		else{
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
	}



	@Path("basket/{id}")
	@GET
	@Produces("application/json")
	public String getCart(@PathParam("id") int klantid) {
		JsonArrayBuilder jab = Json.createArrayBuilder();
		try{
		for (Product p : Controller.getCartByKlantID(klantid)) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("ID", p.getId());
			job.add("Naam", p.getNaam());
			job.add("Omschrijving", p.getOmschrijving());
			job.add("Prijs", p.getPrijs());
			job.add("Fabrikant", p.getFabrikant());
			job.add("Aantal", Controller.getAmount(klantid,p.getId()));
			jab.add(job);
		}

		JsonArray array = jab.build();

		return (array.toString());}
		catch(Exception e){
				throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
	}

	@Path("basket/add/{klantid}/{productid}/{aantal}")
	@POST
	public Response addToCart(@PathParam("klantid") int klantid, @PathParam("productid") int productid,
			@PathParam("aantal") int aantal) {
		Klant found = Controller.getKlantByID(klantid);
		Product found2 = Controller.getProductByID(productid);
		if (found == null || found2 == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		} else {
			Controller.addToCart(klantid, productid, aantal);
			return Response.ok().build();
		}
	}
	
	@Path("basket/delete/{klantid}/{productid}")
	@DELETE
	public Response removeFromWishlist(@PathParam("klantid") int klantid, @PathParam("productid") int ProdId) {
		Klant found = Controller.getKlantByID(klantid);
		Product found2 = Controller.getProductByID(ProdId);
		if (found == null || found2 == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		} else {
			Controller.deletefromCart(found.getId(), found2.getId());
			return Response.ok().build();
		}
	}

	@Path("sales")
	@GET
	@Produces("application/json")
	public String getSales() {
		JsonArrayBuilder jab = Json.createArrayBuilder();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date today= new Date();
		for (Product p : Controller.getAllProducts()) {
			for (Aanbieding a:Controller.getAllSales()){
				if (p.getId()==a.getProductID()){
					if(today.after(a.getVanDatum()) && today.before(a.getTotDatum())){
			
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("ID", p.getId());
			job.add("Naam", p.getNaam());
			job.add("Omschrijving", p.getOmschrijving());
			job.add("Prijs", p.getPrijs());
			job.add("Fabrikant", p.getFabrikant());
			job.add("NieuwePrijs", a.getPrijs());
			job.add("Tekst", a.getReclame());
			job.add("Van", format.format(a.getVanDatum()));
			job.add("Tot", format.format(a.getTotDatum()));

			jab.add(job);
		}}}}

		JsonArray array = jab.build();

		return (array.toString());
	}
	@Path("sales/{id}")
	@GET
	@Produces("application/json")
	public String getSalesByProductID(@PathParam("id") int productid) {
		System.out.println(productid);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date today= new Date();
		Product p=Controller.getProductByID(productid);
		Aanbieding a=Controller.getSaleByProductID(productid);
		if (p!=null && a!=null){
		if(today.after(a.getVanDatum()) && today.before(a.getTotDatum())){
			
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("ID", p.getId());
			job.add("Naam", p.getNaam());
			job.add("Omschrijving", p.getOmschrijving());
			job.add("Prijs", p.getPrijs());
			job.add("Fabrikant", p.getFabrikant());
			job.add("NieuwePrijs", a.getPrijs());
			job.add("Tekst", a.getReclame());
			job.add("Van", format.format(a.getVanDatum()));
			job.add("Tot", format.format(a.getTotDatum()));

		return (job.build().toString());
	}}
		return null;

}}

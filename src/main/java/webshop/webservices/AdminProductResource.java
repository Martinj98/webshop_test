package webshop.webservices;

import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import webshop.domain.DomainController;
import webshop.domain.Product;
@Path("/admin/product")

public class AdminProductResource {
	DomainController Controller=new DomainController();
	
	@Path("/{id}/{naam}/{prijs}/{omschrijving}/{fabrikant}")
	@POST
	public Response addProduct(@PathParam("id") int id, @PathParam("naam") String naam,
			@PathParam("prijs") double prijs,@PathParam("omschrijving") String omschrijving,
			@PathParam("fabrikant") String fabrikant) {
//		Product found = Controller.getProductByID(id);
//		if (found != null) {
//			return Response.status(Response.Status.NOT_FOUND).build();
//		} else {
			Controller.addProduct(id, naam, prijs, omschrijving, fabrikant);
			System.out.println(id+naam+prijs);
			return Response.ok().build();
		}
//	}
	
	@Path("/{id}/{naam}/{prijs}/{omschrijving}/{fabrikant}")
	@PUT
	public Response editProduct(@PathParam("id") int id, @PathParam("naam") String naam,
			@PathParam("prijs") double prijs,@PathParam("omschrijving") String omschrijving,
			@PathParam("fabrikant") String fabrikant) {
		Product found = Controller.getProductByID(id);
		if (found == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		} else {
			Controller.editProduct(id, naam, prijs, omschrijving, fabrikant);
			return Response.ok().build();
		}
	}
	@Path("/{id}")
	@DELETE
	public Response deleteProduct(@PathParam("id") int id) {
		Product found = Controller.getProductByID(id);
		if (found == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		} else {
			Controller.deleteProduct(id);
			return Response.ok().build();
		}
	}
	
}
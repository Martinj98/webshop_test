package webshop.webservices;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import webshop.domain.DomainController;
import webshop.domain.Klant;
 
@Path("Klant")
public class KlantResource {
	DomainController Controller=new DomainController();
	

	@GET
	@Produces("application/json")
	public String getAllKlanten() {
		JsonArrayBuilder jab = Json.createArrayBuilder();
		DateFormat format = new SimpleDateFormat("dd-mm-yyyy", Locale.ENGLISH);
		
		for (Klant c : Controller.getAllKlanten()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("id", c.getId());
			job.add("naam", c.getNaam());
			job.add("email", c.getGeslacht());
			job.add("tel", c.getTelefoonnummer());
			job.add("gebdatum", format.format(c.getGeboortedatum()));
			job.add("woonstraat", c.getWoonAdres().getStraat());
			job.add("woonnummer", c.getWoonAdres().getStraatnummer());
			job.add("wachtwoord", c.getAccount().getWachtwoord());
			job.add("factuurstraat", c.getAccount().getFactuurAdres().getStraat());
			job.add("factuurnummer", c.getAccount().getFactuurAdres().getStraatnummer());
			job.add("opendatum", format.format(c.getAccount().getOpenDatum()));
			
			jab.add(job);
		}

		JsonArray array = jab.build();

		return (array.toString());
	}
	@Path("{id}")
	@GET
	@Produces("application/json")
	public String getKlantByID(@PathParam("id") int id) {
		Klant k = Controller.getKlantByID(id);
		DateFormat format = new SimpleDateFormat("dd-mm-yyyy", Locale.ENGLISH);
		
		if (k!=null){
		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("id", k.getId());
		job.add("naam", k.getNaam());
		job.add("email", k.getGeslacht());
		job.add("tel", k.getTelefoonnummer());
		System.out.println(format.format(k.getGeboortedatum()));
		System.out.println(k.getAccount().getOpenDatum());
		job.add("gebdatum", format.format(k.getGeboortedatum()));
		job.add("woonstraat", k.getWoonAdres().getStraat());
		job.add("woonnummer", k.getWoonAdres().getStraatnummer());
		job.add("wachtwoord", k.getAccount().getWachtwoord());
		job.add("factuurstraat", k.getAccount().getFactuurAdres().getStraat());
		job.add("factuurnummer", k.getAccount().getFactuurAdres().getStraatnummer());
		job.add("opendatum", format.format(k.getAccount().getOpenDatum()));
		

		return (job.build().toString());
		}else{
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
	}
	@Path("/login/{email}/{password}")
	@GET
	@Produces("application/json")
	public String getKlantByLogin(@PathParam("email") String email, @PathParam("password") String password) {
		Klant k = Controller.getKlantByLogin(email, password);
		DateFormat format = new SimpleDateFormat("dd-mm-yyyy", Locale.ENGLISH);
		if (k!=null){
		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("id", k.getId());
		job.add("naam", k.getNaam());
		job.add("email", k.getGeslacht());
		job.add("tel", k.getTelefoonnummer());
		job.add("gebdatum", format.format(k.getGeboortedatum()));
		job.add("woonstraat", k.getWoonAdres().getStraat());
		job.add("woonnummer", k.getWoonAdres().getStraatnummer());
		job.add("wachtwoord", k.getAccount().getWachtwoord());
		job.add("factuurstraat", k.getAccount().getFactuurAdres().getStraat());
		job.add("factuurnummer", k.getAccount().getFactuurAdres().getStraatnummer());
		job.add("opendatum", format.format(k.getAccount().getOpenDatum()));
		

		return (job.build().toString());
	}
		return null;
}
}


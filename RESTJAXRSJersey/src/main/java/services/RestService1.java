package services;
 
import java.util.Date;
import restapplication.*;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
 
@Path("/restService1")
public class RestService1 {
 
	@GET
	@Path("/op1")
	public Response service1Op1(
			@QueryParam("firstName") String firstName, 
			@QueryParam("lastName") String lastName) {
		
 
		String output = "\nLive long and Propser"; 
 
		return Response.status(200).entity(output).build();
 
	}
 
}
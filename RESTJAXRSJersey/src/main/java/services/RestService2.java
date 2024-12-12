package services;

import java.util.Date;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
 
@Path("/restService2")
public class RestService2 {
	@GET
	@Path("/op1")
	public Response service2Op1(
			@QueryParam("firstName") String firstName, 
			@QueryParam("lastName") String lastName) {
		 
		String output = "\nStill Many Happy Returns"; 
 
		return Response.status(200).entity(output).build();
 
	}
 
}

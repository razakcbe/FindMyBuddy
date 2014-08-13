package com.findmybuddy.restws;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.findmybuddy.restws.service.MyLocationService;

/**
 * 
 * @author Razak
 *
 */
/*{
"number":"8123695220",
"latitude":"rrrrrr",
"longitude":"aaaaaaaa",
"lastDetectedLocation":"aaaaaa",
"lastDetectedTime":"rrsadaff"
}*/
@Component
@Path("findmybuddy")
public class RestFullResource
{

	@Autowired
	MyLocationService locationService;
	
	@Path("/mylocation")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveMyLocation(String location)
	{
		locationService.saveMyLocation(location);
		return Response.status(200).entity(location).build();
	}
	
	
	@Path("/mydetails")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveMyDetails(String myDetails)
	{
		locationService.saveMyDetails(myDetails);
		return Response.status(200).entity(myDetails).build();
	}
	
	

}
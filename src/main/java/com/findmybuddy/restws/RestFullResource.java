package com.findmybuddy.restws;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.findmybuddy.restws.service.MyLocationService;
import com.findmybuddy.restws.utils.FindMyBuddyConstants;

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
@Path(FindMyBuddyConstants.TARGETPATH_FINDMYBUDDY)
public class RestFullResource
{

	@Autowired
	MyLocationService locationService;

	private static final Logger logger = LoggerFactory.getLogger(RestFullResource.class);


	@POST
	@Path(FindMyBuddyConstants.PATH_UPDATE_MY_LOCATION)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveMyLocation(String location)
	{
		try {
			locationService.saveMyLocation(location);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Response.status(200).entity(location).build();
	}



	@POST
	@Path(FindMyBuddyConstants.PATH_CREATE_MY_DETAILS)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveMyDetails(String myDetails)
	{

		try {
			locationService.saveMyDetails(myDetails);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Response.status(200).entity(myDetails).build();
	}

	@GET
	@Path(FindMyBuddyConstants.PATH_GET_MY_DETAILS)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMylocation(@PathParam("mobileNo") String mobileNo)
	{
		String response = null;
		try {
			response = locationService.getMyLocation(mobileNo);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Response.status(200).entity(response).build();

	}
	
	@GET
	public Response getHealthCheck(){
		return Response.status(200).entity("OK").build();
	}
	

}
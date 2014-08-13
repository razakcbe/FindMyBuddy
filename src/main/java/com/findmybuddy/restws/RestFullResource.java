package com.findmybuddy.restws;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
	@Path(FindMyBuddyConstants.PATH_MY_LOCATION)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveMyLocation(String location) throws MyException
	{
		try {
			locationService.saveMyLocation(location);
		} catch (JsonParseException e) {
			throw new MyException(e.getMessage());
		} catch (JsonMappingException e) {
			throw new MyException(e.getMessage());
		} catch (IOException e) {
			throw new MyException(e.getMessage());
		} catch (Exception e) {
			throw new MyException(e.getMessage());
		}
		return Response.status(200).entity(location).build();
	}



	@POST
	@Path(FindMyBuddyConstants.PATH_MY_DETAILS)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveMyDetails(String myDetails) throws MyException
	{

		try {
			locationService.saveMyDetails(myDetails);
		} catch (JsonParseException e) {
			throw new MyException(e.getMessage());
		} catch (JsonMappingException e) {
			throw new MyException(e.getMessage());
		} catch (IOException e) {
			throw new MyException(e.getMessage());
		} catch (Exception e) {
			throw new MyException(e.getMessage());
		}
		return Response.status(200).entity(myDetails).build();
	}



}
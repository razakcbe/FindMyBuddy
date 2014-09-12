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
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.findmybuddy.restws.exception.MyBuddyException;
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

	//private static final Logger logger = LoggerFactory.getLogger(RestFullResource.class);


	@POST
	@Path(FindMyBuddyConstants.PATH_UPDATE_MY_LOCATION)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveMyLocation(String location)
	{
		try 
		{
			locationService.saveMyLocation(location);
		} 
		catch (JsonGenerationException e) 
		{
			throw new MyBuddyException("JsonGenerationException while storing my location");
		} catch (JsonMappingException e) 
		{
			throw new MyBuddyException("JsonMappingException while storing my location");
		} catch (IOException e) 
		{
			throw new MyBuddyException("IOException while storing my location");
		}
		return Response.status(200).entity(location).build();
	}



	@POST
	@Path(FindMyBuddyConstants.PATH_CREATE_MY_DETAILS)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveMyDetails(String myDetails)
	{

		try 
		{
			locationService.saveMyDetails(myDetails);
		} 
		catch (JsonGenerationException e) 
		{
			throw new MyBuddyException("JsonGenerationException storing  my location");
		} catch (JsonMappingException e)
		{
			throw new MyBuddyException("JsonMappingException storing getting my location");
		} catch (IOException e) 
		{
			throw new MyBuddyException("IOException while storing my location");
		}
		return Response.status(200).entity(myDetails).build();
	}

	@GET
	@Path(FindMyBuddyConstants.PATH_GET_MY_DETAILS)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMylocation(@PathParam("mobileNo") String mobileNo)
	{
		String response = null;
		try 
		{
			response = locationService.getMyLocation(mobileNo);
			if(response == null)
			{
				throw new MyBuddyException("No location has been found for the given number");
			}
		} 
		catch (JsonGenerationException e) 
		{
			throw new MyBuddyException("JsonGenerationException while getting Friend location");
		} catch (JsonMappingException e) 
		{
			throw new MyBuddyException("JsonMappingException while getting Friend location");
		} catch (IOException e) 
		{
			throw new MyBuddyException("IOException while getting Friend location");
		}
		return Response.status(200).entity(response).build();

	}

	@GET
	public Response getHealthCheck(){
		return Response.status(200).entity("OK").build();
	}


}
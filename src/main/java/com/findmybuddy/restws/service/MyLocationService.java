/**
 * 
 */
package com.findmybuddy.restws.service;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jettison.json.JSONException;


/**
 * @author Razak
 *
 */
public interface MyLocationService {

	public String saveMyLocation(String location) throws JsonParseException, JsonMappingException, IOException , JSONException;

	public void saveMyDetails(String myDetails) throws JsonParseException, JsonMappingException, IOException;
	
	public String getMyLocation(String mobNo) throws JsonGenerationException, JsonMappingException, IOException;
	
	public String getIpAddressGeoLoacation(String ipAddress)throws JSONException, IOException ;

}

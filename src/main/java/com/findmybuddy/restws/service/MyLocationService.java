/**
 * 
 */
package com.findmybuddy.restws.service;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;


/**
 * @author Razak
 *
 */
public interface MyLocationService {

	public String saveMyLocation(String location) throws JsonParseException, JsonMappingException, IOException;

	public void saveMyDetails(String myDetails) throws JsonParseException, JsonMappingException, IOException;
	
	public String getMyLocation(String mobNo) throws JsonGenerationException, JsonMappingException, IOException;

}

/**
 * 
 */
package com.findmybuddy.restws.service.impl;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;

import com.findmybuddy.restws.dao.MyLocationDao;
import com.findmybuddy.restws.domain.MyLocation;
import com.findmybuddy.restws.dto.MyDetailsDto;
import com.findmybuddy.restws.dto.MyLocationDto;
import com.findmybuddy.restws.googleclient.GoogleAddressClient;
import com.findmybuddy.restws.googleclient.IpAddressClient;
import com.findmybuddy.restws.helper.DataPopulationHelper;
import com.findmybuddy.restws.service.MyLocationService;

/**
 * @author Razak
 * 
 */

public class MyLocationServiceImpl implements MyLocationService{

	@Autowired
	MyLocationDao locationDaoImpl;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.findmybuddy.restws.service.MyLocationService#saveMyLocation(java.
	 * lang.String)
	 */
	@Override
	public String saveMyLocation(String location) throws JsonParseException, JsonMappingException, IOException, JSONException {

		MyLocationDto locationObj = null;
		ObjectMapper mapper = new ObjectMapper();
		locationObj = mapper.readValue(location, MyLocationDto.class);
		MyLocation myLocation = DataPopulationHelper.populateLocationFromDto(locationObj);
		String address = GoogleAddressClient.getAddressFromCoordinates(locationObj.getLatitude(),locationObj.getLongitude());
		myLocation.setLastDetectedLocation(address);
		locationDaoImpl.saveMyLocation(myLocation);


		return locationObj.toString();
	}

	@Override
	public void saveMyDetails(String myDetails) throws JsonParseException, JsonMappingException, IOException {

		MyDetailsDto detailsDto = null;
		ObjectMapper mapper = new ObjectMapper();

		detailsDto = mapper.readValue(myDetails, MyDetailsDto.class);
		locationDaoImpl.saveMyDetails(DataPopulationHelper.populateDetailsFromDto(detailsDto));

	}

	@Override
	public String getMyLocation(String number) throws JsonGenerationException, JsonMappingException, IOException {
		String jsonLocation = null;
		ObjectMapper mapper = new ObjectMapper();
		MyLocation location = locationDaoImpl.getMyLocation(number);
		if(location !=null){
			MyLocationDto locationDto = DataPopulationHelper.populateToDto(location);
			jsonLocation = mapper.writeValueAsString(locationDto);
		}
		return jsonLocation;
	}


	@Override
	public String getIpAddressGeoLoacation(String ipAddress) throws JSONException, IOException {
		String jsonLocation = IpAddressClient.getIpAddressGeoLoacation(ipAddress);
		return jsonLocation;
	}

}

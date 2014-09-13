/**
 * 
 */
package com.findmybuddy.restws.service.impl;

import java.io.IOException;
import java.util.Date;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;

import com.findmybuddy.restws.dao.MyLocationDao;
import com.findmybuddy.restws.domain.MyDetails;
import com.findmybuddy.restws.domain.MyLocation;
import com.findmybuddy.restws.dto.MyDetailsDto;
import com.findmybuddy.restws.dto.MyLocationDto;
import com.findmybuddy.restws.googleclient.GoogleAddressClient;
import com.findmybuddy.restws.service.MyLocationService;
import com.findmybuddy.restws.utils.DateUtils;

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
		MyLocation myLocation = populateLocationFromDto(locationObj);
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
		locationDaoImpl.saveMyDetails(populateDetailsFromDto(detailsDto));

	}

	@Override
	public String getMyLocation(String number) throws JsonGenerationException, JsonMappingException, IOException {
		String jsonLocation = null;
		ObjectMapper mapper = new ObjectMapper();
		MyLocation location = locationDaoImpl.getMyLocation(number);
		if(location !=null){
			MyLocationDto locationDto = populateToDto(location);
			jsonLocation = mapper.writeValueAsString(locationDto);
		}
		return jsonLocation;
	}
	
	
	private MyLocationDto populateToDto(MyLocation location) {
		MyLocationDto locationDto =  new MyLocationDto();
		locationDto.setLastDetectedTime(DateUtils.getDateAsString(location.getLastDetectedTime()));
		locationDto.setLatitude(location.getLatitude());
		locationDto.setLongitude(location.getLongitude());
		locationDto.setNumber(location.getNumber());
		return locationDto;
	}

	private MyDetails populateDetailsFromDto(MyDetailsDto detailsDto) {
		MyDetails details = new MyDetails();
		details.setEmail(detailsDto.getEmail());
		details.setName(detailsDto.getName());
		details.setNumber(detailsDto.getNumber());
		details.setPassWord(detailsDto.getPassWord());
		return details;
	}

	private MyLocation populateLocationFromDto(MyLocationDto dto){
		MyLocation location =  new MyLocation();
		location.setLastDetectedLocation(dto.getLastDetectedLocation());
		location.setLastDetectedTime(new Date());
		location.setLatitude(dto.getLatitude());
		location.setLongitude(dto.getLongitude());
		location.setNumber(dto.getNumber());
		return location;
	}

}

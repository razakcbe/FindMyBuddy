package com.findmybuddy.restws.helper;

import java.util.Date;

import com.findmybuddy.restws.domain.MyDetails;
import com.findmybuddy.restws.domain.MyLocation;
import com.findmybuddy.restws.dto.MyDetailsDto;
import com.findmybuddy.restws.dto.MyLocationDto;
import com.findmybuddy.restws.utils.DateUtils;

public class DataPopulationHelper {

	public static MyLocationDto populateToDto(MyLocation location) {
		MyLocationDto locationDto =  new MyLocationDto();
		locationDto.setLastDetectedTime(DateUtils.getDateAsString(location.getLastDetectedTime()));
		locationDto.setLatitude(location.getLatitude());
		locationDto.setLongitude(location.getLongitude());
		locationDto.setNumber(location.getNumber());
		return locationDto;
	}

	public static MyDetails populateDetailsFromDto(MyDetailsDto detailsDto) {
		MyDetails details = new MyDetails();
		details.setEmail(detailsDto.getEmail());
		details.setName(detailsDto.getName());
		details.setNumber(detailsDto.getNumber());
		details.setPassWord(detailsDto.getPassWord());
		return details;
	}

	public static MyLocation populateLocationFromDto(MyLocationDto dto){
		MyLocation location =  new MyLocation();
		location.setLastDetectedLocation(dto.getLastDetectedLocation());
		location.setLastDetectedTime(new Date());
		location.setLatitude(dto.getLatitude());
		location.setLongitude(dto.getLongitude());
		location.setNumber(dto.getNumber());
		return location;
	}

}

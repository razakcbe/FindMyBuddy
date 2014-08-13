/**
 * 
 */
package com.findmybuddy.restws.dto;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author Razak
 *
 */
public class MyLocationDto {
		
	@JsonProperty(value="number")
	private String number;
	
	@JsonProperty(value="latitude")
	private String latitude;
	
	@JsonProperty(value="longitude")
	private String longitude;
	
	@JsonProperty(value="lastDetectedLocation")
	private String lastDetectedLocation;
	
	@JsonProperty(value="lastDetectedTime")
	private String lastDetectedTime;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLastDetectedLocation() {
		return lastDetectedLocation;
	}

	public void setLastDetectedLocation(String lastDetectedLocation) {
		this.lastDetectedLocation = lastDetectedLocation;
	}

	public String getLastDetectedTime() {
		return lastDetectedTime;
	}

	public void setLastDetectedTime(String lastDetectedTime) {
		this.lastDetectedTime = lastDetectedTime;
	}

}

package com.findmybuddy.restws.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "MY_LOCATION")
public class MyLocation {

	@Id
	@Column(name = "number" ,nullable = false, length=10,unique=true)
	private String number;

	@Column(name = "latitude" ,nullable = false, length=50)
	private String latitude;

	@Column(name = "longitude" ,nullable = false, length=50)
	private String longitude;

	@Column(name = "lastDetectedLocation",nullable = false, length=50)
	private String lastDetectedLocation;

	@Column(name = "lastDetectedTime",nullable = false)
	private Date lastDetectedTime;

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

	public Date getLastDetectedTime() {
		return lastDetectedTime;
	}

	public void setLastDetectedTime(Date lastDetectedTime) {
		this.lastDetectedTime = lastDetectedTime;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}
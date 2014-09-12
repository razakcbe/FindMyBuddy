package com.findmybuddy.restws.dao;

import org.springframework.stereotype.Repository;

import com.findmybuddy.restws.domain.MyDetails;
import com.findmybuddy.restws.domain.MyLocation;

@Repository
public interface MyLocationDao {
	
	public String saveMyLocation(MyLocation location);

	public void saveMyDetails(MyDetails myDetails);
	
	public MyDetails getMyDetails(String number);
	
	public MyLocation getMyLocation(String number);

}

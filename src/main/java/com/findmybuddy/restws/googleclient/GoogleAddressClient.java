package com.findmybuddy.restws.googleclient;

import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.io.IOUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;


public class GoogleAddressClient {


	public static String getAddressFromCoordinates(String lat,String log) throws JSONException, IOException{
		String googleUrl ="https://maps.googleapis.com/maps/api/geocode/json?latlng=";
		String url = googleUrl+lat+","+log+"&key=AIzaSyBdxdBEmlQwgddLH7FWuRYajciszppGUJo";
	  
		  Response res = ClientBuilder.newClient().register(JacksonJsonProvider.class)
                  .target(url)
                  .request(MediaType.TEXT_PLAIN)
                  .get();
		  
		  JSONObject response = new JSONObject(
                  IOUtils.toString((InputStream) res.getEntity()));
		  
		  String detectedLocation = (String) response.getJSONArray("results").getJSONObject(0).getString("formatted_address");
		  System.out.println(detectedLocation.length());   
		return detectedLocation;
	}
	
}

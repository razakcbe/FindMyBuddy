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

public class IpAddressClient {

	public static String getIpAddressGeoLoacation(String ipAddress) throws JSONException, IOException
	{
		String googleUrl ="http://freegeoip.net/json/"+ipAddress;

		Response res = ClientBuilder.newClient().register(JacksonJsonProvider.class)
				.target(googleUrl)
				.request(MediaType.TEXT_PLAIN)
				.get();

		JSONObject response = new JSONObject(
				IOUtils.toString((InputStream) res.getEntity()));

		return formatAddress(response);
	}

	public static String formatAddress(JSONObject jsonObject) throws JSONException
	{
		StringBuffer formattedAddress = new StringBuffer();
		formattedAddress.append(jsonObject.get("city")).append(" ").append(jsonObject.get("region_name")).append(" ").append(jsonObject.get("zipcode"));
		
		return formattedAddress.toString();
	}
}

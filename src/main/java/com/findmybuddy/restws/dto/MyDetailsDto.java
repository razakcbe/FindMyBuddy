/**
 * 
 */
package com.findmybuddy.restws.dto;

import org.codehaus.jackson.annotate.JsonProperty;


/**
 * @author Razak
 *
 */
public class MyDetailsDto {
		
	@JsonProperty(value="email")
	private String email;
	
	@JsonProperty(value="number")
	private String number;
	
	@JsonProperty(value="passWord")
	private String passWord;
	
	@JsonProperty(value="name")
	private String name;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

/**
 * 
 */
package com.findmybuddy.restws.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Razak
 *
 */
/*{
	"email":"razakcbe@gmail.com",
	"number":"8123695220",
	"passWord":"abdul",
	"name":"Razak"
	
}*/
@Entity
@Table(name = "MY_DETAIL")
public class MyDetails {
		
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "email" ,nullable = false, length=30)
	private String email;
	

	@Column(name = "number",nullable = false, length=10,unique=true)
	private String number;
	
	@Column(name = "passWord",nullable = false, length=16)
	private String passWord;
	
	@Column(name = "name",nullable = false, length=20)
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

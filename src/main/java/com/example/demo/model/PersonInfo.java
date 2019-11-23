package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class PersonInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@JsonProperty("personName")
	@NotBlank(message = "The person name is mandatory, please enter the name")
	private String personName;
	
	@JsonProperty("lastName")
	@NotBlank(message = "The lastname is mandatory, please enter the lastname")
	private String lastName;
	
	@JsonProperty("addressHome")
	@NotBlank(message = "The address is mandatory, please enter the address")
	private String addressHome;
	
	@JsonProperty("phoneNumber")
	private Integer phoneNumber;
	
	@JsonProperty("hairColour")
	@Pattern(regexp = "^(black|red|yellow|white)$", message = "Only hair colours black, red, yellow and white are allowed")
	private String hairColour;

	public PersonInfo() {
		
	}

	public PersonInfo(Integer id,
			@NotBlank(message = "The person name is mandatory, please enter the name") String personName,
			@NotBlank(message = "The lastname is mandatory, please enter the lastname") String lastName,
			@NotBlank(message = "The address is mandatory, please enter the address") String addressHome,
			Integer phoneNumber,
			@Pattern(regexp = "^(black|red|yellow|white)$", message = "Only hair colours black, red, yellow and white are allowed") String hairColour) {
		super();
		this.id = id;
		this.personName = personName;
		this.lastName = lastName;
		this.addressHome = addressHome;
		this.phoneNumber = phoneNumber;
		this.hairColour = hairColour;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddressHome() {
		return addressHome;
	}

	public void setAddressHome(String addressHome) {
		this.addressHome = addressHome;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getHairColour() {
		return hairColour;
	}

	public void setHairColour(String hairColour) {
		this.hairColour = hairColour;
	}


}

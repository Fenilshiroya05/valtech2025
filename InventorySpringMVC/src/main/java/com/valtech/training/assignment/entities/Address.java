package com.valtech.training.assignment.entities;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

	private String city;
	private int pinCode;
	private String street;
	
	public Address(String city, int pinCode, String street) {
		super();
		this.city = city;
		this.pinCode = pinCode;
		this.street = street;
	}
	public Address() {}
	
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	
}

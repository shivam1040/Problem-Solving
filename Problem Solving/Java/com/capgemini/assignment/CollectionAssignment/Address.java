package com.capgemini.assignment.CollectionAssignment;

public class Address {
	private String addressId, addressline1, city, state;
	
	public Address(String addressId, String addressline1, String city, String state) {
		this.addressId = addressId;
		this.addressline1 = addressline1;
		this.city = city;
		this.state = state;
	}

	public String getAddressId() {
		return addressId;
	}

	public String getAddressline1() {
		return addressline1;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}
}

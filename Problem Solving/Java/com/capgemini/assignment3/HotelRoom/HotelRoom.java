package com.capgemini.assignment3.HotelRoom;

public class HotelRoom {
	protected String hotelName;
	protected Integer numberOfSqFeet;
	protected Boolean hasTv;
	protected Boolean hasWifi;
	
	public HotelRoom(String hotelName, Integer numberOfSqFeet, Boolean hasTv, Boolean hasWifi) {
		this.hotelName = hotelName;
		this.numberOfSqFeet = numberOfSqFeet;
		this.hasTv = hasTv;
		this.hasWifi = hasWifi;
	}
	
	public Integer calculateTariff(Integer ratePerSqFeet) {
		return numberOfSqFeet*ratePerSqFeet;
	}
	
	public Integer getRatePerSqFeet() {
		return 0;
	}
}
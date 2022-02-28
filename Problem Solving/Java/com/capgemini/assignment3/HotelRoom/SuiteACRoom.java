package com.capgemini.assignment3.HotelRoom;

class SuiteACRoom extends HotelRoom{
	private Integer ratePerSqFeet;

	public SuiteACRoom(String hotelName, Integer numberOfSqFeet, Boolean hasTv, Boolean hasWifi) {
		super(hotelName, numberOfSqFeet, hasTv, hasWifi);
		this.ratePerSqFeet = 15;
	}
	
	public Integer getRatePerSqFeet() {
		if(hasWifi)
			return ratePerSqFeet+2;
		return ratePerSqFeet;
	}
}

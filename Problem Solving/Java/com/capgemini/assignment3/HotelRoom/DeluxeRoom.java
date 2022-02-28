package com.capgemini.assignment3.HotelRoom;

class DeluxeRoom extends HotelRoom{
	protected Integer ratePerSqFeet;

	public DeluxeRoom(String hotelName, Integer numberOfSqFeet, Boolean hasTv, Boolean hasWifi) {
		super(hotelName, numberOfSqFeet, hasTv, hasWifi);
		this.ratePerSqFeet = 10;
	}
	
	public Integer getRatePerSqFeet() {
		if(hasWifi) 
			return ratePerSqFeet+2;
		return ratePerSqFeet;
	}
}

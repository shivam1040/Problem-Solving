package com.capgemini.assignment3.HotelRoom;

class DeluxeACRoom extends DeluxeRoom{
	DeluxeACRoom(String hotelName, Integer numberOfSqFeet, Boolean hasTv, Boolean hasWifi){
		super(hotelName, numberOfSqFeet, hasTv, hasWifi);
		super.ratePerSqFeet=12;
	}
}

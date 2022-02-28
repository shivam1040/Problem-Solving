package com.capgemini.assignment3.HotelRoom;

import java.util.Scanner;

class Driver5{
	public static void main(String args[]) {
		System.out.printf("%s%n %5s%n %5s%n %5s %n%s %n", "Hotel Tariff Calculator", "1. Deluxe Room", "2. Deluxe AC Room", "3. Suite AC Room", "Select Room Type:");
		Scanner userInput=new Scanner(System.in);
		int choice=userInput.nextInt();
		System.out.println("Hotel Name:");
		userInput.skip("\\R?");
		String hName=userInput.nextLine();
		System.out.println("Room Square Feet Area:");
		Integer roomSquareFeetArea=userInput.nextInt();
		System.out.println("Room has TV (yes/no):");
		userInput.skip("\\R?");
		Boolean hasTV=userInput.nextLine().equals("yes")?true:false;
		System.out.println("Room has Wifi (yes/no):");
		Boolean hasWifi=userInput.nextLine().equals("yes")?true:false;
		if(choice==1) {
			HotelRoom obj=new DeluxeRoom(hName, roomSquareFeetArea, hasTV, hasWifi);
			System.out.println("Room Tariff per day is:"+obj.calculateTariff(obj.getRatePerSqFeet()));
		}
		else if(choice==2) {
			DeluxeRoom obj=new DeluxeACRoom(hName, roomSquareFeetArea, hasTV, hasWifi);
			System.out.println("Room Tariff per day is:"+obj.calculateTariff(obj.ratePerSqFeet));
		}
		else if(choice==3) {
			HotelRoom obj=new SuiteACRoom(hName, roomSquareFeetArea, hasTV, hasWifi);
			System.out.println("Room Tariff per day is:"+obj.calculateTariff(obj.getRatePerSqFeet()));
		}
		userInput.close();
	}
}

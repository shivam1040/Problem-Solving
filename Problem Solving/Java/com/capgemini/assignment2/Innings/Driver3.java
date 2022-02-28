package com.capgemini.assignment2.Innings;

import java.util.Scanner;

class Driver3{
	public static void main(String args[]) {
		Scanner userInput=new Scanner(System.in);
		System.out.println("Enter the number of innings");
		Innings inningsObjArray[]=new Innings[userInput.nextInt()];
		for(int i=0; i<inningsObjArray.length; i++) {
			System.out.println("Enter innings "+(i+1)+" details");
			userInput.skip("\\R?"); //skipping the new line detection before Scanner objects recieves any input from user
			inningsObjArray[i]=new InningsBO().createInnings(userInput.nextLine().trim());
		}
		System.out.println("Enter the number of deliveries");
		Delivery deliveryObjArray[]=new Delivery[userInput.nextInt()];
		for(int i=0; i<deliveryObjArray.length; i++){
			System.out.println("Enter innings "+(i+1)+" details");
			DeliveryBO deliveryBOObj=new DeliveryBO();
			userInput.skip("\\R?");
			deliveryObjArray[i]=deliveryBOObj.createDelivery(userInput.nextLine().trim(), inningsObjArray);
		}
		System.out.println("Enter the delivery number for which you need to find the innings number");
		System.out.println(new DeliveryBO().findInningsNumber(deliveryObjArray, userInput.nextLong()));
		userInput.close();
	}
}

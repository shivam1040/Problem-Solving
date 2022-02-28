package com.capgemini.assignment3.TheRetailStoreDiscounts;

import java.util.Scanner;

class Driver6{
	public static void main(String args[]) {
		System.out.println("Enter billed amount:");
		Scanner userInput=new Scanner(System.in);
		Double bill=userInput.nextDouble();
		System.out.println("Enter the type of user\n1.Employee\n2.Affiliate\n3.Customer");
		Integer type=userInput.nextInt();
		if(type==1) {
			System.out.println("\nAmount after discount:\n"+new Employee(bill).billAfterDiscount(type+2));
		}
		else if(type==2) {
			System.out.println("\nAmount after discount:\n"+new Affiliate(bill).billAfterDiscount(type+1));
		}
		else if(type==3) {
			System.out.println("Enter the duration of customer:");
			Integer duration=userInput.nextInt();
			System.out.println("\nAmount after discount:\n"+new Customer(bill, duration).billAfterDiscount(duration));
		}
		userInput.close();
	}
}

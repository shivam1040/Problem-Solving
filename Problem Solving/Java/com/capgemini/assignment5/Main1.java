package com.capgemini.assignment5;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class Main1 {
	public static void main(String args[]) {
		String name, teamName, numberOfMatches;
		System.out.println("Enter the name of the player");
		Scanner userInput=new Scanner(System.in);
		name=userInput.nextLine();
		System.out.println("Enter the team name");
		teamName=userInput.nextLine();
		System.out.println("Enter the number of matches played");
		numberOfMatches=userInput.nextLine();
		String temp=name+","+teamName+","+numberOfMatches;
		userInput.close();
		byte b[]=temp.getBytes();
		try {
		OutputStream obj = new FileOutputStream(".\\src\\main\\java\\com\\capgemini\\assignment5\\PlayerDetails.csv");
		obj.write(b);
		obj.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}


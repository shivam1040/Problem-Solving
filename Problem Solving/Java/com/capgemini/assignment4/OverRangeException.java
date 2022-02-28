/*
Custom Exception (OverRange Exception)
Write a program that takes as input the total runs scored and the total overs faced, and calculates the run rate with the formula,
Run rate= total runs scored/total overs faced
This program may generate a custom exception when the over number does not lie between the range   0 < Over <=20.
Create a class called OverRangeException which extends Exception and it includes constructor to initialize the message. 
Use exception handling mechanisms to handle this exception. 
 
Input and Output Format:
	Refer sample input and output for formatting specifications.
	All text in bold corresponds to input and the rest corresponds to output.
 
Sample Input and Output 1:
Enter the total runs scored
79
Enter the total overs faced
14
Current Run Rate: 5.64 
Sample Input and Output 2:
Enter the total runs scored
50
Enter the total overs faced
21
OverRangeException: Over is not in the specified range

*/

package com.capgemini.assignment4;

import java.util.Scanner;

public class OverRangeException extends Exception{

	public OverRangeException() {
		super("OverRangeException: Over is not in the specified range");
		// TODO Auto-generated constructor stub
	}	
	
	public static void main(String args[]) {
		Scanner userInput=new Scanner(System.in);
		try {
			int run, over;
			double runRate;
			System.out.println("Enter the total runs scored");
			run=userInput.nextInt();
			System.out.println("Enter the total overs faced");
			over=userInput.nextInt();
			if(over>20 || over<0)
				throw new OverRangeException();
			runRate=Math.round((double)run/over*100.0)/100.0;
			System.out.println("Current Run Rate:"+runRate);
		}
		catch(OverRangeException e) {
			System.out.println(e);
		}
		finally {
			userInput.close();
		}
	}
}
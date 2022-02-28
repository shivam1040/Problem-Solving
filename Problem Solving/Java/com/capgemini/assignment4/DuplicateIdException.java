/*
Custom Exception - Duplicate Id Exception
 
IPL T20 asks the committee to suggest players for the next IPL series.
Write a program to get the team name, number of players, their id and name in such a way
that the player id in the team should be unique and display the suggested player list.
When the committee enters an id that is already assigned for a player this program may
generate a custom exception called DuplicateIdException. Use exception handling
mechanisms to handle this exception.  
Note:
	Create two arrays: one for playerId and the other for playerName
	Initialize the playerId array with 0
Input and Output Format:
	Refer sample input and output for formatting specifications.
	All text in bold corresponds to input and the rest corresponds to output.
Sample Input and Output 1: 
Enter the team name
Chennai Super Kings
Enter the number of players suggested
3
Enter player 1 details
1
MS Dhoni
Enter player 2 details
2
Ravichandran Ashwin 
Enter player 3 details
2
Suresh Raina
DuplicateIdException: Player Id must be unique
 
Sample Input and Output 2:
Enter the team name
Mumbai Indians
Enter the number of players suggested
2
Enter player 1 details
1
Jaspirit Bumrah
Enter player 2 details
2
Hardik Pandya
1 Jaspirit Bumrah
2 Hardik Pandya

*/

package com.capgemini.assignment4;

import java.util.Arrays;
import java.util.Scanner;

public class DuplicateIdException extends Exception {

	public DuplicateIdException() {
		super("DuplicateIdException: Player Id must be unique");
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String args[]) {
		System.out.println("Enter the team name");
		Scanner userInput=new Scanner(System.in);
		userInput.nextLine();
		System.out.println("Enter the number of players suggested");
		int n=userInput.nextInt();
		Integer playerId[]=new Integer[n];
		String playerName[]=new String[n];
		for(int i=0; i<playerId.length; i++) {
			try {
				System.out.println("Enter player "+(i+1)+" details");
				System.out.println("Enter player "+(i+1)+" id");
				n=userInput.nextInt();
				if(Arrays.asList(playerId).contains(n))
					throw new DuplicateIdException();
				playerId[i]=n;
				System.out.println("Enter player "+(i+1)+" name");
				userInput.skip("\\R?");
				playerName[i]=userInput.nextLine();
			}
			catch(DuplicateIdException e) {
				System.out.println(e);
			}
		}
		System.out.println();
		for(int i=0; i<playerName.length; i++)
			if(playerId[i]!=null)
				System.out.println(playerId[i]+" "+playerName[i]);
		userInput.close();
}
}
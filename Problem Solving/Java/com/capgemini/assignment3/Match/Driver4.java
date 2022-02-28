package com.capgemini.assignment3.Match;

import java.util.Scanner;

class Driver4{
	public static void main(String args[]) {
		Scanner userInput=new Scanner(System.in);
		System.out.println("Enter number of matches");
		Match matchObjArray[]=new Match[userInput.nextInt()];
		for(int i=0; i<matchObjArray.length; i++) {
			System.out.println("Enter match "+(i+1)+" details:");
			System.out.println("Enter match date");
			userInput.skip("\\R?");
			String date=userInput.nextLine();
			System.out.println("Enter team one");
			String teamOne=userInput.nextLine();
			System.out.println("Enter team two");
			String teamTwo=userInput.nextLine();
			System.out.println("Enter venue");
			String venue=userInput.nextLine();
			System.out.println("Enter status");
			String status=userInput.nextLine();
			System.out.println("Enter winner Team");
			String wTeam=userInput.nextLine();
			matchObjArray[i]=new Match(date, teamOne, teamTwo, venue, new Outcome(status, wTeam));
		}
		while(true) {
			System.out.println("\nMenu\n1.View match details\n2.Filter match details with outcome status\n3.Filter match details with outcome winner team\n4.Exit\nEnter your choice");
			int choice=userInput.nextInt();
			if(choice==1) 
				new MatchBO().printAllMatchDetails(matchObjArray);
			else if(choice==2) {
				System.out.println("Enter outcome status");
				userInput.skip("\\R?");
				new MatchBO().printMatchDetailsWithOutcomeStatus(matchObjArray, userInput.nextLine());
			}
			else if(choice==3) {
				System.out.println("Enter outcome winner team");
				userInput.skip("\\R?");
				new MatchBO().printMatchDetailsWithOutcomeWinnerTeam(matchObjArray, userInput.nextLine());
			}
			else {
				break;
			}			
		}
		userInput.close();
	}
}

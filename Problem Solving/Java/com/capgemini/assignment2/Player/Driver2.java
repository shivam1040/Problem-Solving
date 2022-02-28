package com.capgemini.assignment2.Player;

import java.util.Scanner;

class Driver2{
	public static void main(String args[]) {
		Scanner userInput=new Scanner(System.in);
		System.out.println("Enter the player count");
		Player playerObjArray[]=new Player[userInput.nextInt()];
		for(int i=0; i<playerObjArray.length; i++) {
			PlayerBO1 playerBOobj=new PlayerBO1();
			System.out.println("Enter Player "+(i+1)+" details");
			userInput.skip("\\R?");
			playerObjArray[i]=playerBOobj.createPlayer(userInput.nextLine().trim());
		}
		System.out.println("Enter the team count");
		Team teamObjArray[]=new Team[userInput.nextInt()];
		for(int i=0; i<teamObjArray.length; i++) {
			TeamBO teamBOObj=new TeamBO();
			System.out.println("Enter team "+(i+1)+" details");
			userInput.skip("\\R?");
			teamObjArray[i]=teamBOObj.createTeam(userInput.nextLine().trim(), playerObjArray);
		}
		System.out.println("Enter the match count");
		Match matchObjArray[]=new Match[userInput.nextInt()];
		for(int i=0; i<matchObjArray.length; i++) {
			MatchBO matchBOObj=new MatchBO();
			System.out.println("Enter match "+(i+1)+" details");
			userInput.skip("\\R?");
			matchObjArray[i]=matchBOObj.createMatch(userInput.nextLine().trim(), teamObjArray);
		}
		while(true) {
			System.out.println();
			System.out.println("Menu:");
			System.out.println("1) Find Team");
			System.out.println("2) Find All Matches in A Specific Venue");
			System.out.println("Type 1 or 2");
			System.out.println("Enter your choice");
			if(userInput.nextInt()==1) {
				System.out.println("Enter Match date");
				MatchBO matchBOObj=new MatchBO();
				userInput.skip("\\R?");
				matchBOObj.findTeam(userInput.nextLine().trim(), matchObjArray);
				System.out.println("Do you want to continue? Type Yes or No");
				if(userInput.next().equals("Yes")) {
					continue;
				}
				else {
					break;
				}	
			}
			else {
				System.out.println("Enter Team Name");
				MatchBO matchBOObj=new MatchBO();
				userInput.skip("\\R?");
				matchBOObj.findAllMatchesOfTeam(userInput.nextLine().trim(), matchObjArray);
				System.out.println("Do you want to continue? Type Yes or No");
				if(userInput.next().equals("Yes")) {
					continue;
				}
				else {
					break;
				}
			}
		}
		userInput.close();
	}
}
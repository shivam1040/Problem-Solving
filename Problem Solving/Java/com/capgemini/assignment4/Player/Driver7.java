package com.capgemini.assignment4.Player;

import java.util.Scanner;

class Driver7{
	public static void main(String args[]) {
		System.out.println("Enter the number of players");
		Scanner userInput=new Scanner(System.in);
		int playersNum=userInput.nextInt();
		Player playerObjArray[]=new Player[playersNum+1];
		System.out.println("Do you know the details of the captain? Type Yes / No");
		userInput.skip("\\R?");
		if(userInput.nextLine().equals("Yes")) {
			String captainName, captainCountry, skillset;
			System.out.println("Enter name of the captain");
			captainName=userInput.nextLine();
			System.out.println("Enter country of the captain");
			captainCountry=userInput.nextLine();
			System.out.println("Enter skillset of the captain");
			skillset=userInput.nextLine();
			playerObjArray[0]=new Player(captainName, captainCountry, skillset);
		}
		for(int i=1; i<playerObjArray.length; i++) {
			System.out.println("Enter name of player "+i);
			String player=userInput.nextLine();
			System.out.println("Enter country of player "+i);
			String country=userInput.nextLine();
			System.out.println("Enter skillset of player "+i);
			String skillset=userInput.nextLine();
			playerObjArray[i]=new Player(player, country, skillset);
		}
		new PlayerBO().displayPlayerDetails(playerObjArray);
		userInput.close();
	}
}

package com.capgemini.assignment4.Player;

class PlayerBO{
	
	void displayPlayerDetails(Player playerList[]) {
		System.out.println();
		try {
			System.out.println(playerList[0].getName()+", "+playerList[0].getCountry()+", "+playerList[0].getSkill());
		}
		catch(NullPointerException exception){
			System.out.println(exception.getClass()+"\nCaptain details not available");
		}
		finally {
			System.out.println("Player Details");
			for(int i=1; i<playerList.length; i++)
				System.out.println(playerList[i].getName()+", "+playerList[i].getCountry()+", "+playerList[i].getSkill());
		}
	}
}

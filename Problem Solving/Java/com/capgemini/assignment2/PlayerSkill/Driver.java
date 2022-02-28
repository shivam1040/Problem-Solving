package com.capgemini.assignment2.PlayerSkill;

import java.util.Scanner;

class Driver{
	public static void main(String args[]) {
		Scanner userInput=new Scanner(System.in);
		System.out.println("Enter number of Players");
		int players=userInput.nextInt();
		PlayerSkill obj1[]=new PlayerSkill[players];
		Skill obj2[]=new Skill[players];
		PlayerBO obj3=new PlayerBO();
		int menu=0;
		for(int i=0; i<obj1.length; i++) {
			System.out.println("Enter player "+(i+1)+" details:");
			System.out.println("Enter player name");
			String name=userInput.nextLine();
			System.out.println("Enter country name");
			String country=userInput.next();
			System.out.println("Enter skill");
			String skill=userInput.next();
			obj2[i]=new Skill(skill);
			obj1[i]=new PlayerSkill(name, country, obj2[i]);
		}
		
		while(true) {
			System.out.println("\nMenu");
			System.out.println("1.View details");
			System.out.println("2.Filter players with skill");
			System.out.println("3.Exit");
			menu=userInput.nextInt();
			if(menu==1) {
				obj3.viewDetails(obj1);
			}
			else if(menu==2) {
				System.out.println("Enter skill");
				String skillFilterKey=userInput.next();
				System.out.println();
				obj3.printPlayerDetailsWithSkill(obj1, skillFilterKey);
			}
			else {
				userInput.close();
				break;
			}
		}
	}
}

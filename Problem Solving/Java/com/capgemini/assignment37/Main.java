package com.capgemini.assignment37;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		SortScore threadArray[]=new SortScore[3];
		Scanner userInput=new Scanner(System.in);
		for(int i=0; i<3; i++) {
			System.out.println("Enter the Match :");
			String matchType=userInput.nextLine();
			System.out.println("Enter the Scores :");
			String scoreString=userInput.nextLine();
			threadArray[i]=new SortScore(matchType, scoreString);
		}
		userInput.close();
		threadArray[0].start();
		threadArray[1].start();
		threadArray[2].start();
		try {
			threadArray[0].join();
			threadArray[1].join();
			threadArray[2].join();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		System.out.println("\nOrdered Score List");
		for(int i=0; i<threadArray.length; i++) {
			System.out.println("Match : "+threadArray[i].getMatchType());
			Integer temp[]=threadArray[i].getScores();
			for(Integer j:temp)
				System.out.println(j);
			System.out.println();
		}	
	}
}
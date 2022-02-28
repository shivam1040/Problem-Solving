package com.capgemini.assignment1;
import java.util.Scanner;

public class CaseChanger {
	
	void caseOperations(String input) {
		System.out.println("Upper Case:\n"+input.toUpperCase());
		
		System.out.println("Lower case:\n"+input.toLowerCase());
		
		StringBuilder temp=new StringBuilder(input.toLowerCase());
		temp.setCharAt(0, Character.toUpperCase(input.charAt(0)));
		int index=temp.length()-1;
		for(int i=0; i<temp.length()/2; i++) {
			if(temp.charAt(i)==' ')
				temp.setCharAt(i+1, Character.toUpperCase(input.charAt(i+1)));
			if(temp.charAt(index)==' ')
				temp.setCharAt(index+1, Character.toUpperCase(input.charAt(index+1)));
			index--;
		}
		System.out.println("Capitalize:\n"+temp);
		
		temp=new StringBuilder(input.toLowerCase());
		temp.setCharAt(0, Character.toUpperCase(input.charAt(0)));
		index=temp.length()-2;
		for(int i=1; i<temp.length()/2; i++) {
			if(temp.charAt(i-1)=='.' && temp.charAt(i)==' ' )
				temp.setCharAt(i+1, Character.toUpperCase(input.charAt(i+1)));
			if(temp.charAt(index+1)==' ' && temp.charAt(index)=='.')
				temp.setCharAt(index+2, Character.toUpperCase(input.charAt(index+2)));
			index--;
		}
		System.out.println("Sentence case:\n"+temp);
		
		temp=new StringBuilder(input.toUpperCase());
		temp.setCharAt(0, Character.toLowerCase(input.charAt(0)));
		temp.setCharAt(input.lastIndexOf(" ")+1, Character.toLowerCase(input.charAt(input.lastIndexOf(" ")+1)));
		System.out.println("Invert:\n"+temp);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CaseChanger obj1=new CaseChanger();
		Scanner userInput=new Scanner(System.in);
		System.out.println("Input:");
		obj1.caseOperations(userInput.nextLine());
		userInput.close();
	}

}

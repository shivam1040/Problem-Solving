package com.capgemini.assignment1;
import java.util.Scanner;
public class FactorialNumber {
	
	static int factorial=1;
	
	int factorialGenerator(int n) {
		if((n-1)>0) {
			factorial*=n*(n-1);
			factorialGenerator(n-2);
		}
		return factorial;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner userInput=new Scanner(System.in);
		System.out.print("N = ");
		int n=userInput.nextInt();
		FactorialNumber obj1=new FactorialNumber();
		n=obj1.factorialGenerator(n);
		System.out.print(n);
		System.out.print(" ("+NumbersToWords.solution(n)+")");
		userInput.close();
	}

}

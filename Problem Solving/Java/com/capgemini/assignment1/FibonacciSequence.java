package com.capgemini.assignment1;
import java.util.Scanner;
public class FibonacciSequence {
	static int n1=0, n2=1, n3=0;
	
	void fibonacciGenerator(int n) {
		if((n1+n2)<n) {
			n3=n1+n2;
			n1=n2;
			n2=n3;
			System.out.print(n3+" ");
			fibonacciGenerator(n);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner userInput=new Scanner(System.in);
		System.out.print("Input N = ");
		int n=userInput.nextInt();
		FibonacciSequence obj1=new FibonacciSequence();
		System.out.print(n2+" ");
		obj1.fibonacciGenerator(n);
		userInput.close();
	}

}

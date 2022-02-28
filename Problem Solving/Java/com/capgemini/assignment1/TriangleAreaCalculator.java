package com.capgemini.assignment1;
import java.util.Scanner;

public class TriangleAreaCalculator {

	int operation(int coordinates[]) {
		return (int) Math.abs(0.5*((coordinates[0]*(coordinates[3]-coordinates[5]))+(coordinates[2]*(coordinates[5]-coordinates[1]))+(coordinates[4]*(coordinates[1]-coordinates[3]))));
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TriangleAreaCalculator obj1=new TriangleAreaCalculator();
		Scanner userInput=new Scanner(System.in);
		int coordinates[]=new int[6];
		System.out.print("Point A (x, y): ");
		coordinates[0]=userInput.nextInt();
		coordinates[1]=userInput.nextInt();
		System.out.print("Point B (x, y): ");
		coordinates[2]=userInput.nextInt();
		coordinates[3]=userInput.nextInt();
		System.out.print("Point C (x, y): ");
		coordinates[4]=userInput.nextInt();
		coordinates[5]=userInput.nextInt();
		System.out.println(obj1.operation(coordinates));
		userInput.close();
	}

}

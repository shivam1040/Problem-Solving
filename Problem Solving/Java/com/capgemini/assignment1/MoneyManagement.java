package com.capgemini.assignment1;
import java.util.Scanner;

public class MoneyManagement {
	
	void moneyDivision(int money) { 
		System.out.println("NEC: "+(int)(money*0.55)+"\t"+"LTSS: "+(int)(money*0.1)+"\n"+"FFA: "+(int)(money*0.1)+"\t"+"PLAY: "+(int)(money*.1)+"\n"+"EDU: "+(int)(money*.1)+"\t"+"GIVE: "+(int)(money*0.05));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner userInput=new Scanner(System.in);
		System.out.print("Enter your income this month: ");
		int money=userInput.nextInt();
		MoneyManagement obj1=new MoneyManagement();
		obj1.moneyDivision(money);
		userInput.close();
	}

}

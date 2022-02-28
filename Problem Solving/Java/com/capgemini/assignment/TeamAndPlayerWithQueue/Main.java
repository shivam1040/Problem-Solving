package com.capgemini.assignment.TeamAndPlayerWithQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	 public static void main(String[] args) {
		 try {
		 	System.out.println("Enter the number of Players");
		    Scanner userInput=new Scanner(System.in);
		    int n=userInput.nextInt();
		    Queue<Main> qObj=new LinkedList<Main>();
		 	PlayerThread p = new PlayerThread(qObj, n);
		 	TeamThread t=new TeamThread(qObj, n);
		 	t.start();
		 	p.start();
		    userInput.close();
			t.join();
			p.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	}
}

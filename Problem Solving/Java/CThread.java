/*
Write a multi-threaded Java program to implement Team and Player. Span two thread for team and player from the main method. The team inserts number starting from 0 to N into the queue, the consumer should take these number from the shared queue and prints the number to the console. 
The first input is the number of elements inserted into the queue. 
Create a main class "Main.java" 
Create TeamThread class extending Thread class with below attributes, 
	threadMain - Main class object 
	numberOfPlayers 
Create a constructor for TeamThread with arguments threadMain and numberOfPlayers 
Create PlayerThread class extending Thread class with below attributes, 
	threadMain - Main class object 
	numberOfPlayers 
Create a constructor for PlayerThread with arguments threadMain and numberOfPlayers 

In the run() method the main thread object is synchronized and using the wait() and notifyAll() method 

Input and Output Format: 
First input corresponds to the number of players. 
Refer sample input and output for formatting specifications. 

[All text in bold corresponds to input and the rest corresponds to output] 
Sample Input/Output : 
Enter the number of Players 
10 
Player Thread 0 
Player Thread 1 
Player Thread 2 
Player Thread 3 
Player Thread 4 
Player Thread 5 
Player Thread 6 
Player Thread 7 
Player Thread 8 
Player Thread 9

*/
public class CThread implements Runnable {
	public void run() {
		Thread name=new Thread();
		if(name.getName().equals("even")) {
		for(int i=1; i<101; i++) 
			if(i%2==0)
				System.out.println(i);
		}
		else if(name.getName().equals("odd")) {
		for(int i=1; i<101; i++)
			if(i%2!=0)
				System.out.println(i);
		}
		else if(name.getName().equals("prime")) {
		for(int i=2; i<101; i++) {
			if(i==2) {
				System.out.println(i);
				continue;
			}	
			boolean check=false;
			for(int j=2; j<i-1; j++) {
				if(i%j==0)
					j=i-1;
				check=true;
			}
			if(check)
				System.out.println(i);
		}
		}
	}
	
	public static void main(String args[]) {
		Runnable obj=new Thread(new CThread());
		Thread t1=new Thread(obj, "odd");
		Thread t2=new Thread(obj, "even");
		Thread t3=new Thread(obj, "prime");
		t1.start();
		t2.start();
		t3.start();
	}
}
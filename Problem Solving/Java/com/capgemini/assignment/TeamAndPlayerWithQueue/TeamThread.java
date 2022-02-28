package com.capgemini.assignment.TeamAndPlayerWithQueue;

import java.util.Queue;

public class TeamThread extends Thread {
	int numberOfPlayers;
	Queue<Main> threadMain; 
	public TeamThread(Queue<Main> threadMain, int numberOfPlayers) {
		this.threadMain = threadMain;
		this.numberOfPlayers = numberOfPlayers;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			int i=0;
			while(i<this.numberOfPlayers) {
			synchronized (this) {
				while (threadMain.size() == this.numberOfPlayers)
	                wait();
				threadMain.add(new Main());
				i++;
				notify();
			}
			}
			}
			catch(Exception e) {
				System.out.println(e);
			}
	}
}

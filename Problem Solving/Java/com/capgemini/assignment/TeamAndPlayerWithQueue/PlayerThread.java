package com.capgemini.assignment.TeamAndPlayerWithQueue;

import java.util.Queue;

public class PlayerThread extends Thread{
	int numberOfPlayers;
	Queue<Main> threadMain;
	public PlayerThread(Queue<Main> threadMain, int numberOfPlayers) {
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
			while (threadMain.size() == 0)
                wait();
			threadMain.poll();
			System.out.println("Player Thread "+i);
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

package com.capgemini.assignment1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardsDealer {
	void cardsShuffle() {
		List<String> cardsStack=new ArrayList<String>();
		Collections.addAll(cardsStack, "3c","8d","2h","As","Jc","10h","Kh","5s","6s","9d","Qd","2s","7c","6d","6h","2d","3s","4d","4h","5c","Qc","Kd","Jd","8c","10c","Ac","3d","4c","Jh","6c","10d","5h","7s","2c","7h","Ad","8s","Qh","3h","Ah","4s","10s","5d","Qs","Kc","Ks","9c","9h","9s","Js","8h","7d");
		Collections.shuffle(cardsStack); //randomizing the list
		String player1=String.join(" ", cardsStack.subList(0, 13)); //storing a sub lists in equal parts 
		String player2=String.join(" ", cardsStack.subList(13, 26));
		String player3=String.join(" ", cardsStack.subList(26, 39));
		String player4=String.join(" ", cardsStack.subList(39, 52));
		System.out.println("Player #1: "+player1+"\n"+"Player #2: "+player2+"\n"+"Player #3: "+player3+"\n"+"Player #4: "+player4+"\n");
	}
	public static void main(String args[]) {
		CardsDealer obj1=new CardsDealer();
		obj1.cardsShuffle();
	}
}

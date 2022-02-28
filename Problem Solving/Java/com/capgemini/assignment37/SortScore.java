package com.capgemini.assignment37;

import java.util.Arrays;

public class SortScore extends Thread{
	private String matchType, scoreString;
	private Integer scores[];
	
	public SortScore(String matchType, String scoreString) {
		this.matchType = matchType;
		this.scoreString = scoreString;
	}
	
	public void run() {
		String temp[]=this.scoreString.split(",");
		this.scores=new Integer[temp.length];
		for(int i=0; i<temp.length; i++)
			this.scores[i]=Integer.parseInt(temp[i]);
		Arrays.sort(this.scores);
	}

	public Integer[] getScores() {
		return scores;
	}

	public String getMatchType() {
		return matchType;
	}
}

package com.capgemini.assignment3.Match;

class Outcome {
	private String status, winnerTeam;
	Outcome(String status, String winnerTeam) {
		// TODO Auto-generated constructor stub
		this.status=status;
		this.winnerTeam=winnerTeam;
	}
	
	public String getStatus() {
		return status;
	}
	public String getWinnerTeam() {
		return winnerTeam;
	}
}
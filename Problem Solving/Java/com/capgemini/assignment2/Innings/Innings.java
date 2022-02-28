package com.capgemini.assignment2.Innings;

public class Innings {
	private Long inningsNumber;
	private String battingTeam;
	
	Innings(Long inningsNumber, String battingTeam) {
		this.inningsNumber = inningsNumber;
		this.battingTeam = battingTeam;
	}
	public Long getInningsNumber() {
		return inningsNumber;
	}
	public String getBattingTeam() {
		return battingTeam;
	}	
}


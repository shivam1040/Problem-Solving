package com.capgemini.assignment2.Player;

class Match{
	private String  date, venue;
	private Team teamone, teamtwo;
	
	Match(String date, String venue, Team teamone, Team teamtwo) {
		this.date = date;
		this.venue = venue;
		this.teamone = teamone;
		this.teamtwo = teamtwo;		
	}

	public String getDate() {
		return date;
	}

	public String getVenue() {
		return venue;
	}

	public Team getTeamone() {
		return teamone;
	}

	public Team getTeamtwo() {
		return teamtwo;
	}
}

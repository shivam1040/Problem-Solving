package com.capgemini.assignment5.Match;

public class Match {
	private String teamOne, teamTwo, venue, matchDate;

	public Match(String teamOne, String teamTwo, String venue, String matchDate) {
		this.teamOne = teamOne;
		this.teamTwo = teamTwo;
		this.venue = venue;
		this.matchDate = matchDate;
	}

	public String getTeamOne() {
		return teamOne;
	}

	public String getTeamTwo() {
		return teamTwo;
	}

	public String getVenue() {
		return venue;
	}

	public String getMatchDate() {
		return matchDate;
	}
	
	void displayMatch(Match match, Integer i) {
		
	}
}
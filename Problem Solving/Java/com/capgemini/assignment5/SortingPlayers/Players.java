package com.capgemini.assignment5.SortingPlayers;

class Players {
	private Integer capNumber, matchesPlayed;
	private String playerName, skill, country;
	
	Players(Integer capNumber, Integer matchesPlayed, String playerName, String skill, String country) {
		this.capNumber = capNumber;
		this.matchesPlayed = matchesPlayed;
		this.playerName = playerName;
		this.skill = skill;
		this.country = country;
	}

	public Integer getCapNumber() {
		return capNumber;
	}

	public Integer getMatchesPlayed() {
		return matchesPlayed;
	}

	public String getPlayerName() {
		return playerName;
	}

	public String getSkill() {
		return skill;
	}

	public String getCountry() {
		return country;
	}

}

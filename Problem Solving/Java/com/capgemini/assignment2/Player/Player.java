package com.capgemini.assignment2.Player;

public class Player {
private String name, country, skill;

	Player(String name, String country, String skill) {
		this.name = name;
		this.country = country;
		this.skill = skill;
	}

	public String getName() {
		return name;
	}

	public String getCountry() {
		return country;
	}

	public String getSkill() {
		return skill;
	}
	
	
}

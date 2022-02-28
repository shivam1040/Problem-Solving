package com.capgemini.assignment2.PlayerSkill;

public class PlayerSkill {
	private String name, country;
	private Skill skill;
	
	PlayerSkill(String name, String country, Skill skill){
		this.name=name;
		this.country=country;
		this.skill=skill;
	}

	public String getName() {
		return name;
	}


	public String getCountry() {
		return country;
	}


	public Skill getSkill() {
		return skill;
	}
	
	
}

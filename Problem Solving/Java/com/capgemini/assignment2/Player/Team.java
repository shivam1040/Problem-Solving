package com.capgemini.assignment2.Player;

class Team{
	private String name;
	private Player player;
	
	Team(String name, Player player) {
		this.name = name;
		this.player = player;
	}

	public String getName() {
		return name;
	}

	public Player getPlayer() {
		return player;
	}
}

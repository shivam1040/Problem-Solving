package com.capgemini.assignment2.Player;

class TeamBO{
	public Team createTeam(String data, Player[] PlayerList) {
		String temp=data.substring(0, data.indexOf(','));
		for(Player i:PlayerList) {
			if(i.getName().equals(data.substring(data.indexOf(',')+1, data.length()))) {
				return new Team(temp, i);
			}
		}
		return null;
	}
}

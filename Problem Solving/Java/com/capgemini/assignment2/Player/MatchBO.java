package com.capgemini.assignment2.Player;

class MatchBO{
	public Match createMatch(String data, Team[] teamList) {
		Team obj1=null, obj2=null;
		for(Team i:teamList) {
			if(i.getName().equals(data.substring(data.indexOf(',')+1, data.indexOf(',', data.indexOf(',')+1)).trim())) {
				obj1=i;
			}
			else if(i.getName().equals(data.substring(data.indexOf(',', data.indexOf(',')+1)+1, data.lastIndexOf(',')).trim())) {
				obj2=i;
			}
		}
		return new Match(data.substring(0, data.indexOf(',')), data.substring(data.lastIndexOf(',')+1, data.length()), obj1, obj2);
	}
	
	public void findTeam(String matchDate, Match[] matchList) {
		System.out.println("Team");
		for(Match i:matchList) {
			if(i.getDate().equals(matchDate)) 
				System.out.println(i.getTeamone().getName()+", "+i.getTeamtwo().getName());
		}
	}
	
	public void findAllMatchesOfTeam(String teamName, Match[] matchList) {
		System.out.printf("%s %15s %15s %15s %n", "Date", "TeamOne", "TeamTwo", "Venue");
		for(Match i:matchList) {
			if(i.getTeamone().getName().equals(teamName) || i.getTeamtwo().getName().equals(teamName)) {
				int a=(19-i.getDate().length())-(7-i.getTeamone().getName().length());
				int b=(22-i.getTeamone().getName().length())-(7-i.getTeamtwo().getName().length());
				int c=(20-i.getTeamtwo().getName().length())-(5-i.getVenue().length());
				String temp="%s %"+String.valueOf(a)+"s %"+String.valueOf(b)+"s %"+String.valueOf(c)+"s %n";
				System.out.printf(temp, i.getDate(), i.getTeamone().getName(), i.getTeamtwo().getName(), i.getVenue());
			}
		}
	}
}

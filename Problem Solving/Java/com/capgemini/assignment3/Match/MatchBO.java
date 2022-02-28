package com.capgemini.assignment3.Match;

class MatchBO{
	void printAllMatchDetails(Match[] MatchList) {
		System.out.printf("%n%s%n%s %15s %15s %15s %15s %15s %n", "Match Details", "Date", "Team1", "Team2", "Venue", "Status", "Winner");
		for(Match i:MatchList) {
			System.out.printf("%s %"+String.valueOf((19-i.getDate().length())-(5-i.getTeamOne().length()))+"s %"+String.valueOf((20-i.getTeamOne().length())-(5-i.getTeamTwo().length()))+"s %"+String.valueOf((20-i.getTeamTwo().length())-(5-i.getVenue().length()))+"s %"+String.valueOf((20-i.getVenue().length())-(6-i.getOutcome().getStatus().length()))+"s %"+String.valueOf((21-i.getOutcome().getStatus().length())-(6-i.getOutcome().getWinnerTeam().length()))+"s %n", i.getDate(), i.getTeamOne(), i.getTeamTwo(), i.getVenue(), i.getOutcome().getStatus(), i.getOutcome().getWinnerTeam());
		}
	}
	
	void printMatchDetailsWithOutcomeStatus(Match[] MatchList, String outcomeStatus) {
		System.out.printf("%n%s%n%s %15s %15s %15s %15s %15s %n", "Match Details", "Date", "Team1", "Team2", "Venue", "Status", "Winner");
		for(Match i:MatchList) {
			if(i.getOutcome().getStatus().equals(outcomeStatus))
				System.out.printf("%s %"+String.valueOf((19-i.getDate().length())-(5-i.getTeamOne().length()))+"s %"+String.valueOf((20-i.getTeamOne().length())-(5-i.getTeamTwo().length()))+"s %"+String.valueOf((20-i.getTeamTwo().length())-(5-i.getVenue().length()))+"s %"+String.valueOf((20-i.getVenue().length())-(6-i.getOutcome().getStatus().length()))+"s %"+String.valueOf((21-i.getOutcome().getStatus().length())-(6-i.getOutcome().getWinnerTeam().length()))+"s %n", i.getDate(), i.getTeamOne(), i.getTeamTwo(), i.getVenue(), i.getOutcome().getStatus(), i.getOutcome().getWinnerTeam());
		}
	}
	
	void printMatchDetailsWithOutcomeWinnerTeam(Match[] MatchList, String outcomeWinnerTeam) {
		System.out.printf("%n%s%n%s %15s %15s %15s %15s %15s %n", "Match Details", "Date", "Team1", "Team2", "Venue", "Status", "Winner");
		for(Match i:MatchList) {
			if(i.getOutcome().getWinnerTeam().equals(outcomeWinnerTeam))
				System.out.printf("%s %"+String.valueOf((19-i.getDate().length())-(5-i.getTeamOne().length()))+"s %"+String.valueOf((20-i.getTeamOne().length())-(5-i.getTeamTwo().length()))+"s %"+String.valueOf((20-i.getTeamTwo().length())-(5-i.getVenue().length()))+"s %"+String.valueOf((20-i.getVenue().length())-(6-i.getOutcome().getStatus().length()))+"s %"+String.valueOf((21-i.getOutcome().getStatus().length())-(6-i.getOutcome().getWinnerTeam().length()))+"s %n", i.getDate(), i.getTeamOne(), i.getTeamTwo(), i.getVenue(), i.getOutcome().getStatus(), i.getOutcome().getWinnerTeam());
		}
	}
}

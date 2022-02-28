package com.capgemini.assignment2.PlayerSkill;

class PlayerBO{
	public void viewDetails(PlayerSkill[] playerList) {
		System.out.printf("%s %15s %15s %n", "Player", "Country", "Skill");
		for(PlayerSkill i:playerList) {
			String temp="%s %"+String.valueOf((21-i.getName().length())-(7-i.getCountry().length()))+"s "+"%"+String.valueOf((22-i.getCountry().length())-(5-i.getSkill().getSkillName().length()))+"s %n";
			System.out.printf(temp, i.getName(), i.getCountry(), i.getSkill().getSkillName());
		}
	}
	
	public void printPlayerDetailsWithSkill(PlayerSkill[] playerList, String skill) {
		int count=-1;
		for(PlayerSkill i:playerList) {
			if(i.getSkill().getSkillName().equals(skill)) {
				if(count==-1) {
					System.out.printf("%s %15s %15s %n", "Player", "Country", "Skill");
					count++;
				}
				String temp="%s %"+String.valueOf((21-i.getName().length())-(7-i.getCountry().length()))+"s "+"%"+String.valueOf((22-i.getCountry().length())-(5-i.getSkill().getSkillName().length()))+"s %n";
				System.out.printf(temp, i.getName(), i.getCountry(), i.getSkill().getSkillName());
				count++;
			}
		}
		if(count==-1) {
			System.out.println("Skill not found");
		}
	}
}

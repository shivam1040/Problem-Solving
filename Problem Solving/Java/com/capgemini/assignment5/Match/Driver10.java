package com.capgemini.assignment5.Match;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

class Driver10{
	public static void main(String args[]) {
				try {
					InputStream fileObj = new FileInputStream(".\\src\\main\\java\\com\\capgemini\\assignment5\\matches.txt");
					InputStreamReader reader = new InputStreamReader(fileObj); 
					List<Match> output=new MatchFileStore().obtainMatchFromFile(reader);
					System.out.println("The Match Details are:");
					for(int i=0; i<output.size(); i++) 
						System.out.println("\nMatch"+(i+1)+"\nTeamOne : "+output.get(i).getTeamOne()+"\nTeamTwo : "+output.get(i).getTeamTwo()+"\nVenue : "+output.get(i).getVenue()+"\nMatchDate : "+output.get(i).getMatchDate());
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}


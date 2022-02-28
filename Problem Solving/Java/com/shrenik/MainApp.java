/*
using stream methods for data interpretation
*/

package com.shrenik;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.shrenik.ex1.Player;

public class MainApp {

	public static void main(String[] args) {
		
		List<Player> players = Arrays.asList(
				new Player(191, "Mith", 80),
				new Player(193, "Nitin", 17),
				new Player(188, "John", 27),
				new Player(103, "Peter", 38),
				new Player(101, "Manish", 91)
				);
		
		
		//Q1. Modify player runs adding 10 runs more in existing data
		List<Player> modified = players.stream().map(t -> {
				t.setTotalRuns(t.getTotalRuns()+10);
				return t;
		}).collect(Collectors.toList());
		
		//System.out.println("modified = " + modified);
		
		//Q2. Find player by Name
		
		List<Player> searchQuery=players.stream().filter(t -> t.getPlayerName().equals("John")).collect(Collectors.toList());
		searchQuery=players.stream().filter(t -> t.getPlayerId()==191).collect(Collectors.toList());
		searchQuery=players.stream().filter(t -> t.getTotalRuns()>40).collect(Collectors.toList());
		System.out.println(searchQuery);
		//Q3. Find player by playerid
		//Q4. Filter Player by runs more than 40
		
		
		//prerequisite - Function, BiFunction, Predicate, BiPredicate
		//new functions - skip, filter, map, find, reduce

	}

}


/* 
for(int i=0;i<players.size();i++)
{
	Player temp = players.get(i);
	temp.setTotalRuns(temp.getTotalRuns()+ 10);
	players.set(i, temp);
}
*/
package com.capgemini.assignment5.SortingPlayers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

class SortingPlayers{
	public static void main(String args[]) {
		//File directory = new File("./");
		//System.out.println(directory.getAbsolutePath());
		File fileObj = new File(".\\src\\main\\java\\com\\capgemini\\assignment5\\SortingPlayers.txt");
		try {
		BufferedReader brObj= new BufferedReader(new FileReader(fileObj));
		List<Players> playersList=new FileUtility().readFileData(brObj);
		brObj.close();
		new FileUtility().writeDataToFile(playersList);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
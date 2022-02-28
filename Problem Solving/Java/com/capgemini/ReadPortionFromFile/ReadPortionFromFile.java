package com.capgemini.ReadPortionFromFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class ReadPortionFromFile {
	public static void main(String args[]) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter start and end index:");
		try {
		int start=Integer.parseInt(reader.readLine()), end=Integer.parseInt(reader.readLine());
		File fileObj = new File(".\\src\\main\\java\\com\\capgemini\\ReadPortionFromFile\\outcome.txt");
		reader= new BufferedReader(new FileReader(fileObj));
		int countStart=0;
		int data=reader.read();
		System.out.println();
		while(data!=-1 && countStart<=end) {
			countStart++;
			if(countStart>=start) 
				System.out.print((char) data);
			data=reader.read();
		}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}

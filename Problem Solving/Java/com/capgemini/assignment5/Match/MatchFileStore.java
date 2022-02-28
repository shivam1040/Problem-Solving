package com.capgemini.assignment5.Match;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class MatchFileStore{
	List<Match> obtainMatchFromFile(InputStreamReader obj){
		List<Match> output=new ArrayList<Match>();
		try{
		int data=obj.read();
		String temp="";
	     while (data != -1) {  
	    	 temp+=(char) data;
             if((char) data=='\n') {
            	 output.add(new Match(temp.substring(0, 5), temp.substring(5, 10), temp.substring(10, 30), temp.substring(30, 40))); 
            	 System.out.println(temp);
            	 temp="";
            			 }
             data = obj.read();  
             if(data==-1) {
            	 output.add(new Match(temp.substring(0, 5), temp.substring(5, 10), temp.substring(10, 30), temp.substring(30, 40)));
            			 }
         }
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return output;
	}
}

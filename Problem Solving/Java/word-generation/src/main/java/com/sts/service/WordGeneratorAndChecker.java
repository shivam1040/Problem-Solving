package com.sts.service;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.sts.WordGenerationApplication;


@Service
public class WordGeneratorAndChecker {
	
	private boolean check(String word) {
		return WordGenerationApplication.ternarySearchTree.search(word);
	}
	
	public String generator(String word1, String word2) {
		String temp1="";
		String temp2="";
		for(int i=0; i<word1.length(); i++) {
			temp1+=word1.charAt(i);
			for(int j=word2.length()-1; j>=0; j--) {
				temp2=word2.charAt(j)+temp2;
				if(check(temp1+temp2))
					return temp1+temp2;
			}
			temp2="";
		}
		return "no words found";
	}
	
	public Map<String, Set<String>> generatorAll(String word1, String word2, Map<String, Set<String>> map) {
		String temp1="";
		String temp2="";
		for(int i=0; i<word1.length(); i++) {
			temp1+=word1.charAt(i);
			for(int j=word2.length()-1; j>=0; j--) {
				temp2=word2.charAt(j)+temp2;
				if(check(temp1+temp2)) {
					//System.out.println(temp1+temp2);
					Set<String> temp;
					if(map.get(word1+"|"+word2)!=null)
						temp=map.get(word1+"|"+word2);
					else
						temp=new HashSet<String>();
					temp.add(temp1+temp2);
					map.put(word1+"|"+word2, temp);
				}
			}
			temp2="";
		}
		return map;
	}
	
}

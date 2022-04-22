package com.sts.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sts.service.WordGeneratorAndChecker;

@RestController
public class Controller {
	@Autowired
	private WordGeneratorAndChecker wordGeneratorAndChecker;
	
	@GetMapping("/api/{word1}/{word2}")
	public ResponseEntity get(@PathVariable String word1, @PathVariable String word2){
		Map<String, String> map=new HashMap<String, String>();
		String temp=wordGeneratorAndChecker.generator(word1, word2);
		if(temp.equals("no words found"))
			return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.APPLICATION_JSON).body("no words found");
		map.put(word1+"|"+word2, temp);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(map);
	}
	
	@GetMapping("/api1/{word1}/{word2}")
	public ResponseEntity getAll(@PathVariable String word1, @PathVariable String word2){
		Map<String, Set<String>> map=new HashMap<String, Set<String>>();
		wordGeneratorAndChecker.generatorAll(word1, word2, map);
		if(map.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.APPLICATION_JSON).body("no words found");
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(map);
	}
}

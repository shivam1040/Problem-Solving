package com.sts;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sts.service.TernarySearchTree;

@SpringBootApplication
public class WordGenerationApplication {
	public static TernarySearchTree ternarySearchTree;
	public static void main(String[] args) {
		SpringApplication.run(WordGenerationApplication.class, args);
	}
	
	@PostConstruct
	private void createTST() {
		ternarySearchTree=new TernarySearchTree();
		try (Stream<String> stream = Files.lines(Paths.get("src/main/resources/word_dictionaryec82533.txt"))) {

			stream.forEach(a -> ternarySearchTree.insert(a));

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("caching done");
	}

}

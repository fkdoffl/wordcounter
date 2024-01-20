package com.synechron.wordcounter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.synechron.wordcounter","com.google.cloud.translate.Translate"})
public class WordCounterApplication {

	public static void main(String[] args) {
		SpringApplication.run(WordCounterApplication.class, args);
	}

}

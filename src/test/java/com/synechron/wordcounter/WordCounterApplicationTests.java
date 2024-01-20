package com.synechron.wordcounter;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class WordCounterApplicationTests {

	@Test
	void contextLoads() {
	}

	@InjectMocks
	private WordCounterTest wordCounterTest;

	public void WordCounterTest() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void addWords_shouldIncrementWordCount() {
		wordCounterTest.addWords("flower","flor","blume");
		assertEquals(3, wordCounterTest.getWordCount("flower"));
	}

	@Test
	void addWords_shouldNotCountNonAlphabeticCharacters() {
		wordCounterTest.addWords("flower123", "1234", "!@#$%");
		assertEquals(0, wordCounterTest.getWordCount("flower123"));
		assertEquals(0, wordCounterTest.getWordCount("1234"));
		assertEquals(0, wordCounterTest.getWordCount("!@#$%"));
	}

}

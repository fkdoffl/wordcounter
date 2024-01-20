package com.synechron.wordcounter;

import com.synechron.wordcounter.repository.Translator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

public class WordCounterTest {

    @Autowired
    private Translator translator;

    private final ConcurrentHashMap<String, Integer> wordCounts = new ConcurrentHashMap<>();
    public void addWords(String flower, String flor, String blume) {
        List<String> words = new ArrayList<>();
        words.add(flower);
        words.add(flor);
        words.add(blume);
        for (String word : words) {
            // Reject non-alphabetic characters
            if (word.matches("^[a-zA-Z]+$")) {
                String translatedWord = getTranslated(word);
                String normalizedWord = translatedWord.toLowerCase();
                wordCounts.merge(normalizedWord, 1, Integer::sum);
            }
        }
    }

    private String getTranslated(String word) {
        AtomicReference<String> translatedString = new AtomicReference<>("");
        Map<String, String> translations = new HashMap<>();
        translations.put("flower", "flower");
        translations.put("flor", "flower");
        translations.put("blume", "flower");
        translations.forEach((k,v) -> {
            if(word.matches(k)) {
                translatedString.set(v);
            }
        });
        return translatedString.get();
    }

    public int getWordCount(String word) {
        return wordCounts.getOrDefault(word.toLowerCase(), 0);
    }
}

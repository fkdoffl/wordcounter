package com.synechron.wordcounter.service;

import com.synechron.wordcounter.repository.Translator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class WordCounterService {

    @Autowired
    private Translator translator;
    private final ConcurrentHashMap<String, Integer> wordCounts = new ConcurrentHashMap<>();

    public void addWords(List<String> words) throws IOException {
        for (String word : words) {
            // Reject non-alphabetic characters
            if (isValidWord(word)) {
//                String translatedWord = translator.translate(word);
                String translatedWord = getTranslated(word);
                String normalizedWord = translatedWord == null ? word.toLowerCase() :
                        translatedWord.toLowerCase();
                wordCounts.merge(normalizedWord, 1, Integer::sum);
            }
        }
    }

    private boolean isValidWord(String word) {
        return word.matches("^[a-zA-Z]+$");
    }

    private String getTranslated(String word) throws IOException {
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

    public int getWordCount(String word) throws IOException {
        String translatedWord = getTranslated(word);
        return wordCounts.getOrDefault(translatedWord == null ? word.toLowerCase() :
                translatedWord.toLowerCase(), 0);
    }
}

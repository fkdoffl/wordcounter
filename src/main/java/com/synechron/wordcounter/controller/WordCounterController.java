package com.synechron.wordcounter.controller;

import com.synechron.wordcounter.service.WordCounterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/word-counter")
public class WordCounterController {

    @Autowired
    private WordCounterService wordCounterService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @PostMapping(value = "/add-words", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String,Integer>> addWords(@RequestBody List<String> words, @RequestParam String word) {
        Map<String,Integer> response = new HashMap<>();
        int wordCount = 0;
        try {
            wordCounterService.addWords(words);
            wordCount = wordCounterService.getWordCount(word);
            response.put("wordCount", wordCount);
        }
        catch (Exception e) {
            logger.error(e.getMessage());
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/word-count/{word}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String,Integer>> getWordCount(@PathVariable String word) throws IOException {
        Map<String,Integer> response = new HashMap<>();
        int count = wordCounterService.getWordCount(word);
        response.put("wordCount", count);
        return ResponseEntity.ok(response);
    }
}

package com.synechron.wordcounter.controller;

import com.synechron.wordcounter.service.WordCounterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/word-counter")
public class WordCounterController {

    @Autowired
    private WordCounterService wordCounterService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @PostMapping(value = "/add-words", produces = MediaType.APPLICATION_JSON_VALUE)
    public int addWords(@RequestBody String[] words, @RequestParam String word) {
        int wordCount = 0;
        try {
            wordCounterService.addWords(words);
            wordCount = wordCounterService.getWordCount(word);
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return wordCount;
    }

    @GetMapping(value = "/word-count/{word}", produces = MediaType.APPLICATION_JSON_VALUE)
    public int getWordCount(@PathVariable String word) throws IOException {
        return wordCounterService.getWordCount(word);
    }
}

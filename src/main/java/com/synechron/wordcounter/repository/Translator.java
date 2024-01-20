package com.synechron.wordcounter.repository;

import org.springframework.stereotype.Component;

@Component
public interface Translator {
    String translate(String word);
}

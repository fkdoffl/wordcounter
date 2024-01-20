package com.synechron.wordcounter.service;

import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import com.synechron.wordcounter.repository.Translator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class ExternalTranslator implements Translator {

    @Autowired
    Translate translate;

//    public ExternalTranslator() throws IOException {
//        // Load the credentials file
//        // Replace "path/to/your/credentials.json" with the actual path to your JSON key file
//
//        this.translate = TranslateOptions.newBuilder()
//                .setCredentials(ServiceAccountCredentials.fromStream(
//                        new FileInputStream("path/to/your/credentials.json")))
//                .build().getService();
//    }

    @Override
    public String translate(String word) {
        String translatedWord = translateToEnglish(word);
        return word;
    }

    private String translateToEnglish(String text) {
        Translation translation = translate.translate(text, Translate.TranslateOption.targetLanguage("en"));
        return translation.getTranslatedText();
    }
}

package com.synechron.wordcounter.configuration;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.synechron.wordcounter.service.ExternalTranslator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TranslateConfig {

    @Bean
    public Translate translate() {
        return TranslateOptions.getDefaultInstance().getService();
    }
}

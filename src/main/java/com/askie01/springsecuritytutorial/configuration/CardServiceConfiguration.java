package com.askie01.springsecuritytutorial.configuration;

import com.askie01.springsecuritytutorial.repository.CardRepository;
import com.askie01.springsecuritytutorial.service.CardService;
import com.askie01.springsecuritytutorial.service.DefaultCardService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class CardServiceConfiguration {

    @Bean
    @Primary
    @ConditionalOnProperty(
            name = "component.service.card",
            havingValue = "default",
            matchIfMissing = true
    )
    public CardService defaultCardService(CardRepository repository) {
        return new DefaultCardService(repository);
    }
}

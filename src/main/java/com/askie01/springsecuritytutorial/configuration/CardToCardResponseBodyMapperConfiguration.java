package com.askie01.springsecuritytutorial.configuration;

import com.askie01.springsecuritytutorial.mapper.CardToCardResponseBodyMapper;
import com.askie01.springsecuritytutorial.mapper.DefaultCardToCardResponseBodyMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class CardToCardResponseBodyMapperConfiguration {

    @Bean
    @Primary
    @ConditionalOnProperty(
            name = "component.mapper.card-to-card-response-body",
            havingValue = "default",
            matchIfMissing = true
    )
    public CardToCardResponseBodyMapper defaultCardToCardResponseBodyMapper() {
        return new DefaultCardToCardResponseBodyMapper();
    }
}

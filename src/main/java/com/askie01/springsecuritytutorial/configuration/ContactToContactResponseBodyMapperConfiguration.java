package com.askie01.springsecuritytutorial.configuration;

import com.askie01.springsecuritytutorial.mapper.ContactToContactResponseBodyMapper;
import com.askie01.springsecuritytutorial.mapper.DefaultContactToContactResponseBodyMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ContactToContactResponseBodyMapperConfiguration {

    @Bean
    @Primary
    @ConditionalOnProperty(
            name = "component.mapper.contact-to-contact-response-body",
            havingValue = "default",
            matchIfMissing = true
    )
    public ContactToContactResponseBodyMapper defaultContactToContactResponseBodyMapper() {
        return new DefaultContactToContactResponseBodyMapper();
    }
}

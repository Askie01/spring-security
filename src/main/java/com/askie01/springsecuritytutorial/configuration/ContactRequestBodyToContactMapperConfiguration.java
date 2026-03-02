package com.askie01.springsecuritytutorial.configuration;

import com.askie01.springsecuritytutorial.mapper.ContactRequestBodyToContactMapper;
import com.askie01.springsecuritytutorial.mapper.DefaultContactRequestBodyToContactMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ContactRequestBodyToContactMapperConfiguration {

    @Bean
    @Primary
    @ConditionalOnProperty(
            name = "component.mapper.contact-request-body-to-contact",
            havingValue = "default",
            matchIfMissing = true
    )
    public ContactRequestBodyToContactMapper defaultContactRequestBodyToContactMapper() {
        return new DefaultContactRequestBodyToContactMapper();
    }
}

package com.askie01.springsecuritytutorial.configuration;

import com.askie01.springsecuritytutorial.mapper.ContactRequestBodyToContactMapper;
import com.askie01.springsecuritytutorial.repository.ContactRepository;
import com.askie01.springsecuritytutorial.service.ContactService;
import com.askie01.springsecuritytutorial.service.DefaultContactService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ContactServiceConfiguration {

    @Bean
    @Primary
    @ConditionalOnProperty(
            name = "component.service.contact",
            havingValue = "default",
            matchIfMissing = true
    )
    public ContactService defaultContactService(ContactRepository repository,
                                                ContactRequestBodyToContactMapper contactMapper) {
        return new DefaultContactService(repository, contactMapper);
    }
}

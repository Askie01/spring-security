package com.askie01.springsecuritytutorial.configuration;

import com.askie01.springsecuritytutorial.mapper.CustomerToCustomerResponseBodyMapper;
import com.askie01.springsecuritytutorial.mapper.DefaultCustomerToCustomerResponseBodyMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class CustomerToCustomerResponseBodyMapperConfiguration {

    @Bean
    @Primary
    @ConditionalOnProperty(
            name = "component.mapper.customer-to-customer-response-body",
            havingValue = "default",
            matchIfMissing = true
    )
    public CustomerToCustomerResponseBodyMapper defaultCustomerToCustomerResponseBodyMapper() {
        return new DefaultCustomerToCustomerResponseBodyMapper();
    }
}

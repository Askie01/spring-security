package com.askie01.springsecuritytutorial.configuration;

import com.askie01.springsecuritytutorial.repository.LoanRepository;
import com.askie01.springsecuritytutorial.service.DefaultLoanService;
import com.askie01.springsecuritytutorial.service.LoanService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class LoanServiceConfiguration {

    @Bean
    @Primary
    @ConditionalOnProperty(
            name = "component.service.loan",
            havingValue = "default",
            matchIfMissing = true
    )
    public LoanService defaultLoanService(LoanRepository repository) {
        return new DefaultLoanService(repository);
    }
}

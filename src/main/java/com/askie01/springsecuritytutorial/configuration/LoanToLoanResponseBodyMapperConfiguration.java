package com.askie01.springsecuritytutorial.configuration;

import com.askie01.springsecuritytutorial.mapper.DefaultLoanToLoanResponseBodyMapper;
import com.askie01.springsecuritytutorial.mapper.LoanToLoanResponseBodyMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class LoanToLoanResponseBodyMapperConfiguration {

    @Bean
    @Primary
    @ConditionalOnProperty(
            name = "component.mapper.loan-to-loan-response-body",
            havingValue = "default",
            matchIfMissing = true
    )
    public LoanToLoanResponseBodyMapper defaultLoanToLoanResponseBodyMapper() {
        return new DefaultLoanToLoanResponseBodyMapper();
    }
}

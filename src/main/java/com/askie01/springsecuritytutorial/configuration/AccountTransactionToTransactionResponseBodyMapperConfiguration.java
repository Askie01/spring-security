package com.askie01.springsecuritytutorial.configuration;

import com.askie01.springsecuritytutorial.mapper.AccountTransactionToTransactionResponseBodyMapper;
import com.askie01.springsecuritytutorial.mapper.DefaultAccountTransactionToTransactionResponseBodyMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AccountTransactionToTransactionResponseBodyMapperConfiguration {

    @Bean
    @Primary
    @ConditionalOnProperty(
            name = "component.mapper.account-transaction-to-transaction-response-body",
            havingValue = "default",
            matchIfMissing = true
    )
    public AccountTransactionToTransactionResponseBodyMapper defaultAccountTransactionToTransactionResponseBodyMapper() {
        return new DefaultAccountTransactionToTransactionResponseBodyMapper();
    }
}

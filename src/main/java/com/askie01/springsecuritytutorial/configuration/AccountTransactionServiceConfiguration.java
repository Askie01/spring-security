package com.askie01.springsecuritytutorial.configuration;

import com.askie01.springsecuritytutorial.repository.AccountTransactionRepository;
import com.askie01.springsecuritytutorial.service.AccountTransactionService;
import com.askie01.springsecuritytutorial.service.DefaultAccountTransactionService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AccountTransactionServiceConfiguration {

    @Bean
    @Primary
    @ConditionalOnProperty(
            name = "component.service.account-transaction",
            havingValue = "default",
            matchIfMissing = true
    )
    public AccountTransactionService defaultAccountTransactionService(AccountTransactionRepository repository) {
        return new DefaultAccountTransactionService(repository);
    }
}

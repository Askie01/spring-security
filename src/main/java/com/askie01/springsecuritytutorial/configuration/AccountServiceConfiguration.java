package com.askie01.springsecuritytutorial.configuration;

import com.askie01.springsecuritytutorial.repository.AccountRepository;
import com.askie01.springsecuritytutorial.service.AccountService;
import com.askie01.springsecuritytutorial.service.DefaultAccountService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AccountServiceConfiguration {

    @Bean
    @Primary
    @ConditionalOnProperty(
            name = "component.service.account",
            havingValue = "default",
            matchIfMissing = true
    )
    public AccountService defaultAccountService(AccountRepository accountRepository) {
        return new DefaultAccountService(accountRepository);
    }
}

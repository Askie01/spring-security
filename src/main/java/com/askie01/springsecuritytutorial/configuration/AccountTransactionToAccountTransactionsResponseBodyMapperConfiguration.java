package com.askie01.springsecuritytutorial.configuration;

import com.askie01.springsecuritytutorial.mapper.AccountToAccountResponseBodyMapper;
import com.askie01.springsecuritytutorial.mapper.AccountTransactionToAccountTransactionsResponseBodyMapper;
import com.askie01.springsecuritytutorial.mapper.AccountTransactionToTransactionResponseBodyMapper;
import com.askie01.springsecuritytutorial.mapper.DefaultAccountTransactionToAccountTransactionsResponseBodyMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AccountTransactionToAccountTransactionsResponseBodyMapperConfiguration {

    @Bean
    @Primary
    @ConditionalOnProperty(
            name = "component.mapper.account-transaction-to-account-transactions-response-body",
            havingValue = "default",
            matchIfMissing = true
    )
    public AccountTransactionToAccountTransactionsResponseBodyMapper defaultAccountTransactionToAccountTransactionsResponseBodyMapper(AccountToAccountResponseBodyMapper accountMapper,
                                                                                                                                      AccountTransactionToTransactionResponseBodyMapper transactionMapper) {
        return new DefaultAccountTransactionToAccountTransactionsResponseBodyMapper(accountMapper, transactionMapper);
    }
}

package com.askie01.springsecuritytutorial.mapper;

import com.askie01.springsecuritytutorial.dto.AccountResponseBody;
import com.askie01.springsecuritytutorial.dto.AccountTransactionsResponseBody;
import com.askie01.springsecuritytutorial.dto.TransactionResponseBody;
import com.askie01.springsecuritytutorial.model.Account;
import com.askie01.springsecuritytutorial.model.AccountTransaction;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class DefaultAccountTransactionToAccountTransactionsResponseBodyMapper
        implements AccountTransactionToAccountTransactionsResponseBodyMapper {

    private final AccountToAccountResponseBodyMapper accountMapper;
    private final AccountTransactionToTransactionResponseBodyMapper transactionMapper;

    @Override
    public AccountTransactionsResponseBody mapToDTO(List<AccountTransaction> accountTransactions) {
        final Account account = accountTransactions.getFirst().getAccount();
        final AccountResponseBody accountResponseBody = accountMapper.mapToDTO(account);
        final List<TransactionResponseBody> transactions = accountTransactions.stream()
                .map(transactionMapper::mapToDTO)
                .collect(Collectors.toCollection(ArrayList::new));
        return AccountTransactionsResponseBody.builder()
                .account(accountResponseBody)
                .transactions(transactions)
                .build();
    }
}

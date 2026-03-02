package com.askie01.springsecuritytutorial.service;

import com.askie01.springsecuritytutorial.model.AccountTransaction;
import com.askie01.springsecuritytutorial.repository.AccountTransactionRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class DefaultAccountTransactionService implements AccountTransactionService {

    private final AccountTransactionRepository repository;

    @Override
    public List<AccountTransaction> getAccountTransactions(Long accountNumber) {
        return repository.findAccountTransactions(accountNumber);
    }
}

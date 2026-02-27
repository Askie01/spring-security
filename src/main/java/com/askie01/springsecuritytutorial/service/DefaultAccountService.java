package com.askie01.springsecuritytutorial.service;

import com.askie01.springsecuritytutorial.model.Account;
import com.askie01.springsecuritytutorial.repository.AccountRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultAccountService implements AccountService {

    private final AccountRepository repository;

    @Override
    public Account getAccount(Long accountNumber) {
        return repository
                .findByAccountNumber(accountNumber)
                .orElseThrow(() -> new IllegalArgumentException("Account with number: " + accountNumber + " not found."));
    }
}

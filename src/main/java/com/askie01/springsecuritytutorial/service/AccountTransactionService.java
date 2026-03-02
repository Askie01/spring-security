package com.askie01.springsecuritytutorial.service;

import com.askie01.springsecuritytutorial.model.AccountTransaction;

import java.util.List;

public interface AccountTransactionService {
    List<AccountTransaction> getAccountTransactions(Long accountNumber);
}

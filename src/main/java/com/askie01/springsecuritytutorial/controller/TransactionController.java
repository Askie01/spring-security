package com.askie01.springsecuritytutorial.controller;

import com.askie01.springsecuritytutorial.dto.AccountTransactionsResponseBody;
import com.askie01.springsecuritytutorial.mapper.AccountTransactionToAccountTransactionsResponseBodyMapper;
import com.askie01.springsecuritytutorial.model.AccountTransaction;
import com.askie01.springsecuritytutorial.service.AccountTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final AccountTransactionService service;
    private final AccountTransactionToAccountTransactionsResponseBodyMapper accountTransactionMapper;

    @GetMapping(path = "/{accountNumber}")
    public ResponseEntity<AccountTransactionsResponseBody> getAccountTransactions(@PathVariable Long accountNumber) {
        final List<AccountTransaction> accountTransactions = service.getAccountTransactions(accountNumber);
        final AccountTransactionsResponseBody responseBody = accountTransactionMapper.mapToDTO(accountTransactions);
        return ResponseEntity.ok(responseBody);
    }
}

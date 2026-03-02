package com.askie01.springsecuritytutorial.mapper;

import com.askie01.springsecuritytutorial.dto.TransactionResponseBody;
import com.askie01.springsecuritytutorial.model.AccountTransaction;

import java.time.LocalDateTime;

public class DefaultAccountTransactionToTransactionResponseBodyMapper
        implements AccountTransactionToTransactionResponseBodyMapper {

    @Override
    public TransactionResponseBody mapToDTO(AccountTransaction accountTransaction) {
        final TransactionResponseBody transactionResponseBody = new TransactionResponseBody();
        map(accountTransaction, transactionResponseBody);
        return transactionResponseBody;
    }

    @Override
    public void map(AccountTransaction source, TransactionResponseBody target) {
        mapTitle(source, target);
        mapType(source, target);
        mapAmount(source, target);
        mapClosingBalance(source, target);
        mapDate(source, target);
    }

    private void mapTitle(AccountTransaction source, TransactionResponseBody target) {
        final String title = source.getTitle();
        target.setTitle(title);
    }

    private void mapType(AccountTransaction source, TransactionResponseBody target) {
        final String type = source.getTransactionType();
        target.setType(type);
    }

    private void mapAmount(AccountTransaction source, TransactionResponseBody target) {
        final Double amount = source.getAmount();
        target.setAmount(amount);
    }

    private void mapClosingBalance(AccountTransaction source, TransactionResponseBody target) {
        final Double closingBalance = source.getClosingBalance();
        target.setClosingBalance(closingBalance);
    }

    private void mapDate(AccountTransaction source, TransactionResponseBody target) {
        final LocalDateTime date = source.getCreatedAt();
        target.setDate(date);
    }
}

package com.askie01.springsecuritytutorial.service;

import com.askie01.springsecuritytutorial.model.Loan;
import com.askie01.springsecuritytutorial.repository.LoanRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class DefaultLoanService implements LoanService {

    private final LoanRepository repository;

    @Override
    public List<Loan> getAccountLoans(Long accountNumber) {
        return repository.findByAccountNumber(accountNumber);
    }
}

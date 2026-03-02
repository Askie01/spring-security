package com.askie01.springsecuritytutorial.service;

import com.askie01.springsecuritytutorial.model.Loan;

import java.util.List;

public interface LoanService {
    List<Loan> getAccountLoans(Long accountNumber);
}

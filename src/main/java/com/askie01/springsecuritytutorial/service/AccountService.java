package com.askie01.springsecuritytutorial.service;

import com.askie01.springsecuritytutorial.model.Account;

public interface AccountService {
    Account getAccount(Long accountNumber);
}

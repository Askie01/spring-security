package com.askie01.springsecuritytutorial.controller;

import com.askie01.springsecuritytutorial.dto.AccountResponseBody;
import com.askie01.springsecuritytutorial.mapper.AccountToAccountResponseBodyMapper;
import com.askie01.springsecuritytutorial.model.Account;
import com.askie01.springsecuritytutorial.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService service;
    private final AccountToAccountResponseBodyMapper accountMapper;

    @GetMapping
    public ResponseEntity<String> getAccount() {
        final String accountDetails = "Account Details";
        return new ResponseEntity<>(accountDetails, HttpStatus.OK);
    }

    @GetMapping("/{accountNumber}/details")
    public ResponseEntity<AccountResponseBody> getAccountDetails(@PathVariable Long accountNumber) {
        final Account account = service.getAccount(accountNumber);
        final AccountResponseBody responseBody = accountMapper.mapToDTO(account);
        return ResponseEntity.ok(responseBody);
    }
}

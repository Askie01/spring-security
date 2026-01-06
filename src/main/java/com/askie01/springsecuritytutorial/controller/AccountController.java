package com.askie01.springsecuritytutorial.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/accounts")
public class AccountController {

    @GetMapping
    public ResponseEntity<String> getAccount() {
        final String accountDetails = "Account Details";
        return new ResponseEntity<>(accountDetails, HttpStatus.OK);
    }
}

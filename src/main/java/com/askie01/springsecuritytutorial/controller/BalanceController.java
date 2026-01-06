package com.askie01.springsecuritytutorial.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/balances")
public class BalanceController {

    @GetMapping
    public ResponseEntity<String> getBalance() {
        final String balance = "Balance Details";
        return new ResponseEntity<>(balance, HttpStatus.OK);
    }
}

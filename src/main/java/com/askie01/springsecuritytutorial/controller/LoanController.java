package com.askie01.springsecuritytutorial.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/loans")
public class LoanController {

    @GetMapping
    public ResponseEntity<String> getLoan() {
        final String loan = "Loan Details";
        return new ResponseEntity<>(loan, HttpStatus.OK);
    }
}

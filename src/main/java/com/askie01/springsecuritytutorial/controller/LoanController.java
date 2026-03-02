package com.askie01.springsecuritytutorial.controller;

import com.askie01.springsecuritytutorial.dto.LoanResponseBody;
import com.askie01.springsecuritytutorial.mapper.LoanToLoanResponseBodyMapper;
import com.askie01.springsecuritytutorial.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(path = "/loans")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService service;
    private final LoanToLoanResponseBodyMapper loanMapper;

    @GetMapping
    public ResponseEntity<List<LoanResponseBody>> getLoan(@RequestParam Long accountNumber) {
        final List<LoanResponseBody> responseBody = service
                .getAccountLoans(accountNumber)
                .stream()
                .map(loanMapper::mapToDTO)
                .toList();
        return ResponseEntity
                .ok()
                .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                .body(responseBody);
    }
}

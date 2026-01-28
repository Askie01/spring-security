package com.askie01.springsecuritytutorial.controller;

import com.askie01.springsecuritytutorial.dto.RegisterCustomerRequestBody;
import com.askie01.springsecuritytutorial.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<Void> registerCustomer(@RequestBody RegisterCustomerRequestBody requestBody) {
        customerService.register(requestBody);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

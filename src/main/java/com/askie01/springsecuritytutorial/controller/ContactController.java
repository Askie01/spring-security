package com.askie01.springsecuritytutorial.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/contacts")
public class ContactController {

    @GetMapping
    public ResponseEntity<String> getContact() {
        final String contact = "Contact details";
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }
}

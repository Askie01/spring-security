package com.askie01.springsecuritytutorial.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/welcome")
public class WelcomeController {

    @GetMapping
    public ResponseEntity<String> getWelcomeMessage() {
        final String welcomeMessage = "Welcome to Spring Security Tutorial!";
        return new ResponseEntity<>(welcomeMessage, HttpStatus.OK);
    }
}

package com.askie01.springsecuritytutorial.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/cards")
public class CardController {

    @GetMapping
    public ResponseEntity<String> getCard() {
        final String card = "Card Details";
        return ResponseEntity.ok(card);
    }
}

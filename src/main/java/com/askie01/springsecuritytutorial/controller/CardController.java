package com.askie01.springsecuritytutorial.controller;

import com.askie01.springsecuritytutorial.dto.CardResponseBody;
import com.askie01.springsecuritytutorial.mapper.CardToCardResponseBodyMapper;
import com.askie01.springsecuritytutorial.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService service;
    private final CardToCardResponseBodyMapper cardMapper;

    @GetMapping("/{accountNumber}")
    public ResponseEntity<List<CardResponseBody>> getAccountCards(@PathVariable Long accountNumber) {
        final List<CardResponseBody> cards = service
                .getAccountCards(accountNumber)
                .stream()
                .map(cardMapper::mapToDTO)
                .toList();
        return ResponseEntity.ok(cards);
    }
}

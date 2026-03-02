package com.askie01.springsecuritytutorial.service;

import com.askie01.springsecuritytutorial.model.Card;
import com.askie01.springsecuritytutorial.repository.CardRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class DefaultCardService implements CardService {

    private final CardRepository repository;

    @Override
    public List<Card> getAccountCards(Long accountNumber) {
        return repository.findByAccountNumber(accountNumber);
    }
}

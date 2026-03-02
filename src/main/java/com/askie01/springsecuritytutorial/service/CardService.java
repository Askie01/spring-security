package com.askie01.springsecuritytutorial.service;

import com.askie01.springsecuritytutorial.model.Card;

import java.util.List;

public interface CardService {
    List<Card> getAccountCards(Long accountNumber);
}

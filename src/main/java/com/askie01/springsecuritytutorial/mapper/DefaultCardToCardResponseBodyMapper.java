package com.askie01.springsecuritytutorial.mapper;

import com.askie01.springsecuritytutorial.dto.CardResponseBody;
import com.askie01.springsecuritytutorial.model.Card;

public class DefaultCardToCardResponseBodyMapper implements CardToCardResponseBodyMapper {

    @Override
    public CardResponseBody mapToDTO(Card card) {
        final CardResponseBody cardResponseBody = new CardResponseBody();
        map(card, cardResponseBody);
        return cardResponseBody;
    }

    @Override
    public void map(Card source, CardResponseBody target) {
        mapNumber(source, target);
        mapType(source, target);
        mapLimit(source, target);
        mapUsedAmount(source, target);
        mapBalance(source, target);
    }

    private void mapNumber(Card source, CardResponseBody target) {
        final Long number = source.getCardNumber();
        target.setNumber(number);
    }

    private void mapType(Card source, CardResponseBody target) {
        final String type = source.getCardType();
        target.setType(type);
    }

    private void mapLimit(Card source, CardResponseBody target) {
        final Double limit = source.getTotalLimit();
        target.setLimit(limit);
    }

    private void mapUsedAmount(Card source, CardResponseBody target) {
        final Double usedAmount = source.getAmountUsed();
        target.setUsed(usedAmount);
    }

    private void mapBalance(Card source, CardResponseBody target) {
        final Double balance = source.getAvailableAmount();
        target.setBalance(balance);
    }
}

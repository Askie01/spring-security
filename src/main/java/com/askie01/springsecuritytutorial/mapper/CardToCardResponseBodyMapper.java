package com.askie01.springsecuritytutorial.mapper;

import com.askie01.springsecuritytutorial.dto.CardResponseBody;
import com.askie01.springsecuritytutorial.model.Card;

public interface CardToCardResponseBodyMapper
        extends Mapper<Card, CardResponseBody>,
        ToDTOMapper<Card, CardResponseBody> {
}

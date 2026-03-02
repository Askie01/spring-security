package com.askie01.springsecuritytutorial.mapper;

import com.askie01.springsecuritytutorial.dto.AccountTransactionsResponseBody;
import com.askie01.springsecuritytutorial.model.AccountTransaction;

import java.util.List;

public interface AccountTransactionToAccountTransactionsResponseBodyMapper
        extends ToDTOMapper<List<AccountTransaction>, AccountTransactionsResponseBody> {
}

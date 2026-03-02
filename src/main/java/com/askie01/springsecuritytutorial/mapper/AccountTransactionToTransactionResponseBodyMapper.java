package com.askie01.springsecuritytutorial.mapper;

import com.askie01.springsecuritytutorial.dto.TransactionResponseBody;
import com.askie01.springsecuritytutorial.model.AccountTransaction;

public interface AccountTransactionToTransactionResponseBodyMapper
        extends Mapper<AccountTransaction, TransactionResponseBody>,
        ToDTOMapper<AccountTransaction, TransactionResponseBody> {
}

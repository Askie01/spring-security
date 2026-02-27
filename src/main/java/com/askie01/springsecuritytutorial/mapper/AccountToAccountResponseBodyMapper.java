package com.askie01.springsecuritytutorial.mapper;

import com.askie01.springsecuritytutorial.dto.AccountResponseBody;
import com.askie01.springsecuritytutorial.model.Account;

public interface AccountToAccountResponseBodyMapper
        extends Mapper<Account, AccountResponseBody>,
        ToDTOMapper<Account, AccountResponseBody> {
}

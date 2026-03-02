package com.askie01.springsecuritytutorial.mapper;

import com.askie01.springsecuritytutorial.dto.ContactRequestBody;
import com.askie01.springsecuritytutorial.model.Contact;

public interface ContactRequestBodyToContactMapper
        extends Mapper<ContactRequestBody, Contact>,
        ToEntityMapper<ContactRequestBody, Contact> {
}

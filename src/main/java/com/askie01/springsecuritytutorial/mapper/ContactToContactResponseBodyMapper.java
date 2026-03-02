package com.askie01.springsecuritytutorial.mapper;

import com.askie01.springsecuritytutorial.dto.ContactResponseBody;
import com.askie01.springsecuritytutorial.model.Contact;

public interface ContactToContactResponseBodyMapper
        extends Mapper<Contact, ContactResponseBody>,
        ToDTOMapper<Contact, ContactResponseBody> {
}

package com.askie01.springsecuritytutorial.service;

import com.askie01.springsecuritytutorial.dto.ContactRequestBody;
import com.askie01.springsecuritytutorial.model.Contact;

import java.util.List;

public interface ContactService {
    void createContact(ContactRequestBody requestBody);

    List<Contact> getContacts(String subject);

    List<Contact> getContacts();
}

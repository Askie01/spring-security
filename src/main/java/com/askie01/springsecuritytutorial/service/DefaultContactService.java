package com.askie01.springsecuritytutorial.service;

import com.askie01.springsecuritytutorial.dto.ContactRequestBody;
import com.askie01.springsecuritytutorial.mapper.ContactRequestBodyToContactMapper;
import com.askie01.springsecuritytutorial.model.Contact;
import com.askie01.springsecuritytutorial.repository.ContactRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class DefaultContactService implements ContactService {

    private final ContactRepository repository;
    private final ContactRequestBodyToContactMapper contactMapper;

    @Override
    public void createContact(ContactRequestBody requestBody) {
        final Contact contact = contactMapper.mapToEntity(requestBody);
        repository.save(contact);
    }

    @Override
    public List<Contact> getContacts(String subject) {
        return repository.findBySubjectSortedByNewest(subject);
    }

    @Override
    public List<Contact> getContacts() {
        return repository.findAllSortedByNewest();
    }
}

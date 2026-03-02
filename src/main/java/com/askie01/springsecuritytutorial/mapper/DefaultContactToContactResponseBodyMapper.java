package com.askie01.springsecuritytutorial.mapper;

import com.askie01.springsecuritytutorial.dto.ContactResponseBody;
import com.askie01.springsecuritytutorial.model.Contact;

import java.time.LocalDateTime;

public class DefaultContactToContactResponseBodyMapper implements ContactToContactResponseBodyMapper {

    @Override
    public ContactResponseBody mapToDTO(Contact contact) {
        final ContactResponseBody contactResponseBody = new ContactResponseBody();
        map(contact, contactResponseBody);
        return contactResponseBody;
    }

    @Override
    public void map(Contact source, ContactResponseBody target) {
        mapSubject(source, target);
        mapFirstName(source, target);
        mapLastName(source, target);
        mapEmail(source, target);
        mapMessage(source, target);
        mapDate(source, target);
    }

    private void mapSubject(Contact source, ContactResponseBody target) {
        final String subject = source.getSubject();
        target.setSubject(subject);
    }

    private void mapFirstName(Contact source, ContactResponseBody target) {
        final String firstName = source.getFirstName();
        target.setFirstName(firstName);
    }

    private void mapLastName(Contact source, ContactResponseBody target) {
        final String lastName = source.getLastName();
        target.setLastName(lastName);
    }

    private void mapEmail(Contact source, ContactResponseBody target) {
        final String email = source.getEmail();
        target.setEmail(email);
    }

    private void mapMessage(Contact source, ContactResponseBody target) {
        final String message = source.getMessage();
        target.setMessage(message);
    }

    private void mapDate(Contact source, ContactResponseBody target) {
        final LocalDateTime date = source.getCreatedAt();
        target.setDate(date);
    }
}

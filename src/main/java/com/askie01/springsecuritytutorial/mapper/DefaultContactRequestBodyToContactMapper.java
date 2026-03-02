package com.askie01.springsecuritytutorial.mapper;

import com.askie01.springsecuritytutorial.dto.ContactRequestBody;
import com.askie01.springsecuritytutorial.model.Contact;

public class DefaultContactRequestBodyToContactMapper implements ContactRequestBodyToContactMapper {

    @Override
    public Contact mapToEntity(ContactRequestBody contactRequestBody) {
        final Contact contact = new Contact();
        map(contactRequestBody, contact);
        return contact;
    }

    @Override
    public void map(ContactRequestBody source, Contact target) {
        mapSubject(source, target);
        mapFirstName(source, target);
        mapLastName(source, target);
        mapEmail(source, target);
        mapMessage(source, target);
    }

    private void mapSubject(ContactRequestBody source, Contact target) {
        final String subject = source.getSubject();
        target.setSubject(subject);
    }

    private void mapFirstName(ContactRequestBody source, Contact target) {
        final String firstName = source.getFirstName();
        target.setFirstName(firstName);
    }

    private void mapLastName(ContactRequestBody source, Contact target) {
        final String lastName = source.getLastName();
        target.setLastName(lastName);
    }

    private void mapEmail(ContactRequestBody source, Contact target) {
        final String email = source.getEmail();
        target.setEmail(email);
    }

    private void mapMessage(ContactRequestBody source, Contact target) {
        final String message = source.getMessage();
        target.setMessage(message);
    }
}

package com.askie01.springsecuritytutorial.mapper;

import com.askie01.springsecuritytutorial.dto.CustomerResponseBody;
import com.askie01.springsecuritytutorial.model.Customer;

public class DefaultCustomerToCustomerResponseBodyMapper implements CustomerToCustomerResponseBodyMapper {

    @Override
    public CustomerResponseBody mapToDTO(Customer customer) {
        final CustomerResponseBody customerResponseBody = new CustomerResponseBody();
        map(customer, customerResponseBody);
        return customerResponseBody;
    }

    @Override
    public void map(Customer customer, CustomerResponseBody customerResponseBody) {
        mapFirstName(customer, customerResponseBody);
        mapLastName(customer, customerResponseBody);
        mapEmail(customer, customerResponseBody);
        mapMobileNumber(customer, customerResponseBody);
    }

    private void mapFirstName(Customer customer, CustomerResponseBody customerResponseBody) {
        final String firstName = customer.getFirstName();
        customerResponseBody.setFirstName(firstName);
    }

    private void mapLastName(Customer customer, CustomerResponseBody customerResponseBody) {
        final String lastName = customer.getLastName();
        customerResponseBody.setLastName(lastName);
    }

    private void mapEmail(Customer customer, CustomerResponseBody customerResponseBody) {
        final String email = customer.getEmail();
        customerResponseBody.setEmail(email);
    }

    private void mapMobileNumber(Customer customer, CustomerResponseBody customerResponseBody) {
        final String mobileNumber = customer.getMobileNumber();
        customerResponseBody.setMobileNumber(mobileNumber);
    }
}

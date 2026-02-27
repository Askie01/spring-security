package com.askie01.springsecuritytutorial.mapper;

import com.askie01.springsecuritytutorial.dto.CustomerResponseBody;
import com.askie01.springsecuritytutorial.model.Customer;

public interface CustomerToCustomerResponseBodyMapper
        extends Mapper<Customer, CustomerResponseBody>,
        ToDTOMapper<Customer, CustomerResponseBody> {
}

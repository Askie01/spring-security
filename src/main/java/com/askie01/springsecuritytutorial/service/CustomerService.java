package com.askie01.springsecuritytutorial.service;

import com.askie01.springsecuritytutorial.dto.RegisterCustomerRequestBody;

public interface CustomerService {
    void register(RegisterCustomerRequestBody requestBody);
}

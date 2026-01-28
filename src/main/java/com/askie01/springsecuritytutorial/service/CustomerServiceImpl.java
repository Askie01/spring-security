package com.askie01.springsecuritytutorial.service;

import com.askie01.springsecuritytutorial.dto.RegisterCustomerRequestBody;
import com.askie01.springsecuritytutorial.model.Customer;
import com.askie01.springsecuritytutorial.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final PasswordEncoder passwordEncoder;
    private final CustomerRepository customerRepository;

    @Override
    public void register(RegisterCustomerRequestBody requestBody) {
        final String email = requestBody.getEmail();
        final String password = requestBody.getPassword();
        final String encodedPassword = passwordEncoder.encode(password);
        final Customer customer = Customer.builder()
                .email(email)
                .password(encodedPassword)
                .role("USER")
                .build();
        customerRepository.save(customer);
    }
}

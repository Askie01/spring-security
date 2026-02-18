package com.askie01.springsecuritytutorial.service;

import com.askie01.springsecuritytutorial.dto.RegisterCustomerRequestBody;
import com.askie01.springsecuritytutorial.model.Customer;
import com.askie01.springsecuritytutorial.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class DefaultCustomerService implements CustomerService {

    private final PasswordEncoder passwordEncoder;
    private final CustomerRepository customerRepository;

    @Override
    public void register(RegisterCustomerRequestBody requestBody) {
        final String username = requestBody.getUsername();
        final String password = requestBody.getPassword();
        final String encodedPassword = passwordEncoder.encode(password);
        final Customer customer = Customer.builder()
                .username(username)
                .password(encodedPassword)
                .role("USER")
                .build();
        customerRepository.save(customer);
    }
}

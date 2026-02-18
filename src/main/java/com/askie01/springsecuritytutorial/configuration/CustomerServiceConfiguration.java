package com.askie01.springsecuritytutorial.configuration;

import com.askie01.springsecuritytutorial.repository.CustomerRepository;
import com.askie01.springsecuritytutorial.service.CustomerService;
import com.askie01.springsecuritytutorial.service.DefaultCustomerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class CustomerServiceConfiguration {

    @Bean
    @Primary
    public CustomerService defaultCustomerService(PasswordEncoder passwordEncoder,
                                                  CustomerRepository customerRepository) {
        return new DefaultCustomerService(passwordEncoder, customerRepository);
    }
}

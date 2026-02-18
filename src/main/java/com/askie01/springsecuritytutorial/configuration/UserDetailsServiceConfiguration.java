package com.askie01.springsecuritytutorial.configuration;

import com.askie01.springsecuritytutorial.repository.CustomerRepository;
import com.askie01.springsecuritytutorial.service.CustomerUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class UserDetailsServiceConfiguration {

    @Bean
    @Primary
    public UserDetailsService customerUserDetailsService(CustomerRepository customerRepository) {
        return new CustomerUserDetailsService(customerRepository);
    }
}

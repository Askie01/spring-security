package com.askie01.springsecuritytutorial.service;

import com.askie01.springsecuritytutorial.model.Customer;
import com.askie01.springsecuritytutorial.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerUserDetailsService implements UserDetailsService {

    private final CustomerRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Customer customer = repository
                .findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with email: '" + username + "' not found."));
        return toUserDetails(customer);
    }

    private UserDetails toUserDetails(Customer customer) {
        final String email = customer.getEmail();
        final String password = customer.getPassword();
        final String role = customer.getRole();
        return User.builder()
                .username(email)
                .password(password)
                .roles(role)
                .build();
    }
}

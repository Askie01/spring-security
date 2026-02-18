package com.askie01.springsecuritytutorial.service;

import com.askie01.springsecuritytutorial.model.Customer;
import com.askie01.springsecuritytutorial.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RequiredArgsConstructor
public class CustomerUserDetailsService implements UserDetailsService {

    private final CustomerRepository repository;

    @Override
    public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        final Customer customer = repository
                .findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username: '" + username + "' not found."));
        return toUserDetails(customer);
    }

    private UserDetails toUserDetails(Customer customer) {
        final String username = customer.getUsername();
        final String password = customer.getPassword();
        final String role = customer.getRole();
        return User.builder()
                .username(username)
                .password(password)
                .roles(role)
                .build();
    }
}

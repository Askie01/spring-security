package com.askie01.springsecuritytutorial.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import java.util.List;

@Configuration
public class UserDetailsManagerConfiguration {

    @Bean
    public UserDetailsManager userDetailsManager() {
        final List<UserDetails> users = List.of(
                User.builder().username("user").password("{noop}user").build(),
                User.builder().username("root").password("{noop}root").build()
        );
        return new InMemoryUserDetailsManager(users);
    }
}

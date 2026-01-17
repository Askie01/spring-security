package com.askie01.springsecuritytutorial.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class UserDetailsManagerConfiguration {

    private final PasswordEncoder passwordEncoder;

    @Bean
    public UserDetailsManager userDetailsManager() {
        final List<UserDetails> users = List.of(
                createUser("user", "user@123400000"),
                createUser("admin", "admin@123400000")
        );
        return new InMemoryUserDetailsManager(users);
    }

    private UserDetails createUser(String name, String password) {
        final String encodedPassword = passwordEncoder.encode(password);
        return User.builder().
                username(name)
                .password(encodedPassword)
                .build();
    }
}

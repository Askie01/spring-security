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
                User.builder().username("user").password("$2a$12$qPLrxVoWJ1SycwdnCR9wju3LoRH/HDkTNBTYRY8va59giqIecmjd2").build(),
                User.builder().username("root").password("$2a$12$D7QkpqFit.Dhvq4wUm3O0.YR6Xtv6huFjph7DGQROrhipJN9gt3qi").build()
        );
        return new InMemoryUserDetailsManager(users);
    }
}

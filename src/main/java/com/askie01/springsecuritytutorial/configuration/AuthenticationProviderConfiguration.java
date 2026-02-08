package com.askie01.springsecuritytutorial.configuration;

import com.askie01.springsecuritytutorial.provider.UsernamePasswordAuthenticationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AuthenticationProviderConfiguration {

    @Bean
    @Primary
    public AuthenticationProvider usernamePasswordAuthenticationProvider(PasswordEncoder passwordEncoder,
                                                                         UserDetailsService userDetailsService) {
        return new UsernamePasswordAuthenticationProvider(passwordEncoder, userDetailsService);
    }
}

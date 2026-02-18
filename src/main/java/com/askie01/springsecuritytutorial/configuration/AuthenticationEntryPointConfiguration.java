package com.askie01.springsecuritytutorial.configuration;

import com.askie01.springsecuritytutorial.authentication.CustomAuthenticationEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.web.AuthenticationEntryPoint;

@Configuration
public class AuthenticationEntryPointConfiguration {

    @Bean
    @Primary
    public AuthenticationEntryPoint customAuthenticationEntryPoint() {
        return new CustomAuthenticationEntryPoint();
    }
}

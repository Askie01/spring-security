package com.askie01.springsecuritytutorial.configuration;

import com.askie01.springsecuritytutorial.event.AuthenticationEventListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AuthenticationEventListenerConfiguration {

    @Bean
    @Primary
    public AuthenticationEventListener authenticationEventListener() {
        return new AuthenticationEventListener();
    }
}

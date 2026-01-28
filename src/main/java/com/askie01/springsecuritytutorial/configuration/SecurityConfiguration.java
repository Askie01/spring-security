package com.askie01.springsecuritytutorial.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) {
        return http.authorizeHttpRequests(requestConfiguration -> requestConfiguration
                        .requestMatchers("/accounts").authenticated()
                        .requestMatchers("/cards").authenticated()
                        .requestMatchers("/loans").authenticated()
                        .requestMatchers("/balances").authenticated()
                        .requestMatchers("/notices").permitAll()
                        .requestMatchers("/contacts").permitAll()
                        .requestMatchers("/error").permitAll()
                        .requestMatchers("/customers").permitAll()
                )
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .build();
    }
}

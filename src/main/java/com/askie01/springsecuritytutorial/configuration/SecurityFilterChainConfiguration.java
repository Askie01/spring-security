package com.askie01.springsecuritytutorial.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class SecurityFilterChainConfiguration {

    private final AuthenticationEntryPoint authenticationEntryPoint;

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) {
        return http
                .sessionManagement(sessionConfiguration -> sessionConfiguration
                        .invalidSessionUrl("/error/invalid-session")
                        .maximumSessions(1)
                        .maxSessionsPreventsLogin(true)
                        .expiredUrl("/error/session-expired")
                )
                .authorizeHttpRequests(requestConfiguration -> requestConfiguration
                        .requestMatchers("/accounts").authenticated()
                        .requestMatchers("/cards").authenticated()
                        .requestMatchers("/loans").authenticated()
                        .requestMatchers("/balances").authenticated()
                        .requestMatchers("/notices").permitAll()
                        .requestMatchers("/contacts").permitAll()
                        .requestMatchers("/error").permitAll()
                        .requestMatchers("/customers").permitAll()
                        .requestMatchers("/error/invalid-session").permitAll()
                        .requestMatchers("/error/session-expired").permitAll()
                )
                .formLogin(Customizer.withDefaults())
                .httpBasic(httpBasic -> httpBasic
                        .authenticationEntryPoint(authenticationEntryPoint))
                .csrf(AbstractHttpConfigurer::disable)
                .build();
    }
}

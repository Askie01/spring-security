package com.askie01.springsecuritytutorial.configuration;

import com.askie01.springsecuritytutorial.filter.CsrfCookieFilter;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class SecurityFilterChainConfiguration {

    private final AuthenticationEntryPoint authenticationEntryPoint;

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) {
        return http
                .securityContext(contextConfiguration -> contextConfiguration
                        .requireExplicitSave(false)
                )
                .sessionManagement(sessionConfiguration -> sessionConfiguration
                        .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                        .invalidSessionUrl("/error/invalid-session")
                        .maximumSessions(1)
                        .maxSessionsPreventsLogin(true)
                        .expiredUrl("/error/session-expired")
                )
                .authorizeHttpRequests(requestConfiguration -> requestConfiguration
                        .requestMatchers("/accounts/**").authenticated()
                        .requestMatchers("/cards/**").authenticated()
                        .requestMatchers("/loans/**").authenticated()
                        .requestMatchers("/transactions/**").authenticated()
                        .requestMatchers("/notices/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/contacts/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/contacts/**").authenticated()
                        .requestMatchers("/customers/**").permitAll()
                        .requestMatchers("/error/**").permitAll()
                        .requestMatchers("/error/invalid-session/**").permitAll()
                        .requestMatchers("/error/session-expired/**").permitAll()
                )
                .formLogin(Customizer.withDefaults())
                .httpBasic(httpBasic -> httpBasic
                        .authenticationEntryPoint(authenticationEntryPoint)
                )
                .cors(corsConfiguration -> corsConfiguration
                        .configurationSource(corsConfigurationSource())
                )
                .csrf(csrfConfiguration -> csrfConfiguration
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                        .csrfTokenRequestHandler(new CsrfTokenRequestAttributeHandler())
                        .ignoringRequestMatchers("/contact")
                        .ignoringRequestMatchers("/register")
                )
                .addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class)
                .build();
    }

    private CorsConfigurationSource corsConfigurationSource() {
        return new CorsConfigurationSource() {
            @Override
            public @Nullable CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                final CorsConfiguration configuration = new CorsConfiguration();
                configuration.setAllowedOrigins(List.of("http://localhost:4200"));
                configuration.setAllowedMethods(List.of("*"));
                configuration.setAllowCredentials(true);
                configuration.setAllowedHeaders(List.of("*"));
                configuration.setMaxAge(3600L);
                return configuration;
            }
        };
    }
}

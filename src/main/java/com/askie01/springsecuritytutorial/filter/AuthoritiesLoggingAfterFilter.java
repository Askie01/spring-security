package com.askie01.springsecuritytutorial.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Slf4j
public class AuthoritiesLoggingAfterFilter implements Filter {

    @Override
    @SneakyThrows
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            final String username = authentication.getName();
            final String authorities = authentication.getAuthorities().toString();
            log.info("User '{}' is successfully authenticated and has the authorities: '{}'", username, authorities);
        }
        chain.doFilter(request, response);
    }
}

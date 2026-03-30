package com.askie01.springsecuritytutorial.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthoritiesLoggingAtFilter implements Filter {

    @Override
    @SneakyThrows
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) {
        log.info("Authentication validation is in progress...");
        chain.doFilter(request, response);
    }
}

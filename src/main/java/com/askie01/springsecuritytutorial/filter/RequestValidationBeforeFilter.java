package com.askie01.springsecuritytutorial.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class RequestValidationBeforeFilter implements Filter {

    @Override
    @SneakyThrows
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) {
        final HttpServletRequest servletRequest = (HttpServletRequest) request;
        final HttpServletResponse servletResponse = (HttpServletResponse) response;
        final String header = servletRequest.getHeader(HttpHeaders.AUTHORIZATION);
        try {
            if (header != null) {
                final String trimmedHeader = header.trim();
                if (StringUtils.startsWithIgnoreCase(trimmedHeader, "Basic")) {
                    final byte[] base64Token = trimmedHeader.substring(6).getBytes(StandardCharsets.UTF_8);
                    final byte[] decoded = Base64.getDecoder().decode(base64Token);
                    final String token = new String(decoded, StandardCharsets.UTF_8);
                    final int delimiter = token.indexOf(":");
                    if (delimiter == -1) {
                        throw new BadCredentialsException("Invalid token");
                    }
                    final String username = token.substring(0, delimiter);
                    if (username.toLowerCase().contains("test")) {
                        servletResponse.setStatus(HttpStatus.BAD_REQUEST.value());
                    }
                }
            }
        } catch (IllegalArgumentException exception) {
            throw new BadCredentialsException("Failed to decode basic authentication token");
        }
        chain.doFilter(request, response);
    }
}

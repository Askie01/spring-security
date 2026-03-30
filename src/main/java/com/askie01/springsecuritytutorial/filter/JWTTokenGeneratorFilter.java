package com.askie01.springsecuritytutorial.filter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.stream.Collectors;

@Component
public class JWTTokenGeneratorFilter extends OncePerRequestFilter {

    @Value("${jwt.secret-key}")
    private String JWT_SECRET_KEY;

    @Value("${jwt.secret-key-default-value}")
    private String JWT_SECRET_KEY_DEFAULT_VALUE;

    @Override
    @SneakyThrows
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            final String username = authentication.getName();
            final String authorities = authentication
                    .getAuthorities()
                    .stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.joining(","));
            final String secret = getEnvironment().getProperty(JWT_SECRET_KEY, JWT_SECRET_KEY_DEFAULT_VALUE);
            final SecretKey secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
            final String JWT = Jwts.builder()
                    .issuer("Askie01")
                    .subject("JWT Token")
                    .claim("username", username)
                    .claim("authorities", authorities)
                    .issuedAt(new Date())
                    .expiration(createExpirationDate())
                    .signWith(secretKey)
                    .compact();
            response.setHeader("Authorization", "Bearer " + JWT);
        }
        filterChain.doFilter(request, response);
    }

    private Date createExpirationDate() {
        final long time = new Date().getTime();
        return new Date(time + 1000 * 60 * 60 * 24);
    }

    @Override
    @SneakyThrows
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return !request.getServletPath().equals("/user");
    }
}

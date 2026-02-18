package com.askie01.springsecuritytutorial.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;

@Slf4j
public class AuthenticationEventListener {

    @EventListener
    public void onSuccess(AuthenticationSuccessEvent successEvent) {
        final String username = successEvent.getAuthentication().getName();
        log.info("Login successful for the user: '{}'", username);
    }

    @EventListener
    public void onFailure(AbstractAuthenticationFailureEvent failureEvent) {
        final String username = failureEvent.getAuthentication().getName();
        final String reason = failureEvent.getException().getMessage();
        log.info("Login failed for the user: '{}' due to: '{}'", username, reason);
    }
}

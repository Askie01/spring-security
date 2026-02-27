package com.askie01.springsecuritytutorial.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing
public class JpaConfiguration {

    @Bean
    @Primary
    @ConditionalOnProperty(
            name = "component.auditor",
            havingValue = "service",
            matchIfMissing = true
    )
    public AuditorAware<String> serviceAuditor() {
        return () -> Optional.of("Auditor");
    }
}

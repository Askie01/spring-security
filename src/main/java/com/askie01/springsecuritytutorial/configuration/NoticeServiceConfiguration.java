package com.askie01.springsecuritytutorial.configuration;

import com.askie01.springsecuritytutorial.repository.NoticeRepository;
import com.askie01.springsecuritytutorial.service.DefaultNoticeService;
import com.askie01.springsecuritytutorial.service.NoticeService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class NoticeServiceConfiguration {

    @Bean
    @Primary
    @ConditionalOnProperty(
            name = "component.service.notice",
            havingValue = "default",
            matchIfMissing = true
    )
    public NoticeService defaultNoticeService(NoticeRepository repository) {
        return new DefaultNoticeService(repository);
    }
}

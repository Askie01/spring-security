package com.askie01.springsecuritytutorial.configuration;

import com.askie01.springsecuritytutorial.mapper.DefaultNoticeToNoticeResponseBodyMapper;
import com.askie01.springsecuritytutorial.mapper.NoticeToNoticeResponseBodyMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class NoticeToNoticeResponseBodyMapperConfiguration {

    @Bean
    @Primary
    @ConditionalOnProperty(
            name = "component.mapper.notice-to-notice-response-body",
            havingValue = "default",
            matchIfMissing = true
    )
    public NoticeToNoticeResponseBodyMapper defaultNoticeToNoticeResponseBodyMapper() {
        return new DefaultNoticeToNoticeResponseBodyMapper();
    }
}

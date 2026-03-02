package com.askie01.springsecuritytutorial.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class NoticeResponseBody {
    private String title;
    private String content;
    private LocalDateTime date;
}

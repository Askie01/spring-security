package com.askie01.springsecuritytutorial.response;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
@EqualsAndHashCode
public class ErrorHttpResponse implements HttpResponse {
    private String path;
    private Integer statusCode;
    private String message;
    private LocalDateTime timestamp;
}

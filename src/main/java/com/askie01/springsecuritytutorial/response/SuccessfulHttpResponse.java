package com.askie01.springsecuritytutorial.response;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
@EqualsAndHashCode
public class SuccessfulHttpResponse implements HttpResponse {
    private Integer statusCode;
    private String message;
}

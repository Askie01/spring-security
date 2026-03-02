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
public class ContactResponseBody {
    private String subject;
    private String firstName;
    private String lastName;
    private String email;
    private String message;
    private LocalDateTime date;
}

package com.askie01.springsecuritytutorial.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class ContactRequestBody {
    private String subject;
    private String firstName;
    private String lastName;
    private String email;
    private String message;
}

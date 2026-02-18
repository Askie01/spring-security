package com.askie01.springsecuritytutorial.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class RegisterCustomerRequestBody {
    private String username;
    private String password;
}

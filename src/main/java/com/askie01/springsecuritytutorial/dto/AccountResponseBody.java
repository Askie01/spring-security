package com.askie01.springsecuritytutorial.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class AccountResponseBody {
    private Long accountNumber;
    private String accountType;
    private String branchAddress;
    private CustomerResponseBody owner;
}

package com.askie01.springsecuritytutorial.dto;


import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class AccountTransactionsResponseBody {
    private AccountResponseBody account;
    private List<TransactionResponseBody> transactions;
}

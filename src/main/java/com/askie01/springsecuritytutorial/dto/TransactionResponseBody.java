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
public class TransactionResponseBody {
    private String title;
    private String type;
    private Double amount;
    private Double closingBalance;
    private LocalDateTime date;
}

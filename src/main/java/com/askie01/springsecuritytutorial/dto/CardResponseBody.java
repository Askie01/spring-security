package com.askie01.springsecuritytutorial.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class CardResponseBody {
    private Long number;
    private String type;
    private Double limit;
    private Double used;
    private Double balance;
}

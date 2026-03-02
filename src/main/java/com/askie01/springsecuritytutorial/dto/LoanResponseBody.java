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
public class LoanResponseBody {
    private Long number;
    private String type;
    private Double total;
    private Double paid;
    private Double remaining;
    private LocalDateTime date;
}

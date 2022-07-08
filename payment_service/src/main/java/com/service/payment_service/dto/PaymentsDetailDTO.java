package com.service.payment_service.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class PaymentsDetailDTO {

    private Long id;
    private int totalDues;
    private LocalDate paymentDate;
    private CreditCardPostDTO creditCard;
    private Long pack; 
}

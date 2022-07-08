package com.service.payment_service.dto;

import com.service.payment_service.enums.CardTypeEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class CreditCardDetailDTO {
    private CardTypeEnum type;
    private String number;
    private Double mount;
}

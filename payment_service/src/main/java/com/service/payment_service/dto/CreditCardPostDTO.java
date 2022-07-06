package com.service.payment_service.dto;

import java.time.LocalDate;

import com.service.payment_service.enums.CardTypeEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreditCardPostDTO {

    private CardTypeEnum type;
    private String number;
    private String expiredDate;
    private String nameOwner;
    private String surnameOwener;
    private Long cvv;
    private Long client;

}

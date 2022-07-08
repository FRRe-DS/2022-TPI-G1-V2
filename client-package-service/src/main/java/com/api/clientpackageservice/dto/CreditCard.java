package com.api.clientpackageservice.dto;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditCard {
    private Long id;
    private CardTypeEnum type;
    private String number;
    private LocalDate expiredDate;
    private String nameOwner;
    private String surnameOwener;
    private Long cvv;
    private Long client;
    private Double mount;
}

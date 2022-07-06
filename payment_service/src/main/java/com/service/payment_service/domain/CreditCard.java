package com.service.payment_service.domain;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.service.payment_service.enums.CardTypeEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class CreditCard {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type", nullable = false)
    private CardTypeEnum type;
    @Column(name = "number", nullable = false)
    private String number;
    @Column(name = "expired_date", nullable = false)
    private LocalDate expiredDate;
    @Column(name = "name_owner", nullable = false)
    private String nameOwner;
    @Column(name = "surnname_owner", nullable = false)
    private String surnameOwener;
    @Column(name = "cvv", nullable = false)
    private Long cvv;
    @Column(name = "client", nullable = true)
    private Long client;
    @Column(name = "amount", nullable = false)
    private Double mount;
}

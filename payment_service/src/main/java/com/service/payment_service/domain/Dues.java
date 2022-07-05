package com.service.payment_service.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Dues {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "amount", nullable = false)
    private Double amount;
    
    @Column(name = "payment_date")
    private LocalDate paymentDate= LocalDate.now();

    @OneToOne(cascade = {})
    @JoinColumn(name="payment", nullable = false, updatable = true)
    private Payment payment;

}

package com.service.payment_service.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount", nullable = false)
    private Double amount;
    @Column(name = "dues_amount", nullable = false)
    private Double duesAmount;
    @Column(name = "total_dues", nullable = false)
    private int totalDues;
    @Column(name = "payment_date", nullable = false)
    private LocalDate paymentDate = LocalDate.now();

    @ManyToOne
    private CreditCard creditCard;

    @OneToMany(mappedBy = "payment",cascade = {CascadeType.PERSIST,CascadeType.REMOVE, CascadeType.REFRESH}, orphanRemoval = true)
    private List<Dues> dues = new ArrayList<Dues>();

    @Column(nullable = true)
    private Long pack; 
    @Column(nullable = true)
    private Long client;
}

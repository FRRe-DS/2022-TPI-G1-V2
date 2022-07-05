package com.service.payment_service.mapper;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.service.payment_service.domain.Payment;
import com.service.payment_service.dto.PaymentPostDTO;

@Component
public class PaymentMapper {
    
    public Payment paymentMapper(PaymentPostDTO paymentDto){

        Payment payment = new Payment();

        return payment.builder()
               .totalDues(paymentDto.getTotalDues())
               .client(paymentDto.getClient())
               .pack(paymentDto.getPack())
               .paymentDate(LocalDate.now())
               .creditCard(null)
               .build();
    }
}

package com.service.payment_service.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.service.payment_service.domain.Payment;
import com.service.payment_service.dto.PaymentPostDTO;
import com.service.payment_service.mapper.PaymentMapper;
import com.service.payment_service.repository.PaymentRepository;
import com.service.payment_service.service.PaymentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService{
    
    private final PaymentMapper paymentMapper;
    private final PaymentRepository paymentRepository;
    
    public Payment createPayment(PaymentPostDTO paymentPost){

        return paymentRepository.save(paymentMapper.paymentMapper(paymentPost));
    }

    @Override
    public List<Payment> getPayments() {
        // TODO Auto-generated method stub
        return paymentRepository.findAll();
    }
}

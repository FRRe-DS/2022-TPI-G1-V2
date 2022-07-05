package com.service.payment_service.service;

import java.util.List;

import com.service.payment_service.domain.Payment;
import com.service.payment_service.dto.PaymentPostDTO;

public interface PaymentService {
    public Payment createPayment(PaymentPostDTO paymentPost);
    public List<Payment> getPayments();
}

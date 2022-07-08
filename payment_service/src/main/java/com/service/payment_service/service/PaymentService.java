package com.service.payment_service.service;

import java.util.List;

import com.service.payment_service.domain.Dues;
import com.service.payment_service.domain.Payment;
import com.service.payment_service.dto.PaymentPostDTO;
import com.service.payment_service.dto.PaymentsDetailDTO;

public interface PaymentService {
    public Payment createPayment(PaymentPostDTO paymentPost);
    public List<Payment> getPayments();
    public List<Payment> getPaymentsByIdClient(Long id);
    public Dues payPackage(Long id,Long creditCardId);
}

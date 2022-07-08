package com.service.payment_service.service.Impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.service.payment_service.domain.CreditCard;
import com.service.payment_service.domain.Dues;
import com.service.payment_service.domain.Payment;
import com.service.payment_service.dto.PaymentPostDTO;
import com.service.payment_service.dto.PaymentsDetailDTO;
import com.service.payment_service.mapper.PaymentMapper;
import com.service.payment_service.repository.CreditCardRepository;
import com.service.payment_service.repository.DueRepository;
import com.service.payment_service.repository.PaymentRepository;
import com.service.payment_service.service.PackageServiceRest;
import com.service.payment_service.service.PaymentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentMapper paymentMapper;
    private final PaymentRepository paymentRepository;
    private final CreditCardRepository creditCardRepository;
    private final DueRepository dueRepository;
    private final PackageServiceRest packageServiceRest;

    public Payment createPayment(PaymentPostDTO paymentPost) {

        return paymentRepository.save(paymentMapper.paymentMapper(paymentPost));
    }

    @Override
    public List<Payment> getPayments() {
        // TODO Auto-generated method stub
        return paymentRepository.findAll();
    }

    @Override
    public Dues payPackage(Long id, Long creditCardId) {

        Payment payment = paymentRepository.findById(id).get();
        CreditCard creditCard = creditCardRepository.findById(creditCardId).get();

        payment.setCreditCard(creditCard);
        payment.setClient(creditCard.getId());
        paymentRepository.save(payment);
        packageServiceRest.updateStateOfPack(payment.getPack());

        Dues due = new Dues();
        due = due.builder()
                .amount(10.00)
                .paymentDate(LocalDate.now())
                .payment(payment)
                .build();

        return dueRepository.save(due);
    }


    @Override
    public List<Payment> getPaymentsByIdClient(Long id) {
        // TODO Auto-generated method stub
        return null;
    }
}

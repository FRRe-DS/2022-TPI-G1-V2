package com.service.payment_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.payment_service.domain.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long>{
    Payment findByPack(Long id);
    List<Payment> findAllByClient(Long id);
}

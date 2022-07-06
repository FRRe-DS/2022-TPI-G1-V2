package com.service.payment_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.payment_service.domain.CreditCard;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard,Long>{
    List<CreditCard> findAllByClient(Long id);
}

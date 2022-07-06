package com.service.payment_service.service;

import java.util.List;

import com.service.payment_service.domain.CreditCard;
import com.service.payment_service.dto.CreditCardPostDTO;

public interface CreditCardService {
    public CreditCard createCreditCard(CreditCardPostDTO creditCardPostDTO);
    public List<CreditCard> getAllCardsByClient(Long id);
}

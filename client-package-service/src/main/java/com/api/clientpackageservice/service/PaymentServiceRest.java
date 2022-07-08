package com.api.clientpackageservice.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.api.clientpackageservice.dto.CreditCard;
import com.api.clientpackageservice.dto.CreditCardPostDTO;

@FeignClient(name = "payment-service")
public interface PaymentServiceRest {
    
    @PostMapping("card")
    public ResponseEntity<?> createCreditCard(@RequestBody CreditCardPostDTO creditCardPostDTO);

    @GetMapping("card/{id}")
    public ResponseEntity<List<CreditCard>> getAllCardsByClient(@PathVariable(name = "id") Long id);

    @PutMapping("{id}/{creditCardId}")
    public ResponseEntity<?> payPackage(@PathVariable(name = "id") Long id,@PathVariable(name = "creditCardId") Long creditCardId);
}

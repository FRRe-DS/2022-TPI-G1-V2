package com.example.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dto.Payment;
import com.example.demo.dto.PaymentPostDTO;
import com.example.demo.dto.ResponseDTO;

@FeignClient(name = "payment-service")
public interface PaymentClientRest {
    @PostMapping()
    public ResponseEntity<ResponseDTO> createPayment(@RequestBody PaymentPostDTO paymentPostDTO);
    
    @GetMapping("pack/{idPack}")
    public Payment getPaymentByIdPackage(@PathVariable(name = "idPack") Long idPack);
}

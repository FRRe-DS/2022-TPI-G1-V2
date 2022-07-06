package com.service.payment_service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.payment_service.domain.CreditCard;
import com.service.payment_service.dto.CreditCardPostDTO;
import com.service.payment_service.dto.ErrorDTO;
import com.service.payment_service.dto.ResponseDTO;
import com.service.payment_service.mapper.ErrorMapper;
import com.service.payment_service.service.CreditCardService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/card")
public class CreditCardController {

    private final CreditCardService creditService;
    private final ErrorMapper errorMapper;
    @PostMapping
    public ResponseEntity<?> createCreditCard(@RequestBody CreditCardPostDTO creditCardPostDTO){
        ResponseDTO response = new ResponseDTO();
        
        CreditCard card = creditService.createCreditCard(creditCardPostDTO);
        
        if(card == null){
            ErrorDTO error = errorMapper.errorCardNoValid();
            return new ResponseEntity<ErrorDTO>(error, HttpStatus.BAD_REQUEST);
        }

        response.setId(card.getId());
        response.setUrl("/card/"+card.getId());
   
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.CREATED);
    }



    @GetMapping("/{id}")
    public ResponseEntity<List<CreditCard>> getPaymentsByClient(@PathVariable(name = "id") Long id){
        
        return new ResponseEntity<List<CreditCard>>(creditService.getAllCardsByClient(id), HttpStatus.OK);   
    }

}

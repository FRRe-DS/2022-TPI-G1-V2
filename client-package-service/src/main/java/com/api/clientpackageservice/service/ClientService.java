package com.api.clientpackageservice.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.api.clientpackageservice.dto.CreditCard;
import com.api.clientpackageservice.dto.CreditCardPostDTO;

public interface ClientService {
    
    public ResponseEntity<?> getAllPackages();
    public ResponseEntity<?> getPackById(@PathVariable(name = "idPack") Long idPack);
    public ResponseEntity<?> createCreditCard(@RequestBody CreditCardPostDTO creditCardPostDTO);
    public ResponseEntity<List<CreditCard>> getAllCardsByClient(@PathVariable(name = "id") Long id);
    public ResponseEntity<?> payPackage(@PathVariable(name = "id") Long id,@PathVariable(name = "creditCardId") Long creditCardId);
}

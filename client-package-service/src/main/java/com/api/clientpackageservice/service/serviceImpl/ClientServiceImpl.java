package com.api.clientpackageservice.service.serviceImpl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.clientpackageservice.dto.CreditCard;
import com.api.clientpackageservice.dto.CreditCardPostDTO;
import com.api.clientpackageservice.service.ClientService;
import com.api.clientpackageservice.service.PackageServiceRest;
import com.api.clientpackageservice.service.PaymentServiceRest;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ClientServiceImpl implements ClientService{
    
    private final PackageServiceRest packageServiceRest; 
    private final PaymentServiceRest paymentServiceRest;
    
    @Override
    public ResponseEntity<?> getAllPackages() {
        return packageServiceRest.getPacksNotReserved();
    }

    @Override
    public ResponseEntity<?> getPackById(Long idPack) {
        return packageServiceRest.getPackById(idPack);
    }

    @Override
    public ResponseEntity<?> createCreditCard(CreditCardPostDTO creditCardPostDTO) {
        return paymentServiceRest.createCreditCard(creditCardPostDTO);
    }

    @Override
    public ResponseEntity<List<CreditCard>> getAllCardsByClient(Long id) {
        return paymentServiceRest.getAllCardsByClient(id);
    }

    @Override
    public ResponseEntity<?> payPackage(Long id, Long creditCardId) {
        return paymentServiceRest.payPackage(id, creditCardId);
    }
    


}

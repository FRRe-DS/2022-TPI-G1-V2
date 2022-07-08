package com.api.clientpackageservice.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.clientpackageservice.dto.CreditCard;
import com.api.clientpackageservice.dto.CreditCardPostDTO;
import com.api.clientpackageservice.service.PackageServiceRest;
import com.api.clientpackageservice.service.PaymentServiceRest;
import com.api.clientpackageservice.service.serviceImpl.ClientServiceImpl;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
public class ClientController {
    
    private final ClientServiceImpl clientServiceImpl;


    @GetMapping("/packages")
    public ResponseEntity<?> getAllPackages(){
        //Devuelve todos los paquetes sin reserva
        return clientServiceImpl.getAllPackages();
    }

    @GetMapping("/packages/{idPack}")
    public ResponseEntity<?> getPackById(@PathVariable(name = "idPack") Long idPack){
        //Obtener detalle de paquete
        return clientServiceImpl.getPackById(idPack);
    }

    @PostMapping("/card")
    public ResponseEntity<?> createCreditCard(@RequestBody CreditCardPostDTO creditCardPostDTO){
        //Subir mi tarjeta de credito
        return clientServiceImpl.createCreditCard(creditCardPostDTO);
    }

    @GetMapping("/card/client/{id}")
    public ResponseEntity<List<CreditCard>> getAllCardsByClient(@PathVariable(name = "id") Long id){
        //Traer todas mis tarjetas
        return clientServiceImpl.getAllCardsByClient(id);
    }

    @PutMapping("/payment/{id}/card/{creditCardId}")
    public ResponseEntity<?> payPackage(@PathVariable(name = "id") Long id,@PathVariable(name = "creditCardId") Long creditCardId){
        //Realizar el pago
        return clientServiceImpl.payPackage(id, creditCardId);
    }

}

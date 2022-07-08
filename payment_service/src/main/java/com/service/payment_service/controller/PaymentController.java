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

import com.service.payment_service.domain.Dues;
import com.service.payment_service.domain.Payment;
import com.service.payment_service.dto.PaymentPostDTO;
import com.service.payment_service.dto.ResponseDTO;
import com.service.payment_service.service.Impl.PaymentServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class PaymentController {
    
    private final PaymentServiceImpl paymentService;

    @PostMapping
    public ResponseEntity<ResponseDTO> createPayment(@RequestBody PaymentPostDTO paymentPostDTO){
        ResponseDTO response = new ResponseDTO();
        
        Payment payment = paymentService.createPayment(paymentPostDTO);

        response.setId(payment.getId());
        response.setUrl("/payment/"+payment.getId());
   
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/{creditCardId}")
    public ResponseEntity<?> payPackage(@PathVariable(name = "id") Long id,@PathVariable(name = "creditCardId") Long creditCardId){
        Dues due = paymentService.payPackage(id, creditCardId);
        
        return new ResponseEntity<Dues>(due, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Payment>> getPayments(){
        return new ResponseEntity<List<Payment>>(paymentService.getPayments(), HttpStatus.OK);
    }

}

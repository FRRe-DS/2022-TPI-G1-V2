package com.example.Service.ServiceHealthInsurance.controller;

import java.util.List;

import com.example.Service.ServiceHealthInsurance.domain.HealthInsurance;
import com.example.Service.ServiceHealthInsurance.dto.HealthInsuranceDTO;
import com.example.Service.ServiceHealthInsurance.dto.ResponseDTO;
import com.example.Service.ServiceHealthInsurance.service.impl.HealthInsuranceServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/health")
public class HealthInsuranceController {
//@RequestPart(value="character", required=true) Character character
    private final HealthInsuranceServiceImpl healthInsuranceServiceImpl;
    @PostMapping
    public ResponseEntity<ResponseDTO> createHealthInsurance(@RequestBody HealthInsuranceDTO healthInsuranceDTO){
        ResponseDTO responseDTO = new ResponseDTO();

        HealthInsurance healthInsurance = healthInsuranceServiceImpl.createHealth(healthInsuranceDTO);

        responseDTO.setId(healthInsurance.getId());
        responseDTO.setUrl("/health"+healthInsurance.getId());
        
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<HealthInsurance>> getHealthService(){

        return new ResponseEntity<List<HealthInsurance>>
        (healthInsuranceServiceImpl.getHealthService(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HealthInsurance> getHealthServiceById(@PathVariable(name = "id") Long id){
        return new ResponseEntity<HealthInsurance>
        (healthInsuranceServiceImpl.getHealthServiceById(id), HttpStatus.OK);
    }
}

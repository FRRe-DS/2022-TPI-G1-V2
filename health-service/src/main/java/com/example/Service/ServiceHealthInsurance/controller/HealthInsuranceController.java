package com.example.Service.ServiceHealthInsurance.controller;

import java.util.List;

import com.example.Service.ServiceHealthInsurance.domain.HealthInsurance;
import com.example.Service.ServiceHealthInsurance.domain.HealthService;
import com.example.Service.ServiceHealthInsurance.dto.ErrorDTO;
import com.example.Service.ServiceHealthInsurance.dto.GetHealthInsuranceDTO;
import com.example.Service.ServiceHealthInsurance.dto.HealthInsuranceDTO;
import com.example.Service.ServiceHealthInsurance.dto.ResponseDTO;
import com.example.Service.ServiceHealthInsurance.mapper.ErrorMapper;
import com.example.Service.ServiceHealthInsurance.service.impl.HealthInsuranceServiceImpl;
import com.fasterxml.jackson.core.JsonParser;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    private final ErrorMapper errorMapper;


    @PostMapping
    public ResponseEntity<ResponseDTO> createHealthInsurance(@RequestBody HealthInsuranceDTO healthInsuranceDTO){
        ResponseDTO responseDTO = new ResponseDTO();

        HealthInsurance healthInsurance = healthInsuranceServiceImpl.createHealth(healthInsuranceDTO);

        responseDTO.setId(healthInsurance.getId());
        responseDTO.setUrl("/health"+healthInsurance.getId());
        
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<GetHealthInsuranceDTO>> getHealthService(){

        return new ResponseEntity<List<GetHealthInsuranceDTO>>
        (healthInsuranceServiceImpl.getHealthService(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteHealthServiceById(@PathVariable(name = "id") Long id){
        Boolean response = healthInsuranceServiceImpl.deleteHealthServiceById(id);
        
        if(response == false){
            ErrorDTO error = errorMapper.errorNotFoundMatch();
            return new ResponseEntity<ErrorDTO>(error, HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<String>
            ("Health Service deleted", HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getHealthServiceById(@PathVariable(name = "id") Long id){
        HealthInsurance healthInsurance = healthInsuranceServiceImpl.getHealthServiceById(id);
        
        if(healthInsurance == null){
            ErrorDTO error = errorMapper.errorNotFoundMatch();
            return new ResponseEntity<ErrorDTO>(error, HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<HealthInsurance>
            (healthInsurance, HttpStatus.OK);
        }
    }

    @GetMapping("/services")
    public ResponseEntity<?> getServices(){
        List<HealthService> healthService= healthInsuranceServiceImpl.getServices();
        
        if(healthService.isEmpty()){
            return new ResponseEntity<String>("No exists services", HttpStatus.OK);
        }else{
            return new ResponseEntity<List<HealthService>>
            (healthService, HttpStatus.OK);
        }


    }
}

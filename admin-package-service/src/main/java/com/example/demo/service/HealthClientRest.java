package com.example.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "health-insurance-service",url="localhost:8003/api/v1/")
public interface HealthClientRest {
    @GetMapping("health/{id}")
    public ResponseEntity<?> getHealthServiceById(@PathVariable(name = "id") Long id);
    
}

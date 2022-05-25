package com.example.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "travel-service",url="localhost:8004/api/v1/")
public interface TravelClientRest {
    @GetMapping("travel/{id}")
    public ResponseEntity<?> getTravelById(@PathVariable(name = "id") Long id);
}

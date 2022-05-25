package com.example.demo.service;

import com.example.demo.request.GetMatchByIdDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "match-service",url="localhost:8001/api/v1/")
public interface MatchClientRest {
    
    @GetMapping("match/{id}")
    public ResponseEntity<?> getMatchById(@PathVariable(name = "id") Long id);

}

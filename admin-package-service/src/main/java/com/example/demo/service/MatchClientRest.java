package com.example.demo.service;

import com.example.demo.request.GetMatchByIdDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "match-service")
public interface MatchClientRest {
    
    @GetMapping("{id}")
    public ResponseEntity<?> getMatchById(@PathVariable(name = "id") Long id);

}

package com.example.Service.ServiceHealthInsurance.mapper;

import com.example.Service.ServiceHealthInsurance.dto.ErrorDTO;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class ErrorMapper {

    public ErrorDTO errorNotFoundMatch(){
        
        return ErrorDTO.builder()
            .code(404)
            .error(true)
            .message("Match not found")
            .build();
    }
}


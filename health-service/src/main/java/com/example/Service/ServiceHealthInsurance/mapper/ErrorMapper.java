package com.example.Service.ServiceHealthInsurance.mapper;

import com.example.Service.ServiceHealthInsurance.dto.ErrorDTO;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class ErrorMapper {

    public ErrorDTO errorNotFoundHealthInsurance(){
        
        return ErrorDTO.builder()
            .code(404)
            .error(true)
            .message("Health insurance not found")
            .build();
    }

    public ErrorDTO errorBadRequestHealthInsurance(){
        
        return ErrorDTO.builder()
            .code(400)
            .error(true)
            .message("Health insurance bad request")
            .build();
    }
}


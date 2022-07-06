package com.service.payment_service.mapper;

import org.springframework.stereotype.Component;

import com.service.payment_service.dto.ErrorDTO;

@Component
public class ErrorMapper {
    public ErrorDTO errorCardNoValid(){
        
        return ErrorDTO.builder()
            .code(400)
            .error(true)
            .message("Number Card not valid")
            .build();
    }
}

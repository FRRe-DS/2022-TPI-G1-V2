package com.api.service.lodging.mapper;

import com.api.service.lodging.dto.ErrorDTO;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ErrorMapper {
    public ErrorDTO errorNotFoundMatch(){
        
        return ErrorDTO.builder()
            .code(404)
            .error(true)
            .message("Match not found")
            .build();
    }
}

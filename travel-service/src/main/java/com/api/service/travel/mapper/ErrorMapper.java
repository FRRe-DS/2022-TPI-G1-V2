package com.api.service.travel.mapper;

import com.api.service.travel.dto.ErrorDTO;

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

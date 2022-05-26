package com.api.service.lodging.mapper;

import com.api.service.lodging.dto.ErrorDTO;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ErrorMapper {
    public ErrorDTO errorNotFoundLodging(){
        
        return ErrorDTO.builder()
            .code(404)
            .error(true)
            .message("Lodging not found")
            .build();
    }

    public ErrorDTO errorBadRequestLodging(){
        
        return ErrorDTO.builder()
            .code(400)
            .error(true)
            .message("Lodging bad request")
            .build();
    }
}

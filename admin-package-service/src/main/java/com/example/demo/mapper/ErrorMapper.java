package com.example.demo.mapper;

import com.example.demo.dto.ErrorDTO;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class ErrorMapper {

    public ErrorDTO errorNotFoundResouce(){
        
        return ErrorDTO.builder()
            .code(404)
            .error(true)
            .message("Resouce not found")
            .build();
    }
}

package com.api.service.lodging.controller;

import java.util.List;

import com.api.service.lodging.domain.Lodging;
import com.api.service.lodging.dto.ErrorDTO;
import com.api.service.lodging.dto.GetLodgingDTO;
import com.api.service.lodging.dto.LodgingDTO;
import com.api.service.lodging.dto.ResponseDTO;
import com.api.service.lodging.mapper.ErrorMapper;
import com.api.service.lodging.service.impl.LodgingServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/lodging")
public class LodgingController {
    
    private final LodgingServiceImpl lodgingServiceImpl;
    private final ErrorMapper errorMapper;
    @PostMapping
    public ResponseEntity<?> createdLodging(@RequestBody LodgingDTO lodgingDTO){
        Lodging lodging = lodgingServiceImpl.createLodging(lodgingDTO);

        ResponseDTO response = new ResponseDTO();
        
        response.setId(lodging.getId());
        response.setUrl("/lodging"+lodging.getId());


        return new ResponseEntity<ResponseDTO>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllLodging(){
        
        List<GetLodgingDTO> lodgings =  lodgingServiceImpl.getAllLodging();

        if(lodgings.isEmpty()){
            return new ResponseEntity<String>("No exists lodgings", HttpStatus.OK);
        }else{
            return new ResponseEntity<List<GetLodgingDTO>>(lodgings,  HttpStatus.OK);
        }
       
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getLodgingById(@PathVariable(name = "id") Long id){
        
        GetLodgingDTO lodging =  lodgingServiceImpl.getLodgingById(id);

        if(lodging == null){
            ErrorDTO error = errorMapper.errorNotFoundMatch();
            return new ResponseEntity<ErrorDTO>(error, HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<GetLodgingDTO>(lodging,  HttpStatus.OK);
        }
       
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLodgingById(@PathVariable(name = "id") Long id){
        
        Boolean response = lodgingServiceImpl.deleteLodgingById(id);

        if(response == false){
            ErrorDTO error = errorMapper.errorNotFoundMatch();
            return new ResponseEntity<ErrorDTO>(error, HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<Object>(Object.class,  HttpStatus.OK);
        }
       
    }






}

package com.api.service.travel.controller;

import java.util.List;

import com.api.service.travel.domain.Travel;
import com.api.service.travel.dto.ErrorDTO;
import com.api.service.travel.dto.GetTravelDTO;
import com.api.service.travel.dto.ResponseDTO;
import com.api.service.travel.dto.TravelDTO;
import com.api.service.travel.mapper.ErrorMapper;
import com.api.service.travel.service.impl.TravelServiceImpl;

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
public class TravelController {
    private final ErrorMapper errorMapper;
    private final TravelServiceImpl travelServiceImpl;

    @PostMapping
    public ResponseEntity<?> createTravel(@RequestBody TravelDTO travelDTO){
        ResponseDTO response = new ResponseDTO();
        
        Travel travel = travelServiceImpl.createTravel(travelDTO);

        response.setId(travel.getId());
        response.setUrl("/travel/"+travel.getId());
   
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getTravel(){
        

        List<GetTravelDTO> travels = travelServiceImpl.getTravels();
        
        if(travels == null){
            return new ResponseEntity<String>("No exists travels", HttpStatus.OK);
        }else{
            return new ResponseEntity<List<GetTravelDTO>>(travels, HttpStatus.OK);
        }
        
   
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTravelById(@PathVariable(name = "id") Long id){
        

        GetTravelDTO travels = travelServiceImpl.getTravelById(id);
        
        if(travels == null){
            ErrorDTO error = errorMapper.errorNotFoundMatch();
            return new ResponseEntity<ErrorDTO>(error, HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<GetTravelDTO>(travels, HttpStatus.OK);
        } 
   
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTravelById(@PathVariable(name = "id") Long id){

        Boolean response = travelServiceImpl.deleteTravelById(id);
        
        if(response == true){
            return new ResponseEntity<ResponseDTO>(new ResponseDTO(), HttpStatus.OK);
        }else{
            ErrorDTO error = errorMapper.errorNotFoundMatch();
            return new ResponseEntity<ErrorDTO>(error, HttpStatus.NOT_FOUND);
        }
    }

}

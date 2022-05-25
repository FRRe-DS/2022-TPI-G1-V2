package com.example.demo.controller;

import java.util.List;

import com.example.demo.domain.Pack;
import com.example.demo.dto.ErrorDTO;
import com.example.demo.dto.GetPackDTO;
import com.example.demo.dto.PostPackDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.mapper.ErrorMapper;
import com.example.demo.request.GetMatchByIdDTO;
import com.example.demo.service.impl.PackServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/admin/package")
public class PackController {

    private final PackServiceImpl packServiceImpl;
    private final ErrorMapper errorMapper;

    @PostMapping()
    public ResponseEntity<?> createPackage(@RequestBody PostPackDTO postPackDTO){
        ResponseDTO response = new ResponseDTO();

        Pack pack = packServiceImpl.createPack(postPackDTO);
       
        if(pack != null){
            response.setId(pack.getId());
            response.setUrl("/admin/package"+pack.getId());
            return new ResponseEntity<ResponseDTO>(response, HttpStatus.CREATED);
        }else{
            ErrorDTO error = errorMapper.errorNotFoundResouce();
            return new ResponseEntity<ErrorDTO>(error, HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping
    public ResponseEntity<?> getPacks(){
        List<GetPackDTO> packs = packServiceImpl.getAllPacks();
        
        if(packs == null){
            return new ResponseEntity<String>("No exists packs", HttpStatus.OK);
        }else{
            return new ResponseEntity<List<GetPackDTO>>(packs, HttpStatus.OK);
        }
        
    }

    @GetMapping("/matches/{id}")
    public Object getAllMatches(@PathVariable(name = "id") Long id){
        return packServiceImpl.getAllMatches(id).getBody();
        
       
    }
}

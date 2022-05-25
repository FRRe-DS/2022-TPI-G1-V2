package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.domain.Pack;
import com.example.demo.dto.GetPackDTO;
import com.example.demo.dto.PostPackDTO;
import com.example.demo.mapper.PackMapper;
import com.example.demo.repository.PackRepository;
import com.example.demo.request.GetMatchByIdDTO;
import com.example.demo.service.MatchClientRest;
import com.example.demo.service.PackService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PackServiceImpl implements PackService{
    
    private final MatchClientRest matchClientRest;
    private final PackMapper packMapper;
    private final PackRepository packRepository;

    @Override
    public Pack createPack(PostPackDTO postPackDTO) {
        
        Pack pack = packMapper.packMapper(postPackDTO);
        if(pack != null){
            return packRepository.save(pack);
        }else{
            return null;
        }
        
    }

    @Override
    public List<GetPackDTO> getAllPacks() {
        List<GetPackDTO> listPackResponse = new ArrayList<>();
        for (Pack pack : packRepository.findAll()) {
            listPackResponse.add(packMapper.packGetMapper(pack));
        }
        return listPackResponse;
    }

    @Override
    public ResponseEntity<?> getAllMatches(Long id) {
        
        return matchClientRest.getMatchById(id);
    }

    
}

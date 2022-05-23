package com.api.service.lodging.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.api.service.lodging.domain.Lodging;
import com.api.service.lodging.dto.GetLodgingDTO;
import com.api.service.lodging.dto.LodgingDTO;
import com.api.service.lodging.mapper.LodgingMapper;
import com.api.service.lodging.repository.LodgingRepository;
import com.api.service.lodging.service.LodgingService;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class LodgingServiceImpl implements LodgingService{

    private final LodgingRepository lodgingRepository;
    private final LodgingMapper lodgingMapper;

    @Override
    public Lodging createLodging(LodgingDTO lodgingDTO) {
        Lodging lodging = lodgingMapper.lodgingMapper(lodgingDTO);

        return lodgingRepository.save(lodging);
    }

    @Override
    public List<GetLodgingDTO> getAllLodging() {

        List<Lodging> lodgings = (List<Lodging>) lodgingRepository.findAll();
        
        
        return lodgingMapper.returnLodgings(lodgings);
    }

    @Override
    public GetLodgingDTO getLodgingById(Long id) {
        Optional<Lodging> lodging = lodgingRepository.findById(id);
        
        if(lodging.isPresent()){
            return lodgingMapper.returnLodging(lodging.get());
        }else{
            return null;
        }
    }

    @Override
    public Boolean deleteLodgingById(Long id) {
        Optional<Lodging> lodging = lodgingRepository.findById(id);
        
        if(lodging.isPresent()){
            lodgingRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
    

}



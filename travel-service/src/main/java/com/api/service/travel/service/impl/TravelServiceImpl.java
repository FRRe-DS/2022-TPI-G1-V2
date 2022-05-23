package com.api.service.travel.service.impl;

import java.util.List;
import java.util.Optional;

import com.api.service.travel.domain.Travel;
import com.api.service.travel.dto.GetTravelDTO;
import com.api.service.travel.dto.TravelDTO;
import com.api.service.travel.mapper.TravelMapper;
import com.api.service.travel.repository.TravelRepository;
import com.api.service.travel.service.TravelService;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TravelServiceImpl implements TravelService{

    private final TravelRepository travelRepository;
    private final TravelMapper travelMapper;
    @Override
    public Travel createTravel(TravelDTO travelDTO) {
        
        Travel travel = travelMapper.travelMapper(travelDTO);

        travelRepository.save(travel);

        return travel;

    }
    
    @Override
    public List<GetTravelDTO> getTravels() {
        List<Travel> travels = travelRepository.findAll();

        if(!travels.isEmpty()){
            return travelMapper.travelMapper(travels);
        }else{
            return null;
        }
    }

    @Override
    public GetTravelDTO getTravelById(Long id) {
        Optional<Travel> travel = travelRepository.findById(id);
        if(travel.isPresent()){
            return travelMapper.getTravelById(travel.get());
        }else{
            return null;
        }
    }

    @Override
    public Boolean deleteTravelById(Long id) {
        Optional<Travel> travel = travelRepository.findById(id);
        if(travel.isPresent()){
            travelRepository.delete(travel.get());
            return true;
        }else{
            return false;
        }
    }
    
}

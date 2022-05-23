package com.api.service.travel.service;

import java.util.List;

import com.api.service.travel.domain.Travel;
import com.api.service.travel.dto.GetTravelDTO;
import com.api.service.travel.dto.TravelDTO;

public interface TravelService {
    public Travel createTravel(TravelDTO travelDTO);
    public List<GetTravelDTO> getTravels();
    public GetTravelDTO getTravelById(Long id);
    public Boolean deleteTravelById(Long id);
}

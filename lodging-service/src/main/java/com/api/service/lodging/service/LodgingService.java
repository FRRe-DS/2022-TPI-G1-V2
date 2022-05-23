package com.api.service.lodging.service;

import java.util.List;

import com.api.service.lodging.domain.Lodging;
import com.api.service.lodging.dto.GetLodgingDTO;
import com.api.service.lodging.dto.LodgingDTO;

public interface LodgingService {
    public Lodging createLodging(LodgingDTO lodgingDTO);
    public List<GetLodgingDTO> getAllLodging();
    public GetLodgingDTO getLodgingById(Long id);
    public Boolean deleteLodgingById(Long id);
}

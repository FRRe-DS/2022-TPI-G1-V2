package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Pack;
import com.example.demo.dto.GetDetailPack;
import com.example.demo.dto.GetPackDTO;
import com.example.demo.dto.PostPackDTO;
import com.example.demo.request.GetMatchByIdDTO;

import org.springframework.http.ResponseEntity;

public interface PackService {
    public Pack createPack(PostPackDTO postPackDTO);
    public void updateStateOfPack(Long id);
    public GetDetailPack getPackById(Long id);
    public List<GetPackDTO> getAllPacks();
    public List<GetPackDTO> getAllPacksNotReserved();
}

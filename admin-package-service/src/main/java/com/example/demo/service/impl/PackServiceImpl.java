package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.domain.Pack;
import com.example.demo.dto.GetDetailPack;
import com.example.demo.dto.GetPackDTO;
import com.example.demo.dto.Payment;
import com.example.demo.dto.PaymentPostDTO;
import com.example.demo.dto.PostPackDTO;
import com.example.demo.mapper.PackMapper;
import com.example.demo.repository.PackRepository;
import com.example.demo.service.PackService;
import com.example.demo.service.PaymentClientRest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PackServiceImpl implements PackService{
    
    private final PackMapper packMapper;
    private final PaymentClientRest paymentClientRest;
    private final PackRepository packRepository;

    @Override
    public Pack createPack(PostPackDTO postPackDTO) {
        
        Pack pack = packMapper.packMapper(postPackDTO);
        if(pack != null){
            Pack newPack = packRepository.save(pack);

            PaymentPostDTO paymentPostDTO = 
            packMapper.paymentMapper(newPack.getId(), postPackDTO.getTotalDues());
            paymentClientRest.createPayment(paymentPostDTO);

            return packRepository.save(newPack);
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
    public List<GetPackDTO> getAllPacksNotReserved() {
        List<GetPackDTO> listPackResponse = new ArrayList<>();
        for (Pack pack : packRepository.findAll()) {
            if(pack.getReserved() == false){
                listPackResponse.add(packMapper.packGetMapper(pack));
            }
        }
        return listPackResponse;
    }

    @Override
    public GetDetailPack getPackById(Long id) {
       Payment payment = paymentClientRest.getPaymentByIdPackage(id);
       Pack pack = packRepository.findById(id).get();

       return packMapper.packDetailGetMapper(pack, payment);
    }

    @Override
    public void updateStateOfPack(Long id) {
        Pack pack = packRepository.findById(id).get();
        pack.setReserved(true);
        packRepository.save(pack);
    }
    
}

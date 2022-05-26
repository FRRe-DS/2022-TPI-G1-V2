package com.example.Service.ServiceHealthInsurance.service.impl;

import java.util.List;
import java.util.Optional;

import com.example.Service.ServiceHealthInsurance.domain.HealthInsurance;
import com.example.Service.ServiceHealthInsurance.domain.HealthService;
import com.example.Service.ServiceHealthInsurance.dto.GetHealthInsuranceDTO;
import com.example.Service.ServiceHealthInsurance.dto.HealthInsuranceDTO;
import com.example.Service.ServiceHealthInsurance.mapper.HealthInsuranceMapper;
import com.example.Service.ServiceHealthInsurance.repository.HealthInsuranceRepository;
import com.example.Service.ServiceHealthInsurance.repository.HealthServiceRepository;
import com.example.Service.ServiceHealthInsurance.service.HealthInsuranceService;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class HealthInsuranceServiceImpl implements HealthInsuranceService{

    private final HealthInsuranceMapper healthInsuranceMapper;
    private final HealthInsuranceRepository healthInsuranceRepository;
    private final HealthServiceRepository healthServiceRepository;
    @Override
    public HealthInsurance createHealth(HealthInsuranceDTO healthInsuranceDTO) {
        if(healthInsuranceDTO.getServices().isEmpty()) 
        return null; 
        
        return healthInsuranceRepository.save(
            healthInsuranceMapper.healthInsuranceMapper(healthInsuranceDTO));

    }

    @Override
    public List<GetHealthInsuranceDTO> getHealthService() {

        return healthInsuranceMapper.getHealthInsuranceMapper(
            healthInsuranceRepository.findAll());
    }

    @Override
    public HealthInsurance getHealthServiceById(Long id) {
        Optional<HealthInsurance> healthInsurance = healthInsuranceRepository.findById(id);
        if(healthInsurance.isPresent()){
            return healthInsurance.get();
        }else{
            return null; 
        }
        
    }

    @Override
    public Boolean deleteHealthServiceById(Long id) {
        Optional<HealthInsurance> healthInsurance = healthInsuranceRepository.findById(id);
        if(healthInsurance.isPresent()){
            healthInsuranceRepository.deleteById(id);
            return true;
        }else{
            return false; 
        }
    }

    @Override
    public List<HealthService> getServices() {

        return healthServiceRepository.findAll();
    }
    
}

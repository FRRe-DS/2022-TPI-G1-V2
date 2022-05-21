package com.example.Service.ServiceHealthInsurance.service.impl;

import java.util.List;

import com.example.Service.ServiceHealthInsurance.domain.HealthInsurance;
import com.example.Service.ServiceHealthInsurance.dto.HealthInsuranceDTO;
import com.example.Service.ServiceHealthInsurance.mapper.HealthInsuranceMapper;
import com.example.Service.ServiceHealthInsurance.repository.HealthInsuranceRepository;
import com.example.Service.ServiceHealthInsurance.service.HealthInsuranceService;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class HealthInsuranceServiceImpl implements HealthInsuranceService{

    private final HealthInsuranceMapper healthInsuranceMapper;
    private final HealthInsuranceRepository healthInsuranceRepository;

    @Override
    public HealthInsurance createHealth(HealthInsuranceDTO healthInsuranceDTO) {
        
        return healthInsuranceRepository.save(
            healthInsuranceMapper.HealthInsuranceMapper(healthInsuranceDTO));

    }

    @Override
    public List<HealthInsurance> getHealthService() {
        return healthInsuranceRepository.findAll();
    }

    @Override
    public HealthInsurance getHealthServiceById(Long id) {
        
        return healthInsuranceRepository.findById(id).get();
    }
    
}

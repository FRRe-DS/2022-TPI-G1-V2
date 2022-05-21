package com.example.Service.ServiceHealthInsurance.service;

import java.util.List;

import com.example.Service.ServiceHealthInsurance.domain.HealthInsurance;
import com.example.Service.ServiceHealthInsurance.dto.HealthInsuranceDTO;

public interface HealthInsuranceService {

    HealthInsurance createHealth(HealthInsuranceDTO healthInsuranceDTO);
    List<HealthInsurance> getHealthService();
    HealthInsurance getHealthServiceById(Long id);
}

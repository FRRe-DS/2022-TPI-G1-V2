package com.example.Service.ServiceHealthInsurance.service;

import java.util.List;

import com.example.Service.ServiceHealthInsurance.domain.HealthInsurance;
import com.example.Service.ServiceHealthInsurance.domain.HealthService;
import com.example.Service.ServiceHealthInsurance.dto.GetHealthInsuranceDTO;
import com.example.Service.ServiceHealthInsurance.dto.HealthInsuranceDTO;

public interface HealthInsuranceService {

    HealthInsurance createHealth(HealthInsuranceDTO healthInsuranceDTO);
    List<GetHealthInsuranceDTO> getHealthService();
    HealthInsurance getHealthServiceById(Long id);
    Boolean deleteHealthServiceById(Long id);
    List<HealthService> getServices();
}

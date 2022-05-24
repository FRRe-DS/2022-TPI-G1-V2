package com.example.Service.ServiceHealthInsurance.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.Service.ServiceHealthInsurance.domain.HealthInsurance;
import com.example.Service.ServiceHealthInsurance.domain.HealthService;
import com.example.Service.ServiceHealthInsurance.dto.GetHealthInsuranceDTO;
import com.example.Service.ServiceHealthInsurance.dto.HealthInsuranceDTO;
import com.example.Service.ServiceHealthInsurance.repository.HealthServiceRepository;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class HealthInsuranceMapper {

    private final HealthServiceRepository healthServiceRepository;
    public HealthInsurance healthInsuranceMapper(HealthInsuranceDTO healthInsuranceDTO){

        HealthInsurance healthInsurance = new HealthInsurance();

        healthInsurance.setDescription(healthInsuranceDTO.getDescription());
        healthInsurance.setServices(returnService(healthInsuranceDTO.getServices()));

        return healthInsurance;
    }
    
    public List<GetHealthInsuranceDTO> getHealthInsuranceMapper(List<HealthInsurance> healthInsurances){
        List<GetHealthInsuranceDTO> healthInsurance = new ArrayList<>();
        for (HealthInsurance health : healthInsurances) {
            healthInsurance.add(
                GetHealthInsuranceDTO.builder()
                    .url("/health/"+health.getId())
                    .description(health.getDescription())
                    .services(health.getServices())
                    .build()
            );
        }
        return healthInsurance;
    }

    private List<HealthService> returnService(List<Long> services){
        List<HealthService> lHealthServices = new ArrayList<>();
        for (Long s : services) {
            Optional<HealthService> healthServicesRequest = healthServiceRepository.findById(s);
            if(healthServicesRequest.isPresent()){
                lHealthServices.add(healthServicesRequest.get());
            }
        }
        return lHealthServices;
    }


}

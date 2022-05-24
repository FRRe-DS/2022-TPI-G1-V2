package com.example.Service.ServiceHealthInsurance.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.Service.ServiceHealthInsurance.domain.HealthService;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GetHealthInsuranceDTO {

    private String url;
    
    private String description; 

    private List<HealthService> services = new ArrayList<HealthService>();
}

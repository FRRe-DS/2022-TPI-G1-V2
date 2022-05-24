package com.example.Service.ServiceHealthInsurance.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HealthInsuranceDTO {
    private String description;
    private List<Long> services = new ArrayList<Long>();
}

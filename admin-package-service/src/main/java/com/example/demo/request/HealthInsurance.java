package com.example.demo.request;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class HealthInsurance {

    private Long id;
    private String description; 
    private List<HealthService> services = new ArrayList<HealthService>();
}

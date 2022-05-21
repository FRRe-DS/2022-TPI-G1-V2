package com.example.Service.ServiceHealthInsurance.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HealthInsurance {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "description", nullable = false, updatable = true)
    private String description; 

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH}, orphanRemoval = true)
    private List<HealthService> services = new ArrayList<HealthService>();
}

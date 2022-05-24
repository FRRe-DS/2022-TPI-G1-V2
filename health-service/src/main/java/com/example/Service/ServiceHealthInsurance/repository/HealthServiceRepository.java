package com.example.Service.ServiceHealthInsurance.repository;

import com.example.Service.ServiceHealthInsurance.domain.HealthService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthServiceRepository extends JpaRepository<HealthService,Long>{
    
}

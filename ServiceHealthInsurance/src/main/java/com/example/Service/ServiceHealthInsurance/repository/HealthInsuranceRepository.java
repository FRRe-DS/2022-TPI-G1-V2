package com.example.Service.ServiceHealthInsurance.repository;

import com.example.Service.ServiceHealthInsurance.domain.HealthInsurance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthInsuranceRepository extends JpaRepository<HealthInsurance,Long>{
    
}

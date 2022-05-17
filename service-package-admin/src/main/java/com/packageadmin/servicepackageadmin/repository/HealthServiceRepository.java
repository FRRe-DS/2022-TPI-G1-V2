package com.packageadmin.servicepackageadmin.repository;

import com.packageadmin.servicepackageadmin.domain.HealthService;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthServiceRepository extends JpaRepository<HealthService,Long>{
    
}

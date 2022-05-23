package com.api.service.travel.repository;

import com.api.service.travel.domain.Travel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelRepository extends JpaRepository<Travel,Long>{
    
}

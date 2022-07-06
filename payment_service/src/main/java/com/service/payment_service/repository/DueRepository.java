package com.service.payment_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.payment_service.domain.Dues;

@Repository
public interface DueRepository extends JpaRepository<Dues,Long>{
    
}

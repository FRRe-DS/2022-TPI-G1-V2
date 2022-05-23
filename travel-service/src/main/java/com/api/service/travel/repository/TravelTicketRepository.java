package com.api.service.travel.repository;

import com.api.service.travel.domain.TravelTicket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelTicketRepository extends JpaRepository<TravelTicket,Long>{
    
}

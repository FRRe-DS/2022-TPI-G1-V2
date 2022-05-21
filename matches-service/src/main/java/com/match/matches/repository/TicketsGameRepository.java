package com.match.matches.repository;

import com.match.matches.domain.MatchTicket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketsGameRepository extends JpaRepository<MatchTicket,Long>{
    
}

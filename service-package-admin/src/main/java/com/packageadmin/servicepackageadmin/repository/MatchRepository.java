package com.packageadmin.servicepackageadmin.repository;

import com.packageadmin.servicepackageadmin.domain.MatchGame;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<MatchGame,Long>{
    
}

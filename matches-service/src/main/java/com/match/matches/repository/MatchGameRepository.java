package com.match.matches.repository;

import com.match.matches.domain.MatchGame;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchGameRepository extends JpaRepository<MatchGame,Long>{
    
}

package com.example.demo.repository;

import com.example.demo.domain.Pack;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackRepository extends JpaRepository<Pack,Long>{
    
}

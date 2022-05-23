package com.api.service.lodging.repository;

import com.api.service.lodging.domain.Lodging;

import org.springframework.data.repository.CrudRepository;

public interface LodgingRepository extends CrudRepository<Lodging,Long>{
    
}

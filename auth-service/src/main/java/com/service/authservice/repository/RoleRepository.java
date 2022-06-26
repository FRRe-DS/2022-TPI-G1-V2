package com.service.authservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.authservice.domain.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role,Long>{
    Optional<Role> findByNameRole(String nameRole);
}
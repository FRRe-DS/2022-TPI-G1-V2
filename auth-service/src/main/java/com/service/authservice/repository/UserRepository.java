package com.service.authservice.repository;

import org.springframework.stereotype.Repository;

import com.service.authservice.domain.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    Optional<User> findByEmail(String email);
}

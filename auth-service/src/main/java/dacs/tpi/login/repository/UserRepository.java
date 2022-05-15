package dacs.tpi.login.repository;

import org.springframework.stereotype.Repository;
import dacs.tpi.login.domain.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    Optional<User> findByEmail(String email);
}

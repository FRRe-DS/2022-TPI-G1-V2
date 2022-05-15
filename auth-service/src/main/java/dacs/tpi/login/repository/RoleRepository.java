package dacs.tpi.login.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dacs.tpi.login.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long>{
    Optional<Role> findByNameRole(String nameRole);
}

package com.packageadmin.servicepackageadmin.repository;
import com.packageadmin.servicepackageadmin.domain.Package;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageRepository extends JpaRepository<Package,Long>{
    
}

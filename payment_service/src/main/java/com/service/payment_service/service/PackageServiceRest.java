package com.service.payment_service.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "package-admin-service")
public interface PackageServiceRest {
    @PutMapping("{id}")
    public void updateStateOfPack(@PathVariable(name = "id") Long id);
}

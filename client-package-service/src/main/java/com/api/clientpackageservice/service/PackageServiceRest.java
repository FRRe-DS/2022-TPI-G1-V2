package com.api.clientpackageservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "package-admin-service")
public interface PackageServiceRest {

    @GetMapping("{idPack}")
    public ResponseEntity<?> getPackById(@PathVariable(name = "idPack") Long idPack);

    @GetMapping("notreserved")
    public ResponseEntity<?> getPacksNotReserved();
}

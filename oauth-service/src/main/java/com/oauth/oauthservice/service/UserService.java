package com.oauth.oauthservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.usercommons.usercommons.domain.User;

@FeignClient(name="auth-service")
public interface UserService {
    
    @GetMapping("/api/v1/users")
    public User getUserByEmail(@RequestParam String email);
}

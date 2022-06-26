package com.service.authservice.controller;



import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.authservice.domain.User;
import com.service.authservice.dto.forms.user.PostUserDTO;
import com.service.authservice.dto.response.ResponsePost;
import com.service.authservice.mapper.UserMapper;
import com.service.authservice.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    
    private final AuthService authService;
    private final UserMapper userMapper;
    
    @PostMapping("/register")
    public ResponseEntity<ResponsePost> createUser(@RequestBody PostUserDTO user){
        User newUser = authService.createUser(user);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(userMapper.mapperResponsePost(newUser));
    }
    
    @GetMapping("/users")
    public ResponseEntity<List<User>> getallUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(authService.getUser()); 
    }
}

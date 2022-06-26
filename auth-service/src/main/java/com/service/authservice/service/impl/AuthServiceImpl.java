package com.service.authservice.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.service.authservice.domain.User;
import com.service.authservice.dto.forms.user.PostUserDTO;
import com.service.authservice.dto.forms.user.UserDTO;
import com.service.authservice.mapper.UserMapper;
import com.service.authservice.repository.UserRepository;
import com.service.authservice.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class  AuthServiceImpl implements AuthService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    
    @Override
    public User createUser(PostUserDTO user) {

        return userRepository.save(userMapper.mapperNewUser(user));
    }

    @Override
    public User createAdmin(PostUserDTO user) {
        return userRepository.save(userMapper.mapperNewAdmin(user));
    }

    @Override
    public UserDTO deleteUser(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<User> getUser() {
        return userRepository.findAll();
    }
    
}

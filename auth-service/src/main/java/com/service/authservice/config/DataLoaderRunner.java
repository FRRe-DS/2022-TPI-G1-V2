package com.service.authservice.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.service.authservice.domain.Role;
import com.service.authservice.domain.User;
import com.service.authservice.dto.forms.user.PostUserDTO;
import com.service.authservice.mapper.UserMapper;
import com.service.authservice.repository.RoleRepository;
import com.service.authservice.repository.UserRepository;

import java.util.stream.Collectors;


import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class DataLoaderRunner implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final SecurityJwtBeans securityJwtBeans;
    
    @Override
    public void run(String... args) throws Exception {
        createRoles();
        createAdmin();
    }

    private void createRoles(){
        if(roleRepository.findAll().isEmpty()){
            Role roleAdmin = new Role();
            Role roleUser = new Role();
            roleAdmin.setNameRole("ROLE_ADMIN");
            roleUser.setNameRole("ROLE_USER");

            roleRepository.save(roleAdmin);
            roleRepository.save(roleUser);
        }
    }

    private void createAdmin(){
        List<User> users = userRepository.findAll(); 
        if(users.isEmpty()){
            if(!adminExists(users)){
                System.out.println("No hay admins");
                PostUserDTO user = new PostUserDTO();
                user.setEmail("admin@mail.com");
                user.setPassword(securityJwtBeans.passwordEncoder().encode("admin"));
                userRepository.save(userMapper.mapperNewAdmin(user));
            }
        }
    }

    private boolean adminExists(List<User> users){
        if(users.stream().filter(
            user -> (user.getRoles().stream()
            .filter(role -> role.getNameRole().equals("ROLE_ADMIN"))
            .collect(Collectors.toList()).size() > 0 ))
            .collect(Collectors.toList()).size() > 0){
            
            return true;
        }else{
            return false;
        }
    }
}

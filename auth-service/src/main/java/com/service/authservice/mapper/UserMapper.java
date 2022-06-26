package com.service.authservice.mapper;
import java.util.Optional;


import org.springframework.stereotype.Component;

import com.service.authservice.domain.Role;
import com.service.authservice.domain.User;
import com.service.authservice.dto.forms.user.PostUserDTO;
import com.service.authservice.dto.response.ResponsePost;
import com.service.authservice.repository.RoleRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserMapper {
    private final RoleRepository roleRepository;

    public User mapperNewUser(PostUserDTO user){
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        setRoleUser(newUser);
        return newUser;
    }

    public User mapperNewAdmin(PostUserDTO user){
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        setRoleAdmin(newUser);
        return newUser;
    }
    
    public ResponsePost mapperResponsePost(User user){
        ResponsePost response = new ResponsePost();
        response.setId(user.getId());
        response.setUrl("/auth/me");

        return response;
    }

    private void setRoleUser(User newUser){
        String nameRole = "ROLE_USER";
        Optional<Role> role = roleRepository.findByNameRole(nameRole);
        
        newUser.getRoles().add(role.get());
    }

    private void setRoleAdmin(User newUser){
        String nameRole = "ROLE_ADMIN";
        Optional<Role> role = roleRepository.findByNameRole(nameRole);
        
        newUser.getRoles().add(role.get());
    }

}

package com.service.authservice.service;

import java.util.List;


import com.service.authservice.domain.User;
import com.service.authservice.dto.forms.user.PostUserDTO;
import com.service.authservice.dto.forms.user.UserDTO;


public interface AuthService {
    public User createUser(PostUserDTO user);
    public User getUserByEmail(String email);
    public User createAdmin(PostUserDTO user);
    public UserDTO deleteUser(Long id);
    public List<User> getUser();
}

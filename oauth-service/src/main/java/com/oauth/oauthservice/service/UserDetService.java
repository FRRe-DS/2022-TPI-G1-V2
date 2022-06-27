package com.oauth.oauthservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.usercommons.usercommons.domain.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserDetService implements UserDetailsService{

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        User user = userService.getUserByEmail(username);

        if(user == null){
            throw new UsernameNotFoundException("Error user not found");
        }

        List<GrantedAuthority> authorities = user.getRoles()
        .stream()
        .map(role -> new SimpleGrantedAuthority(role.getNameRole()))
        .collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(
            username,
            user.getPassword(), 
            true, 
            true, 
            true, 
            true, 
            authorities);
    }
    
}

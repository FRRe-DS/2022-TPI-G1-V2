package dacs.tpi.login.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dacs.tpi.login.domain.Role;
import dacs.tpi.login.domain.User;
import dacs.tpi.login.dto.forms.user.PostUserDTO;
import dacs.tpi.login.dto.forms.user.UserDTO;
import dacs.tpi.login.dto.response.ResponsePost;
import dacs.tpi.login.dto.response.tokens.Tokens;
import dacs.tpi.login.mapper.UserMapper;
import dacs.tpi.login.repository.RoleRepository;
import dacs.tpi.login.repository.UserRepository;
import dacs.tpi.login.service.AuthService;
import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService,UserDetailsService{

    
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
        // TODO Auto-generated method stub
        return userRepository.findAll();
    }

    @Override
    public void refreshToken(HttpServletRequest request, HttpServletResponse response)
            throws StreamWriteException, DatabindException, IOException {
                String authorizationHeader = request.getHeader("AUTHORIZATION");
                if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                    try {
                        String refreshToken = authorizationHeader.substring("Bearer ".length());
                        Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                        JWTVerifier jwtVerifier = JWT.require(algorithm).build();
                        DecodedJWT decodedJWT = jwtVerifier.verify(refreshToken);
                        String email = decodedJWT.getSubject();
                        Optional<User> user = userRepository.findByEmail(email);
                        String accessToken = JWT.create()
                                .withSubject(user.get().getEmail())
                                .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000)) //Diez minutos de vida
                                .withIssuer(request.getRequestURL().toString())
                                .withClaim("roles", user.get().getRoles().stream().map(Role::getNameRole).collect(Collectors.toList()))
                                .sign(algorithm);
                        Tokens tokens = new Tokens();
                        tokens.setAccessToken(accessToken);
                        tokens.setRefreshToken(refreshToken);
                        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                        new ObjectMapper().writeValue(response.getOutputStream(), tokens);
                    } catch (Exception e) {
                        response.setHeader("error", e.getMessage());
                        response.setStatus(HttpStatus.FORBIDDEN.value());
                        Map<String, String> error = new HashMap<>();
                        error.put("error_message", e.getMessage());
                        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                        new ObjectMapper().writeValue(response.getOutputStream(), error);
                    }
                } else {
                    throw new RuntimeException("Refresh token is missing");
                }
        
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(email);
        if (!user.isPresent()) {
            //Usuario no encontrado.
            throw new UsernameNotFoundException("{error.user.notfound}");
        }
        //Tomamos todos los roles
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        
        user.get().getRoles()
            .forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getNameRole())));
        return new org.springframework.security.core.userdetails.User(
                user.get().getEmail(),
                user.get().getPassword(),
                authorities);
    }

    @Override
    public User getInfoUser() throws NotFoundException {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof User){
            String username = ((User)principal).getEmail();
        }else{
            String username = principal.toString();
        }
        return userRepository.findByEmail(principal.toString()).get();
    }


    
}

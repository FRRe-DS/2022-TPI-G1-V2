package dacs.tpi.login.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dacs.tpi.login.domain.User;
import dacs.tpi.login.dto.forms.user.PostUserDTO;
import dacs.tpi.login.dto.response.ResponsePost;
import dacs.tpi.login.mapper.UserMapper;
import dacs.tpi.login.service.AuthService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    
    private final AuthService authService;
    private final UserMapper userMapper;
    
    @PostMapping("/register")
    public ResponseEntity<ResponsePost> createUser(@Valid @RequestBody PostUserDTO user){
        User newUser = authService.createUser(user);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(userMapper.mapperResponsePost(newUser));
    }

    @GetMapping("/me")
    public ResponseEntity<User> getUserLogged() throws NotFoundException{
        return ResponseEntity.status(HttpStatus.OK).body(authService.getInfoUser()); 
    }

    //TODO ELIMINAR EL ENDPOINT GETUSERS
    @GetMapping("/users")
    public ResponseEntity<List<User>> getallUsers() throws NotFoundException{
        return ResponseEntity.status(HttpStatus.OK).body(authService.getUser()); 
    }

    @GetMapping("/token/refresh")
    public void refreshToken(HttpServletRequest request,
                            HttpServletResponse response) throws IOException {
            authService.refreshToken(request, response);
    }
    
}

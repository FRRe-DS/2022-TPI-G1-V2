package dacs.tpi.login.mapper;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import dacs.tpi.login.domain.Role;
import dacs.tpi.login.domain.User;
import dacs.tpi.login.dto.forms.user.PostUserDTO;
import dacs.tpi.login.dto.response.ResponsePost;
import dacs.tpi.login.repository.RoleRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserMapper {
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    
    public User mapperNewUser(PostUserDTO user){
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        setRoleUser(newUser);
        return newUser;
    }

    public User mapperNewAdmin(PostUserDTO user){
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
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

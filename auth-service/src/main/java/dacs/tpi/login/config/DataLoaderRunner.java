package dacs.tpi.login.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

import dacs.tpi.login.domain.Role;
import dacs.tpi.login.domain.User;
import dacs.tpi.login.dto.forms.user.PostUserDTO;
import dacs.tpi.login.mapper.UserMapper;
import dacs.tpi.login.repository.RoleRepository;
import dacs.tpi.login.repository.UserRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class DataLoaderRunner implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    
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
                user.setPassword("admin");
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

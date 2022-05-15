package dacs.tpi.login.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import dacs.tpi.login.domain.User;
import dacs.tpi.login.dto.forms.user.PostUserDTO;
import dacs.tpi.login.dto.forms.user.UserDTO;

public interface AuthService {
    public User createUser(PostUserDTO user);
    public User createAdmin(PostUserDTO user);
    public UserDTO deleteUser(Long id);
    public List<User> getUser();
    User getInfoUser() throws NotFoundException;
    public void refreshToken(HttpServletRequest request,HttpServletResponse response) throws StreamWriteException, DatabindException, IOException;
}

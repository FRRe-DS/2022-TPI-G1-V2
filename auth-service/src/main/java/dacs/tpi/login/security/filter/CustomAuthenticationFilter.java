package dacs.tpi.login.security.filter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Date;

import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import dacs.tpi.login.dto.response.tokens.Tokens;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.stream.Collectors;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
    
    private final AuthenticationManager authenticationManager;
    
    /**
     * De la request obtengo el email y password. 
     * Creamos la clase UsernamePasswordAuthenticationToken y le pasamos email y pass.
     * El manager se encarga de autenticarlo.
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //Log para demostracion, luego debe ser eliminado
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        return authenticationManager.authenticate(authenticationToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
        HttpServletResponse response,
        FilterChain chain,
        Authentication authResult) throws IOException, ServletException {
        
                User user = (User) authResult.getPrincipal();   
                Algorithm algorithm = Algorithm.HMAC256("DACSTPI".getBytes());
                //Generamos token de acceso
                String accessToken = JWT.create()
                    .withSubject(user.getUsername())
                    .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000)) //10 minutos de validacion del token
                    .withIssuer(request.getRequestURL().toString())                        
                    .withClaim("roles", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                    .sign(algorithm);
                //Generamos token de refresco
                String refreshToken = JWT.create()
                    .withSubject(user.getUsername())
                    .withExpiresAt(new Date(System.currentTimeMillis() + 30 * 60 * 1000)) //Treinta minutos de vida
                    .withIssuer(request.getRequestURL().toString())
                    .withClaim("roles", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                    .sign(algorithm);
                
                //Seteamos en un objeto los dos tokens.
                Tokens tokens = new Tokens();
                tokens.setAccessToken(accessToken);
                tokens.setRefreshToken(refreshToken);
                //Indicamos que el tipo de la respuesta será JSON
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                //Object mapper escribe en response el objeto con formato json.
                new ObjectMapper().writeValue(response.getOutputStream(), tokens);
    
                }


}

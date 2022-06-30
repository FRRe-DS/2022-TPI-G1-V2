package com.oauth.oauthservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import lombok.RequiredArgsConstructor;


@Configuration
@EnableAuthorizationServer
@RequiredArgsConstructor
public class AuthorizarionServerConfig extends AuthorizationServerConfigurerAdapter{
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final AuthenticationManager authenticationManager;

    public void configure(AuthorizationServerSecurityConfigurer security )throws Exception {
        //Es el permiso que tienen nuetros endpoints para capturar el token y validarlo
        security.tokenKeyAccess("permitAll()")
        .checkTokenAccess("isAuthenticated()");

    }


    public void configure(ClientDetailsServiceConfigurer clients )throws Exception {
        //Registrar la aplicacion que se conecta a la aplicacion
        clients.inMemory().withClient("angularapp")
        .secret(bCryptPasswordEncoder
        .encode("secret"))
        .scopes("read","write")
        .authorizedGrantTypes("password","refresh_token")
        .accessTokenValiditySeconds(3600)
        .refreshTokenValiditySeconds(3600); 
    }
        
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception{
        //El endpoint precisamente es oauth/token dodne recibe el username, password, ROLE
        
        endpoints.authenticationManager(authenticationManager)
        .tokenStore(tokenStore())
        .accessTokenConverter(accessTokenConverter());
    }

    @Bean
    JwtTokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setSigningKey("secret");
        return jwtAccessTokenConverter;
    }
}

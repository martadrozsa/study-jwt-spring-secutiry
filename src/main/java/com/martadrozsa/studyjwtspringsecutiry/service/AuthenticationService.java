package com.martadrozsa.studyjwtspringsecutiry.service;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;

    // Retorna o JWT se autenticado com sucesso; retorna null se autenticação falhou.
    public String authenticate(String username, String password) {
        try {
            // Pede para o Spring Security autenticar o usuário por nome e senha. Se Spring não reclamar, sucesso!
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username, password);
            Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

            UserDetails principal = (UserDetails) authenticate.getPrincipal();
            //return jwtTokenUtil.generateToken(principal);
            return null;
        } catch (Exception e) {
            System.out.println("Authenticação falhou!! " + e);
            return null;
        }
    }

}

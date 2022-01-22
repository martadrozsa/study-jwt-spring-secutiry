package com.martadrozsa.studyjwtspringsecutiry.config;

import com.martadrozsa.studyjwtspringsecutiry.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Slf4j
@AllArgsConstructor
@Service
public class DbUserDetailsService implements UserDetailsService {

    private final UserService userBusiness;

    @Override
    public UserDetails loadUserByUsername(String login) {
        com.martadrozsa.studyjwtspringsecutiry.entities.User sysUser = userBusiness.findByLogin(login);
        if (sysUser == null) {
            log.info("User {} not found!", login);
            return null;
        }

        // TODO: add authority.
//        return new User(sysUser.getLogin(), sysUser.getPassword(), List.of("ROLE_READ_MOVIES", "ROLE_WRITE_MOVIES"));
        return new org.springframework.security.core.userdetails.User(sysUser.getLogin(), sysUser.getPassword(), new ArrayList<>());
    }
}

package com.martadrozsa.studyjwtspringsecutiry.service;

import com.martadrozsa.studyjwtspringsecutiry.entities.User;
import com.martadrozsa.studyjwtspringsecutiry.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public User findByLogin(final String login) {
        return userRepository.findByLogin(login);
    }

    public void create(final String username, final String password) {
//        assertNewUserInfo(user);
        String pwdHash = BCrypt.hashpw(password, BCrypt.gensalt());

        User user = new User();
        user.setPassword(pwdHash);
        user.setLogin(username);
        userRepository.save(user);

        System.out.println("User created! " + user);
    }
}

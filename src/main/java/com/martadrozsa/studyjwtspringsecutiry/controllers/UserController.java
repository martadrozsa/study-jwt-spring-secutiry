package com.martadrozsa.studyjwtspringsecutiry.controllers;

import com.martadrozsa.studyjwtspringsecutiry.dto.UserDTO;

import com.martadrozsa.studyjwtspringsecutiry.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void create(@RequestBody UserDTO userDTO) {
        userService.create(userDTO.getUsername(), userDTO.getPassword());
    }

}

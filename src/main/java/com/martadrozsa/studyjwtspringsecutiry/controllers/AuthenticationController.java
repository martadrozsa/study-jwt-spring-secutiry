package com.martadrozsa.studyjwtspringsecutiry.controllers;

import com.martadrozsa.studyjwtspringsecutiry.service.AuthenticationService;
import com.martadrozsa.studyjwtspringsecutiry.dto.AuthenticationDataDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("authenticate")
public class AuthenticationController {

    private final AuthenticationService authenticationBusiness;

    //@RequestBody mapeando o body da requisição para o tipo AuthenticationDataDto
    @PostMapping
    public ResponseEntity<Void> authenticate(@RequestBody AuthenticationDataDto request) {
        String jwt = authenticationBusiness.authenticate(request.getUsername(), request.getPassword());
        if (jwt == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

        return ResponseEntity.ok().build();
    }

}

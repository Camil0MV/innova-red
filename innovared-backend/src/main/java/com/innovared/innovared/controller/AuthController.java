package com.innovared.innovared.controller;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;

import com.innovared.innovared.dto.LoginRequest;
import com.innovared.innovared.dto.LoginResponse;
import com.innovared.innovared.dto.SignupRequest;
import com.innovared.innovared.model.Person;
import com.innovared.innovared.service.AuthService;
import com.innovared.innovared.service.PersonService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final PersonService personService;
    private final AuthService authService;    

    public AuthController(PersonService personService, AuthService authService) {
        this.personService = personService;
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<Person> register(@Valid @RequestBody SignupRequest request) {
        return ResponseEntity.ok(personService.register(request));
    }

    @GetMapping("/me")
    public ResponseEntity<String> getAuthenticatedUser(Authentication authentication) {
        String username = authentication.getName();
        return ResponseEntity.ok("Usuario autenticado: " + username);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
}

package com.example.Practise.service;

import com.example.Practise.config.JwtService;
import com.example.Practise.model.Role;
import com.example.Practise.model.Student;
import com.example.Practise.repository.StudentRepository;
import com.example.Practise.auth.AuthenticationRequest;
import com.example.Practise.auth.RegisterRequest;
import com.example.Practise.auth.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
public class AuthenticationService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest registerRequest) {
        var user = Student.builder()
                .firstname(registerRequest.getFirstname())
                .lastname(registerRequest.getLastname())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(Role.ROLE_STUDENT)
                .build();
        studentRepository.save(user);

        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getEmail(),
                        authenticationRequest.getPassword()
                )
        );
        var user = studentRepository.findByEmail(authenticationRequest.getEmail());

        var jwtToken = jwtService.generateToken(user.get());

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}

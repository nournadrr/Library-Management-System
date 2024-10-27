package com.managementsystem.library_management_system.service.IMPL;

import com.managementsystem.library_management_system.dto.AuthenticationRequest;
import com.managementsystem.library_management_system.auth.AuthenticationResponse;
import com.managementsystem.library_management_system.dto.RegisterRequest;
import com.managementsystem.library_management_system.config.JwtService;
import com.managementsystem.library_management_system.entity.Role;
import com.managementsystem.library_management_system.entity.User;
import com.managementsystem.library_management_system.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder().firstname(request.getFirstName())
                .lastname(request.getLastName())
                .email(request.getEmail()).
                password(passwordEncoder.encode(request.getPassword()))
                .role(Role.valueOf(request.getRole())).build();
        userRepo.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail()
                    , request.getPassword()));
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        }

        var user = userRepo.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}

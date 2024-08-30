package com.example.AnimalShelter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.AnimalShelter.config.JwtService;
import com.example.AnimalShelter.controller.UserDto;
import com.example.AnimalShelter.model.AuthResponseDto;
import com.example.AnimalShelter.model.RegisterRequestDto;
import com.example.AnimalShelter.model.Role;
import com.example.AnimalShelter.model.User;
import com.example.AnimalShelter.repositories.IShelterRepositoryUser;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ShelterServiceUserImpl implements ShelterServiceUser {
    @Autowired
    private final IShelterRepositoryUser iShelterRepositoryUser;
    @Autowired
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private final JwtService jwtservice;
    @Autowired
    private final AuthenticationManager authenticationManager;
    
    @Override
    public AuthResponseDto register(RegisterRequestDto request) {
        var user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
            iShelterRepositoryUser.save(user);
            var jwtToken = jwtservice.generateToken(user);
            return AuthResponseDto.builder()
                .token(jwtToken).build();

    }

    @Override
    public AuthResponseDto authenticate(UserDto request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
            )
        );
        var user = iShelterRepositoryUser.findUserByUsername(request.getUsername()).orElseThrow();
        var jwtToken = jwtservice.generateToken(user);
        return AuthResponseDto.builder().token(jwtToken).build(); 
    }

}


    


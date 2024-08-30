package com.example.AnimalShelter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AnimalShelter.model.AuthResponseDto;    
import com.example.AnimalShelter.model.RegisterRequestDto;
import com.example.AnimalShelter.service.ShelterServiceUser;


@RestController 
@RequestMapping("/api")
public class ShelterControllerUser {

    @Autowired
    ShelterServiceUser shelterServiceUser;

    @PostMapping(path = "/auth/signup")
    public ResponseEntity<AuthResponseDto> register(@RequestBody RegisterRequestDto request){
        return ResponseEntity.ok(shelterServiceUser.register(request));
    }

    @PostMapping(path = "/auth/signin")
    public ResponseEntity<AuthResponseDto> register(@RequestBody UserDto request){
        return ResponseEntity.ok(shelterServiceUser.authenticate(request));
    }
    
}

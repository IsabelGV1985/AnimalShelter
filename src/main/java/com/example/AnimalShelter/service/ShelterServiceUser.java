package com.example.AnimalShelter.service;

import com.example.AnimalShelter.controller.UserDto;
import com.example.AnimalShelter.model.AuthResponseDto;
import com.example.AnimalShelter.model.RegisterRequestDto;

public interface ShelterServiceUser {

    AuthResponseDto register(RegisterRequestDto request);

    AuthResponseDto authenticate(UserDto request);
}

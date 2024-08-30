package com.example.AnimalShelter.controller;

import com.example.AnimalShelter.controller.ShelterControllerUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")

public class ShelterControllerUser {

    @Autowired
    ShelterControllerUser shelterControllerUser;
}

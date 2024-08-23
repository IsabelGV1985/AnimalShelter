package com.example.AnimalShelter.controller;

import com.example.AnimalShelter.service.ShelterServicePet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")

public class ShelterControllerPet {

         @Autowired
        ShelterServicePet shelterServicePet;


}

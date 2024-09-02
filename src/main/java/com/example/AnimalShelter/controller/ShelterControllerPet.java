package com.example.AnimalShelter.controller;

import com.example.AnimalShelter.model.Pet;
import com.example.AnimalShelter.service.ShelterServicePet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pet")
public class ShelterControllerPet {

    @Autowired
    ShelterServicePet shelterServicePet;

    @PostMapping
    public ResponseEntity<Pet> createPet(@RequestBody Pet pet) {
        Pet createPet = ShelterServicePet.createPet(pet);
        return ResponseEntity.ok(createPet);

    }
}

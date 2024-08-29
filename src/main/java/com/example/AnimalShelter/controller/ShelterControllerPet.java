package com.example.AnimalShelter.controller;


import com.example.AnimalShelter.model.Pet;
import com.example.AnimalShelter.service.ShelterServicePet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pet")
public class ShelterControllerPet {

    @Autowired
    ShelterServicePet shelterServicePet;

    @DeleteMapping("/pets/{id}")
    public void deletePet(@PathVariable Long id) {
        shelterServicePet.deletePetById(id);
    }

    @GetMapping("/pets")
    public List<Pet> getAllPet() {
    return shelterServicePet.getAllPet();
    }

    @GetMapping("/pet/{id}")
    public Pet getPetById(@PathVariable("id") Long id) {
    return shelterServicePet.getById(id);
    }

}
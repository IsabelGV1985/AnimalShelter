package com.example.AnimalShelter.controller;


import com.example.AnimalShelter.model.Pet;
import com.example.AnimalShelter.service.ShelterServicePet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class ShelterControllerPet {

    @Autowired
    ShelterServicePet shelterServicePet;

    @DeleteMapping("/pets/{id}")
    public void deletePet(@PathVariable Long id) {
        shelterServicePet.deletePetById(id);
    }

    @GetMapping("/pets")
    public List<Pet> getAllPets() {
        return shelterServicePet.findAll();
    }

    @GetMapping("/pets/{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable Long id) {
        return shelterServicePet.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
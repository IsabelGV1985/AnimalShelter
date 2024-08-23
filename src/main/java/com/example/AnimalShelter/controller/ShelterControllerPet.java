package com.example.AnimalShelter.controller;

import com.example.AnimalShelter.service.ShelterServicePet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ShelterControllerPet {

    @Autowired
    ShelterServicePet shelterServicePet;

    @DeleteMapping("/pets/{id}")
    public void deletePet(@PathVariable Long id) {
        shelterServicePet.deletePetById(id);
    }
}

package com.example.AnimalShelter.service;

import com.example.AnimalShelter.model.Pet;
import com.example.AnimalShelter.repositories.IShelterRepositoryPet;
import org.springframework.beans.factory.annotation.Autowired;

public class ShelterServicePet {

    @Autowired
    IShelterRepositoryPet iShelterRepositoryPet;

    public Pet createPet (Pet pet) {
        return iShelterRepositoryPet.save(pet);

    }
}
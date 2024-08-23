package com.example.AnimalShelter.service;

import com.example.AnimalShelter.model.Pet;
import com.example.AnimalShelter.repositories.IShelterRepositoryPet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShelterServicePet {

    @Autowired
    IShelterRepositoryPet iShelterRepositoryPet;

    public Pet createPet(Pet newPet) {
        return iShelterRepositoryPet.save(newPet);
    }

}

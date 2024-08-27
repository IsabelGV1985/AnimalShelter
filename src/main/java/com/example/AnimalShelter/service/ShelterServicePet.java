package com.example.AnimalShelter.service;

import com.example.AnimalShelter.repositories.IShelterRepositoryPet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShelterServicePet {

    @Autowired
    IShelterRepositoryPet iShelterRepositoryPet;

public void deletePetById(Long id){
    if (iShelterRepositoryPet.existsById(id)){
        iShelterRepositoryPet.deleteById(id);
        } else {
        throw new IllegalArgumentException("Pet entry does not exist");
        }
    }
}
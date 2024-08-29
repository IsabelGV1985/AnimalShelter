package com.example.AnimalShelter.service;

import com.example.AnimalShelter.model.Pet;
import com.example.AnimalShelter.repositories.IShelterRepositoryPet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Pet> getAllPet() {
        return (List<Pet>) iShelterRepositoryPet.findAll();
    }

    public Pet getById(Long id) {
        Pet pet;
        pet = iShelterRepositoryPet.findById(id).orElseThrow();
        return pet;

    }
}
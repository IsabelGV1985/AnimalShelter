package com.example.AnimalShelter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AnimalShelter.model.Adoption;
import com.example.AnimalShelter.repositories.IShelterRepositoryAdoption;

@Service
public class ShelterServiceAdoption {

    @Autowired
    IShelterRepositoryAdoption iShelterRepositoryAdoption;

    public void deleteAdoptionById(Long id){
        if (iShelterRepositoryAdoption.existsById(id)){
            iShelterRepositoryAdoption.deleteById(id);
        } else {
            throw new IllegalArgumentException("Adoption entry does not exist");
        }
    }

    public Adoption createAdoption(Adoption adoption) {
        return iShelterRepositoryAdoption.save(adoption);
    }

}

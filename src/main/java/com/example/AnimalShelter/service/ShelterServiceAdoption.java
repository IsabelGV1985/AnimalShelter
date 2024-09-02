package com.example.AnimalShelter.service;

import com.example.AnimalShelter.model.Adoption;
import com.example.AnimalShelter.repositories.IShelterRepositoryAdoption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShelterServiceAdoption {

    @Autowired
    private IShelterRepositoryAdoption iShelterRepositoryAdoption;

    public Adoption createAdoption(Adoption adoption) {
        return iShelterRepositoryAdoption.save(adoption);
    }
}


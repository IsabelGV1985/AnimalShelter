package com.example.AnimalShelter.service;

import com.example.AnimalShelter.repositories.IShelterRepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShelterServiceUser {

    @Autowired
    IShelterRepositoryUser iShelterRepositoryUser;
}

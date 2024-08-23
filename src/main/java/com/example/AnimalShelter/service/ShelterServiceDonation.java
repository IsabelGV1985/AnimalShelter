package com.example.AnimalShelter.service;

import com.example.AnimalShelter.model.Donation;
import com.example.AnimalShelter.repositories.IShelterRepositoryDonation;
import org.springframework.beans.factory.annotation.Autowired;

public class ShelterServiceDonation {

    @Autowired
    IShelterRepositoryDonation iShelterRepositoryDonation;
}

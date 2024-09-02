package com.example.AnimalShelter.service;

import com.example.AnimalShelter.model.Donation;
import com.example.AnimalShelter.repositories.IShelterRepositoryDonation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShelterServiceDonation {

    @Autowired
    private IShelterRepositoryDonation iShelterRepositoryDonation;

    public Donation createDonation(Donation donation) {
        return iShelterRepositoryDonation.save(donation);
    }
}
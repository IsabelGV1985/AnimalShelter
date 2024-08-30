package com.example.AnimalShelter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AnimalShelter.repositories.IShelterRepositoryDonation;

@Service
public class ShelterServiceDonation {

    @Autowired
    IShelterRepositoryDonation iShelterRepositoryDonation;

    public void deleteDonationById(Long id){
    if (iShelterRepositoryDonation.existsById(id)) {
        iShelterRepositoryDonation.deleteById(id);
        } else {
        throw new IllegalArgumentException("Donation entry does not exist");
        }
    }
}
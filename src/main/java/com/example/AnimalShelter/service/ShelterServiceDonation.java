package com.example.AnimalShelter.service;


import com.example.AnimalShelter.model.Donation;
import com.example.AnimalShelter.repositories.IShelterRepositoryDonation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShelterServiceDonation {

    @Autowired
    IShelterRepositoryDonation iShelterRepositoryDonation;

    public List<Donation> deleteDonationById(Long id) {
        if (iShelterRepositoryDonation.existsById(id)) {
            iShelterRepositoryDonation.deleteById(id);
        } else {
            throw new IllegalArgumentException("Donation entry does not exist");
        }


        public List<Donation> getAllDonation() {
            return (List<Donation>) iShelterRepositoryDonation.findAll();
        }

        public Donation getById (Long id){
            Donation donation;
            donation = iShelterRepositoryDonation.findById(id).orElseThrow();
            return donation;

        }
    }
}
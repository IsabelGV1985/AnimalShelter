package com.example.AnimalShelter.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AnimalShelter.model.Donation;
import com.example.AnimalShelter.repositories.IShelterRepositoryDonation;

@Service
public class ShelterServiceDonation {

    @Autowired
    private IShelterRepositoryDonation iShelterRepositoryDonation;

    public Donation createDonation (Donation donation) {
        return iShelterRepositoryDonation.save(donation);
    }

    public void deleteDonationById(Long id){
    if (iShelterRepositoryDonation.existsById(id)) {
        iShelterRepositoryDonation.deleteById(id);
        } else {
            throw new IllegalArgumentException("Donation entry does not exist");
        }
    }

     public List<Donation> getAllDonations() {
        Iterable<Donation> donations = iShelterRepositoryDonation.findAll();
        return StreamSupport.stream(donations.spliterator(), false)
                .collect(Collectors.toList());
    }

    public Donation getDonationById(Long id) {
        return iShelterRepositoryDonation.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Donation not found with id: " + id));
    }
}
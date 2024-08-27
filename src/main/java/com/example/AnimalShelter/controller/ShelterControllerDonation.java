package com.example.AnimalShelter.controller;


import com.example.AnimalShelter.model.Adoption;
import com.example.AnimalShelter.model.Donation;
import com.example.AnimalShelter.service.ShelterServiceDonation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/donation")
public class ShelterControllerDonation {

    @Autowired
    ShelterServiceDonation shelterServiceDonation;

    @DeleteMapping("/donations/{id}")
    public void deleteDonation(@PathVariable Long id) {
        shelterServiceDonation.deleteDonationById(id);
    }


    @GetMapping(path = "/donations")
    public List<Donation> getAllDonation() {
        return shelterServiceDonation.getAllDonation();
    }

    @GetMapping(path = "/donations")
    public ResponseEntity<List<Donation>> getAllDonations() {
        List<Donation> donations = shelterServiceDonation.getAllDonation();
        if (donations.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(donations);
        }
    }
}
package com.example.AnimalShelter.controller;

import com.example.AnimalShelter.model.Donation;
import com.example.AnimalShelter.service.ShelterServiceDonation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/donation")
public class ShelterControllerDonation {

    @Autowired
    private ShelterServiceDonation shelterServiceDonation;

    @DeleteMapping("/donations/{id}")
    public ResponseEntity<Void> deleteDonation(@PathVariable Long id) {
        shelterServiceDonation.deleteDonationById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/donations")
    public ResponseEntity<List<Donation>> getAllDonations() {
        List<Donation> donations = shelterServiceDonation.getAllDonations();
        return ResponseEntity.ok(donations);
    }

    @GetMapping("/donations/{id}")
    public ResponseEntity<Donation> getDonationById(@PathVariable Long id) {
        Donation donation = shelterServiceDonation.getDonationById(id);
        if (donation != null) {
            return ResponseEntity.ok(donation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
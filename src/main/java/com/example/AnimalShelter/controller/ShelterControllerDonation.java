package com.example.AnimalShelter.controller;

import com.example.AnimalShelter.model.Donation;
import com.example.AnimalShelter.service.ShelterServiceDonation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/donations")
public class ShelterControllerDonation {

    @Autowired
    ShelterServiceDonation shelterServiceDonation;

    @PostMapping
    public ResponseEntity<Donation> createDonation(@RequestBody Donation donation) {
        Donation createDonation = shelterServiceDonation.createDonation(donation);
        return ResponseEntity.ok(createDonation);
    }

}
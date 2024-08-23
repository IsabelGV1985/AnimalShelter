package com.example.AnimalShelter.controller;

import com.example.AnimalShelter.service.ShelterServiceDonation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ShelterControllerDonation {

@Autowired
    ShelterServiceDonation shelterServiceDonation;

    @DeleteMapping("/donations/{id}")
    public void deleteDonation(@PathVariable Long id) {
        shelterServiceDonation.deleteDonationById(id);
    }
}
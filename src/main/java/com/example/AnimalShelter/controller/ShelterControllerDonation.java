package com.example.AnimalShelter.controller;

import com.example.AnimalShelter.service.ShelterServiceDonation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")

public class ShelterControllerDonation{

        @Autowired
        ShelterServiceDonation shelterServiceDonation;


}

package com.example.AnimalShelter.controller;

import com.example.AnimalShelter.model.Adoption;
import com.example.AnimalShelter.service.ShelterServiceAdoption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/adoption")
public class ShelterControllerAdoption {

    @Autowired
    private ShelterServiceAdoption shelterServiceAdoption;


    @PostMapping
    public ResponseEntity<Adoption> createAdoption(@RequestBody Adoption adoption) {
        Adoption createAdoption = shelterServiceAdoption.createAdoption(adoption);
        return ResponseEntity.ok(createAdoption);
    }

}
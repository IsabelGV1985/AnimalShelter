package com.example.AnimalShelter.controller;


import com.example.AnimalShelter.model.Adoption;
import com.example.AnimalShelter.service.ShelterServiceAdoption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adoptions")
public class ShelterControllerAdoption {

    @Autowired
    ShelterServiceAdoption shelterServiceAdoption;

    @DeleteMapping("/adoptions/{id}")
    public void deleteAdoption(@PathVariable Long id) {
        shelterServiceAdoption.deleteAdoptionById(id);

    }
    @GetMapping(path = "/adoptions")
    public List<Adoption> getAllAdoption() {
        return shelterServiceAdoption.getAllAdoption();
    }

    @GetMapping(path = "/adoptions/{id}")
    public Adoption getAdoptionById(@PathVariable("id") Long id) {
        return shelterServiceAdoption.getById(id);
    }

}
package com.example.AnimalShelter.controller;

import com.example.AnimalShelter.service.ShelterServiceAdoption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ShelterControllerAdoption {

    @Autowired
    ShelterServiceAdoption shelterServiceAdoption;

    @DeleteMapping("/adoptions/{id}")
    public void deleteAdoption(@PathVariable Long id){
        shelterServiceAdoption.deleteAdoptionById(id);
    }
}

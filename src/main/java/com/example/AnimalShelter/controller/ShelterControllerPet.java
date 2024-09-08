package com.example.AnimalShelter.controller;

import java.util.List;

import com.example.AnimalShelter.model.Pet;
import com.example.AnimalShelter.service.ShelterServicePet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")  // Cambié el path base a "/api" para mejor organización
public class ShelterControllerPet {

    @Autowired
    ShelterServicePet shelterServicePet;

    // Método para eliminar una mascota por ID
    @DeleteMapping("/pets/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable Long id) {
        try {
            shelterServicePet.deletePetById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Método para obtener todas las mascotas
    @GetMapping("/pets")
    public ResponseEntity<List<Pet>> getAllPets() {
        List<Pet> pets = shelterServicePet.getAllPet();
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }

    // Método para obtener una mascota por ID
    @GetMapping("/pets/{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable("id") Long id) {
        try {
            Pet pet = shelterServicePet.getById(id);
            return new ResponseEntity<>(pet, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

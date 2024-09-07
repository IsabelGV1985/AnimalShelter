package com.example.AnimalShelter.controller;

import com.example.AnimalShelter.model.Adoption;
import com.example.AnimalShelter.model.Pet;
import com.example.AnimalShelter.model.User;
import com.example.AnimalShelter.repositories.IShelterRepositoryPet;
import com.example.AnimalShelter.repositories.IShelterRepositoryUser;
import com.example.AnimalShelter.service.ShelterServiceAdoption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.AnimalShelter.model.AdoptionRequestDto;

@RestController
@RequestMapping("/api")
public class ShelterControllerAdoption {

    @Autowired
    ShelterServiceAdoption shelterServiceAdoption;

    @Autowired
    private IShelterRepositoryUser userRepository;

    @Autowired
    private IShelterRepositoryPet petRepository;

    @PostMapping("/adoptions")
    public ResponseEntity<String> createAdoption(@RequestBody AdoptionRequestDto adoptionRequest) {
        try {
            User user = userRepository.findUserByUsername(adoptionRequest.getUsername())
                                      .orElseThrow(() -> new ResourceNotFoundException("User not found"));

            Pet pet = petRepository.findById(adoptionRequest.getPetId())
                                   .orElseThrow(() -> new ResourceNotFoundException("Pet not found"));

            Adoption adoption = new Adoption();
            adoption.setUser(user);
            adoption.setPet(pet);

            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            String formattedDate = formatter.format(new Date());
            adoption.setAdoption_date(formattedDate);

            Adoption createdAdoption = shelterServiceAdoption.createAdoption(adoption);

            return new ResponseEntity<>("Adopción creada exitosamente con ID: " + createdAdoption.getId(), HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear la adopción: " + e.getMessage());
        }
    }

    @DeleteMapping("/adoptions/{id}")
    public void deleteAdoption(@PathVariable Long id) {
        shelterServiceAdoption.deleteAdoptionById(id);
    }

    // Excepción personalizada
    public static class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String message) {
            super(message);
        }
    }
}

package com.example.AnimalShelter.service;

import com.example.AnimalShelter.model.Pet;
import com.example.AnimalShelter.repositories.IShelterRepositoryPet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ShelterServicePet {

    @Autowired
    IShelterRepositoryPet iShelterRepositoryPet;

    // Método para eliminar una mascota por ID
    public void deletePetById(Long id) {
        if (iShelterRepositoryPet.existsById(id)) {
            iShelterRepositoryPet.deleteById(id);
        } else {
            throw new IllegalArgumentException("La mascota con ID " + id + " no existe.");
        }
    }

    // Método para obtener todas las mascotas
    public List<Pet> getAllPet() {
        return (List<Pet>) iShelterRepositoryPet.findAll();
    }

    // Método para obtener una mascota por ID
    public Pet getById(Long id) {
        return iShelterRepositoryPet.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("La mascota con ID " + id + " no existe."));
    }
}

package com.example.AnimalShelter.repositories;

import java.util.Optional;

import com.example.AnimalShelter.model.Pet;

import org.springframework.data.repository.CrudRepository;



public interface IShelterRepositoryPet extends CrudRepository <Pet, Long> {
    Optional<Pet> findbyId (Long id);

}

package com.example.AnimalShelter.repositories;

import com.example.AnimalShelter.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface IShelterRepositoryPet extends CrudRepository <Pet, Long> {
}

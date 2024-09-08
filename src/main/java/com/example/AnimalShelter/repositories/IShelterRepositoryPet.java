package com.example.AnimalShelter.repositories;


import org.springframework.data.repository.CrudRepository;

import com.example.AnimalShelter.model.Pet;



public interface IShelterRepositoryPet extends CrudRepository <Pet, Long> {
  

}

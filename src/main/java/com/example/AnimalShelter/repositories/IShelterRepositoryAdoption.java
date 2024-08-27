package com.example.AnimalShelter.repositories;

import com.example.AnimalShelter.model.Adoption;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IShelterRepositoryAdoption extends CrudRepository<Adoption, Long> {
}





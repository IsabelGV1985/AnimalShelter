package com.example.AnimalShelter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.AnimalShelter.model.Adoption;

public interface IShelterRepositoryAdoption extends JpaRepository<Adoption, Long> {
}

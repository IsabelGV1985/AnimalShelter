package com.example.AnimalShelter.repositories;

import com.example.AnimalShelter.model.User;
import org.springframework.data.repository.CrudRepository;

public interface IShelterRepositoryUser extends CrudRepository <User, Long> {
}

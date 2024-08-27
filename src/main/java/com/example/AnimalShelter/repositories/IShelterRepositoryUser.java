package com.example.AnimalShelter.repositories;

import com.example.AnimalShelter.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IShelterRepositoryUser extends CrudRepository<User, Long> {
}

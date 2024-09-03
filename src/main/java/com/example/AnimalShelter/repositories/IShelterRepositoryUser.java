package com.example.AnimalShelter.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.AnimalShelter.model.User;

public interface IShelterRepositoryUser extends CrudRepository <User, Long> {
    Optional<User> findUserById(Long id);
    Optional<User> findUserByUsername(String username);
}
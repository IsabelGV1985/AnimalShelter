package com.example.AnimalShelter.service;

import com.example.AnimalShelter.repositories.IShelterRepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShelterServiceUser {

    @Autowired
    IShelterRepositoryUser iShelterRepositoryUser;

public void deleteUserById(Long id){
    if (iShelterRepositoryUser.existsById(id)){
        iShelterRepositoryUser.deleteById(id);
        } else {
        throw new IllegalArgumentException("User does not exist");
        }
    }
}

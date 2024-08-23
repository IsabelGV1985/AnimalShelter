package com.example.AnimalShelter.controller;

import com.example.AnimalShelter.service.ShelterServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ShelterControllerUser {

    @Autowired
    ShelterServiceUser shelterServiceUser;

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        shelterServiceUser.deleteUserById(id);
    }
}

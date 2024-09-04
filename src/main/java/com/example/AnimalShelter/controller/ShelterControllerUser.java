package com.example.AnimalShelter.controller;


import com.example.AnimalShelter.model.User;
import com.example.AnimalShelter.service.ShelterServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class ShelterControllerUser {

    @Autowired
    ShelterServiceUser shelterServiceUser;

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        shelterServiceUser.deleteUserById(id);
    }


}

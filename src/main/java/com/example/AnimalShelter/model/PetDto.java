package com.example.AnimalShelter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class PetDto {
    private String pet_name;
    private String pet_breed;
    private boolean adoptable;
    private User user;
}





package com.example.AnimalShelter.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "pet")

public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_id")
    private Long id;

    @Column(name = "pet_name")
    private String pet_name;

    @Column(name = "pet_type")
    private String pet_type;

    @Column(name = "pet_breed")
    private String pet_breed;

    @Column(name = "pet_gender")
    private String pet_gender;

    @Column(name = "adoptable")
    private boolean adoptable;

    @Column(name = "pet_description")
    private String pet_description;
}

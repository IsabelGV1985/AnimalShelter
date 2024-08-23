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

    @Column
    private String pet_name;

    @Column
    private String pet_type;

    @Column
    private String pet_breed;

    @Column
    private String pet_gender;

    @Column
    private boolean adoptable;

    @Column
    private String pet_description;
}

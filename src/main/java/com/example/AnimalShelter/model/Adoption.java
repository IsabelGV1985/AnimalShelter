package com.example.AnimalShelter.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "adoption")

public class Adoption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adoption_id")
    private Long id;

    @Column(name = "user_id")
    private String user_id;

    @Column(name = "pet_id")
    private String pet_id;

    @Column(name = "adoption_date")
    private String adoption_date;


}

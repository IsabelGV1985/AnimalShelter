package com.example.AnimalShelter.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

   @Column(name = "user_name")
   private String user_name;

   @Column(name = "phone_number")
   private Long phone_number;

   @Column(name = "email")
   private String email;

   @Column(name = "rol")
   private String rol;

}

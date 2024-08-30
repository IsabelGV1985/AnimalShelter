package com.example.AnimalShelter.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ShelterModelPetTest {

        public Pet pet;

        @BeforeEach
                void setUp() {
            pet = new Pet();

        }

        @Test
            void Test_getters_and_Setters() {

            Long id = 1L;
            String name = "gandalf";
            String pet_type = "Dog";
            String breed = "Long Hair";
            String gender = "Male";
            boolean adoptable = true;
            String pet_description = "The best boy.";

            pet.setId(id);
            pet.setPet_name(name);
            pet.setPet_type(pet_type);
            pet.setPet_breed(breed);
            pet.setPet_gender(gender);
            pet.setAdoptable(adoptable);
            pet.setPet_description(pet_description);

            assertEquals(id, pet.getId());
            assertEquals(name, pet.getPet_name());
            assertEquals(pet_type, pet.getPet_type());
            assertEquals(breed, pet.getPet_breed());
            assertEquals(gender, pet.getPet_gender());
            assertEquals(adoptable, pet.isAdoptable());
            assertEquals(pet_description, pet.getPet_description());

                }
            }
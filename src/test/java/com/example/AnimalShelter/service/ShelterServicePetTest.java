package com.example.AnimalShelter.service;

import com.example.AnimalShelter.model.Pet;
import com.example.AnimalShelter.repositories.IShelterRepositoryPet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class ShelterServicePetTest {

    @Mock
    private IShelterRepositoryPet shelterRepositoryPet;

    @InjectMocks
    private ShelterServicePet shelterServicePet;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreatePets() {
        Pet pet = new Pet();
        pet.setPet_name("Bolita");
        pet.setPet_type("Rabbit");
        pet.setPet_breed("German Belier");
        pet.setPet_gender("Male");
        pet.setAdoptable(true);
        pet.getPet_description();

        when(shelterRepositoryPet.save(pet)).thenAnswer(invocation -> {
            Pet savePet = invocation.getArgument(0);
            savePet.setId(1L);
            return savePet;
        });

        Pet createPet = shelterServicePet.createPet(pet);
        assertNotNull(createPet);
        assertEquals(1L, createPet.getId());
        assertEquals("Bolita", createPet.getPet_name());
        assertEquals("Rabbit", createPet.getPet_type());
        assertEquals("German Belier", createPet.getPet_breed());
        assertEquals("Male", createPet.getPet_gender());
        assertEquals("yes", createPet.isAdoptable());
        assertEquals("description of the animal", createPet.getPet_description());

    }
}



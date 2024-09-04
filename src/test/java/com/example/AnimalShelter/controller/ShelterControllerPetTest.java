package com.example.AnimalShelter.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import com.example.AnimalShelter.model.Pet;
import com.example.AnimalShelter.repositories.IShelterRepositoryPet;
import com.example.AnimalShelter.service.ShelterServicePet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Nested
@WebMvcTest(ShelterControllerPet.class)
class ShelterControllerPetTest {

    @InjectMocks
    private ShelterServicePet shelterServicePet;

    @Mock
    private IShelterRepositoryPet iShelterRepositoryPet;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void testGetAllPet() {
        ArrayList<Pet> PetList = new ArrayList<>();
        Pet pet = new Pet();
        PetList.add(pet);

        when(iShelterRepositoryPet.findAll()).thenReturn(PetList);

        List<Pet> result = shelterServicePet.getAllPet();

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(iShelterRepositoryPet, times(1)).findAll();
    }

    @Test
    void testGetPetById() {
        Pet pet = new Pet();
        when(iShelterRepositoryPet.findById(1L)).thenReturn(Optional.of(pet));

        Pet result = shelterServicePet.getById(1L);

        assertNotNull(result);
        verify(iShelterRepositoryPet, times(1)).findById(1L);
    }
}

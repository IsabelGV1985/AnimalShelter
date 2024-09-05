package com.example.AnimalShelter.model;

import com.example.AnimalShelter.repositories.IShelterRepositoryPet;
import com.example.AnimalShelter.service.ShelterServicePet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class ShelterModelPetTest {


    @Mock
    private IShelterRepositoryPet iShelterRepositoryPet;

    @InjectMocks
    private ShelterServicePet shelterServicePet;

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
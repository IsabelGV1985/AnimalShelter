package com.example.AnimalShelter.service;


import com.example.AnimalShelter.model.Pet;
import com.example.AnimalShelter.repositories.IShelterRepositoryPet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.test.web.client.ExpectedCount;

import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.ExpectedCount.times;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class ShelterServicePetTest {

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

    private JpaSpecificationExecutor<Object> verify(IShelterRepositoryPet iShelterRepositoryPet, ExpectedCount times) {
        return null;
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

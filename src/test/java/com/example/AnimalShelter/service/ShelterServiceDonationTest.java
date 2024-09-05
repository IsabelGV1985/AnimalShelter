package com.example.AnimalShelter.service;


import com.example.AnimalShelter.model.Donation;
import com.example.AnimalShelter.repositories.IShelterRepositoryDonation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ShelterServiceDonationTest {

    @Mock
    private IShelterRepositoryDonation iShelterRepositoryDonation;

    @InjectMocks
    private ShelterServiceDonation shelterServiceDonation;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }


        @Test
    void testGetAllDonation() {
        ArrayList<Donation> DonationList = new ArrayList<>();
        Donation donation = new Donation();
        DonationList.add(donation);

        when(iShelterRepositoryDonation.findAll()).thenReturn(DonationList);

        List<Donation> result = shelterServiceDonation.getAllDonations();

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(iShelterRepositoryDonation, times(1)).findAll();
    }

    @Test
    void testGetDonationById() {
        Donation donation = new Donation();
        when(iShelterRepositoryDonation.findById(1L)).thenReturn(Optional.of(donation));

        Donation result = shelterServiceDonation.getDonationById(1L);

        assertNotNull(result);
        verify(iShelterRepositoryDonation, times(1)).findById(1L);
    }
}
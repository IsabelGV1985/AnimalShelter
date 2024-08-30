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
    private IShelterRepositoryDonation shelterRepositoryDonation;

    @InjectMocks
    private ShelterServiceDonation shelterServiceDonation;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateDonation() {
        Donation donation = new Donation();
        donation.setUser_name("Isabel");
        donation.setDonor_email("IsabelGV@gmail.com");
        donation.setDonation_amount(10);

        when(shelterRepositoryDonation.save(donation)).thenAnswer(invocation -> {
            Donation saveDonation = invocation.getArgument(0);
            saveDonation.setId(1L);
            return saveDonation;
        });

        Donation createDonation = ShelterServiceDonation.createDonation(donation);
        assertNotNull(createDonation);
        assertEquals(1L, createDonation.getId());
        assertEquals("Isabel", createDonation.getUser_name());
        assertEquals("IsabelGV@gmail.com", createDonation.getDonor_email());
        assertEquals(10, createDonation.getDonation_amount());

    }

}

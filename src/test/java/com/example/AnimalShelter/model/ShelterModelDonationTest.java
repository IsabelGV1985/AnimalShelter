package com.example.AnimalShelter.model;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


public class ShelterModelDonationTest {

    public Donation donation;

    @BeforeEach
    void setUp() {
        donation = new Donation();

    }


    @Test
    void testGetAllDonation()  {
    when(shelterServiceDonation.getAllDonation()).thenReturn(new ArrayList<>());

    mockMvc.perform(get("/donation").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());

    verify(shelterServiceDonation, times(1)).getAllDonation();
    }

    @Test
    void testGetDonationById() throws Exception {
    Donation donation = new Donation();
    donation.setId(1L);


    when(shelterServiceDonation.getById(1L)).thenReturn(donation);

    mockMvc.perform(get("/donation/1").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(1));

    verify(shelterServiceDonation, times(1)).getById(1L);
    }
}
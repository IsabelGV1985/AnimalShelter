package com.example.AnimalShelter.controller;

import com.example.AnimalShelter.model.Donation;
import com.example.AnimalShelter.service.ShelterServiceDonation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.http.MediaType;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ShelterControllerDonation.class)
public class ShelterControllerDonationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ShelterServiceDonation shelterServiceDonation;

    @InjectMocks
    private ShelterControllerDonation shelterControllerDonation;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(shelterControllerDonation).build();
    }

    @Test
    public void testCreateDonation() throws Exception {
        Donation donation = new Donation(1L, "Isabel", "IsabelGV@gmail.com", 10, "30/07/2024");

        when(shelterServiceDonation.createDonation(any(Donation.class))).thenReturn(donation);

        String donationJson = objectMapper.writeValueAsString(donation);

        mockMvc.perform(post("/donation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(donationJson)
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.user_name").value("Isabel"))
                .andExpect(jsonPath("$.donor_email").value("IsabelGV@gmail.com"))
                .andExpect(jsonPath("$.amount").value(10));

        }

    }
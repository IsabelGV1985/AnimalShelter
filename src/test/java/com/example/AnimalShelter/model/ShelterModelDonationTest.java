package com.example.AnimalShelter.model;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.AnimalShelter.model.Donation;
import com.example.AnimalShelter.service.ShelterServiceDonation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.ArrayList;


@WebMvcTest(ShelterControllerDonation.class)
public class ShelterModelDonationTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ShelterServiceDonation shelterServiceDonation;


    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(shelterControllerDonation).build();
    }

    @InjectMocks
    private ShelterControllerDonation shelterControllerDonation;

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
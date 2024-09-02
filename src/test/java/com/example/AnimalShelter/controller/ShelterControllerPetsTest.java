package com.example.AnimalShelter.controller;

import com.example.AnimalShelter.model.Pet;
import com.example.AnimalShelter.service.ShelterServicePet;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ShelterControllerPetsTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ShelterServicePet shelterServicePet;

    @InjectMocks
    private ShelterControllerPet shelterControllerPet;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(shelterControllerPet).build();    }

    @Test
    public void testCreatePet() throws Exception {
        Pet pet = new Pet();

        when(shelterServicePet.createPet(any(Pet.class))).thenReturn(pet);

        String petJson = objectMapper.writeValueAsString(pet);

        mockMvc.perform(post("/pet")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(petJson)
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pet_id").value(1L))
                .andExpect(jsonPath("$.pet_name").value("Bolita"))
                .andExpect(jsonPath("$.pet_type").value("Bunny"))
                .andExpect(jsonPath("$.pet_breed").value("German Belier"))
                .andExpect(jsonPath("$.pet_gender").value("male"))
                .andExpect(jsonPath("$.adoptable").value("yes"))
                .andExpect(jsonPath("$.pet_description").value("soft, beautiful rabbit"));

    }



}

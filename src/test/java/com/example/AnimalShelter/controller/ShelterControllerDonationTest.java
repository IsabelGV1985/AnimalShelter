package com.example.AnimalShelter.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.AnimalShelter.config.JwtService;
import com.example.AnimalShelter.model.Donation;
import com.example.AnimalShelter.model.User;
import com.example.AnimalShelter.repositories.IShelterRepositoryUser;
import com.example.AnimalShelter.service.ShelterServiceDonation;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebMvcTest(ShelterControllerDonation.class)
public class ShelterControllerDonationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ShelterServiceDonation shelterServiceDonation;

    @MockBean
    private IShelterRepositoryUser userRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private JwtService jwtService;

    private Donation donationisabel;
    private ArrayList<Donation> donationisabelList = new ArrayList<>();

    @BeforeEach
    void setup() {
        donationisabel = new Donation();
        donationisabel.setId(10L);
        donationisabel.setUsername("Isabel");
        donationisabel.setDonor_email("IsabelGV@gmail.com");
        donationisabel.setDonation_amount(10);   
        
        User userIsabel = new User();
        userIsabel.setId(1L);  
        userIsabel.setUsername("Isabel"); 

        donationisabel.setUser(userIsabel);
        donationisabelList.add(donationisabel);
    }

    @Test
    @WithMockUser(roles = "USER")
    public void testCreateDonation() throws Exception {
        // Simulación del usuario en el repositorio
        when(userRepository.findUserByUsername("Isabel"))
            .thenReturn(Optional.of(new User()));
    
        // Simulación del comportamiento del servicio
        when(shelterServiceDonation.createDonation(any(Donation.class)))
            .thenAnswer(invocation -> {
                Donation donation = invocation.getArgument(0);
                donation.setId(10L); // Configura el ID que esperas
                return donation;
            });
    
        // JSON que representa la donación que se enviará en la solicitud
        String donationJson = "{\n" +
            "  \"username\": \"Isabel\",\n" +
            "  \"donorEmail\": \"IsabelGV@gmail.com\",\n" +
            "  \"donationAmount\": 10,\n" +
            "  \"donationDate\": \"2024-09-07\",\n" +
            "  \"userId\": 1\n" +
            "}";
    
        // Realiza la solicitud POST a /api/donations y verifica la respuesta
        mockMvc.perform(post("/api/donations")
                .contentType(MediaType.APPLICATION_JSON)
                .content(donationJson)
                .with(SecurityMockMvcRequestPostProcessors.csrf()))
            .andExpect(status().isCreated()); // Asegúrate de que el controlador devuelve 201 Created
    }
    

}
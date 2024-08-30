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
    void Test_getter_and_setter_donation() {

        Long id = 1L;
        String user_name = "Isabel";
        String donor_email = "isabelmgutierrez@hotmail.es";
        int amount = 10 ;
        String donation_date = "12-03-2024";


        donation.setId(id);
        donation.setUser_name(user_name);
        donation.setDonor_email(donor_email);
        donation.setDonation_amount(amount);
        donation.setDonation_date(donation_date);


        assertEquals(id, donation.getId());
        assertEquals(user_name, donation.getUser_name());
        assertEquals(donor_email, donation.getDonor_email());
        assertEquals(donation_date, donation.getDonation_date());

    }
}

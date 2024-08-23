package com.example.AnimalShelter.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

    @Entity
    @Getter
    @Setter
    @NoArgsConstructor
    @Table(name = "donation")

    public class ShelterModelDonation {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long Id;

        @Column(name = "donor_name")
        private String donor_name;

        @Column(name = "amount")
        private int amount;

        @Column(name = "donation_date")
        private String donation_date;

}

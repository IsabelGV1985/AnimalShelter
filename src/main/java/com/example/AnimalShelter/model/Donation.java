package com.example.AnimalShelter.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

    @Entity
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Table(name = "donation")

    public class Donation {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "user_name")
        private String user_name;

        @Column(name = "donor_email")
        private String donor_email;

        @Column(name = "amount")
        private int donation_amount;

        @Column(name = "donation_date")
        private String donation_date;

}

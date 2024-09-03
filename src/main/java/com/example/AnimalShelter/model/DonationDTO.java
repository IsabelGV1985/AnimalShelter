package com.example.AnimalShelter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DonationDTO {
    private String username;
    private String donorEmail;
    private int donationAmount;
    private String donationDate;
    private Long userId;
}

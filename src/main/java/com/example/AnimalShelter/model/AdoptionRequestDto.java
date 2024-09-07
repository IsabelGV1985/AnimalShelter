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
public class AdoptionRequestDto {
    private String username;
    private Long petId;
    private Long userId;
    
 
}

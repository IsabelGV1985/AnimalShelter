package com.example.AnimalShelter.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AnimalShelter.model.Donation;
import com.example.AnimalShelter.model.DonationDTO;
import com.example.AnimalShelter.model.User;
import com.example.AnimalShelter.repositories.IShelterRepositoryUser;
import com.example.AnimalShelter.service.ShelterServiceDonation;

@RestController
@RequestMapping("/api")
public class ShelterControllerDonation {

    @Autowired
    private IShelterRepositoryUser userRepository;

    @Autowired
    private ShelterServiceDonation shelterServiceDonation;

    @PostMapping("/donations")
    public ResponseEntity<String> createDonation(@RequestBody DonationDTO donationDTO) {
        try {
            // Buscar el usuario por username
            User user = userRepository.findUserByUsername(donationDTO.getUsername())
                                      .orElseThrow(() -> new ResourceNotFoundException("User not found"));

            // Crear la donación
            Donation donation = new Donation();
            donation.setUsername(donationDTO.getUsername());
            donation.setDonor_email(donationDTO.getDonorEmail());
            donation.setDonation_amount(donationDTO.getDonationAmount());

            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            String formattedDate = formatter.format(new Date());
            donation.setDonation_date(formattedDate);

            donation.setUser(user);

            // Guardar la donación
            Donation createdDonation = shelterServiceDonation.createDonation(donation);

            // Retornar la donación creada
            return new ResponseEntity<>("Donación creada exitosamente con ID: " + createdDonation.getId(), HttpStatus.CREATED);
        } catch (Exception e) {
            // Retornar mensaje de error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear donación: " + e.getMessage());
        }
    }

    @DeleteMapping("/donations/{id}")
    public ResponseEntity<String> deleteDonation(@PathVariable Long id) {
        try {
            shelterServiceDonation.deleteDonationById(id);
            return ResponseEntity.ok("Donación eliminada exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar donación: " + e.getMessage());
        }
    }

    @GetMapping("/donations")
    public ResponseEntity<List<Donation>> getAllDonations() {
        List<Donation> donations = shelterServiceDonation.getAllDonations();
        return ResponseEntity.ok(donations);
    }

    @GetMapping("/donations/{id}")
    public ResponseEntity<?> getDonationById(@PathVariable Long id) {
        Donation donation = shelterServiceDonation.getDonationById(id);
        if (donation != null) {
            // Convertir Donation a DonationDTO
            DonationDTO donationDTO = convertToDTO(donation);
            return ResponseEntity.ok(donationDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Donación no encontrada con ID: " + id);
        }
    }

    private DonationDTO convertToDTO(Donation donation) {
        return DonationDTO.builder()
            .username(donation.getUsername())
            .donationAmount(donation.getDonation_amount())
            .userId(donation.getId())
            .build();
    }

    // Excepción personalizada
    public static class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String message) {
            super(message);
        }
    }
}

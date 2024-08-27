package com.example.AnimalShelter.repositories;


import com.example.AnimalShelter.model.Donation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IShelterRepositoryDonation extends CrudRepository<Donation, Long> {
}

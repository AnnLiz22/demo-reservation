package com.lietz.demo.service;

import com.lietz.demo.model.Accommodation;
import com.lietz.demo.repository.AccommodationRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AccommodationService {

  private final AccommodationRepository accommodationRepository;

  public AccommodationService(AccommodationRepository accommodationRepository) {
    this.accommodationRepository = accommodationRepository;
  }

  public List<Accommodation> findAllAccommodations(){
    return accommodationRepository.findAll();
  }

  public Accommodation findAccommodationById(Long id){
    return accommodationRepository.findById(id)
        .orElseThrow(()->new RuntimeException("Accommodation not found"));
  }
}

package com.lietz.demo.controller;

import com.lietz.demo.model.Accommodation;
import com.lietz.demo.service.AccommodationService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accommodations")
@RequiredArgsConstructor
public class AccommodationController {
  private final AccommodationService accommodationService;

  @GetMapping
  public ResponseEntity<List<Accommodation>> getAllAccommodations(){
    List <Accommodation> accommodations = accommodationService.findAllAccommodations();
    return ResponseEntity.ok(accommodations);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Accommodation> getAccommodation(@PathVariable Long id){
    try {
      Accommodation accommodation = accommodationService.findAccommodationById(id);
      return ResponseEntity.ok(accommodation);
    } catch (RuntimeException e){
      return ResponseEntity.notFound().build();
    }
  }
}

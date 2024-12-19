package com.lietz.demo.service;

import com.lietz.demo.model.Accommodation;
import com.lietz.demo.repository.AccommodationRepository;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class AccommodationServiceTest {
  @Mock
  private AccommodationRepository accommodationRepository;
  @InjectMocks
  private AccommodationService accommodationService;

  List<Accommodation> accommodations = List.of(
      new Accommodation(1L, 2L, "Super condo", "very nice place", 450.50, "close to city center"),
      new Accommodation(2L, 2L, "Super condo2", "nice and cheap", 350.50, "close to city center"),
      new Accommodation(3L, 2L, "Super condo3", "2 bedrooms", 950.50, "close to city center")
      );

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void shouldFindAllAccommodations() {
    Mockito.when(accommodationRepository.findAll()).thenReturn(accommodations);

    List<Accommodation> result = accommodationService.findAllAccommodations();

    Assertions.assertEquals("Super condo", result.get(0).getName());
    Mockito.verify(accommodationRepository, Mockito.times(1)).findAll();
  }

  @Test
  void shouldFindAccommodationByIdAndReturnDescription() {
    Accommodation accommodation1 = accommodations.get(0);
    Mockito.when(accommodationRepository.findById(1L)).thenReturn(Optional.ofNullable(accommodation1));
    accommodationService.findAccommodationById(1L);
    Assertions.assertEquals("very nice place", accommodation1.getDescription());
  }

  @Test
  void shouldFindAccommodationByIdAndReturnPricePerDay() {
    Accommodation accommodation3 = accommodations.get(2);
    Mockito.when(accommodationRepository.findById(3L)).thenReturn(Optional.ofNullable(accommodation3));
    accommodationService.findAccommodationById(3L);
    Assertions.assertEquals(950.50, accommodation3.getPricePerDay());
  }
}
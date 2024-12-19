package com.lietz.demo.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.lietz.demo.model.Reservation;
import com.lietz.demo.repository.ReservationRepository;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class ReservationServiceTest {

  @Mock
  ReservationRepository reservationRepository;

  @InjectMocks
  ReservationService reservationService;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void shouldGetAllReservations() {
    List <Reservation> reservations = List.of(
        new Reservation()
    );

    when(reservationRepository.findAll()).thenReturn(reservations);
    reservationService.getAllReservations();
    verify(reservationRepository, times(1)).findAll();
  }

  @Test
  void createReservation() {
  }

  @Test
  void getReservationById() {
  }

  @Test
  void deleteReservation() {
  }
}
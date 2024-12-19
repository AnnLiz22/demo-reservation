package com.lietz.demo.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.lietz.demo.model.Reservation;
import com.lietz.demo.repository.ReservationRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class ReservationServiceTest {

  @Mock
  ReservationRepository reservationRepository;

  @InjectMocks
  ReservationService reservationService;

  List <Reservation> reservations = List.of(
      new Reservation(1L, 1L, 2L, LocalDate.of(2024,12,12), LocalDate.of(2024,12,14), "confirmed"),
      new Reservation(2L, 2L, 4L, LocalDate.of(2024,11,12), LocalDate.of(2024,11,14), "confirmed"),
      new Reservation(3L, 3L, 4L, LocalDate.of(2024,10,12), LocalDate.of(2024,10,14), "confirmed")
  );

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void shouldGetAllReservations() {

    when(reservationRepository.findAll()).thenReturn(reservations);
    reservationService.getAllReservations();
    verify(reservationRepository, times(1)).findAll();
  }

  @Test
  void shouldCreateReservation() {
    Reservation reservation = new Reservation();
    when(reservationRepository.save(reservation)).thenReturn(reservation);

    reservationService.createReservation(reservation);
    Mockito.verify(reservationRepository, times(1)).save(reservation);
  }

  @Test
  void shouldGetReservationById() {
    Reservation reservation1 = reservations.get(0);
    when(reservationRepository.findById(1L)).thenReturn(Optional.ofNullable(reservation1));
    reservationService.getReservationById(1L);
    Assertions.assertEquals("confirmed", reservation1.getStatus());

    Mockito.verify(reservationRepository, times(1)).findById(1L);
  }

  @Test
  void shouldInvokeDeleteReservation() {
    Reservation reservation1 = reservations.get(0);
    reservationService.deleteReservation(reservation1.getId());

    Mockito.verify(reservationRepository, times(1)).existsById(1L);
  }
}
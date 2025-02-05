package com.lietz.demo.controller;

import com.lietz.demo.model.Reservation;
import com.lietz.demo.service.ReservationService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationController {
  private final ReservationService reservationService;

  @GetMapping
  public ResponseEntity<List<Reservation>> getAllReservations() {
    List<Reservation> reservations = reservationService.getAllReservations();
    return ResponseEntity.ok(reservations);
  }

  @PostMapping
  public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
    Reservation newReservation = reservationService.createReservation(reservation);
    return ResponseEntity.status(HttpStatus.CREATED).body(newReservation);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Reservation> getReservationById(@PathVariable Long id) {
    try {
      Reservation reservation = reservationService.getReservationById(id);
      return ResponseEntity.ok(reservation);
    } catch (RuntimeException e) {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
    try {
      reservationService.deleteReservation(id);
      return ResponseEntity.noContent().build();
    } catch (RuntimeException e) {
      return ResponseEntity.notFound().build();
    }
  }
}

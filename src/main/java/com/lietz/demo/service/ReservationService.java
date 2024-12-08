package com.lietz.demo.service;

import com.lietz.demo.model.Reservation;
import com.lietz.demo.repository.ReservationRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
  private final ReservationRepository reservationRepository;

  public ReservationService(ReservationRepository reservationRepository) {
    this.reservationRepository = reservationRepository;
  }

  public List<Reservation> getAllReservations() {
    return reservationRepository.findAll();
  }

  public Reservation createReservation(Reservation reservation){
    return reservationRepository.save(reservation);
  }

  public Reservation getReservationById(Long id){
    return reservationRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Reservation not found"));

  }

  public void deleteReservation(Long id){
    reservationRepository.deleteById(id);
  }
}
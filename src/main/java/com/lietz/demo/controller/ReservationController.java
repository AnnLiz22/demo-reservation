package com.lietz.demo.controller;

import com.lietz.demo.model.Reservation;
import com.lietz.demo.service.ReservationService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {
  private final ReservationService reservationService;

  @GetMapping
  public String getAllReservations(Model model) {
    List<Reservation> reservations = reservationService.getAllReservations();
    model.addAttribute("reservations", reservations);
    return "reservations/list";
  }

  @PostMapping
  public String createReservation(@ModelAttribute Reservation reservation, Model model) {
    Reservation newReservation = reservationService.createReservation(reservation);
    model.addAttribute("reservation", newReservation);
    return "reservations/list";
  }

  @GetMapping("/{id}")
  public String getReservationById(@PathVariable Long id, Model model) {
    try {
      Reservation reservation = reservationService.getReservationById(id);
      model.addAttribute("reservation", reservation);
      return "reservations/details";
    } catch (RuntimeException e) {
      return "error/404";
    }
  }

  @DeleteMapping("/{id}")
  public String deleteReservation(@PathVariable Long id) {
    try {
      reservationService.deleteReservation(id);
      return "reservations/list";
    } catch (RuntimeException e) {
      return "reservations/error";
    }
  }
}

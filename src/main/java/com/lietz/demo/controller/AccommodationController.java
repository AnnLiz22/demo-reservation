package com.lietz.demo.controller;

import com.lietz.demo.model.Accommodation;
import com.lietz.demo.service.AccommodationService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/accommodations")
@RequiredArgsConstructor
public class AccommodationController {
  private final AccommodationService accommodationService;

  @GetMapping
  public String getAllAccommodations(Model model){
    List <Accommodation> accommodations = accommodationService.findAllAccommodations();
    model.addAttribute("accommodations", accommodations);
    return "accommodations/list";
  }

  @GetMapping("/{id}")
  public String getAccommodation(@PathVariable Long id, Model model){
    try {
      Accommodation accommodation = accommodationService.findAccommodationById(id);
      model.addAttribute("accommodation", accommodation);
      return "accommodations/details";
    } catch (RuntimeException e){
      return "error/404";
    }
  }
}

package com.lietz.demo.controller;

import com.lietz.demo.model.Festival;
import com.lietz.demo.service.FestivalService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/festivals")
@RequiredArgsConstructor
public class FestivalController {
  private final FestivalService festivalService;
  @GetMapping
  public ResponseEntity<List<Festival>> getAllFestivals() {
    List<Festival> festivals = festivalService.findAllFestivals();
    return ResponseEntity.ok(festivals);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Festival> getFestivalById(@PathVariable Long id) {
    try {
      Festival festival = festivalService.getFestivalById(id);
      return ResponseEntity.ok(festival);
    } catch (RuntimeException e) {
      return ResponseEntity.notFound().build();
    }
  }
}

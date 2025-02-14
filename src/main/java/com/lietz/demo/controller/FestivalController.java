package com.lietz.demo.controller;

import com.lietz.demo.model.Festival;
import com.lietz.demo.service.FestivalService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/festivals")
@RequiredArgsConstructor
public class FestivalController {
  private final FestivalService festivalService;
  @GetMapping
  public String getAllFestivals(Model model) {
    List<Festival> festivals = festivalService.findAllFestivals();
    model.addAttribute("festivals", festivals);
    return "festivals/list";
  }

  @GetMapping("/{id}")
  public String getFestivalById(@PathVariable Long id, Model model) {
    try {
      Festival festival = festivalService.getFestivalById(id);
      model.addAttribute("festival", festival);
      return "festivals/details";
    } catch (RuntimeException e) {
      return "error/404";
    }
  }
}

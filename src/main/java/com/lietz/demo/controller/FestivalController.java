package com.lietz.demo.controller;

import com.lietz.demo.service.FestivalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/festivals")
@RequiredArgsConstructor
public class FestivalController {
  private final FestivalService festivalService;
}

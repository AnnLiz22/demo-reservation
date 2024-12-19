package com.lietz.demo.service;

import com.lietz.demo.model.Festival;
import com.lietz.demo.repository.FestivalRepository;
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

class FestivalServiceTest {
  @Mock
  private FestivalRepository festivalRepository;

  @InjectMocks
  private FestivalService festivalService;

  List<Festival> festivals = List.of(
      new Festival(1L, "fest", "festival", LocalDate.of(2024, 8, 5), LocalDate.of(2024,8,13), "Katowice"),
      new Festival(2L, "opener", "festival", LocalDate.of(2024, 7, 1), LocalDate.of(2024,7,6), "Gdynia"),
      new Festival(3L, "warsaw", "festival", LocalDate.of(2024, 9, 12), LocalDate.of(2024,9,15), "Warszawa")
  );

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }


  @Test
  void shouldFindAllFestivals() {
    Mockito.when(festivalRepository.findAll()).thenReturn(festivals);
    List<Festival> result = festivalService.findAllFestivals();
    Assertions.assertEquals("opener", result.get(1).getName());
    Assertions.assertEquals("Gdynia", result.get(1).getLocation());
    Assertions.assertEquals("warsaw", result.get(2).getName());
    Mockito.verify(festivalRepository, Mockito.times(1)).findAll();
  }

  @Test
  void shouldGetFestivalById() {
    Festival festival1 = festivals.get(0);
    Mockito.when(festivalRepository.findById(1L)).thenReturn(Optional.ofNullable(festival1));
    festivalService.getFestivalById(1L);

    Assertions.assertEquals("fest", festival1.getName());
    Mockito.verify(festivalRepository, Mockito.times(1)).findById(1L);

  }
}
package com.lietz.demo.service;

import com.lietz.demo.model.Festival;
import com.lietz.demo.repository.FestivalRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FestivalService {
  private final FestivalRepository festivalRepository;
  public FestivalService(FestivalRepository festivalRepository) {
    this.festivalRepository = festivalRepository;
  }

  public List<Festival> findAllFestivals(){
    return festivalRepository.findAll();
  }

  public Festival getFestivalById(Long id){
    return festivalRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("Festival not found"));
  }
}

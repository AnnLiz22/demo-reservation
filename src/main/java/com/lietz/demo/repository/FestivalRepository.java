package com.lietz.demo.repository;

import com.lietz.demo.model.Festival;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FestivalRepository extends JpaRepository <Festival, Long> {

}

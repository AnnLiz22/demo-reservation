package com.lietz.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "accommodations")
@AllArgsConstructor
@NoArgsConstructor
public class Accommodation {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String description;
  private double pricePerDay;
  private String location;

  @ManyToOne
  @JoinColumn(name = "festival_id")
  private Festival festival;

  @OneToMany(mappedBy = "accommodation")
  private List<Reservation> reservations;
}
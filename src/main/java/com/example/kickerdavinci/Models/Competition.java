package com.example.kickerdavinci.Models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Competitions")
public class Competition {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private long Id;

  @Column(name = "date", nullable = false, unique = true)
  private LocalDate date;

  @Column(name = "max_slots", nullable = false)
  private int maxSlots;

  @Column(name = "note")
  private String note;

  @OneToMany
  private List<Club> teams;
  @JsonManagedReference
  @OneToMany(mappedBy = "competition")
  private List<Game> gamesPlayed;

}
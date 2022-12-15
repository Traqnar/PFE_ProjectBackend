package com.example.kickerdavinci.Models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Game_Recaps")
public class GameRecap {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private long Id;

  @OneToOne
  @JoinColumn(name = "GAME_ID", unique = true, nullable = false)
  private Game game;

  @Column(name = "host_score", nullable = false)
  private int hostScore;
  @Column(name = "guest_score", nullable = false)
  private int guestScore;
  @JsonManagedReference
  @OneToMany(mappedBy = "gameRecap")
  private List<Set> sets;

}
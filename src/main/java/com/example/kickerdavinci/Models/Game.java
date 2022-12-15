package com.example.kickerdavinci.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Games")
public class Game {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private long Id;

  @OneToOne
  @JoinColumn(name = "CLUB_HOST_ID", nullable = false)
  private Club hostClub;

  @OneToOne
  @JoinColumn(name = "CLUB_GUEST_ID", nullable = false)
  private Club guestClub;

  @JsonBackReference
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "COMPETITION_ID")
  private Competition competition;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "CUP_ID")
  private Cup cup;

  @Column(name ="cup_position")
  private int cupPosition;
  @Column(name ="cup_date")
  private LocalDate cupDate;
}
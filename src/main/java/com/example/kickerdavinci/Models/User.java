package com.example.kickerdavinci.Models;

import java.time.LocalDate;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private long Id;
  @Column(name = "email", nullable = false)
  private String email;
  @Column(name = "password", nullable = false)
  private String password;
  @Column(name = "birth_date", nullable = false)
  private LocalDate birthDate;
  @Column(name = "firstname", nullable = false)
  private String firstname;
  @Column(name = "lastname", nullable = false)
  private String lastname;
  @Column(name = "ranking_points")
  private int rankingPoints;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "CLUB_ID", referencedColumnName = "ID")
  private Club club;

}
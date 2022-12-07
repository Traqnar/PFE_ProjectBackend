package com.example.kickerdavinci.Models;

import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class NoIdUser {

  private String pseudo;
  private String password;
  private LocalDate birthDate;
  private String firstname;
  private String lastname;
  private int rankingPoints;
  private int idClub;

  public User toUser() {
    return new User(0L, pseudo,password, birthDate, firstname, lastname, rankingPoints, idClub);
  }
}

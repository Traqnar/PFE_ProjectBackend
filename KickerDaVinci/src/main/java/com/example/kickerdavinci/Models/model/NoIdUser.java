package com.example.kickerdavinci.Models.model;

import com.example.kickerdavinci.Models.Club;
import com.example.kickerdavinci.Models.User;
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

  private String email;
  private String password;
  private LocalDate birthDate;
  private String firstname;
  private String lastname;
  private Club club;

  public User toUser() {
    return new User(0L, email, password, birthDate, firstname, lastname, 0, club);
  }
}

package com.example.kickerdavinci.Models.model;

import com.example.kickerdavinci.Models.Club;
import com.example.kickerdavinci.Models.Competition;
import com.example.kickerdavinci.Models.Cup;
import com.example.kickerdavinci.Models.Game;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class NoIdGame {

  private Club hostClub;

  private Club guestClub;

  private Competition competition;

  private Cup cup;

  public Game toGame() {
    return new Game(0L, hostClub, guestClub, competition, cup);
  }
}

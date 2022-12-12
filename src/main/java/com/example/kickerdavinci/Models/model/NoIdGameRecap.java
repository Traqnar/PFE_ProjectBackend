package com.example.kickerdavinci.Models.model;

import com.example.kickerdavinci.Models.Game;
import com.example.kickerdavinci.Models.GameRecap;
import com.example.kickerdavinci.Models.Set;
import java.util.ArrayList;

public class NoIdGameRecap {

  private Game game;

  private int hostScore;
  private int guestScore;


  public GameRecap toGameRecap() {
    return new GameRecap(0L, game, hostScore, guestScore, new ArrayList<Set>());
  }
}

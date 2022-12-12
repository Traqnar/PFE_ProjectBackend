package com.example.kickerdavinci.Models.model;

import com.example.kickerdavinci.Models.GameRecap;
import com.example.kickerdavinci.Models.Set;
import com.example.kickerdavinci.Models.User;


public class NoIdSet {

  private GameRecap gameRecap;

  private int num;

  private User hostPlayer1;

  private User hostPlayer2;

  private User guestPlayer1;

  private User guestPlayer2;

  private User hostReserve1;

  private User hostReserve2;

  private User guestReserve1;

  private User guestReserve2;

  public Set toSet() {
    return new Set(0L, gameRecap, num, hostPlayer1, hostPlayer2, guestPlayer1, guestPlayer2,
        hostReserve1, hostReserve2, guestReserve1, guestReserve2);
  }
}

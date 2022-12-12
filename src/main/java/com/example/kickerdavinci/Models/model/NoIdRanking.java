package com.example.kickerdavinci.Models.model;

import com.example.kickerdavinci.Models.Ranking;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class NoIdRanking {

  private String name;

  private int minPoints;

  private int maxPoints;

  public Ranking toRanking() {
    return new Ranking(0L, name, minPoints, maxPoints);
  }
}

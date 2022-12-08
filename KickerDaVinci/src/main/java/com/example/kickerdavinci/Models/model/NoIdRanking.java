package com.example.kickerdavinci.Models.model;

import com.example.kickerdavinci.Models.Ranking;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
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

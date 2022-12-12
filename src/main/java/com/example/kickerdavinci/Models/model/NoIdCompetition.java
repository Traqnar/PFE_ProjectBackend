package com.example.kickerdavinci.Models.model;


import com.example.kickerdavinci.Models.Club;
import com.example.kickerdavinci.Models.Competition;
import com.example.kickerdavinci.Models.Game;
import java.time.LocalDate;
import java.util.ArrayList;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class NoIdCompetition {

  private LocalDate date;

  private int maxSlots;

  private String note;

  public Competition toCompetition() {
    return new Competition(0L, date, maxSlots, note,new ArrayList<Club>(),new ArrayList<Game>());
  }
}

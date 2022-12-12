package com.example.kickerdavinci.Models.model;


import com.example.kickerdavinci.Models.Club;
import com.example.kickerdavinci.Models.Cup;
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

public class NoIdCup {

  private String name;
  private LocalDate startDate;
  private LocalDate endDate;

  public Cup toCup(){
    return new Cup(0L, name, startDate, endDate, new ArrayList<Club>(), new ArrayList<Game>());
  }
}

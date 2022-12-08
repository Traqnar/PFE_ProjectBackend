package com.example.kickerdavinci.Models.model;


import com.example.kickerdavinci.Models.Competition;
import java.time.LocalDate;
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
public class NoIdCompetition {

  private LocalDate date;

  private int maxSlots;

  private String note;

  public Competition toCompetition() {
    return new Competition(0L, date, maxSlots, note);
  }
}

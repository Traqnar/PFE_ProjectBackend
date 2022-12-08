package com.example.kickerdavinci.Models.model;


import com.example.kickerdavinci.Models.Cup;
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

public class NoIdCup {

  private String name;
  private LocalDate startDate;
  private LocalDate endDate;

  public Cup toCup(){
    return new Cup(0L, name, startDate, endDate);
  }
}
